package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.g.e;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
    private GroupActivityActivity gIH;
    private HeadImageView gIJ;
    private TextView gIK;
    private LinearLayout gIL;
    private TextView gIM;
    private TextView gIN;
    private TextView gIO;
    private TextView gIP;
    private TextView gIQ;
    private LinearLayout gIR;
    private LinearLayout gIS;
    private LinearLayout gIT;
    private TextView gIU;
    private ImageView gIV;
    private ImageView gIW;
    private i gIX;
    private TextView gIY;
    private TextView gIZ;
    private View gyy;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gIH = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gyy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gIK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gIK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBR();
                b.this.gIX.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gIK.setVisibility(8);
        this.gIY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gIY.setOnClickListener(groupActivityActivity);
        this.gIY.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gIL = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gIJ = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gIJ.setAutoChangeStyle(true);
        this.gIJ.setIsRound(false);
        this.gIM = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gIN = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gIO = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gIP = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gIQ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gIR = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gIS = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gIT = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gIU = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gIW = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gIV = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gIZ = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gIZ.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gIZ.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gIL.getVisibility() != 0) {
                this.gIL.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gIJ.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gIM.setText(groupActivityData.getgActivityTitle());
            this.gIN.setText(this.gIH.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gIK.setVisibility(8);
                    this.gIY.setVisibility(0);
                    if (com.baidu.tieba.group.a.bsG().bsH() || z) {
                        this.gIZ.setVisibility(8);
                    } else {
                        this.gIZ.setVisibility(0);
                        com.baidu.tieba.group.a.bsG().kV(true);
                        e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gIZ != null) {
                                    b.this.gIZ.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gIK.setVisibility(0);
                    this.gIY.setVisibility(8);
                }
            } else {
                this.gIK.setVisibility(8);
                this.gIY.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gIU.setVisibility(0);
                am.setImageResource(this.gIW, R.drawable.icon_activity_time_n);
                am.setImageResource(this.gIV, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.gIP, R.color.common_color_10106, 1);
                am.setViewTextColor(this.gIQ, R.color.common_color_10106, 1);
            } else {
                this.gIU.setVisibility(8);
                am.setImageResource(this.gIW, R.drawable.icon_activity_time_s);
                am.setImageResource(this.gIV, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.gIP, R.color.common_color_10039, 1);
                am.setViewTextColor(this.gIQ, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gIR.setVisibility(8);
            } else {
                this.gIR.setVisibility(0);
                this.gIO.setText(groupActivityData.getgActivityContent());
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
                sb.append(HanziToPinyin.Token.SEPARATOR);
                sb.append(aq.getWeekString(year, month, date2));
                sb.append(HanziToPinyin.Token.SEPARATOR);
                if (hours > 12) {
                    sb.append(this.gIH.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gIH.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gIP.setText(sb.toString());
            } else {
                this.gIP.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gIS.setVisibility(8);
                am.setBackgroundResource(this.gIT, R.drawable.bg_activity_down);
                return;
            }
            this.gIS.setVisibility(0);
            this.gIQ.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.gIT, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gIH.getLayoutMode().setNightMode(i == 1);
        this.gIH.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.gIH.getPageContext(), i);
        this.gIK.setTextColor(am.getColor(R.color.cp_cont_f));
        this.gIY.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gIZ = null;
    }

    public View bBO() {
        return this.gyy;
    }

    public TextView bBP() {
        return this.gIY;
    }

    public i bBQ() {
        return this.gIX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBR() {
        if (this.gIX == null) {
            String[] strArr = {this.gIH.getPageContext().getString(R.string.group_activity_eidt), this.gIH.getPageContext().getString(R.string.group_activity_delete)};
            this.gIX = new i(this.gIH.getPageContext());
            this.gIX.a(null, strArr, this.gIH);
        }
    }
}
