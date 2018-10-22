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
    private GroupActivityActivity eJI;
    private HeadImageView eJK;
    private TextView eJL;
    private LinearLayout eJM;
    private TextView eJN;
    private TextView eJO;
    private TextView eJP;
    private TextView eJQ;
    private TextView eJR;
    private LinearLayout eJS;
    private LinearLayout eJT;
    private LinearLayout eJU;
    private TextView eJV;
    private ImageView eJW;
    private ImageView eJX;
    private com.baidu.tbadk.core.dialog.b eJY;
    private TextView eJZ;
    private TextView eKa;
    private View ezC;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eJI = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.ezC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eJL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eJL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aQF();
                b.this.eJY.Ax();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eJL.setVisibility(8);
        this.eJZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eJZ.setOnClickListener(groupActivityActivity);
        this.eJZ.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bwo = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eJM = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eJK = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eJK.setAutoChangeStyle(true);
        this.eJK.setIsRound(false);
        this.eJN = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eJO = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eJP = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eJQ = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eJR = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eJS = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eJT = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eJU = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eJV = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eJX = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eJW = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eKa = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eKa.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eKa.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eJM.getVisibility() != 0) {
                this.eJM.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eJK.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eJN.setText(groupActivityData.getgActivityTitle());
            this.eJO.setText(this.eJI.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eJL.setVisibility(8);
                    this.eJZ.setVisibility(0);
                    if (com.baidu.tieba.group.a.aIw().aIx() || z) {
                        this.eKa.setVisibility(8);
                    } else {
                        this.eKa.setVisibility(0);
                        com.baidu.tieba.group.a.aIw().hv(true);
                        com.baidu.adp.lib.g.e.jI().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eKa != null) {
                                    b.this.eKa.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eJL.setVisibility(0);
                    this.eJZ.setVisibility(8);
                }
            } else {
                this.eJL.setVisibility(8);
                this.eJZ.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eJV.setVisibility(0);
                al.c(this.eJX, e.f.icon_activity_time_n);
                al.c(this.eJW, e.f.icon_activity_lbs_n);
                al.c(this.eJQ, e.d.common_color_10106, 1);
                al.c(this.eJR, e.d.common_color_10106, 1);
            } else {
                this.eJV.setVisibility(8);
                al.c(this.eJX, e.f.icon_activity_time_s);
                al.c(this.eJW, e.f.icon_activity_lbs_s);
                al.c(this.eJQ, e.d.common_color_10039, 1);
                al.c(this.eJR, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eJS.setVisibility(8);
            } else {
                this.eJS.setVisibility(0);
                this.eJP.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eJI.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eJI.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eJQ.setText(sb.toString());
            } else {
                this.eJQ.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eJT.setVisibility(8);
                al.i(this.eJU, e.f.bg_activity_down);
                return;
            }
            this.eJT.setVisibility(0);
            this.eJR.setText(groupActivityData.getgActivityArea());
            al.i(this.eJU, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eJI.getLayoutMode().setNightMode(i == 1);
        this.eJI.getLayoutMode().onModeChanged(this.bwo);
        this.mNavigationBar.onChangeSkinType(this.eJI.getPageContext(), i);
        this.eJL.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eJZ.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eKa = null;
    }

    public View aQC() {
        return this.ezC;
    }

    public TextView aQD() {
        return this.eJZ;
    }

    public com.baidu.tbadk.core.dialog.b aQE() {
        return this.eJY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQF() {
        if (this.eJY == null) {
            CharSequence[] charSequenceArr = {this.eJI.getPageContext().getString(e.j.group_activity_eidt), this.eJI.getPageContext().getString(e.j.group_activity_delete)};
            this.eJY = new com.baidu.tbadk.core.dialog.b(this.eJI.getPageContext().getPageActivity());
            this.eJY.ek(this.eJI.getPageContext().getString(e.j.operation));
            this.eJY.a(charSequenceArr, this.eJI);
            this.eJY.d(this.eJI.getPageContext());
        }
    }
}
