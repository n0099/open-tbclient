package com.baidu.tieba.im.groupActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.c;
import com.baidu.adp.lib.g.e;
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
/* loaded from: classes5.dex */
public class b extends c<GroupActivityActivity> {
    private HeadImageView gJA;
    private TextView gJB;
    private LinearLayout gJC;
    private TextView gJD;
    private TextView gJE;
    private TextView gJF;
    private TextView gJG;
    private TextView gJH;
    private LinearLayout gJI;
    private LinearLayout gJJ;
    private LinearLayout gJK;
    private TextView gJL;
    private ImageView gJM;
    private ImageView gJN;
    private i gJO;
    private TextView gJP;
    private TextView gJQ;
    private GroupActivityActivity gJy;
    private View gzp;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.gJy = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.gzp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.gJB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.gJB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bBT();
                b.this.gJO.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.gJB.setVisibility(8);
        this.gJP = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.gJP.setOnClickListener(groupActivityActivity);
        this.gJP.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.gJC = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.gJA = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.gJA.setAutoChangeStyle(true);
        this.gJA.setIsRound(false);
        this.gJD = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.gJE = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.gJF = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.gJG = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.gJH = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.gJI = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.gJJ = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.gJK = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.gJL = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.gJN = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.gJM = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.gJQ = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gJQ.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.gJQ.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.gJC.getVisibility() != 0) {
                this.gJC.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.gJA.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.gJD.setText(groupActivityData.getgActivityTitle());
            this.gJE.setText(this.gJy.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.gJB.setVisibility(8);
                    this.gJP.setVisibility(0);
                    if (com.baidu.tieba.group.a.bsI().bsJ() || z) {
                        this.gJQ.setVisibility(8);
                    } else {
                        this.gJQ.setVisibility(0);
                        com.baidu.tieba.group.a.bsI().kV(true);
                        e.fZ().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.gJQ != null) {
                                    b.this.gJQ.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.gJB.setVisibility(0);
                    this.gJP.setVisibility(8);
                }
            } else {
                this.gJB.setVisibility(8);
                this.gJP.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.gJL.setVisibility(0);
                am.setImageResource(this.gJN, R.drawable.icon_activity_time_n);
                am.setImageResource(this.gJM, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.gJG, R.color.common_color_10106, 1);
                am.setViewTextColor(this.gJH, R.color.common_color_10106, 1);
            } else {
                this.gJL.setVisibility(8);
                am.setImageResource(this.gJN, R.drawable.icon_activity_time_s);
                am.setImageResource(this.gJM, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.gJG, R.color.common_color_10039, 1);
                am.setViewTextColor(this.gJH, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.gJI.setVisibility(8);
            } else {
                this.gJI.setVisibility(0);
                this.gJF.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.gJy.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.gJy.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.gJG.setText(sb.toString());
            } else {
                this.gJG.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.gJJ.setVisibility(8);
                am.setBackgroundResource(this.gJK, R.drawable.bg_activity_down);
                return;
            }
            this.gJJ.setVisibility(0);
            this.gJH.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.gJK, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.gJy.getLayoutMode().setNightMode(i == 1);
        this.gJy.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.gJy.getPageContext(), i);
        this.gJB.setTextColor(am.getColor(R.color.cp_cont_f));
        this.gJP.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.gJQ = null;
    }

    public View bBQ() {
        return this.gzp;
    }

    public TextView bBR() {
        return this.gJP;
    }

    public i bBS() {
        return this.gJO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBT() {
        if (this.gJO == null) {
            String[] strArr = {this.gJy.getPageContext().getString(R.string.group_activity_eidt), this.gJy.getPageContext().getString(R.string.group_activity_delete)};
            this.gJO = new i(this.gJy.getPageContext());
            this.gJO.a(null, strArr, this.gJy);
        }
    }
}
