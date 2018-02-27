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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View aHS;
    private GroupLevelActivity eDI;
    private ImageView eDJ;
    private ImageView eDK;
    private ImageView eDL;
    private TextView eDM;
    private TextView eDN;
    private TextView eDO;
    private TextView eDP;
    private TextView eDQ;
    private TextView eDR;
    private TextView eDS;
    private TextView eDT;
    private TextView eDU;
    private ImageView[] eDV;
    private TextView[] eDW;
    private TextView[] eDX;
    private String[] eDY;
    private TextView eDZ;
    private TextView eEa;
    private View evy;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eDV = new ImageView[4];
        this.eDW = new TextView[4];
        this.eDX = new TextView[4];
        this.eDY = new String[4];
        this.mNavigationBar = null;
        this.eDI = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.evy.setOnClickListener(this.eDI);
        this.eDZ.setOnClickListener(this.eDI);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.aHS = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.eDJ = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.eDK = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.eDL = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.eDM = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.eDN = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.eDO = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.eDQ = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.eDR = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eDI.getPageContext().getPageActivity().getString(d.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eDR.setText(spannableString);
        this.eDP = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.eDS = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.eDT = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.eDU = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.eDX[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.eDX[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.eDX[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.eDV[1] = this.eDJ;
        this.eDV[2] = this.eDK;
        this.eDV[3] = this.eDL;
        this.eDY[1] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_1);
        this.eDY[2] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_2);
        this.eDY[3] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_3);
        this.eDW[1] = this.eDS;
        this.eDW[2] = this.eDT;
        this.eDW[3] = this.eDU;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eDI.getResources().getString(d.j.group_info_grade));
        this.evy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eDZ = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.eEa = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eDZ.setVisibility(8);
            this.eEa.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eDM.setText(TbadkApplication.getInst().getString(d.j.grouplevel_vip_current_level));
            aj.e(this.eDM, d.C0141d.common_color_10167, 1);
        } else {
            this.eDM.setText(TbadkApplication.getInst().getString(d.j.grouplevel_current_level));
            aj.e(this.eDM, d.C0141d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eDZ.setVisibility(8);
            this.eEa.setVisibility(8);
            return;
        }
        this.eDZ.setVisibility(0);
        this.eEa.setVisibility(0);
        if (z3 && i > 0) {
            this.eDZ.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.j.upgrade_mem_group_left_num), String.valueOf(i));
            aj.e(this.eDZ, d.C0141d.cp_cont_i, 1);
            this.eDZ.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_over_max_num);
            }
            this.eDZ.setEnabled(false);
            aj.e(this.eDZ, d.C0141d.common_color_10172, 1);
        }
        this.eEa.setText(string);
    }

    public View aIP() {
        return this.evy;
    }

    public TextView aIQ() {
        return this.eDZ;
    }

    public void onChangeSkinType(int i) {
        this.eDI.getLayoutMode().aQ(i == 1);
        this.eDI.getLayoutMode().aM(this.aHS);
        this.mNavigationBar.onChangeSkinType(this.eDI.getPageContext(), i);
    }

    public TextView[] aIR() {
        return this.eDW;
    }

    public TextView[] aIS() {
        return this.eDX;
    }

    public void hx(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void L(int i, boolean z) {
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
                aj.c(this.eDV[i2], i5);
            } else {
                aj.c(this.eDV[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                aj.c(this.eDV[i2], i6);
            } else {
                aj.c(this.eDV[i2], i4);
            }
            i2++;
        }
        this.eDN.setText(this.eDY[i]);
    }

    public TextView aIT() {
        return this.eDP;
    }

    public void Z(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eDQ.setVisibility(0);
            this.eDO.setVisibility(8);
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eDI.getPageContext().getPageActivity().getString(d.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eDI.getPageContext().getPageActivity().getString(d.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eDQ.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eDQ.setVisibility(8);
            this.eDO.setVisibility(0);
            this.eDO.setText(d.j.grouplevel_highest_grade);
        }
    }
}
