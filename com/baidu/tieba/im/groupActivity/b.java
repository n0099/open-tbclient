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
    private View iQw;
    private GroupActivityActivity jcE;
    private HeadImageView jcG;
    private TextView jcH;
    private LinearLayout jcI;
    private TextView jcJ;
    private TextView jcK;
    private TextView jcL;
    private TextView jcM;
    private TextView jcN;
    private LinearLayout jcO;
    private LinearLayout jcP;
    private LinearLayout jcQ;
    private TextView jcR;
    private ImageView jcS;
    private ImageView jcT;
    private i jcU;
    private TextView jcV;
    private TextView jcW;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jcE = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.iQw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.jcH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.jcH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cvd();
                b.this.jcU.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.jcH.setVisibility(8);
        this.jcV = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.jcV.setOnClickListener(groupActivityActivity);
        this.jcV.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.jcI = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.jcG = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.jcG.setAutoChangeStyle(true);
        this.jcG.setIsRound(false);
        this.jcJ = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.jcK = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.jcL = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.jcM = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.jcN = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.jcO = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.jcP = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.jcQ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.jcR = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.jcT = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.jcS = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.jcW = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcW.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.jcW.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.jcI.getVisibility() != 0) {
                this.jcI.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.jcG.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.jcJ.setText(groupActivityData.getgActivityTitle());
            this.jcK.setText(this.jcE.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.jcH.setVisibility(8);
                    this.jcV.setVisibility(0);
                    if (com.baidu.tieba.group.a.cld().cle() || z) {
                        this.jcW.setVisibility(8);
                    } else {
                        this.jcW.setVisibility(0);
                        com.baidu.tieba.group.a.cld().oS(true);
                        e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.jcW != null) {
                                    b.this.jcW.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.jcH.setVisibility(0);
                    this.jcV.setVisibility(8);
                }
            } else {
                this.jcH.setVisibility(8);
                this.jcV.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.jcR.setVisibility(0);
                ao.setImageResource(this.jcT, R.drawable.icon_activity_time_n);
                ao.setImageResource(this.jcS, R.drawable.icon_activity_lbs_n);
                ao.setViewTextColor(this.jcM, R.color.common_color_10106, 1);
                ao.setViewTextColor(this.jcN, R.color.common_color_10106, 1);
            } else {
                this.jcR.setVisibility(8);
                ao.setImageResource(this.jcT, R.drawable.icon_activity_time_s);
                ao.setImageResource(this.jcS, R.drawable.icon_activity_lbs_s);
                ao.setViewTextColor(this.jcM, R.color.common_color_10039, 1);
                ao.setViewTextColor(this.jcN, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.jcO.setVisibility(8);
            } else {
                this.jcO.setVisibility(0);
                this.jcL.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.jcE.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.jcE.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.jcM.setText(sb.toString());
            } else {
                this.jcM.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.jcP.setVisibility(8);
                ao.setBackgroundResource(this.jcQ, R.drawable.bg_activity_down);
                return;
            }
            this.jcP.setVisibility(0);
            this.jcN.setText(groupActivityData.getgActivityArea());
            ao.setBackgroundResource(this.jcQ, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.jcE.getLayoutMode().setNightMode(i == 1);
        this.jcE.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.jcE.getPageContext(), i);
        this.jcH.setTextColor(ao.getColor(R.color.cp_cont_f));
        this.jcV.setTextColor(ao.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.jcW = null;
    }

    public View cva() {
        return this.iQw;
    }

    public TextView cvb() {
        return this.jcV;
    }

    public i cvc() {
        return this.jcU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cvd() {
        if (this.jcU == null) {
            String[] strArr = {this.jcE.getPageContext().getString(R.string.group_activity_eidt), this.jcE.getPageContext().getString(R.string.group_activity_delete)};
            this.jcU = new i(this.jcE.getPageContext());
            this.jcU.a(null, strArr, this.jcE);
        }
    }
}
