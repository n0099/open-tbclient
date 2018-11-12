package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.searchbox.ng.ai.apps.res.ui.BdDatePicker;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout bwZ;
    private View eAV;
    private GroupActivityActivity eLa;
    private HeadImageView eLc;
    private TextView eLd;
    private LinearLayout eLe;
    private TextView eLf;
    private TextView eLg;
    private TextView eLh;
    private TextView eLi;
    private TextView eLj;
    private LinearLayout eLk;
    private LinearLayout eLl;
    private LinearLayout eLm;
    private TextView eLn;
    private ImageView eLo;
    private ImageView eLp;
    private com.baidu.tbadk.core.dialog.b eLq;
    private TextView eLr;
    private TextView eLs;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eLa = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.eAV = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eLd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eLd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aQc();
                b.this.eLq.AE();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eLd.setVisibility(8);
        this.eLr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eLr.setOnClickListener(groupActivityActivity);
        this.eLr.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bwZ = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eLe = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eLc = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eLc.setAutoChangeStyle(true);
        this.eLc.setIsRound(false);
        this.eLf = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eLg = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eLh = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eLi = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eLj = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eLk = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eLl = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eLm = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eLn = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eLp = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eLo = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eLs = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLs.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eLs.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eLe.getVisibility() != 0) {
                this.eLe.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eLc.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eLf.setText(groupActivityData.getgActivityTitle());
            this.eLg.setText(this.eLa.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eLd.setVisibility(8);
                    this.eLr.setVisibility(0);
                    if (com.baidu.tieba.group.a.aHU().aHV() || z) {
                        this.eLs.setVisibility(8);
                    } else {
                        this.eLs.setVisibility(0);
                        com.baidu.tieba.group.a.aHU().hF(true);
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eLs != null) {
                                    b.this.eLs.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eLd.setVisibility(0);
                    this.eLr.setVisibility(8);
                }
            } else {
                this.eLd.setVisibility(8);
                this.eLr.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eLn.setVisibility(0);
                al.c(this.eLp, e.f.icon_activity_time_n);
                al.c(this.eLo, e.f.icon_activity_lbs_n);
                al.c(this.eLi, e.d.common_color_10106, 1);
                al.c(this.eLj, e.d.common_color_10106, 1);
            } else {
                this.eLn.setVisibility(8);
                al.c(this.eLp, e.f.icon_activity_time_s);
                al.c(this.eLo, e.f.icon_activity_lbs_s);
                al.c(this.eLi, e.d.common_color_10039, 1);
                al.c(this.eLj, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eLk.setVisibility(8);
            } else {
                this.eLk.setVisibility(0);
                this.eLh.setText(groupActivityData.getgActivityContent());
            }
            if (groupActivityData.getgActivityTime() > 0) {
                Date date = new Date(groupActivityData.getgActivityTime() * 1000);
                int year = date.getYear() + BdDatePicker.START_YEAR;
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
                sb.append(ao.m(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.eLa.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eLa.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eLi.setText(sb.toString());
            } else {
                this.eLi.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eLl.setVisibility(8);
                al.i(this.eLm, e.f.bg_activity_down);
                return;
            }
            this.eLl.setVisibility(0);
            this.eLj.setText(groupActivityData.getgActivityArea());
            al.i(this.eLm, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eLa.getLayoutMode().setNightMode(i == 1);
        this.eLa.getLayoutMode().onModeChanged(this.bwZ);
        this.mNavigationBar.onChangeSkinType(this.eLa.getPageContext(), i);
        this.eLd.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eLr.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eLs = null;
    }

    public View aPZ() {
        return this.eAV;
    }

    public TextView aQa() {
        return this.eLr;
    }

    public com.baidu.tbadk.core.dialog.b aQb() {
        return this.eLq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQc() {
        if (this.eLq == null) {
            CharSequence[] charSequenceArr = {this.eLa.getPageContext().getString(e.j.group_activity_eidt), this.eLa.getPageContext().getString(e.j.group_activity_delete)};
            this.eLq = new com.baidu.tbadk.core.dialog.b(this.eLa.getPageContext().getPageActivity());
            this.eLq.ek(this.eLa.getPageContext().getString(e.j.operation));
            this.eLq.a(charSequenceArr, this.eLa);
            this.eLq.d(this.eLa.getPageContext());
        }
    }
}
