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
    private GroupLevelActivity iAC;
    private ImageView iAD;
    private ImageView iAE;
    private ImageView iAF;
    private TextView iAG;
    private TextView iAH;
    private TextView iAI;
    private TextView iAJ;
    private TextView iAK;
    private TextView iAL;
    private TextView iAM;
    private TextView iAN;
    private TextView iAO;
    private ImageView[] iAP;
    private TextView[] iAQ;
    private TextView[] iAR;
    private String[] iAS;
    private TextView iAT;
    private TextView iAU;
    private boolean isMem;
    private View isy;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.iAP = new ImageView[4];
        this.iAQ = new TextView[4];
        this.iAR = new TextView[4];
        this.iAS = new String[4];
        this.mNavigationBar = null;
        this.iAC = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.isy.setOnClickListener(this.iAC);
        this.iAT.setOnClickListener(this.iAC);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.iAD = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.iAE = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.iAF = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.iAG = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.iAH = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.iAI = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.iAK = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.iAL = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.iAC.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.iAL.setText(spannableString);
        this.iAJ = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.iAM = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.iAN = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.iAO = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.iAR[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.iAR[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.iAR[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.iAP[1] = this.iAD;
        this.iAP[2] = this.iAE;
        this.iAP[3] = this.iAF;
        this.iAS[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.iAS[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.iAS[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.iAQ[1] = this.iAM;
        this.iAQ[2] = this.iAN;
        this.iAQ[3] = this.iAO;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.iAC.getResources().getString(R.string.group_info_grade));
        this.isy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iAT = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.iAU = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.iAT.setVisibility(8);
            this.iAU.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.iAG.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.iAG, R.color.common_color_10167, 1);
        } else {
            this.iAG.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.iAG, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.iAT.setVisibility(8);
            this.iAU.setVisibility(8);
            return;
        }
        this.iAT.setVisibility(0);
        this.iAU.setVisibility(0);
        if (z3 && i > 0) {
            this.iAT.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.iAT, R.color.cp_cont_a, 1);
            this.iAT.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.iAT.setEnabled(false);
            am.setViewTextColor(this.iAT, R.color.common_color_10172, 1);
        }
        this.iAU.setText(string);
    }

    public View cmp() {
        return this.isy;
    }

    public TextView cmq() {
        return this.iAT;
    }

    public void onChangeSkinType(int i) {
        this.iAC.getLayoutMode().setNightMode(i == 1);
        this.iAC.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iAC.getPageContext(), i);
    }

    public TextView[] cmr() {
        return this.iAQ;
    }

    public TextView[] cms() {
        return this.iAR;
    }

    public void pe(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void T(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.setImageResource(this.iAP[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.iAP[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.iAP[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.iAP[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.iAH.setText(this.iAS[i]);
    }

    public TextView cmt() {
        return this.iAJ;
    }

    public void T(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.iAK.setVisibility(0);
            this.iAI.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.iAC.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.iAC.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.iAK.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.iAK.setVisibility(8);
            this.iAI.setVisibility(0);
            this.iAI.setText(R.string.grouplevel_highest_grade);
        }
    }
}
