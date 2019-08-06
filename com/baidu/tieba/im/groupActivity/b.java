package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.g.e;
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
/* loaded from: classes5.dex */
public class b extends c<GroupActivityActivity> {
    private RelativeLayout cWk;
    private GroupActivityActivity gJH;
    private HeadImageView gJJ;
    private TextView gJK;
    private LinearLayout gJL;
    private TextView gJM;
    private TextView gJN;
    private TextView gJO;
    private TextView gJP;
    private TextView gJQ;
    private LinearLayout gJR;
    private LinearLayout gJS;
    private LinearLayout gJT;
    private TextView gJU;
    private ImageView gJV;
    private ImageView gJW;
    private i gJX;
    private TextView gJY;
    private TextView gJZ;
    private View gzz;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gJH = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gzz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gJK = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gJK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bEu();
                b.this.gJX.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gJK.setVisibility(8);
        this.gJY = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gJY.setOnClickListener(groupActivityActivity);
        this.gJY.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.cWk = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gJL = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gJJ = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gJJ.setAutoChangeStyle(true);
        this.gJJ.setIsRound(false);
        this.gJM = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gJN = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gJO = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gJP = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gJQ = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gJR = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gJS = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gJT = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gJU = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gJW = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gJV = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gJZ = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJZ.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gJZ.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gJL.getVisibility() != 0) {
                this.gJL.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gJJ.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gJM.setText(groupActivityData.getgActivityTitle());
            this.gJN.setText(this.gJH.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gJK.setVisibility(8);
                    this.gJY.setVisibility(0);
                    if (com.baidu.tieba.group.a.buP().buQ() || z) {
                        this.gJZ.setVisibility(8);
                    } else {
                        this.gJZ.setVisibility(0);
                        com.baidu.tieba.group.a.buP().le(true);
                        e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gJZ != null) {
                                    b.this.gJZ.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gJK.setVisibility(0);
                    this.gJY.setVisibility(8);
                }
            } else {
                this.gJK.setVisibility(8);
                this.gJY.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gJU.setVisibility(0);
                am.c(this.gJW, (int) R.drawable.icon_activity_time_n);
                am.c(this.gJV, (int) R.drawable.icon_activity_lbs_n);
                am.f(this.gJP, R.color.common_color_10106, 1);
                am.f(this.gJQ, R.color.common_color_10106, 1);
            } else {
                this.gJU.setVisibility(8);
                am.c(this.gJW, (int) R.drawable.icon_activity_time_s);
                am.c(this.gJV, (int) R.drawable.icon_activity_lbs_s);
                am.f(this.gJP, R.color.common_color_10039, 1);
                am.f(this.gJQ, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gJR.setVisibility(8);
            } else {
                this.gJR.setVisibility(0);
                this.gJO.setText(groupActivityData.getgActivityContent());
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
                sb.append(" ");
                sb.append(aq.q(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.gJH.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gJH.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gJP.setText(sb.toString());
            } else {
                this.gJP.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gJS.setVisibility(8);
                am.k(this.gJT, R.drawable.bg_activity_down);
                return;
            }
            this.gJS.setVisibility(0);
            this.gJQ.setText(groupActivityData.getgActivityArea());
            am.k(this.gJT, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gJH.getLayoutMode().setNightMode(i == 1);
        this.gJH.getLayoutMode().onModeChanged(this.cWk);
        this.mNavigationBar.onChangeSkinType(this.gJH.getPageContext(), i);
        this.gJK.setTextColor(am.getColor(R.color.cp_cont_f));
        this.gJY.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gJZ = null;
    }

    public View bEr() {
        return this.gzz;
    }

    public TextView bEs() {
        return this.gJY;
    }

    public i bEt() {
        return this.gJX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEu() {
        if (this.gJX == null) {
            String[] strArr = {this.gJH.getPageContext().getString(R.string.group_activity_eidt), this.gJH.getPageContext().getString(R.string.group_activity_delete)};
            this.gJX = new i(this.gJH.getPageContext());
            this.gJX.a(null, strArr, this.gJH);
        }
    }
}
