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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.Date;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.f {
    private static TextView t;
    private GroupActivityActivity a;
    private HeadImageView b;
    private NavigationBar c;
    private View d;
    private TextView e;
    private RelativeLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private TextView o;
    private ImageView p;
    private ImageView q;
    private Dialog r;
    private TextView s;
    private final Handler u;

    public s(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity);
        this.u = new u(null);
        this.a = groupActivityActivity;
        groupActivityActivity.setContentView(v.im_group_activity_activity);
        a(groupActivityActivity);
        b(groupActivityActivity);
    }

    private void a(GroupActivityActivity groupActivityActivity) {
        this.c = (NavigationBar) groupActivityActivity.findViewById(com.baidu.tieba.u.view_navigation_bar);
        this.c.a(groupActivityActivity.getResources().getString(x.group_activity));
        this.d = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.e = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(x.edit));
        this.e.setOnClickListener(new t(this, groupActivityActivity));
        this.e.setVisibility(8);
        this.s = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(x.delete));
        this.s.setOnClickListener(groupActivityActivity);
        this.s.setVisibility(8);
    }

    private void b(GroupActivityActivity groupActivityActivity) {
        this.f = (RelativeLayout) groupActivityActivity.findViewById(com.baidu.tieba.u.group_info_container);
        this.b = (HeadImageView) groupActivityActivity.findViewById(com.baidu.tieba.u.group_head_pic);
        this.b.setAutoChangeStyle(true);
        this.b.setIsRound(true);
        this.g = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.u.tv_group_activity_name);
        this.h = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.u.txt_group_author);
        this.i = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.u.txt_group_activity_content);
        this.j = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.u.txt_group_activity_time);
        this.k = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.u.txt_group_activity_place);
        this.l = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.u.lay_group_activity_content);
        this.m = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.u.lay_group_activity_place);
        this.n = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.u.lay_group_activity_time);
        this.o = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.u.txt_group_activity_end);
        this.q = (ImageView) groupActivityActivity.findViewById(com.baidu.tieba.u.img_activity_time);
        this.p = (ImageView) groupActivityActivity.findViewById(com.baidu.tieba.u.img_activity_place);
        t = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.u.tv_group_activity_del_tip);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.b.a(groupActivityData.getActivityPortrait(), 12, false);
            }
            this.g.setText(groupActivityData.getgActivityTitle());
            this.h.setText(String.valueOf(this.a.getResources().getString(x.group_activity_creator)) + "：" + groupActivityData.getUserName());
            if (com.baidu.tieba.im.c.c() != null && com.baidu.tieba.im.c.c().getID() != null && com.baidu.tieba.im.c.c().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.e.setVisibility(8);
                    this.s.setVisibility(0);
                    if (com.baidu.tieba.im.c.a().d() || z) {
                        t.setVisibility(8);
                    } else {
                        t.setVisibility(0);
                        com.baidu.tieba.im.c.a().a(true);
                        this.u.removeMessages(1);
                        this.u.sendMessageDelayed(this.u.obtainMessage(1), 3000L);
                    }
                } else {
                    this.e.setVisibility(0);
                    this.s.setVisibility(8);
                }
            } else {
                this.e.setVisibility(8);
                this.s.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.o.setVisibility(0);
                ay.c(this.q, com.baidu.tieba.t.icon_activity_time_n);
                ay.c(this.p, com.baidu.tieba.t.icon_activity_lbs_n);
                ay.a(this.j, com.baidu.tieba.r.group_activity_group_author, 1);
                ay.a(this.k, com.baidu.tieba.r.group_activity_group_author, 1);
            } else {
                this.o.setVisibility(8);
                ay.c(this.q, com.baidu.tieba.t.icon_activity_time_s);
                ay.c(this.p, com.baidu.tieba.t.icon_activity_lbs_s);
                ay.a(this.j, com.baidu.tieba.r.group_activity_main_text, 1);
                ay.a(this.k, com.baidu.tieba.r.group_activity_main_text, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                this.i.setText(groupActivityData.getgActivityContent());
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
                sb.append(ba.a(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.a.getResources().getString(x.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.a.getResources().getString(x.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.j.setText(sb.toString());
            } else {
                this.j.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.m.setVisibility(8);
                ay.f(this.n, com.baidu.tieba.t.bg_activity_down);
                return;
            }
            this.m.setVisibility(0);
            this.k.setText(groupActivityData.getgActivityArea());
            ay.f(this.n, com.baidu.tieba.t.bg_activity_middle);
        }
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.f);
        this.c.c(i);
    }

    public void a() {
        this.u.removeMessages(1);
    }

    public View b() {
        return this.d;
    }

    public TextView c() {
        return this.s;
    }

    public Dialog d() {
        return this.r;
    }

    public void f() {
        if (this.r == null) {
            CharSequence[] charSequenceArr = {this.a.getString(x.group_activity_eidt), this.a.getString(x.group_activity_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(this.a.getString(x.operation));
            builder.setItems(charSequenceArr, this.a);
            this.r = builder.create();
            this.r.setCanceledOnTouchOutside(true);
        }
    }
}
