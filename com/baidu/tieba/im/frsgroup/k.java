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
    private View iQw;
    private boolean isMem;
    private GroupLevelActivity jaE;
    private ImageView jaF;
    private ImageView jaG;
    private ImageView jaH;
    private TextView jaI;
    private TextView jaJ;
    private TextView jaK;
    private TextView jaL;
    private TextView jaM;
    private TextView jaN;
    private TextView jaO;
    private TextView jaP;
    private TextView jaQ;
    private ImageView[] jaR;
    private TextView[] jaS;
    private TextView[] jaT;
    private String[] jaU;
    private TextView jaV;
    private TextView jaW;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.jaR = new ImageView[4];
        this.jaS = new TextView[4];
        this.jaT = new TextView[4];
        this.jaU = new String[4];
        this.mNavigationBar = null;
        this.jaE = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.iQw.setOnClickListener(this.jaE);
        this.jaV.setOnClickListener(this.jaE);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.jaF = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.jaG = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.jaH = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.jaI = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.jaJ = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.jaK = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.jaM = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.jaN = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.jaE.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.jaN.setText(spannableString);
        this.jaL = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.jaO = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.jaP = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.jaQ = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.jaT[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.jaT[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.jaT[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.jaR[1] = this.jaF;
        this.jaR[2] = this.jaG;
        this.jaR[3] = this.jaH;
        this.jaU[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.jaU[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.jaU[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.jaS[1] = this.jaO;
        this.jaS[2] = this.jaP;
        this.jaS[3] = this.jaQ;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jaE.getResources().getString(R.string.group_info_grade));
        this.iQw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jaV = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.jaW = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.jaV.setVisibility(8);
            this.jaW.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.jaI.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ao.setViewTextColor(this.jaI, R.color.common_color_10167, 1);
        } else {
            this.jaI.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ao.setViewTextColor(this.jaI, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.jaV.setVisibility(8);
            this.jaW.setVisibility(8);
            return;
        }
        this.jaV.setVisibility(0);
        this.jaW.setVisibility(0);
        if (z3 && i > 0) {
            this.jaV.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ao.setViewTextColor(this.jaV, R.color.cp_cont_a, 1);
            this.jaV.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.jaV.setEnabled(false);
            ao.setViewTextColor(this.jaV, R.color.common_color_10172, 1);
        }
        this.jaW.setText(string);
    }

    public View cum() {
        return this.iQw;
    }

    public TextView cun() {
        return this.jaV;
    }

    public void onChangeSkinType(int i) {
        this.jaE.getLayoutMode().setNightMode(i == 1);
        this.jaE.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jaE.getPageContext(), i);
    }

    public TextView[] cuo() {
        return this.jaS;
    }

    public TextView[] cup() {
        return this.jaT;
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
                ao.setImageResource(this.jaR[i2], i5);
            } else {
                ao.setImageResource(this.jaR[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ao.setImageResource(this.jaR[i2], i6);
            } else {
                ao.setImageResource(this.jaR[i2], i4);
            }
            i2++;
        }
        this.jaJ.setText(this.jaU[i]);
    }

    public TextView cuq() {
        return this.jaL;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.jaM.setVisibility(0);
            this.jaK.setVisibility(8);
            int color = ao.getColor(R.color.cp_cont_b);
            int color2 = ao.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.jaE.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.jaE.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.jaM.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.jaM.setVisibility(8);
            this.jaK.setVisibility(0);
            this.jaK.setText(R.string.grouplevel_highest_grade);
        }
    }
}
