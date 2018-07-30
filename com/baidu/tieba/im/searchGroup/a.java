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
    private NavigationBar bpN;
    private View eBh;
    private View eBi;
    private EditText eBj;
    private ImageButton eBk;
    private View eBl;
    private View eBm;
    private AddGroupActivity eBn;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eBh = null;
        this.bpN = null;
        this.eBi = null;
        this.eBj = null;
        this.eBk = null;
        this.progressBar = null;
        this.eBl = null;
        this.eBn = null;
        this.eBn = addGroupActivity;
        initUI();
    }

    public View aIK() {
        return this.eBk;
    }

    public View aNm() {
        return this.eBl;
    }

    public View aNn() {
        return this.eBi;
    }

    public View aNo() {
        return this.eBm;
    }

    public void aNp() {
        if (this.eBj != null) {
            this.eBj.setText("");
        }
    }

    public void hA(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eBn.getLayoutMode().setNightMode(i == 1);
        this.eBn.getLayoutMode().onModeChanged(this.eBh);
        this.bpN.onChangeSkinType(this.eBn.getPageContext(), i);
    }

    private void initUI() {
        this.eBn.setContentView(d.h.im_add_group_activity);
        this.eBh = this.eBn.findViewById(d.g.addgroup_rootlayout);
        this.bpN = (NavigationBar) this.eBn.findViewById(d.g.addgroup_navigationbar);
        this.eBi = this.bpN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bpN.setTitleText(this.eBn.getResources().getString(d.j.add_group_title_main));
        this.eBj = (EditText) this.eBn.findViewById(d.g.addgroup_input);
        this.eBj.setInputType(2);
        this.eBk = (ImageButton) this.eBn.findViewById(d.g.addgroup_delbtn);
        this.eBl = this.eBn.findViewById(d.g.addgroup_searchbutton);
        this.eBm = this.eBn.findViewById(d.g.addgroup_vcode);
        this.eBj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eBj.length() > 0) {
                    a.this.eBk.setVisibility(0);
                } else {
                    a.this.eBk.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eBl.setTag(editable.toString().trim());
            }
        });
        this.eBl = this.eBn.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eBn.findViewById(d.g.addgroup_progress);
        this.eBi.setOnClickListener(this.eBn);
        this.eBk.setOnClickListener(this.eBn);
        this.eBl.setOnClickListener(this.eBn);
        this.eBm.setOnClickListener(this.eBn);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eBm.setVisibility(8);
        }
    }
}
