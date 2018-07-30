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
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View aaV;
    private View ekv;
    private GroupLevelActivity esH;
    private ImageView esI;
    private ImageView esJ;
    private ImageView esK;
    private TextView esL;
    private TextView esM;
    private TextView esN;
    private TextView esO;
    private TextView esP;
    private TextView esQ;
    private TextView esR;
    private TextView esS;
    private TextView esT;
    private ImageView[] esU;
    private TextView[] esV;
    private TextView[] esW;
    private String[] esX;
    private TextView esY;
    private TextView esZ;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.esU = new ImageView[4];
        this.esV = new TextView[4];
        this.esW = new TextView[4];
        this.esX = new String[4];
        this.mNavigationBar = null;
        this.esH = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.ekv.setOnClickListener(this.esH);
        this.esY.setOnClickListener(this.esH);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.aaV = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.esI = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.esJ = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.esK = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.esL = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.esM = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.esN = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.esP = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.esQ = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.esH.getPageContext().getPageActivity().getString(d.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.esQ.setText(spannableString);
        this.esO = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.esR = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.esS = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.esT = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.esW[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.esW[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.esW[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.esU[1] = this.esI;
        this.esU[2] = this.esJ;
        this.esU[3] = this.esK;
        this.esX[1] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_1);
        this.esX[2] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_2);
        this.esX[3] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_3);
        this.esV[1] = this.esR;
        this.esV[2] = this.esS;
        this.esV[3] = this.esT;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.esH.getResources().getString(d.j.group_info_grade));
        this.ekv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.esY = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.esZ = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.esY.setVisibility(8);
            this.esZ.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.esL.setText(TbadkApplication.getInst().getString(d.j.grouplevel_vip_current_level));
            am.c(this.esL, d.C0140d.common_color_10167, 1);
        } else {
            this.esL.setText(TbadkApplication.getInst().getString(d.j.grouplevel_current_level));
            am.c(this.esL, d.C0140d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.esY.setVisibility(8);
            this.esZ.setVisibility(8);
            return;
        }
        this.esY.setVisibility(0);
        this.esZ.setVisibility(0);
        if (z3 && i > 0) {
            this.esY.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.j.upgrade_mem_group_left_num), String.valueOf(i));
            am.c(this.esY, d.C0140d.cp_cont_i, 1);
            this.esY.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_over_max_num);
            }
            this.esY.setEnabled(false);
            am.c(this.esY, d.C0140d.common_color_10172, 1);
        }
        this.esZ.setText(string);
    }

    public View aKo() {
        return this.ekv;
    }

    public TextView aKp() {
        return this.esY;
    }

    public void onChangeSkinType(int i) {
        this.esH.getLayoutMode().setNightMode(i == 1);
        this.esH.getLayoutMode().onModeChanged(this.aaV);
        this.mNavigationBar.onChangeSkinType(this.esH.getPageContext(), i);
    }

    public TextView[] aKq() {
        return this.esV;
    }

    public TextView[] aKr() {
        return this.esW;
    }

    public void hw(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void w(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = d.f.icon_grade_big_star_s;
        int i4 = d.f.icon_grade_big_star_n;
        int i5 = d.f.icon_vip_grade_big_star_s;
        int i6 = d.f.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                am.c(this.esU[i2], i5);
            } else {
                am.c(this.esU[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                am.c(this.esU[i2], i6);
            } else {
                am.c(this.esU[i2], i4);
            }
            i2++;
        }
        this.esM.setText(this.esX[i]);
    }

    public TextView aKs() {
        return this.esO;
    }

    public void N(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.esP.setVisibility(0);
            this.esN.setVisibility(8);
            int color = am.getColor(d.C0140d.cp_cont_b);
            int color2 = am.getColor(d.C0140d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.esH.getPageContext().getPageActivity().getString(d.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.esH.getPageContext().getPageActivity().getString(d.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.esP.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.esP.setVisibility(8);
            this.esN.setVisibility(0);
            this.esN.setText(d.j.grouplevel_highest_grade);
        }
    }
}
