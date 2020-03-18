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
    private GroupActivityActivity hEb;
    private HeadImageView hEd;
    private TextView hEe;
    private LinearLayout hEf;
    private TextView hEg;
    private TextView hEh;
    private TextView hEi;
    private TextView hEj;
    private TextView hEk;
    private LinearLayout hEl;
    private LinearLayout hEm;
    private LinearLayout hEn;
    private TextView hEo;
    private ImageView hEp;
    private ImageView hEq;
    private i hEr;
    private TextView hEs;
    private TextView hEt;
    private View htW;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hEb = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.htW = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.hEe = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.hEe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bWj();
                b.this.hEr.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.hEe.setVisibility(8);
        this.hEs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.hEs.setOnClickListener(groupActivityActivity);
        this.hEs.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.hEf = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.hEd = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.hEd.setAutoChangeStyle(true);
        this.hEd.setIsRound(false);
        this.hEg = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.hEh = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.hEi = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.hEj = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.hEk = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.hEl = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.hEm = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.hEn = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.hEo = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.hEq = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.hEp = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.hEt = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hEt.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.hEt.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.hEf.getVisibility() != 0) {
                this.hEf.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.hEd.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.hEg.setText(groupActivityData.getgActivityTitle());
            this.hEh.setText(this.hEb.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.hEe.setVisibility(8);
                    this.hEs.setVisibility(0);
                    if (com.baidu.tieba.group.a.bNa().bNb() || z) {
                        this.hEt.setVisibility(8);
                    } else {
                        this.hEt.setVisibility(0);
                        com.baidu.tieba.group.a.bNa().mC(true);
                        e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.hEt != null) {
                                    b.this.hEt.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.hEe.setVisibility(0);
                    this.hEs.setVisibility(8);
                }
            } else {
                this.hEe.setVisibility(8);
                this.hEs.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.hEo.setVisibility(0);
                am.setImageResource(this.hEq, R.drawable.icon_activity_time_n);
                am.setImageResource(this.hEp, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.hEj, R.color.common_color_10106, 1);
                am.setViewTextColor(this.hEk, R.color.common_color_10106, 1);
            } else {
                this.hEo.setVisibility(8);
                am.setImageResource(this.hEq, R.drawable.icon_activity_time_s);
                am.setImageResource(this.hEp, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.hEj, R.color.common_color_10039, 1);
                am.setViewTextColor(this.hEk, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.hEl.setVisibility(8);
            } else {
                this.hEl.setVisibility(0);
                this.hEi.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.hEb.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.hEb.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.hEj.setText(sb.toString());
            } else {
                this.hEj.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.hEm.setVisibility(8);
                am.setBackgroundResource(this.hEn, R.drawable.bg_activity_down);
                return;
            }
            this.hEm.setVisibility(0);
            this.hEk.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.hEn, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.hEb.getLayoutMode().setNightMode(i == 1);
        this.hEb.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.hEb.getPageContext(), i);
        this.hEe.setTextColor(am.getColor(R.color.cp_cont_f));
        this.hEs.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.hEt = null;
    }

    public View bWg() {
        return this.htW;
    }

    public TextView bWh() {
        return this.hEs;
    }

    public i bWi() {
        return this.hEr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWj() {
        if (this.hEr == null) {
            String[] strArr = {this.hEb.getPageContext().getString(R.string.group_activity_eidt), this.hEb.getPageContext().getString(R.string.group_activity_delete)};
            this.hEr = new i(this.hEb.getPageContext());
            this.hEr.a(null, strArr, this.hEb);
        }
    }
}
