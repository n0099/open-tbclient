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
    private ProgressBar aVw;
    private NavigationBar aey;
    private View bmm;
    private EditText bmn;
    private ImageButton bmo;
    private View bmp;
    private View bmq;
    private AddGroupActivity bmr;
    private View jf;

    public b(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        this.bmm = null;
        this.aey = null;
        this.jf = null;
        this.bmn = null;
        this.bmo = null;
        this.aVw = null;
        this.bmp = null;
        this.bmr = null;
        this.bmr = addGroupActivity;
        initUI();
    }

    public View LE() {
        return this.bmo;
    }

    public View SH() {
        return this.bmp;
    }

    public View Ss() {
        return this.jf;
    }

    public View SI() {
        return this.bmq;
    }

    public void SJ() {
        if (this.bmn != null) {
            this.bmn.setText("");
        }
    }

    public void cR(boolean z) {
        this.aVw.setVisibility(z ? 0 : 8);
    }

    public void changeSkinType(int i) {
        this.bmr.getLayoutMode().ab(i == 1);
        this.bmr.getLayoutMode().h(this.bmm);
        this.aey.onChangeSkinType(this.bmr.getPageContext(), i);
    }

    private void initUI() {
        this.bmr.setContentView(x.im_add_group_activity);
        this.bmm = this.bmr.findViewById(w.addgroup_rootlayout);
        this.aey = (NavigationBar) this.bmr.findViewById(w.addgroup_navigationbar);
        this.jf = this.aey.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aey.setTitleText(this.bmr.getResources().getString(z.add_group_title_main));
        this.bmn = (EditText) this.bmr.findViewById(w.addgroup_input);
        this.bmn.setInputType(2);
        this.bmo = (ImageButton) this.bmr.findViewById(w.addgroup_delbtn);
        this.bmp = this.bmr.findViewById(w.addgroup_searchbutton);
        this.bmq = this.bmr.findViewById(w.addgroup_vcode);
        this.bmn.addTextChangedListener(new c(this));
        this.bmp = this.bmr.findViewById(w.addgroup_searchbutton);
        this.aVw = (ProgressBar) this.bmr.findViewById(w.addgroup_progress);
        this.jf.setOnClickListener(this.bmr);
        this.bmo.setOnClickListener(this.bmr);
        this.bmp.setOnClickListener(this.bmr);
        this.bmq.setOnClickListener(this.bmr);
        if (!TbadkCoreApplication.m255getInst().appResponseToCmd(2902030)) {
            this.bmq.setVisibility(8);
        }
    }
}
