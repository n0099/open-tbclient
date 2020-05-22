package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.f.e;
import com.baidu.ar.auth.FeatureCodes;
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
/* loaded from: classes10.dex */
public class b extends c<GroupActivityActivity> {
    private GroupActivityActivity iCD;
    private HeadImageView iCF;
    private TextView iCG;
    private LinearLayout iCH;
    private TextView iCI;
    private TextView iCJ;
    private TextView iCK;
    private TextView iCL;
    private TextView iCM;
    private LinearLayout iCN;
    private LinearLayout iCO;
    private LinearLayout iCP;
    private TextView iCQ;
    private ImageView iCR;
    private ImageView iCS;
    private i iCT;
    private TextView iCU;
    private TextView iCV;
    private View isy;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.iCD = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.isy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.iCG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.iCG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cng();
                b.this.iCT.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.iCG.setVisibility(8);
        this.iCU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.iCU.setOnClickListener(groupActivityActivity);
        this.iCU.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.iCH = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.iCF = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.iCF.setAutoChangeStyle(true);
        this.iCF.setIsRound(false);
        this.iCI = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.iCJ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.iCK = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.iCL = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.iCM = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.iCN = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.iCO = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.iCP = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.iCQ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.iCS = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.iCR = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.iCV = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iCV.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.iCV.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.iCH.getVisibility() != 0) {
                this.iCH.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.iCF.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.iCI.setText(groupActivityData.getgActivityTitle());
            this.iCJ.setText(this.iCD.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.iCG.setVisibility(8);
                    this.iCU.setVisibility(0);
                    if (com.baidu.tieba.group.a.cdY().cdZ() || z) {
                        this.iCV.setVisibility(8);
                    } else {
                        this.iCV.setVisibility(0);
                        com.baidu.tieba.group.a.cdY().ob(true);
                        e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.iCV != null) {
                                    b.this.iCV.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.iCG.setVisibility(0);
                    this.iCU.setVisibility(8);
                }
            } else {
                this.iCG.setVisibility(8);
                this.iCU.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.iCQ.setVisibility(0);
                am.setImageResource(this.iCS, R.drawable.icon_activity_time_n);
                am.setImageResource(this.iCR, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.iCL, R.color.common_color_10106, 1);
                am.setViewTextColor(this.iCM, R.color.common_color_10106, 1);
            } else {
                this.iCQ.setVisibility(8);
                am.setImageResource(this.iCS, R.drawable.icon_activity_time_s);
                am.setImageResource(this.iCR, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.iCL, R.color.common_color_10039, 1);
                am.setViewTextColor(this.iCM, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.iCN.setVisibility(8);
            } else {
                this.iCN.setVisibility(0);
                this.iCK.setText(groupActivityData.getgActivityContent());
            }
            if (groupActivityData.getgActivityTime() > 0) {
                Date date = new Date(groupActivityData.getgActivityTime() * 1000);
                int year = date.getYear() + FeatureCodes.SKY_SEG;
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
                sb.append(aq.getWeekString(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.iCD.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.iCD.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.iCL.setText(sb.toString());
            } else {
                this.iCL.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.iCO.setVisibility(8);
                am.setBackgroundResource(this.iCP, R.drawable.bg_activity_down);
                return;
            }
            this.iCO.setVisibility(0);
            this.iCM.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.iCP, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.iCD.getLayoutMode().setNightMode(i == 1);
        this.iCD.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.iCD.getPageContext(), i);
        this.iCG.setTextColor(am.getColor(R.color.cp_cont_f));
        this.iCU.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.iCV = null;
    }

    public View cnd() {
        return this.isy;
    }

    public TextView cne() {
        return this.iCU;
    }

    public i cnf() {
        return this.iCT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cng() {
        if (this.iCT == null) {
            String[] strArr = {this.iCD.getPageContext().getString(R.string.group_activity_eidt), this.iCD.getPageContext().getString(R.string.group_activity_delete)};
            this.iCT = new i(this.iCD.getPageContext());
            this.iCT.a(null, strArr, this.iCD);
        }
    }
}
