package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class b extends g<AddGroupActivity> {
    private NavigationBar anu;
    private ProgressBar bbm;
    private View bmC;
    private EditText bmD;
    private ImageButton bmE;
    private View bmF;
    private View bmG;
    private AddGroupActivity bmH;
    private View uy;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.bmC = null;
        this.anu = null;
        this.uy = null;
        this.bmD = null;
        this.bmE = null;
        this.bbm = null;
        this.bmF = null;
        this.bmH = null;
        this.bmH = addGroupActivity;
        initUI();
    }

    public View Pg() {
        return this.bmE;
    }

    public View Tt() {
        return this.bmF;
    }

    public View Tu() {
        return this.uy;
    }

    public View Tv() {
        return this.bmG;
    }

    public void Tw() {
        if (this.bmD != null) {
            this.bmD.setText("");
        }
    }

    public void cI(boolean z) {
        this.bbm.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.bmH.getLayoutMode().X(i == 1);
        this.bmH.getLayoutMode().h(this.bmC);
        this.anu.onChangeSkinType(this.bmH.getPageContext(), i);
    }

    private void initUI() {
        this.bmH.setContentView(w.im_add_group_activity);
        this.bmC = this.bmH.findViewById(v.addgroup_rootlayout);
        this.anu = (NavigationBar) this.bmH.findViewById(v.addgroup_navigationbar);
        this.uy = this.anu.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.anu.setTitleText(this.bmH.getResources().getString(y.add_group_title_main));
        this.bmD = (EditText) this.bmH.findViewById(v.addgroup_input);
        this.bmD.setInputType(2);
        this.bmE = (ImageButton) this.bmH.findViewById(v.addgroup_delbtn);
        this.bmF = this.bmH.findViewById(v.addgroup_searchbutton);
        this.bmG = this.bmH.findViewById(v.addgroup_vcode);
        this.bmD.addTextChangedListener(new c(this));
        this.bmF = this.bmH.findViewById(v.addgroup_searchbutton);
        this.bbm = (ProgressBar) this.bmH.findViewById(v.addgroup_progress);
        this.uy.setOnClickListener(this.bmH);
        this.bmE.setOnClickListener(this.bmH);
        this.bmF.setOnClickListener(this.bmH);
        this.bmG.setOnClickListener(this.bmH);
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(2902030)) {
            this.bmG.setVisibility(8);
        }
    }
}
