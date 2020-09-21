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
/* loaded from: classes22.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private boolean isMem;
    private View joh;
    private TextView jyA;
    private ImageView[] jyB;
    private TextView[] jyC;
    private TextView[] jyD;
    private String[] jyE;
    private TextView jyF;
    private TextView jyG;
    private GroupLevelActivity jyo;
    private ImageView jyp;
    private ImageView jyq;
    private ImageView jyr;
    private TextView jys;
    private TextView jyt;
    private TextView jyu;
    private TextView jyv;
    private TextView jyw;
    private TextView jyx;
    private TextView jyy;
    private TextView jyz;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.jyB = new ImageView[4];
        this.jyC = new TextView[4];
        this.jyD = new TextView[4];
        this.jyE = new String[4];
        this.mNavigationBar = null;
        this.jyo = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.joh.setOnClickListener(this.jyo);
        this.jyF.setOnClickListener(this.jyo);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.jyp = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.jyq = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.jyr = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.jys = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.jyt = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.jyu = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.jyw = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.jyx = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.jyo.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.jyx.setText(spannableString);
        this.jyv = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.jyy = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.jyz = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.jyA = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.jyD[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.jyD[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.jyD[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.jyB[1] = this.jyp;
        this.jyB[2] = this.jyq;
        this.jyB[3] = this.jyr;
        this.jyE[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.jyE[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.jyE[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.jyC[1] = this.jyy;
        this.jyC[2] = this.jyz;
        this.jyC[3] = this.jyA;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jyo.getResources().getString(R.string.group_info_grade));
        this.joh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jyF = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.jyG = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.jyF.setVisibility(8);
            this.jyG.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.jys.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.jys, R.color.common_color_10167, 1);
        } else {
            this.jys.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.jys, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.jyF.setVisibility(8);
            this.jyG.setVisibility(8);
            return;
        }
        this.jyF.setVisibility(0);
        this.jyG.setVisibility(0);
        if (z3 && i > 0) {
            this.jyF.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.jyF, R.color.cp_cont_a, 1);
            this.jyF.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.jyF.setEnabled(false);
            ap.setViewTextColor(this.jyF, R.color.common_color_10172, 1);
        }
        this.jyG.setText(string);
    }

    public View cIK() {
        return this.joh;
    }

    public TextView cIL() {
        return this.jyF;
    }

    public void onChangeSkinType(int i) {
        this.jyo.getLayoutMode().setNightMode(i == 1);
        this.jyo.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jyo.getPageContext(), i);
    }

    public TextView[] cIM() {
        return this.jyC;
    }

    public TextView[] cIN() {
        return this.jyD;
    }

    public void qL(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void Z(int i, boolean z) {
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
                ap.setImageResource(this.jyB[i2], i5);
            } else {
                ap.setImageResource(this.jyB[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.jyB[i2], i6);
            } else {
                ap.setImageResource(this.jyB[i2], i4);
            }
            i2++;
        }
        this.jyt.setText(this.jyE[i]);
    }

    public TextView cIO() {
        return this.jyv;
    }

    public void T(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.jyw.setVisibility(0);
            this.jyu.setVisibility(8);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.jyo.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.jyo.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.jyw.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.jyw.setVisibility(8);
            this.jyu.setVisibility(0);
            this.jyu.setText(R.string.grouplevel_highest_grade);
        }
    }
}
