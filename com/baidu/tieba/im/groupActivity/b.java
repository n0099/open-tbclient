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
/* loaded from: classes7.dex */
public class b extends c<GroupActivityActivity> {
    private View hmG;
    private GroupActivityActivity hwL;
    private HeadImageView hwN;
    private TextView hwO;
    private LinearLayout hwP;
    private TextView hwQ;
    private TextView hwR;
    private TextView hwS;
    private TextView hwT;
    private TextView hwU;
    private LinearLayout hwV;
    private LinearLayout hwW;
    private LinearLayout hwX;
    private TextView hwY;
    private ImageView hwZ;
    private ImageView hxa;
    private i hxb;
    private TextView hxc;
    private TextView hxd;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hwL = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.hmG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.hwO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.hwO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bTe();
                b.this.hxb.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.hwO.setVisibility(8);
        this.hxc = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.hxc.setOnClickListener(groupActivityActivity);
        this.hxc.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.hwP = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.hwN = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.hwN.setAutoChangeStyle(true);
        this.hwN.setIsRound(false);
        this.hwQ = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.hwR = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.hwS = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.hwT = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.hwU = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.hwV = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.hwW = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.hwX = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.hwY = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.hxa = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.hwZ = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.hxd = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hxd.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.hxd.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.hwP.getVisibility() != 0) {
                this.hwP.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.hwN.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.hwQ.setText(groupActivityData.getgActivityTitle());
            this.hwR.setText(this.hwL.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.hwO.setVisibility(8);
                    this.hxc.setVisibility(0);
                    if (com.baidu.tieba.group.a.bKb().bKc() || z) {
                        this.hxd.setVisibility(8);
                    } else {
                        this.hxd.setVisibility(0);
                        com.baidu.tieba.group.a.bKb().mj(true);
                        e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.hxd != null) {
                                    b.this.hxd.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.hwO.setVisibility(0);
                    this.hxc.setVisibility(8);
                }
            } else {
                this.hwO.setVisibility(8);
                this.hxc.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.hwY.setVisibility(0);
                am.setImageResource(this.hxa, R.drawable.icon_activity_time_n);
                am.setImageResource(this.hwZ, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.hwT, R.color.common_color_10106, 1);
                am.setViewTextColor(this.hwU, R.color.common_color_10106, 1);
            } else {
                this.hwY.setVisibility(8);
                am.setImageResource(this.hxa, R.drawable.icon_activity_time_s);
                am.setImageResource(this.hwZ, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.hwT, R.color.common_color_10039, 1);
                am.setViewTextColor(this.hwU, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.hwV.setVisibility(8);
            } else {
                this.hwV.setVisibility(0);
                this.hwS.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.hwL.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.hwL.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.hwT.setText(sb.toString());
            } else {
                this.hwT.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.hwW.setVisibility(8);
                am.setBackgroundResource(this.hwX, R.drawable.bg_activity_down);
                return;
            }
            this.hwW.setVisibility(0);
            this.hwU.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.hwX, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.hwL.getLayoutMode().setNightMode(i == 1);
        this.hwL.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.hwL.getPageContext(), i);
        this.hwO.setTextColor(am.getColor(R.color.cp_cont_f));
        this.hxc.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.hxd = null;
    }

    public View bTb() {
        return this.hmG;
    }

    public TextView bTc() {
        return this.hxc;
    }

    public i bTd() {
        return this.hxb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTe() {
        if (this.hxb == null) {
            String[] strArr = {this.hwL.getPageContext().getString(R.string.group_activity_eidt), this.hwL.getPageContext().getString(R.string.group_activity_delete)};
            this.hxb = new i(this.hwL.getPageContext());
            this.hxb.a(null, strArr, this.hwL);
        }
    }
}
