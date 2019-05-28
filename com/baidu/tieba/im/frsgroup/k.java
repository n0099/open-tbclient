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
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View bBg;
    private GroupLevelActivity gAD;
    private ImageView gAE;
    private ImageView gAF;
    private ImageView gAG;
    private TextView gAH;
    private TextView gAI;
    private TextView gAJ;
    private TextView gAK;
    private TextView gAL;
    private TextView gAM;
    private TextView gAN;
    private TextView gAO;
    private TextView gAP;
    private ImageView[] gAQ;
    private TextView[] gAR;
    private TextView[] gAS;
    private String[] gAT;
    private TextView gAU;
    private TextView gAV;
    private View gsu;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gAQ = new ImageView[4];
        this.gAR = new TextView[4];
        this.gAS = new TextView[4];
        this.gAT = new String[4];
        this.mNavigationBar = null;
        this.gAD = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gsu.setOnClickListener(this.gAD);
        this.gAU.setOnClickListener(this.gAD);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.bBg = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gAE = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gAF = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gAG = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gAH = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gAI = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gAJ = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gAL = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gAM = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gAD.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gAM.setText(spannableString);
        this.gAK = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gAN = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gAO = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gAP = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gAS[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gAS[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gAS[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gAQ[1] = this.gAE;
        this.gAQ[2] = this.gAF;
        this.gAQ[3] = this.gAG;
        this.gAT[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gAT[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gAT[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gAR[1] = this.gAN;
        this.gAR[2] = this.gAO;
        this.gAR[3] = this.gAP;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gAD.getResources().getString(R.string.group_info_grade));
        this.gsu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAU = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gAV = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gAU.setVisibility(8);
            this.gAV.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gAH.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            al.f(this.gAH, R.color.common_color_10167, 1);
        } else {
            this.gAH.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            al.f(this.gAH, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gAU.setVisibility(8);
            this.gAV.setVisibility(8);
            return;
        }
        this.gAU.setVisibility(0);
        this.gAV.setVisibility(0);
        if (z3 && i > 0) {
            this.gAU.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            al.f(this.gAU, R.color.cp_btn_a, 1);
            this.gAU.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gAU.setEnabled(false);
            al.f(this.gAU, R.color.common_color_10172, 1);
        }
        this.gAV.setText(string);
    }

    public View bAI() {
        return this.gsu;
    }

    public TextView bAJ() {
        return this.gAU;
    }

    public void onChangeSkinType(int i) {
        this.gAD.getLayoutMode().setNightMode(i == 1);
        this.gAD.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.gAD.getPageContext(), i);
    }

    public TextView[] bAK() {
        return this.gAR;
    }

    public TextView[] bAL() {
        return this.gAS;
    }

    public void lQ(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void I(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                al.c(this.gAQ[i2], (int) R.drawable.icon_grade_big_star_s);
            } else {
                al.c(this.gAQ[i2], (int) R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                al.c(this.gAQ[i2], (int) R.drawable.icon_grade_big_star_n);
            } else {
                al.c(this.gAQ[i2], (int) R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gAI.setText(this.gAT[i]);
    }

    public TextView bAM() {
        return this.gAK;
    }

    public void W(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gAL.setVisibility(0);
            this.gAJ.setVisibility(8);
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gAD.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gAD.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gAL.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gAL.setVisibility(8);
            this.gAJ.setVisibility(0);
            this.gAJ.setText(R.string.grouplevel_highest_grade);
        }
    }
}
