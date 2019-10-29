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
    private ImageView gHA;
    private TextView gHB;
    private TextView gHC;
    private TextView gHD;
    private TextView gHE;
    private TextView gHF;
    private TextView gHG;
    private TextView gHH;
    private TextView gHI;
    private TextView gHJ;
    private ImageView[] gHK;
    private TextView[] gHL;
    private TextView[] gHM;
    private String[] gHN;
    private TextView gHO;
    private TextView gHP;
    private GroupLevelActivity gHx;
    private ImageView gHy;
    private ImageView gHz;
    private View gzp;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gHK = new ImageView[4];
        this.gHL = new TextView[4];
        this.gHM = new TextView[4];
        this.gHN = new String[4];
        this.mNavigationBar = null;
        this.gHx = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gzp.setOnClickListener(this.gHx);
        this.gHO.setOnClickListener(this.gHx);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gHy = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gHz = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gHA = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gHB = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gHC = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gHD = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gHF = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gHG = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gHx.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gHG.setText(spannableString);
        this.gHE = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gHH = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gHI = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gHJ = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gHM[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gHM[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gHM[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gHK[1] = this.gHy;
        this.gHK[2] = this.gHz;
        this.gHK[3] = this.gHA;
        this.gHN[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gHN[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gHN[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gHL[1] = this.gHH;
        this.gHL[2] = this.gHI;
        this.gHL[3] = this.gHJ;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gHx.getResources().getString(R.string.group_info_grade));
        this.gzp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gHO = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gHP = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gHO.setVisibility(8);
            this.gHP.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gHB.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.gHB, R.color.common_color_10167, 1);
        } else {
            this.gHB.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.gHB, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gHO.setVisibility(8);
            this.gHP.setVisibility(8);
            return;
        }
        this.gHO.setVisibility(0);
        this.gHP.setVisibility(0);
        if (z3 && i > 0) {
            this.gHO.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.gHO, R.color.cp_cont_a, 1);
            this.gHO.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gHO.setEnabled(false);
            am.setViewTextColor(this.gHO, R.color.common_color_10172, 1);
        }
        this.gHP.setText(string);
    }

    public View bBd() {
        return this.gzp;
    }

    public TextView bBe() {
        return this.gHO;
    }

    public void onChangeSkinType(int i) {
        this.gHx.getLayoutMode().setNightMode(i == 1);
        this.gHx.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gHx.getPageContext(), i);
    }

    public TextView[] bBf() {
        return this.gHL;
    }

    public TextView[] bBg() {
        return this.gHM;
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
                am.setImageResource(this.gHK[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.gHK[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.gHK[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.gHK[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gHC.setText(this.gHN[i]);
    }

    public TextView bBh() {
        return this.gHE;
    }

    public void P(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gHF.setVisibility(0);
            this.gHD.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gHx.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gHx.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gHF.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gHF.setVisibility(8);
            this.gHD.setVisibility(0);
            this.gHD.setText(R.string.grouplevel_highest_grade);
        }
    }
}
