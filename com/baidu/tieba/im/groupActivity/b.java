package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.g.e;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes5.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout cMr;
    private View gbp;
    private GroupActivityActivity glB;
    private HeadImageView glD;
    private TextView glE;
    private LinearLayout glF;
    private TextView glG;
    private TextView glH;
    private TextView glI;
    private TextView glJ;
    private TextView glK;
    private LinearLayout glL;
    private LinearLayout glM;
    private LinearLayout glN;
    private TextView glO;
    private ImageView glP;
    private ImageView glQ;
    private g glR;
    private TextView glS;
    private TextView glT;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.glB = groupActivityActivity;
        groupActivityActivity.setContentView(d.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.j.group_activity));
        this.gbp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.glE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.edit));
        this.glE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.btM();
                b.this.glR.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.glE.setVisibility(8);
        this.glS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.delete));
        this.glS.setOnClickListener(groupActivityActivity);
        this.glS.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cMr = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.glF = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.glD = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.glD.setAutoChangeStyle(true);
        this.glD.setIsRound(false);
        this.glG = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.glH = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.glI = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.glJ = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.glK = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.glL = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.glM = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.glN = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.glO = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.glQ = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.glP = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.glT = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glT.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.glT.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.glF.getVisibility() != 0) {
                this.glF.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.glD.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.glG.setText(groupActivityData.getgActivityTitle());
            this.glH.setText(this.glB.getResources().getString(d.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.glE.setVisibility(8);
                    this.glS.setVisibility(0);
                    if (com.baidu.tieba.group.a.blf().blg() || z) {
                        this.glT.setVisibility(8);
                    } else {
                        this.glT.setVisibility(0);
                        com.baidu.tieba.group.a.blf().ke(true);
                        e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.glT != null) {
                                    b.this.glT.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.glE.setVisibility(0);
                    this.glS.setVisibility(8);
                }
            } else {
                this.glE.setVisibility(8);
                this.glS.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.glO.setVisibility(0);
                al.c(this.glQ, d.f.icon_activity_time_n);
                al.c(this.glP, d.f.icon_activity_lbs_n);
                al.d(this.glJ, d.C0277d.common_color_10106, 1);
                al.d(this.glK, d.C0277d.common_color_10106, 1);
            } else {
                this.glO.setVisibility(8);
                al.c(this.glQ, d.f.icon_activity_time_s);
                al.c(this.glP, d.f.icon_activity_lbs_s);
                al.d(this.glJ, d.C0277d.common_color_10039, 1);
                al.d(this.glK, d.C0277d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.glL.setVisibility(8);
            } else {
                this.glL.setVisibility(0);
                this.glI.setText(groupActivityData.getgActivityContent());
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
                sb.append(ap.p(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.glB.getResources().getString(d.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.glB.getResources().getString(d.j.morning));
                    sb.append(hours);
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.glJ.setText(sb.toString());
            } else {
                this.glJ.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.glM.setVisibility(8);
                al.k(this.glN, d.f.bg_activity_down);
                return;
            }
            this.glM.setVisibility(0);
            this.glK.setText(groupActivityData.getgActivityArea());
            al.k(this.glN, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.glB.getLayoutMode().setNightMode(i == 1);
        this.glB.getLayoutMode().onModeChanged(this.cMr);
        this.mNavigationBar.onChangeSkinType(this.glB.getPageContext(), i);
        this.glE.setTextColor(al.getColor(d.C0277d.cp_cont_f));
        this.glS.setTextColor(al.getColor(d.C0277d.cp_cont_f));
    }

    public void onDestory() {
        this.glT = null;
    }

    public View btJ() {
        return this.gbp;
    }

    public TextView btK() {
        return this.glS;
    }

    public g btL() {
        return this.glR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btM() {
        if (this.glR == null) {
            String[] strArr = {this.glB.getPageContext().getString(d.j.group_activity_eidt), this.glB.getPageContext().getString(d.j.group_activity_delete)};
            this.glR = new g(this.glB.getPageContext());
            this.glR.a(null, strArr, this.glB);
        }
    }
}
