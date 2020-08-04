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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes17.dex */
public class b extends c<GroupActivityActivity> {
    private View iQy;
    private GroupActivityActivity jcG;
    private HeadImageView jcI;
    private TextView jcJ;
    private LinearLayout jcK;
    private TextView jcL;
    private TextView jcM;
    private TextView jcN;
    private TextView jcO;
    private TextView jcP;
    private LinearLayout jcQ;
    private LinearLayout jcR;
    private LinearLayout jcS;
    private TextView jcT;
    private ImageView jcU;
    private ImageView jcV;
    private i jcW;
    private TextView jcX;
    private TextView jcY;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jcG = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.iQy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.jcJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.jcJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cvd();
                b.this.jcW.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.jcJ.setVisibility(8);
        this.jcX = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.jcX.setOnClickListener(groupActivityActivity);
        this.jcX.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.jcK = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.jcI = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.jcI.setAutoChangeStyle(true);
        this.jcI.setIsRound(false);
        this.jcL = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.jcM = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.jcN = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.jcO = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.jcP = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.jcQ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.jcR = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.jcS = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.jcT = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.jcV = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.jcU = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.jcY = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcY.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.jcY.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.jcK.getVisibility() != 0) {
                this.jcK.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.jcI.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.jcL.setText(groupActivityData.getgActivityTitle());
            this.jcM.setText(this.jcG.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.jcJ.setVisibility(8);
                    this.jcX.setVisibility(0);
                    if (com.baidu.tieba.group.a.cld().cle() || z) {
                        this.jcY.setVisibility(8);
                    } else {
                        this.jcY.setVisibility(0);
                        com.baidu.tieba.group.a.cld().oS(true);
                        e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.jcY != null) {
                                    b.this.jcY.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.jcJ.setVisibility(0);
                    this.jcX.setVisibility(8);
                }
            } else {
                this.jcJ.setVisibility(8);
                this.jcX.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.jcT.setVisibility(0);
                ao.setImageResource(this.jcV, R.drawable.icon_activity_time_n);
                ao.setImageResource(this.jcU, R.drawable.icon_activity_lbs_n);
                ao.setViewTextColor(this.jcO, R.color.common_color_10106, 1);
                ao.setViewTextColor(this.jcP, R.color.common_color_10106, 1);
            } else {
                this.jcT.setVisibility(8);
                ao.setImageResource(this.jcV, R.drawable.icon_activity_time_s);
                ao.setImageResource(this.jcU, R.drawable.icon_activity_lbs_s);
                ao.setViewTextColor(this.jcO, R.color.common_color_10039, 1);
                ao.setViewTextColor(this.jcP, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.jcQ.setVisibility(8);
            } else {
                this.jcQ.setVisibility(0);
                this.jcN.setText(groupActivityData.getgActivityContent());
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
                sb.append(as.getWeekString(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.jcG.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.jcG.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.jcO.setText(sb.toString());
            } else {
                this.jcO.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.jcR.setVisibility(8);
                ao.setBackgroundResource(this.jcS, R.drawable.bg_activity_down);
                return;
            }
            this.jcR.setVisibility(0);
            this.jcP.setText(groupActivityData.getgActivityArea());
            ao.setBackgroundResource(this.jcS, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.jcG.getLayoutMode().setNightMode(i == 1);
        this.jcG.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.jcG.getPageContext(), i);
        this.jcJ.setTextColor(ao.getColor(R.color.cp_cont_f));
        this.jcX.setTextColor(ao.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.jcY = null;
    }

    public View cva() {
        return this.iQy;
    }

    public TextView cvb() {
        return this.jcX;
    }

    public i cvc() {
        return this.jcW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvd() {
        if (this.jcW == null) {
            String[] strArr = {this.jcG.getPageContext().getString(R.string.group_activity_eidt), this.jcG.getPageContext().getString(R.string.group_activity_delete)};
            this.jcW = new i(this.jcG.getPageContext());
            this.jcW.a(null, strArr, this.jcG);
        }
    }
}
