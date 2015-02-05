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
    private ProgressBar aWO;
    private NavigationBar aeS;
    private View bnI;
    private EditText bnJ;
    private ImageButton bnK;
    private View bnL;
    private View bnM;
    private AddGroupActivity bnN;
    private View jh;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.bnI = null;
        this.aeS = null;
        this.jh = null;
        this.bnJ = null;
        this.bnK = null;
        this.aWO = null;
        this.bnL = null;
        this.bnN = null;
        this.bnN = addGroupActivity;
        initUI();
    }

    public View LU() {
        return this.bnK;
    }

    public View SY() {
        return this.bnL;
    }

    public View SJ() {
        return this.jh;
    }

    public View SZ() {
        return this.bnM;
    }

    public void Ta() {
        if (this.bnJ != null) {
            this.bnJ.setText("");
        }
    }

    public void cW(boolean z) {
        this.aWO.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.bnN.getLayoutMode().ab(i == 1);
        this.bnN.getLayoutMode().h(this.bnI);
        this.aeS.onChangeSkinType(this.bnN.getPageContext(), i);
    }

    private void initUI() {
        this.bnN.setContentView(x.im_add_group_activity);
        this.bnI = this.bnN.findViewById(w.addgroup_rootlayout);
        this.aeS = (NavigationBar) this.bnN.findViewById(w.addgroup_navigationbar);
        this.jh = this.aeS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aeS.setTitleText(this.bnN.getResources().getString(z.add_group_title_main));
        this.bnJ = (EditText) this.bnN.findViewById(w.addgroup_input);
        this.bnJ.setInputType(2);
        this.bnK = (ImageButton) this.bnN.findViewById(w.addgroup_delbtn);
        this.bnL = this.bnN.findViewById(w.addgroup_searchbutton);
        this.bnM = this.bnN.findViewById(w.addgroup_vcode);
        this.bnJ.addTextChangedListener(new c(this));
        this.bnL = this.bnN.findViewById(w.addgroup_searchbutton);
        this.aWO = (ProgressBar) this.bnN.findViewById(w.addgroup_progress);
        this.jh.setOnClickListener(this.bnN);
        this.bnK.setOnClickListener(this.bnN);
        this.bnL.setOnClickListener(this.bnN);
        this.bnM.setOnClickListener(this.bnN);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2902030)) {
            this.bnM.setVisibility(8);
        }
    }
}
