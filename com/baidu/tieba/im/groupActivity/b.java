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
    private RelativeLayout cUF;
    private GroupActivityActivity gCC;
    private HeadImageView gCE;
    private TextView gCF;
    private LinearLayout gCG;
    private TextView gCH;
    private TextView gCI;
    private TextView gCJ;
    private TextView gCK;
    private TextView gCL;
    private LinearLayout gCM;
    private LinearLayout gCN;
    private LinearLayout gCO;
    private TextView gCP;
    private ImageView gCQ;
    private ImageView gCR;
    private i gCS;
    private TextView gCT;
    private TextView gCU;
    private View gst;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gCC = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gst = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gCF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gCF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBv();
                b.this.gCS.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gCF.setVisibility(8);
        this.gCT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gCT.setOnClickListener(groupActivityActivity);
        this.gCT.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cUF = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gCG = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gCE = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gCE.setAutoChangeStyle(true);
        this.gCE.setIsRound(false);
        this.gCH = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gCI = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gCJ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gCK = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gCL = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gCM = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gCN = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gCO = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gCP = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gCR = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gCQ = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gCU = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCU.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gCU.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gCG.getVisibility() != 0) {
                this.gCG.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gCE.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gCH.setText(groupActivityData.getgActivityTitle());
            this.gCI.setText(this.gCC.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gCF.setVisibility(8);
                    this.gCT.setVisibility(0);
                    if (com.baidu.tieba.group.a.bsw().bsx() || z) {
                        this.gCU.setVisibility(8);
                    } else {
                        this.gCU.setVisibility(0);
                        com.baidu.tieba.group.a.bsw().kT(true);
                        e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gCU != null) {
                                    b.this.gCU.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gCF.setVisibility(0);
                    this.gCT.setVisibility(8);
                }
            } else {
                this.gCF.setVisibility(8);
                this.gCT.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gCP.setVisibility(0);
                al.c(this.gCR, (int) R.drawable.icon_activity_time_n);
                al.c(this.gCQ, (int) R.drawable.icon_activity_lbs_n);
                al.f(this.gCK, R.color.common_color_10106, 1);
                al.f(this.gCL, R.color.common_color_10106, 1);
            } else {
                this.gCP.setVisibility(8);
                al.c(this.gCR, (int) R.drawable.icon_activity_time_s);
                al.c(this.gCQ, (int) R.drawable.icon_activity_lbs_s);
                al.f(this.gCK, R.color.common_color_10039, 1);
                al.f(this.gCL, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gCM.setVisibility(8);
            } else {
                this.gCM.setVisibility(0);
                this.gCJ.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.gCC.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gCC.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gCK.setText(sb.toString());
            } else {
                this.gCK.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gCN.setVisibility(8);
                al.k(this.gCO, R.drawable.bg_activity_down);
                return;
            }
            this.gCN.setVisibility(0);
            this.gCL.setText(groupActivityData.getgActivityArea());
            al.k(this.gCO, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gCC.getLayoutMode().setNightMode(i == 1);
        this.gCC.getLayoutMode().onModeChanged(this.cUF);
        this.mNavigationBar.onChangeSkinType(this.gCC.getPageContext(), i);
        this.gCF.setTextColor(al.getColor(R.color.cp_cont_f));
        this.gCT.setTextColor(al.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gCU = null;
    }

    public View bBs() {
        return this.gst;
    }

    public TextView bBt() {
        return this.gCT;
    }

    public i bBu() {
        return this.gCS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBv() {
        if (this.gCS == null) {
            String[] strArr = {this.gCC.getPageContext().getString(R.string.group_activity_eidt), this.gCC.getPageContext().getString(R.string.group_activity_delete)};
            this.gCS = new i(this.gCC.getPageContext());
            this.gCS.a(null, strArr, this.gCC);
        }
    }
}
