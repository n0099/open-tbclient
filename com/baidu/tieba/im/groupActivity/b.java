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
    private RelativeLayout bRU;
    private GroupActivityActivity eFZ;
    private HeadImageView eGb;
    private TextView eGc;
    private LinearLayout eGd;
    private TextView eGe;
    private TextView eGf;
    private TextView eGg;
    private TextView eGh;
    private TextView eGi;
    private LinearLayout eGj;
    private LinearLayout eGk;
    private LinearLayout eGl;
    private TextView eGm;
    private ImageView eGn;
    private ImageView eGo;
    private com.baidu.tbadk.core.dialog.b eGp;
    private TextView eGq;
    private TextView eGr;
    private View evO;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eFZ = groupActivityActivity;
        groupActivityActivity.setContentView(d.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.j.group_activity));
        this.evO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eGc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.edit));
        this.eGc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aJG();
                b.this.eGp.AY();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eGc.setVisibility(8);
        this.eGq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.j.delete));
        this.eGq.setOnClickListener(groupActivityActivity);
        this.eGq.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bRU = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.eGd = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.eGb = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.eGb.setAutoChangeStyle(true);
        this.eGb.setIsRound(false);
        this.eGe = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.eGf = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.eGg = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.eGh = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.eGi = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.eGj = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.eGk = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.eGl = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.eGm = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.eGo = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.eGn = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eGr = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eGr.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eGr.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eGd.getVisibility() != 0) {
                this.eGd.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eGb.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eGe.setText(groupActivityData.getgActivityTitle());
            this.eGf.setText(this.eFZ.getResources().getString(d.j.group_activity_creator) + "：" + groupActivityData.getUserName());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eGc.setVisibility(8);
                    this.eGq.setVisibility(0);
                    if (com.baidu.tieba.group.a.aBS().aBT() || z) {
                        this.eGr.setVisibility(8);
                    } else {
                        this.eGr.setVisibility(0);
                        com.baidu.tieba.group.a.aBS().gM(true);
                        e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eGr != null) {
                                    b.this.eGr.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eGc.setVisibility(0);
                    this.eGq.setVisibility(8);
                }
            } else {
                this.eGc.setVisibility(8);
                this.eGq.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eGm.setVisibility(0);
                aj.c(this.eGo, d.f.icon_activity_time_n);
                aj.c(this.eGn, d.f.icon_activity_lbs_n);
                aj.e(this.eGh, d.C0141d.common_color_10106, 1);
                aj.e(this.eGi, d.C0141d.common_color_10106, 1);
            } else {
                this.eGm.setVisibility(8);
                aj.c(this.eGo, d.f.icon_activity_time_s);
                aj.c(this.eGn, d.f.icon_activity_lbs_s);
                aj.e(this.eGh, d.C0141d.common_color_10039, 1);
                aj.e(this.eGi, d.C0141d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eGj.setVisibility(8);
            } else {
                this.eGj.setVisibility(0);
                this.eGg.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eFZ.getResources().getString(d.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eFZ.getResources().getString(d.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eGh.setText(sb.toString());
            } else {
                this.eGh.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eGk.setVisibility(8);
                aj.s(this.eGl, d.f.bg_activity_down);
                return;
            }
            this.eGk.setVisibility(0);
            this.eGi.setText(groupActivityData.getgActivityArea());
            aj.s(this.eGl, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eFZ.getLayoutMode().aQ(i == 1);
        this.eFZ.getLayoutMode().aM(this.bRU);
        this.mNavigationBar.onChangeSkinType(this.eFZ.getPageContext(), i);
        this.eGc.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
        this.eGq.setTextColor(aj.getColor(d.C0141d.cp_cont_f));
    }

    public void onDestory() {
        this.eGr = null;
    }

    public View aJD() {
        return this.evO;
    }

    public TextView aJE() {
        return this.eGq;
    }

    public com.baidu.tbadk.core.dialog.b aJF() {
        return this.eGp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJG() {
        if (this.eGp == null) {
            CharSequence[] charSequenceArr = {this.eFZ.getPageContext().getString(d.j.group_activity_eidt), this.eFZ.getPageContext().getString(d.j.group_activity_delete)};
            this.eGp = new com.baidu.tbadk.core.dialog.b(this.eFZ.getPageContext().getPageActivity());
            this.eGp.dl(this.eFZ.getPageContext().getString(d.j.operation));
            this.eGp.a(charSequenceArr, this.eFZ);
            this.eGp.d(this.eFZ.getPageContext());
        }
    }
}
