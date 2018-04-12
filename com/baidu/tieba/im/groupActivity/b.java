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
    private View dQu;
    private GroupActivityActivity eaE;
    private HeadImageView eaG;
    private TextView eaH;
    private LinearLayout eaI;
    private TextView eaJ;
    private TextView eaK;
    private TextView eaL;
    private TextView eaM;
    private TextView eaN;
    private LinearLayout eaO;
    private LinearLayout eaP;
    private LinearLayout eaQ;
    private TextView eaR;
    private ImageView eaS;
    private ImageView eaT;
    private com.baidu.tbadk.core.dialog.b eaU;
    private TextView eaV;
    private TextView eaW;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eaE = groupActivityActivity;
        groupActivityActivity.setContentView(d.i.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.k.group_activity));
        this.dQu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eaH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.edit));
        this.eaH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                b.this.aED();
                b.this.eaU.tG();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eaH.setVisibility(8);
        this.eaV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.delete));
        this.eaV.setOnClickListener(groupActivityActivity);
        this.eaV.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bbY = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.eaI = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.eaG = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.eaG.setAutoChangeStyle(true);
        this.eaG.setIsRound(false);
        this.eaJ = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.eaK = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.eaL = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.eaM = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.eaN = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.eaO = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.eaP = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.eaQ = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.eaR = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.eaT = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.eaS = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eaW = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eaW.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eaW.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eaI.getVisibility() != 0) {
                this.eaI.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eaG.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eaJ.setText(groupActivityData.getgActivityTitle());
            this.eaK.setText(this.eaE.getResources().getString(d.k.group_activity_creator) + "：" + groupActivityData.getUserName());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eaH.setVisibility(8);
                    this.eaV.setVisibility(0);
                    if (com.baidu.tieba.group.a.awO().awP() || z) {
                        this.eaW.setVisibility(8);
                    } else {
                        this.eaW.setVisibility(0);
                        com.baidu.tieba.group.a.awO().gm(true);
                        e.fw().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eaW != null) {
                                    b.this.eaW.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eaH.setVisibility(0);
                    this.eaV.setVisibility(8);
                }
            } else {
                this.eaH.setVisibility(8);
                this.eaV.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eaR.setVisibility(0);
                ak.c(this.eaT, d.f.icon_activity_time_n);
                ak.c(this.eaS, d.f.icon_activity_lbs_n);
                ak.c(this.eaM, d.C0126d.common_color_10106, 1);
                ak.c(this.eaN, d.C0126d.common_color_10106, 1);
            } else {
                this.eaR.setVisibility(8);
                ak.c(this.eaT, d.f.icon_activity_time_s);
                ak.c(this.eaS, d.f.icon_activity_lbs_s);
                ak.c(this.eaM, d.C0126d.common_color_10039, 1);
                ak.c(this.eaN, d.C0126d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eaO.setVisibility(8);
            } else {
                this.eaO.setVisibility(0);
                this.eaL.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eaE.getResources().getString(d.k.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eaE.getResources().getString(d.k.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eaM.setText(sb.toString());
            } else {
                this.eaM.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eaP.setVisibility(8);
                ak.i(this.eaQ, d.f.bg_activity_down);
                return;
            }
            this.eaP.setVisibility(0);
            this.eaN.setText(groupActivityData.getgActivityArea());
            ak.i(this.eaQ, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eaE.getLayoutMode().setNightMode(i == 1);
        this.eaE.getLayoutMode().u(this.bbY);
        this.mNavigationBar.onChangeSkinType(this.eaE.getPageContext(), i);
        this.eaH.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
        this.eaV.setTextColor(ak.getColor(d.C0126d.cp_cont_f));
    }

    public void onDestory() {
        this.eaW = null;
    }

    public View aEA() {
        return this.dQu;
    }

    public TextView aEB() {
        return this.eaV;
    }

    public com.baidu.tbadk.core.dialog.b aEC() {
        return this.eaU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aED() {
        if (this.eaU == null) {
            CharSequence[] charSequenceArr = {this.eaE.getPageContext().getString(d.k.group_activity_eidt), this.eaE.getPageContext().getString(d.k.group_activity_delete)};
            this.eaU = new com.baidu.tbadk.core.dialog.b(this.eaE.getPageContext().getPageActivity());
            this.eaU.dd(this.eaE.getPageContext().getString(d.k.operation));
            this.eaU.a(charSequenceArr, this.eaE);
            this.eaU.d(this.eaE.getPageContext());
        }
    }
}
