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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes23.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private boolean isMem;
    private View jDe;
    private TextView[] jNA;
    private String[] jNB;
    private TextView jNC;
    private TextView jND;
    private GroupLevelActivity jNl;
    private ImageView jNm;
    private ImageView jNn;
    private ImageView jNo;
    private TextView jNp;
    private TextView jNq;
    private TextView jNr;
    private TextView jNs;
    private TextView jNt;
    private TextView jNu;
    private TextView jNv;
    private TextView jNw;
    private TextView jNx;
    private ImageView[] jNy;
    private TextView[] jNz;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.jNy = new ImageView[4];
        this.jNz = new TextView[4];
        this.jNA = new TextView[4];
        this.jNB = new String[4];
        this.mNavigationBar = null;
        this.jNl = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.jDe.setOnClickListener(this.jNl);
        this.jNC.setOnClickListener(this.jNl);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.jNm = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.jNn = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.jNo = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.jNp = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.jNq = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.jNr = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.jNt = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.jNu = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.jNl.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.jNu.setText(spannableString);
        this.jNs = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.jNv = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.jNw = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.jNx = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.jNA[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.jNA[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.jNA[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.jNy[1] = this.jNm;
        this.jNy[2] = this.jNn;
        this.jNy[3] = this.jNo;
        this.jNB[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.jNB[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.jNB[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.jNz[1] = this.jNv;
        this.jNz[2] = this.jNw;
        this.jNz[3] = this.jNx;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jNl.getResources().getString(R.string.group_info_grade));
        this.jDe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jNC = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.jND = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.jNC.setVisibility(8);
            this.jND.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.jNp.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.jNp, R.color.common_color_10167, 1);
        } else {
            this.jNp.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.jNp, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.jNC.setVisibility(8);
            this.jND.setVisibility(8);
            return;
        }
        this.jNC.setVisibility(0);
        this.jND.setVisibility(0);
        if (z3 && i > 0) {
            this.jNC.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.jNC, R.color.cp_cont_a, 1);
            this.jNC.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.jNC.setEnabled(false);
            ap.setViewTextColor(this.jNC, R.color.common_color_10172, 1);
        }
        this.jND.setText(string);
    }

    public View cMt() {
        return this.jDe;
    }

    public TextView cMu() {
        return this.jNC;
    }

    public void onChangeSkinType(int i) {
        this.jNl.getLayoutMode().setNightMode(i == 1);
        this.jNl.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jNl.getPageContext(), i);
    }

    public TextView[] cMv() {
        return this.jNz;
    }

    public TextView[] cMw() {
        return this.jNA;
    }

    public void rr(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void ab(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = R.drawable.icon_grade_big_star_s;
        int i4 = R.drawable.icon_grade_big_star_n;
        int i5 = R.drawable.icon_vip_grade_big_star_s;
        int i6 = R.drawable.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                ap.setImageResource(this.jNy[i2], i5);
            } else {
                ap.setImageResource(this.jNy[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.jNy[i2], i6);
            } else {
                ap.setImageResource(this.jNy[i2], i4);
            }
            i2++;
        }
        this.jNq.setText(this.jNB[i]);
    }

    public TextView cMx() {
        return this.jNs;
    }

    public void T(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.jNt.setVisibility(0);
            this.jNr.setVisibility(8);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.jNl.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.jNl.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.jNt.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.jNt.setVisibility(8);
            this.jNr.setVisibility(0);
            this.jNr.setText(R.string.grouplevel_highest_grade);
        }
    }
}
