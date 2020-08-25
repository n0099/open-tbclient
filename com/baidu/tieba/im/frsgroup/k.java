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
/* loaded from: classes17.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private boolean isMem;
    private View jfv;
    private GroupLevelActivity jpG;
    private ImageView jpH;
    private ImageView jpI;
    private ImageView jpJ;
    private TextView jpK;
    private TextView jpL;
    private TextView jpM;
    private TextView jpN;
    private TextView jpO;
    private TextView jpP;
    private TextView jpQ;
    private TextView jpR;
    private TextView jpS;
    private ImageView[] jpT;
    private TextView[] jpU;
    private TextView[] jpV;
    private String[] jpW;
    private TextView jpX;
    private TextView jpY;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.jpT = new ImageView[4];
        this.jpU = new TextView[4];
        this.jpV = new TextView[4];
        this.jpW = new String[4];
        this.mNavigationBar = null;
        this.jpG = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.jfv.setOnClickListener(this.jpG);
        this.jpX.setOnClickListener(this.jpG);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.jpH = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.jpI = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.jpJ = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.jpK = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.jpL = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.jpM = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.jpO = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.jpP = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.jpG.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.jpP.setText(spannableString);
        this.jpN = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.jpQ = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.jpR = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.jpS = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.jpV[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.jpV[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.jpV[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.jpT[1] = this.jpH;
        this.jpT[2] = this.jpI;
        this.jpT[3] = this.jpJ;
        this.jpW[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.jpW[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.jpW[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.jpU[1] = this.jpQ;
        this.jpU[2] = this.jpR;
        this.jpU[3] = this.jpS;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jpG.getResources().getString(R.string.group_info_grade));
        this.jfv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jpX = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.jpY = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.jpX.setVisibility(8);
            this.jpY.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.jpK.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.jpK, R.color.common_color_10167, 1);
        } else {
            this.jpK.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.jpK, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.jpX.setVisibility(8);
            this.jpY.setVisibility(8);
            return;
        }
        this.jpX.setVisibility(0);
        this.jpY.setVisibility(0);
        if (z3 && i > 0) {
            this.jpX.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.jpX, R.color.cp_cont_a, 1);
            this.jpX.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.jpX.setEnabled(false);
            ap.setViewTextColor(this.jpX, R.color.common_color_10172, 1);
        }
        this.jpY.setText(string);
    }

    public View cFd() {
        return this.jfv;
    }

    public TextView cFe() {
        return this.jpX;
    }

    public void onChangeSkinType(int i) {
        this.jpG.getLayoutMode().setNightMode(i == 1);
        this.jpG.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jpG.getPageContext(), i);
    }

    public TextView[] cFf() {
        return this.jpU;
    }

    public TextView[] cFg() {
        return this.jpV;
    }

    public void qB(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void Y(int i, boolean z) {
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
                ap.setImageResource(this.jpT[i2], i5);
            } else {
                ap.setImageResource(this.jpT[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.jpT[i2], i6);
            } else {
                ap.setImageResource(this.jpT[i2], i4);
            }
            i2++;
        }
        this.jpL.setText(this.jpW[i]);
    }

    public TextView cFh() {
        return this.jpN;
    }

    public void R(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.jpO.setVisibility(0);
            this.jpM.setVisibility(8);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.jpG.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.jpG.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.jpO.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.jpO.setVisibility(8);
            this.jpM.setVisibility(0);
            this.jpM.setText(R.string.grouplevel_highest_grade);
        }
    }
}
