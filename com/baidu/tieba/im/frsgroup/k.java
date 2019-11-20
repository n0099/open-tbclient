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
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private GroupLevelActivity gGG;
    private ImageView gGH;
    private ImageView gGI;
    private ImageView gGJ;
    private TextView gGK;
    private TextView gGL;
    private TextView gGM;
    private TextView gGN;
    private TextView gGO;
    private TextView gGP;
    private TextView gGQ;
    private TextView gGR;
    private TextView gGS;
    private ImageView[] gGT;
    private TextView[] gGU;
    private TextView[] gGV;
    private String[] gGW;
    private TextView gGX;
    private TextView gGY;
    private View gyy;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gGT = new ImageView[4];
        this.gGU = new TextView[4];
        this.gGV = new TextView[4];
        this.gGW = new String[4];
        this.mNavigationBar = null;
        this.gGG = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gyy.setOnClickListener(this.gGG);
        this.gGX.setOnClickListener(this.gGG);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gGH = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gGI = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gGJ = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gGK = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gGL = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gGM = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gGO = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gGP = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gGG.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gGP.setText(spannableString);
        this.gGN = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gGQ = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gGR = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gGS = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gGV[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gGV[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gGV[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gGT[1] = this.gGH;
        this.gGT[2] = this.gGI;
        this.gGT[3] = this.gGJ;
        this.gGW[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gGW[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gGW[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gGU[1] = this.gGQ;
        this.gGU[2] = this.gGR;
        this.gGU[3] = this.gGS;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gGG.getResources().getString(R.string.group_info_grade));
        this.gyy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gGX = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gGY = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gGX.setVisibility(8);
            this.gGY.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gGK.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.gGK, R.color.common_color_10167, 1);
        } else {
            this.gGK.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.gGK, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gGX.setVisibility(8);
            this.gGY.setVisibility(8);
            return;
        }
        this.gGX.setVisibility(0);
        this.gGY.setVisibility(0);
        if (z3 && i > 0) {
            this.gGX.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.gGX, R.color.cp_cont_a, 1);
            this.gGX.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gGX.setEnabled(false);
            am.setViewTextColor(this.gGX, R.color.common_color_10172, 1);
        }
        this.gGY.setText(string);
    }

    public View bBb() {
        return this.gyy;
    }

    public TextView bBc() {
        return this.gGX;
    }

    public void onChangeSkinType(int i) {
        this.gGG.getLayoutMode().setNightMode(i == 1);
        this.gGG.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gGG.getPageContext(), i);
    }

    public TextView[] bBd() {
        return this.gGU;
    }

    public TextView[] bBe() {
        return this.gGV;
    }

    public void lW(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void J(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.setImageResource(this.gGT[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.gGT[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.gGT[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.gGT[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gGL.setText(this.gGW[i]);
    }

    public TextView bBf() {
        return this.gGN;
    }

    public void P(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gGO.setVisibility(0);
            this.gGM.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gGG.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gGG.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gGO.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gGO.setVisibility(8);
            this.gGM.setVisibility(0);
            this.gGM.setText(R.string.grouplevel_highest_grade);
        }
    }
}
