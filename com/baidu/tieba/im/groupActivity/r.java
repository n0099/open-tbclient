package com.baidu.tieba.im.groupActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.Date;
/* loaded from: classes.dex */
public final class r extends com.baidu.adp.a.e {
    private static TextView v;
    private GroupActivityActivity a;
    private HeadImageView c;
    private com.baidu.tieba.util.i d;
    private NavigationBar e;
    private ImageView f;
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

    public r(GroupActivityActivity groupActivityActivity) {
        super(groupActivityActivity);
        this.w = new u((byte) 0);
        this.a = groupActivityActivity;
        groupActivityActivity.setContentView(R.layout.im_group_activity_activity);
        this.d = new com.baidu.tieba.util.i(groupActivityActivity);
        this.e = (NavigationBar) groupActivityActivity.findViewById(R.id.view_navigation_bar);
        this.e.a(groupActivityActivity.getResources().getString(R.string.group_activity));
        this.f = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, groupActivityActivity);
        this.g = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(R.string.edit));
        this.g.setOnClickListener(new s(this, groupActivityActivity));
        this.g.setVisibility(8);
        this.u = this.e.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupActivityActivity.getString(R.string.delete));
        this.u.setOnClickListener(groupActivityActivity);
        this.u.setVisibility(8);
        this.h = (RelativeLayout) groupActivityActivity.findViewById(R.id.group_info_container);
        this.c = (HeadImageView) groupActivityActivity.findViewById(R.id.group_head_pic);
        this.c.setAutoChangeStyle(true);
        this.c.setIsRound(true);
        this.i = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_name);
        this.j = (TextView) groupActivityActivity.findViewById(R.id.txt_group_author);
        this.k = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_content);
        this.l = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_time);
        this.m = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_place);
        this.n = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_content);
        this.o = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_place);
        this.p = (LinearLayout) groupActivityActivity.findViewById(R.id.lay_group_activity_time);
        this.q = (TextView) groupActivityActivity.findViewById(R.id.txt_group_activity_end);
        this.s = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_time);
        this.r = (ImageView) groupActivityActivity.findViewById(R.id.img_activity_place);
        v = (TextView) groupActivityActivity.findViewById(R.id.tv_group_activity_del_tip);
    }

    public final void a(GroupActivityData groupActivityData, boolean z) {
        if (groupActivityData != null) {
            if (!TextUtils.isEmpty(groupActivityData.getActivityPortrait())) {
                this.d.c(groupActivityData.getActivityPortrait(), new t(this));
            }
            this.i.setText(groupActivityData.getgActivityTitle());
            this.j.setText(String.valueOf(this.a.getResources().getString(R.string.group_activity_creator)) + "：" + groupActivityData.getUserName());
            if (com.baidu.tieba.im.e.d() != null && com.baidu.tieba.im.e.d().getID() != null && com.baidu.tieba.im.e.d().getID().equals(String.valueOf(groupActivityData.getUserId()))) {
                if (groupActivityData.getIsEnd() == 1) {
                    this.g.setVisibility(8);
                    this.u.setVisibility(0);
                    if (TiebaApplication.g().ad() || z) {
                        v.setVisibility(8);
                    } else {
                        v.setVisibility(0);
                        TiebaApplication.g().s(true);
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
                bq.d(this.s, (int) R.drawable.icon_activity_time_n);
                bq.d(this.r, (int) R.drawable.icon_activity_lbs_n);
                bq.a(this.l, R.color.group_activity_group_author, 1);
                bq.a(this.m, R.color.group_activity_group_author, 1);
            } else {
                this.q.setVisibility(8);
                bq.d(this.s, (int) R.drawable.icon_activity_time_s);
                bq.d(this.r, (int) R.drawable.icon_activity_lbs_s);
                bq.a(this.l, R.color.group_activity_main_text, 1);
                bq.a(this.m, R.color.group_activity_main_text, 1);
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
                sb.append(bs.a(year, month, date2));
                sb.append(" ");
                if (hours > 12) {
                    sb.append(this.a.getResources().getString(R.string.afternoon));
                    sb.append(hours - 12);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append(SocialConstants.FALSE);
                    }
                    sb.append(minutes);
                } else {
                    sb.append(this.a.getResources().getString(R.string.morning));
                    sb.append(hours);
                    sb.append(":");
                    if (minutes < 10) {
                        sb.append(SocialConstants.FALSE);
                    }
                    sb.append(minutes);
                }
                this.l.setText(sb.toString());
            } else {
                this.l.setText("");
            }
            if (TextUtils.isEmpty(groupActivityData.getgActivityArea())) {
                this.o.setVisibility(8);
                bq.f(this.p, (int) R.drawable.bg_activity_down);
                return;
            }
            this.o.setVisibility(0);
            this.m.setText(groupActivityData.getgActivityArea());
            bq.f(this.p, (int) R.drawable.bg_activity_middle);
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

    public final ImageView d() {
        return this.f;
    }

    public final TextView e() {
        return this.u;
    }

    public final Dialog f() {
        return this.t;
    }

    public static /* synthetic */ void a(r rVar) {
        if (rVar.t == null) {
            CharSequence[] charSequenceArr = {rVar.a.getString(R.string.group_activity_eidt), rVar.a.getString(R.string.group_activity_delete)};
            AlertDialog.Builder builder = new AlertDialog.Builder(rVar.a);
            builder.setTitle(rVar.a.getString(R.string.operation));
            builder.setItems(charSequenceArr, rVar.a);
            rVar.t = builder.create();
            rVar.t.setCanceledOnTouchOutside(true);
        }
    }
}
