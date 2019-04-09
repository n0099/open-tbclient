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
    private RelativeLayout cMu;
    private View gbd;
    private LinearLayout glA;
    private LinearLayout glB;
    private TextView glC;
    private ImageView glD;
    private ImageView glE;
    private g glF;
    private TextView glG;
    private TextView glH;
    private GroupActivityActivity glp;
    private HeadImageView glr;
    private TextView gls;
    private LinearLayout glt;
    private TextView glu;
    private TextView glv;
    private TextView glw;
    private TextView glx;
    private TextView gly;
    private LinearLayout glz;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.glp = groupActivityActivity;
        groupActivityActivity.setContentView(d.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.j.group_activity));
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gls = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.edit));
        this.gls.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.btJ();
                b.this.glF.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gls.setVisibility(8);
        this.glG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.delete));
        this.glG.setOnClickListener(groupActivityActivity);
        this.glG.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cMu = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.glt = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.glr = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.glr.setAutoChangeStyle(true);
        this.glr.setIsRound(false);
        this.glu = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.glv = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.glw = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.glx = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.gly = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.glz = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.glA = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.glB = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.glC = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.glE = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.glD = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.glH = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.glH.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.glH.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.glt.getVisibility() != 0) {
                this.glt.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.glr.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.glu.setText(groupActivityData.getgActivityTitle());
            this.glv.setText(this.glp.getResources().getString(d.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gls.setVisibility(8);
                    this.glG.setVisibility(0);
                    if (com.baidu.tieba.group.a.blc().bld() || z) {
                        this.glH.setVisibility(8);
                    } else {
                        this.glH.setVisibility(0);
                        com.baidu.tieba.group.a.blc().ke(true);
                        e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.glH != null) {
                                    b.this.glH.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gls.setVisibility(0);
                    this.glG.setVisibility(8);
                }
            } else {
                this.gls.setVisibility(8);
                this.glG.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.glC.setVisibility(0);
                al.c(this.glE, d.f.icon_activity_time_n);
                al.c(this.glD, d.f.icon_activity_lbs_n);
                al.d(this.glx, d.C0277d.common_color_10106, 1);
                al.d(this.gly, d.C0277d.common_color_10106, 1);
            } else {
                this.glC.setVisibility(8);
                al.c(this.glE, d.f.icon_activity_time_s);
                al.c(this.glD, d.f.icon_activity_lbs_s);
                al.d(this.glx, d.C0277d.common_color_10039, 1);
                al.d(this.gly, d.C0277d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.glz.setVisibility(8);
            } else {
                this.glz.setVisibility(0);
                this.glw.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.glp.getResources().getString(d.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.glp.getResources().getString(d.j.morning));
                    sb.append(hours);
                    sb.append(Config.TRACE_TODAY_VISIT_SPLIT);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.glx.setText(sb.toString());
            } else {
                this.glx.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.glA.setVisibility(8);
                al.k(this.glB, d.f.bg_activity_down);
                return;
            }
            this.glA.setVisibility(0);
            this.gly.setText(groupActivityData.getgActivityArea());
            al.k(this.glB, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.glp.getLayoutMode().setNightMode(i == 1);
        this.glp.getLayoutMode().onModeChanged(this.cMu);
        this.mNavigationBar.onChangeSkinType(this.glp.getPageContext(), i);
        this.gls.setTextColor(al.getColor(d.C0277d.cp_cont_f));
        this.glG.setTextColor(al.getColor(d.C0277d.cp_cont_f));
    }

    public void onDestory() {
        this.glH = null;
    }

    public View btG() {
        return this.gbd;
    }

    public TextView btH() {
        return this.glG;
    }

    public g btI() {
        return this.glF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btJ() {
        if (this.glF == null) {
            String[] strArr = {this.glp.getPageContext().getString(d.j.group_activity_eidt), this.glp.getPageContext().getString(d.j.group_activity_delete)};
            this.glF = new g(this.glp.getPageContext());
            this.glF.a(null, strArr, this.glp);
        }
    }
}
