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
    private View aHT;
    private GroupLevelActivity eDY;
    private ImageView eDZ;
    private ImageView eEa;
    private ImageView eEb;
    private TextView eEc;
    private TextView eEd;
    private TextView eEe;
    private TextView eEf;
    private TextView eEg;
    private TextView eEh;
    private TextView eEi;
    private TextView eEj;
    private TextView eEk;
    private ImageView[] eEl;
    private TextView[] eEm;
    private TextView[] eEn;
    private String[] eEo;
    private TextView eEp;
    private TextView eEq;
    private View evO;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eEl = new ImageView[4];
        this.eEm = new TextView[4];
        this.eEn = new TextView[4];
        this.eEo = new String[4];
        this.mNavigationBar = null;
        this.eDY = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.evO.setOnClickListener(this.eDY);
        this.eEp.setOnClickListener(this.eDY);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.aHT = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.eDZ = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.eEa = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.eEb = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.eEc = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.eEd = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.eEe = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.eEg = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.eEh = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eDY.getPageContext().getPageActivity().getString(d.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eEh.setText(spannableString);
        this.eEf = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.eEi = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.eEj = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.eEk = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.eEn[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.eEn[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.eEn[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.eEl[1] = this.eDZ;
        this.eEl[2] = this.eEa;
        this.eEl[3] = this.eEb;
        this.eEo[1] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_1);
        this.eEo[2] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_2);
        this.eEo[3] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_3);
        this.eEm[1] = this.eEi;
        this.eEm[2] = this.eEj;
        this.eEm[3] = this.eEk;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eDY.getResources().getString(d.j.group_info_grade));
        this.evO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEp = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.eEq = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eEp.setVisibility(8);
            this.eEq.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eEc.setText(TbadkApplication.getInst().getString(d.j.grouplevel_vip_current_level));
            aj.e(this.eEc, d.C0141d.common_color_10167, 1);
        } else {
            this.eEc.setText(TbadkApplication.getInst().getString(d.j.grouplevel_current_level));
            aj.e(this.eEc, d.C0141d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eEp.setVisibility(8);
            this.eEq.setVisibility(8);
            return;
        }
        this.eEp.setVisibility(0);
        this.eEq.setVisibility(0);
        if (z3 && i > 0) {
            this.eEp.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.j.upgrade_mem_group_left_num), String.valueOf(i));
            aj.e(this.eEp, d.C0141d.cp_cont_i, 1);
            this.eEp.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_over_max_num);
            }
            this.eEp.setEnabled(false);
            aj.e(this.eEp, d.C0141d.common_color_10172, 1);
        }
        this.eEq.setText(string);
    }

    public View aIQ() {
        return this.evO;
    }

    public TextView aIR() {
        return this.eEp;
    }

    public void onChangeSkinType(int i) {
        this.eDY.getLayoutMode().aQ(i == 1);
        this.eDY.getLayoutMode().aM(this.aHT);
        this.mNavigationBar.onChangeSkinType(this.eDY.getPageContext(), i);
    }

    public TextView[] aIS() {
        return this.eEm;
    }

    public TextView[] aIT() {
        return this.eEn;
    }

    public void hC(boolean z) {
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
                aj.c(this.eEl[i2], i5);
            } else {
                aj.c(this.eEl[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                aj.c(this.eEl[i2], i6);
            } else {
                aj.c(this.eEl[i2], i4);
            }
            i2++;
        }
        this.eEd.setText(this.eEo[i]);
    }

    public TextView aIU() {
        return this.eEf;
    }

    public void Z(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eEg.setVisibility(0);
            this.eEe.setVisibility(8);
            int color = aj.getColor(d.C0141d.cp_cont_b);
            int color2 = aj.getColor(d.C0141d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eDY.getPageContext().getPageActivity().getString(d.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eDY.getPageContext().getPageActivity().getString(d.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eEg.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eEg.setVisibility(8);
            this.eEe.setVisibility(0);
            this.eEe.setText(d.j.grouplevel_highest_grade);
        }
    }
}
