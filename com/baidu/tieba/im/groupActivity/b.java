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
    private RelativeLayout bBn;
    private View eLo;
    private TextView eVA;
    private TextView eVB;
    private TextView eVC;
    private TextView eVD;
    private LinearLayout eVE;
    private LinearLayout eVF;
    private LinearLayout eVG;
    private TextView eVH;
    private ImageView eVI;
    private ImageView eVJ;
    private com.baidu.tbadk.core.dialog.b eVK;
    private TextView eVL;
    private TextView eVM;
    private GroupActivityActivity eVu;
    private HeadImageView eVw;
    private TextView eVx;
    private LinearLayout eVy;
    private TextView eVz;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eVu = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.eLo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eVx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aTh();
                b.this.eVK.BV();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eVx.setVisibility(8);
        this.eVL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eVL.setOnClickListener(groupActivityActivity);
        this.eVL.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bBn = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eVy = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eVw = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eVw.setAutoChangeStyle(true);
        this.eVw.setIsRound(false);
        this.eVz = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eVA = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eVB = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eVC = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eVD = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eVE = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eVF = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eVG = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eVH = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eVJ = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eVI = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eVM = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eVM.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eVM.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eVy.getVisibility() != 0) {
                this.eVy.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eVw.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eVz.setText(groupActivityData.getgActivityTitle());
            this.eVA.setText(this.eVu.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eVx.setVisibility(8);
                    this.eVL.setVisibility(0);
                    if (com.baidu.tieba.group.a.aKY().aKZ() || z) {
                        this.eVM.setVisibility(8);
                    } else {
                        this.eVM.setVisibility(0);
                        com.baidu.tieba.group.a.aKY().hK(true);
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eVM != null) {
                                    b.this.eVM.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eVx.setVisibility(0);
                    this.eVL.setVisibility(8);
                }
            } else {
                this.eVx.setVisibility(8);
                this.eVL.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eVH.setVisibility(0);
                al.c(this.eVJ, e.f.icon_activity_time_n);
                al.c(this.eVI, e.f.icon_activity_lbs_n);
                al.c(this.eVC, e.d.common_color_10106, 1);
                al.c(this.eVD, e.d.common_color_10106, 1);
            } else {
                this.eVH.setVisibility(8);
                al.c(this.eVJ, e.f.icon_activity_time_s);
                al.c(this.eVI, e.f.icon_activity_lbs_s);
                al.c(this.eVC, e.d.common_color_10039, 1);
                al.c(this.eVD, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eVE.setVisibility(8);
            } else {
                this.eVE.setVisibility(0);
                this.eVB.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eVu.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eVu.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eVC.setText(sb.toString());
            } else {
                this.eVC.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eVF.setVisibility(8);
                al.i(this.eVG, e.f.bg_activity_down);
                return;
            }
            this.eVF.setVisibility(0);
            this.eVD.setText(groupActivityData.getgActivityArea());
            al.i(this.eVG, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eVu.getLayoutMode().setNightMode(i == 1);
        this.eVu.getLayoutMode().onModeChanged(this.bBn);
        this.mNavigationBar.onChangeSkinType(this.eVu.getPageContext(), i);
        this.eVx.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eVL.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eVM = null;
    }

    public View aTe() {
        return this.eLo;
    }

    public TextView aTf() {
        return this.eVL;
    }

    public com.baidu.tbadk.core.dialog.b aTg() {
        return this.eVK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        if (this.eVK == null) {
            CharSequence[] charSequenceArr = {this.eVu.getPageContext().getString(e.j.group_activity_eidt), this.eVu.getPageContext().getString(e.j.group_activity_delete)};
            this.eVK = new com.baidu.tbadk.core.dialog.b(this.eVu.getPageContext().getPageActivity());
            this.eVK.eL(this.eVu.getPageContext().getString(e.j.operation));
            this.eVK.a(charSequenceArr, this.eVu);
            this.eVK.d(this.eVu.getPageContext());
        }
    }
}
