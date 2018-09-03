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
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout bmt;
    private View ekr;
    private GroupActivityActivity euF;
    private HeadImageView euH;
    private TextView euI;
    private LinearLayout euJ;
    private TextView euK;
    private TextView euL;
    private TextView euM;
    private TextView euN;
    private TextView euO;
    private LinearLayout euP;
    private LinearLayout euQ;
    private LinearLayout euR;
    private TextView euS;
    private ImageView euT;
    private ImageView euU;
    private com.baidu.tbadk.core.dialog.b euV;
    private TextView euW;
    private TextView euX;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.euF = groupActivityActivity;
        groupActivityActivity.setContentView(f.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(f.j.group_activity));
        this.ekr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.euI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(f.j.edit));
        this.euI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aLb();
                b.this.euV.xh();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.euI.setVisibility(8);
        this.euW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(f.j.delete));
        this.euW.setOnClickListener(groupActivityActivity);
        this.euW.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bmt = (RelativeLayout) groupActivityActivity.findViewById(f.g.group_info_container);
        this.euJ = (LinearLayout) groupActivityActivity.findViewById(f.g.lay_group_body);
        this.euH = (HeadImageView) groupActivityActivity.findViewById(f.g.group_head_pic);
        this.euH.setAutoChangeStyle(true);
        this.euH.setIsRound(false);
        this.euK = (TextView) groupActivityActivity.findViewById(f.g.tv_group_activity_name);
        this.euL = (TextView) groupActivityActivity.findViewById(f.g.txt_group_author);
        this.euM = (TextView) groupActivityActivity.findViewById(f.g.txt_group_activity_content);
        this.euN = (TextView) groupActivityActivity.findViewById(f.g.txt_group_activity_time);
        this.euO = (TextView) groupActivityActivity.findViewById(f.g.txt_group_activity_place);
        this.euP = (LinearLayout) groupActivityActivity.findViewById(f.g.lay_group_activity_content);
        this.euQ = (LinearLayout) groupActivityActivity.findViewById(f.g.lay_group_activity_place);
        this.euR = (LinearLayout) groupActivityActivity.findViewById(f.g.lay_group_activity_time);
        this.euS = (TextView) groupActivityActivity.findViewById(f.g.txt_group_activity_end);
        this.euU = (ImageView) groupActivityActivity.findViewById(f.g.img_activity_time);
        this.euT = (ImageView) groupActivityActivity.findViewById(f.g.img_activity_place);
        this.euX = (TextView) groupActivityActivity.findViewById(f.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.euX.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.euX.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.euJ.getVisibility() != 0) {
                this.euJ.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.euH.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.euK.setText(groupActivityData.getgActivityTitle());
            this.euL.setText(this.euF.getResources().getString(f.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.euI.setVisibility(8);
                    this.euW.setVisibility(0);
                    if (com.baidu.tieba.group.a.aCR().aCS() || z) {
                        this.euX.setVisibility(8);
                    } else {
                        this.euX.setVisibility(0);
                        com.baidu.tieba.group.a.aCR().gF(true);
                        e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.euX != null) {
                                    b.this.euX.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.euI.setVisibility(0);
                    this.euW.setVisibility(8);
                }
            } else {
                this.euI.setVisibility(8);
                this.euW.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.euS.setVisibility(0);
                am.c(this.euU, f.C0146f.icon_activity_time_n);
                am.c(this.euT, f.C0146f.icon_activity_lbs_n);
                am.c(this.euN, f.d.common_color_10106, 1);
                am.c(this.euO, f.d.common_color_10106, 1);
            } else {
                this.euS.setVisibility(8);
                am.c(this.euU, f.C0146f.icon_activity_time_s);
                am.c(this.euT, f.C0146f.icon_activity_lbs_s);
                am.c(this.euN, f.d.common_color_10039, 1);
                am.c(this.euO, f.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.euP.setVisibility(8);
            } else {
                this.euP.setVisibility(0);
                this.euM.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.euF.getResources().getString(f.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.euF.getResources().getString(f.j.morning));
                    sb.append(hours);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.euN.setText(sb.toString());
            } else {
                this.euN.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.euQ.setVisibility(8);
                am.i(this.euR, f.C0146f.bg_activity_down);
                return;
            }
            this.euQ.setVisibility(0);
            this.euO.setText(groupActivityData.getgActivityArea());
            am.i(this.euR, f.C0146f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.euF.getLayoutMode().setNightMode(i == 1);
        this.euF.getLayoutMode().onModeChanged(this.bmt);
        this.mNavigationBar.onChangeSkinType(this.euF.getPageContext(), i);
        this.euI.setTextColor(am.getColor(f.d.cp_cont_f));
        this.euW.setTextColor(am.getColor(f.d.cp_cont_f));
    }

    public void onDestory() {
        this.euX = null;
    }

    public View aKY() {
        return this.ekr;
    }

    public TextView aKZ() {
        return this.euW;
    }

    public com.baidu.tbadk.core.dialog.b aLa() {
        return this.euV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLb() {
        if (this.euV == null) {
            CharSequence[] charSequenceArr = {this.euF.getPageContext().getString(f.j.group_activity_eidt), this.euF.getPageContext().getString(f.j.group_activity_delete)};
            this.euV = new com.baidu.tbadk.core.dialog.b(this.euF.getPageContext().getPageActivity());
            this.euV.dC(this.euF.getPageContext().getString(f.j.operation));
            this.euV.a(charSequenceArr, this.euF);
            this.euV.d(this.euF.getPageContext());
        }
    }
}
