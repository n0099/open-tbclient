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
    private RelativeLayout bwo;
    private GroupActivityActivity eJH;
    private HeadImageView eJJ;
    private TextView eJK;
    private LinearLayout eJL;
    private TextView eJM;
    private TextView eJN;
    private TextView eJO;
    private TextView eJP;
    private TextView eJQ;
    private LinearLayout eJR;
    private LinearLayout eJS;
    private LinearLayout eJT;
    private TextView eJU;
    private ImageView eJV;
    private ImageView eJW;
    private com.baidu.tbadk.core.dialog.b eJX;
    private TextView eJY;
    private TextView eJZ;
    private View ezB;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eJH = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.ezB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eJK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aQF();
                b.this.eJX.Ax();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eJK.setVisibility(8);
        this.eJY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eJY.setOnClickListener(groupActivityActivity);
        this.eJY.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bwo = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eJL = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eJJ = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eJJ.setAutoChangeStyle(true);
        this.eJJ.setIsRound(false);
        this.eJM = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eJN = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eJO = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eJP = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eJQ = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eJR = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eJS = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eJT = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eJU = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eJW = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eJV = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eJZ = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eJZ.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eJZ.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eJL.getVisibility() != 0) {
                this.eJL.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eJJ.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eJM.setText(groupActivityData.getgActivityTitle());
            this.eJN.setText(this.eJH.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eJK.setVisibility(8);
                    this.eJY.setVisibility(0);
                    if (com.baidu.tieba.group.a.aIw().aIx() || z) {
                        this.eJZ.setVisibility(8);
                    } else {
                        this.eJZ.setVisibility(0);
                        com.baidu.tieba.group.a.aIw().hv(true);
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eJZ != null) {
                                    b.this.eJZ.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eJK.setVisibility(0);
                    this.eJY.setVisibility(8);
                }
            } else {
                this.eJK.setVisibility(8);
                this.eJY.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eJU.setVisibility(0);
                al.c(this.eJW, e.f.icon_activity_time_n);
                al.c(this.eJV, e.f.icon_activity_lbs_n);
                al.c(this.eJP, e.d.common_color_10106, 1);
                al.c(this.eJQ, e.d.common_color_10106, 1);
            } else {
                this.eJU.setVisibility(8);
                al.c(this.eJW, e.f.icon_activity_time_s);
                al.c(this.eJV, e.f.icon_activity_lbs_s);
                al.c(this.eJP, e.d.common_color_10039, 1);
                al.c(this.eJQ, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eJR.setVisibility(8);
            } else {
                this.eJR.setVisibility(0);
                this.eJO.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eJH.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eJH.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eJP.setText(sb.toString());
            } else {
                this.eJP.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eJS.setVisibility(8);
                al.i(this.eJT, e.f.bg_activity_down);
                return;
            }
            this.eJS.setVisibility(0);
            this.eJQ.setText(groupActivityData.getgActivityArea());
            al.i(this.eJT, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eJH.getLayoutMode().setNightMode(i == 1);
        this.eJH.getLayoutMode().onModeChanged(this.bwo);
        this.mNavigationBar.onChangeSkinType(this.eJH.getPageContext(), i);
        this.eJK.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eJY.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eJZ = null;
    }

    public View aQC() {
        return this.ezB;
    }

    public TextView aQD() {
        return this.eJY;
    }

    public com.baidu.tbadk.core.dialog.b aQE() {
        return this.eJX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQF() {
        if (this.eJX == null) {
            CharSequence[] charSequenceArr = {this.eJH.getPageContext().getString(e.j.group_activity_eidt), this.eJH.getPageContext().getString(e.j.group_activity_delete)};
            this.eJX = new com.baidu.tbadk.core.dialog.b(this.eJH.getPageContext().getPageActivity());
            this.eJX.ek(this.eJH.getPageContext().getString(e.j.operation));
            this.eJX.a(charSequenceArr, this.eJH);
            this.eJX.d(this.eJH.getPageContext());
        }
    }
}
