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
    private GroupLevelActivity gAC;
    private ImageView gAD;
    private ImageView gAE;
    private ImageView gAF;
    private TextView gAG;
    private TextView gAH;
    private TextView gAI;
    private TextView gAJ;
    private TextView gAK;
    private TextView gAL;
    private TextView gAM;
    private TextView gAN;
    private TextView gAO;
    private ImageView[] gAP;
    private TextView[] gAQ;
    private TextView[] gAR;
    private String[] gAS;
    private TextView gAT;
    private TextView gAU;
    private View gst;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gAP = new ImageView[4];
        this.gAQ = new TextView[4];
        this.gAR = new TextView[4];
        this.gAS = new String[4];
        this.mNavigationBar = null;
        this.gAC = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gst.setOnClickListener(this.gAC);
        this.gAT.setOnClickListener(this.gAC);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.bBg = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gAD = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gAE = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gAF = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gAG = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gAH = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gAI = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gAK = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gAL = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gAC.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gAL.setText(spannableString);
        this.gAJ = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gAM = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gAN = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gAO = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gAR[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gAR[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gAR[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gAP[1] = this.gAD;
        this.gAP[2] = this.gAE;
        this.gAP[3] = this.gAF;
        this.gAS[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gAS[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gAS[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gAQ[1] = this.gAM;
        this.gAQ[2] = this.gAN;
        this.gAQ[3] = this.gAO;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gAC.getResources().getString(R.string.group_info_grade));
        this.gst = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAT = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gAU = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gAT.setVisibility(8);
            this.gAU.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gAG.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            al.f(this.gAG, R.color.common_color_10167, 1);
        } else {
            this.gAG.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            al.f(this.gAG, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gAT.setVisibility(8);
            this.gAU.setVisibility(8);
            return;
        }
        this.gAT.setVisibility(0);
        this.gAU.setVisibility(0);
        if (z3 && i > 0) {
            this.gAT.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            al.f(this.gAT, R.color.cp_btn_a, 1);
            this.gAT.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gAT.setEnabled(false);
            al.f(this.gAT, R.color.common_color_10172, 1);
        }
        this.gAU.setText(string);
    }

    public View bAF() {
        return this.gst;
    }

    public TextView bAG() {
        return this.gAT;
    }

    public void onChangeSkinType(int i) {
        this.gAC.getLayoutMode().setNightMode(i == 1);
        this.gAC.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.gAC.getPageContext(), i);
    }

    public TextView[] bAH() {
        return this.gAQ;
    }

    public TextView[] bAI() {
        return this.gAR;
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
                al.c(this.gAP[i2], (int) R.drawable.icon_grade_big_star_s);
            } else {
                al.c(this.gAP[i2], (int) R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                al.c(this.gAP[i2], (int) R.drawable.icon_grade_big_star_n);
            } else {
                al.c(this.gAP[i2], (int) R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gAH.setText(this.gAS[i]);
    }

    public TextView bAJ() {
        return this.gAJ;
    }

    public void W(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gAK.setVisibility(0);
            this.gAI.setVisibility(8);
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gAC.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gAC.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gAK.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gAK.setVisibility(8);
            this.gAI.setVisibility(0);
            this.gAI.setText(R.string.grouplevel_highest_grade);
        }
    }
}
