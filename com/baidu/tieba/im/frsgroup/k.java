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
    private GroupLevelActivity hAA;
    private ImageView hAB;
    private ImageView hAC;
    private ImageView hAD;
    private TextView hAE;
    private TextView hAF;
    private TextView hAG;
    private TextView hAH;
    private TextView hAI;
    private TextView hAJ;
    private TextView hAK;
    private TextView hAL;
    private TextView hAM;
    private ImageView[] hAN;
    private TextView[] hAO;
    private TextView[] hAP;
    private String[] hAQ;
    private TextView hAR;
    private TextView hAS;
    private View hsw;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.hAN = new ImageView[4];
        this.hAO = new TextView[4];
        this.hAP = new TextView[4];
        this.hAQ = new String[4];
        this.mNavigationBar = null;
        this.hAA = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.hsw.setOnClickListener(this.hAA);
        this.hAR.setOnClickListener(this.hAA);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.hAB = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.hAC = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.hAD = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.hAE = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.hAF = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.hAG = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.hAI = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.hAJ = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.hAA.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.hAJ.setText(spannableString);
        this.hAH = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.hAK = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.hAL = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.hAM = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.hAP[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.hAP[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.hAP[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.hAN[1] = this.hAB;
        this.hAN[2] = this.hAC;
        this.hAN[3] = this.hAD;
        this.hAQ[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.hAQ[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.hAQ[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.hAO[1] = this.hAK;
        this.hAO[2] = this.hAL;
        this.hAO[3] = this.hAM;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hAA.getResources().getString(R.string.group_info_grade));
        this.hsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hAR = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.hAS = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.hAR.setVisibility(8);
            this.hAS.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.hAE.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.hAE, R.color.common_color_10167, 1);
        } else {
            this.hAE.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.hAE, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.hAR.setVisibility(8);
            this.hAS.setVisibility(8);
            return;
        }
        this.hAR.setVisibility(0);
        this.hAS.setVisibility(0);
        if (z3 && i > 0) {
            this.hAR.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.hAR, R.color.cp_cont_a, 1);
            this.hAR.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.hAR.setEnabled(false);
            am.setViewTextColor(this.hAR, R.color.common_color_10172, 1);
        }
        this.hAS.setText(string);
    }

    public View bVa() {
        return this.hsw;
    }

    public TextView bVb() {
        return this.hAR;
    }

    public void onChangeSkinType(int i) {
        this.hAA.getLayoutMode().setNightMode(i == 1);
        this.hAA.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hAA.getPageContext(), i);
    }

    public TextView[] bVc() {
        return this.hAO;
    }

    public TextView[] bVd() {
        return this.hAP;
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
                am.setImageResource(this.hAN[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.hAN[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.hAN[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.hAN[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.hAF.setText(this.hAQ[i]);
    }

    public TextView bVe() {
        return this.hAH;
    }

    public void Q(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.hAI.setVisibility(0);
            this.hAG.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.hAA.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.hAA.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hAI.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.hAI.setVisibility(8);
            this.hAG.setVisibility(0);
            this.hAG.setText(R.string.grouplevel_highest_grade);
        }
    }
}
