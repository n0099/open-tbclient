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
    private NavigationBar bnG;
    private View etA;
    private EditText etB;
    private ImageButton etC;
    private View etD;
    private View etE;
    private AddGroupActivity etF;
    private View etz;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.etz = null;
        this.bnG = null;
        this.etA = null;
        this.etB = null;
        this.etC = null;
        this.progressBar = null;
        this.etD = null;
        this.etF = null;
        this.etF = addGroupActivity;
        initUI();
    }

    public View aHd() {
        return this.etC;
    }

    public View aLG() {
        return this.etD;
    }

    public View aLH() {
        return this.etA;
    }

    public View aLI() {
        return this.etE;
    }

    public void aLJ() {
        if (this.etB != null) {
            this.etB.setText("");
        }
    }

    public void hn(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.etF.getLayoutMode().setNightMode(i == 1);
        this.etF.getLayoutMode().onModeChanged(this.etz);
        this.bnG.onChangeSkinType(this.etF.getPageContext(), i);
    }

    private void initUI() {
        this.etF.setContentView(d.i.im_add_group_activity);
        this.etz = this.etF.findViewById(d.g.addgroup_rootlayout);
        this.bnG = (NavigationBar) this.etF.findViewById(d.g.addgroup_navigationbar);
        this.etA = this.bnG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bnG.setTitleText(this.etF.getResources().getString(d.k.add_group_title_main));
        this.etB = (EditText) this.etF.findViewById(d.g.addgroup_input);
        this.etB.setInputType(2);
        this.etC = (ImageButton) this.etF.findViewById(d.g.addgroup_delbtn);
        this.etD = this.etF.findViewById(d.g.addgroup_searchbutton);
        this.etE = this.etF.findViewById(d.g.addgroup_vcode);
        this.etB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.etB.length() > 0) {
                    a.this.etC.setVisibility(0);
                } else {
                    a.this.etC.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.etD.setTag(editable.toString().trim());
            }
        });
        this.etD = this.etF.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.etF.findViewById(d.g.addgroup_progress);
        this.etA.setOnClickListener(this.etF);
        this.etC.setOnClickListener(this.etF);
        this.etD.setOnClickListener(this.etF);
        this.etE.setOnClickListener(this.etF);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.etE.setVisibility(8);
        }
    }
}
