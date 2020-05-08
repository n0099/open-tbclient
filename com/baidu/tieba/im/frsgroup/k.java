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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class k extends com.baidu.adp.base.c<GroupLevelActivity> {
    private View idP;
    private GroupLevelActivity ilU;
    private ImageView ilV;
    private ImageView ilW;
    private ImageView ilX;
    private TextView ilY;
    private TextView ilZ;
    private TextView ima;
    private TextView imb;
    private TextView imc;
    private TextView imd;
    private TextView ime;
    private TextView imf;
    private TextView imh;
    private ImageView[] imi;
    private TextView[] imj;
    private TextView[] imk;
    private String[] iml;
    private TextView imm;
    private TextView imn;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.imi = new ImageView[4];
        this.imj = new TextView[4];
        this.imk = new TextView[4];
        this.iml = new String[4];
        this.mNavigationBar = null;
        this.ilU = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.idP.setOnClickListener(this.ilU);
        this.imm.setOnClickListener(this.ilU);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.ilV = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.ilW = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.ilX = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.ilY = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.ilZ = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.ima = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.imc = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.imd = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.ilU.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.imd.setText(spannableString);
        this.imb = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.ime = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.imf = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.imh = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.imk[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.imk[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.imk[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.imi[1] = this.ilV;
        this.imi[2] = this.ilW;
        this.imi[3] = this.ilX;
        this.iml[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.iml[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.iml[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.imj[1] = this.ime;
        this.imj[2] = this.imf;
        this.imj[3] = this.imh;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ilU.getResources().getString(R.string.group_info_grade));
        this.idP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.imm = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.imn = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.imm.setVisibility(8);
            this.imn.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.ilY.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.ilY, R.color.common_color_10167, 1);
        } else {
            this.ilY.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.ilY, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.imm.setVisibility(8);
            this.imn.setVisibility(8);
            return;
        }
        this.imm.setVisibility(0);
        this.imn.setVisibility(0);
        if (z3 && i > 0) {
            this.imm.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.imm, R.color.cp_cont_a, 1);
            this.imm.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.imm.setEnabled(false);
            am.setViewTextColor(this.imm, R.color.common_color_10172, 1);
        }
        this.imn.setText(string);
    }

    public View cfR() {
        return this.idP;
    }

    public TextView cfS() {
        return this.imm;
    }

    public void onChangeSkinType(int i) {
        this.ilU.getLayoutMode().setNightMode(i == 1);
        this.ilU.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ilU.getPageContext(), i);
    }

    public TextView[] cfT() {
        return this.imj;
    }

    public TextView[] cfU() {
        return this.imk;
    }

    public void oI(boolean z) {
        this.mProgressBar.setVisibility(z ? 0 : 8);
    }

    public void Q(int i, boolean z) {
        int i2 = 1;
        if (i <= 1) {
            i = 1;
        }
        while (i2 <= i) {
            if (!z) {
                am.setImageResource(this.imi[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.imi[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.imi[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.imi[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.ilZ.setText(this.iml[i]);
    }

    public TextView cfV() {
        return this.imb;
    }

    public void T(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.imc.setVisibility(0);
            this.ima.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.ilU.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.ilU.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.imc.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.imc.setVisibility(8);
            this.ima.setVisibility(0);
            this.ima.setText(R.string.grouplevel_highest_grade);
        }
    }
}
