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
    private TextView iBA;
    private TextView iBB;
    private ImageView[] iBC;
    private TextView[] iBD;
    private TextView[] iBE;
    private String[] iBF;
    private TextView iBG;
    private TextView iBH;
    private GroupLevelActivity iBp;
    private ImageView iBq;
    private ImageView iBr;
    private ImageView iBs;
    private TextView iBt;
    private TextView iBu;
    private TextView iBv;
    private TextView iBw;
    private TextView iBx;
    private TextView iBy;
    private TextView iBz;
    private boolean isMem;
    private View itl;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.iBC = new ImageView[4];
        this.iBD = new TextView[4];
        this.iBE = new TextView[4];
        this.iBF = new String[4];
        this.mNavigationBar = null;
        this.iBp = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.itl.setOnClickListener(this.iBp);
        this.iBG.setOnClickListener(this.iBp);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.iBq = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.iBr = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.iBs = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.iBt = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.iBu = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.iBv = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.iBx = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.iBy = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.iBp.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.iBy.setText(spannableString);
        this.iBw = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.iBz = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.iBA = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.iBB = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.iBE[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.iBE[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.iBE[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.iBC[1] = this.iBq;
        this.iBC[2] = this.iBr;
        this.iBC[3] = this.iBs;
        this.iBF[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.iBF[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.iBF[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.iBD[1] = this.iBz;
        this.iBD[2] = this.iBA;
        this.iBD[3] = this.iBB;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.iBp.getResources().getString(R.string.group_info_grade));
        this.itl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iBG = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.iBH = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.iBG.setVisibility(8);
            this.iBH.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.iBt.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.iBt, R.color.common_color_10167, 1);
        } else {
            this.iBt.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.iBt, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.iBG.setVisibility(8);
            this.iBH.setVisibility(8);
            return;
        }
        this.iBG.setVisibility(0);
        this.iBH.setVisibility(0);
        if (z3 && i > 0) {
            this.iBG.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.iBG, R.color.cp_cont_a, 1);
            this.iBG.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.iBG.setEnabled(false);
            am.setViewTextColor(this.iBG, R.color.common_color_10172, 1);
        }
        this.iBH.setText(string);
    }

    public View cmy() {
        return this.itl;
    }

    public TextView cmz() {
        return this.iBG;
    }

    public void onChangeSkinType(int i) {
        this.iBp.getLayoutMode().setNightMode(i == 1);
        this.iBp.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iBp.getPageContext(), i);
    }

    public TextView[] cmA() {
        return this.iBD;
    }

    public TextView[] cmB() {
        return this.iBE;
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
                am.setImageResource(this.iBC[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.iBC[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.iBC[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.iBC[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.iBu.setText(this.iBF[i]);
    }

    public TextView cmC() {
        return this.iBw;
    }

    public void T(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.iBx.setVisibility(0);
            this.iBv.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.iBp.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.iBp.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.iBx.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.iBx.setVisibility(8);
            this.iBv.setVisibility(0);
            this.iBv.setText(R.string.grouplevel_highest_grade);
        }
    }
}
