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
    private View ehb;
    private View ehc;
    private EditText ehd;
    private ImageButton ehe;
    private View ehf;
    private View ehg;
    private AddGroupActivity ehh;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.ehb = null;
        this.bfy = null;
        this.ehc = null;
        this.ehd = null;
        this.ehe = null;
        this.progressBar = null;
        this.ehf = null;
        this.ehh = null;
        this.ehh = addGroupActivity;
        initUI();
    }

    public View aCk() {
        return this.ehe;
    }

    public View aGN() {
        return this.ehf;
    }

    public View aGO() {
        return this.ehc;
    }

    public View aGP() {
        return this.ehg;
    }

    public void aGQ() {
        if (this.ehd != null) {
            this.ehd.setText("");
        }
    }

    public void hg(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.ehh.getLayoutMode().setNightMode(i == 1);
        this.ehh.getLayoutMode().u(this.ehb);
        this.bfy.onChangeSkinType(this.ehh.getPageContext(), i);
    }

    private void initUI() {
        this.ehh.setContentView(d.i.im_add_group_activity);
        this.ehb = this.ehh.findViewById(d.g.addgroup_rootlayout);
        this.bfy = (NavigationBar) this.ehh.findViewById(d.g.addgroup_navigationbar);
        this.ehc = this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bfy.setTitleText(this.ehh.getResources().getString(d.k.add_group_title_main));
        this.ehd = (EditText) this.ehh.findViewById(d.g.addgroup_input);
        this.ehd.setInputType(2);
        this.ehe = (ImageButton) this.ehh.findViewById(d.g.addgroup_delbtn);
        this.ehf = this.ehh.findViewById(d.g.addgroup_searchbutton);
        this.ehg = this.ehh.findViewById(d.g.addgroup_vcode);
        this.ehd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.ehd.length() > 0) {
                    a.this.ehe.setVisibility(0);
                } else {
                    a.this.ehe.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.ehf.setTag(editable.toString().trim());
            }
        });
        this.ehf = this.ehh.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.ehh.findViewById(d.g.addgroup_progress);
        this.ehc.setOnClickListener(this.ehh);
        this.ehe.setOnClickListener(this.ehh);
        this.ehf.setOnClickListener(this.ehh);
        this.ehg.setOnClickListener(this.ehh);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.ehg.setVisibility(8);
        }
    }
}
