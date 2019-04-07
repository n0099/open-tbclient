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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View bub;
    private View gbd;
    private TextView gjA;
    private ImageView[] gjB;
    private TextView[] gjC;
    private TextView[] gjD;
    private String[] gjE;
    private TextView gjF;
    private TextView gjG;
    private GroupLevelActivity gjo;
    private ImageView gjp;
    private ImageView gjq;
    private ImageView gjr;
    private TextView gjs;
    private TextView gjt;
    private TextView gju;
    private TextView gjv;
    private TextView gjw;
    private TextView gjx;
    private TextView gjy;
    private TextView gjz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gjB = new ImageView[4];
        this.gjC = new TextView[4];
        this.gjD = new TextView[4];
        this.gjE = new String[4];
        this.mNavigationBar = null;
        this.gjo = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gbd.setOnClickListener(this.gjo);
        this.gjF.setOnClickListener(this.gjo);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.bub = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.gjp = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.gjq = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.gjr = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.gjs = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.gjt = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.gju = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.gjw = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.gjx = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gjo.getPageContext().getPageActivity().getString(d.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gjx.setText(spannableString);
        this.gjv = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.gjy = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.gjz = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.gjA = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.gjD[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.gjD[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.gjD[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.gjB[1] = this.gjp;
        this.gjB[2] = this.gjq;
        this.gjB[3] = this.gjr;
        this.gjE[1] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_1);
        this.gjE[2] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_2);
        this.gjE[3] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_3);
        this.gjC[1] = this.gjy;
        this.gjC[2] = this.gjz;
        this.gjC[3] = this.gjA;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gjo.getResources().getString(d.j.group_info_grade));
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjF = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.gjG = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gjF.setVisibility(8);
            this.gjG.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gjs.setText(TbadkApplication.getInst().getString(d.j.grouplevel_vip_current_level));
            al.d(this.gjs, d.C0277d.common_color_10167, 1);
        } else {
            this.gjs.setText(TbadkApplication.getInst().getString(d.j.grouplevel_current_level));
            al.d(this.gjs, d.C0277d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gjF.setVisibility(8);
            this.gjG.setVisibility(8);
            return;
        }
        this.gjF.setVisibility(0);
        this.gjG.setVisibility(0);
        if (z3 && i > 0) {
            this.gjF.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.d(this.gjF, d.C0277d.cp_btn_a, 1);
            this.gjF.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_over_max_num);
            }
            this.gjF.setEnabled(false);
            al.d(this.gjF, d.C0277d.common_color_10172, 1);
        }
        this.gjG.setText(string);
    }

    public View bsT() {
        return this.gbd;
    }

    public TextView bsU() {
        return this.gjF;
    }

    public void onChangeSkinType(int i) {
        this.gjo.getLayoutMode().setNightMode(i == 1);
        this.gjo.getLayoutMode().onModeChanged(this.bub);
        this.mNavigationBar.onChangeSkinType(this.gjo.getPageContext(), i);
    }

    public TextView[] bsV() {
        return this.gjC;
    }

    public TextView[] bsW() {
        return this.gjD;
    }

    public void lb(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void D(int i, boolean z) {
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
                al.c(this.gjB[i2], i5);
            } else {
                al.c(this.gjB[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.gjB[i2], i6);
            } else {
                al.c(this.gjB[i2], i4);
            }
            i2++;
        }
        this.gjt.setText(this.gjE[i]);
    }

    public TextView bsX() {
        return this.gjv;
    }

    public void V(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gjw.setVisibility(0);
            this.gju.setVisibility(8);
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gjo.getPageContext().getPageActivity().getString(d.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gjo.getPageContext().getPageActivity().getString(d.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gjw.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gjw.setVisibility(8);
            this.gju.setVisibility(0);
            this.gju.setText(d.j.grouplevel_highest_grade);
        }
    }
}
