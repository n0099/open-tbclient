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
    private View kjR;
    private GroupLevelActivity ktR;
    private ImageView ktS;
    private ImageView ktT;
    private ImageView ktU;
    private TextView ktV;
    private TextView ktW;
    private TextView ktX;
    private TextView ktY;
    private TextView ktZ;
    private TextView kua;
    private TextView kub;
    private TextView kuc;
    private TextView kud;
    private ImageView[] kue;
    private TextView[] kuf;
    private TextView[] kug;
    private String[] kuh;
    private TextView kui;
    private TextView kuj;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.kue = new ImageView[4];
        this.kuf = new TextView[4];
        this.kug = new TextView[4];
        this.kuh = new String[4];
        this.mNavigationBar = null;
        this.ktR = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.kjR.setOnClickListener(this.ktR);
        this.kui.setOnClickListener(this.ktR);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.ktS = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.ktT = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.ktU = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.ktV = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.ktW = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.ktX = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.ktZ = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.kua = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.ktR.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.kua.setText(spannableString);
        this.ktY = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.kub = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.kuc = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.kud = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.kug[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.kug[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.kug[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.kue[1] = this.ktS;
        this.kue[2] = this.ktT;
        this.kue[3] = this.ktU;
        this.kuh[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.kuh[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.kuh[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.kuf[1] = this.kub;
        this.kuf[2] = this.kuc;
        this.kuf[3] = this.kud;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ktR.getResources().getString(R.string.group_info_grade));
        this.kjR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kui = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.kuj = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.kui.setVisibility(8);
            this.kuj.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.ktV.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.ktV, R.color.common_color_10167, 1);
        } else {
            this.ktV.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.ktV, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.kui.setVisibility(8);
            this.kuj.setVisibility(8);
            return;
        }
        this.kui.setVisibility(0);
        this.kuj.setVisibility(0);
        if (z3 && i > 0) {
            this.kui.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.kui, R.color.CAM_X0101, 1);
            this.kui.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.kui.setEnabled(false);
            ap.setViewTextColor(this.kui, R.color.common_color_10172, 1);
        }
        this.kuj.setText(string);
    }

    public View cWU() {
        return this.kjR;
    }

    public TextView cWV() {
        return this.kui;
    }

    public void onChangeSkinType(int i) {
        this.ktR.getLayoutMode().setNightMode(i == 1);
        this.ktR.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ktR.getPageContext(), i);
    }

    public TextView[] cWW() {
        return this.kuf;
    }

    public TextView[] cWX() {
        return this.kug;
    }

    public void sx(boolean z) {
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
                ap.setImageResource(this.kue[i2], i5);
            } else {
                ap.setImageResource(this.kue[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.kue[i2], i6);
            } else {
                ap.setImageResource(this.kue[i2], i4);
            }
            i2++;
        }
        this.ktW.setText(this.kuh[i]);
    }

    public TextView cWY() {
        return this.ktY;
    }

    public void V(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.ktZ.setVisibility(0);
            this.ktX.setVisibility(8);
            int color = ap.getColor(R.color.CAM_X0105);
            int color2 = ap.getColor(R.color.CAM_X0305);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.ktR.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.ktR.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.ktZ.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.ktZ.setVisibility(8);
            this.ktX.setVisibility(0);
            this.ktX.setText(R.string.grouplevel_highest_grade);
        }
    }
}
