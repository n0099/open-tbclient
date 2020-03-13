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
/* loaded from: classes10.dex */
public class b extends c<GroupActivityActivity> {
    private GroupActivityActivity hCB;
    private HeadImageView hCD;
    private TextView hCE;
    private LinearLayout hCF;
    private TextView hCG;
    private TextView hCH;
    private TextView hCI;
    private TextView hCJ;
    private TextView hCK;
    private LinearLayout hCL;
    private LinearLayout hCM;
    private LinearLayout hCN;
    private TextView hCO;
    private ImageView hCP;
    private ImageView hCQ;
    private i hCR;
    private TextView hCS;
    private TextView hCT;
    private View hsw;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hCB = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.hsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.hCE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.hCE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVR();
                b.this.hCR.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.hCE.setVisibility(8);
        this.hCS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.hCS.setOnClickListener(groupActivityActivity);
        this.hCS.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.hCF = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.hCD = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.hCD.setAutoChangeStyle(true);
        this.hCD.setIsRound(false);
        this.hCG = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.hCH = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.hCI = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.hCJ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.hCK = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.hCL = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.hCM = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.hCN = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.hCO = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.hCQ = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.hCP = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.hCT = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hCT.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.hCT.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.hCF.getVisibility() != 0) {
                this.hCF.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.hCD.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.hCG.setText(groupActivityData.getgActivityTitle());
            this.hCH.setText(this.hCB.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.hCE.setVisibility(8);
                    this.hCS.setVisibility(0);
                    if (com.baidu.tieba.group.a.bMM().bMN() || z) {
                        this.hCT.setVisibility(8);
                    } else {
                        this.hCT.setVisibility(0);
                        com.baidu.tieba.group.a.bMM().mw(true);
                        e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.hCT != null) {
                                    b.this.hCT.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.hCE.setVisibility(0);
                    this.hCS.setVisibility(8);
                }
            } else {
                this.hCE.setVisibility(8);
                this.hCS.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.hCO.setVisibility(0);
                am.setImageResource(this.hCQ, R.drawable.icon_activity_time_n);
                am.setImageResource(this.hCP, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.hCJ, R.color.common_color_10106, 1);
                am.setViewTextColor(this.hCK, R.color.common_color_10106, 1);
            } else {
                this.hCO.setVisibility(8);
                am.setImageResource(this.hCQ, R.drawable.icon_activity_time_s);
                am.setImageResource(this.hCP, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.hCJ, R.color.common_color_10039, 1);
                am.setViewTextColor(this.hCK, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.hCL.setVisibility(8);
            } else {
                this.hCL.setVisibility(0);
                this.hCI.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.hCB.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.hCB.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.hCJ.setText(sb.toString());
            } else {
                this.hCJ.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.hCM.setVisibility(8);
                am.setBackgroundResource(this.hCN, R.drawable.bg_activity_down);
                return;
            }
            this.hCM.setVisibility(0);
            this.hCK.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.hCN, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.hCB.getLayoutMode().setNightMode(i == 1);
        this.hCB.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.hCB.getPageContext(), i);
        this.hCE.setTextColor(am.getColor(R.color.cp_cont_f));
        this.hCS.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.hCT = null;
    }

    public View bVO() {
        return this.hsw;
    }

    public TextView bVP() {
        return this.hCS;
    }

    public i bVQ() {
        return this.hCR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVR() {
        if (this.hCR == null) {
            String[] strArr = {this.hCB.getPageContext().getString(R.string.group_activity_eidt), this.hCB.getPageContext().getString(R.string.group_activity_delete)};
            this.hCR = new i(this.hCB.getPageContext());
            this.hCR.a(null, strArr, this.hCB);
        }
    }
}
