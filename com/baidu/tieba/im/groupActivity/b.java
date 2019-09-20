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
    private RelativeLayout cXd;
    private View gBq;
    private HeadImageView gLB;
    private TextView gLC;
    private LinearLayout gLD;
    private TextView gLE;
    private TextView gLF;
    private TextView gLG;
    private TextView gLH;
    private TextView gLI;
    private LinearLayout gLJ;
    private LinearLayout gLK;
    private LinearLayout gLL;
    private TextView gLM;
    private ImageView gLN;
    private ImageView gLO;
    private i gLP;
    private TextView gLQ;
    private TextView gLR;
    private GroupActivityActivity gLz;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gLz = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gBq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gLC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gLC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bFi();
                b.this.gLP.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gLC.setVisibility(8);
        this.gLQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gLQ.setOnClickListener(groupActivityActivity);
        this.gLQ.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cXd = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gLD = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gLB = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gLB.setAutoChangeStyle(true);
        this.gLB.setIsRound(false);
        this.gLE = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gLF = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gLG = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gLH = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gLI = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gLJ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gLK = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gLL = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gLM = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gLO = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gLN = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gLR = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gLR.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gLR.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gLD.getVisibility() != 0) {
                this.gLD.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gLB.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gLE.setText(groupActivityData.getgActivityTitle());
            this.gLF.setText(this.gLz.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gLC.setVisibility(8);
                    this.gLQ.setVisibility(0);
                    if (com.baidu.tieba.group.a.bvD().bvE() || z) {
                        this.gLR.setVisibility(8);
                    } else {
                        this.gLR.setVisibility(0);
                        com.baidu.tieba.group.a.bvD().lh(true);
                        e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gLR != null) {
                                    b.this.gLR.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gLC.setVisibility(0);
                    this.gLQ.setVisibility(8);
                }
            } else {
                this.gLC.setVisibility(8);
                this.gLQ.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gLM.setVisibility(0);
                am.c(this.gLO, (int) R.drawable.icon_activity_time_n);
                am.c(this.gLN, (int) R.drawable.icon_activity_lbs_n);
                am.f(this.gLH, R.color.common_color_10106, 1);
                am.f(this.gLI, R.color.common_color_10106, 1);
            } else {
                this.gLM.setVisibility(8);
                am.c(this.gLO, (int) R.drawable.icon_activity_time_s);
                am.c(this.gLN, (int) R.drawable.icon_activity_lbs_s);
                am.f(this.gLH, R.color.common_color_10039, 1);
                am.f(this.gLI, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gLJ.setVisibility(8);
            } else {
                this.gLJ.setVisibility(0);
                this.gLG.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.gLz.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gLz.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gLH.setText(sb.toString());
            } else {
                this.gLH.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gLK.setVisibility(8);
                am.k(this.gLL, R.drawable.bg_activity_down);
                return;
            }
            this.gLK.setVisibility(0);
            this.gLI.setText(groupActivityData.getgActivityArea());
            am.k(this.gLL, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gLz.getLayoutMode().setNightMode(i == 1);
        this.gLz.getLayoutMode().onModeChanged(this.cXd);
        this.mNavigationBar.onChangeSkinType(this.gLz.getPageContext(), i);
        this.gLC.setTextColor(am.getColor(R.color.cp_cont_f));
        this.gLQ.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gLR = null;
    }

    public View bFf() {
        return this.gBq;
    }

    public TextView bFg() {
        return this.gLQ;
    }

    public i bFh() {
        return this.gLP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFi() {
        if (this.gLP == null) {
            String[] strArr = {this.gLz.getPageContext().getString(R.string.group_activity_eidt), this.gLz.getPageContext().getString(R.string.group_activity_delete)};
            this.gLP = new i(this.gLz.getPageContext());
            this.gLP.a(null, strArr, this.gLz);
        }
    }
}
