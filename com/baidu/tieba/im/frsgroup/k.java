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
    private View adA;
    private ImageView eAa;
    private TextView eAb;
    private TextView eAc;
    private TextView eAd;
    private TextView eAe;
    private TextView eAf;
    private TextView eAg;
    private TextView eAh;
    private TextView eAi;
    private TextView eAj;
    private ImageView[] eAk;
    private TextView[] eAl;
    private TextView[] eAm;
    private String[] eAn;
    private TextView eAo;
    private TextView eAp;
    private View erL;
    private GroupLevelActivity ezX;
    private ImageView ezY;
    private ImageView ezZ;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eAk = new ImageView[4];
        this.eAl = new TextView[4];
        this.eAm = new TextView[4];
        this.eAn = new String[4];
        this.mNavigationBar = null;
        this.ezX = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.erL.setOnClickListener(this.ezX);
        this.eAo.setOnClickListener(this.ezX);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.adA = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.ezY = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.ezZ = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.eAa = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.eAb = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.eAc = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.eAd = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.eAf = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.eAg = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.ezX.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eAg.setText(spannableString);
        this.eAe = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.eAh = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eAi = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eAj = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eAm[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eAm[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eAm[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eAk[1] = this.ezY;
        this.eAk[2] = this.ezZ;
        this.eAk[3] = this.eAa;
        this.eAn[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eAn[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eAn[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eAl[1] = this.eAh;
        this.eAl[2] = this.eAi;
        this.eAl[3] = this.eAj;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ezX.getResources().getString(e.j.group_info_grade));
        this.erL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eAo = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eAp = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eAo.setVisibility(8);
            this.eAp.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eAb.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.eAb, e.d.common_color_10167, 1);
        } else {
            this.eAb.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.eAb, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eAo.setVisibility(8);
            this.eAp.setVisibility(8);
            return;
        }
        this.eAo.setVisibility(0);
        this.eAp.setVisibility(0);
        if (z3 && i > 0) {
            this.eAo.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eAo, e.d.cp_cont_i, 1);
            this.eAo.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eAo.setEnabled(false);
            al.c(this.eAo, e.d.common_color_10172, 1);
        }
        this.eAp.setText(string);
    }

    public View aMA() {
        return this.erL;
    }

    public TextView aMB() {
        return this.eAo;
    }

    public void onChangeSkinType(int i) {
        this.ezX.getLayoutMode().setNightMode(i == 1);
        this.ezX.getLayoutMode().onModeChanged(this.adA);
        this.mNavigationBar.onChangeSkinType(this.ezX.getPageContext(), i);
    }

    public TextView[] aMC() {
        return this.eAl;
    }

    public TextView[] aMD() {
        return this.eAm;
    }

    public void hU(boolean z) {
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
                al.c(this.eAk[i2], i5);
            } else {
                al.c(this.eAk[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eAk[i2], i6);
            } else {
                al.c(this.eAk[i2], i4);
            }
            i2++;
        }
        this.eAc.setText(this.eAn[i]);
    }

    public TextView aME() {
        return this.eAe;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eAf.setVisibility(0);
            this.eAd.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.ezX.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.ezX.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eAf.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eAf.setVisibility(8);
            this.eAd.setVisibility(0);
            this.eAd.setText(e.j.grouplevel_highest_grade);
        }
    }
}
