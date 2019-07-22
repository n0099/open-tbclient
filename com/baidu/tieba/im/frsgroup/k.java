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
    private GroupLevelActivity gGP;
    private ImageView gGQ;
    private ImageView gGR;
    private ImageView gGS;
    private TextView gGT;
    private TextView gGU;
    private TextView gGV;
    private TextView gGW;
    private TextView gGX;
    private TextView gGY;
    private TextView gGZ;
    private TextView gHa;
    private TextView gHb;
    private ImageView[] gHc;
    private TextView[] gHd;
    private TextView[] gHe;
    private String[] gHf;
    private TextView gHg;
    private TextView gHh;
    private View gyH;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gHc = new ImageView[4];
        this.gHd = new TextView[4];
        this.gHe = new TextView[4];
        this.gHf = new String[4];
        this.mNavigationBar = null;
        this.gGP = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gyH.setOnClickListener(this.gGP);
        this.gHg.setOnClickListener(this.gGP);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gGQ = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gGR = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gGS = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gGT = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gGU = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gGV = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gGX = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gGY = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gGP.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gGY.setText(spannableString);
        this.gGW = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gGZ = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gHa = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gHb = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gHe[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gHe[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gHe[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gHc[1] = this.gGQ;
        this.gHc[2] = this.gGR;
        this.gHc[3] = this.gGS;
        this.gHf[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gHf[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gHf[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gHd[1] = this.gGZ;
        this.gHd[2] = this.gHa;
        this.gHd[3] = this.gHb;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gGP.getResources().getString(R.string.group_info_grade));
        this.gyH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gHg = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gHh = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gHg.setVisibility(8);
            this.gHh.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gGT.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.f(this.gGT, R.color.common_color_10167, 1);
        } else {
            this.gGT.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.f(this.gGT, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gHg.setVisibility(8);
            this.gHh.setVisibility(8);
            return;
        }
        this.gHg.setVisibility(0);
        this.gHh.setVisibility(0);
        if (z3 && i > 0) {
            this.gHg.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.f(this.gHg, R.color.cp_btn_a, 1);
            this.gHg.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gHg.setEnabled(false);
            am.f(this.gHg, R.color.common_color_10172, 1);
        }
        this.gHh.setText(string);
    }

    public View bDq() {
        return this.gyH;
    }

    public TextView bDr() {
        return this.gHg;
    }

    public void onChangeSkinType(int i) {
        this.gGP.getLayoutMode().setNightMode(i == 1);
        this.gGP.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gGP.getPageContext(), i);
    }

    public TextView[] bDs() {
        return this.gHd;
    }

    public TextView[] bDt() {
        return this.gHe;
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
                am.c(this.gHc[i2], (int) R.drawable.icon_grade_big_star_s);
            } else {
                am.c(this.gHc[i2], (int) R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.c(this.gHc[i2], (int) R.drawable.icon_grade_big_star_n);
            } else {
                am.c(this.gHc[i2], (int) R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gGU.setText(this.gHf[i]);
    }

    public TextView bDu() {
        return this.gGW;
    }

    public void X(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gGX.setVisibility(0);
            this.gGV.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gGP.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gGP.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gGX.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gGX.setVisibility(8);
            this.gGV.setVisibility(0);
            this.gGV.setText(R.string.grouplevel_highest_grade);
        }
    }
}
