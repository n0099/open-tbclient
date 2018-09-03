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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar bpP;
    private View eBd;
    private View eBe;
    private EditText eBf;
    private ImageButton eBg;
    private View eBh;
    private View eBi;
    private AddGroupActivity eBj;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eBd = null;
        this.bpP = null;
        this.eBe = null;
        this.eBf = null;
        this.eBg = null;
        this.progressBar = null;
        this.eBh = null;
        this.eBj = null;
        this.eBj = addGroupActivity;
        initUI();
    }

    public View aIH() {
        return this.eBg;
    }

    public View aNj() {
        return this.eBh;
    }

    public View aNk() {
        return this.eBe;
    }

    public View aNl() {
        return this.eBi;
    }

    public void aNm() {
        if (this.eBf != null) {
            this.eBf.setText("");
        }
    }

    public void hA(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eBj.getLayoutMode().setNightMode(i == 1);
        this.eBj.getLayoutMode().onModeChanged(this.eBd);
        this.bpP.onChangeSkinType(this.eBj.getPageContext(), i);
    }

    private void initUI() {
        this.eBj.setContentView(f.h.im_add_group_activity);
        this.eBd = this.eBj.findViewById(f.g.addgroup_rootlayout);
        this.bpP = (NavigationBar) this.eBj.findViewById(f.g.addgroup_navigationbar);
        this.eBe = this.bpP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bpP.setTitleText(this.eBj.getResources().getString(f.j.add_group_title_main));
        this.eBf = (EditText) this.eBj.findViewById(f.g.addgroup_input);
        this.eBf.setInputType(2);
        this.eBg = (ImageButton) this.eBj.findViewById(f.g.addgroup_delbtn);
        this.eBh = this.eBj.findViewById(f.g.addgroup_searchbutton);
        this.eBi = this.eBj.findViewById(f.g.addgroup_vcode);
        this.eBf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eBf.length() > 0) {
                    a.this.eBg.setVisibility(0);
                } else {
                    a.this.eBg.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eBh.setTag(editable.toString().trim());
            }
        });
        this.eBh = this.eBj.findViewById(f.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eBj.findViewById(f.g.addgroup_progress);
        this.eBe.setOnClickListener(this.eBj);
        this.eBg.setOnClickListener(this.eBj);
        this.eBh.setOnClickListener(this.eBj);
        this.eBi.setOnClickListener(this.eBj);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eBi.setVisibility(8);
        }
    }
}
