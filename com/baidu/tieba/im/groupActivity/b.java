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
    private RelativeLayout bbY;
    private View dQr;
    private GroupActivityActivity eaB;
    private HeadImageView eaD;
    private TextView eaE;
    private LinearLayout eaF;
    private TextView eaG;
    private TextView eaH;
    private TextView eaI;
    private TextView eaJ;
    private TextView eaK;
    private LinearLayout eaL;
    private LinearLayout eaM;
    private LinearLayout eaN;
    private TextView eaO;
    private ImageView eaP;
    private ImageView eaQ;
    private com.baidu.tbadk.core.dialog.b eaR;
    private TextView eaS;
    private TextView eaT;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eaB = groupActivityActivity;
        groupActivityActivity.setContentView(d.i.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.k.group_activity));
        this.dQr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eaE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.edit));
        this.eaE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aED();
                b.this.eaR.tG();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eaE.setVisibility(8);
        this.eaS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.delete));
        this.eaS.setOnClickListener(groupActivityActivity);
        this.eaS.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bbY = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.eaF = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.eaD = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.eaD.setAutoChangeStyle(true);
        this.eaD.setIsRound(false);
        this.eaG = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.eaH = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.eaI = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.eaJ = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.eaK = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.eaL = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.eaM = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.eaN = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.eaO = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.eaQ = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.eaP = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eaT = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eaT.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eaT.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eaF.getVisibility() != 0) {
                this.eaF.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eaD.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eaG.setText(groupActivityData.getgActivityTitle());
            this.eaH.setText(this.eaB.getResources().getString(d.k.group_activity_creator) + "：" + groupActivityData.getUserName());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eaE.setVisibility(8);
                    this.eaS.setVisibility(0);
                    if (com.baidu.tieba.group.a.awO().awP() || z) {
                        this.eaT.setVisibility(8);
                    } else {
                        this.eaT.setVisibility(0);
                        com.baidu.tieba.group.a.awO().gm(true);
                        e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eaT != null) {
                                    b.this.eaT.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eaE.setVisibility(0);
                    this.eaS.setVisibility(8);
                }
            } else {
                this.eaE.setVisibility(8);
                this.eaS.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eaO.setVisibility(0);
                ak.c(this.eaQ, d.f.icon_activity_time_n);
                ak.c(this.eaP, d.f.icon_activity_lbs_n);
                ak.c(this.eaJ, d.C0126d.common_color_10106, 1);
                ak.c(this.eaK, d.C0126d.common_color_10106, 1);
            } else {
                this.eaO.setVisibility(8);
                ak.c(this.eaQ, d.f.icon_activity_time_s);
                ak.c(this.eaP, d.f.icon_activity_lbs_s);
                ak.c(this.eaJ, d.C0126d.common_color_10039, 1);
                ak.c(this.eaK, d.C0126d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eaL.setVisibility(8);
            } else {
                this.eaL.setVisibility(0);
                this.eaI.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eaB.getResources().getString(d.k.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eaB.getResources().getString(d.k.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eaJ.setText(sb.toString());
            } else {
                this.eaJ.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eaM.setVisibility(8);
                ak.i(this.eaN, d.f.bg_activity_down);
                return;
            }
            this.eaM.setVisibility(0);
            this.eaK.setText(groupActivityData.getgActivityArea());
            ak.i(this.eaN, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eaB.getLayoutMode().setNightMode(i == 1);
        this.eaB.getLayoutMode().u(this.bbY);
        this.mNavigationBar.onChangeSkinType(this.eaB.getPageContext(), i);
        this.eaE.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
        this.eaS.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
    }

    public void onDestory() {
        this.eaT = null;
    }

    public View aEA() {
        return this.dQr;
    }

    public TextView aEB() {
        return this.eaS;
    }

    public com.baidu.tbadk.core.dialog.b aEC() {
        return this.eaR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aED() {
        if (this.eaR == null) {
            CharSequence[] charSequenceArr = {this.eaB.getPageContext().getString(d.k.group_activity_eidt), this.eaB.getPageContext().getString(d.k.group_activity_delete)};
            this.eaR = new com.baidu.tbadk.core.dialog.b(this.eaB.getPageContext().getPageActivity());
            this.eaR.dd(this.eaB.getPageContext().getString(d.k.operation));
            this.eaR.a(charSequenceArr, this.eaB);
            this.eaR.d(this.eaB.getPageContext());
        }
    }
}
