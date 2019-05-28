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
    private RelativeLayout cUG;
    private GroupActivityActivity gCD;
    private HeadImageView gCF;
    private TextView gCG;
    private LinearLayout gCH;
    private TextView gCI;
    private TextView gCJ;
    private TextView gCK;
    private TextView gCL;
    private TextView gCM;
    private LinearLayout gCN;
    private LinearLayout gCO;
    private LinearLayout gCP;
    private TextView gCQ;
    private ImageView gCR;
    private ImageView gCS;
    private i gCT;
    private TextView gCU;
    private TextView gCV;
    private View gsu;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gCD = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gsu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gCG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gCG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBy();
                b.this.gCT.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gCG.setVisibility(8);
        this.gCU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gCU.setOnClickListener(groupActivityActivity);
        this.gCU.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cUG = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gCH = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gCF = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gCF.setAutoChangeStyle(true);
        this.gCF.setIsRound(false);
        this.gCI = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gCJ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gCK = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gCL = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gCM = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gCN = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gCO = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gCP = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gCQ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gCS = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gCR = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gCV = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCV.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gCV.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gCH.getVisibility() != 0) {
                this.gCH.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gCF.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gCI.setText(groupActivityData.getgActivityTitle());
            this.gCJ.setText(this.gCD.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gCG.setVisibility(8);
                    this.gCU.setVisibility(0);
                    if (com.baidu.tieba.group.a.bsz().bsA() || z) {
                        this.gCV.setVisibility(8);
                    } else {
                        this.gCV.setVisibility(0);
                        com.baidu.tieba.group.a.bsz().kT(true);
                        e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gCV != null) {
                                    b.this.gCV.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gCG.setVisibility(0);
                    this.gCU.setVisibility(8);
                }
            } else {
                this.gCG.setVisibility(8);
                this.gCU.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gCQ.setVisibility(0);
                al.c(this.gCS, (int) R.drawable.icon_activity_time_n);
                al.c(this.gCR, (int) R.drawable.icon_activity_lbs_n);
                al.f(this.gCL, R.color.common_color_10106, 1);
                al.f(this.gCM, R.color.common_color_10106, 1);
            } else {
                this.gCQ.setVisibility(8);
                al.c(this.gCS, (int) R.drawable.icon_activity_time_s);
                al.c(this.gCR, (int) R.drawable.icon_activity_lbs_s);
                al.f(this.gCL, R.color.common_color_10039, 1);
                al.f(this.gCM, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gCN.setVisibility(8);
            } else {
                this.gCN.setVisibility(0);
                this.gCK.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.gCD.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gCD.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gCL.setText(sb.toString());
            } else {
                this.gCL.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gCO.setVisibility(8);
                al.k(this.gCP, R.drawable.bg_activity_down);
                return;
            }
            this.gCO.setVisibility(0);
            this.gCM.setText(groupActivityData.getgActivityArea());
            al.k(this.gCP, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gCD.getLayoutMode().setNightMode(i == 1);
        this.gCD.getLayoutMode().onModeChanged(this.cUG);
        this.mNavigationBar.onChangeSkinType(this.gCD.getPageContext(), i);
        this.gCG.setTextColor(al.getColor(R.color.cp_cont_f));
        this.gCU.setTextColor(al.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gCV = null;
    }

    public View bBv() {
        return this.gsu;
    }

    public TextView bBw() {
        return this.gCU;
    }

    public i bBx() {
        return this.gCT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBy() {
        if (this.gCT == null) {
            String[] strArr = {this.gCD.getPageContext().getString(R.string.group_activity_eidt), this.gCD.getPageContext().getString(R.string.group_activity_delete)};
            this.gCT = new i(this.gCD.getPageContext());
            this.gCT.a(null, strArr, this.gCD);
        }
    }
}
