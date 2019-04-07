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
    private RelativeLayout cMt;
    private View gbd;
    private LinearLayout glA;
    private TextView glB;
    private ImageView glC;
    private ImageView glD;
    private g glE;
    private TextView glF;
    private TextView glG;
    private GroupActivityActivity glo;
    private HeadImageView glq;
    private TextView glr;
    private LinearLayout gls;
    private TextView glt;
    private TextView glu;
    private TextView glv;
    private TextView glw;
    private TextView glx;
    private LinearLayout gly;
    private LinearLayout glz;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.glo = groupActivityActivity;
        groupActivityActivity.setContentView(d.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.j.group_activity));
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.glr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.edit));
        this.glr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.btJ();
                b.this.glE.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.glr.setVisibility(8);
        this.glF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.delete));
        this.glF.setOnClickListener(groupActivityActivity);
        this.glF.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cMt = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.gls = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.glq = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.glq.setAutoChangeStyle(true);
        this.glq.setIsRound(false);
        this.glt = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.glu = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.glv = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.glw = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.glx = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.gly = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.glz = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.glA = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.glB = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.glD = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.glC = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.glG = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glG.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.glG.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gls.getVisibility() != 0) {
                this.gls.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.glq.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.glt.setText(groupActivityData.getgActivityTitle());
            this.glu.setText(this.glo.getResources().getString(d.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.glr.setVisibility(8);
                    this.glF.setVisibility(0);
                    if (com.baidu.tieba.group.a.blc().bld() || z) {
                        this.glG.setVisibility(8);
                    } else {
                        this.glG.setVisibility(0);
                        com.baidu.tieba.group.a.blc().ke(true);
                        e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.glG != null) {
                                    b.this.glG.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.glr.setVisibility(0);
                    this.glF.setVisibility(8);
                }
            } else {
                this.glr.setVisibility(8);
                this.glF.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.glB.setVisibility(0);
                al.c(this.glD, d.f.icon_activity_time_n);
                al.c(this.glC, d.f.icon_activity_lbs_n);
                al.d(this.glw, d.C0277d.common_color_10106, 1);
                al.d(this.glx, d.C0277d.common_color_10106, 1);
            } else {
                this.glB.setVisibility(8);
                al.c(this.glD, d.f.icon_activity_time_s);
                al.c(this.glC, d.f.icon_activity_lbs_s);
                al.d(this.glw, d.C0277d.common_color_10039, 1);
                al.d(this.glx, d.C0277d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gly.setVisibility(8);
            } else {
                this.gly.setVisibility(0);
                this.glv.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.glo.getResources().getString(d.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.glo.getResources().getString(d.j.morning));
                    sb.append(hours);
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.glw.setText(sb.toString());
            } else {
                this.glw.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.glz.setVisibility(8);
                al.k(this.glA, d.f.bg_activity_down);
                return;
            }
            this.glz.setVisibility(0);
            this.glx.setText(groupActivityData.getgActivityArea());
            al.k(this.glA, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.glo.getLayoutMode().setNightMode(i == 1);
        this.glo.getLayoutMode().onModeChanged(this.cMt);
        this.mNavigationBar.onChangeSkinType(this.glo.getPageContext(), i);
        this.glr.setTextColor(al.getColor(d.C0277d.cp_cont_f));
        this.glF.setTextColor(al.getColor(d.C0277d.cp_cont_f));
    }

    public void onDestory() {
        this.glG = null;
    }

    public View btG() {
        return this.gbd;
    }

    public TextView btH() {
        return this.glF;
    }

    public g btI() {
        return this.glE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btJ() {
        if (this.glE == null) {
            String[] strArr = {this.glo.getPageContext().getString(d.j.group_activity_eidt), this.glo.getPageContext().getString(d.j.group_activity_delete)};
            this.glE = new g(this.glo.getPageContext());
            this.glE.a(null, strArr, this.glo);
        }
    }
}
