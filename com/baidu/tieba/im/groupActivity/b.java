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
    private View jPD;
    private GroupActivityActivity kbK;
    private HeadImageView kbM;
    private TextView kbN;
    private LinearLayout kbO;
    private TextView kbP;
    private TextView kbQ;
    private TextView kbR;
    private TextView kbS;
    private TextView kbT;
    private LinearLayout kbU;
    private LinearLayout kbV;
    private LinearLayout kbW;
    private TextView kbX;
    private ImageView kbY;
    private ImageView kbZ;
    private i kca;
    private TextView kcb;
    private TextView kcc;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kbK = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.jPD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.kbN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.kbN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cQr();
                b.this.kca.PJ();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.kbN.setVisibility(8);
        this.kcb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.kcb.setOnClickListener(groupActivityActivity);
        this.kcb.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.kbO = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.kbM = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.kbM.setAutoChangeStyle(true);
        this.kbM.setIsRound(false);
        this.kbP = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.kbQ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.kbR = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.kbS = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.kbT = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.kbU = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.kbV = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.kbW = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.kbX = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.kbZ = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.kbY = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.kcc = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kcc.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.kcc.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.kbO.getVisibility() != 0) {
                this.kbO.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.kbM.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.kbP.setText(groupActivityData.getgActivityTitle());
            this.kbQ.setText(this.kbK.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.kbN.setVisibility(8);
                    this.kcb.setVisibility(0);
                    if (com.baidu.tieba.group.a.cFL().cFM() || z) {
                        this.kcc.setVisibility(8);
                    } else {
                        this.kcc.setVisibility(0);
                        com.baidu.tieba.group.a.cFL().qC(true);
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.kcc != null) {
                                    b.this.kcc.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.kbN.setVisibility(0);
                    this.kcb.setVisibility(8);
                }
            } else {
                this.kbN.setVisibility(8);
                this.kcb.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.kbX.setVisibility(0);
                ap.setImageResource(this.kbZ, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.kbY, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.kbS, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.kbT, R.color.common_color_10106, 1);
            } else {
                this.kbX.setVisibility(8);
                ap.setImageResource(this.kbZ, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.kbY, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.kbS, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.kbT, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.kbU.setVisibility(8);
            } else {
                this.kbU.setVisibility(0);
                this.kbR.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.kbK.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.kbK.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.kbS.setText(sb.toString());
            } else {
                this.kbS.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.kbV.setVisibility(8);
                ap.setBackgroundResource(this.kbW, R.drawable.bg_activity_down);
                return;
            }
            this.kbV.setVisibility(0);
            this.kbT.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.kbW, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.kbK.getLayoutMode().setNightMode(i == 1);
        this.kbK.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.kbK.getPageContext(), i);
        this.kbN.setTextColor(ap.getColor(R.color.cp_cont_f));
        this.kcb.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.kcc = null;
    }

    public View cQo() {
        return this.jPD;
    }

    public TextView cQp() {
        return this.kcb;
    }

    public i cQq() {
        return this.kca;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cQr() {
        if (this.kca == null) {
            String[] strArr = {this.kbK.getPageContext().getString(R.string.group_activity_eidt), this.kbK.getPageContext().getString(R.string.group_activity_delete)};
            this.kca = new i(this.kbK.getPageContext());
            this.kca.a(null, strArr, this.kbK);
        }
    }
}
