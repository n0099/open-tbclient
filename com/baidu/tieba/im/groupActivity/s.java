package com.baidu.tieba.im.groupActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f {
    private static TextView aZJ;
    private RelativeLayout KP;
    private View aOT;
    private TextView aZA;
    private LinearLayout aZB;
    private LinearLayout aZC;
    private LinearLayout aZD;
    private TextView aZE;
    private ImageView aZF;
    private ImageView aZG;
    private Dialog aZH;
    private TextView aZI;
    private GroupActivityActivity aZt;
    private HeadImageView aZu;
    private TextView aZv;
    private TextView aZw;
    private TextView aZx;
    private TextView aZy;
    private TextView aZz;
    private final Handler mHandler;
    private NavigationBar mNavigationBar;

    public s(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity);
        this.mHandler = new u(null);
        this.aZt = groupActivityActivity;
        groupActivityActivity.setContentView(w.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(y.group_activity));
        this.aOT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.aZv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(y.edit));
        this.aZv.setOnClickListener(new t(this, groupActivityActivity));
        this.aZv.setVisibility(8);
        this.aZI = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(y.delete));
        this.aZI.setOnClickListener(groupActivityActivity);
        this.aZI.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.KP = (RelativeLayout) groupActivityActivity.findViewById(v.group_info_container);
        this.aZu = (HeadImageView) groupActivityActivity.findViewById(v.group_head_pic);
        this.aZu.setAutoChangeStyle(true);
        this.aZu.setIsRound(false);
        this.aZw = (TextView) groupActivityActivity.findViewById(v.tv_group_activity_name);
        this.aZx = (TextView) groupActivityActivity.findViewById(v.txt_group_author);
        this.aZy = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_content);
        this.aZz = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_time);
        this.aZA = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_place);
        this.aZB = (LinearLayout) groupActivityActivity.findViewById(v.lay_group_activity_content);
        this.aZC = (LinearLayout) groupActivityActivity.findViewById(v.lay_group_activity_place);
        this.aZD = (LinearLayout) groupActivityActivity.findViewById(v.lay_group_activity_time);
        this.aZE = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_end);
        this.aZG = (ImageView) groupActivityActivity.findViewById(v.img_activity_time);
        this.aZF = (ImageView) groupActivityActivity.findViewById(v.img_activity_place);
        aZJ = (TextView) groupActivityActivity.findViewById(v.tv_group_activity_del_tip);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.aZu.c(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.aZw.setText(groupActivityData.getgActivityTitle());
            this.aZx.setText(String.valueOf(this.aZt.getResources().getString(y.group_activity_creator)) + "：" + groupActivityData.getUserName());
            if (com.baidu.tieba.im.c.Jk() != null && com.baidu.tieba.im.c.Jk().getID() != null && com.baidu.tieba.im.c.Jk().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.aZv.setVisibility(8);
                    this.aZI.setVisibility(0);
                    if (com.baidu.tieba.im.c.Ji().Jl() || z) {
                        aZJ.setVisibility(8);
                    } else {
                        aZJ.setVisibility(0);
                        com.baidu.tieba.im.c.Ji().cw(true);
                        this.mHandler.removeMessages(1);
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
                    }
                } else {
                    this.aZv.setVisibility(0);
                    this.aZI.setVisibility(8);
                }
            } else {
                this.aZv.setVisibility(8);
                this.aZI.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.aZE.setVisibility(0);
                aw.c(this.aZG, com.baidu.tieba.u.icon_activity_time_n);
                aw.c(this.aZF, com.baidu.tieba.u.icon_activity_lbs_n);
                aw.b(this.aZz, com.baidu.tieba.s.group_activity_group_author, 1);
                aw.b(this.aZA, com.baidu.tieba.s.group_activity_group_author, 1);
            } else {
                this.aZE.setVisibility(8);
                aw.c(this.aZG, com.baidu.tieba.u.icon_activity_time_s);
                aw.c(this.aZF, com.baidu.tieba.u.icon_activity_lbs_s);
                aw.b(this.aZz, com.baidu.tieba.s.group_activity_main_text, 1);
                aw.b(this.aZA, com.baidu.tieba.s.group_activity_main_text, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.aZB.setVisibility(8);
            } else {
                this.aZB.setVisibility(0);
                this.aZy.setText(groupActivityData.getgActivityContent());
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
                sb.append("-");
                sb.append(month + 1);
                sb.append("-");
                sb.append(date2);
                sb.append(" ");
                sb.append(az.l(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.aZt.getResources().getString(y.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.aZt.getResources().getString(y.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.aZz.setText(sb.toString());
            } else {
                this.aZz.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.aZC.setVisibility(8);
                aw.h(this.aZD, com.baidu.tieba.u.bg_activity_down);
                return;
            }
            this.aZC.setVisibility(0);
            this.aZA.setText(groupActivityData.getgActivityArea());
            aw.h(this.aZD, com.baidu.tieba.u.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.aZt.getLayoutMode().L(i == 1);
        this.aZt.getLayoutMode().h(this.KP);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public void onDestory() {
        this.mHandler.removeMessages(1);
    }

    public View On() {
        return this.aOT;
    }

    public TextView Oo() {
        return this.aZI;
    }

    public Dialog Op() {
        return this.aZH;
    }

    public void Oq() {
        if (this.aZH == null) {
            CharSequence[] charSequenceArr = {this.aZt.getString(y.group_activity_eidt), this.aZt.getString(y.group_activity_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aZt);
            builder.setTitle(this.aZt.getString(y.operation));
            builder.setItems(charSequenceArr, this.aZt);
            this.aZH = builder.create();
            this.aZH.setCanceledOnTouchOutside(true);
        }
    }
}
