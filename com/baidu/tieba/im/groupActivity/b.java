package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout bAz;
    private View eKB;
    private GroupActivityActivity eUG;
    private HeadImageView eUI;
    private TextView eUJ;
    private LinearLayout eUK;
    private TextView eUL;
    private TextView eUM;
    private TextView eUN;
    private TextView eUO;
    private TextView eUP;
    private LinearLayout eUQ;
    private LinearLayout eUR;
    private LinearLayout eUS;
    private TextView eUT;
    private ImageView eUU;
    private ImageView eUV;
    private com.baidu.tbadk.core.dialog.b eUW;
    private TextView eUX;
    private TextView eUY;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eUG = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.eKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eUJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eUJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aSH();
                b.this.eUW.BI();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eUJ.setVisibility(8);
        this.eUX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eUX.setOnClickListener(groupActivityActivity);
        this.eUX.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bAz = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eUK = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eUI = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eUI.setAutoChangeStyle(true);
        this.eUI.setIsRound(false);
        this.eUL = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eUM = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eUN = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eUO = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eUP = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eUQ = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eUR = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eUS = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eUT = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eUV = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eUU = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eUY = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eUY.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eUY.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eUK.getVisibility() != 0) {
                this.eUK.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eUI.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eUL.setText(groupActivityData.getgActivityTitle());
            this.eUM.setText(this.eUG.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eUJ.setVisibility(8);
                    this.eUX.setVisibility(0);
                    if (com.baidu.tieba.group.a.aKA().aKB() || z) {
                        this.eUY.setVisibility(8);
                    } else {
                        this.eUY.setVisibility(0);
                        com.baidu.tieba.group.a.aKA().hK(true);
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eUY != null) {
                                    b.this.eUY.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eUJ.setVisibility(0);
                    this.eUX.setVisibility(8);
                }
            } else {
                this.eUJ.setVisibility(8);
                this.eUX.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eUT.setVisibility(0);
                al.c(this.eUV, e.f.icon_activity_time_n);
                al.c(this.eUU, e.f.icon_activity_lbs_n);
                al.c(this.eUO, e.d.common_color_10106, 1);
                al.c(this.eUP, e.d.common_color_10106, 1);
            } else {
                this.eUT.setVisibility(8);
                al.c(this.eUV, e.f.icon_activity_time_s);
                al.c(this.eUU, e.f.icon_activity_lbs_s);
                al.c(this.eUO, e.d.common_color_10039, 1);
                al.c(this.eUP, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eUQ.setVisibility(8);
            } else {
                this.eUQ.setVisibility(0);
                this.eUN.setText(groupActivityData.getgActivityContent());
            }
            if (groupActivityData.getgActivityTime() > 0) {
                Date date = new Date(groupActivityData.getgActivityTime() * 1000);
                int year = date.getYear() + BdDatePicker.START_YEAR;
                int month = date.getMonth();
                int date2 = date.getDate();
                int hours = date.getHours();
                int minutes = date.getMinutes();
                StringBuilder sb = new StringBuilder();
                sb.append(year);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(month + 1);
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb.append(date2);
                sb.append(" ");
                sb.append(ao.m(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.eUG.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eUG.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eUO.setText(sb.toString());
            } else {
                this.eUO.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eUR.setVisibility(8);
                al.i(this.eUS, e.f.bg_activity_down);
                return;
            }
            this.eUR.setVisibility(0);
            this.eUP.setText(groupActivityData.getgActivityArea());
            al.i(this.eUS, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eUG.getLayoutMode().setNightMode(i == 1);
        this.eUG.getLayoutMode().onModeChanged(this.bAz);
        this.mNavigationBar.onChangeSkinType(this.eUG.getPageContext(), i);
        this.eUJ.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eUX.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eUY = null;
    }

    public View aSE() {
        return this.eKB;
    }

    public TextView aSF() {
        return this.eUX;
    }

    public com.baidu.tbadk.core.dialog.b aSG() {
        return this.eUW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aSH() {
        if (this.eUW == null) {
            CharSequence[] charSequenceArr = {this.eUG.getPageContext().getString(e.j.group_activity_eidt), this.eUG.getPageContext().getString(e.j.group_activity_delete)};
            this.eUW = new com.baidu.tbadk.core.dialog.b(this.eUG.getPageContext().getPageActivity());
            this.eUW.eC(this.eUG.getPageContext().getString(e.j.operation));
            this.eUW.a(charSequenceArr, this.eUG);
            this.eUW.d(this.eUG.getPageContext());
        }
    }
}
