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
    private View dQu;
    private GroupLevelActivity dYC;
    private ImageView dYD;
    private ImageView dYE;
    private ImageView dYF;
    private TextView dYG;
    private TextView dYH;
    private TextView dYI;
    private TextView dYJ;
    private TextView dYK;
    private TextView dYL;
    private TextView dYM;
    private TextView dYN;
    private TextView dYO;
    private ImageView[] dYP;
    private TextView[] dYQ;
    private TextView[] dYR;
    private String[] dYS;
    private TextView dYT;
    private TextView dYU;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.dYP = new ImageView[4];
        this.dYQ = new TextView[4];
        this.dYR = new TextView[4];
        this.dYS = new String[4];
        this.mNavigationBar = null;
        this.dYC = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.i.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.dQu.setOnClickListener(this.dYC);
        this.dYT.setOnClickListener(this.dYC);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.Tl = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.dYD = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.dYE = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.dYF = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.dYG = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.dYH = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.dYI = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.dYK = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.dYL = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.dYC.getPageContext().getPageActivity().getString(d.k.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.dYL.setText(spannableString);
        this.dYJ = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.dYM = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.dYN = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.dYO = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.dYR[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.dYR[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.dYR[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.dYP[1] = this.dYD;
        this.dYP[2] = this.dYE;
        this.dYP[3] = this.dYF;
        this.dYS[1] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_1);
        this.dYS[2] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_2);
        this.dYS[3] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_3);
        this.dYQ[1] = this.dYM;
        this.dYQ[2] = this.dYN;
        this.dYQ[3] = this.dYO;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.dYC.getResources().getString(d.k.group_info_grade));
        this.dQu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dYT = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.dYU = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.dYT.setVisibility(8);
            this.dYU.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.dYG.setText(TbadkApplication.getInst().getString(d.k.grouplevel_vip_current_level));
            ak.c(this.dYG, d.C0126d.common_color_10167, 1);
        } else {
            this.dYG.setText(TbadkApplication.getInst().getString(d.k.grouplevel_current_level));
            ak.c(this.dYG, d.C0126d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.dYT.setVisibility(8);
            this.dYU.setVisibility(8);
            return;
        }
        this.dYT.setVisibility(0);
        this.dYU.setVisibility(0);
        if (z3 && i > 0) {
            this.dYT.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.k.upgrade_mem_group_left_num), String.valueOf(i));
            ak.c(this.dYT, d.C0126d.cp_cont_i, 1);
            this.dYT.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_over_max_num);
            }
            this.dYT.setEnabled(false);
            ak.c(this.dYT, d.C0126d.common_color_10172, 1);
        }
        this.dYU.setText(string);
    }

    public View aDN() {
        return this.dQu;
    }

    public TextView aDO() {
        return this.dYT;
    }

    public void onChangeSkinType(int i) {
        this.dYC.getLayoutMode().setNightMode(i == 1);
        this.dYC.getLayoutMode().u(this.Tl);
        this.mNavigationBar.onChangeSkinType(this.dYC.getPageContext(), i);
    }

    public TextView[] aDP() {
        return this.dYQ;
    }

    public TextView[] aDQ() {
        return this.dYR;
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
                ak.c(this.dYP[i2], i5);
            } else {
                ak.c(this.dYP[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ak.c(this.dYP[i2], i6);
            } else {
                ak.c(this.dYP[i2], i4);
            }
            i2++;
        }
        this.dYH.setText(this.dYS[i]);
    }

    public TextView aDR() {
        return this.dYJ;
    }

    public void N(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.dYK.setVisibility(0);
            this.dYI.setVisibility(8);
            int color = ak.getColor(d.C0126d.cp_cont_b);
            int color2 = ak.getColor(d.C0126d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.dYC.getPageContext().getPageActivity().getString(d.k.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.dYC.getPageContext().getPageActivity().getString(d.k.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.dYK.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.dYK.setVisibility(8);
            this.dYI.setVisibility(0);
            this.dYI.setText(d.k.grouplevel_highest_grade);
        }
    }
}
