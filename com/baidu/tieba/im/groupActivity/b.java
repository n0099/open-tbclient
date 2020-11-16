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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes22.dex */
public class b extends c<GroupActivityActivity> {
    private View jWk;
    private TextView kiA;
    private TextView kiB;
    private LinearLayout kiC;
    private LinearLayout kiD;
    private LinearLayout kiE;
    private TextView kiF;
    private ImageView kiG;
    private ImageView kiH;
    private i kiI;
    private TextView kiJ;
    private TextView kiK;
    private GroupActivityActivity kis;
    private HeadImageView kiu;
    private TextView kiv;
    private LinearLayout kiw;
    private TextView kix;
    private TextView kiy;
    private TextView kiz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kis = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.jWk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.kiv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.kiv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cSy();
                b.this.kiI.PA();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.kiv.setVisibility(8);
        this.kiJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.kiJ.setOnClickListener(groupActivityActivity);
        this.kiJ.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.kiw = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.kiu = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.kiu.setAutoChangeStyle(true);
        this.kiu.setIsRound(false);
        this.kix = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.kiy = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.kiz = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.kiA = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.kiB = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.kiC = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.kiD = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.kiE = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.kiF = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.kiH = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.kiG = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.kiK = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kiK.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.kiK.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.kiw.getVisibility() != 0) {
                this.kiw.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.kiu.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.kix.setText(groupActivityData.getgActivityTitle());
            this.kiy.setText(this.kis.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.kiv.setVisibility(8);
                    this.kiJ.setVisibility(0);
                    if (com.baidu.tieba.group.a.cHR().cHS() || z) {
                        this.kiK.setVisibility(8);
                    } else {
                        this.kiK.setVisibility(0);
                        com.baidu.tieba.group.a.cHR().qO(true);
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.kiK != null) {
                                    b.this.kiK.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.kiv.setVisibility(0);
                    this.kiJ.setVisibility(8);
                }
            } else {
                this.kiv.setVisibility(8);
                this.kiJ.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.kiF.setVisibility(0);
                ap.setImageResource(this.kiH, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.kiG, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.kiA, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.kiB, R.color.common_color_10106, 1);
            } else {
                this.kiF.setVisibility(8);
                ap.setImageResource(this.kiH, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.kiG, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.kiA, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.kiB, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.kiC.setVisibility(8);
            } else {
                this.kiC.setVisibility(0);
                this.kiz.setText(groupActivityData.getgActivityContent());
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
                sb.append(au.getWeekString(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.kis.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.kis.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.kiA.setText(sb.toString());
            } else {
                this.kiA.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.kiD.setVisibility(8);
                ap.setBackgroundResource(this.kiE, R.drawable.bg_activity_down);
                return;
            }
            this.kiD.setVisibility(0);
            this.kiB.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.kiE, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.kis.getLayoutMode().setNightMode(i == 1);
        this.kis.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.kis.getPageContext(), i);
        this.kiv.setTextColor(ap.getColor(R.color.CAM_X0106));
        this.kiJ.setTextColor(ap.getColor(R.color.CAM_X0106));
    }

    public void onDestory() {
        this.kiK = null;
    }

    public View cSv() {
        return this.jWk;
    }

    public TextView cSw() {
        return this.kiJ;
    }

    public i cSx() {
        return this.kiI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSy() {
        if (this.kiI == null) {
            String[] strArr = {this.kis.getPageContext().getString(R.string.group_activity_eidt), this.kis.getPageContext().getString(R.string.group_activity_delete)};
            this.kiI = new i(this.kis.getPageContext());
            this.kiI.a(null, strArr, this.kis);
        }
    }
}
