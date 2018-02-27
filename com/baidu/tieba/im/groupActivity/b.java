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
    private RelativeLayout bRR;
    private GroupActivityActivity eFJ;
    private HeadImageView eFL;
    private TextView eFM;
    private LinearLayout eFN;
    private TextView eFO;
    private TextView eFP;
    private TextView eFQ;
    private TextView eFR;
    private TextView eFS;
    private LinearLayout eFT;
    private LinearLayout eFU;
    private LinearLayout eFV;
    private TextView eFW;
    private ImageView eFX;
    private ImageView eFY;
    private com.baidu.tbadk.core.dialog.b eFZ;
    private TextView eGa;
    private TextView eGb;
    private View evy;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eFJ = groupActivityActivity;
        groupActivityActivity.setContentView(d.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.j.group_activity));
        this.evy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eFM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.edit));
        this.eFM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aJF();
                b.this.eFZ.AX();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eFM.setVisibility(8);
        this.eGa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.delete));
        this.eGa.setOnClickListener(groupActivityActivity);
        this.eGa.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bRR = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.eFN = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.eFL = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.eFL.setAutoChangeStyle(true);
        this.eFL.setIsRound(false);
        this.eFO = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.eFP = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.eFQ = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.eFR = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.eFS = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.eFT = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.eFU = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.eFV = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.eFW = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.eFY = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.eFX = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eGb = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eGb.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eGb.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eFN.getVisibility() != 0) {
                this.eFN.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eFL.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eFO.setText(groupActivityData.getgActivityTitle());
            this.eFP.setText(this.eFJ.getResources().getString(d.j.group_activity_creator) + "：" + groupActivityData.getUserName());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eFM.setVisibility(8);
                    this.eGa.setVisibility(0);
                    if (com.baidu.tieba.group.a.aBR().aBS() || z) {
                        this.eGb.setVisibility(8);
                    } else {
                        this.eGb.setVisibility(0);
                        com.baidu.tieba.group.a.aBR().gH(true);
                        e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eGb != null) {
                                    b.this.eGb.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eFM.setVisibility(0);
                    this.eGa.setVisibility(8);
                }
            } else {
                this.eFM.setVisibility(8);
                this.eGa.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eFW.setVisibility(0);
                aj.c(this.eFY, d.f.icon_activity_time_n);
                aj.c(this.eFX, d.f.icon_activity_lbs_n);
                aj.e(this.eFR, d.C0141d.common_color_10106, 1);
                aj.e(this.eFS, d.C0141d.common_color_10106, 1);
            } else {
                this.eFW.setVisibility(8);
                aj.c(this.eFY, d.f.icon_activity_time_s);
                aj.c(this.eFX, d.f.icon_activity_lbs_s);
                aj.e(this.eFR, d.C0141d.common_color_10039, 1);
                aj.e(this.eFS, d.C0141d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eFT.setVisibility(8);
            } else {
                this.eFT.setVisibility(0);
                this.eFQ.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eFJ.getResources().getString(d.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eFJ.getResources().getString(d.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eFR.setText(sb.toString());
            } else {
                this.eFR.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eFU.setVisibility(8);
                aj.s(this.eFV, d.f.bg_activity_down);
                return;
            }
            this.eFU.setVisibility(0);
            this.eFS.setText(groupActivityData.getgActivityArea());
            aj.s(this.eFV, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eFJ.getLayoutMode().aQ(i == 1);
        this.eFJ.getLayoutMode().aM(this.bRR);
        this.mNavigationBar.onChangeSkinType(this.eFJ.getPageContext(), i);
        this.eFM.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
        this.eGa.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
    }

    public void onDestory() {
        this.eGb = null;
    }

    public View aJC() {
        return this.evy;
    }

    public TextView aJD() {
        return this.eGa;
    }

    public com.baidu.tbadk.core.dialog.b aJE() {
        return this.eFZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJF() {
        if (this.eFZ == null) {
            CharSequence[] charSequenceArr = {this.eFJ.getPageContext().getString(d.j.group_activity_eidt), this.eFJ.getPageContext().getString(d.j.group_activity_delete)};
            this.eFZ = new com.baidu.tbadk.core.dialog.b(this.eFJ.getPageContext().getPageActivity());
            this.eFZ.dl(this.eFJ.getPageContext().getString(d.j.operation));
            this.eFZ.a(charSequenceArr, this.eFJ);
            this.eFZ.d(this.eFJ.getPageContext());
        }
    }
}
