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
    private NavigationBar cPN;
    private View grK;
    private View grL;
    private EditText grM;
    private ImageButton grN;
    private View grO;
    private View grP;
    private AddGroupActivity grQ;
    private ProgressBar progressBar;

    public a(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.grK = null;
        this.cPN = null;
        this.grL = null;
        this.grM = null;
        this.grN = null;
        this.progressBar = null;
        this.grO = null;
        this.grQ = null;
        this.grQ = addGroupActivity;
        initUI();
    }

    public View brp() {
        return this.grN;
    }

    public View bvQ() {
        return this.grO;
    }

    public View bvR() {
        return this.grL;
    }

    public View bvS() {
        return this.grP;
    }

    public void bvT() {
        if (this.grM != null) {
            this.grM.setText("");
        }
    }

    public void lf(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.grQ.getLayoutMode().setNightMode(i == 1);
        this.grQ.getLayoutMode().onModeChanged(this.grK);
        this.cPN.onChangeSkinType(this.grQ.getPageContext(), i);
    }

    private void initUI() {
        this.grQ.setContentView(d.h.im_add_group_activity);
        this.grK = this.grQ.findViewById(d.g.addgroup_rootlayout);
        this.cPN = (NavigationBar) this.grQ.findViewById(d.g.addgroup_navigationbar);
        this.grL = this.cPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cPN.setTitleText(this.grQ.getResources().getString(d.j.add_group_title_main));
        this.grM = (EditText) this.grQ.findViewById(d.g.addgroup_input);
        this.grM.setInputType(2);
        this.grN = (ImageButton) this.grQ.findViewById(d.g.addgroup_delbtn);
        this.grO = this.grQ.findViewById(d.g.addgroup_searchbutton);
        this.grP = this.grQ.findViewById(d.g.addgroup_vcode);
        this.grM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.im.searchGroup.a.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (a.this.grM.length() > 0) {
                    a.this.grN.setVisibility(0);
                } else {
                    a.this.grN.setVisibility(8);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                a.this.grO.setTag(editable.toString().trim());
            }
        });
        this.grO = this.grQ.findViewById(d.g.addgroup_searchbutton);
        this.progressBar = (ProgressBar) this.grQ.findViewById(d.g.addgroup_progress);
        this.grL.setOnClickListener(this.grQ);
        this.grN.setOnClickListener(this.grQ);
        this.grO.setOnClickListener(this.grQ);
        this.grP.setOnClickListener(this.grQ);
        if (!TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
            this.grP.setVisibility(8);
        }
    }
}
