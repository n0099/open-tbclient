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
    private View jPD;
    private GroupLevelActivity jZJ;
    private ImageView jZK;
    private ImageView jZL;
    private ImageView jZM;
    private TextView jZN;
    private TextView jZO;
    private TextView jZP;
    private TextView jZQ;
    private TextView jZR;
    private TextView jZS;
    private TextView jZT;
    private TextView jZU;
    private TextView jZV;
    private ImageView[] jZW;
    private TextView[] jZX;
    private TextView[] jZY;
    private String[] jZZ;
    private TextView kaa;
    private TextView kab;
    protected NavigationBar mNavigationBar;
    private ProgressBar mProgressBar;
    private View mRoot;

    public k(GroupLevelActivity groupLevelActivity, boolean z) {
        super(groupLevelActivity.getPageContext());
        this.jZW = new ImageView[4];
        this.jZX = new TextView[4];
        this.jZY = new TextView[4];
        this.jZZ = new String[4];
        this.mNavigationBar = null;
        this.jZJ = groupLevelActivity;
        this.isMem = z;
        groupLevelActivity.setContentView(R.layout.im_grouplevel_activity);
        e(groupLevelActivity);
        d(groupLevelActivity);
    }

    private void d(GroupLevelActivity groupLevelActivity) {
        this.jPD.setOnClickListener(this.jZJ);
        this.kaa.setOnClickListener(this.jZJ);
    }

    private void e(GroupLevelActivity groupLevelActivity) {
        this.mRoot = groupLevelActivity.findViewById(R.id.parent);
        this.mProgressBar = (ProgressBar) groupLevelActivity.findViewById(R.id.progress_loading);
        this.jZK = (ImageView) groupLevelActivity.findViewById(R.id.level_image_1);
        this.jZL = (ImageView) groupLevelActivity.findViewById(R.id.level_image_2);
        this.jZM = (ImageView) groupLevelActivity.findViewById(R.id.level_image_3);
        this.jZN = (TextView) groupLevelActivity.findViewById(R.id.text_current_level);
        this.jZO = (TextView) groupLevelActivity.findViewById(R.id.current_level);
        this.jZP = (TextView) groupLevelActivity.findViewById(R.id.grouplevel_highest);
        this.jZR = (TextView) groupLevelActivity.findViewById(R.id.active_day_surplus);
        this.jZS = (TextView) groupLevelActivity.findViewById(R.id.text_level_intro);
        SpannableString spannableString = new SpannableString(this.jZJ.getPageContext().getPageActivity().getString(R.string.grouplevel_level_intro));
        spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
        this.jZS.setText(spannableString);
        this.jZQ = (TextView) groupLevelActivity.findViewById(R.id.active_condition);
        this.jZT = (TextView) groupLevelActivity.findViewById(R.id.group_max1);
        this.jZU = (TextView) groupLevelActivity.findViewById(R.id.group_max2);
        this.jZV = (TextView) groupLevelActivity.findViewById(R.id.group_max3);
        this.jZY[1] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max1);
        this.jZY[2] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max2);
        this.jZY[3] = (TextView) groupLevelActivity.findViewById(R.id.vgroup_max3);
        this.jZW[1] = this.jZK;
        this.jZW[2] = this.jZL;
        this.jZW[3] = this.jZM;
        this.jZZ[1] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_1);
        this.jZZ[2] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_2);
        this.jZZ[3] = groupLevelActivity.getPageContext().getString(R.string.grouplevel_level_3);
        this.jZX[1] = this.jZT;
        this.jZX[2] = this.jZU;
        this.jZX[3] = this.jZV;
        this.mNavigationBar = (NavigationBar) groupLevelActivity.findViewById(R.id.grouplevel_top_bar);
        this.mNavigationBar.setSystemClickable(false);
        this.mNavigationBar.setTitleText(this.jZJ.getResources().getString(R.string.group_info_grade));
        this.jPD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kaa = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_btn);
        this.kab = (TextView) groupLevelActivity.findViewById(R.id.upgrade_mem_group_tip);
        if (this.isMem) {
            this.kaa.setVisibility(8);
            this.kab.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, boolean z3, int i) {
        String string;
        if (z) {
            this.jZN.setText(TbadkApplication.getInst().getString(R.string.grouplevel_vip_current_level));
            ap.setViewTextColor(this.jZN, R.color.common_color_10167, 1);
        } else {
            this.jZN.setText(TbadkApplication.getInst().getString(R.string.grouplevel_current_level));
            ap.setViewTextColor(this.jZN, R.color.common_color_10166, 1);
        }
        if (z || !z2) {
            this.kaa.setVisibility(8);
            this.kab.setVisibility(8);
            return;
        }
        this.kaa.setVisibility(0);
        this.kab.setVisibility(0);
        if (z3 && i > 0) {
            this.kaa.setEnabled(true);
            string = String.format(TbadkApplication.getInst().getString(R.string.upgrade_mem_group_left_num), String.valueOf(i));
            ap.setViewTextColor(this.kaa, R.color.cp_cont_a, 1);
            this.kaa.setEnabled(true);
        } else {
            if (!z3) {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_cannot_up);
            } else {
                string = TbadkApplication.getInst().getString(R.string.upgrade_mem_group_over_max_num);
            }
            this.kaa.setEnabled(false);
            ap.setViewTextColor(this.kaa, R.color.common_color_10172, 1);
        }
        this.kab.setText(string);
    }

    public View cPA() {
        return this.jPD;
    }

    public TextView cPB() {
        return this.kaa;
    }

    public void onChangeSkinType(int i) {
        this.jZJ.getLayoutMode().setNightMode(i == 1);
        this.jZJ.getLayoutMode().onModeChanged(this.mRoot);
        this.mNavigationBar.onChangeSkinType(this.jZJ.getPageContext(), i);
    }

    public TextView[] cPC() {
        return this.jZX;
    }

    public TextView[] cPD() {
        return this.jZY;
    }

    public void rJ(boolean z) {
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
                ap.setImageResource(this.jZW[i2], i5);
            } else {
                ap.setImageResource(this.jZW[i2], i3);
            }
            i2++;
        }
        while (i2 <= 3) {
            if (z) {
                ap.setImageResource(this.jZW[i2], i6);
            } else {
                ap.setImageResource(this.jZW[i2], i4);
            }
            i2++;
        }
        this.jZO.setText(this.jZZ[i]);
    }

    public TextView cPE() {
        return this.jZQ;
    }

    public void U(int i, int i2, int i3) {
        if (i >= 1 && i <= 2) {
            this.jZR.setVisibility(0);
            this.jZP.setVisibility(8);
            int color = ap.getColor(R.color.cp_cont_b);
            int color2 = ap.getColor(R.color.cp_link_tip_d);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            SpannableString spannableString = new SpannableString(this.jZJ.getPageContext().getPageActivity().getString(R.string.activte_day_tip_surplus));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            SpannableString spannableString2 = new SpannableString(String.valueOf(i3 - i2));
            spannableString2.setSpan(new ForegroundColorSpan(color2), 0, spannableString2.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString2);
            SpannableString spannableString3 = new SpannableString(this.jZJ.getPageContext().getPageActivity().getString(R.string.activte_day_tip_remind_up));
            spannableString3.setSpan(new ForegroundColorSpan(color), 0, spannableString3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString3);
            this.jZR.setText(spannableStringBuilder);
        } else if (i >= 3) {
            this.jZR.setVisibility(8);
            this.jZP.setVisibility(0);
            this.jZP.setText(R.string.grouplevel_highest_grade);
        }
    }
}
