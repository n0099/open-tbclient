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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.Date;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.base.c {
    private static TextView u;
    private GroupActivityActivity a;
    private HeadImageView b;
    private ab c;
    private NavigationBar d;
    private View e;
    private TextView f;
    private RelativeLayout g;
    private TextView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private TextView p;
    private ImageView q;
    private ImageView r;
    private Dialog s;
    private TextView t;
    private final Handler v;

    public s(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity);
        this.v = new v(null);
        this.a = groupActivityActivity;
        groupActivityActivity.setContentView(w.im_group_activity_activity);
        this.c = new ab(groupActivityActivity);
        a(groupActivityActivity);
        b(groupActivityActivity);
    }

    private void a(GroupActivityActivity groupActivityActivity) {
        this.d = (NavigationBar) groupActivityActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.d.a(groupActivityActivity.getResources().getString(y.group_activity));
        this.e = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.f = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(y.edit));
        this.f.setOnClickListener(new t(this, groupActivityActivity));
        this.f.setVisibility(8);
        this.t = this.d.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(y.delete));
        this.t.setOnClickListener(groupActivityActivity);
        this.t.setVisibility(8);
    }

    private void b(GroupActivityActivity groupActivityActivity) {
        this.g = (RelativeLayout) groupActivityActivity.findViewById(com.baidu.tieba.v.group_info_container);
        this.b = (HeadImageView) groupActivityActivity.findViewById(com.baidu.tieba.v.group_head_pic);
        this.b.setAutoChangeStyle(true);
        this.b.setIsRound(true);
        this.h = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.v.tv_group_activity_name);
        this.i = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.v.txt_group_author);
        this.j = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.v.txt_group_activity_content);
        this.k = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.v.txt_group_activity_time);
        this.l = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.v.txt_group_activity_place);
        this.m = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.v.lay_group_activity_content);
        this.n = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.v.lay_group_activity_place);
        this.o = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.v.lay_group_activity_time);
        this.p = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.v.txt_group_activity_end);
        this.r = (ImageView) groupActivityActivity.findViewById(com.baidu.tieba.v.img_activity_time);
        this.q = (ImageView) groupActivityActivity.findViewById(com.baidu.tieba.v.img_activity_place);
        u = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.v.tv_group_activity_del_tip);
    }

    public void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.c.c(groupActivityData.getActivityPortrait(), new u(this));
            }
            this.h.setText(groupActivityData.getgActivityTitle());
            this.i.setText(String.valueOf(this.a.getResources().getString(y.group_activity_creator)) + "：" + groupActivityData.getUserName());
            if (com.baidu.tieba.im.e.c() != null && com.baidu.tieba.im.e.c().getID() != null && com.baidu.tieba.im.e.c().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.f.setVisibility(8);
                    this.t.setVisibility(0);
                    if (com.baidu.tieba.im.e.a().d() || z) {
                        u.setVisibility(8);
                    } else {
                        u.setVisibility(0);
                        com.baidu.tieba.im.e.a().a(true);
                        this.v.removeMessages(1);
                        this.v.sendMessageDelayed(this.v.obtainMessage(1), 3000L);
                    }
                } else {
                    this.f.setVisibility(0);
                    this.t.setVisibility(8);
                }
            } else {
                this.f.setVisibility(8);
                this.t.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.p.setVisibility(0);
                be.c(this.r, com.baidu.tieba.u.icon_activity_time_n);
                be.c(this.q, com.baidu.tieba.u.icon_activity_lbs_n);
                be.a(this.k, com.baidu.tieba.s.group_activity_group_author, 1);
                be.a(this.l, com.baidu.tieba.s.group_activity_group_author, 1);
            } else {
                this.p.setVisibility(8);
                be.c(this.r, com.baidu.tieba.u.icon_activity_time_s);
                be.c(this.q, com.baidu.tieba.u.icon_activity_lbs_s);
                be.a(this.k, com.baidu.tieba.s.group_activity_main_text, 1);
                be.a(this.l, com.baidu.tieba.s.group_activity_main_text, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                this.j.setText(groupActivityData.getgActivityContent());
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
                sb.append(bg.a(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.a.getResources().getString(y.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.a.getResources().getString(y.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.k.setText(sb.toString());
            } else {
                this.k.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.n.setVisibility(8);
                be.f(this.o, com.baidu.tieba.u.bg_activity_down);
                return;
            }
            this.n.setVisibility(0);
            this.l.setText(groupActivityData.getgActivityArea());
            be.f(this.o, com.baidu.tieba.u.bg_activity_middle);
        }
    }

    public void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a((View) this.g);
        this.d.c(i);
    }

    public void a() {
        this.c.d();
        this.v.removeMessages(1);
    }

    public View b() {
        return this.e;
    }

    public TextView c() {
        return this.t;
    }

    public Dialog d() {
        return this.s;
    }

    public void f() {
        if (this.s == null) {
            CharSequence[] charSequenceArr = {this.a.getString(y.group_activity_eidt), this.a.getString(y.group_activity_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(this.a.getString(y.operation));
            builder.setItems(charSequenceArr, this.a);
            this.s = builder.create();
            this.s.setCanceledOnTouchOutside(true);
        }
    }
}
