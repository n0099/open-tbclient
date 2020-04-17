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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes10.dex */
public class b extends c<GroupActivityActivity> {
    private View idJ;
    private GroupActivityActivity inR;
    private HeadImageView inT;
    private TextView inU;
    private LinearLayout inV;
    private TextView inW;
    private TextView inX;
    private TextView inY;
    private TextView inZ;
    private TextView ioa;
    private LinearLayout iob;
    private LinearLayout ioc;
    private LinearLayout iod;
    private TextView ioe;
    private ImageView iof;
    private ImageView iog;
    private i ioh;
    private TextView ioi;
    private TextView ioj;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.inR = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.idJ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.inU = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.inU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cgK();
                b.this.ioh.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.inU.setVisibility(8);
        this.ioi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.ioi.setOnClickListener(groupActivityActivity);
        this.ioi.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.inV = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.inT = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.inT.setAutoChangeStyle(true);
        this.inT.setIsRound(false);
        this.inW = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.inX = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.inY = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.inZ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.ioa = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.iob = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.ioc = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.iod = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.ioe = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.iog = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.iof = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.ioj = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ioj.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.ioj.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.inV.getVisibility() != 0) {
                this.inV.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.inT.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.inW.setText(groupActivityData.getgActivityTitle());
            this.inX.setText(this.inR.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.inU.setVisibility(8);
                    this.ioi.setVisibility(0);
                    if (com.baidu.tieba.group.a.bXB().bXC() || z) {
                        this.ioj.setVisibility(8);
                    } else {
                        this.ioj.setVisibility(0);
                        com.baidu.tieba.group.a.bXB().nG(true);
                        e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.ioj != null) {
                                    b.this.ioj.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.inU.setVisibility(0);
                    this.ioi.setVisibility(8);
                }
            } else {
                this.inU.setVisibility(8);
                this.ioi.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.ioe.setVisibility(0);
                am.setImageResource(this.iog, R.drawable.icon_activity_time_n);
                am.setImageResource(this.iof, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.inZ, R.color.common_color_10106, 1);
                am.setViewTextColor(this.ioa, R.color.common_color_10106, 1);
            } else {
                this.ioe.setVisibility(8);
                am.setImageResource(this.iog, R.drawable.icon_activity_time_s);
                am.setImageResource(this.iof, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.inZ, R.color.common_color_10039, 1);
                am.setViewTextColor(this.ioa, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.iob.setVisibility(8);
            } else {
                this.iob.setVisibility(0);
                this.inY.setText(groupActivityData.getgActivityContent());
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
                sb.append(aq.getWeekString(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.inR.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.inR.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.inZ.setText(sb.toString());
            } else {
                this.inZ.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.ioc.setVisibility(8);
                am.setBackgroundResource(this.iod, R.drawable.bg_activity_down);
                return;
            }
            this.ioc.setVisibility(0);
            this.ioa.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.iod, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.inR.getLayoutMode().setNightMode(i == 1);
        this.inR.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.inR.getPageContext(), i);
        this.inU.setTextColor(am.getColor(R.color.cp_cont_f));
        this.ioi.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.ioj = null;
    }

    public View cgH() {
        return this.idJ;
    }

    public TextView cgI() {
        return this.ioi;
    }

    public i cgJ() {
        return this.ioh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgK() {
        if (this.ioh == null) {
            String[] strArr = {this.inR.getPageContext().getString(R.string.group_activity_eidt), this.inR.getPageContext().getString(R.string.group_activity_delete)};
            this.ioh = new i(this.inR.getPageContext());
            this.ioh.a(null, strArr, this.inR);
        }
    }
}
