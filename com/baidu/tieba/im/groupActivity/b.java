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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupActivityData;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
/* loaded from: classes10.dex */
public class b extends c<GroupActivityActivity> {
    private View iKr;
    private TextView iUA;
    private TextView iUB;
    private TextView iUC;
    private TextView iUD;
    private LinearLayout iUE;
    private LinearLayout iUF;
    private LinearLayout iUG;
    private TextView iUH;
    private ImageView iUI;
    private ImageView iUJ;
    private i iUK;
    private TextView iUL;
    private TextView iUM;
    private GroupActivityActivity iUu;
    private HeadImageView iUw;
    private TextView iUx;
    private LinearLayout iUy;
    private TextView iUz;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.iUu = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.iKr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.iUx = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.iUx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.cre();
                b.this.iUK.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.iUx.setVisibility(8);
        this.iUL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.iUL.setOnClickListener(groupActivityActivity);
        this.iUL.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.iUy = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.iUw = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.iUw.setAutoChangeStyle(true);
        this.iUw.setIsRound(false);
        this.iUz = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.iUA = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.iUB = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.iUC = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.iUD = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.iUE = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.iUF = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.iUG = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.iUH = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.iUJ = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.iUI = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.iUM = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iUM.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.iUM.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.iUy.getVisibility() != 0) {
                this.iUy.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.iUw.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.iUz.setText(groupActivityData.getgActivityTitle());
            this.iUA.setText(this.iUu.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.iUx.setVisibility(8);
                    this.iUL.setVisibility(0);
                    if (com.baidu.tieba.group.a.chD().chE() || z) {
                        this.iUM.setVisibility(8);
                    } else {
                        this.iUM.setVisibility(0);
                        com.baidu.tieba.group.a.chD().on(true);
                        e.lt().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.iUM != null) {
                                    b.this.iUM.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.iUx.setVisibility(0);
                    this.iUL.setVisibility(8);
                }
            } else {
                this.iUx.setVisibility(8);
                this.iUL.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.iUH.setVisibility(0);
                an.setImageResource(this.iUJ, R.drawable.icon_activity_time_n);
                an.setImageResource(this.iUI, R.drawable.icon_activity_lbs_n);
                an.setViewTextColor(this.iUC, R.color.common_color_10106, 1);
                an.setViewTextColor(this.iUD, R.color.common_color_10106, 1);
            } else {
                this.iUH.setVisibility(8);
                an.setImageResource(this.iUJ, R.drawable.icon_activity_time_s);
                an.setImageResource(this.iUI, R.drawable.icon_activity_lbs_s);
                an.setViewTextColor(this.iUC, R.color.common_color_10039, 1);
                an.setViewTextColor(this.iUD, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.iUE.setVisibility(8);
            } else {
                this.iUE.setVisibility(0);
                this.iUB.setText(groupActivityData.getgActivityContent());
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
                sb.append(ar.getWeekString(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.iUu.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.iUu.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.iUC.setText(sb.toString());
            } else {
                this.iUC.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.iUF.setVisibility(8);
                an.setBackgroundResource(this.iUG, R.drawable.bg_activity_down);
                return;
            }
            this.iUF.setVisibility(0);
            this.iUD.setText(groupActivityData.getgActivityArea());
            an.setBackgroundResource(this.iUG, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.iUu.getLayoutMode().setNightMode(i == 1);
        this.iUu.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.iUu.getPageContext(), i);
        this.iUx.setTextColor(an.getColor(R.color.cp_cont_f));
        this.iUL.setTextColor(an.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.iUM = null;
    }

    public View crb() {
        return this.iKr;
    }

    public TextView crc() {
        return this.iUL;
    }

    public i crd() {
        return this.iUK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cre() {
        if (this.iUK == null) {
            String[] strArr = {this.iUu.getPageContext().getString(R.string.group_activity_eidt), this.iUu.getPageContext().getString(R.string.group_activity_delete)};
            this.iUK = new i(this.iUu.getPageContext());
            this.iUK.a(null, strArr, this.iUu);
        }
    }
}
