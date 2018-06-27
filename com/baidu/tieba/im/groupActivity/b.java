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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes3.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout blJ;
    private View egF;
    private GroupActivityActivity eqQ;
    private HeadImageView eqS;
    private TextView eqT;
    private LinearLayout eqU;
    private TextView eqV;
    private TextView eqW;
    private TextView eqX;
    private TextView eqY;
    private TextView eqZ;
    private LinearLayout era;
    private LinearLayout erb;
    private LinearLayout erc;
    private TextView erd;
    private ImageView ere;
    private ImageView erf;
    private com.baidu.tbadk.core.dialog.b erg;
    private TextView erh;
    private TextView eri;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.eqQ = groupActivityActivity;
        groupActivityActivity.setContentView(d.i.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(d.k.group_activity));
        this.egF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.eqT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.edit));
        this.eqT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.aKd();
                b.this.erg.xq();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.eqT.setVisibility(8);
        this.erh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(d.k.delete));
        this.erh.setOnClickListener(groupActivityActivity);
        this.erh.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.blJ = (RelativeLayout) groupActivityActivity.findViewById(d.g.group_info_container);
        this.eqU = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_body);
        this.eqS = (HeadImageView) groupActivityActivity.findViewById(d.g.group_head_pic);
        this.eqS.setAutoChangeStyle(true);
        this.eqS.setIsRound(false);
        this.eqV = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_name);
        this.eqW = (TextView) groupActivityActivity.findViewById(d.g.txt_group_author);
        this.eqX = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_content);
        this.eqY = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_time);
        this.eqZ = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_place);
        this.era = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_content);
        this.erb = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_place);
        this.erc = (LinearLayout) groupActivityActivity.findViewById(d.g.lay_group_activity_time);
        this.erd = (TextView) groupActivityActivity.findViewById(d.g.txt_group_activity_end);
        this.erf = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_time);
        this.ere = (ImageView) groupActivityActivity.findViewById(d.g.img_activity_place);
        this.eri = (TextView) groupActivityActivity.findViewById(d.g.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eri.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.eri.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.eqU.getVisibility() != 0) {
                this.eqU.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.eqS.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.eqV.setText(groupActivityData.getgActivityTitle());
            this.eqW.setText(this.eqQ.getResources().getString(d.k.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.eqT.setVisibility(8);
                    this.erh.setVisibility(0);
                    if (com.baidu.tieba.group.a.aCl().aCm() || z) {
                        this.eri.setVisibility(8);
                    } else {
                        this.eri.setVisibility(0);
                        com.baidu.tieba.group.a.aCl().gD(true);
                        e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.eri != null) {
                                    b.this.eri.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.eqT.setVisibility(0);
                    this.erh.setVisibility(8);
                }
            } else {
                this.eqT.setVisibility(8);
                this.erh.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.erd.setVisibility(0);
                am.c(this.erf, d.f.icon_activity_time_n);
                am.c(this.ere, d.f.icon_activity_lbs_n);
                am.c(this.eqY, d.C0142d.common_color_10106, 1);
                am.c(this.eqZ, d.C0142d.common_color_10106, 1);
            } else {
                this.erd.setVisibility(8);
                am.c(this.erf, d.f.icon_activity_time_s);
                am.c(this.ere, d.f.icon_activity_lbs_s);
                am.c(this.eqY, d.C0142d.common_color_10039, 1);
                am.c(this.eqZ, d.C0142d.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.era.setVisibility(8);
            } else {
                this.era.setVisibility(0);
                this.eqX.setText(groupActivityData.getgActivityContent());
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
                sb.append(ap.k(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.eqQ.getResources().getString(d.k.afternoon));
                    sb.append(hours - 12);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.eqQ.getResources().getString(d.k.morning));
                    sb.append(hours);
                    sb.append(SystemInfoUtil.COLON);
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.eqY.setText(sb.toString());
            } else {
                this.eqY.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.erb.setVisibility(8);
                am.i(this.erc, d.f.bg_activity_down);
                return;
            }
            this.erb.setVisibility(0);
            this.eqZ.setText(groupActivityData.getgActivityArea());
            am.i(this.erc, d.f.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.eqQ.getLayoutMode().setNightMode(i == 1);
        this.eqQ.getLayoutMode().onModeChanged(this.blJ);
        this.mNavigationBar.onChangeSkinType(this.eqQ.getPageContext(), i);
        this.eqT.setTextColor(am.getColor(d.C0142d.cp_cont_f));
        this.erh.setTextColor(am.getColor(d.C0142d.cp_cont_f));
    }

    public void onDestory() {
        this.eri = null;
    }

    public View aKa() {
        return this.egF;
    }

    public TextView aKb() {
        return this.erh;
    }

    public com.baidu.tbadk.core.dialog.b aKc() {
        return this.erg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKd() {
        if (this.erg == null) {
            CharSequence[] charSequenceArr = {this.eqQ.getPageContext().getString(d.k.group_activity_eidt), this.eqQ.getPageContext().getString(d.k.group_activity_delete)};
            this.erg = new com.baidu.tbadk.core.dialog.b(this.eqQ.getPageContext().getPageActivity());
            this.erg.dF(this.eqQ.getPageContext().getString(d.k.operation));
            this.erg.a(charSequenceArr, this.eqQ);
            this.erg.d(this.eqQ.getPageContext());
        }
    }
}
