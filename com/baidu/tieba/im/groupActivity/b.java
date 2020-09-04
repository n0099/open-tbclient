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
/* loaded from: classes17.dex */
public class b extends c<GroupActivityActivity> {
    private View jfB;
    private GroupActivityActivity jrM;
    private HeadImageView jrO;
    private TextView jrP;
    private LinearLayout jrQ;
    private TextView jrR;
    private TextView jrS;
    private TextView jrT;
    private TextView jrU;
    private TextView jrV;
    private LinearLayout jrW;
    private LinearLayout jrX;
    private LinearLayout jrY;
    private TextView jrZ;
    private ImageView jsa;
    private ImageView jsb;
    private i jsc;
    private TextView jsd;
    private TextView jse;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jrM = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.jfB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.jrP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.jrP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cFV();
                b.this.jsc.Nv();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.jrP.setVisibility(8);
        this.jsd = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.jsd.setOnClickListener(groupActivityActivity);
        this.jsd.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.jrQ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.jrO = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.jrO.setAutoChangeStyle(true);
        this.jrO.setIsRound(false);
        this.jrR = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.jrS = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.jrT = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.jrU = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.jrV = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.jrW = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.jrX = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.jrY = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.jrZ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.jsb = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.jsa = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.jse = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jse.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.jse.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.jrQ.getVisibility() != 0) {
                this.jrQ.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.jrO.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.jrR.setText(groupActivityData.getgActivityTitle());
            this.jrS.setText(this.jrM.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.jrP.setVisibility(8);
                    this.jsd.setVisibility(0);
                    if (com.baidu.tieba.group.a.cvN().cvO() || z) {
                        this.jse.setVisibility(8);
                    } else {
                        this.jse.setVisibility(0);
                        com.baidu.tieba.group.a.cvN().pz(true);
                        e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.jse != null) {
                                    b.this.jse.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.jrP.setVisibility(0);
                    this.jsd.setVisibility(8);
                }
            } else {
                this.jrP.setVisibility(8);
                this.jsd.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.jrZ.setVisibility(0);
                ap.setImageResource(this.jsb, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.jsa, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.jrU, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.jrV, R.color.common_color_10106, 1);
            } else {
                this.jrZ.setVisibility(8);
                ap.setImageResource(this.jsb, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.jsa, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.jrU, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.jrV, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.jrW.setVisibility(8);
            } else {
                this.jrW.setVisibility(0);
                this.jrT.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.jrM.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.jrM.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.jrU.setText(sb.toString());
            } else {
                this.jrU.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.jrX.setVisibility(8);
                ap.setBackgroundResource(this.jrY, R.drawable.bg_activity_down);
                return;
            }
            this.jrX.setVisibility(0);
            this.jrV.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.jrY, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.jrM.getLayoutMode().setNightMode(i == 1);
        this.jrM.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.jrM.getPageContext(), i);
        this.jrP.setTextColor(ap.getColor(R.color.cp_cont_f));
        this.jsd.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.jse = null;
    }

    public View cFS() {
        return this.jfB;
    }

    public TextView cFT() {
        return this.jsd;
    }

    public i cFU() {
        return this.jsc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFV() {
        if (this.jsc == null) {
            String[] strArr = {this.jrM.getPageContext().getString(R.string.group_activity_eidt), this.jrM.getPageContext().getString(R.string.group_activity_delete)};
            this.jsc = new i(this.jrM.getPageContext());
            this.jsc.a(null, strArr, this.jrM);
        }
    }
}
