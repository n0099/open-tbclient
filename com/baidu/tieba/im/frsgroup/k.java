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
/* loaded from: classes7.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View hmG;
    private GroupLevelActivity huK;
    private ImageView huL;
    private ImageView huM;
    private ImageView huN;
    private TextView huO;
    private TextView huP;
    private TextView huQ;
    private TextView huR;
    private TextView huS;
    private TextView huT;
    private TextView huU;
    private TextView huV;
    private TextView huW;
    private ImageView[] huX;
    private TextView[] huY;
    private TextView[] huZ;
    private String[] hva;
    private TextView hvb;
    private TextView hvc;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.huX = new ImageView[4];
        this.huY = new TextView[4];
        this.huZ = new TextView[4];
        this.hva = new String[4];
        this.mNavigationBar = null;
        this.huK = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.hmG.setOnClickListener(this.huK);
        this.hvb.setOnClickListener(this.huK);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.huL = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.huM = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.huN = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.huO = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.huP = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.huQ = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.huS = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.huT = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.huK.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.huT.setText(spannableString);
        this.huR = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.huU = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.huV = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.huW = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.huZ[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.huZ[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.huZ[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.huX[1] = this.huL;
        this.huX[2] = this.huM;
        this.huX[3] = this.huN;
        this.hva[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.hva[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.hva[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.huY[1] = this.huU;
        this.huY[2] = this.huV;
        this.huY[3] = this.huW;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.huK.getResources().getString(R.string.group_info_grade));
        this.hmG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hvb = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.hvc = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.hvb.setVisibility(8);
            this.hvc.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.huO.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.huO, R.color.common_color_10167, 1);
        } else {
            this.huO.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.huO, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.hvb.setVisibility(8);
            this.hvc.setVisibility(8);
            return;
        }
        this.hvb.setVisibility(0);
        this.hvc.setVisibility(0);
        if (z3 && i > 0) {
            this.hvb.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.hvb, R.color.cp_cont_a, 1);
            this.hvb.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.hvb.setEnabled(false);
            am.setViewTextColor(this.hvb, R.color.common_color_10172, 1);
        }
        this.hvc.setText(string);
    }

    public View bSn() {
        return this.hmG;
    }

    public TextView bSo() {
        return this.hvb;
    }

    public void onChangeSkinType(int i) {
        this.huK.getLayoutMode().setNightMode(i == 1);
        this.huK.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.huK.getPageContext(), i);
    }

    public TextView[] bSp() {
        return this.huY;
    }

    public TextView[] bSq() {
        return this.huZ;
    }

    public void nk(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void L(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.setImageResource(this.huX[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.huX[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.huX[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.huX[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.huP.setText(this.hva[i]);
    }

    public TextView bSr() {
        return this.huR;
    }

    public void P(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.huS.setVisibility(0);
            this.huQ.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.huK.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.huK.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.huS.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.huS.setVisibility(8);
            this.huQ.setVisibility(0);
            this.huQ.setText(R.string.grouplevel_highest_grade);
        }
    }
}
