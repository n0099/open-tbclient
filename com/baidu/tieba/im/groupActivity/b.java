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
/* loaded from: classes22.dex */
public class b extends c<GroupActivityActivity> {
    private LinearLayout jAA;
    private TextView jAB;
    private ImageView jAC;
    private ImageView jAD;
    private i jAE;
    private TextView jAF;
    private TextView jAG;
    private GroupActivityActivity jAo;
    private HeadImageView jAq;
    private TextView jAr;
    private LinearLayout jAs;
    private TextView jAt;
    private TextView jAu;
    private TextView jAv;
    private TextView jAw;
    private TextView jAx;
    private LinearLayout jAy;
    private LinearLayout jAz;
    private View joh;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jAo = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.joh = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.jAr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.jAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cJB();
                b.this.jAE.NY();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.jAr.setVisibility(8);
        this.jAF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.jAF.setOnClickListener(groupActivityActivity);
        this.jAF.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.jAs = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.jAq = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.jAq.setAutoChangeStyle(true);
        this.jAq.setIsRound(false);
        this.jAt = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.jAu = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.jAv = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.jAw = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.jAx = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.jAy = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.jAz = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.jAA = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.jAB = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.jAD = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.jAC = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.jAG = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jAG.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.jAG.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.jAs.getVisibility() != 0) {
                this.jAs.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.jAq.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.jAt.setText(groupActivityData.getgActivityTitle());
            this.jAu.setText(this.jAo.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.jAr.setVisibility(8);
                    this.jAF.setVisibility(0);
                    if (com.baidu.tieba.group.a.czg().czh() || z) {
                        this.jAG.setVisibility(8);
                    } else {
                        this.jAG.setVisibility(0);
                        com.baidu.tieba.group.a.czg().pF(true);
                        e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.jAG != null) {
                                    b.this.jAG.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.jAr.setVisibility(0);
                    this.jAF.setVisibility(8);
                }
            } else {
                this.jAr.setVisibility(8);
                this.jAF.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.jAB.setVisibility(0);
                ap.setImageResource(this.jAD, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.jAC, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.jAw, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.jAx, R.color.common_color_10106, 1);
            } else {
                this.jAB.setVisibility(8);
                ap.setImageResource(this.jAD, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.jAC, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.jAw, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.jAx, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.jAy.setVisibility(8);
            } else {
                this.jAy.setVisibility(0);
                this.jAv.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.jAo.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.jAo.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.jAw.setText(sb.toString());
            } else {
                this.jAw.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.jAz.setVisibility(8);
                ap.setBackgroundResource(this.jAA, R.drawable.bg_activity_down);
                return;
            }
            this.jAz.setVisibility(0);
            this.jAx.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.jAA, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.jAo.getLayoutMode().setNightMode(i == 1);
        this.jAo.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.jAo.getPageContext(), i);
        this.jAr.setTextColor(ap.getColor(R.color.cp_cont_f));
        this.jAF.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.jAG = null;
    }

    public View cJy() {
        return this.joh;
    }

    public TextView cJz() {
        return this.jAF;
    }

    public i cJA() {
        return this.jAE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJB() {
        if (this.jAE == null) {
            String[] strArr = {this.jAo.getPageContext().getString(R.string.group_activity_eidt), this.jAo.getPageContext().getString(R.string.group_activity_delete)};
            this.jAE = new i(this.jAo.getPageContext());
            this.jAE.a(null, strArr, this.jAo);
        }
    }
}
