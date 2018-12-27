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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View amM;
    private View eKB;
    private GroupLevelActivity eSG;
    private ImageView eSH;
    private ImageView eSI;
    private ImageView eSJ;
    private TextView eSK;
    private TextView eSL;
    private TextView eSM;
    private TextView eSN;
    private TextView eSO;
    private TextView eSP;
    private TextView eSQ;
    private TextView eSR;
    private TextView eSS;
    private ImageView[] eST;
    private TextView[] eSU;
    private TextView[] eSV;
    private String[] eSW;
    private TextView eSX;
    private TextView eSY;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eST = new ImageView[4];
        this.eSU = new TextView[4];
        this.eSV = new TextView[4];
        this.eSW = new String[4];
        this.mNavigationBar = null;
        this.eSG = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.eKB.setOnClickListener(this.eSG);
        this.eSX.setOnClickListener(this.eSG);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.amM = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.eSH = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.eSI = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.eSJ = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.eSK = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.eSL = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.eSM = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.eSO = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.eSP = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eSG.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eSP.setText(spannableString);
        this.eSN = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.eSQ = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eSR = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eSS = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eSV[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eSV[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eSV[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eST[1] = this.eSH;
        this.eST[2] = this.eSI;
        this.eST[3] = this.eSJ;
        this.eSW[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eSW[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eSW[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eSU[1] = this.eSQ;
        this.eSU[2] = this.eSR;
        this.eSU[3] = this.eSS;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eSG.getResources().getString(e.j.group_info_grade));
        this.eKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eSX = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eSY = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eSX.setVisibility(8);
            this.eSY.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eSK.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.eSK, e.d.common_color_10167, 1);
        } else {
            this.eSK.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.eSK, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eSX.setVisibility(8);
            this.eSY.setVisibility(8);
            return;
        }
        this.eSX.setVisibility(0);
        this.eSY.setVisibility(0);
        if (z3 && i > 0) {
            this.eSX.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eSX, e.d.cp_cont_i, 1);
            this.eSX.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eSX.setEnabled(false);
            al.c(this.eSX, e.d.common_color_10172, 1);
        }
        this.eSY.setText(string);
    }

    public View aRR() {
        return this.eKB;
    }

    public TextView aRS() {
        return this.eSX;
    }

    public void onChangeSkinType(int i) {
        this.eSG.getLayoutMode().setNightMode(i == 1);
        this.eSG.getLayoutMode().onModeChanged(this.amM);
        this.mNavigationBar.onChangeSkinType(this.eSG.getPageContext(), i);
    }

    public TextView[] aRT() {
        return this.eSU;
    }

    public TextView[] aRU() {
        return this.eSV;
    }

    public void iB(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void x(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = e.f.icon_grade_big_star_s;
        int i4 = e.f.icon_grade_big_star_n;
        int i5 = e.f.icon_vip_grade_big_star_s;
        int i6 = e.f.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                al.c(this.eST[i2], i5);
            } else {
                al.c(this.eST[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eST[i2], i6);
            } else {
                al.c(this.eST[i2], i4);
            }
            i2++;
        }
        this.eSL.setText(this.eSW[i]);
    }

    public TextView aRV() {
        return this.eSN;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eSO.setVisibility(0);
            this.eSM.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eSG.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eSG.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eSO.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eSO.setVisibility(8);
            this.eSM.setVisibility(0);
            this.eSM.setText(e.j.grouplevel_highest_grade);
        }
    }
}
