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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View aaW;
    private View ekr;
    private GroupLevelActivity esD;
    private ImageView esE;
    private ImageView esF;
    private ImageView esG;
    private TextView esH;
    private TextView esI;
    private TextView esJ;
    private TextView esK;
    private TextView esL;
    private TextView esM;
    private TextView esN;
    private TextView esO;
    private TextView esP;
    private ImageView[] esQ;
    private TextView[] esR;
    private TextView[] esS;
    private String[] esT;
    private TextView esU;
    private TextView esV;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.esQ = new ImageView[4];
        this.esR = new TextView[4];
        this.esS = new TextView[4];
        this.esT = new String[4];
        this.mNavigationBar = null;
        this.esD = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(f.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.ekr.setOnClickListener(this.esD);
        this.esU.setOnClickListener(this.esD);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.aaW = groupLevelActivity.findViewById(f.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(f.g.progress_loading);
        this.esE = (ImageView) groupLevelActivity.findViewById(f.g.level_image_1);
        this.esF = (ImageView) groupLevelActivity.findViewById(f.g.level_image_2);
        this.esG = (ImageView) groupLevelActivity.findViewById(f.g.level_image_3);
        this.esH = (TextView) groupLevelActivity.findViewById(f.g.text_current_level);
        this.esI = (TextView) groupLevelActivity.findViewById(f.g.current_level);
        this.esJ = (TextView) groupLevelActivity.findViewById(f.g.grouplevel_highest);
        this.esL = (TextView) groupLevelActivity.findViewById(f.g.active_day_surplus);
        this.esM = (TextView) groupLevelActivity.findViewById(f.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.esD.getPageContext().getPageActivity().getString(f.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.esM.setText(spannableString);
        this.esK = (TextView) groupLevelActivity.findViewById(f.g.active_condition);
        this.esN = (TextView) groupLevelActivity.findViewById(f.g.group_max1);
        this.esO = (TextView) groupLevelActivity.findViewById(f.g.group_max2);
        this.esP = (TextView) groupLevelActivity.findViewById(f.g.group_max3);
        this.esS[1] = (TextView) groupLevelActivity.findViewById(f.g.vgroup_max1);
        this.esS[2] = (TextView) groupLevelActivity.findViewById(f.g.vgroup_max2);
        this.esS[3] = (TextView) groupLevelActivity.findViewById(f.g.vgroup_max3);
        this.esQ[1] = this.esE;
        this.esQ[2] = this.esF;
        this.esQ[3] = this.esG;
        this.esT[1] = groupLevelActivity.getPageContext().getString(f.j.grouplevel_level_1);
        this.esT[2] = groupLevelActivity.getPageContext().getString(f.j.grouplevel_level_2);
        this.esT[3] = groupLevelActivity.getPageContext().getString(f.j.grouplevel_level_3);
        this.esR[1] = this.esN;
        this.esR[2] = this.esO;
        this.esR[3] = this.esP;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(f.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.esD.getResources().getString(f.j.group_info_grade));
        this.ekr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.esU = (TextView) groupLevelActivity.findViewById(f.g.upgrade_mem_group_btn);
        this.esV = (TextView) groupLevelActivity.findViewById(f.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.esU.setVisibility(8);
            this.esV.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.esH.setText(TbadkApplication.getInst().getString(f.j.grouplevel_vip_current_level));
            am.c(this.esH, f.d.common_color_10167, 1);
        } else {
            this.esH.setText(TbadkApplication.getInst().getString(f.j.grouplevel_current_level));
            am.c(this.esH, f.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.esU.setVisibility(8);
            this.esV.setVisibility(8);
            return;
        }
        this.esU.setVisibility(0);
        this.esV.setVisibility(0);
        if (z3 && i > 0) {
            this.esU.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(f.j.upgrade_mem_group_left_num), String.valueOf(i));
            am.c(this.esU, f.d.cp_cont_i, 1);
            this.esU.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(f.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(f.j.upgrade_mem_group_over_max_num);
            }
            this.esU.setEnabled(false);
            am.c(this.esU, f.d.common_color_10172, 1);
        }
        this.esV.setText(string);
    }

    public View aKl() {
        return this.ekr;
    }

    public TextView aKm() {
        return this.esU;
    }

    public void onChangeSkinType(int i) {
        this.esD.getLayoutMode().setNightMode(i == 1);
        this.esD.getLayoutMode().onModeChanged(this.aaW);
        this.mNavigationBar.onChangeSkinType(this.esD.getPageContext(), i);
    }

    public TextView[] aKn() {
        return this.esR;
    }

    public TextView[] aKo() {
        return this.esS;
    }

    public void hw(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void w(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = f.C0146f.icon_grade_big_star_s;
        int i4 = f.C0146f.icon_grade_big_star_n;
        int i5 = f.C0146f.icon_vip_grade_big_star_s;
        int i6 = f.C0146f.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                am.c(this.esQ[i2], i5);
            } else {
                am.c(this.esQ[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                am.c(this.esQ[i2], i6);
            } else {
                am.c(this.esQ[i2], i4);
            }
            i2++;
        }
        this.esI.setText(this.esT[i]);
    }

    public TextView aKp() {
        return this.esK;
    }

    public void N(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.esL.setVisibility(0);
            this.esJ.setVisibility(8);
            int color = am.getColor(f.d.cp_cont_b);
            int color2 = am.getColor(f.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.esD.getPageContext().getPageActivity().getString(f.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.esD.getPageContext().getPageActivity().getString(f.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.esL.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.esL.setVisibility(8);
            this.esJ.setVisibility(0);
            this.esJ.setText(f.j.grouplevel_highest_grade);
        }
    }
}
