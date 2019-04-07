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
    private NavigationBar cPM;
    private View grJ;
    private View grK;
    private EditText grL;
    private ImageButton grM;
    private View grN;
    private View grO;
    private AddGroupActivity grP;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.grJ = null;
        this.cPM = null;
        this.grK = null;
        this.grL = null;
        this.grM = null;
        this.progressBar = null;
        this.grN = null;
        this.grP = null;
        this.grP = addGroupActivity;
        initUI();
    }

    public View brp() {
        return this.grM;
    }

    public View bvQ() {
        return this.grN;
    }

    public View bvR() {
        return this.grK;
    }

    public View bvS() {
        return this.grO;
    }

    public void bvT() {
        if (this.grL != null) {
            this.grL.setText("");
        }
    }

    public void lf(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.grP.getLayoutMode().setNightMode(i == 1);
        this.grP.getLayoutMode().onModeChanged(this.grJ);
        this.cPM.onChangeSkinType(this.grP.getPageContext(), i);
    }

    private void initUI() {
        this.grP.setContentView(d.h.im_add_group_activity);
        this.grJ = this.grP.findViewById(d.g.addgroup_rootlayout);
        this.cPM = (NavigationBar) this.grP.findViewById(d.g.addgroup_navigationbar);
        this.grK = this.cPM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cPM.setTitleText(this.grP.getResources().getString(d.j.add_group_title_main));
        this.grL = (EditText) this.grP.findViewById(d.g.addgroup_input);
        this.grL.setInputType(2);
        this.grM = (ImageButton) this.grP.findViewById(d.g.addgroup_delbtn);
        this.grN = this.grP.findViewById(d.g.addgroup_searchbutton);
        this.grO = this.grP.findViewById(d.g.addgroup_vcode);
        this.grL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.grL.length() > 0) {
                    a.this.grM.setVisibility(0);
                } else {
                    a.this.grM.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.grN.setTag(editable.toString().trim());
            }
        });
        this.grN = this.grP.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.grP.findViewById(d.g.addgroup_progress);
        this.grK.setOnClickListener(this.grP);
        this.grM.setOnClickListener(this.grP);
        this.grN.setOnClickListener(this.grP);
        this.grO.setOnClickListener(this.grP);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.grO.setVisibility(8);
        }
    }
}
