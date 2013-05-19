package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bd extends com.baidu.adp.a.d {
    private BdSwitchView b;
    private BdSwitchView c;
    private View d;
    private LinearLayout e;
    private Button f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private final int x;
    private View.OnClickListener y;

    public bd(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 10;
        this.y = null;
        g();
    }

    public View a() {
        return this.d;
    }

    public void b() {
        e();
        f();
    }

    private void g() {
        this.d = LayoutInflater.from(this.a).inflate(R.layout.frs_sidebar, (ViewGroup) null);
        this.b = (BdSwitchView) this.d.findViewById(R.id.abstract_state_switch);
        this.b.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.a);
        this.b.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.SIDE_BAR);
        this.c = (BdSwitchView) this.d.findViewById(R.id.eyeshield_mode_switch);
        this.c.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.a);
        this.c.setSwitchStyle(com.baidu.adp.widget.BdSwitchView.e.SIDE_BAR);
        this.f = (Button) this.d.findViewById(R.id.message_btn);
        this.e = (LinearLayout) this.d.findViewById(R.id.message_layout);
        this.g = (LinearLayout) this.d.findViewById(R.id.like_forum_layout);
        this.h = (LinearLayout) this.d.findViewById(R.id.add_to_window_layout);
        this.j = (LinearLayout) this.d.findViewById(R.id.show_all);
        this.k = (LinearLayout) this.d.findViewById(R.id.show_good);
        this.l = (LinearLayout) this.d.findViewById(R.id.show_image);
        this.m = (TextView) this.d.findViewById(R.id.show_all_text);
        this.n = (TextView) this.d.findViewById(R.id.show_good_text);
        this.o = (TextView) this.d.findViewById(R.id.show_image_text);
        this.p = (TextView) this.d.findViewById(R.id.show_title);
        this.q = (TextView) this.d.findViewById(R.id.setting_title);
        this.r = (TextView) this.d.findViewById(R.id.inform_title);
        this.s = (TextView) this.d.findViewById(R.id.like_forum_text);
        this.w = (TextView) this.d.findViewById(R.id.message_text);
        this.u = (TextView) this.d.findViewById(R.id.eyeshield_mode_text);
        this.t = (TextView) this.d.findViewById(R.id.abstract_text);
        this.v = (TextView) this.d.findViewById(R.id.add_to_window);
    }

    public BdSwitchView c() {
        return this.b;
    }

    public void a(int i) {
        this.i = (LinearLayout) this.d.findViewById(i);
        if (this.i != null) {
            if (this.i == this.j) {
                this.j.setSelected(true);
                this.k.setSelected(false);
                this.l.setSelected(false);
            } else if (this.i == this.k) {
                this.j.setSelected(false);
                this.k.setSelected(true);
                this.l.setSelected(false);
            } else if (this.i == this.l) {
                this.j.setSelected(false);
                this.k.setSelected(false);
                this.l.setSelected(true);
            }
        }
    }

    public BdSwitchView d() {
        return this.c;
    }

    public void e() {
        if (TiebaApplication.d().ah()) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    public void f() {
        if (TiebaApplication.d().ai() == 1) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    public void a(com.baidu.tieba.c.u uVar) {
        long a = uVar.a();
        if (a > 0) {
            this.f.setVisibility(0);
            this.f.setText(String.valueOf(a <= 99 ? a : 99L));
            return;
        }
        this.f.setVisibility(8);
    }

    public void a(View.OnClickListener onClickListener) {
        this.y = onClickListener;
        this.e.setOnClickListener(this.y);
        this.h.setOnClickListener(this.y);
        this.j.setOnClickListener(this.y);
        this.k.setOnClickListener(this.y);
        this.l.setOnClickListener(this.y);
    }

    public void a(boolean z, String str) {
    }

    public void a(com.baidu.tieba.a.q qVar) {
        if (qVar != null) {
            this.g.removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.a);
            ArrayList c = qVar.c();
            int size = c.size();
            int i = size > 10 ? 10 : size;
            int ai = TiebaApplication.d().ai();
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.frs_sidebar_item, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.like_forum_name);
                if (ai == 1) {
                    textView.setTextAppearance(this.a, R.style.sidebar_content_1);
                } else {
                    textView.setTextAppearance(this.a, R.style.sidebar_content);
                }
                String b = ((com.baidu.tieba.a.p) c.get(i2)).b();
                textView.setText(b);
                textView.setTag(b);
                textView.setOnClickListener(this.y);
                this.g.addView(linearLayout);
            }
        }
    }

    public void b(int i) {
        int childCount = this.g.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TextView textView = (TextView) this.g.getChildAt(i2).findViewById(R.id.like_forum_name);
            if (textView != null) {
                if (i == 1) {
                    textView.setTextAppearance(this.a, R.style.sidebar_content_1);
                } else {
                    textView.setTextAppearance(this.a, R.style.sidebar_content);
                }
            }
        }
        if (i == 1) {
            this.p.setTextColor(-13025722);
            this.q.setTextColor(-13025722);
            this.r.setTextColor(-13025722);
            this.s.setTextColor(-13025722);
            this.m.setTextAppearance(this.a, R.style.sidebar_content_1);
            this.n.setTextAppearance(this.a, R.style.sidebar_content_1);
            this.o.setTextAppearance(this.a, R.style.sidebar_content_1);
            this.t.setTextAppearance(this.a, R.style.sidebar_content_1);
            this.u.setTextAppearance(this.a, R.style.sidebar_content_1);
            this.v.setTextAppearance(this.a, R.style.sidebar_content_1);
            this.w.setTextAppearance(this.a, R.style.sidebar_content_1);
            this.f.setTextColor(-7128039);
            return;
        }
        this.p.setTextColor(-11974069);
        this.q.setTextColor(-11974069);
        this.r.setTextColor(-11974069);
        this.s.setTextColor(-11974069);
        this.m.setTextAppearance(this.a, R.style.sidebar_content);
        this.n.setTextAppearance(this.a, R.style.sidebar_content);
        this.o.setTextAppearance(this.a, R.style.sidebar_content);
        this.t.setTextAppearance(this.a, R.style.sidebar_content);
        this.u.setTextAppearance(this.a, R.style.sidebar_content);
        this.v.setTextAppearance(this.a, R.style.sidebar_content);
        this.w.setTextAppearance(this.a, R.style.sidebar_content);
        this.f.setTextColor(-1485280);
    }
}
