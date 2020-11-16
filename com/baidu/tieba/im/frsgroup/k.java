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
    private View jWk;
    private TextView kgA;
    private TextView kgB;
    private TextView kgC;
    private TextView kgD;
    private ImageView[] kgE;
    private TextView[] kgF;
    private TextView[] kgG;
    private String[] kgH;
    private TextView kgI;
    private TextView kgJ;
    private GroupLevelActivity kgr;
    private ImageView kgs;
    private ImageView kgt;
    private ImageView kgu;
    private TextView kgv;
    private TextView kgw;
    private TextView kgx;
    private TextView kgy;
    private TextView kgz;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.kgE = new ImageView[4];
        this.kgF = new TextView[4];
        this.kgG = new TextView[4];
        this.kgH = new String[4];
        this.mNavigationBar = null;
        this.kgr = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.jWk.setOnClickListener(this.kgr);
        this.kgI.setOnClickListener(this.kgr);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.kgs = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.kgt = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.kgu = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.kgv = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.kgw = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.kgx = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.kgz = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.kgA = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.kgr.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.kgA.setText(spannableString);
        this.kgy = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.kgB = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.kgC = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.kgD = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.kgG[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.kgG[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.kgG[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.kgE[1] = this.kgs;
        this.kgE[2] = this.kgt;
        this.kgE[3] = this.kgu;
        this.kgH[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.kgH[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.kgH[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.kgF[1] = this.kgB;
        this.kgF[2] = this.kgC;
        this.kgF[3] = this.kgD;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.kgr.getResources().getString(R.string.group_info_grade));
        this.jWk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kgI = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.kgJ = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.kgI.setVisibility(8);
            this.kgJ.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.kgv.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.kgv, R.color.common_color_10167, 1);
        } else {
            this.kgv.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.kgv, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.kgI.setVisibility(8);
            this.kgJ.setVisibility(8);
            return;
        }
        this.kgI.setVisibility(0);
        this.kgJ.setVisibility(0);
        if (z3 && i > 0) {
            this.kgI.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.kgI, R.color.CAM_X0101, 1);
            this.kgI.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.kgI.setEnabled(false);
            ap.setViewTextColor(this.kgI, R.color.common_color_10172, 1);
        }
        this.kgJ.setText(string);
    }

    public View cRH() {
        return this.jWk;
    }

    public TextView cRI() {
        return this.kgI;
    }

    public void onChangeSkinType(int i) {
        this.kgr.getLayoutMode().setNightMode(i == 1);
        this.kgr.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.kgr.getPageContext(), i);
    }

    public TextView[] cRJ() {
        return this.kgF;
    }

    public TextView[] cRK() {
        return this.kgG;
    }

    public void rV(boolean z) {
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
                ap.setImageResource(this.kgE[i2], i5);
            } else {
                ap.setImageResource(this.kgE[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.kgE[i2], i6);
            } else {
                ap.setImageResource(this.kgE[i2], i4);
            }
            i2++;
        }
        this.kgw.setText(this.kgH[i]);
    }

    public TextView cRL() {
        return this.kgy;
    }

    public void W(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.kgz.setVisibility(0);
            this.kgx.setVisibility(8);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0305);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.kgr.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.kgr.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.kgz.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.kgz.setVisibility(8);
            this.kgx.setVisibility(0);
            this.kgx.setText(R.string.grouplevel_highest_grade);
        }
    }
}
