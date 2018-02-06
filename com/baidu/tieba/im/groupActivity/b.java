package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.g.e;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout bSe;
    private GroupActivityActivity eFV;
    private HeadImageView eFX;
    private TextView eFY;
    private LinearLayout eFZ;
    private TextView eGa;
    private TextView eGb;
    private TextView eGc;
    private TextView eGd;
    private TextView eGe;
    private LinearLayout eGf;
    private LinearLayout eGg;
    private LinearLayout eGh;
    private TextView eGi;
    private ImageView eGj;
    private ImageView eGk;
    private com.baidu.tbadk.core.dialog.b eGl;
    private TextView eGm;
    private TextView eGn;
    private View evK;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eFV = groupActivityActivity;
        groupActivityActivity.setContentView(d.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.j.group_activity));
        this.evK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eFY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.edit));
        this.eFY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aJG();
                b.this.eGl.AX();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eFY.setVisibility(8);
        this.eGm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.delete));
        this.eGm.setOnClickListener(groupActivityActivity);
        this.eGm.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bSe = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.eFZ = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.eFX = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.eFX.setAutoChangeStyle(true);
        this.eFX.setIsRound(false);
        this.eGa = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.eGb = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.eGc = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.eGd = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.eGe = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.eGf = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.eGg = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.eGh = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.eGi = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.eGk = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.eGj = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eGn = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eGn.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eGn.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eFZ.getVisibility() != 0) {
                this.eFZ.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eFX.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eGa.setText(groupActivityData.getgActivityTitle());
            this.eGb.setText(this.eFV.getResources().getString(d.j.group_activity_creator) + "：" + groupActivityData.getUserName());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eFY.setVisibility(8);
                    this.eGm.setVisibility(0);
                    if (com.baidu.tieba.group.a.aBS().aBT() || z) {
                        this.eGn.setVisibility(8);
                    } else {
                        this.eGn.setVisibility(0);
                        com.baidu.tieba.group.a.aBS().gH(true);
                        e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eGn != null) {
                                    b.this.eGn.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eFY.setVisibility(0);
                    this.eGm.setVisibility(8);
                }
            } else {
                this.eFY.setVisibility(8);
                this.eGm.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eGi.setVisibility(0);
                aj.c(this.eGk, d.f.icon_activity_time_n);
                aj.c(this.eGj, d.f.icon_activity_lbs_n);
                aj.e(this.eGd, d.C0140d.common_color_10106, 1);
                aj.e(this.eGe, d.C0140d.common_color_10106, 1);
            } else {
                this.eGi.setVisibility(8);
                aj.c(this.eGk, d.f.icon_activity_time_s);
                aj.c(this.eGj, d.f.icon_activity_lbs_s);
                aj.e(this.eGd, d.C0140d.common_color_10039, 1);
                aj.e(this.eGe, d.C0140d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eGf.setVisibility(8);
            } else {
                this.eGf.setVisibility(0);
                this.eGc.setText(groupActivityData.getgActivityContent());
            }
            if (groupActivityData.getgActivityTime() > 0) {
                Date date = new Date(groupActivityData.getgActivityTime() * 1000);
                int year = date.getYear() + 1900;
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
                sb.append(am.v(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.eFV.getResources().getString(d.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eFV.getResources().getString(d.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eGd.setText(sb.toString());
            } else {
                this.eGd.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eGg.setVisibility(8);
                aj.s(this.eGh, d.f.bg_activity_down);
                return;
            }
            this.eGg.setVisibility(0);
            this.eGe.setText(groupActivityData.getgActivityArea());
            aj.s(this.eGh, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eFV.getLayoutMode().aQ(i == 1);
        this.eFV.getLayoutMode().aM(this.bSe);
        this.mNavigationBar.onChangeSkinType(this.eFV.getPageContext(), i);
        this.eFY.setTextColor(aj.getColor(d.C0140d.cp_cont_f));
        this.eGm.setTextColor(aj.getColor(d.C0140d.cp_cont_f));
    }

    public void onDestory() {
        this.eGn = null;
    }

    public View aJD() {
        return this.evK;
    }

    public TextView aJE() {
        return this.eGm;
    }

    public com.baidu.tbadk.core.dialog.b aJF() {
        return this.eGl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJG() {
        if (this.eGl == null) {
            CharSequence[] charSequenceArr = {this.eFV.getPageContext().getString(d.j.group_activity_eidt), this.eFV.getPageContext().getString(d.j.group_activity_delete)};
            this.eGl = new com.baidu.tbadk.core.dialog.b(this.eFV.getPageContext().getPageActivity());
            this.eGl.dl(this.eFV.getPageContext().getString(d.j.operation));
            this.eGl.a(charSequenceArr, this.eFV);
            this.eGl.d(this.eFV.getPageContext());
        }
    }
}
