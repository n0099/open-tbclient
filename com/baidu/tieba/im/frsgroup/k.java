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
    private View aId;
    private GroupLevelActivity eDU;
    private ImageView eDV;
    private ImageView eDW;
    private ImageView eDX;
    private TextView eDY;
    private TextView eDZ;
    private TextView eEa;
    private TextView eEb;
    private TextView eEc;
    private TextView eEd;
    private TextView eEe;
    private TextView eEf;
    private TextView eEg;
    private ImageView[] eEh;
    private TextView[] eEi;
    private TextView[] eEj;
    private String[] eEk;
    private TextView eEl;
    private TextView eEm;
    private View evK;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eEh = new ImageView[4];
        this.eEi = new TextView[4];
        this.eEj = new TextView[4];
        this.eEk = new String[4];
        this.mNavigationBar = null;
        this.eDU = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.evK.setOnClickListener(this.eDU);
        this.eEl.setOnClickListener(this.eDU);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.aId = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.eDV = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.eDW = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.eDX = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.eDY = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.eDZ = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.eEa = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.eEc = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.eEd = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eDU.getPageContext().getPageActivity().getString(d.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eEd.setText(spannableString);
        this.eEb = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.eEe = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.eEf = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.eEg = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.eEj[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.eEj[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.eEj[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.eEh[1] = this.eDV;
        this.eEh[2] = this.eDW;
        this.eEh[3] = this.eDX;
        this.eEk[1] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_1);
        this.eEk[2] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_2);
        this.eEk[3] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_3);
        this.eEi[1] = this.eEe;
        this.eEi[2] = this.eEf;
        this.eEi[3] = this.eEg;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eDU.getResources().getString(d.j.group_info_grade));
        this.evK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEl = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.eEm = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eEl.setVisibility(8);
            this.eEm.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eDY.setText(TbadkApplication.getInst().getString(d.j.grouplevel_vip_current_level));
            aj.e(this.eDY, d.C0140d.common_color_10167, 1);
        } else {
            this.eDY.setText(TbadkApplication.getInst().getString(d.j.grouplevel_current_level));
            aj.e(this.eDY, d.C0140d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eEl.setVisibility(8);
            this.eEm.setVisibility(8);
            return;
        }
        this.eEl.setVisibility(0);
        this.eEm.setVisibility(0);
        if (z3 && i > 0) {
            this.eEl.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.j.upgrade_mem_group_left_num), String.valueOf(i));
            aj.e(this.eEl, d.C0140d.cp_cont_i, 1);
            this.eEl.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_over_max_num);
            }
            this.eEl.setEnabled(false);
            aj.e(this.eEl, d.C0140d.common_color_10172, 1);
        }
        this.eEm.setText(string);
    }

    public View aIQ() {
        return this.evK;
    }

    public TextView aIR() {
        return this.eEl;
    }

    public void onChangeSkinType(int i) {
        this.eDU.getLayoutMode().aQ(i == 1);
        this.eDU.getLayoutMode().aM(this.aId);
        this.mNavigationBar.onChangeSkinType(this.eDU.getPageContext(), i);
    }

    public TextView[] aIS() {
        return this.eEi;
    }

    public TextView[] aIT() {
        return this.eEj;
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
                aj.c(this.eEh[i2], i5);
            } else {
                aj.c(this.eEh[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                aj.c(this.eEh[i2], i6);
            } else {
                aj.c(this.eEh[i2], i4);
            }
            i2++;
        }
        this.eDZ.setText(this.eEk[i]);
    }

    public TextView aIU() {
        return this.eEb;
    }

    public void Z(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eEc.setVisibility(0);
            this.eEa.setVisibility(8);
            int color = aj.getColor(d.C0140d.cp_cont_b);
            int color2 = aj.getColor(d.C0140d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eDU.getPageContext().getPageActivity().getString(d.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eDU.getPageContext().getPageActivity().getString(d.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eEc.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eEc.setVisibility(8);
            this.eEa.setVisibility(0);
            this.eEa.setText(d.j.grouplevel_highest_grade);
        }
    }
}
