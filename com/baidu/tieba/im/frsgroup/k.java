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
/* loaded from: classes8.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View hqj;
    private ImageView[] hyA;
    private TextView[] hyB;
    private TextView[] hyC;
    private String[] hyD;
    private TextView hyE;
    private TextView hyF;
    private GroupLevelActivity hyn;
    private ImageView hyo;
    private ImageView hyp;
    private ImageView hyq;
    private TextView hyr;
    private TextView hys;
    private TextView hyt;
    private TextView hyu;
    private TextView hyv;
    private TextView hyw;
    private TextView hyx;
    private TextView hyy;
    private TextView hyz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.hyA = new ImageView[4];
        this.hyB = new TextView[4];
        this.hyC = new TextView[4];
        this.hyD = new String[4];
        this.mNavigationBar = null;
        this.hyn = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.hqj.setOnClickListener(this.hyn);
        this.hyE.setOnClickListener(this.hyn);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.hyo = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.hyp = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.hyq = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.hyr = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.hys = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.hyt = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.hyv = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.hyw = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.hyn.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.hyw.setText(spannableString);
        this.hyu = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.hyx = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.hyy = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.hyz = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.hyC[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.hyC[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.hyC[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.hyA[1] = this.hyo;
        this.hyA[2] = this.hyp;
        this.hyA[3] = this.hyq;
        this.hyD[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.hyD[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.hyD[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.hyB[1] = this.hyx;
        this.hyB[2] = this.hyy;
        this.hyB[3] = this.hyz;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hyn.getResources().getString(R.string.group_info_grade));
        this.hqj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hyE = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.hyF = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.hyE.setVisibility(8);
            this.hyF.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.hyr.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.hyr, R.color.common_color_10167, 1);
        } else {
            this.hyr.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.hyr, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.hyE.setVisibility(8);
            this.hyF.setVisibility(8);
            return;
        }
        this.hyE.setVisibility(0);
        this.hyF.setVisibility(0);
        if (z3 && i > 0) {
            this.hyE.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.hyE, R.color.cp_cont_a, 1);
            this.hyE.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.hyE.setEnabled(false);
            am.setViewTextColor(this.hyE, R.color.common_color_10172, 1);
        }
        this.hyF.setText(string);
    }

    public View bTw() {
        return this.hqj;
    }

    public TextView bTx() {
        return this.hyE;
    }

    public void onChangeSkinType(int i) {
        this.hyn.getLayoutMode().setNightMode(i == 1);
        this.hyn.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hyn.getPageContext(), i);
    }

    public TextView[] bTy() {
        return this.hyB;
    }

    public TextView[] bTz() {
        return this.hyC;
    }

    public void nw(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void L(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.setImageResource(this.hyA[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.hyA[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.hyA[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.hyA[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.hys.setText(this.hyD[i]);
    }

    public TextView bTA() {
        return this.hyu;
    }

    public void P(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.hyv.setVisibility(0);
            this.hyt.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.hyn.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.hyn.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hyv.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.hyv.setVisibility(8);
            this.hyt.setVisibility(0);
            this.hyt.setText(R.string.grouplevel_highest_grade);
        }
    }
}
