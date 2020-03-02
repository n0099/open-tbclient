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
    private TextView hAA;
    private ImageView[] hAB;
    private TextView[] hAC;
    private TextView[] hAD;
    private String[] hAE;
    private TextView hAF;
    private TextView hAG;
    private GroupLevelActivity hAo;
    private ImageView hAp;
    private ImageView hAq;
    private ImageView hAr;
    private TextView hAs;
    private TextView hAt;
    private TextView hAu;
    private TextView hAv;
    private TextView hAw;
    private TextView hAx;
    private TextView hAy;
    private TextView hAz;
    private View hsk;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.hAB = new ImageView[4];
        this.hAC = new TextView[4];
        this.hAD = new TextView[4];
        this.hAE = new String[4];
        this.mNavigationBar = null;
        this.hAo = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.hsk.setOnClickListener(this.hAo);
        this.hAF.setOnClickListener(this.hAo);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.hAp = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.hAq = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.hAr = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.hAs = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.hAt = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.hAu = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.hAw = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.hAx = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.hAo.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.hAx.setText(spannableString);
        this.hAv = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.hAy = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.hAz = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.hAA = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.hAD[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.hAD[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.hAD[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.hAB[1] = this.hAp;
        this.hAB[2] = this.hAq;
        this.hAB[3] = this.hAr;
        this.hAE[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.hAE[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.hAE[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.hAC[1] = this.hAy;
        this.hAC[2] = this.hAz;
        this.hAC[3] = this.hAA;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hAo.getResources().getString(R.string.group_info_grade));
        this.hsk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hAF = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.hAG = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.hAF.setVisibility(8);
            this.hAG.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.hAs.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.hAs, R.color.common_color_10167, 1);
        } else {
            this.hAs.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.hAs, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.hAF.setVisibility(8);
            this.hAG.setVisibility(8);
            return;
        }
        this.hAF.setVisibility(0);
        this.hAG.setVisibility(0);
        if (z3 && i > 0) {
            this.hAF.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.hAF, R.color.cp_cont_a, 1);
            this.hAF.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.hAF.setEnabled(false);
            am.setViewTextColor(this.hAF, R.color.common_color_10172, 1);
        }
        this.hAG.setText(string);
    }

    public View bUZ() {
        return this.hsk;
    }

    public TextView bVa() {
        return this.hAF;
    }

    public void onChangeSkinType(int i) {
        this.hAo.getLayoutMode().setNightMode(i == 1);
        this.hAo.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hAo.getPageContext(), i);
    }

    public TextView[] bVb() {
        return this.hAC;
    }

    public TextView[] bVc() {
        return this.hAD;
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
                am.setImageResource(this.hAB[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.hAB[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.hAB[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.hAB[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.hAt.setText(this.hAE[i]);
    }

    public TextView bVd() {
        return this.hAv;
    }

    public void Q(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.hAw.setVisibility(0);
            this.hAu.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.hAo.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.hAo.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hAw.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.hAw.setVisibility(8);
            this.hAu.setVisibility(0);
            this.hAu.setText(R.string.grouplevel_highest_grade);
        }
    }
}
