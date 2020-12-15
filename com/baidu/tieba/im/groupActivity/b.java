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
    private View kjR;
    private GroupActivityActivity kvQ;
    private HeadImageView kvS;
    private TextView kvT;
    private LinearLayout kvU;
    private TextView kvV;
    private TextView kvW;
    private TextView kvX;
    private TextView kvY;
    private TextView kvZ;
    private LinearLayout kwa;
    private LinearLayout kwb;
    private LinearLayout kwc;
    private TextView kwd;
    private ImageView kwe;
    private ImageView kwf;
    private i kwg;
    private TextView kwh;
    private TextView kwi;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.kvQ = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.kjR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.kvT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.kvT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cXL();
                b.this.kwg.RU();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.kvT.setVisibility(8);
        this.kwh = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.kwh.setOnClickListener(groupActivityActivity);
        this.kwh.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.kvU = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.kvS = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.kvS.setAutoChangeStyle(true);
        this.kvS.setIsRound(false);
        this.kvV = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.kvW = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.kvX = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.kvY = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.kvZ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.kwa = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.kwb = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.kwc = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.kwd = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.kwf = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.kwe = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.kwi = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kwi.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.kwi.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.kvU.getVisibility() != 0) {
                this.kvU.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.kvS.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.kvV.setText(groupActivityData.getgActivityTitle());
            this.kvW.setText(this.kvQ.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.kvT.setVisibility(8);
                    this.kwh.setVisibility(0);
                    if (com.baidu.tieba.group.a.cNg().cNh() || z) {
                        this.kwi.setVisibility(8);
                    } else {
                        this.kwi.setVisibility(0);
                        com.baidu.tieba.group.a.cNg().rp(true);
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.kwi != null) {
                                    b.this.kwi.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.kvT.setVisibility(0);
                    this.kwh.setVisibility(8);
                }
            } else {
                this.kvT.setVisibility(8);
                this.kwh.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.kwd.setVisibility(0);
                ap.setImageResource(this.kwf, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.kwe, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.kvY, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.kvZ, R.color.common_color_10106, 1);
            } else {
                this.kwd.setVisibility(8);
                ap.setImageResource(this.kwf, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.kwe, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.kvY, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.kvZ, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.kwa.setVisibility(8);
            } else {
                this.kwa.setVisibility(0);
                this.kvX.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.kvQ.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.kvQ.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.kvY.setText(sb.toString());
            } else {
                this.kvY.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.kwb.setVisibility(8);
                ap.setBackgroundResource(this.kwc, R.drawable.bg_activity_down);
                return;
            }
            this.kwb.setVisibility(0);
            this.kvZ.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.kwc, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.kvQ.getLayoutMode().setNightMode(i == 1);
        this.kvQ.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.kvQ.getPageContext(), i);
        this.kvT.setTextColor(ap.getColor(R.color.CAM_X0106));
        this.kwh.setTextColor(ap.getColor(R.color.CAM_X0106));
    }

    public void onDestory() {
        this.kwi = null;
    }

    public View cXI() {
        return this.kjR;
    }

    public TextView cXJ() {
        return this.kwh;
    }

    public i cXK() {
        return this.kwg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cXL() {
        if (this.kwg == null) {
            String[] strArr = {this.kvQ.getPageContext().getString(R.string.group_activity_eidt), this.kvQ.getPageContext().getString(R.string.group_activity_delete)};
            this.kwg = new i(this.kvQ.getPageContext());
            this.kwg.a(null, strArr, this.kvQ);
        }
    }
}
