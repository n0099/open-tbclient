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
/* loaded from: classes23.dex */
public class b extends c<GroupActivityActivity> {
    private View jDe;
    private ImageView jPA;
    private i jPB;
    private TextView jPC;
    private TextView jPD;
    private GroupActivityActivity jPl;
    private HeadImageView jPn;
    private TextView jPo;
    private LinearLayout jPp;
    private TextView jPq;
    private TextView jPr;
    private TextView jPs;
    private TextView jPt;
    private TextView jPu;
    private LinearLayout jPv;
    private LinearLayout jPw;
    private LinearLayout jPx;
    private TextView jPy;
    private ImageView jPz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.jPl = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.jDe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.jPo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.jPo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cNk();
                b.this.jPB.Pd();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.jPo.setVisibility(8);
        this.jPC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.jPC.setOnClickListener(groupActivityActivity);
        this.jPC.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.jPp = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.jPn = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.jPn.setAutoChangeStyle(true);
        this.jPn.setIsRound(false);
        this.jPq = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.jPr = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.jPs = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.jPt = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.jPu = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.jPv = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.jPw = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.jPx = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.jPy = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.jPA = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.jPz = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.jPD = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jPD.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.jPD.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.jPp.getVisibility() != 0) {
                this.jPp.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.jPn.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.jPq.setText(groupActivityData.getgActivityTitle());
            this.jPr.setText(this.jPl.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.jPo.setVisibility(8);
                    this.jPC.setVisibility(0);
                    if (com.baidu.tieba.group.a.cCE().cCF() || z) {
                        this.jPD.setVisibility(8);
                    } else {
                        this.jPD.setVisibility(0);
                        com.baidu.tieba.group.a.cCE().qk(true);
                        e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.jPD != null) {
                                    b.this.jPD.setVisibility(8);
                                }
                            }
                        }, IMConnection.RETRY_DELAY_TIMES);
                    }
                } else {
                    this.jPo.setVisibility(0);
                    this.jPC.setVisibility(8);
                }
            } else {
                this.jPo.setVisibility(8);
                this.jPC.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.jPy.setVisibility(0);
                ap.setImageResource(this.jPA, R.drawable.icon_activity_time_n);
                ap.setImageResource(this.jPz, R.drawable.icon_activity_lbs_n);
                ap.setViewTextColor(this.jPt, R.color.common_color_10106, 1);
                ap.setViewTextColor(this.jPu, R.color.common_color_10106, 1);
            } else {
                this.jPy.setVisibility(8);
                ap.setImageResource(this.jPA, R.drawable.icon_activity_time_s);
                ap.setImageResource(this.jPz, R.drawable.icon_activity_lbs_s);
                ap.setViewTextColor(this.jPt, R.color.common_color_10039, 1);
                ap.setViewTextColor(this.jPu, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.jPv.setVisibility(8);
            } else {
                this.jPv.setVisibility(0);
                this.jPs.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.jPl.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.jPl.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.jPt.setText(sb.toString());
            } else {
                this.jPt.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.jPw.setVisibility(8);
                ap.setBackgroundResource(this.jPx, R.drawable.bg_activity_down);
                return;
            }
            this.jPw.setVisibility(0);
            this.jPu.setText(groupActivityData.getgActivityArea());
            ap.setBackgroundResource(this.jPx, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.jPl.getLayoutMode().setNightMode(i == 1);
        this.jPl.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.jPl.getPageContext(), i);
        this.jPo.setTextColor(ap.getColor(R.color.cp_cont_f));
        this.jPC.setTextColor(ap.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.jPD = null;
    }

    public View cNh() {
        return this.jDe;
    }

    public TextView cNi() {
        return this.jPC;
    }

    public i cNj() {
        return this.jPB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNk() {
        if (this.jPB == null) {
            String[] strArr = {this.jPl.getPageContext().getString(R.string.group_activity_eidt), this.jPl.getPageContext().getString(R.string.group_activity_delete)};
            this.jPB = new i(this.jPl.getPageContext());
            this.jPB.a(null, strArr, this.jPl);
        }
    }
}
