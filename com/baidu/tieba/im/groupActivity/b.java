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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes5.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout cUH;
    private GroupActivityActivity gCF;
    private HeadImageView gCH;
    private TextView gCI;
    private LinearLayout gCJ;
    private TextView gCK;
    private TextView gCL;
    private TextView gCM;
    private TextView gCN;
    private TextView gCO;
    private LinearLayout gCP;
    private LinearLayout gCQ;
    private LinearLayout gCR;
    private TextView gCS;
    private ImageView gCT;
    private ImageView gCU;
    private i gCV;
    private TextView gCW;
    private TextView gCX;
    private View gsw;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gCF = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gCI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gCI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBz();
                b.this.gCV.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gCI.setVisibility(8);
        this.gCW = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gCW.setOnClickListener(groupActivityActivity);
        this.gCW.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cUH = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gCJ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gCH = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gCH.setAutoChangeStyle(true);
        this.gCH.setIsRound(false);
        this.gCK = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gCL = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gCM = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gCN = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gCO = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gCP = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gCQ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gCR = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gCS = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gCU = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gCT = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gCX = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCX.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gCX.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gCJ.getVisibility() != 0) {
                this.gCJ.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gCH.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gCK.setText(groupActivityData.getgActivityTitle());
            this.gCL.setText(this.gCF.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gCI.setVisibility(8);
                    this.gCW.setVisibility(0);
                    if (com.baidu.tieba.group.a.bsB().bsC() || z) {
                        this.gCX.setVisibility(8);
                    } else {
                        this.gCX.setVisibility(0);
                        com.baidu.tieba.group.a.bsB().kU(true);
                        e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gCX != null) {
                                    b.this.gCX.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gCI.setVisibility(0);
                    this.gCW.setVisibility(8);
                }
            } else {
                this.gCI.setVisibility(8);
                this.gCW.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gCS.setVisibility(0);
                al.c(this.gCU, (int) R.drawable.icon_activity_time_n);
                al.c(this.gCT, (int) R.drawable.icon_activity_lbs_n);
                al.f(this.gCN, R.color.common_color_10106, 1);
                al.f(this.gCO, R.color.common_color_10106, 1);
            } else {
                this.gCS.setVisibility(8);
                al.c(this.gCU, (int) R.drawable.icon_activity_time_s);
                al.c(this.gCT, (int) R.drawable.icon_activity_lbs_s);
                al.f(this.gCN, R.color.common_color_10039, 1);
                al.f(this.gCO, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gCP.setVisibility(8);
            } else {
                this.gCP.setVisibility(0);
                this.gCM.setText(groupActivityData.getgActivityContent());
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
                sb.append(ap.q(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.gCF.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gCF.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gCN.setText(sb.toString());
            } else {
                this.gCN.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gCQ.setVisibility(8);
                al.k(this.gCR, R.drawable.bg_activity_down);
                return;
            }
            this.gCQ.setVisibility(0);
            this.gCO.setText(groupActivityData.getgActivityArea());
            al.k(this.gCR, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gCF.getLayoutMode().setNightMode(i == 1);
        this.gCF.getLayoutMode().onModeChanged(this.cUH);
        this.mNavigationBar.onChangeSkinType(this.gCF.getPageContext(), i);
        this.gCI.setTextColor(al.getColor(R.color.cp_cont_f));
        this.gCW.setTextColor(al.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gCX = null;
    }

    public View bBw() {
        return this.gsw;
    }

    public TextView bBx() {
        return this.gCW;
    }

    public i bBy() {
        return this.gCV;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBz() {
        if (this.gCV == null) {
            String[] strArr = {this.gCF.getPageContext().getString(R.string.group_activity_eidt), this.gCF.getPageContext().getString(R.string.group_activity_delete)};
            this.gCV = new i(this.gCF.getPageContext());
            this.gCV.a(null, strArr, this.gCF);
        }
    }
}
