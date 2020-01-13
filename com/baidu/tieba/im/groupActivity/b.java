package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.f.e;
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
/* loaded from: classes8.dex */
public class b extends c<GroupActivityActivity> {
    private LinearLayout hAA;
    private TextView hAB;
    private ImageView hAC;
    private ImageView hAD;
    private i hAE;
    private TextView hAF;
    private TextView hAG;
    private GroupActivityActivity hAo;
    private HeadImageView hAq;
    private TextView hAr;
    private LinearLayout hAs;
    private TextView hAt;
    private TextView hAu;
    private TextView hAv;
    private TextView hAw;
    private TextView hAx;
    private LinearLayout hAy;
    private LinearLayout hAz;
    private View hqj;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hAo = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.hqj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.hAr = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.hAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bUn();
                b.this.hAE.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.hAr.setVisibility(8);
        this.hAF = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.hAF.setOnClickListener(groupActivityActivity);
        this.hAF.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.hAs = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.hAq = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.hAq.setAutoChangeStyle(true);
        this.hAq.setIsRound(false);
        this.hAt = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.hAu = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.hAv = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.hAw = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.hAx = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.hAy = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.hAz = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.hAA = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.hAB = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.hAD = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.hAC = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.hAG = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hAG.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.hAG.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.hAs.getVisibility() != 0) {
                this.hAs.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.hAq.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.hAt.setText(groupActivityData.getgActivityTitle());
            this.hAu.setText(this.hAo.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.hAr.setVisibility(8);
                    this.hAF.setVisibility(0);
                    if (com.baidu.tieba.group.a.bLg().bLh() || z) {
                        this.hAG.setVisibility(8);
                    } else {
                        this.hAG.setVisibility(0);
                        com.baidu.tieba.group.a.bLg().mu(true);
                        e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.hAG != null) {
                                    b.this.hAG.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.hAr.setVisibility(0);
                    this.hAF.setVisibility(8);
                }
            } else {
                this.hAr.setVisibility(8);
                this.hAF.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.hAB.setVisibility(0);
                am.setImageResource(this.hAD, R.drawable.icon_activity_time_n);
                am.setImageResource(this.hAC, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.hAw, R.color.common_color_10106, 1);
                am.setViewTextColor(this.hAx, R.color.common_color_10106, 1);
            } else {
                this.hAB.setVisibility(8);
                am.setImageResource(this.hAD, R.drawable.icon_activity_time_s);
                am.setImageResource(this.hAC, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.hAw, R.color.common_color_10039, 1);
                am.setViewTextColor(this.hAx, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.hAy.setVisibility(8);
            } else {
                this.hAy.setVisibility(0);
                this.hAv.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.hAo.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.hAo.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.hAw.setText(sb.toString());
            } else {
                this.hAw.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.hAz.setVisibility(8);
                am.setBackgroundResource(this.hAA, R.drawable.bg_activity_down);
                return;
            }
            this.hAz.setVisibility(0);
            this.hAx.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.hAA, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.hAo.getLayoutMode().setNightMode(i == 1);
        this.hAo.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.hAo.getPageContext(), i);
        this.hAr.setTextColor(am.getColor(R.color.cp_cont_f));
        this.hAF.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.hAG = null;
    }

    public View bUk() {
        return this.hqj;
    }

    public TextView bUl() {
        return this.hAF;
    }

    public i bUm() {
        return this.hAE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUn() {
        if (this.hAE == null) {
            String[] strArr = {this.hAo.getPageContext().getString(R.string.group_activity_eidt), this.hAo.getPageContext().getString(R.string.group_activity_delete)};
            this.hAE = new i(this.hAo.getPageContext());
            this.hAE.a(null, strArr, this.hAo);
        }
    }
}
