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
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private GroupLevelActivity hCa;
    private ImageView hCb;
    private ImageView hCc;
    private ImageView hCd;
    private TextView hCe;
    private TextView hCf;
    private TextView hCg;
    private TextView hCh;
    private TextView hCi;
    private TextView hCj;
    private TextView hCk;
    private TextView hCl;
    private TextView hCm;
    private ImageView[] hCn;
    private TextView[] hCo;
    private TextView[] hCp;
    private String[] hCq;
    private TextView hCr;
    private TextView hCs;
    private View htW;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.hCn = new ImageView[4];
        this.hCo = new TextView[4];
        this.hCp = new TextView[4];
        this.hCq = new String[4];
        this.mNavigationBar = null;
        this.hCa = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.htW.setOnClickListener(this.hCa);
        this.hCr.setOnClickListener(this.hCa);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.hCb = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.hCc = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.hCd = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.hCe = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.hCf = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.hCg = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.hCi = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.hCj = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.hCa.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.hCj.setText(spannableString);
        this.hCh = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.hCk = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.hCl = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.hCm = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.hCp[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.hCp[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.hCp[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.hCn[1] = this.hCb;
        this.hCn[2] = this.hCc;
        this.hCn[3] = this.hCd;
        this.hCq[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.hCq[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.hCq[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.hCo[1] = this.hCk;
        this.hCo[2] = this.hCl;
        this.hCo[3] = this.hCm;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.hCa.getResources().getString(R.string.group_info_grade));
        this.htW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hCr = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.hCs = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.hCr.setVisibility(8);
            this.hCs.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.hCe.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.hCe, R.color.common_color_10167, 1);
        } else {
            this.hCe.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.hCe, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.hCr.setVisibility(8);
            this.hCs.setVisibility(8);
            return;
        }
        this.hCr.setVisibility(0);
        this.hCs.setVisibility(0);
        if (z3 && i > 0) {
            this.hCr.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.hCr, R.color.cp_cont_a, 1);
            this.hCr.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.hCr.setEnabled(false);
            am.setViewTextColor(this.hCr, R.color.common_color_10172, 1);
        }
        this.hCs.setText(string);
    }

    public View bVs() {
        return this.htW;
    }

    public TextView bVt() {
        return this.hCr;
    }

    public void onChangeSkinType(int i) {
        this.hCa.getLayoutMode().setNightMode(i == 1);
        this.hCa.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.hCa.getPageContext(), i);
    }

    public TextView[] bVu() {
        return this.hCo;
    }

    public TextView[] bVv() {
        return this.hCp;
    }

    public void nE(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void K(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.setImageResource(this.hCn[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.hCn[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.hCn[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.hCn[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.hCf.setText(this.hCq[i]);
    }

    public TextView bVw() {
        return this.hCh;
    }

    public void Q(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.hCi.setVisibility(0);
            this.hCg.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.hCa.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.hCa.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.hCi.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.hCi.setVisibility(8);
            this.hCg.setVisibility(0);
            this.hCg.setText(R.string.grouplevel_highest_grade);
        }
    }
}
