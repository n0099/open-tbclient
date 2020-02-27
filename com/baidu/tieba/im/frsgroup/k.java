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
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private TextView[] hAA;
    private TextView[] hAB;
    private String[] hAC;
    private TextView hAD;
    private TextView hAE;
    private GroupLevelActivity hAm;
    private ImageView hAn;
    private ImageView hAo;
    private ImageView hAp;
    private TextView hAq;
    private TextView hAr;
    private TextView hAs;
    private TextView hAt;
    private TextView hAu;
    private TextView hAv;
    private TextView hAw;
    private TextView hAx;
    private TextView hAy;
    private ImageView[] hAz;
    private View hsi;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.hAz = new ImageView[4];
        this.hAA = new TextView[4];
        this.hAB = new TextView[4];
        this.hAC = new String[4];
        this.mNavigationBar = null;
        this.hAm = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.hsi.setOnClickListener(this.hAm);
        this.hAD.setOnClickListener(this.hAm);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.hAn = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.hAo = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.hAp = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.hAq = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.hAr = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.hAs = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.hAu = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.hAv = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.hAm.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.hAv.setText(spannableString);
        this.hAt = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.hAw = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.hAx = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.hAy = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.hAB[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.hAB[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.hAB[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.hAz[1] = this.hAn;
        this.hAz[2] = this.hAo;
        this.hAz[3] = this.hAp;
        this.hAC[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.hAC[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.hAC[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.hAA[1] = this.hAw;
        this.hAA[2] = this.hAx;
        this.hAA[3] = this.hAy;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hAm.getResources().getString(R.string.group_info_grade));
        this.hsi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hAD = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.hAE = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.hAD.setVisibility(8);
            this.hAE.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.hAq.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.hAq, R.color.common_color_10167, 1);
        } else {
            this.hAq.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.hAq, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.hAD.setVisibility(8);
            this.hAE.setVisibility(8);
            return;
        }
        this.hAD.setVisibility(0);
        this.hAE.setVisibility(0);
        if (z3 && i > 0) {
            this.hAD.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.hAD, R.color.cp_cont_a, 1);
            this.hAD.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.hAD.setEnabled(false);
            am.setViewTextColor(this.hAD, R.color.common_color_10172, 1);
        }
        this.hAE.setText(string);
    }

    public View bUX() {
        return this.hsi;
    }

    public TextView bUY() {
        return this.hAD;
    }

    public void onChangeSkinType(int i) {
        this.hAm.getLayoutMode().setNightMode(i == 1);
        this.hAm.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hAm.getPageContext(), i);
    }

    public TextView[] bUZ() {
        return this.hAA;
    }

    public TextView[] bVa() {
        return this.hAB;
    }

    public void ny(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void K(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.setImageResource(this.hAz[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.hAz[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.hAz[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.hAz[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.hAr.setText(this.hAC[i]);
    }

    public TextView bVb() {
        return this.hAt;
    }

    public void Q(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.hAu.setVisibility(0);
            this.hAs.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.hAm.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.hAm.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hAu.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.hAu.setVisibility(8);
            this.hAs.setVisibility(0);
            this.hAs.setText(R.string.grouplevel_highest_grade);
        }
    }
}
