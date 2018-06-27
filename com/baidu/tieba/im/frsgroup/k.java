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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View abt;
    private View egF;
    private GroupLevelActivity eoP;
    private ImageView eoQ;
    private ImageView eoR;
    private ImageView eoS;
    private TextView eoT;
    private TextView eoU;
    private TextView eoV;
    private TextView eoW;
    private TextView eoX;
    private TextView eoY;
    private TextView eoZ;
    private TextView epa;
    private TextView epb;
    private ImageView[] epc;
    private TextView[] epd;
    private TextView[] epe;
    private String[] epf;
    private TextView epg;
    private TextView eph;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.epc = new ImageView[4];
        this.epd = new TextView[4];
        this.epe = new TextView[4];
        this.epf = new String[4];
        this.mNavigationBar = null;
        this.eoP = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.i.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.egF.setOnClickListener(this.eoP);
        this.epg.setOnClickListener(this.eoP);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.abt = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.eoQ = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.eoR = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.eoS = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.eoT = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.eoU = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.eoV = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.eoX = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.eoY = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eoP.getPageContext().getPageActivity().getString(d.k.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eoY.setText(spannableString);
        this.eoW = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.eoZ = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.epa = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.epb = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.epe[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.epe[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.epe[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.epc[1] = this.eoQ;
        this.epc[2] = this.eoR;
        this.epc[3] = this.eoS;
        this.epf[1] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_1);
        this.epf[2] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_2);
        this.epf[3] = groupLevelActivity.getPageContext().getString(d.k.grouplevel_level_3);
        this.epd[1] = this.eoZ;
        this.epd[2] = this.epa;
        this.epd[3] = this.epb;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eoP.getResources().getString(d.k.group_info_grade));
        this.egF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.epg = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.eph = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.epg.setVisibility(8);
            this.eph.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eoT.setText(TbadkApplication.getInst().getString(d.k.grouplevel_vip_current_level));
            am.c(this.eoT, d.C0142d.common_color_10167, 1);
        } else {
            this.eoT.setText(TbadkApplication.getInst().getString(d.k.grouplevel_current_level));
            am.c(this.eoT, d.C0142d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.epg.setVisibility(8);
            this.eph.setVisibility(8);
            return;
        }
        this.epg.setVisibility(0);
        this.eph.setVisibility(0);
        if (z3 && i > 0) {
            this.epg.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.k.upgrade_mem_group_left_num), String.valueOf(i));
            am.c(this.epg, d.C0142d.cp_cont_i, 1);
            this.epg.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.k.upgrade_mem_group_over_max_num);
            }
            this.epg.setEnabled(false);
            am.c(this.epg, d.C0142d.common_color_10172, 1);
        }
        this.eph.setText(string);
    }

    public View aJn() {
        return this.egF;
    }

    public TextView aJo() {
        return this.epg;
    }

    public void onChangeSkinType(int i) {
        this.eoP.getLayoutMode().setNightMode(i == 1);
        this.eoP.getLayoutMode().onModeChanged(this.abt);
        this.mNavigationBar.onChangeSkinType(this.eoP.getPageContext(), i);
    }

    public TextView[] aJp() {
        return this.epd;
    }

    public TextView[] aJq() {
        return this.epe;
    }

    public void ht(boolean z) {
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
                am.c(this.epc[i2], i5);
            } else {
                am.c(this.epc[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                am.c(this.epc[i2], i6);
            } else {
                am.c(this.epc[i2], i4);
            }
            i2++;
        }
        this.eoU.setText(this.epf[i]);
    }

    public TextView aJr() {
        return this.eoW;
    }

    public void N(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eoX.setVisibility(0);
            this.eoV.setVisibility(8);
            int color = am.getColor(d.C0142d.cp_cont_b);
            int color2 = am.getColor(d.C0142d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eoP.getPageContext().getPageActivity().getString(d.k.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eoP.getPageContext().getPageActivity().getString(d.k.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eoX.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eoX.setVisibility(8);
            this.eoV.setVisibility(0);
            this.eoV.setText(d.k.grouplevel_highest_grade);
        }
    }
}
