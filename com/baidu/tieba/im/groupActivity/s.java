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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f {
    private static TextView aZw;
    private RelativeLayout KO;
    private View aOF;
    private GroupActivityActivity aZg;
    private HeadImageView aZh;
    private TextView aZi;
    private TextView aZj;
    private TextView aZk;
    private TextView aZl;
    private TextView aZm;
    private TextView aZn;
    private LinearLayout aZo;
    private LinearLayout aZp;
    private LinearLayout aZq;
    private TextView aZr;
    private ImageView aZs;
    private ImageView aZt;
    private Dialog aZu;
    private TextView aZv;
    private final Handler mHandler;
    private NavigationBar mNavigationBar;

    public s(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity);
        this.mHandler = new u(null);
        this.aZg = groupActivityActivity;
        groupActivityActivity.setContentView(w.im_group_activity_activity);
        c(groupActivityActivity);
        d(groupActivityActivity);
    }

    private void c(GroupActivityActivity groupActivityActivity) {
        this.mNavigationBar = (NavigationBar) groupActivityActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(groupActivityActivity.getResources().getString(y.group_activity));
        this.aOF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.aZi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(y.edit));
        this.aZi.setOnClickListener(new t(this, groupActivityActivity));
        this.aZi.setVisibility(8);
        this.aZv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(y.delete));
        this.aZv.setOnClickListener(groupActivityActivity);
        this.aZv.setVisibility(8);
    }

    private void d(GroupActivityActivity groupActivityActivity) {
        this.KO = (RelativeLayout) groupActivityActivity.findViewById(v.group_info_container);
        this.aZh = (HeadImageView) groupActivityActivity.findViewById(v.group_head_pic);
        this.aZh.setAutoChangeStyle(true);
        this.aZh.setIsRound(false);
        this.aZj = (TextView) groupActivityActivity.findViewById(v.tv_group_activity_name);
        this.aZk = (TextView) groupActivityActivity.findViewById(v.txt_group_author);
        this.aZl = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_content);
        this.aZm = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_time);
        this.aZn = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_place);
        this.aZo = (LinearLayout) groupActivityActivity.findViewById(v.lay_group_activity_content);
        this.aZp = (LinearLayout) groupActivityActivity.findViewById(v.lay_group_activity_place);
        this.aZq = (LinearLayout) groupActivityActivity.findViewById(v.lay_group_activity_time);
        this.aZr = (TextView) groupActivityActivity.findViewById(v.txt_group_activity_end);
        this.aZt = (ImageView) groupActivityActivity.findViewById(v.img_activity_time);
        this.aZs = (ImageView) groupActivityActivity.findViewById(v.img_activity_place);
        aZw = (TextView) groupActivityActivity.findViewById(v.tv_group_activity_del_tip);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.aZh.c(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.aZj.setText(groupActivityData.getgActivityTitle());
            this.aZk.setText(String.valueOf(this.aZg.getResources().getString(y.group_activity_creator)) + "：" + groupActivityData.getUserName());
            if (com.baidu.tieba.im.c.Jg() != null && com.baidu.tieba.im.c.Jg().getID() != null && com.baidu.tieba.im.c.Jg().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.aZi.setVisibility(8);
                    this.aZv.setVisibility(0);
                    if (com.baidu.tieba.im.c.Je().Jh() || z) {
                        aZw.setVisibility(8);
                    } else {
                        aZw.setVisibility(0);
                        com.baidu.tieba.im.c.Je().cw(true);
                        this.mHandler.removeMessages(1);
                        this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(1), 3000L);
                    }
                } else {
                    this.aZi.setVisibility(0);
                    this.aZv.setVisibility(8);
                }
            } else {
                this.aZi.setVisibility(8);
                this.aZv.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.aZr.setVisibility(0);
                aw.c(this.aZt, com.baidu.tieba.u.icon_activity_time_n);
                aw.c(this.aZs, com.baidu.tieba.u.icon_activity_lbs_n);
                aw.b(this.aZm, com.baidu.tieba.s.group_activity_group_author, 1);
                aw.b(this.aZn, com.baidu.tieba.s.group_activity_group_author, 1);
            } else {
                this.aZr.setVisibility(8);
                aw.c(this.aZt, com.baidu.tieba.u.icon_activity_time_s);
                aw.c(this.aZs, com.baidu.tieba.u.icon_activity_lbs_s);
                aw.b(this.aZm, com.baidu.tieba.s.group_activity_main_text, 1);
                aw.b(this.aZn, com.baidu.tieba.s.group_activity_main_text, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.aZo.setVisibility(8);
            } else {
                this.aZo.setVisibility(0);
                this.aZl.setText(groupActivityData.getgActivityContent());
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
                sb.append(ay.l(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.aZg.getResources().getString(y.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.aZg.getResources().getString(y.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.aZm.setText(sb.toString());
            } else {
                this.aZm.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.aZp.setVisibility(8);
                aw.h(this.aZq, com.baidu.tieba.u.bg_activity_down);
                return;
            }
            this.aZp.setVisibility(0);
            this.aZn.setText(groupActivityData.getgActivityArea());
            aw.h(this.aZq, com.baidu.tieba.u.bg_activity_middle);
        }
    }

    public void changeSkinType(int i) {
        this.aZg.getLayoutMode().L(i == 1);
        this.aZg.getLayoutMode().h(this.KO);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public void onDestory() {
        this.mHandler.removeMessages(1);
    }

    public View Ok() {
        return this.aOF;
    }

    public TextView Ol() {
        return this.aZv;
    }

    public Dialog Om() {
        return this.aZu;
    }

    public void On() {
        if (this.aZu == null) {
            CharSequence[] charSequenceArr = {this.aZg.getString(y.group_activity_eidt), this.aZg.getString(y.group_activity_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.aZg);
            builder.setTitle(this.aZg.getString(y.operation));
            builder.setItems(charSequenceArr, this.aZg);
            this.aZu = builder.create();
            this.aZu.setCanceledOnTouchOutside(true);
        }
    }
}
