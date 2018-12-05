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
    private View amM;
    private View eHK;
    private GroupLevelActivity ePP;
    private ImageView ePQ;
    private ImageView ePR;
    private ImageView ePS;
    private TextView ePT;
    private TextView ePU;
    private TextView ePV;
    private TextView ePW;
    private TextView ePX;
    private TextView ePY;
    private TextView ePZ;
    private TextView eQa;
    private TextView eQb;
    private ImageView[] eQc;
    private TextView[] eQd;
    private TextView[] eQe;
    private String[] eQf;
    private TextView eQg;
    private TextView eQh;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eQc = new ImageView[4];
        this.eQd = new TextView[4];
        this.eQe = new TextView[4];
        this.eQf = new String[4];
        this.mNavigationBar = null;
        this.ePP = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.eHK.setOnClickListener(this.ePP);
        this.eQg.setOnClickListener(this.ePP);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.amM = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.ePQ = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.ePR = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.ePS = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.ePT = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.ePU = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.ePV = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.ePX = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.ePY = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.ePP.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.ePY.setText(spannableString);
        this.ePW = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.ePZ = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eQa = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eQb = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eQe[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eQe[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eQe[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eQc[1] = this.ePQ;
        this.eQc[2] = this.ePR;
        this.eQc[3] = this.ePS;
        this.eQf[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eQf[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eQf[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eQd[1] = this.ePZ;
        this.eQd[2] = this.eQa;
        this.eQd[3] = this.eQb;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ePP.getResources().getString(e.j.group_info_grade));
        this.eHK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eQg = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eQh = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eQg.setVisibility(8);
            this.eQh.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.ePT.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.ePT, e.d.common_color_10167, 1);
        } else {
            this.ePT.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.ePT, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eQg.setVisibility(8);
            this.eQh.setVisibility(8);
            return;
        }
        this.eQg.setVisibility(0);
        this.eQh.setVisibility(0);
        if (z3 && i > 0) {
            this.eQg.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eQg, e.d.cp_cont_i, 1);
            this.eQg.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eQg.setEnabled(false);
            al.c(this.eQg, e.d.common_color_10172, 1);
        }
        this.eQh.setText(string);
    }

    public View aRe() {
        return this.eHK;
    }

    public TextView aRf() {
        return this.eQg;
    }

    public void onChangeSkinType(int i) {
        this.ePP.getLayoutMode().setNightMode(i == 1);
        this.ePP.getLayoutMode().onModeChanged(this.amM);
        this.mNavigationBar.onChangeSkinType(this.ePP.getPageContext(), i);
    }

    public TextView[] aRg() {
        return this.eQd;
    }

    public TextView[] aRh() {
        return this.eQe;
    }

    public void iy(boolean z) {
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
                al.c(this.eQc[i2], i5);
            } else {
                al.c(this.eQc[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eQc[i2], i6);
            } else {
                al.c(this.eQc[i2], i4);
            }
            i2++;
        }
        this.ePU.setText(this.eQf[i]);
    }

    public TextView aRi() {
        return this.ePW;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.ePX.setVisibility(0);
            this.ePV.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.ePP.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.ePP.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.ePX.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.ePX.setVisibility(8);
            this.ePV.setVisibility(0);
            this.ePV.setText(e.j.grouplevel_highest_grade);
        }
    }
}
