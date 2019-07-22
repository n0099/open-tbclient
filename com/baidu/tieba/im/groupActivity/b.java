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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes5.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout cWd;
    private GroupActivityActivity gIP;
    private HeadImageView gIR;
    private TextView gIS;
    private LinearLayout gIT;
    private TextView gIU;
    private TextView gIV;
    private TextView gIW;
    private TextView gIX;
    private TextView gIY;
    private LinearLayout gIZ;
    private LinearLayout gJa;
    private LinearLayout gJb;
    private TextView gJc;
    private ImageView gJd;
    private ImageView gJe;
    private i gJf;
    private TextView gJg;
    private TextView gJh;
    private View gyH;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gIP = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gyH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gIS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gIS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bEg();
                b.this.gJf.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gIS.setVisibility(8);
        this.gJg = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gJg.setOnClickListener(groupActivityActivity);
        this.gJg.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cWd = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gIT = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gIR = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gIR.setAutoChangeStyle(true);
        this.gIR.setIsRound(false);
        this.gIU = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gIV = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gIW = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gIX = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gIY = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gIZ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gJa = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gJb = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gJc = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gJe = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gJd = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gJh = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJh.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gJh.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gIT.getVisibility() != 0) {
                this.gIT.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gIR.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gIU.setText(groupActivityData.getgActivityTitle());
            this.gIV.setText(this.gIP.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gIS.setVisibility(8);
                    this.gJg.setVisibility(0);
                    if (com.baidu.tieba.group.a.buC().buD() || z) {
                        this.gJh.setVisibility(8);
                    } else {
                        this.gJh.setVisibility(0);
                        com.baidu.tieba.group.a.buC().le(true);
                        e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gJh != null) {
                                    b.this.gJh.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gIS.setVisibility(0);
                    this.gJg.setVisibility(8);
                }
            } else {
                this.gIS.setVisibility(8);
                this.gJg.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gJc.setVisibility(0);
                am.c(this.gJe, (int) R.drawable.icon_activity_time_n);
                am.c(this.gJd, (int) R.drawable.icon_activity_lbs_n);
                am.f(this.gIX, R.color.common_color_10106, 1);
                am.f(this.gIY, R.color.common_color_10106, 1);
            } else {
                this.gJc.setVisibility(8);
                am.c(this.gJe, (int) R.drawable.icon_activity_time_s);
                am.c(this.gJd, (int) R.drawable.icon_activity_lbs_s);
                am.f(this.gIX, R.color.common_color_10039, 1);
                am.f(this.gIY, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gIZ.setVisibility(8);
            } else {
                this.gIZ.setVisibility(0);
                this.gIW.setText(groupActivityData.getgActivityContent());
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
                sb.append(aq.q(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.gIP.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gIP.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gIX.setText(sb.toString());
            } else {
                this.gIX.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gJa.setVisibility(8);
                am.k(this.gJb, R.drawable.bg_activity_down);
                return;
            }
            this.gJa.setVisibility(0);
            this.gIY.setText(groupActivityData.getgActivityArea());
            am.k(this.gJb, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gIP.getLayoutMode().setNightMode(i == 1);
        this.gIP.getLayoutMode().onModeChanged(this.cWd);
        this.mNavigationBar.onChangeSkinType(this.gIP.getPageContext(), i);
        this.gIS.setTextColor(am.getColor(R.color.cp_cont_f));
        this.gJg.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gJh = null;
    }

    public View bEd() {
        return this.gyH;
    }

    public TextView bEe() {
        return this.gJg;
    }

    public i bEf() {
        return this.gJf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEg() {
        if (this.gJf == null) {
            String[] strArr = {this.gIP.getPageContext().getString(R.string.group_activity_eidt), this.gIP.getPageContext().getString(R.string.group_activity_delete)};
            this.gJf = new i(this.gIP.getPageContext());
            this.gJf.a(null, strArr, this.gIP);
        }
    }
}
