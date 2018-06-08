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
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View abp;
    private View ecL;
    private GroupLevelActivity ekT;
    private ImageView ekU;
    private ImageView ekV;
    private ImageView ekW;
    private TextView ekX;
    private TextView ekY;
    private TextView ekZ;
    private TextView ela;
    private TextView elb;
    private TextView elc;
    private TextView eld;
    private TextView ele;
    private TextView elf;
    private ImageView[] elg;
    private TextView[] elh;
    private TextView[] eli;
    private String[] elj;
    private TextView elk;
    private TextView ell;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.elg = new ImageView[4];
        this.elh = new TextView[4];
        this.eli = new TextView[4];
        this.elj = new String[4];
        this.mNavigationBar = null;
        this.ekT = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.i.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.ecL.setOnClickListener(this.ekT);
        this.elk.setOnClickListener(this.ekT);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.abp = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.ekU = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.ekV = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.ekW = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.ekX = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.ekY = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.ekZ = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.elb = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.elc = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.ekT.getPageContext().getPageActivity().getString(d.k.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.elc.setText(spannableString);
        this.ela = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.eld = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.ele = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.elf = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.eli[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.eli[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.eli[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.elg[1] = this.ekU;
        this.elg[2] = this.ekV;
        this.elg[3] = this.ekW;
        this.elj[1] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_1);
        this.elj[2] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_2);
        this.elj[3] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_3);
        this.elh[1] = this.eld;
        this.elh[2] = this.ele;
        this.elh[3] = this.elf;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ekT.getResources().getString(d.k.group_info_grade));
        this.ecL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.elk = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.ell = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.elk.setVisibility(8);
            this.ell.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.ekX.setText(TbadkApplication.getInst().getString(d.k.grouplevel_vip_current_level));
            al.c(this.ekX, d.C0141d.common_color_10167, 1);
        } else {
            this.ekX.setText(TbadkApplication.getInst().getString(d.k.grouplevel_current_level));
            al.c(this.ekX, d.C0141d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.elk.setVisibility(8);
            this.ell.setVisibility(8);
            return;
        }
        this.elk.setVisibility(0);
        this.ell.setVisibility(0);
        if (z3 && i > 0) {
            this.elk.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.k.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.elk, d.C0141d.cp_cont_i, 1);
            this.elk.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_over_max_num);
            }
            this.elk.setEnabled(false);
            al.c(this.elk, d.C0141d.common_color_10172, 1);
        }
        this.ell.setText(string);
    }

    public View aIG() {
        return this.ecL;
    }

    public TextView aIH() {
        return this.elk;
    }

    public void onChangeSkinType(int i) {
        this.ekT.getLayoutMode().setNightMode(i == 1);
        this.ekT.getLayoutMode().onModeChanged(this.abp);
        this.mNavigationBar.onChangeSkinType(this.ekT.getPageContext(), i);
    }

    public TextView[] aII() {
        return this.elh;
    }

    public TextView[] aIJ() {
        return this.eli;
    }

    public void hj(boolean z) {
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
                al.c(this.elg[i2], i5);
            } else {
                al.c(this.elg[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.elg[i2], i6);
            } else {
                al.c(this.elg[i2], i4);
            }
            i2++;
        }
        this.ekY.setText(this.elj[i]);
    }

    public TextView aIK() {
        return this.ela;
    }

    public void N(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.elb.setVisibility(0);
            this.ekZ.setVisibility(8);
            int color = al.getColor(d.C0141d.cp_cont_b);
            int color2 = al.getColor(d.C0141d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.ekT.getPageContext().getPageActivity().getString(d.k.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.ekT.getPageContext().getPageActivity().getString(d.k.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.elb.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.elb.setVisibility(8);
            this.ekZ.setVisibility(0);
            this.ekZ.setText(d.k.grouplevel_highest_grade);
        }
    }
}
