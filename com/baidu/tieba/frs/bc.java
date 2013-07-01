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
public class bc extends com.baidu.adp.a.d {
    private TextView A;
    private View.OnClickListener B;
    private BdSwitchView b;
    private BdSwitchView c;
    private View d;
    private LinearLayout e;
    private LinearLayout f;
    private Button g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
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
    private TextView x;
    private LinearLayout y;
    private TextView z;

    public bc(Context context) {
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
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
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
        this.d = LayoutInflater.from(this.f118a).inflate(R.layout.frs_sidebar, (ViewGroup) null);
        this.b = (BdSwitchView) this.d.findViewById(R.id.abstract_state_switch);
        this.b.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.f118a);
        this.b.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.c = (BdSwitchView) this.d.findViewById(R.id.eyeshield_mode_switch);
        this.c.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.f118a);
        this.c.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.g = (Button) this.d.findViewById(R.id.message_btn);
        this.e = (LinearLayout) this.d.findViewById(R.id.message_layout);
        this.h = (LinearLayout) this.d.findViewById(R.id.like_forum_layout);
        this.f = (LinearLayout) this.d.findViewById(R.id.inform_title_layout);
        this.i = (LinearLayout) this.d.findViewById(R.id.add_to_window_layout);
        this.k = (LinearLayout) this.d.findViewById(R.id.show_all);
        this.l = (LinearLayout) this.d.findViewById(R.id.show_good);
        this.m = (LinearLayout) this.d.findViewById(R.id.show_image);
        this.n = (TextView) this.d.findViewById(R.id.show_all_text);
        this.o = (TextView) this.d.findViewById(R.id.show_good_text);
        this.p = (TextView) this.d.findViewById(R.id.show_image_text);
        this.q = (TextView) this.d.findViewById(R.id.show_title);
        this.r = (TextView) this.d.findViewById(R.id.setting_title);
        this.s = (TextView) this.d.findViewById(R.id.inform_title);
        this.t = (TextView) this.d.findViewById(R.id.like_forum_text);
        this.x = (TextView) this.d.findViewById(R.id.message_text);
        this.v = (TextView) this.d.findViewById(R.id.eyeshield_mode_text);
        this.u = (TextView) this.d.findViewById(R.id.abstract_text);
        this.w = (TextView) this.d.findViewById(R.id.add_to_window);
        this.y = (LinearLayout) this.d.findViewById(R.id.chat_layout);
        this.z = (TextView) this.d.findViewById(R.id.chat_text);
        this.A = (TextView) this.d.findViewById(R.id.new_chat);
    }

    public BdSwitchView c() {
        return this.b;
    }

    public void a(boolean z) {
        if (z) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void a(int i) {
        this.j = (LinearLayout) this.d.findViewById(i);
        if (this.j != null) {
            if (this.j == this.k) {
                this.k.setSelected(true);
                this.l.setSelected(false);
                this.m.setSelected(false);
            } else if (this.j == this.l) {
                this.k.setSelected(false);
                this.l.setSelected(true);
                this.m.setSelected(false);
            } else if (this.j == this.m) {
                this.k.setSelected(false);
                this.l.setSelected(false);
                this.m.setSelected(true);
            }
        }
    }

    public BdSwitchView d() {
        return this.c;
    }

    public void e() {
        if (TiebaApplication.f().ar()) {
            this.b.a();
        } else {
            this.b.b();
        }
    }

    public void f() {
        if (TiebaApplication.f().at() == 1) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    public void a(com.baidu.tieba.model.aa aaVar) {
        long a2 = aaVar.a();
        if (a2 > 0) {
            this.g.setVisibility(0);
            if (a2 > 99) {
                a2 = 99;
            }
            this.g.setText(String.valueOf(a2));
        } else {
            this.g.setVisibility(8);
        }
        long b = aaVar.b();
        if (b > 0) {
            this.A.setVisibility(0);
            this.A.setText(String.valueOf(b <= 99 ? b : 99L));
            return;
        }
        this.A.setVisibility(8);
    }

    public void a(View.OnClickListener onClickListener) {
        this.B = onClickListener;
        this.e.setOnClickListener(this.B);
        this.i.setOnClickListener(this.B);
        this.k.setOnClickListener(this.B);
        this.l.setOnClickListener(this.B);
        this.m.setOnClickListener(this.B);
        this.y.setOnClickListener(this.B);
    }

    public void a(boolean z, String str) {
    }

    public void a(com.baidu.tieba.data.p pVar) {
        if (pVar != null) {
            this.h.removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.f118a);
            ArrayList c = pVar.c();
            int size = c.size();
            int i = size > 10 ? 10 : size;
            int at = TiebaApplication.f().at();
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.frs_sidebar_item, (ViewGroup) null);
                TextView textView = (TextView) linearLayout.findViewById(R.id.like_forum_name);
                if (at == 1) {
                    textView.setTextAppearance(this.f118a, R.style.sidebar_content_1);
                } else {
                    textView.setTextAppearance(this.f118a, R.style.sidebar_content);
                }
                String a2 = ((com.baidu.tieba.data.o) c.get(i2)).a();
                textView.setText(a2);
                textView.setTag(a2);
                textView.setOnClickListener(this.B);
                this.h.addView(linearLayout);
            }
        }
    }

    public void b(int i) {
        int childCount = this.h.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            TextView textView = (TextView) this.h.getChildAt(i2).findViewById(R.id.like_forum_name);
            if (textView != null) {
                if (i == 1) {
                    textView.setTextAppearance(this.f118a, R.style.sidebar_content_1);
                } else {
                    textView.setTextAppearance(this.f118a, R.style.sidebar_content);
                }
            }
        }
        if (i == 1) {
            this.q.setTextColor(-13025722);
            this.r.setTextColor(-13025722);
            this.s.setTextColor(-13025722);
            this.t.setTextColor(-13025722);
            this.n.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            this.o.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            this.p.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            this.u.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            this.v.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            this.w.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            this.x.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            this.g.setTextColor(-7128039);
            this.A.setTextColor(-7128039);
            this.z.setTextAppearance(this.f118a, R.style.sidebar_content_1);
            return;
        }
        this.q.setTextColor(-11974069);
        this.r.setTextColor(-11974069);
        this.s.setTextColor(-11974069);
        this.t.setTextColor(-11974069);
        this.n.setTextAppearance(this.f118a, R.style.sidebar_content);
        this.o.setTextAppearance(this.f118a, R.style.sidebar_content);
        this.p.setTextAppearance(this.f118a, R.style.sidebar_content);
        this.u.setTextAppearance(this.f118a, R.style.sidebar_content);
        this.v.setTextAppearance(this.f118a, R.style.sidebar_content);
        this.w.setTextAppearance(this.f118a, R.style.sidebar_content);
        this.x.setTextAppearance(this.f118a, R.style.sidebar_content);
        this.g.setTextColor(-1485280);
        this.A.setTextColor(-1485280);
        this.z.setTextAppearance(this.f118a, R.style.sidebar_content);
    }
}
