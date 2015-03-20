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
    private NavigationBar anm;
    private ProgressBar baW;
    private View bmm;
    private EditText bmn;
    private ImageButton bmo;
    private View bmp;
    private View bmq;
    private AddGroupActivity bmr;
    private View uy;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.bmm = null;
        this.anm = null;
        this.uy = null;
        this.bmn = null;
        this.bmo = null;
        this.baW = null;
        this.bmp = null;
        this.bmr = null;
        this.bmr = addGroupActivity;
        initUI();
    }

    public View OT() {
        return this.bmo;
    }

    public View Tg() {
        return this.bmp;
    }

    public View Th() {
        return this.uy;
    }

    public View Ti() {
        return this.bmq;
    }

    public void Tj() {
        if (this.bmn != null) {
            this.bmn.setText("");
        }
    }

    public void cK(boolean z) {
        this.baW.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.bmr.getLayoutMode().X(i == 1);
        this.bmr.getLayoutMode().h(this.bmm);
        this.anm.onChangeSkinType(this.bmr.getPageContext(), i);
    }

    private void initUI() {
        this.bmr.setContentView(w.im_add_group_activity);
        this.bmm = this.bmr.findViewById(v.addgroup_rootlayout);
        this.anm = (NavigationBar) this.bmr.findViewById(v.addgroup_navigationbar);
        this.uy = this.anm.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.anm.setTitleText(this.bmr.getResources().getString(y.add_group_title_main));
        this.bmn = (EditText) this.bmr.findViewById(v.addgroup_input);
        this.bmn.setInputType(2);
        this.bmo = (ImageButton) this.bmr.findViewById(v.addgroup_delbtn);
        this.bmp = this.bmr.findViewById(v.addgroup_searchbutton);
        this.bmq = this.bmr.findViewById(v.addgroup_vcode);
        this.bmn.addTextChangedListener(new c(this));
        this.bmp = this.bmr.findViewById(v.addgroup_searchbutton);
        this.baW = (ProgressBar) this.bmr.findViewById(v.addgroup_progress);
        this.uy.setOnClickListener(this.bmr);
        this.bmo.setOnClickListener(this.bmr);
        this.bmp.setOnClickListener(this.bmr);
        this.bmq.setOnClickListener(this.bmr);
        if (!TbadkCoreApplication.m411getInst().appResponseToCmd(2902030)) {
            this.bmq.setVisibility(8);
        }
    }
}
