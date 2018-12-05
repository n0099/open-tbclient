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
    private RelativeLayout bAw;
    private View eHK;
    private GroupActivityActivity eRP;
    private HeadImageView eRR;
    private TextView eRS;
    private LinearLayout eRT;
    private TextView eRU;
    private TextView eRV;
    private TextView eRW;
    private TextView eRX;
    private TextView eRY;
    private LinearLayout eRZ;
    private LinearLayout eSa;
    private LinearLayout eSb;
    private TextView eSc;
    private ImageView eSd;
    private ImageView eSe;
    private com.baidu.tbadk.core.dialog.b eSf;
    private TextView eSg;
    private TextView eSh;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eRP = groupActivityActivity;
        groupActivityActivity.setContentView(e.h.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(e.j.group_activity));
        this.eHK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eRS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.edit));
        this.eRS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aRU();
                b.this.eSf.BI();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eRS.setVisibility(8);
        this.eSg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(e.j.delete));
        this.eSg.setOnClickListener(groupActivityActivity);
        this.eSg.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bAw = (RelativeLayout) groupActivityActivity.findViewById(e.g.group_info_container);
        this.eRT = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_body);
        this.eRR = (HeadImageView) groupActivityActivity.findViewById(e.g.group_head_pic);
        this.eRR.setAutoChangeStyle(true);
        this.eRR.setIsRound(false);
        this.eRU = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_name);
        this.eRV = (TextView) groupActivityActivity.findViewById(e.g.txt_group_author);
        this.eRW = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_content);
        this.eRX = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_time);
        this.eRY = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_place);
        this.eRZ = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_content);
        this.eSa = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_place);
        this.eSb = (LinearLayout) groupActivityActivity.findViewById(e.g.lay_group_activity_time);
        this.eSc = (TextView) groupActivityActivity.findViewById(e.g.txt_group_activity_end);
        this.eSe = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_time);
        this.eSd = (ImageView) groupActivityActivity.findViewById(e.g.img_activity_place);
        this.eSh = (TextView) groupActivityActivity.findViewById(e.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSh.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eSh.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eRT.getVisibility() != 0) {
                this.eRT.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eRR.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eRU.setText(groupActivityData.getgActivityTitle());
            this.eRV.setText(this.eRP.getResources().getString(e.j.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eRS.setVisibility(8);
                    this.eSg.setVisibility(0);
                    if (com.baidu.tieba.group.a.aJL().aJM() || z) {
                        this.eSh.setVisibility(8);
                    } else {
                        this.eSh.setVisibility(0);
                        com.baidu.tieba.group.a.aJL().hH(true);
                        com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eSh != null) {
                                    b.this.eSh.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eRS.setVisibility(0);
                    this.eSg.setVisibility(8);
                }
            } else {
                this.eRS.setVisibility(8);
                this.eSg.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.eSc.setVisibility(0);
                al.c(this.eSe, e.f.icon_activity_time_n);
                al.c(this.eSd, e.f.icon_activity_lbs_n);
                al.c(this.eRX, e.d.common_color_10106, 1);
                al.c(this.eRY, e.d.common_color_10106, 1);
            } else {
                this.eSc.setVisibility(8);
                al.c(this.eSe, e.f.icon_activity_time_s);
                al.c(this.eSd, e.f.icon_activity_lbs_s);
                al.c(this.eRX, e.d.common_color_10039, 1);
                al.c(this.eRY, e.d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eRZ.setVisibility(8);
            } else {
                this.eRZ.setVisibility(0);
                this.eRW.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.eRP.getResources().getString(e.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eRP.getResources().getString(e.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eRX.setText(sb.toString());
            } else {
                this.eRX.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.eSa.setVisibility(8);
                al.i(this.eSb, e.f.bg_activity_down);
                return;
            }
            this.eSa.setVisibility(0);
            this.eRY.setText(groupActivityData.getgActivityArea());
            al.i(this.eSb, e.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eRP.getLayoutMode().setNightMode(i == 1);
        this.eRP.getLayoutMode().onModeChanged(this.bAw);
        this.mNavigationBar.onChangeSkinType(this.eRP.getPageContext(), i);
        this.eRS.setTextColor(al.getColor(e.d.cp_cont_f));
        this.eSg.setTextColor(al.getColor(e.d.cp_cont_f));
    }

    public void onDestory() {
        this.eSh = null;
    }

    public View aRR() {
        return this.eHK;
    }

    public TextView aRS() {
        return this.eSg;
    }

    public com.baidu.tbadk.core.dialog.b aRT() {
        return this.eSf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRU() {
        if (this.eSf == null) {
            CharSequence[] charSequenceArr = {this.eRP.getPageContext().getString(e.j.group_activity_eidt), this.eRP.getPageContext().getString(e.j.group_activity_delete)};
            this.eSf = new com.baidu.tbadk.core.dialog.b(this.eRP.getPageContext().getPageActivity());
            this.eSf.eC(this.eRP.getPageContext().getString(e.j.operation));
            this.eSf.a(charSequenceArr, this.eRP);
            this.eSf.d(this.eRP.getPageContext());
        }
    }
}
