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
    private View gBq;
    private ImageView gJA;
    private ImageView gJB;
    private ImageView gJC;
    private TextView gJD;
    private TextView gJE;
    private TextView gJF;
    private TextView gJG;
    private TextView gJH;
    private TextView gJI;
    private TextView gJJ;
    private TextView gJK;
    private TextView gJL;
    private ImageView[] gJM;
    private TextView[] gJN;
    private TextView[] gJO;
    private String[] gJP;
    private TextView gJQ;
    private TextView gJR;
    private GroupLevelActivity gJz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gJM = new ImageView[4];
        this.gJN = new TextView[4];
        this.gJO = new TextView[4];
        this.gJP = new String[4];
        this.mNavigationBar = null;
        this.gJz = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gBq.setOnClickListener(this.gJz);
        this.gJQ.setOnClickListener(this.gJz);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.gJA = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.gJB = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.gJC = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.gJD = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.gJE = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.gJF = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.gJH = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.gJI = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gJz.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gJI.setText(spannableString);
        this.gJG = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.gJJ = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.gJK = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.gJL = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.gJO[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.gJO[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.gJO[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.gJM[1] = this.gJA;
        this.gJM[2] = this.gJB;
        this.gJM[3] = this.gJC;
        this.gJP[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.gJP[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.gJP[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.gJN[1] = this.gJJ;
        this.gJN[2] = this.gJK;
        this.gJN[3] = this.gJL;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gJz.getResources().getString(R.string.group_info_grade));
        this.gBq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gJQ = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.gJR = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gJQ.setVisibility(8);
            this.gJR.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gJD.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.f(this.gJD, R.color.common_color_10167, 1);
        } else {
            this.gJD.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.f(this.gJD, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gJQ.setVisibility(8);
            this.gJR.setVisibility(8);
            return;
        }
        this.gJQ.setVisibility(0);
        this.gJR.setVisibility(0);
        if (z3 && i > 0) {
            this.gJQ.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.f(this.gJQ, R.color.cp_cont_a, 1);
            this.gJQ.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.gJQ.setEnabled(false);
            am.f(this.gJQ, R.color.common_color_10172, 1);
        }
        this.gJR.setText(string);
    }

    public View bEs() {
        return this.gBq;
    }

    public TextView bEt() {
        return this.gJQ;
    }

    public void onChangeSkinType(int i) {
        this.gJz.getLayoutMode().setNightMode(i == 1);
        this.gJz.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.gJz.getPageContext(), i);
    }

    public TextView[] bEu() {
        return this.gJN;
    }

    public TextView[] bEv() {
        return this.gJO;
    }

    public void mi(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void L(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.c(this.gJM[i2], (int) R.drawable.icon_grade_big_star_s);
            } else {
                am.c(this.gJM[i2], (int) R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.c(this.gJM[i2], (int) R.drawable.icon_grade_big_star_n);
            } else {
                am.c(this.gJM[i2], (int) R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.gJE.setText(this.gJP[i]);
    }

    public TextView bEw() {
        return this.gJG;
    }

    public void Y(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gJH.setVisibility(0);
            this.gJF.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gJz.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gJz.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gJH.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gJH.setVisibility(8);
            this.gJF.setVisibility(0);
            this.gJF.setText(R.string.grouplevel_highest_grade);
        }
    }
}
