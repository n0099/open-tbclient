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
import com.baidu.tieba.d;
/* loaded from: classes5.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View btY;
    private View gbp;
    private GroupLevelActivity gjB;
    private ImageView gjC;
    private ImageView gjD;
    private ImageView gjE;
    private TextView gjF;
    private TextView gjG;
    private TextView gjH;
    private TextView gjI;
    private TextView gjJ;
    private TextView gjK;
    private TextView gjL;
    private TextView gjM;
    private TextView gjN;
    private ImageView[] gjO;
    private TextView[] gjP;
    private TextView[] gjQ;
    private String[] gjR;
    private TextView gjS;
    private TextView gjT;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.gjO = new ImageView[4];
        this.gjP = new TextView[4];
        this.gjQ = new TextView[4];
        this.gjR = new String[4];
        this.mNavigationBar = null;
        this.gjB = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(d.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.gbp.setOnClickListener(this.gjB);
        this.gjS.setOnClickListener(this.gjB);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.btY = groupLevelActivity.findViewById(d.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(d.g.progress_loading);
        this.gjC = (ImageView) groupLevelActivity.findViewById(d.g.level_image_1);
        this.gjD = (ImageView) groupLevelActivity.findViewById(d.g.level_image_2);
        this.gjE = (ImageView) groupLevelActivity.findViewById(d.g.level_image_3);
        this.gjF = (TextView) groupLevelActivity.findViewById(d.g.text_current_level);
        this.gjG = (TextView) groupLevelActivity.findViewById(d.g.current_level);
        this.gjH = (TextView) groupLevelActivity.findViewById(d.g.grouplevel_highest);
        this.gjJ = (TextView) groupLevelActivity.findViewById(d.g.active_day_surplus);
        this.gjK = (TextView) groupLevelActivity.findViewById(d.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.gjB.getPageContext().getPageActivity().getString(d.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.gjK.setText(spannableString);
        this.gjI = (TextView) groupLevelActivity.findViewById(d.g.active_condition);
        this.gjL = (TextView) groupLevelActivity.findViewById(d.g.group_max1);
        this.gjM = (TextView) groupLevelActivity.findViewById(d.g.group_max2);
        this.gjN = (TextView) groupLevelActivity.findViewById(d.g.group_max3);
        this.gjQ[1] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max1);
        this.gjQ[2] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max2);
        this.gjQ[3] = (TextView) groupLevelActivity.findViewById(d.g.vgroup_max3);
        this.gjO[1] = this.gjC;
        this.gjO[2] = this.gjD;
        this.gjO[3] = this.gjE;
        this.gjR[1] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_1);
        this.gjR[2] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_2);
        this.gjR[3] = groupLevelActivity.getPageContext().getString(d.j.grouplevel_level_3);
        this.gjP[1] = this.gjL;
        this.gjP[2] = this.gjM;
        this.gjP[3] = this.gjN;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(d.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.gjB.getResources().getString(d.j.group_info_grade));
        this.gbp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gjS = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_btn);
        this.gjT = (TextView) groupLevelActivity.findViewById(d.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.gjS.setVisibility(8);
            this.gjT.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.gjF.setText(TbadkApplication.getInst().getString(d.j.grouplevel_vip_current_level));
            al.d(this.gjF, d.C0277d.common_color_10167, 1);
        } else {
            this.gjF.setText(TbadkApplication.getInst().getString(d.j.grouplevel_current_level));
            al.d(this.gjF, d.C0277d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.gjS.setVisibility(8);
            this.gjT.setVisibility(8);
            return;
        }
        this.gjS.setVisibility(0);
        this.gjT.setVisibility(0);
        if (z3 && i > 0) {
            this.gjS.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(d.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.d(this.gjS, d.C0277d.cp_btn_a, 1);
            this.gjS.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(d.j.upgrade_mem_group_over_max_num);
            }
            this.gjS.setEnabled(false);
            al.d(this.gjS, d.C0277d.common_color_10172, 1);
        }
        this.gjT.setText(string);
    }

    public View bsW() {
        return this.gbp;
    }

    public TextView bsX() {
        return this.gjS;
    }

    public void onChangeSkinType(int i) {
        this.gjB.getLayoutMode().setNightMode(i == 1);
        this.gjB.getLayoutMode().onModeChanged(this.btY);
        this.mNavigationBar.onChangeSkinType(this.gjB.getPageContext(), i);
    }

    public TextView[] bsY() {
        return this.gjP;
    }

    public TextView[] bsZ() {
        return this.gjQ;
    }

    public void lb(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void D(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        int i3 = d.f.icon_grade_big_star_s;
        int i4 = d.f.icon_grade_big_star_n;
        int i5 = d.f.icon_vip_grade_big_star_s;
        int i6 = d.f.icon_vip_grade_big_star_n;
        while (i2 <= i) {
            if (z) {
                al.c(this.gjO[i2], i5);
            } else {
                al.c(this.gjO[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.gjO[i2], i6);
            } else {
                al.c(this.gjO[i2], i4);
            }
            i2++;
        }
        this.gjG.setText(this.gjR[i]);
    }

    public TextView bta() {
        return this.gjI;
    }

    public void V(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.gjJ.setVisibility(0);
            this.gjH.setVisibility(8);
            int color = al.getColor(d.C0277d.cp_cont_b);
            int color2 = al.getColor(d.C0277d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.gjB.getPageContext().getPageActivity().getString(d.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.gjB.getPageContext().getPageActivity().getString(d.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.gjJ.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.gjJ.setVisibility(8);
            this.gjH.setVisibility(0);
            this.gjH.setText(d.j.grouplevel_highest_grade);
        }
    }
}
