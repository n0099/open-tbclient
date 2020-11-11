package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.f.e;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.ar.auth.FeatureCodes;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes23.dex */
public class b extends c<GroupActivityActivity> {
    private View jVA;
    private GroupActivityActivity khH;
    private HeadImageView khJ;
    private TextView khK;
    private LinearLayout khL;
    private TextView khM;
    private TextView khN;
    private TextView khO;
    private TextView khP;
    private TextView khQ;
    private LinearLayout khR;
    private LinearLayout khS;
    private LinearLayout khT;
    private TextView khU;
    private ImageView khV;
    private ImageView khW;
    private i khX;
    private TextView khY;
    private TextView khZ;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.khH = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.jVA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.khK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.khK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cSS();
                b.this.khX.Qj();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.khK.setVisibility(8);
        this.khY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.khY.setOnClickListener(groupActivityActivity);
        this.khY.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.khL = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.khJ = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.khJ.setAutoChangeStyle(true);
        this.khJ.setIsRound(false);
        this.khM = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.khN = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.khO = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.khP = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.khQ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.khR = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.khS = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.khT = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.khU = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.khW = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.khV = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.khZ = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.khZ.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.khZ.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.khL.getVisibility() != 0) {
                this.khL.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.khJ.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.khM.setText(groupActivityData.getgActivityTitle());
            this.khN.setText(this.khH.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.khK.setVisibility(8);
                    this.khY.setVisibility(0);
                    if (com.baidu.tieba.group.a.cIm().cIn() || z) {
                        this.khZ.setVisibility(8);
                    } else {
                        this.khZ.setVisibility(0);
                        com.baidu.tieba.group.a.cIm().qL(true);
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.khZ != null) {
                                    b.this.khZ.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.khK.setVisibility(0);
                    this.khY.setVisibility(8);
                }
            } else {
                this.khK.setVisibility(8);
                this.khY.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.khU.setVisibility(0);
                ap.setImageResource(this.khW, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.khV, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.khP, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.khQ, R.color.common_color_10106, 1);
            } else {
                this.khU.setVisibility(8);
                ap.setImageResource(this.khW, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.khV, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.khP, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.khQ, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.khR.setVisibility(8);
            } else {
                this.khR.setVisibility(0);
                this.khO.setText(groupActivityData.getgActivityContent());
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
                sb.append(at.getWeekString(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.khH.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.khH.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.khP.setText(sb.toString());
            } else {
                this.khP.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.khS.setVisibility(8);
                ap.setBackgroundResource(this.khT, R.drawable.bg_activity_down);
                return;
            }
            this.khS.setVisibility(0);
            this.khQ.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.khT, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.khH.getLayoutMode().setNightMode(i == 1);
        this.khH.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.khH.getPageContext(), i);
        this.khK.setTextColor(ap.getColor(R.color.cp_cont_f));
        this.khY.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.khZ = null;
    }

    public View cSP() {
        return this.jVA;
    }

    public TextView cSQ() {
        return this.khY;
    }

    public i cSR() {
        return this.khX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSS() {
        if (this.khX == null) {
            String[] strArr = {this.khH.getPageContext().getString(R.string.group_activity_eidt), this.khH.getPageContext().getString(R.string.group_activity_delete)};
            this.khX = new i(this.khH.getPageContext());
            this.khX.a(null, strArr, this.khH);
        }
    }
}
