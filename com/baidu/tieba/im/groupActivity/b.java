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
    private LinearLayout iDA;
    private LinearLayout iDB;
    private LinearLayout iDC;
    private TextView iDD;
    private ImageView iDE;
    private ImageView iDF;
    private i iDG;
    private TextView iDH;
    private TextView iDI;
    private GroupActivityActivity iDq;
    private HeadImageView iDs;
    private TextView iDt;
    private LinearLayout iDu;
    private TextView iDv;
    private TextView iDw;
    private TextView iDx;
    private TextView iDy;
    private TextView iDz;
    private View itl;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.iDq = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.itl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.iDt = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.iDt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cnp();
                b.this.iDG.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.iDt.setVisibility(8);
        this.iDH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.iDH.setOnClickListener(groupActivityActivity);
        this.iDH.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.iDu = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.iDs = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.iDs.setAutoChangeStyle(true);
        this.iDs.setIsRound(false);
        this.iDv = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.iDw = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.iDx = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.iDy = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.iDz = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.iDA = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.iDB = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.iDC = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.iDD = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.iDF = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.iDE = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.iDI = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iDI.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.iDI.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.iDu.getVisibility() != 0) {
                this.iDu.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.iDs.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.iDv.setText(groupActivityData.getgActivityTitle());
            this.iDw.setText(this.iDq.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.iDt.setVisibility(8);
                    this.iDH.setVisibility(0);
                    if (com.baidu.tieba.group.a.ceg().ceh() || z) {
                        this.iDI.setVisibility(8);
                    } else {
                        this.iDI.setVisibility(0);
                        com.baidu.tieba.group.a.ceg().ob(true);
                        e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.iDI != null) {
                                    b.this.iDI.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.iDt.setVisibility(0);
                    this.iDH.setVisibility(8);
                }
            } else {
                this.iDt.setVisibility(8);
                this.iDH.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.iDD.setVisibility(0);
                am.setImageResource(this.iDF, R.drawable.icon_activity_time_n);
                am.setImageResource(this.iDE, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.iDy, R.color.common_color_10106, 1);
                am.setViewTextColor(this.iDz, R.color.common_color_10106, 1);
            } else {
                this.iDD.setVisibility(8);
                am.setImageResource(this.iDF, R.drawable.icon_activity_time_s);
                am.setImageResource(this.iDE, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.iDy, R.color.common_color_10039, 1);
                am.setViewTextColor(this.iDz, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.iDA.setVisibility(8);
            } else {
                this.iDA.setVisibility(0);
                this.iDx.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.iDq.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.iDq.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.iDy.setText(sb.toString());
            } else {
                this.iDy.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.iDB.setVisibility(8);
                am.setBackgroundResource(this.iDC, R.drawable.bg_activity_down);
                return;
            }
            this.iDB.setVisibility(0);
            this.iDz.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.iDC, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.iDq.getLayoutMode().setNightMode(i == 1);
        this.iDq.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.iDq.getPageContext(), i);
        this.iDt.setTextColor(am.getColor(R.color.cp_cont_f));
        this.iDH.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.iDI = null;
    }

    public View cnm() {
        return this.itl;
    }

    public TextView cnn() {
        return this.iDH;
    }

    public i cno() {
        return this.iDG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnp() {
        if (this.iDG == null) {
            String[] strArr = {this.iDq.getPageContext().getString(R.string.group_activity_eidt), this.iDq.getPageContext().getString(R.string.group_activity_delete)};
            this.iDG = new i(this.iDq.getPageContext());
            this.iDG.a(null, strArr, this.iDq);
        }
    }
}
