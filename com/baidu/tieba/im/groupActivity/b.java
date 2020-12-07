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
/* loaded from: classes23.dex */
public class b extends c<GroupActivityActivity> {
    private View kjP;
    private GroupActivityActivity kvO;
    private HeadImageView kvQ;
    private TextView kvR;
    private LinearLayout kvS;
    private TextView kvT;
    private TextView kvU;
    private TextView kvV;
    private TextView kvW;
    private TextView kvX;
    private LinearLayout kvY;
    private LinearLayout kvZ;
    private LinearLayout kwa;
    private TextView kwb;
    private ImageView kwc;
    private ImageView kwd;
    private i kwe;
    private TextView kwf;
    private TextView kwg;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kvO = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.kjP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.kvR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.kvR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cXK();
                b.this.kwe.RU();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.kvR.setVisibility(8);
        this.kwf = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.kwf.setOnClickListener(groupActivityActivity);
        this.kwf.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.kvS = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.kvQ = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.kvQ.setAutoChangeStyle(true);
        this.kvQ.setIsRound(false);
        this.kvT = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.kvU = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.kvV = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.kvW = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.kvX = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.kvY = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.kvZ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.kwa = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.kwb = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.kwd = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.kwc = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.kwg = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kwg.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.kwg.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.kvS.getVisibility() != 0) {
                this.kvS.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.kvQ.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.kvT.setText(groupActivityData.getgActivityTitle());
            this.kvU.setText(this.kvO.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.kvR.setVisibility(8);
                    this.kwf.setVisibility(0);
                    if (com.baidu.tieba.group.a.cNf().cNg() || z) {
                        this.kwg.setVisibility(8);
                    } else {
                        this.kwg.setVisibility(0);
                        com.baidu.tieba.group.a.cNf().rp(true);
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.kwg != null) {
                                    b.this.kwg.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.kvR.setVisibility(0);
                    this.kwf.setVisibility(8);
                }
            } else {
                this.kvR.setVisibility(8);
                this.kwf.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.kwb.setVisibility(0);
                ap.setImageResource(this.kwd, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.kwc, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.kvW, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.kvX, R.color.common_color_10106, 1);
            } else {
                this.kwb.setVisibility(8);
                ap.setImageResource(this.kwd, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.kwc, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.kvW, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.kvX, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.kvY.setVisibility(8);
            } else {
                this.kvY.setVisibility(0);
                this.kvV.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.kvO.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.kvO.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.kvW.setText(sb.toString());
            } else {
                this.kvW.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.kvZ.setVisibility(8);
                ap.setBackgroundResource(this.kwa, R.drawable.bg_activity_down);
                return;
            }
            this.kvZ.setVisibility(0);
            this.kvX.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.kwa, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.kvO.getLayoutMode().setNightMode(i == 1);
        this.kvO.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.kvO.getPageContext(), i);
        this.kvR.setTextColor(ap.getColor(R.color.CAM_X0106));
        this.kwf.setTextColor(ap.getColor(R.color.CAM_X0106));
    }

    public void onDestory() {
        this.kwg = null;
    }

    public View cXH() {
        return this.kjP;
    }

    public TextView cXI() {
        return this.kwf;
    }

    public i cXJ() {
        return this.kwe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXK() {
        if (this.kwe == null) {
            String[] strArr = {this.kvO.getPageContext().getString(R.string.group_activity_eidt), this.kvO.getPageContext().getString(R.string.group_activity_delete)};
            this.kwe = new i(this.kvO.getPageContext());
            this.kwe.a(null, strArr, this.kvO);
        }
    }
}
