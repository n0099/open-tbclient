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
    private View idP;
    private GroupActivityActivity inX;
    private HeadImageView inZ;
    private TextView ioa;
    private LinearLayout iob;
    private TextView ioc;
    private TextView iod;
    private TextView ioe;
    private TextView iof;
    private TextView iog;
    private LinearLayout ioh;
    private LinearLayout ioi;
    private LinearLayout ioj;
    private TextView iok;
    private ImageView iol;
    private ImageView iom;
    private i ion;
    private TextView ioo;
    private TextView iop;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.inX = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.idP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.ioa = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.ioa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cgJ();
                b.this.ion.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.ioa.setVisibility(8);
        this.ioo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.ioo.setOnClickListener(groupActivityActivity);
        this.ioo.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.iob = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.inZ = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.inZ.setAutoChangeStyle(true);
        this.inZ.setIsRound(false);
        this.ioc = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.iod = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.ioe = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.iof = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.iog = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.ioh = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.ioi = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.ioj = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.iok = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.iom = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.iol = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.iop = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iop.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.iop.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.iob.getVisibility() != 0) {
                this.iob.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.inZ.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.ioc.setText(groupActivityData.getgActivityTitle());
            this.iod.setText(this.inX.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.ioa.setVisibility(8);
                    this.ioo.setVisibility(0);
                    if (com.baidu.tieba.group.a.bXA().bXB() || z) {
                        this.iop.setVisibility(8);
                    } else {
                        this.iop.setVisibility(0);
                        com.baidu.tieba.group.a.bXA().nG(true);
                        e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.iop != null) {
                                    b.this.iop.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.ioa.setVisibility(0);
                    this.ioo.setVisibility(8);
                }
            } else {
                this.ioa.setVisibility(8);
                this.ioo.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.iok.setVisibility(0);
                am.setImageResource(this.iom, R.drawable.icon_activity_time_n);
                am.setImageResource(this.iol, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.iof, R.color.common_color_10106, 1);
                am.setViewTextColor(this.iog, R.color.common_color_10106, 1);
            } else {
                this.iok.setVisibility(8);
                am.setImageResource(this.iom, R.drawable.icon_activity_time_s);
                am.setImageResource(this.iol, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.iof, R.color.common_color_10039, 1);
                am.setViewTextColor(this.iog, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.ioh.setVisibility(8);
            } else {
                this.ioh.setVisibility(0);
                this.ioe.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.inX.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.inX.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.iof.setText(sb.toString());
            } else {
                this.iof.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.ioi.setVisibility(8);
                am.setBackgroundResource(this.ioj, R.drawable.bg_activity_down);
                return;
            }
            this.ioi.setVisibility(0);
            this.iog.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.ioj, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.inX.getLayoutMode().setNightMode(i == 1);
        this.inX.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.inX.getPageContext(), i);
        this.ioa.setTextColor(am.getColor(R.color.cp_cont_f));
        this.ioo.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.iop = null;
    }

    public View cgG() {
        return this.idP;
    }

    public TextView cgH() {
        return this.ioo;
    }

    public i cgI() {
        return this.ion;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgJ() {
        if (this.ion == null) {
            String[] strArr = {this.inX.getPageContext().getString(R.string.group_activity_eidt), this.inX.getPageContext().getString(R.string.group_activity_delete)};
            this.ion = new i(this.inX.getPageContext());
            this.ion.a(null, strArr, this.inX);
        }
    }
}
