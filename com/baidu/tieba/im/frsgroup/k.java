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
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View ajk;
    private View eAV;
    private GroupLevelActivity eJa;
    private ImageView eJb;
    private ImageView eJc;
    private ImageView eJd;
    private TextView eJe;
    private TextView eJf;
    private TextView eJg;
    private TextView eJh;
    private TextView eJi;
    private TextView eJj;
    private TextView eJk;
    private TextView eJl;
    private TextView eJm;
    private ImageView[] eJn;
    private TextView[] eJo;
    private TextView[] eJp;
    private String[] eJq;
    private TextView eJr;
    private TextView eJs;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eJn = new ImageView[4];
        this.eJo = new TextView[4];
        this.eJp = new TextView[4];
        this.eJq = new String[4];
        this.mNavigationBar = null;
        this.eJa = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.eAV.setOnClickListener(this.eJa);
        this.eJr.setOnClickListener(this.eJa);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.ajk = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.eJb = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.eJc = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.eJd = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.eJe = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.eJf = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.eJg = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.eJi = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.eJj = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eJa.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eJj.setText(spannableString);
        this.eJh = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.eJk = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eJl = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eJm = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eJp[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eJp[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eJp[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eJn[1] = this.eJb;
        this.eJn[2] = this.eJc;
        this.eJn[3] = this.eJd;
        this.eJq[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eJq[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eJq[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eJo[1] = this.eJk;
        this.eJo[2] = this.eJl;
        this.eJo[3] = this.eJm;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eJa.getResources().getString(e.j.group_info_grade));
        this.eAV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eJr = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eJs = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eJr.setVisibility(8);
            this.eJs.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eJe.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.eJe, e.d.common_color_10167, 1);
        } else {
            this.eJe.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.eJe, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eJr.setVisibility(8);
            this.eJs.setVisibility(8);
            return;
        }
        this.eJr.setVisibility(0);
        this.eJs.setVisibility(0);
        if (z3 && i > 0) {
            this.eJr.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eJr, e.d.cp_cont_i, 1);
            this.eJr.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eJr.setEnabled(false);
            al.c(this.eJr, e.d.common_color_10172, 1);
        }
        this.eJs.setText(string);
    }

    public View aPm() {
        return this.eAV;
    }

    public TextView aPn() {
        return this.eJr;
    }

    public void onChangeSkinType(int i) {
        this.eJa.getLayoutMode().setNightMode(i == 1);
        this.eJa.getLayoutMode().onModeChanged(this.ajk);
        this.mNavigationBar.onChangeSkinType(this.eJa.getPageContext(), i);
    }

    public TextView[] aPo() {
        return this.eJo;
    }

    public TextView[] aPp() {
        return this.eJp;
    }

    public void iv(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void x(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = e.f.icon_grade_big_star_s;
        int i4 = e.f.icon_grade_big_star_n;
        int i5 = e.f.icon_vip_grade_big_star_s;
        int i6 = e.f.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                al.c(this.eJn[i2], i5);
            } else {
                al.c(this.eJn[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eJn[i2], i6);
            } else {
                al.c(this.eJn[i2], i4);
            }
            i2++;
        }
        this.eJf.setText(this.eJq[i]);
    }

    public TextView aPq() {
        return this.eJh;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eJi.setVisibility(0);
            this.eJg.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eJa.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eJa.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eJi.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eJi.setVisibility(8);
            this.eJg.setVisibility(0);
            this.eJg.setText(e.j.grouplevel_highest_grade);
        }
    }
}
