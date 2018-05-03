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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View Tl;
    private View dQr;
    private ImageView dYA;
    private ImageView dYB;
    private ImageView dYC;
    private TextView dYD;
    private TextView dYE;
    private TextView dYF;
    private TextView dYG;
    private TextView dYH;
    private TextView dYI;
    private TextView dYJ;
    private TextView dYK;
    private TextView dYL;
    private ImageView[] dYM;
    private TextView[] dYN;
    private TextView[] dYO;
    private String[] dYP;
    private TextView dYQ;
    private TextView dYR;
    private GroupLevelActivity dYz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.dYM = new ImageView[4];
        this.dYN = new TextView[4];
        this.dYO = new TextView[4];
        this.dYP = new String[4];
        this.mNavigationBar = null;
        this.dYz = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.i.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.dQr.setOnClickListener(this.dYz);
        this.dYQ.setOnClickListener(this.dYz);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.Tl = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.dYA = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.dYB = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.dYC = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.dYD = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.dYE = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.dYF = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.dYH = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.dYI = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.dYz.getPageContext().getPageActivity().getString(d.k.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.dYI.setText(spannableString);
        this.dYG = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.dYJ = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.dYK = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.dYL = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.dYO[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.dYO[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.dYO[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.dYM[1] = this.dYA;
        this.dYM[2] = this.dYB;
        this.dYM[3] = this.dYC;
        this.dYP[1] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_1);
        this.dYP[2] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_2);
        this.dYP[3] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_3);
        this.dYN[1] = this.dYJ;
        this.dYN[2] = this.dYK;
        this.dYN[3] = this.dYL;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.dYz.getResources().getString(d.k.group_info_grade));
        this.dQr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dYQ = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.dYR = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.dYQ.setVisibility(8);
            this.dYR.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.dYD.setText(TbadkApplication.getInst().getString(d.k.grouplevel_vip_current_level));
            ak.c(this.dYD, d.C0126d.common_color_10167, 1);
        } else {
            this.dYD.setText(TbadkApplication.getInst().getString(d.k.grouplevel_current_level));
            ak.c(this.dYD, d.C0126d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.dYQ.setVisibility(8);
            this.dYR.setVisibility(8);
            return;
        }
        this.dYQ.setVisibility(0);
        this.dYR.setVisibility(0);
        if (z3 && i > 0) {
            this.dYQ.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.k.upgrade_mem_group_left_num), String.valueOf(i));
            ak.c(this.dYQ, d.C0126d.cp_cont_i, 1);
            this.dYQ.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_over_max_num);
            }
            this.dYQ.setEnabled(false);
            ak.c(this.dYQ, d.C0126d.common_color_10172, 1);
        }
        this.dYR.setText(string);
    }

    public View aDN() {
        return this.dQr;
    }

    public TextView aDO() {
        return this.dYQ;
    }

    public void onChangeSkinType(int i) {
        this.dYz.getLayoutMode().setNightMode(i == 1);
        this.dYz.getLayoutMode().u(this.Tl);
        this.mNavigationBar.onChangeSkinType(this.dYz.getPageContext(), i);
    }

    public TextView[] aDP() {
        return this.dYN;
    }

    public TextView[] aDQ() {
        return this.dYO;
    }

    public void hc(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void x(int i, boolean z) {
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
                ak.c(this.dYM[i2], i5);
            } else {
                ak.c(this.dYM[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ak.c(this.dYM[i2], i6);
            } else {
                ak.c(this.dYM[i2], i4);
            }
            i2++;
        }
        this.dYE.setText(this.dYP[i]);
    }

    public TextView aDR() {
        return this.dYG;
    }

    public void N(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.dYH.setVisibility(0);
            this.dYF.setVisibility(8);
            int color = ak.getColor(d.C0126d.cp_cont_b);
            int color2 = ak.getColor(d.C0126d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.dYz.getPageContext().getPageActivity().getString(d.k.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.dYz.getPageContext().getPageActivity().getString(d.k.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.dYH.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.dYH.setVisibility(8);
            this.dYF.setVisibility(0);
            this.dYF.setText(d.k.grouplevel_highest_grade);
        }
    }
}
