package com.baidu.tieba.im.searchGroup;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.adp.base.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class b extends g<AddGroupActivity> {
    private ProgressBar aWP;
    private NavigationBar aeV;
    private View bnJ;
    private EditText bnK;
    private ImageButton bnL;
    private View bnM;
    private View bnN;
    private AddGroupActivity bnO;
    private View jh;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.bnJ = null;
        this.aeV = null;
        this.jh = null;
        this.bnK = null;
        this.bnL = null;
        this.aWP = null;
        this.bnM = null;
        this.bnO = null;
        this.bnO = addGroupActivity;
        initUI();
    }

    public View LZ() {
        return this.bnL;
    }

    public View Td() {
        return this.bnM;
    }

    public View SO() {
        return this.jh;
    }

    public View Te() {
        return this.bnN;
    }

    public void Tf() {
        if (this.bnK != null) {
            this.bnK.setText("");
        }
    }

    public void cW(boolean z) {
        this.aWP.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.bnO.getLayoutMode().ab(i == 1);
        this.bnO.getLayoutMode().h(this.bnJ);
        this.aeV.onChangeSkinType(this.bnO.getPageContext(), i);
    }

    private void initUI() {
        this.bnO.setContentView(x.im_add_group_activity);
        this.bnJ = this.bnO.findViewById(w.addgroup_rootlayout);
        this.aeV = (NavigationBar) this.bnO.findViewById(w.addgroup_navigationbar);
        this.jh = this.aeV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aeV.setTitleText(this.bnO.getResources().getString(z.add_group_title_main));
        this.bnK = (EditText) this.bnO.findViewById(w.addgroup_input);
        this.bnK.setInputType(2);
        this.bnL = (ImageButton) this.bnO.findViewById(w.addgroup_delbtn);
        this.bnM = this.bnO.findViewById(w.addgroup_searchbutton);
        this.bnN = this.bnO.findViewById(w.addgroup_vcode);
        this.bnK.addTextChangedListener(new c(this));
        this.bnM = this.bnO.findViewById(w.addgroup_searchbutton);
        this.aWP = (ProgressBar) this.bnO.findViewById(w.addgroup_progress);
        this.jh.setOnClickListener(this.bnO);
        this.bnL.setOnClickListener(this.bnO);
        this.bnM.setOnClickListener(this.bnO);
        this.bnN.setOnClickListener(this.bnO);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2902030)) {
            this.bnN.setVisibility(8);
        }
    }
}
