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
    private View jfv;
    private GroupActivityActivity jrG;
    private HeadImageView jrI;
    private TextView jrJ;
    private LinearLayout jrK;
    private TextView jrL;
    private TextView jrM;
    private TextView jrN;
    private TextView jrO;
    private TextView jrP;
    private LinearLayout jrQ;
    private LinearLayout jrR;
    private LinearLayout jrS;
    private TextView jrT;
    private ImageView jrU;
    private ImageView jrV;
    private i jrW;
    private TextView jrX;
    private TextView jrY;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jrG = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.jfv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.jrJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.jrJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cFU();
                b.this.jrW.Nv();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.jrJ.setVisibility(8);
        this.jrX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.jrX.setOnClickListener(groupActivityActivity);
        this.jrX.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.jrK = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.jrI = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.jrI.setAutoChangeStyle(true);
        this.jrI.setIsRound(false);
        this.jrL = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.jrM = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.jrN = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.jrO = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.jrP = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.jrQ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.jrR = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.jrS = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.jrT = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.jrV = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.jrU = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.jrY = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jrY.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.jrY.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.jrK.getVisibility() != 0) {
                this.jrK.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.jrI.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.jrL.setText(groupActivityData.getgActivityTitle());
            this.jrM.setText(this.jrG.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.jrJ.setVisibility(8);
                    this.jrX.setVisibility(0);
                    if (com.baidu.tieba.group.a.cvM().cvN() || z) {
                        this.jrY.setVisibility(8);
                    } else {
                        this.jrY.setVisibility(0);
                        com.baidu.tieba.group.a.cvM().px(true);
                        e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.jrY != null) {
                                    b.this.jrY.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.jrJ.setVisibility(0);
                    this.jrX.setVisibility(8);
                }
            } else {
                this.jrJ.setVisibility(8);
                this.jrX.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.jrT.setVisibility(0);
                ap.setImageResource(this.jrV, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.jrU, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.jrO, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.jrP, R.color.common_color_10106, 1);
            } else {
                this.jrT.setVisibility(8);
                ap.setImageResource(this.jrV, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.jrU, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.jrO, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.jrP, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.jrQ.setVisibility(8);
            } else {
                this.jrQ.setVisibility(0);
                this.jrN.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.jrG.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.jrG.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.jrO.setText(sb.toString());
            } else {
                this.jrO.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.jrR.setVisibility(8);
                ap.setBackgroundResource(this.jrS, R.drawable.bg_activity_down);
                return;
            }
            this.jrR.setVisibility(0);
            this.jrP.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.jrS, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.jrG.getLayoutMode().setNightMode(i == 1);
        this.jrG.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.jrG.getPageContext(), i);
        this.jrJ.setTextColor(ap.getColor(R.color.cp_cont_f));
        this.jrX.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.jrY = null;
    }

    public View cFR() {
        return this.jfv;
    }

    public TextView cFS() {
        return this.jrX;
    }

    public i cFT() {
        return this.jrW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFU() {
        if (this.jrW == null) {
            String[] strArr = {this.jrG.getPageContext().getString(R.string.group_activity_eidt), this.jrG.getPageContext().getString(R.string.group_activity_delete)};
            this.jrW = new i(this.jrG.getPageContext());
            this.jrW.a(null, strArr, this.jrG);
        }
    }
}
