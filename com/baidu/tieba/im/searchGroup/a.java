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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class a extends c<AddGroupActivity> {
    private NavigationBar bAs;
    private View eRA;
    private View eRB;
    private AddGroupActivity eRC;
    private View eRw;
    private View eRx;
    private EditText eRy;
    private ImageButton eRz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.eRw = null;
        this.bAs = null;
        this.eRx = null;
        this.eRy = null;
        this.eRz = null;
        this.progressBar = null;
        this.eRA = null;
        this.eRC = null;
        this.eRC = addGroupActivity;
        initUI();
    }

    public View aNI() {
        return this.eRz;
    }

    public View aSj() {
        return this.eRA;
    }

    public View aSk() {
        return this.eRx;
    }

    public View aSl() {
        return this.eRB;
    }

    public void aSm() {
        if (this.eRy != null) {
            this.eRy.setText("");
        }
    }

    public void iz(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.eRC.getLayoutMode().setNightMode(i == 1);
        this.eRC.getLayoutMode().onModeChanged(this.eRw);
        this.bAs.onChangeSkinType(this.eRC.getPageContext(), i);
    }

    private void initUI() {
        this.eRC.setContentView(e.h.im_add_group_activity);
        this.eRw = this.eRC.findViewById(e.g.addgroup_rootlayout);
        this.bAs = (NavigationBar) this.eRC.findViewById(e.g.addgroup_navigationbar);
        this.eRx = this.bAs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bAs.setTitleText(this.eRC.getResources().getString(e.j.add_group_title_main));
        this.eRy = (EditText) this.eRC.findViewById(e.g.addgroup_input);
        this.eRy.setInputType(2);
        this.eRz = (ImageButton) this.eRC.findViewById(e.g.addgroup_delbtn);
        this.eRA = this.eRC.findViewById(e.g.addgroup_searchbutton);
        this.eRB = this.eRC.findViewById(e.g.addgroup_vcode);
        this.eRy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.eRy.length() > 0) {
                    a.this.eRz.setVisibility(0);
                } else {
                    a.this.eRz.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.eRA.setTag(editable.toString().trim());
            }
        });
        this.eRA = this.eRC.findViewById(e.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.eRC.findViewById(e.g.addgroup_progress);
        this.eRx.setOnClickListener(this.eRC);
        this.eRz.setOnClickListener(this.eRC);
        this.eRA.setOnClickListener(this.eRC);
        this.eRB.setOnClickListener(this.eRC);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.eRB.setVisibility(8);
        }
    }
}
