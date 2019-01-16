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
    private RelativeLayout bBm;
    private View eLn;
    private TextView eVA;
    private TextView eVB;
    private TextView eVC;
    private LinearLayout eVD;
    private LinearLayout eVE;
    private LinearLayout eVF;
    private TextView eVG;
    private ImageView eVH;
    private ImageView eVI;
    private com.baidu.tbadk.core.dialog.b eVJ;
    private TextView eVK;
    private TextView eVL;
    private GroupActivityActivity eVt;
    private HeadImageView eVv;
    private TextView eVw;
    private LinearLayout eVx;
    private TextView eVy;
    private TextView eVz;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eVt = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.eLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eVw = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eVw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aTh();
                b.this.eVJ.BV();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eVw.setVisibility(8);
        this.eVK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eVK.setOnClickListener(groupActivityActivity);
        this.eVK.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bBm = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eVx = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eVv = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eVv.setAutoChangeStyle(true);
        this.eVv.setIsRound(false);
        this.eVy = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eVz = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eVA = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eVB = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eVC = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eVD = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eVE = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eVF = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eVG = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eVI = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eVH = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eVL = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eVL.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eVL.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eVx.getVisibility() != 0) {
                this.eVx.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eVv.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eVy.setText(groupActivityData.getgActivityTitle());
            this.eVz.setText(this.eVt.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eVw.setVisibility(8);
                    this.eVK.setVisibility(0);
                    if (com.baidu.tieba.group.a.aKY().aKZ() || z) {
                        this.eVL.setVisibility(8);
                    } else {
                        this.eVL.setVisibility(0);
                        com.baidu.tieba.group.a.aKY().hK(true);
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eVL != null) {
                                    b.this.eVL.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eVw.setVisibility(0);
                    this.eVK.setVisibility(8);
                }
            } else {
                this.eVw.setVisibility(8);
                this.eVK.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eVG.setVisibility(0);
                al.c(this.eVI, e.f.icon_activity_time_n);
                al.c(this.eVH, e.f.icon_activity_lbs_n);
                al.c(this.eVB, e.d.common_color_10106, 1);
                al.c(this.eVC, e.d.common_color_10106, 1);
            } else {
                this.eVG.setVisibility(8);
                al.c(this.eVI, e.f.icon_activity_time_s);
                al.c(this.eVH, e.f.icon_activity_lbs_s);
                al.c(this.eVB, e.d.common_color_10039, 1);
                al.c(this.eVC, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eVD.setVisibility(8);
            } else {
                this.eVD.setVisibility(0);
                this.eVA.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eVt.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eVt.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eVB.setText(sb.toString());
            } else {
                this.eVB.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eVE.setVisibility(8);
                al.i(this.eVF, e.f.bg_activity_down);
                return;
            }
            this.eVE.setVisibility(0);
            this.eVC.setText(groupActivityData.getgActivityArea());
            al.i(this.eVF, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eVt.getLayoutMode().setNightMode(i == 1);
        this.eVt.getLayoutMode().onModeChanged(this.bBm);
        this.mNavigationBar.onChangeSkinType(this.eVt.getPageContext(), i);
        this.eVw.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eVK.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eVL = null;
    }

    public View aTe() {
        return this.eLn;
    }

    public TextView aTf() {
        return this.eVK;
    }

    public com.baidu.tbadk.core.dialog.b aTg() {
        return this.eVJ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        if (this.eVJ == null) {
            CharSequence[] charSequenceArr = {this.eVt.getPageContext().getString(e.j.group_activity_eidt), this.eVt.getPageContext().getString(e.j.group_activity_delete)};
            this.eVJ = new com.baidu.tbadk.core.dialog.b(this.eVt.getPageContext().getPageActivity());
            this.eVJ.eL(this.eVt.getPageContext().getString(e.j.operation));
            this.eVJ.a(charSequenceArr, this.eVt);
            this.eVJ.d(this.eVt.getPageContext());
        }
    }
}
