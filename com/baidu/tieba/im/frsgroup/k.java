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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View iKr;
    private TextView iSA;
    private TextView iSB;
    private TextView iSC;
    private TextView iSD;
    private TextView iSE;
    private TextView iSF;
    private TextView iSG;
    private ImageView[] iSH;
    private TextView[] iSI;
    private TextView[] iSJ;
    private String[] iSK;
    private TextView iSL;
    private TextView iSM;
    private GroupLevelActivity iSu;
    private ImageView iSv;
    private ImageView iSw;
    private ImageView iSx;
    private TextView iSy;
    private TextView iSz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.iSH = new ImageView[4];
        this.iSI = new TextView[4];
        this.iSJ = new TextView[4];
        this.iSK = new String[4];
        this.mNavigationBar = null;
        this.iSu = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.iKr.setOnClickListener(this.iSu);
        this.iSL.setOnClickListener(this.iSu);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.iSv = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.iSw = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.iSx = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.iSy = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.iSz = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.iSA = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.iSC = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.iSD = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.iSu.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.iSD.setText(spannableString);
        this.iSB = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.iSE = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.iSF = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.iSG = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.iSJ[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.iSJ[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.iSJ[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.iSH[1] = this.iSv;
        this.iSH[2] = this.iSw;
        this.iSH[3] = this.iSx;
        this.iSK[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.iSK[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.iSK[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.iSI[1] = this.iSE;
        this.iSI[2] = this.iSF;
        this.iSI[3] = this.iSG;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.iSu.getResources().getString(R.string.group_info_grade));
        this.iKr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iSL = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.iSM = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.iSL.setVisibility(8);
            this.iSM.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.iSy.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            an.setViewTextColor(this.iSy, R.color.common_color_10167, 1);
        } else {
            this.iSy.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            an.setViewTextColor(this.iSy, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.iSL.setVisibility(8);
            this.iSM.setVisibility(8);
            return;
        }
        this.iSL.setVisibility(0);
        this.iSM.setVisibility(0);
        if (z3 && i > 0) {
            this.iSL.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            an.setViewTextColor(this.iSL, R.color.cp_cont_a, 1);
            this.iSL.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.iSL.setEnabled(false);
            an.setViewTextColor(this.iSL, R.color.common_color_10172, 1);
        }
        this.iSM.setText(string);
    }

    public View cqn() {
        return this.iKr;
    }

    public TextView cqo() {
        return this.iSL;
    }

    public void onChangeSkinType(int i) {
        this.iSu.getLayoutMode().setNightMode(i == 1);
        this.iSu.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.iSu.getPageContext(), i);
    }

    public TextView[] cqp() {
        return this.iSI;
    }

    public TextView[] cqq() {
        return this.iSJ;
    }

    public void po(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void W(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                an.setImageResource(this.iSH[i2], R.drawable.icon_grade_big_star_s);
            } else {
                an.setImageResource(this.iSH[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                an.setImageResource(this.iSH[i2], R.drawable.icon_grade_big_star_n);
            } else {
                an.setImageResource(this.iSH[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.iSz.setText(this.iSK[i]);
    }

    public TextView cqr() {
        return this.iSB;
    }

    public void T(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.iSC.setVisibility(0);
            this.iSA.setVisibility(8);
            int color = an.getColor(R.color.cp_cont_b);
            int color2 = an.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.iSu.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.iSu.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.iSC.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.iSC.setVisibility(8);
            this.iSA.setVisibility(0);
            this.iSA.setText(R.string.grouplevel_highest_grade);
        }
    }
}
