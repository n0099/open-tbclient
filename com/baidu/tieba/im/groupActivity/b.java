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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout bkk;
    private View ecL;
    private GroupActivityActivity emV;
    private HeadImageView emX;
    private TextView emY;
    private LinearLayout emZ;
    private TextView ena;
    private TextView enb;
    private TextView enc;
    private TextView ene;
    private TextView enf;
    private LinearLayout eng;
    private LinearLayout enh;
    private LinearLayout eni;
    private TextView enj;
    private ImageView enk;
    private ImageView enl;
    private com.baidu.tbadk.core.dialog.b enm;
    private TextView enn;
    private TextView eno;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.emV = groupActivityActivity;
        groupActivityActivity.setContentView(d.i.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.k.group_activity));
        this.ecL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.emY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.edit));
        this.emY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aJw();
                b.this.enm.xd();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.emY.setVisibility(8);
        this.enn = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.delete));
        this.enn.setOnClickListener(groupActivityActivity);
        this.enn.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.bkk = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.emZ = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.emX = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.emX.setAutoChangeStyle(true);
        this.emX.setIsRound(false);
        this.ena = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.enb = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.enc = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.ene = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.enf = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.eng = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.enh = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.eni = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.enj = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.enl = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.enk = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eno = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eno.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eno.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.emZ.getVisibility() != 0) {
                this.emZ.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.emX.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.ena.setText(groupActivityData.getgActivityTitle());
            this.enb.setText(this.emV.getResources().getString(d.k.group_activity_creator) + "：" + groupActivityData.getUserName());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.emY.setVisibility(8);
                    this.enn.setVisibility(0);
                    if (com.baidu.tieba.group.a.aBF().aBG() || z) {
                        this.eno.setVisibility(8);
                    } else {
                        this.eno.setVisibility(0);
                        com.baidu.tieba.group.a.aBF().gt(true);
                        e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eno != null) {
                                    b.this.eno.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.emY.setVisibility(0);
                    this.enn.setVisibility(8);
                }
            } else {
                this.emY.setVisibility(8);
                this.enn.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.enj.setVisibility(0);
                al.c(this.enl, d.f.icon_activity_time_n);
                al.c(this.enk, d.f.icon_activity_lbs_n);
                al.c(this.ene, d.C0141d.common_color_10106, 1);
                al.c(this.enf, d.C0141d.common_color_10106, 1);
            } else {
                this.enj.setVisibility(8);
                al.c(this.enl, d.f.icon_activity_time_s);
                al.c(this.enk, d.f.icon_activity_lbs_s);
                al.c(this.ene, d.C0141d.common_color_10039, 1);
                al.c(this.enf, d.C0141d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.eng.setVisibility(8);
            } else {
                this.eng.setVisibility(0);
                this.enc.setText(groupActivityData.getgActivityContent());
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
                sb.append(ao.k(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.emV.getResources().getString(d.k.afternoon));
                    sb.append(hours - 12);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.emV.getResources().getString(d.k.morning));
                    sb.append(hours);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.ene.setText(sb.toString());
            } else {
                this.ene.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.enh.setVisibility(8);
                al.i(this.eni, d.f.bg_activity_down);
                return;
            }
            this.enh.setVisibility(0);
            this.enf.setText(groupActivityData.getgActivityArea());
            al.i(this.eni, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.emV.getLayoutMode().setNightMode(i == 1);
        this.emV.getLayoutMode().onModeChanged(this.bkk);
        this.mNavigationBar.onChangeSkinType(this.emV.getPageContext(), i);
        this.emY.setTextColor(al.getColor(d.C0141d.cp_cont_f));
        this.enn.setTextColor(al.getColor(d.C0141d.cp_cont_f));
    }

    public void onDestory() {
        this.eno = null;
    }

    public View aJt() {
        return this.ecL;
    }

    public TextView aJu() {
        return this.enn;
    }

    public com.baidu.tbadk.core.dialog.b aJv() {
        return this.enm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJw() {
        if (this.enm == null) {
            CharSequence[] charSequenceArr = {this.emV.getPageContext().getString(d.k.group_activity_eidt), this.emV.getPageContext().getString(d.k.group_activity_delete)};
            this.enm = new com.baidu.tbadk.core.dialog.b(this.emV.getPageContext().getPageActivity());
            this.enm.dC(this.emV.getPageContext().getString(d.k.operation));
            this.enm.a(charSequenceArr, this.emV);
            this.enm.d(this.emV.getPageContext());
        }
    }
}
