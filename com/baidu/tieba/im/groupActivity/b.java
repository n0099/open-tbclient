package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.g.e;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout bmp;
    private View ekv;
    private GroupActivityActivity euJ;
    private HeadImageView euL;
    private TextView euM;
    private LinearLayout euN;
    private TextView euO;
    private TextView euP;
    private TextView euQ;
    private TextView euR;
    private TextView euS;
    private LinearLayout euT;
    private LinearLayout euU;
    private LinearLayout euV;
    private TextView euW;
    private ImageView euX;
    private ImageView euY;
    private com.baidu.tbadk.core.dialog.b euZ;
    private TextView eva;
    private TextView evb;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.euJ = groupActivityActivity;
        groupActivityActivity.setContentView(d.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.j.group_activity));
        this.ekv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.euM = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.edit));
        this.euM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aLe();
                b.this.euZ.xi();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.euM.setVisibility(8);
        this.eva = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.delete));
        this.eva.setOnClickListener(groupActivityActivity);
        this.eva.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bmp = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.euN = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.euL = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.euL.setAutoChangeStyle(true);
        this.euL.setIsRound(false);
        this.euO = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.euP = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.euQ = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.euR = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.euS = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.euT = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.euU = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.euV = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.euW = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.euY = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.euX = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.evb = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.evb.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.evb.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.euN.getVisibility() != 0) {
                this.euN.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.euL.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.euO.setText(groupActivityData.getgActivityTitle());
            this.euP.setText(this.euJ.getResources().getString(d.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.euM.setVisibility(8);
                    this.eva.setVisibility(0);
                    if (com.baidu.tieba.group.a.aCU().aCV() || z) {
                        this.evb.setVisibility(8);
                    } else {
                        this.evb.setVisibility(0);
                        com.baidu.tieba.group.a.aCU().gF(true);
                        e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.evb != null) {
                                    b.this.evb.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.euM.setVisibility(0);
                    this.eva.setVisibility(8);
                }
            } else {
                this.euM.setVisibility(8);
                this.eva.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.euW.setVisibility(0);
                am.c(this.euY, d.f.icon_activity_time_n);
                am.c(this.euX, d.f.icon_activity_lbs_n);
                am.c(this.euR, d.C0140d.common_color_10106, 1);
                am.c(this.euS, d.C0140d.common_color_10106, 1);
            } else {
                this.euW.setVisibility(8);
                am.c(this.euY, d.f.icon_activity_time_s);
                am.c(this.euX, d.f.icon_activity_lbs_s);
                am.c(this.euR, d.C0140d.common_color_10039, 1);
                am.c(this.euS, d.C0140d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.euT.setVisibility(8);
            } else {
                this.euT.setVisibility(0);
                this.euQ.setText(groupActivityData.getgActivityContent());
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
                sb.append(ap.k(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.euJ.getResources().getString(d.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.euJ.getResources().getString(d.j.morning));
                    sb.append(hours);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.euR.setText(sb.toString());
            } else {
                this.euR.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.euU.setVisibility(8);
                am.i(this.euV, d.f.bg_activity_down);
                return;
            }
            this.euU.setVisibility(0);
            this.euS.setText(groupActivityData.getgActivityArea());
            am.i(this.euV, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.euJ.getLayoutMode().setNightMode(i == 1);
        this.euJ.getLayoutMode().onModeChanged(this.bmp);
        this.mNavigationBar.onChangeSkinType(this.euJ.getPageContext(), i);
        this.euM.setTextColor(am.getColor(d.C0140d.cp_cont_f));
        this.eva.setTextColor(am.getColor(d.C0140d.cp_cont_f));
    }

    public void onDestory() {
        this.evb = null;
    }

    public View aLb() {
        return this.ekv;
    }

    public TextView aLc() {
        return this.eva;
    }

    public com.baidu.tbadk.core.dialog.b aLd() {
        return this.euZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLe() {
        if (this.euZ == null) {
            CharSequence[] charSequenceArr = {this.euJ.getPageContext().getString(d.j.group_activity_eidt), this.euJ.getPageContext().getString(d.j.group_activity_delete)};
            this.euZ = new com.baidu.tbadk.core.dialog.b(this.euJ.getPageContext().getPageActivity());
            this.euZ.dC(this.euJ.getPageContext().getString(d.j.operation));
            this.euZ.a(charSequenceArr, this.euJ);
            this.euZ.d(this.euJ.getPageContext());
        }
    }
}
