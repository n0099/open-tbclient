package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
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
    private RelativeLayout bsh;
    private GroupActivityActivity eBY;
    private HeadImageView eCa;
    private TextView eCb;
    private LinearLayout eCc;
    private TextView eCd;
    private TextView eCe;
    private TextView eCf;
    private TextView eCg;
    private TextView eCh;
    private LinearLayout eCi;
    private LinearLayout eCj;
    private LinearLayout eCk;
    private TextView eCl;
    private ImageView eCm;
    private ImageView eCn;
    private com.baidu.tbadk.core.dialog.b eCo;
    private TextView eCp;
    private TextView eCq;
    private View erL;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eBY = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.erL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eCb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eCb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aNq();
                b.this.eCo.yo();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eCb.setVisibility(8);
        this.eCp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eCp.setOnClickListener(groupActivityActivity);
        this.eCp.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bsh = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eCc = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eCa = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eCa.setAutoChangeStyle(true);
        this.eCa.setIsRound(false);
        this.eCd = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eCe = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eCf = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eCg = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eCh = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eCi = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eCj = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eCk = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eCl = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eCn = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eCm = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eCq = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eCq.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eCq.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eCc.getVisibility() != 0) {
                this.eCc.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eCa.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eCd.setText(groupActivityData.getgActivityTitle());
            this.eCe.setText(this.eBY.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eCb.setVisibility(8);
                    this.eCp.setVisibility(0);
                    if (com.baidu.tieba.group.a.aFe().aFf() || z) {
                        this.eCq.setVisibility(8);
                    } else {
                        this.eCq.setVisibility(0);
                        com.baidu.tieba.group.a.aFe().hd(true);
                        com.baidu.adp.lib.g.e.jt().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eCq != null) {
                                    b.this.eCq.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eCb.setVisibility(0);
                    this.eCp.setVisibility(8);
                }
            } else {
                this.eCb.setVisibility(8);
                this.eCp.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eCl.setVisibility(0);
                al.c(this.eCn, e.f.icon_activity_time_n);
                al.c(this.eCm, e.f.icon_activity_lbs_n);
                al.c(this.eCg, e.d.common_color_10106, 1);
                al.c(this.eCh, e.d.common_color_10106, 1);
            } else {
                this.eCl.setVisibility(8);
                al.c(this.eCn, e.f.icon_activity_time_s);
                al.c(this.eCm, e.f.icon_activity_lbs_s);
                al.c(this.eCg, e.d.common_color_10039, 1);
                al.c(this.eCh, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eCi.setVisibility(8);
            } else {
                this.eCi.setVisibility(0);
                this.eCf.setText(groupActivityData.getgActivityContent());
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
                sb.append(ao.m(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.eBY.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eBY.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eCg.setText(sb.toString());
            } else {
                this.eCg.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eCj.setVisibility(8);
                al.i(this.eCk, e.f.bg_activity_down);
                return;
            }
            this.eCj.setVisibility(0);
            this.eCh.setText(groupActivityData.getgActivityArea());
            al.i(this.eCk, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eBY.getLayoutMode().setNightMode(i == 1);
        this.eBY.getLayoutMode().onModeChanged(this.bsh);
        this.mNavigationBar.onChangeSkinType(this.eBY.getPageContext(), i);
        this.eCb.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eCp.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eCq = null;
    }

    public View aNn() {
        return this.erL;
    }

    public TextView aNo() {
        return this.eCp;
    }

    public com.baidu.tbadk.core.dialog.b aNp() {
        return this.eCo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNq() {
        if (this.eCo == null) {
            CharSequence[] charSequenceArr = {this.eBY.getPageContext().getString(e.j.group_activity_eidt), this.eBY.getPageContext().getString(e.j.group_activity_delete)};
            this.eCo = new com.baidu.tbadk.core.dialog.b(this.eBY.getPageContext().getPageActivity());
            this.eCo.dU(this.eBY.getPageContext().getString(e.j.operation));
            this.eCo.a(charSequenceArr, this.eBY);
            this.eCo.d(this.eBY.getPageContext());
        }
    }
}
