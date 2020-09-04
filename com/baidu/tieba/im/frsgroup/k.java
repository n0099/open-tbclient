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
    private View jfB;
    private GroupLevelActivity jpM;
    private ImageView jpN;
    private ImageView jpO;
    private ImageView jpP;
    private TextView jpQ;
    private TextView jpR;
    private TextView jpS;
    private TextView jpT;
    private TextView jpU;
    private TextView jpV;
    private TextView jpW;
    private TextView jpX;
    private TextView jpY;
    private ImageView[] jpZ;
    private TextView[] jqa;
    private TextView[] jqb;
    private String[] jqc;
    private TextView jqd;
    private TextView jqe;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.jpZ = new ImageView[4];
        this.jqa = new TextView[4];
        this.jqb = new TextView[4];
        this.jqc = new String[4];
        this.mNavigationBar = null;
        this.jpM = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.jfB.setOnClickListener(this.jpM);
        this.jqd.setOnClickListener(this.jpM);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.jpN = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.jpO = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.jpP = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.jpQ = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.jpR = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.jpS = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.jpU = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.jpV = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.jpM.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.jpV.setText(spannableString);
        this.jpT = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.jpW = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.jpX = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.jpY = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.jqb[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.jqb[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.jqb[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.jpZ[1] = this.jpN;
        this.jpZ[2] = this.jpO;
        this.jpZ[3] = this.jpP;
        this.jqc[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.jqc[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.jqc[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.jqa[1] = this.jpW;
        this.jqa[2] = this.jpX;
        this.jqa[3] = this.jpY;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jpM.getResources().getString(R.string.group_info_grade));
        this.jfB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jqd = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.jqe = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.jqd.setVisibility(8);
            this.jqe.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.jpQ.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.jpQ, R.color.common_color_10167, 1);
        } else {
            this.jpQ.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.jpQ, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.jqd.setVisibility(8);
            this.jqe.setVisibility(8);
            return;
        }
        this.jqd.setVisibility(0);
        this.jqe.setVisibility(0);
        if (z3 && i > 0) {
            this.jqd.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.jqd, R.color.cp_cont_a, 1);
            this.jqd.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.jqd.setEnabled(false);
            ap.setViewTextColor(this.jqd, R.color.common_color_10172, 1);
        }
        this.jqe.setText(string);
    }

    public View cFe() {
        return this.jfB;
    }

    public TextView cFf() {
        return this.jqd;
    }

    public void onChangeSkinType(int i) {
        this.jpM.getLayoutMode().setNightMode(i == 1);
        this.jpM.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jpM.getPageContext(), i);
    }

    public TextView[] cFg() {
        return this.jqa;
    }

    public TextView[] cFh() {
        return this.jqb;
    }

    public void qD(boolean z) {
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
                ap.setImageResource(this.jpZ[i2], i5);
            } else {
                ap.setImageResource(this.jpZ[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.jpZ[i2], i6);
            } else {
                ap.setImageResource(this.jpZ[i2], i4);
            }
            i2++;
        }
        this.jpR.setText(this.jqc[i]);
    }

    public TextView cFi() {
        return this.jpT;
    }

    public void R(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.jpU.setVisibility(0);
            this.jpS.setVisibility(8);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.jpM.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.jpM.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.jpU.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.jpU.setVisibility(8);
            this.jpS.setVisibility(0);
            this.jpS.setText(R.string.grouplevel_highest_grade);
        }
    }
}
