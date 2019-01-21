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
    private View anp;
    private View eLo;
    private TextView eTA;
    private TextView eTB;
    private TextView eTC;
    private TextView eTD;
    private TextView eTE;
    private TextView eTF;
    private TextView eTG;
    private ImageView[] eTH;
    private TextView[] eTI;
    private TextView[] eTJ;
    private String[] eTK;
    private TextView eTL;
    private TextView eTM;
    private GroupLevelActivity eTu;
    private ImageView eTv;
    private ImageView eTw;
    private ImageView eTx;
    private TextView eTy;
    private TextView eTz;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.eTH = new ImageView[4];
        this.eTI = new TextView[4];
        this.eTJ = new TextView[4];
        this.eTK = new String[4];
        this.mNavigationBar = null;
        this.eTu = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(e.h.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.eLo.setOnClickListener(this.eTu);
        this.eTL.setOnClickListener(this.eTu);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.anp = groupLevelActivity.findViewById(e.g.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(e.g.progress_loading);
        this.eTv = (ImageView) groupLevelActivity.findViewById(e.g.level_image_1);
        this.eTw = (ImageView) groupLevelActivity.findViewById(e.g.level_image_2);
        this.eTx = (ImageView) groupLevelActivity.findViewById(e.g.level_image_3);
        this.eTy = (TextView) groupLevelActivity.findViewById(e.g.text_current_level);
        this.eTz = (TextView) groupLevelActivity.findViewById(e.g.current_level);
        this.eTA = (TextView) groupLevelActivity.findViewById(e.g.grouplevel_highest);
        this.eTC = (TextView) groupLevelActivity.findViewById(e.g.active_day_surplus);
        this.eTD = (TextView) groupLevelActivity.findViewById(e.g.text_level_intro);
        SpannableString spannableString = new SpannableString(this.eTu.getPageContext().getPageActivity().getString(e.j.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.eTD.setText(spannableString);
        this.eTB = (TextView) groupLevelActivity.findViewById(e.g.active_condition);
        this.eTE = (TextView) groupLevelActivity.findViewById(e.g.group_max1);
        this.eTF = (TextView) groupLevelActivity.findViewById(e.g.group_max2);
        this.eTG = (TextView) groupLevelActivity.findViewById(e.g.group_max3);
        this.eTJ[1] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max1);
        this.eTJ[2] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max2);
        this.eTJ[3] = (TextView) groupLevelActivity.findViewById(e.g.vgroup_max3);
        this.eTH[1] = this.eTv;
        this.eTH[2] = this.eTw;
        this.eTH[3] = this.eTx;
        this.eTK[1] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_1);
        this.eTK[2] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_2);
        this.eTK[3] = groupLevelActivity.getPageContext().getString(e.j.grouplevel_level_3);
        this.eTI[1] = this.eTE;
        this.eTI[2] = this.eTF;
        this.eTI[3] = this.eTG;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(e.g.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.eTu.getResources().getString(e.j.group_info_grade));
        this.eLo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTL = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_btn);
        this.eTM = (TextView) groupLevelActivity.findViewById(e.g.upgrade_mem_group_tip);
        if (this.isMem) {
            this.eTL.setVisibility(8);
            this.eTM.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.eTy.setText(TbadkApplication.getInst().getString(e.j.grouplevel_vip_current_level));
            al.c(this.eTy, e.d.common_color_10167, 1);
        } else {
            this.eTy.setText(TbadkApplication.getInst().getString(e.j.grouplevel_current_level));
            al.c(this.eTy, e.d.common_color_10166, 1);
        }
        if (z || !z2) {
            this.eTL.setVisibility(8);
            this.eTM.setVisibility(8);
            return;
        }
        this.eTL.setVisibility(0);
        this.eTM.setVisibility(0);
        if (z3 && i > 0) {
            this.eTL.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(e.j.upgrade_mem_group_left_num), String.valueOf(i));
            al.c(this.eTL, e.d.cp_cont_i, 1);
            this.eTL.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(e.j.upgrade_mem_group_over_max_num);
            }
            this.eTL.setEnabled(false);
            al.c(this.eTL, e.d.common_color_10172, 1);
        }
        this.eTM.setText(string);
    }

    public View aSr() {
        return this.eLo;
    }

    public TextView aSs() {
        return this.eTL;
    }

    public void onChangeSkinType(int i) {
        this.eTu.getLayoutMode().setNightMode(i == 1);
        this.eTu.getLayoutMode().onModeChanged(this.anp);
        this.mNavigationBar.onChangeSkinType(this.eTu.getPageContext(), i);
    }

    public TextView[] aSt() {
        return this.eTI;
    }

    public TextView[] aSu() {
        return this.eTJ;
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
                al.c(this.eTH[i2], i5);
            } else {
                al.c(this.eTH[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                al.c(this.eTH[i2], i6);
            } else {
                al.c(this.eTH[i2], i4);
            }
            i2++;
        }
        this.eTz.setText(this.eTK[i]);
    }

    public TextView aSv() {
        return this.eTB;
    }

    public void S(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.eTC.setVisibility(0);
            this.eTA.setVisibility(8);
            int color = al.getColor(e.d.cp_cont_b);
            int color2 = al.getColor(e.d.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.eTu.getPageContext().getPageActivity().getString(e.j.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.eTu.getPageContext().getPageActivity().getString(e.j.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.eTC.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.eTC.setVisibility(8);
            this.eTA.setVisibility(0);
            this.eTA.setText(e.j.grouplevel_highest_grade);
        }
    }
}
