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
    private GroupLevelActivity eHI;
    private ImageView eHJ;
    private ImageView eHK;
    private ImageView eHL;
    private TextView eHM;
    private TextView eHN;
    private TextView eHO;
    private TextView eHP;
    private TextView eHQ;
    private TextView eHR;
    private TextView eHS;
    private TextView eHT;
    private TextView eHU;
    private ImageView[] eHV;
    private TextView[] eHW;
    private TextView[] eHX;
    private String[] eHY;
    private TextView eHZ;
    private TextView eIa;
    private View ezC;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eHV = new ImageView[4];
        this.eHW = new TextView[4];
        this.eHX = new TextView[4];
        this.eHY = new String[4];
        this.mNavigationBar = null;
        this.eHI = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.ezC.setOnClickListener(this.eHI);
        this.eHZ.setOnClickListener(this.eHI);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.aix = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.eHJ = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.eHK = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.eHL = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.eHM = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.eHN = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.eHO = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.eHQ = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.eHR = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eHI.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eHR.setText(spannableString);
        this.eHP = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.eHS = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eHT = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eHU = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eHX[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eHX[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eHX[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eHV[1] = this.eHJ;
        this.eHV[2] = this.eHK;
        this.eHV[3] = this.eHL;
        this.eHY[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eHY[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eHY[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eHW[1] = this.eHS;
        this.eHW[2] = this.eHT;
        this.eHW[3] = this.eHU;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eHI.getResources().getString(e.j.group_info_grade));
        this.ezC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eHZ = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eIa = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eHZ.setVisibility(8);
            this.eIa.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eHM.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.eHM, e.d.common_color_10167, 1);
        } else {
            this.eHM.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.eHM, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eHZ.setVisibility(8);
            this.eIa.setVisibility(8);
            return;
        }
        this.eHZ.setVisibility(0);
        this.eIa.setVisibility(0);
        if (z3 && i > 0) {
            this.eHZ.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eHZ, e.d.cp_cont_i, 1);
            this.eHZ.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eHZ.setEnabled(false);
            al.c(this.eHZ, e.d.common_color_10172, 1);
        }
        this.eIa.setText(string);
    }

    public View aPP() {
        return this.ezC;
    }

    public TextView aPQ() {
        return this.eHZ;
    }

    public void onChangeSkinType(int i) {
        this.eHI.getLayoutMode().setNightMode(i == 1);
        this.eHI.getLayoutMode().onModeChanged(this.aix);
        this.mNavigationBar.onChangeSkinType(this.eHI.getPageContext(), i);
    }

    public TextView[] aPR() {
        return this.eHW;
    }

    public TextView[] aPS() {
        return this.eHX;
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
                al.c(this.eHV[i2], i5);
            } else {
                al.c(this.eHV[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eHV[i2], i6);
            } else {
                al.c(this.eHV[i2], i4);
            }
            i2++;
        }
        this.eHN.setText(this.eHY[i]);
    }

    public TextView aPT() {
        return this.eHP;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eHQ.setVisibility(0);
            this.eHO.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eHI.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eHI.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eHQ.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eHQ.setVisibility(8);
            this.eHO.setVisibility(0);
            this.eHO.setText(e.j.grouplevel_highest_grade);
        }
    }
}
