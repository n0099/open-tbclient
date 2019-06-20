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
    private GroupLevelActivity gAF;
    private ImageView gAG;
    private ImageView gAH;
    private ImageView gAI;
    private TextView gAJ;
    private TextView gAK;
    private TextView gAL;
    private TextView gAM;
    private TextView gAN;
    private TextView gAO;
    private TextView gAP;
    private TextView gAQ;
    private TextView gAR;
    private ImageView[] gAS;
    private TextView[] gAT;
    private TextView[] gAU;
    private String[] gAV;
    private TextView gAW;
    private TextView gAX;
    private View gsw;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gAS = new ImageView[4];
        this.gAT = new TextView[4];
        this.gAU = new TextView[4];
        this.gAV = new String[4];
        this.mNavigationBar = null;
        this.gAF = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gsw.setOnClickListener(this.gAF);
        this.gAW.setOnClickListener(this.gAF);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.bBg = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gAG = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gAH = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gAI = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gAJ = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gAK = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gAL = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gAN = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gAO = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gAF.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gAO.setText(spannableString);
        this.gAM = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gAP = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gAQ = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gAR = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gAU[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gAU[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gAU[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gAS[1] = this.gAG;
        this.gAS[2] = this.gAH;
        this.gAS[3] = this.gAI;
        this.gAV[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gAV[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gAV[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gAT[1] = this.gAP;
        this.gAT[2] = this.gAQ;
        this.gAT[3] = this.gAR;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gAF.getResources().getString(R.string.group_info_grade));
        this.gsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gAW = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gAX = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gAW.setVisibility(8);
            this.gAX.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gAJ.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            al.f(this.gAJ, R.color.common_color_10167, 1);
        } else {
            this.gAJ.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            al.f(this.gAJ, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gAW.setVisibility(8);
            this.gAX.setVisibility(8);
            return;
        }
        this.gAW.setVisibility(0);
        this.gAX.setVisibility(0);
        if (z3 && i > 0) {
            this.gAW.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            al.f(this.gAW, R.color.cp_btn_a, 1);
            this.gAW.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gAW.setEnabled(false);
            al.f(this.gAW, R.color.common_color_10172, 1);
        }
        this.gAX.setText(string);
    }

    public View bAJ() {
        return this.gsw;
    }

    public TextView bAK() {
        return this.gAW;
    }

    public void onChangeSkinType(int i) {
        this.gAF.getLayoutMode().setNightMode(i == 1);
        this.gAF.getLayoutMode().onModeChanged(this.bBg);
        this.mNavigationBar.onChangeSkinType(this.gAF.getPageContext(), i);
    }

    public TextView[] bAL() {
        return this.gAT;
    }

    public TextView[] bAM() {
        return this.gAU;
    }

    public void lR(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void I(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                al.c(this.gAS[i2], (int) R.drawable.icon_grade_big_star_s);
            } else {
                al.c(this.gAS[i2], (int) R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                al.c(this.gAS[i2], (int) R.drawable.icon_grade_big_star_n);
            } else {
                al.c(this.gAS[i2], (int) R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gAK.setText(this.gAV[i]);
    }

    public TextView bAN() {
        return this.gAM;
    }

    public void W(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gAN.setVisibility(0);
            this.gAL.setVisibility(8);
            int color = al.getColor(R.color.cp_cont_b);
            int color2 = al.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gAF.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gAF.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gAN.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gAN.setVisibility(8);
            this.gAL.setVisibility(0);
            this.gAL.setText(R.string.grouplevel_highest_grade);
        }
    }
}
