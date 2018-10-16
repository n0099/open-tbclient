package com.baidu.tieba.im.frsgroup;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View aix;
    private GroupLevelActivity eHH;
    private ImageView eHI;
    private ImageView eHJ;
    private ImageView eHK;
    private TextView eHL;
    private TextView eHM;
    private TextView eHN;
    private TextView eHO;
    private TextView eHP;
    private TextView eHQ;
    private TextView eHR;
    private TextView eHS;
    private TextView eHT;
    private ImageView[] eHU;
    private TextView[] eHV;
    private TextView[] eHW;
    private String[] eHX;
    private TextView eHY;
    private TextView eHZ;
    private View ezB;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eHU = new ImageView[4];
        this.eHV = new TextView[4];
        this.eHW = new TextView[4];
        this.eHX = new String[4];
        this.mNavigationBar = null;
        this.eHH = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.ezB.setOnClickListener(this.eHH);
        this.eHY.setOnClickListener(this.eHH);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.aix = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.eHI = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.eHJ = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.eHK = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.eHL = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.eHM = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.eHN = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.eHP = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.eHQ = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eHH.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eHQ.setText(spannableString);
        this.eHO = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.eHR = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eHS = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eHT = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eHW[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eHW[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eHW[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eHU[1] = this.eHI;
        this.eHU[2] = this.eHJ;
        this.eHU[3] = this.eHK;
        this.eHX[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eHX[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eHX[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eHV[1] = this.eHR;
        this.eHV[2] = this.eHS;
        this.eHV[3] = this.eHT;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eHH.getResources().getString(e.j.group_info_grade));
        this.ezB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eHY = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eHZ = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eHY.setVisibility(8);
            this.eHZ.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eHL.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.eHL, e.d.common_color_10167, 1);
        } else {
            this.eHL.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.eHL, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eHY.setVisibility(8);
            this.eHZ.setVisibility(8);
            return;
        }
        this.eHY.setVisibility(0);
        this.eHZ.setVisibility(0);
        if (z3 && i > 0) {
            this.eHY.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eHY, e.d.cp_cont_i, 1);
            this.eHY.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eHY.setEnabled(false);
            al.c(this.eHY, e.d.common_color_10172, 1);
        }
        this.eHZ.setText(string);
    }

    public View aPP() {
        return this.ezB;
    }

    public TextView aPQ() {
        return this.eHY;
    }

    public void onChangeSkinType(int i) {
        this.eHH.getLayoutMode().setNightMode(i == 1);
        this.eHH.getLayoutMode().onModeChanged(this.aix);
        this.mNavigationBar.onChangeSkinType(this.eHH.getPageContext(), i);
    }

    public TextView[] aPR() {
        return this.eHV;
    }

    public TextView[] aPS() {
        return this.eHW;
    }

    public void im(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void x(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = e.f.icon_grade_big_star_s;
        int i4 = e.f.icon_grade_big_star_n;
        int i5 = e.f.icon_vip_grade_big_star_s;
        int i6 = e.f.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                al.c(this.eHU[i2], i5);
            } else {
                al.c(this.eHU[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eHU[i2], i6);
            } else {
                al.c(this.eHU[i2], i4);
            }
            i2++;
        }
        this.eHM.setText(this.eHX[i]);
    }

    public TextView aPT() {
        return this.eHO;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eHP.setVisibility(0);
            this.eHN.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eHH.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eHH.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eHP.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eHP.setVisibility(8);
            this.eHN.setVisibility(0);
            this.eHN.setText(e.j.grouplevel_highest_grade);
        }
    }
}
