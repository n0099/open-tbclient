package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar bfy;
    private View ehe;
    private View ehf;
    private EditText ehg;
    private ImageButton ehh;
    private View ehi;
    private View ehj;
    private AddGroupActivity ehk;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.ehe = null;
        this.bfy = null;
        this.ehf = null;
        this.ehg = null;
        this.ehh = null;
        this.progressBar = null;
        this.ehi = null;
        this.ehk = null;
        this.ehk = addGroupActivity;
        initUI();
    }

    public View aCk() {
        return this.ehh;
    }

    public View aGN() {
        return this.ehi;
    }

    public View aGO() {
        return this.ehf;
    }

    public View aGP() {
        return this.ehj;
    }

    public void aGQ() {
        if (this.ehg != null) {
            this.ehg.setText("");
        }
    }

    public void hg(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.ehk.getLayoutMode().setNightMode(i == 1);
        this.ehk.getLayoutMode().u(this.ehe);
        this.bfy.onChangeSkinType(this.ehk.getPageContext(), i);
    }

    private void initUI() {
        this.ehk.setContentView(d.i.im_add_group_activity);
        this.ehe = this.ehk.findViewById(d.g.addgroup_rootlayout);
        this.bfy = (NavigationBar) this.ehk.findViewById(d.g.addgroup_navigationbar);
        this.ehf = this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bfy.setTitleText(this.ehk.getResources().getString(d.k.add_group_title_main));
        this.ehg = (EditText) this.ehk.findViewById(d.g.addgroup_input);
        this.ehg.setInputType(2);
        this.ehh = (ImageButton) this.ehk.findViewById(d.g.addgroup_delbtn);
        this.ehi = this.ehk.findViewById(d.g.addgroup_searchbutton);
        this.ehj = this.ehk.findViewById(d.g.addgroup_vcode);
        this.ehg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.ehg.length() > 0) {
                    a.this.ehh.setVisibility(0);
                } else {
                    a.this.ehh.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.ehi.setTag(editable.toString().trim());
            }
        });
        this.ehi = this.ehk.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.ehk.findViewById(d.g.addgroup_progress);
        this.ehf.setOnClickListener(this.ehk);
        this.ehh.setOnClickListener(this.ehk);
        this.ehi.setOnClickListener(this.ehk);
        this.ehj.setOnClickListener(this.ehk);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.ehj.setVisibility(8);
        }
    }
}
