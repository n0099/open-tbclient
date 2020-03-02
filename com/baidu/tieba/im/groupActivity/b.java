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
    private LinearLayout hCA;
    private LinearLayout hCB;
    private TextView hCC;
    private ImageView hCD;
    private ImageView hCE;
    private i hCF;
    private TextView hCG;
    private TextView hCH;
    private GroupActivityActivity hCp;
    private HeadImageView hCr;
    private TextView hCs;
    private LinearLayout hCt;
    private TextView hCu;
    private TextView hCv;
    private TextView hCw;
    private TextView hCx;
    private TextView hCy;
    private LinearLayout hCz;
    private View hsk;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public b(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity.getPageContext());
        this.hCp = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(final GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.hsk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.hCs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.edit));
        this.hCs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupActivity.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                b.this.bVQ();
                b.this.hCF.showDialog();
                TiebaStatic.eventStat(groupActivityActivity.getPageContext().getPageActivity(), "group_activity_edit", "groupclick", 1, new Object[0]);
            }
        });
        this.hCs.setVisibility(8);
        this.hCG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getPageContext().getString(R.string.delete));
        this.hCG.setOnClickListener(groupActivityActivity);
        this.hCG.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.mContainer = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.hCt = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_body);
        this.hCr = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.hCr.setAutoChangeStyle(true);
        this.hCr.setIsRound(false);
        this.hCu = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.hCv = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.hCw = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.hCx = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.hCy = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.hCz = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.hCA = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.hCB = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.hCC = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.hCE = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.hCD = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        this.hCH = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hCH.getLayoutParams();
            layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            this.hCH.setLayoutParams(layoutParams);
        }
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (this.hCt.getVisibility() != 0) {
                this.hCt.setVisibility(0);
            }
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.hCr.startLoad(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.hCu.setText(groupActivityData.getgActivityTitle());
            this.hCv.setText(this.hCp.getResources().getString(R.string.group_activity_creator) + "：" + groupActivityData.getNameShow());
            if (TbadkApplication.getCurrentAccountObj() != null && TbadkApplication.getCurrentAccountObj().getID() != null && TbadkApplication.getCurrentAccountObj().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.hCs.setVisibility(8);
                    this.hCG.setVisibility(0);
                    if (com.baidu.tieba.group.a.bML().bMM() || z) {
                        this.hCH.setVisibility(8);
                    } else {
                        this.hCH.setVisibility(0);
                        com.baidu.tieba.group.a.bML().mw(true);
                        e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.im.groupActivity.b.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.hCH != null) {
                                    b.this.hCH.setVisibility(8);
                                }
                            }
                        }, 3000L);
                    }
                } else {
                    this.hCs.setVisibility(0);
                    this.hCG.setVisibility(8);
                }
            } else {
                this.hCs.setVisibility(8);
                this.hCG.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.hCC.setVisibility(0);
                am.setImageResource(this.hCE, R.drawable.icon_activity_time_n);
                am.setImageResource(this.hCD, R.drawable.icon_activity_lbs_n);
                am.setViewTextColor(this.hCx, R.color.common_color_10106, 1);
                am.setViewTextColor(this.hCy, R.color.common_color_10106, 1);
            } else {
                this.hCC.setVisibility(8);
                am.setImageResource(this.hCE, R.drawable.icon_activity_time_s);
                am.setImageResource(this.hCD, R.drawable.icon_activity_lbs_s);
                am.setViewTextColor(this.hCx, R.color.common_color_10039, 1);
                am.setViewTextColor(this.hCy, R.color.common_color_10039, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.hCz.setVisibility(8);
            } else {
                this.hCz.setVisibility(0);
                this.hCw.setText(groupActivityData.getgActivityContent());
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
                    sb.append(this.hCp.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.hCp.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.hCx.setText(sb.toString());
            } else {
                this.hCx.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.hCA.setVisibility(8);
                am.setBackgroundResource(this.hCB, R.drawable.bg_activity_down);
                return;
            }
            this.hCA.setVisibility(0);
            this.hCy.setText(groupActivityData.getgActivityArea());
            am.setBackgroundResource(this.hCB, R.drawable.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.hCp.getLayoutMode().setNightMode(i == 1);
        this.hCp.getLayoutMode().onModeChanged(this.mContainer);
        this.mNavigationBar.onChangeSkinType(this.hCp.getPageContext(), i);
        this.hCs.setTextColor(am.getColor(R.color.cp_cont_f));
        this.hCG.setTextColor(am.getColor(R.color.cp_cont_f));
    }

    public void onDestory() {
        this.hCH = null;
    }

    public View bVN() {
        return this.hsk;
    }

    public TextView bVO() {
        return this.hCG;
    }

    public i bVP() {
        return this.hCF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVQ() {
        if (this.hCF == null) {
            String[] strArr = {this.hCp.getPageContext().getString(R.string.group_activity_eidt), this.hCp.getPageContext().getString(R.string.group_activity_delete)};
            this.hCF = new i(this.hCp.getPageContext());
            this.hCF.a(null, strArr, this.hCp);
        }
    }
}
