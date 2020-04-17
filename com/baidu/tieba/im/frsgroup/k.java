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
    private View idJ;
    private GroupLevelActivity ilO;
    private ImageView ilP;
    private ImageView ilQ;
    private ImageView ilR;
    private TextView ilS;
    private TextView ilT;
    private TextView ilU;
    private TextView ilV;
    private TextView ilW;
    private TextView ilX;
    private TextView ilY;
    private TextView ilZ;
    private TextView ima;
    private ImageView[] imb;
    private TextView[] imc;
    private TextView[] imd;
    private String[] ime;
    private TextView imf;
    private TextView imh;
    private boolean isMem;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.imb = new ImageView[4];
        this.imc = new TextView[4];
        this.imd = new TextView[4];
        this.ime = new String[4];
        this.mNavigationBar = null;
        this.ilO = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.idJ.setOnClickListener(this.ilO);
        this.imf.setOnClickListener(this.ilO);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.ilP = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.ilQ = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.ilR = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.ilS = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.ilT = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.ilU = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.ilW = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.ilX = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.ilO.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.ilX.setText(spannableString);
        this.ilV = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.ilY = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.ilZ = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.ima = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.imd[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.imd[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.imd[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.imb[1] = this.ilP;
        this.imb[2] = this.ilQ;
        this.imb[3] = this.ilR;
        this.ime[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.ime[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.ime[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.imc[1] = this.ilY;
        this.imc[2] = this.ilZ;
        this.imc[3] = this.ima;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.ilO.getResources().getString(R.string.group_info_grade));
        this.idJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.imf = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.imh = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.imf.setVisibility(8);
            this.imh.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.ilS.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            am.setViewTextColor(this.ilS, R.color.common_color_10167, 1);
        } else {
            this.ilS.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            am.setViewTextColor(this.ilS, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.imf.setVisibility(8);
            this.imh.setVisibility(8);
            return;
        }
        this.imf.setVisibility(0);
        this.imh.setVisibility(0);
        if (z3 && i > 0) {
            this.imf.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            am.setViewTextColor(this.imf, R.color.cp_cont_a, 1);
            this.imf.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.imf.setEnabled(false);
            am.setViewTextColor(this.imf, R.color.common_color_10172, 1);
        }
        this.imh.setText(string);
    }

    public View cfT() {
        return this.idJ;
    }

    public TextView cfU() {
        return this.imf;
    }

    public void onChangeSkinType(int i) {
        this.ilO.getLayoutMode().setNightMode(i == 1);
        this.ilO.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.ilO.getPageContext(), i);
    }

    public TextView[] cfV() {
        return this.imc;
    }

    public TextView[] cfW() {
        return this.imd;
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
                am.setImageResource(this.imb[i2], R.drawable.icon_grade_big_star_s);
            } else {
                am.setImageResource(this.imb[i2], R.drawable.icon_vip_grade_big_star_s);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (!z) {
                am.setImageResource(this.imb[i2], R.drawable.icon_grade_big_star_n);
            } else {
                am.setImageResource(this.imb[i2], R.drawable.icon_vip_grade_big_star_n);
            }
            i2++;
        }
        this.ilT.setText(this.ime[i]);
    }

    public TextView cfX() {
        return this.ilV;
    }

    public void T(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.ilW.setVisibility(0);
            this.ilU.setVisibility(8);
            int color = am.getColor(R.color.cp_cont_b);
            int color2 = am.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.ilO.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.ilO.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.ilW.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.ilW.setVisibility(8);
            this.ilU.setVisibility(0);
            this.ilU.setText(R.string.grouplevel_highest_grade);
        }
    }
}
