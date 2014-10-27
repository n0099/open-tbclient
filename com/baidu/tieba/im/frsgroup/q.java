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
    private View aOF;
    private TextView aXA;
    private TextView aXB;
    private TextView aXC;
    private ImageView[] aXD;
    private TextView[] aXE;
    private TextView[] aXF;
    private String[] aXG;
    private Button aXH;
    private TextView aXI;
    private GroupLevelActivity aXo;
    private ImageView aXp;
    private ImageView aXq;
    private ImageView aXr;
    private TextView aXs;
    private TextView aXt;
    private ViewGroup aXu;
    private TextView aXv;
    private ProgressBar aXw;
    private TextView aXx;
    private TextView aXy;
    private TextView aXz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public q(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity);
        this.aXD = new ImageView[4];
        this.aXE = new TextView[4];
        this.aXF = new TextView[4];
        this.aXG = new String[4];
        this.mNavigationBar = null;
        this.aXo = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(com.baidu.tieba.w.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.aOF.setOnClickListener(this.aXo);
        this.aXH.setOnClickListener(this.aXo);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(com.baidu.tieba.v.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.v.progress_loading);
        this.aXp = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_1);
        this.aXq = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_2);
        this.aXr = (ImageView) groupLevelActivity.findViewById(com.baidu.tieba.v.level_image_3);
        this.aXs = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.text_current_level);
        this.aXt = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.current_level);
        this.aXu = (ViewGroup) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_active);
        this.aXv = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_highest);
        this.aXw = (ProgressBar) groupLevelActivity.findViewById(com.baidu.tieba.v.active_progress);
        this.aXx = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_day_cur);
        this.aXy = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_day_total);
        this.aXz = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.active_condition);
        this.aXA = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max1);
        this.aXB = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max2);
        this.aXC = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.group_max3);
        this.aXF[1] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max1);
        this.aXF[2] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max2);
        this.aXF[3] = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.vgroup_max3);
        this.aXD[1] = this.aXp;
        this.aXD[2] = this.aXq;
        this.aXD[3] = this.aXr;
        this.aXG[1] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_1);
        this.aXG[2] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_2);
        this.aXG[3] = groupLevelActivity.getString(com.baidu.tieba.y.grouplevel_level_3);
        this.aXE[1] = this.aXA;
        this.aXE[2] = this.aXB;
        this.aXE[3] = this.aXC;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(com.baidu.tieba.v.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.aXo.getResources().getString(com.baidu.tieba.y.grouplevel_title));
        this.aOF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aXH = (Button) groupLevelActivity.findViewById(com.baidu.tieba.v.upgrade_mem_group_btn);
        this.aXI = (TextView) groupLevelActivity.findViewById(com.baidu.tieba.v.upgrade_mem_group_tip);
        if (this.isMem) {
            this.aXH.setVisibility(8);
            this.aXI.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.aXs.setText(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.grouplevel_vip_current_level));
            aw.b(this.aXs, com.baidu.tieba.s.group_level_promote, 1);
        } else {
            this.aXs.setText(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.grouplevel_current_level));
            aw.b(this.aXs, com.baidu.tieba.s.group_level_secondtitle_text, 1);
        }
        if (z || !z2) {
            this.aXH.setVisibility(8);
            this.aXI.setVisibility(8);
            return;
        }
        this.aXH.setVisibility(0);
        this.aXI.setVisibility(0);
        if (z3 && i > 0) {
            this.aXH.setEnabled(true);
            string = String.format(TbadkApplication.m251getInst().getString(com.baidu.tieba.y.upgrade_mem_group_left_num), String.valueOf(i));
            aw.b(this.aXH, com.baidu.tieba.s.upgrade_mem_group_btn_text, 3);
            this.aXH.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.m251getInst().getString(com.baidu.tieba.y.upgrade_mem_group_over_max_num);
            }
            this.aXH.setEnabled(false);
            aw.b(this.aXH, com.baidu.tieba.s.upgrade_mem_group_btn_cannotup_text, 3);
        }
        this.aXI.setText(string);
    }

    public View Nw() {
        return this.aOF;
    }

    public Button Nx() {
        return this.aXH;
    }

    public void onChangeSkinType(int i) {
        this.aXo.getLayoutMode().L(i == 1);
        this.aXo.getLayoutMode().h(this.mRoot);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public TextView[] Ny() {
        return this.aXE;
    }

    public TextView[] Nz() {
        return this.aXF;
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
                aw.c(this.aXD[i2], i5);
            } else {
                aw.c(this.aXD[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                aw.c(this.aXD[i2], i6);
            } else {
                aw.c(this.aXD[i2], i4);
            }
            i2++;
        }
        this.aXt.setText(this.aXG[i]);
    }

    public TextView NA() {
        return this.aXz;
    }

    public void o(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.aXu.setVisibility(0);
            this.aXv.setVisibility(8);
            this.aXw.setProgress((int) ((i2 / i3) * 100.0f));
            String string = this.aXo.getString(com.baidu.tieba.y.grouplevel_active_day_value, new Object[]{String.valueOf(i3)});
            this.aXx.setText(String.valueOf(i2));
            this.aXy.setText(string);
        } else if (i >= 3) {
            this.aXu.setVisibility(8);
            this.aXv.setVisibility(0);
            this.aXv.setText(com.baidu.tieba.y.grouplevel_highest_grade);
        }
    }
}
