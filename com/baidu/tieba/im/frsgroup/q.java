package com.baidu.tieba.im.frsgroup;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NavigationBar;
/* loaded from: classes.dex */
public class q extends com.baidu.adp.base.f {
    private View aOT;
    private GroupLevelActivity aXC;
    private ImageView aXD;
    private ImageView aXE;
    private ImageView aXF;
    private TextView aXG;
    private TextView aXH;
    private ViewGroup aXI;
    private TextView aXJ;
    private ProgressBar aXK;
    private TextView aXL;
    private TextView aXM;
    private TextView aXN;
    private TextView aXO;
    private TextView aXP;
    private TextView aXQ;
    private ImageView[] aXR;
    private TextView[] aXS;
    private TextView[] aXT;
    private String[] aXU;
    private Button aXV;
    private TextView aXW;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public q(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity);
        this.aXR = new ImageView[4];
        this.aXS = new TextView[4];
        this.aXT = new TextView[4];
        this.aXU = new String[4];
        this.mNavigationBar = null;
        this.aXC = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(com.baidu.tieba.w.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.aOT.setOnClickListener(this.aXC);
        this.aXV.setOnClickListener(this.aXC);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(com.baidu.tieba.v.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.v.progress_loading);
        this.aXD = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_1);
        this.aXE = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_2);
        this.aXF = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_3);
        this.aXG = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.text_current_level);
        this.aXH = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.current_level);
        this.aXI = (ViewGroup) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_active);
        this.aXJ = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_highest);
        this.aXK = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.v.active_progress);
        this.aXL = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_day_cur);
        this.aXM = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_day_total);
        this.aXN = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_condition);
        this.aXO = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max1);
        this.aXP = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max2);
        this.aXQ = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max3);
        this.aXT[1] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max1);
        this.aXT[2] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max2);
        this.aXT[3] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max3);
        this.aXR[1] = this.aXD;
        this.aXR[2] = this.aXE;
        this.aXR[3] = this.aXF;
        this.aXU[1] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_1);
        this.aXU[2] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_2);
        this.aXU[3] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_3);
        this.aXS[1] = this.aXO;
        this.aXS[2] = this.aXP;
        this.aXS[3] = this.aXQ;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.aXC.getResources().getString(com.baidu.tieba.y.grouplevel_title));
        this.aOT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aXV = (Button) groupLevelActivity.findViewById(com.baidu.tieba.v.upgrade_mem_group_btn);
        this.aXW = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.upgrade_mem_group_tip);
        if (this.isMem) {
            this.aXV.setVisibility(8);
            this.aXW.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.aXG.setText(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.grouplevel_vip_current_level));
            aw.b(this.aXG, com.baidu.tieba.s.group_level_promote, 1);
        } else {
            this.aXG.setText(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.grouplevel_current_level));
            aw.b(this.aXG, com.baidu.tieba.s.group_level_secondtitle_text, 1);
        }
        if (z || !z2) {
            this.aXV.setVisibility(8);
            this.aXW.setVisibility(8);
            return;
        }
        this.aXV.setVisibility(0);
        this.aXW.setVisibility(0);
        if (z3 && i > 0) {
            this.aXV.setEnabled(true);
            string = String.format(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.upgrade_mem_group_left_num), String.valueOf(i));
            aw.b(this.aXV, com.baidu.tieba.s.upgrade_mem_group_btn_text, 3);
            this.aXV.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.upgrade_mem_group_over_max_num);
            }
            this.aXV.setEnabled(false);
            aw.b(this.aXV, com.baidu.tieba.s.upgrade_mem_group_btn_cannotup_text, 3);
        }
        this.aXW.setText(string);
    }

    public View NA() {
        return this.aOT;
    }

    public Button NB() {
        return this.aXV;
    }

    public void onChangeSkinType(int i) {
        this.aXC.getLayoutMode().L(i == 1);
        this.aXC.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public TextView[] NC() {
        return this.aXS;
    }

    public TextView[] ND() {
        return this.aXT;
    }

    public void cX(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void r(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = com.baidu.tieba.u.icon_grade_big_star_s;
        int i4 = com.baidu.tieba.u.icon_grade_big_star_n;
        int i5 = com.baidu.tieba.u.icon_vip_grade_big_star_s;
        int i6 = com.baidu.tieba.u.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                aw.c(this.aXR[i2], i5);
            } else {
                aw.c(this.aXR[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                aw.c(this.aXR[i2], i6);
            } else {
                aw.c(this.aXR[i2], i4);
            }
            i2++;
        }
        this.aXH.setText(this.aXU[i]);
    }

    public TextView NE() {
        return this.aXN;
    }

    public void o(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.aXI.setVisibility(0);
            this.aXJ.setVisibility(8);
            this.aXK.setProgress((int) ((i2 / i3) * 100.0f));
            String string = this.aXC.getString(com.baidu.tieba.y.grouplevel_active_day_value, new Object[]{String.valueOf(i3)});
            this.aXL.setText(String.valueOf(i2));
            this.aXM.setText(string);
        } else if (i >= 3) {
            this.aXI.setVisibility(8);
            this.aXJ.setVisibility(0);
            this.aXJ.setText(com.baidu.tieba.y.grouplevel_highest_grade);
        }
    }
}
