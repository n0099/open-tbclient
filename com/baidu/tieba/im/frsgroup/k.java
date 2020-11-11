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
    private View jVA;
    private GroupLevelActivity kfH;
    private ImageView kfI;
    private ImageView kfJ;
    private ImageView kfK;
    private TextView kfL;
    private TextView kfM;
    private TextView kfN;
    private TextView kfO;
    private TextView kfP;
    private TextView kfQ;
    private TextView kfR;
    private TextView kfS;
    private TextView kfT;
    private ImageView[] kfU;
    private TextView[] kfV;
    private TextView[] kfW;
    private String[] kfX;
    private TextView kfY;
    private TextView kfZ;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.kfU = new ImageView[4];
        this.kfV = new TextView[4];
        this.kfW = new TextView[4];
        this.kfX = new String[4];
        this.mNavigationBar = null;
        this.kfH = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.jVA.setOnClickListener(this.kfH);
        this.kfY.setOnClickListener(this.kfH);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.kfI = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.kfJ = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.kfK = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.kfL = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.kfM = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.kfN = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.kfP = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.kfQ = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.kfH.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.kfQ.setText(spannableString);
        this.kfO = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.kfR = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.kfS = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.kfT = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.kfW[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.kfW[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.kfW[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.kfU[1] = this.kfI;
        this.kfU[2] = this.kfJ;
        this.kfU[3] = this.kfK;
        this.kfX[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.kfX[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.kfX[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.kfV[1] = this.kfR;
        this.kfV[2] = this.kfS;
        this.kfV[3] = this.kfT;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.kfH.getResources().getString(R.string.group_info_grade));
        this.jVA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kfY = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.kfZ = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.kfY.setVisibility(8);
            this.kfZ.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.kfL.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.kfL, R.color.common_color_10167, 1);
        } else {
            this.kfL.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.kfL, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.kfY.setVisibility(8);
            this.kfZ.setVisibility(8);
            return;
        }
        this.kfY.setVisibility(0);
        this.kfZ.setVisibility(0);
        if (z3 && i > 0) {
            this.kfY.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.kfY, R.color.cp_cont_a, 1);
            this.kfY.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.kfY.setEnabled(false);
            ap.setViewTextColor(this.kfY, R.color.common_color_10172, 1);
        }
        this.kfZ.setText(string);
    }

    public View cSb() {
        return this.jVA;
    }

    public TextView cSc() {
        return this.kfY;
    }

    public void onChangeSkinType(int i) {
        this.kfH.getLayoutMode().setNightMode(i == 1);
        this.kfH.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.kfH.getPageContext(), i);
    }

    public TextView[] cSd() {
        return this.kfV;
    }

    public TextView[] cSe() {
        return this.kfW;
    }

    public void rS(boolean z) {
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
                ap.setImageResource(this.kfU[i2], i5);
            } else {
                ap.setImageResource(this.kfU[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.kfU[i2], i6);
            } else {
                ap.setImageResource(this.kfU[i2], i4);
            }
            i2++;
        }
        this.kfM.setText(this.kfX[i]);
    }

    public TextView cSf() {
        return this.kfO;
    }

    public void U(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.kfP.setVisibility(0);
            this.kfN.setVisibility(8);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.kfH.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.kfH.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.kfP.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.kfP.setVisibility(8);
            this.kfN.setVisibility(0);
            this.kfN.setText(R.string.grouplevel_highest_grade);
        }
    }
}
