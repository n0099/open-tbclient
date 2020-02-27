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
    private TextView hCA;
    private ImageView hCB;
    private ImageView hCC;
    private i hCD;
    private TextView hCE;
    private TextView hCF;
    private GroupActivityActivity hCn;
    private HeadImageView hCp;
    private TextView hCq;
    private LinearLayout hCr;
    private TextView hCs;
    private TextView hCt;
    private TextView hCu;
    private TextView hCv;
    private TextView hCw;
    private LinearLayout hCx;
    private LinearLayout hCy;
    private LinearLayout hCz;
    private View hsi;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hCn = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.hsi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.hCq = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.hCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVO();
                b.this.hCD.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.hCq.setVisibility(8);
        this.hCE = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.hCE.setOnClickListener(groupActivityActivity);
        this.hCE.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.hCr = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.hCp = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.hCp.setAutoChangeStyle(true);
        this.hCp.setIsRound(false);
        this.hCs = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.hCt = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.hCu = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.hCv = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.hCw = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.hCx = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.hCy = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.hCz = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.hCA = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.hCC = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.hCB = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.hCF = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hCF.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.hCF.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.hCr.getVisibility() != 0) {
                this.hCr.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.hCp.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.hCs.setText(groupActivityData.getgActivityTitle());
            this.hCt.setText(this.hCn.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.hCq.setVisibility(8);
                    this.hCE.setVisibility(0);
                    if (com.baidu.tieba.group.a.bMJ().bMK() || z) {
                        this.hCF.setVisibility(8);
                    } else {
                        this.hCF.setVisibility(0);
                        com.baidu.tieba.group.a.bMJ().mw(true);
                        e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.hCF != null) {
                                    b.this.hCF.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.hCq.setVisibility(0);
                    this.hCE.setVisibility(8);
                }
            } else {
                this.hCq.setVisibility(8);
                this.hCE.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.hCA.setVisibility(0);
                am.setImageResource(this.hCC, R.drawable.icon_activity_time_n);
                am.setImageResource(this.hCB, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.hCv, R.color.common_color_10106, 1);
                am.setViewTextColor(this.hCw, R.color.common_color_10106, 1);
            } else {
                this.hCA.setVisibility(8);
                am.setImageResource(this.hCC, R.drawable.icon_activity_time_s);
                am.setImageResource(this.hCB, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.hCv, R.color.common_color_10039, 1);
                am.setViewTextColor(this.hCw, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.hCx.setVisibility(8);
            } else {
                this.hCx.setVisibility(0);
                this.hCu.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.hCn.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.hCn.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.hCv.setText(sb.toString());
            } else {
                this.hCv.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.hCy.setVisibility(8);
                am.setBackgroundResource(this.hCz, R.drawable.bg_activity_down);
                return;
            }
            this.hCy.setVisibility(0);
            this.hCw.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.hCz, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.hCn.getLayoutMode().setNightMode(i == 1);
        this.hCn.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.hCn.getPageContext(), i);
        this.hCq.setTextColor(am.getColor(R.color.cp_cont_f));
        this.hCE.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.hCF = null;
    }

    public View bVL() {
        return this.hsi;
    }

    public TextView bVM() {
        return this.hCE;
    }

    public i bVN() {
        return this.hCD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVO() {
        if (this.hCD == null) {
            String[] strArr = {this.hCn.getPageContext().getString(R.string.group_activity_eidt), this.hCn.getPageContext().getString(R.string.group_activity_delete)};
            this.hCD = new i(this.hCn.getPageContext());
            this.hCD.a(null, strArr, this.hCn);
        }
    }
}
