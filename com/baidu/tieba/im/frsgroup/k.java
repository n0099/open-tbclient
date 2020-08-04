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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes17.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View iQy;
    private boolean isMem;
    private GroupLevelActivity jaG;
    private ImageView jaH;
    private ImageView jaI;
    private ImageView jaJ;
    private TextView jaK;
    private TextView jaL;
    private TextView jaM;
    private TextView jaN;
    private TextView jaO;
    private TextView jaP;
    private TextView jaQ;
    private TextView jaR;
    private TextView jaS;
    private ImageView[] jaT;
    private TextView[] jaU;
    private TextView[] jaV;
    private String[] jaW;
    private TextView jaX;
    private TextView jaY;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.jaT = new ImageView[4];
        this.jaU = new TextView[4];
        this.jaV = new TextView[4];
        this.jaW = new String[4];
        this.mNavigationBar = null;
        this.jaG = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.iQy.setOnClickListener(this.jaG);
        this.jaX.setOnClickListener(this.jaG);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.jaH = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.jaI = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.jaJ = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.jaK = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.jaL = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.jaM = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.jaO = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.jaP = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.jaG.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.jaP.setText(spannableString);
        this.jaN = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.jaQ = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.jaR = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.jaS = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.jaV[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.jaV[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.jaV[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.jaT[1] = this.jaH;
        this.jaT[2] = this.jaI;
        this.jaT[3] = this.jaJ;
        this.jaW[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.jaW[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.jaW[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.jaU[1] = this.jaQ;
        this.jaU[2] = this.jaR;
        this.jaU[3] = this.jaS;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jaG.getResources().getString(R.string.group_info_grade));
        this.iQy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jaX = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.jaY = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.jaX.setVisibility(8);
            this.jaY.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.jaK.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ao.setViewTextColor(this.jaK, R.color.common_color_10167, 1);
        } else {
            this.jaK.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ao.setViewTextColor(this.jaK, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.jaX.setVisibility(8);
            this.jaY.setVisibility(8);
            return;
        }
        this.jaX.setVisibility(0);
        this.jaY.setVisibility(0);
        if (z3 && i > 0) {
            this.jaX.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ao.setViewTextColor(this.jaX, R.color.cp_cont_a, 1);
            this.jaX.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.jaX.setEnabled(false);
            ao.setViewTextColor(this.jaX, R.color.common_color_10172, 1);
        }
        this.jaY.setText(string);
    }

    public View cum() {
        return this.iQy;
    }

    public TextView cun() {
        return this.jaX;
    }

    public void onChangeSkinType(int i) {
        this.jaG.getLayoutMode().setNightMode(i == 1);
        this.jaG.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jaG.getPageContext(), i);
    }

    public TextView[] cuo() {
        return this.jaU;
    }

    public TextView[] cup() {
        return this.jaV;
    }

    public void pV(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void W(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = R.drawable.icon_grade_big_star_s;
        int i4 = R.drawable.icon_grade_big_star_n;
        int i5 = R.drawable.icon_vip_grade_big_star_s;
        int i6 = R.drawable.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                ao.setImageResource(this.jaT[i2], i5);
            } else {
                ao.setImageResource(this.jaT[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ao.setImageResource(this.jaT[i2], i6);
            } else {
                ao.setImageResource(this.jaT[i2], i4);
            }
            i2++;
        }
        this.jaL.setText(this.jaW[i]);
    }

    public TextView cuq() {
        return this.jaN;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.jaO.setVisibility(0);
            this.jaM.setVisibility(8);
            int color = ao.getColor(R.color.cp_cont_b);
            int color2 = ao.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.jaG.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.jaG.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.jaO.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.jaO.setVisibility(8);
            this.jaM.setVisibility(0);
            this.jaM.setText(R.string.grouplevel_highest_grade);
        }
    }
}
