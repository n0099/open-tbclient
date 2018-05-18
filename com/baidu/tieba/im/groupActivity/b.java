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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout bbZ;
    private View dRy;
    private GroupActivityActivity ebI;
    private HeadImageView ebK;
    private TextView ebL;
    private LinearLayout ebM;
    private TextView ebN;
    private TextView ebO;
    private TextView ebP;
    private TextView ebQ;
    private TextView ebR;
    private LinearLayout ebS;
    private LinearLayout ebT;
    private LinearLayout ebU;
    private TextView ebV;
    private ImageView ebW;
    private ImageView ebX;
    private com.baidu.tbadk.core.dialog.b ebY;
    private TextView ebZ;
    private TextView eca;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.ebI = groupActivityActivity;
        groupActivityActivity.setContentView(d.i.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.k.group_activity));
        this.dRy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.ebL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.edit));
        this.ebL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aEB();
                b.this.ebY.tF();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.ebL.setVisibility(8);
        this.ebZ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.delete));
        this.ebZ.setOnClickListener(groupActivityActivity);
        this.ebZ.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bbZ = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.ebM = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.ebK = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.ebK.setAutoChangeStyle(true);
        this.ebK.setIsRound(false);
        this.ebN = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.ebO = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.ebP = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.ebQ = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.ebR = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.ebS = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.ebT = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.ebU = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.ebV = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.ebX = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.ebW = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eca = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eca.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eca.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.ebM.getVisibility() != 0) {
                this.ebM.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.ebK.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.ebN.setText(groupActivityData.getgActivityTitle());
            this.ebO.setText(this.ebI.getResources().getString(d.k.group_activity_creator) + "：" + groupActivityData.getUserName());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.ebL.setVisibility(8);
                    this.ebZ.setVisibility(0);
                    if (com.baidu.tieba.group.a.awN().awO() || z) {
                        this.eca.setVisibility(8);
                    } else {
                        this.eca.setVisibility(0);
                        com.baidu.tieba.group.a.awN().gn(true);
                        e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eca != null) {
                                    b.this.eca.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.ebL.setVisibility(0);
                    this.ebZ.setVisibility(8);
                }
            } else {
                this.ebL.setVisibility(8);
                this.ebZ.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.ebV.setVisibility(0);
                ak.c(this.ebX, d.f.icon_activity_time_n);
                ak.c(this.ebW, d.f.icon_activity_lbs_n);
                ak.c(this.ebQ, d.C0126d.common_color_10106, 1);
                ak.c(this.ebR, d.C0126d.common_color_10106, 1);
            } else {
                this.ebV.setVisibility(8);
                ak.c(this.ebX, d.f.icon_activity_time_s);
                ak.c(this.ebW, d.f.icon_activity_lbs_s);
                ak.c(this.ebQ, d.C0126d.common_color_10039, 1);
                ak.c(this.ebR, d.C0126d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.ebS.setVisibility(8);
            } else {
                this.ebS.setVisibility(0);
                this.ebP.setText(groupActivityData.getgActivityContent());
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
                sb.append(an.k(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.ebI.getResources().getString(d.k.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.ebI.getResources().getString(d.k.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.ebQ.setText(sb.toString());
            } else {
                this.ebQ.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.ebT.setVisibility(8);
                ak.i(this.ebU, d.f.bg_activity_down);
                return;
            }
            this.ebT.setVisibility(0);
            this.ebR.setText(groupActivityData.getgActivityArea());
            ak.i(this.ebU, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.ebI.getLayoutMode().setNightMode(i == 1);
        this.ebI.getLayoutMode().u(this.bbZ);
        this.mNavigationBar.onChangeSkinType(this.ebI.getPageContext(), i);
        this.ebL.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
        this.ebZ.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
    }

    public void onDestory() {
        this.eca = null;
    }

    public View aEy() {
        return this.dRy;
    }

    public TextView aEz() {
        return this.ebZ;
    }

    public com.baidu.tbadk.core.dialog.b aEA() {
        return this.ebY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEB() {
        if (this.ebY == null) {
            CharSequence[] charSequenceArr = {this.ebI.getPageContext().getString(d.k.group_activity_eidt), this.ebI.getPageContext().getString(d.k.group_activity_delete)};
            this.ebY = new com.baidu.tbadk.core.dialog.b(this.ebI.getPageContext().getPageActivity());
            this.ebY.dd(this.ebI.getPageContext().getString(d.k.operation));
            this.ebY.a(charSequenceArr, this.ebI);
            this.ebY.d(this.ebI.getPageContext());
        }
    }
}
