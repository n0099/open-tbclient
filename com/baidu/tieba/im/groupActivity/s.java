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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.editortool.aa;
import com.baidu.tieba.im.data.GroupActivityData;
import java.util.Date;
/* loaded from: classes.dex */
public final class s extends com.baidu.adp.a.f {
    private static TextView v;
    private GroupActivityActivity a;
    private HeadImageView c;
    private aa d;
    private NavigationBar e;
    private View f;
    private TextView g;
    private RelativeLayout h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private TextView q;
    private ImageView r;
    private ImageView s;
    private Dialog t;
    private TextView u;
    private final Handler w;

    public s(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity);
        this.w = new v((byte) 0);
        this.a = groupActivityActivity;
        groupActivityActivity.setContentView(com.baidu.tieba.im.i.im_group_activity_activity);
        this.d = new aa(groupActivityActivity);
        this.e = (NavigationBar) groupActivityActivity.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.e.a(groupActivityActivity.getResources().getString(com.baidu.tieba.im.j.group_activity));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.g = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(com.baidu.tieba.im.j.edit));
        this.g.setOnClickListener(new t(this, groupActivityActivity));
        this.g.setVisibility(8);
        this.u = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(com.baidu.tieba.im.j.delete));
        this.u.setOnClickListener(groupActivityActivity);
        this.u.setVisibility(8);
        this.h = (RelativeLayout) groupActivityActivity.findViewById(com.baidu.tieba.im.h.group_info_container);
        this.c = (HeadImageView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.group_head_pic);
        this.c.setAutoChangeStyle(true);
        this.c.setIsRound(true);
        this.i = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.tv_group_activity_name);
        this.j = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.txt_group_author);
        this.k = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.txt_group_activity_content);
        this.l = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.txt_group_activity_time);
        this.m = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.txt_group_activity_place);
        this.n = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.im.h.lay_group_activity_content);
        this.o = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.im.h.lay_group_activity_place);
        this.p = (LinearLayout) groupActivityActivity.findViewById(com.baidu.tieba.im.h.lay_group_activity_time);
        this.q = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.txt_group_activity_end);
        this.s = (ImageView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.img_activity_time);
        this.r = (ImageView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.img_activity_place);
        v = (TextView) groupActivityActivity.findViewById(com.baidu.tieba.im.h.tv_group_activity_del_tip);
    }

    public final void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.d.c(groupActivityData.getActivityPortrait(), new u(this));
            }
            this.i.setText(groupActivityData.getgActivityTitle());
            this.j.setText(String.valueOf(this.a.getResources().getString(com.baidu.tieba.im.j.group_activity_creator)) + "：" + groupActivityData.getUserName());
            if (com.baidu.tieba.im.p.d() != null && com.baidu.tieba.im.p.d().getID() != null && com.baidu.tieba.im.p.d().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.g.setVisibility(8);
                    this.u.setVisibility(0);
                    if (com.baidu.tieba.im.p.a().e() || z) {
                        v.setVisibility(8);
                    } else {
                        v.setVisibility(0);
                        com.baidu.tieba.im.p.a().a(true);
                        this.w.removeMessages(1);
                        this.w.sendMessageDelayed(this.w.obtainMessage(1), 3000L);
                    }
                } else {
                    this.g.setVisibility(0);
                    this.u.setVisibility(8);
                }
            } else {
                this.g.setVisibility(8);
                this.u.setVisibility(8);
            }
            if (groupActivityData.getIsEnd() == 1) {
                this.q.setVisibility(0);
                ba.c(this.s, com.baidu.tieba.im.g.icon_activity_time_n);
                ba.c(this.r, com.baidu.tieba.im.g.icon_activity_lbs_n);
                ba.a(this.l, com.baidu.tieba.im.e.group_activity_group_author, 1);
                ba.a(this.m, com.baidu.tieba.im.e.group_activity_group_author, 1);
            } else {
                this.q.setVisibility(8);
                ba.c(this.s, com.baidu.tieba.im.g.icon_activity_time_s);
                ba.c(this.r, com.baidu.tieba.im.g.icon_activity_lbs_s);
                ba.a(this.l, com.baidu.tieba.im.e.group_activity_main_text, 1);
                ba.a(this.m, com.baidu.tieba.im.e.group_activity_main_text, 1);
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityContent())) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.k.setText(groupActivityData.getgActivityContent());
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
                sb.append(bc.a(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.a.getResources().getString(com.baidu.tieba.im.j.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.a.getResources().getString(com.baidu.tieba.im.j.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append("0");
                    }
                    sb.append(minutes);
                }
                this.l.setText(sb.toString());
            } else {
                this.l.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.o.setVisibility(8);
                ba.f(this.p, com.baidu.tieba.im.g.bg_activity_down);
                return;
            }
            this.o.setVisibility(0);
            this.m.setText(groupActivityData.getgActivityArea());
            ba.f(this.p, com.baidu.tieba.im.g.bg_activity_middle);
        }
    }

    public final void a(int i) {
        this.a.getLayoutMode().a(i == 1);
        this.a.getLayoutMode().a(this.h);
        this.e.b(i);
    }

    public final void a() {
        this.d.c();
        this.w.removeMessages(1);
    }

    public final View d() {
        return this.f;
    }

    public final TextView e() {
        return this.u;
    }

    public final Dialog f() {
        return this.t;
    }

    public static /* synthetic */ void a(s sVar) {
        if (sVar.t == null) {
            CharSequence[] charSequenceArr = {sVar.a.getString(com.baidu.tieba.im.j.group_activity_eidt), sVar.a.getString(com.baidu.tieba.im.j.group_activity_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(sVar.a);
            builder.setTitle(sVar.a.getString(com.baidu.tieba.im.j.operation));
            builder.setItems(charSequenceArr, sVar.a);
            sVar.t = builder.create();
            sVar.t.setCanceledOnTouchOutside(true);
        }
    }
}
