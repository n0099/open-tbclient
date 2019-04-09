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
    private View buc;
    private View gbd;
    private TextView gjA;
    private TextView gjB;
    private ImageView[] gjC;
    private TextView[] gjD;
    private TextView[] gjE;
    private String[] gjF;
    private TextView gjG;
    private TextView gjH;
    private GroupLevelActivity gjp;
    private ImageView gjq;
    private ImageView gjr;
    private ImageView gjs;
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
        this.gjC = new ImageView[4];
        this.gjD = new TextView[4];
        this.gjE = new TextView[4];
        this.gjF = new String[4];
        this.mNavigationBar = null;
        this.gjp = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gbd.setOnClickListener(this.gjp);
        this.gjG.setOnClickListener(this.gjp);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.buc = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.gjq = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.gjr = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.gjs = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.gjt = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.gju = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.gjv = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.gjx = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.gjy = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gjp.getPageContext().getPageActivity().getString(d.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gjy.setText(spannableString);
        this.gjw = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.gjz = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.gjA = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.gjB = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.gjE[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.gjE[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.gjE[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.gjC[1] = this.gjq;
        this.gjC[2] = this.gjr;
        this.gjC[3] = this.gjs;
        this.gjF[1] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_1);
        this.gjF[2] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_2);
        this.gjF[3] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_3);
        this.gjD[1] = this.gjz;
        this.gjD[2] = this.gjA;
        this.gjD[3] = this.gjB;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gjp.getResources().getString(d.j.group_info_grade));
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjG = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.gjH = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gjG.setVisibility(8);
            this.gjH.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gjt.setText(TbadkApplication.getInst().getString(d.j.grouplevel_vip_current_level));
            al.d(this.gjt, d.C0277d.common_color_10167, 1);
        } else {
            this.gjt.setText(TbadkApplication.getInst().getString(d.j.grouplevel_current_level));
            al.d(this.gjt, d.C0277d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gjG.setVisibility(8);
            this.gjH.setVisibility(8);
            return;
        }
        this.gjG.setVisibility(0);
        this.gjH.setVisibility(0);
        if (z3 && i > 0) {
            this.gjG.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.d(this.gjG, d.C0277d.cp_btn_a, 1);
            this.gjG.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_over_max_num);
            }
            this.gjG.setEnabled(false);
            al.d(this.gjG, d.C0277d.common_color_10172, 1);
        }
        this.gjH.setText(string);
    }

    public View bsT() {
        return this.gbd;
    }

    public TextView bsU() {
        return this.gjG;
    }

    public void onChangeSkinType(int i) {
        this.gjp.getLayoutMode().setNightMode(i == 1);
        this.gjp.getLayoutMode().onModeChanged(this.buc);
        this.mNavigationBar.onChangeSkinType(this.gjp.getPageContext(), i);
    }

    public TextView[] bsV() {
        return this.gjD;
    }

    public TextView[] bsW() {
        return this.gjE;
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
                al.c(this.gjC[i2], i5);
            } else {
                al.c(this.gjC[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.gjC[i2], i6);
            } else {
                al.c(this.gjC[i2], i4);
            }
            i2++;
        }
        this.gju.setText(this.gjF[i]);
    }

    public TextView bsX() {
        return this.gjw;
    }

    public void V(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gjx.setVisibility(0);
            this.gjv.setVisibility(8);
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gjp.getPageContext().getPageActivity().getString(d.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gjp.getPageContext().getPageActivity().getString(d.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gjx.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gjx.setVisibility(8);
            this.gjv.setVisibility(0);
            this.gjv.setText(d.j.grouplevel_highest_grade);
        }
    }
}
