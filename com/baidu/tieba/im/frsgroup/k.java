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
    private View ano;
    private View eLn;
    private TextView eTA;
    private TextView eTB;
    private TextView eTC;
    private TextView eTD;
    private TextView eTE;
    private TextView eTF;
    private ImageView[] eTG;
    private TextView[] eTH;
    private TextView[] eTI;
    private String[] eTJ;
    private TextView eTK;
    private TextView eTL;
    private GroupLevelActivity eTt;
    private ImageView eTu;
    private ImageView eTv;
    private ImageView eTw;
    private TextView eTx;
    private TextView eTy;
    private TextView eTz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eTG = new ImageView[4];
        this.eTH = new TextView[4];
        this.eTI = new TextView[4];
        this.eTJ = new String[4];
        this.mNavigationBar = null;
        this.eTt = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.eLn.setOnClickListener(this.eTt);
        this.eTK.setOnClickListener(this.eTt);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.ano = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.eTu = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.eTv = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.eTw = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.eTx = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.eTy = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.eTz = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.eTB = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.eTC = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eTt.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eTC.setText(spannableString);
        this.eTA = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.eTD = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eTE = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eTF = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eTI[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eTI[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eTI[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eTG[1] = this.eTu;
        this.eTG[2] = this.eTv;
        this.eTG[3] = this.eTw;
        this.eTJ[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eTJ[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eTJ[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eTH[1] = this.eTD;
        this.eTH[2] = this.eTE;
        this.eTH[3] = this.eTF;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eTt.getResources().getString(e.j.group_info_grade));
        this.eLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTK = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eTL = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eTK.setVisibility(8);
            this.eTL.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eTx.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.eTx, e.d.common_color_10167, 1);
        } else {
            this.eTx.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.eTx, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eTK.setVisibility(8);
            this.eTL.setVisibility(8);
            return;
        }
        this.eTK.setVisibility(0);
        this.eTL.setVisibility(0);
        if (z3 && i > 0) {
            this.eTK.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eTK, e.d.cp_cont_i, 1);
            this.eTK.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eTK.setEnabled(false);
            al.c(this.eTK, e.d.common_color_10172, 1);
        }
        this.eTL.setText(string);
    }

    public View aSr() {
        return this.eLn;
    }

    public TextView aSs() {
        return this.eTK;
    }

    public void onChangeSkinType(int i) {
        this.eTt.getLayoutMode().setNightMode(i == 1);
        this.eTt.getLayoutMode().onModeChanged(this.ano);
        this.mNavigationBar.onChangeSkinType(this.eTt.getPageContext(), i);
    }

    public TextView[] aSt() {
        return this.eTH;
    }

    public TextView[] aSu() {
        return this.eTI;
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
                al.c(this.eTG[i2], i5);
            } else {
                al.c(this.eTG[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eTG[i2], i6);
            } else {
                al.c(this.eTG[i2], i4);
            }
            i2++;
        }
        this.eTy.setText(this.eTJ[i]);
    }

    public TextView aSv() {
        return this.eTA;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eTB.setVisibility(0);
            this.eTz.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eTt.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eTt.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eTB.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eTB.setVisibility(8);
            this.eTz.setVisibility(0);
            this.eTz.setText(e.j.grouplevel_highest_grade);
        }
    }
}
