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
    private GroupLevelActivity gHH;
    private ImageView gHI;
    private ImageView gHJ;
    private ImageView gHK;
    private TextView gHL;
    private TextView gHM;
    private TextView gHN;
    private TextView gHO;
    private TextView gHP;
    private TextView gHQ;
    private TextView gHR;
    private TextView gHS;
    private TextView gHT;
    private ImageView[] gHU;
    private TextView[] gHV;
    private TextView[] gHW;
    private String[] gHX;
    private TextView gHY;
    private TextView gHZ;
    private View gzz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gHU = new ImageView[4];
        this.gHV = new TextView[4];
        this.gHW = new TextView[4];
        this.gHX = new String[4];
        this.mNavigationBar = null;
        this.gHH = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gzz.setOnClickListener(this.gHH);
        this.gHY.setOnClickListener(this.gHH);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gHI = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gHJ = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gHK = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gHL = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gHM = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gHN = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gHP = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gHQ = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gHH.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gHQ.setText(spannableString);
        this.gHO = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gHR = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gHS = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gHT = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gHW[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gHW[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gHW[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gHU[1] = this.gHI;
        this.gHU[2] = this.gHJ;
        this.gHU[3] = this.gHK;
        this.gHX[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gHX[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gHX[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gHV[1] = this.gHR;
        this.gHV[2] = this.gHS;
        this.gHV[3] = this.gHT;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gHH.getResources().getString(R.string.group_info_grade));
        this.gzz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gHY = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gHZ = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gHY.setVisibility(8);
            this.gHZ.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gHL.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.f(this.gHL, R.color.common_color_10167, 1);
        } else {
            this.gHL.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.f(this.gHL, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gHY.setVisibility(8);
            this.gHZ.setVisibility(8);
            return;
        }
        this.gHY.setVisibility(0);
        this.gHZ.setVisibility(0);
        if (z3 && i > 0) {
            this.gHY.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.f(this.gHY, R.color.cp_btn_a, 1);
            this.gHY.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gHY.setEnabled(false);
            am.f(this.gHY, R.color.common_color_10172, 1);
        }
        this.gHZ.setText(string);
    }

    public View bDE() {
        return this.gzz;
    }

    public TextView bDF() {
        return this.gHY;
    }

    public void onChangeSkinType(int i) {
        this.gHH.getLayoutMode().setNightMode(i == 1);
        this.gHH.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gHH.getPageContext(), i);
    }

    public TextView[] bDG() {
        return this.gHV;
    }

    public TextView[] bDH() {
        return this.gHW;
    }

    public void mf(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void K(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.c(this.gHU[i2], (int) R.drawable.icon_grade_big_star_s);
            } else {
                am.c(this.gHU[i2], (int) R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.c(this.gHU[i2], (int) R.drawable.icon_grade_big_star_n);
            } else {
                am.c(this.gHU[i2], (int) R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gHM.setText(this.gHX[i]);
    }

    public TextView bDI() {
        return this.gHO;
    }

    public void X(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gHP.setVisibility(0);
            this.gHN.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gHH.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gHH.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gHP.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gHP.setVisibility(8);
            this.gHN.setVisibility(0);
            this.gHN.setText(R.string.grouplevel_highest_grade);
        }
    }
}
