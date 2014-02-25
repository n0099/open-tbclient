package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bz extends com.baidu.adp.a.e {
    private LinearLayout a;
    private BdSwitchView c;
    private BdSwitchView d;
    private View e;
    private LinearLayout f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private LinearLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private View.OnClickListener r;
    private boolean s;
    private com.baidu.adp.widget.BdSwitchView.c t;

    public bz(Context context) {
        super(context);
        this.a = null;
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
        this.t = new ca(this);
        k();
    }

    public View a() {
        return this.e;
    }

    public void e() {
        h();
        i();
        j();
    }

    private void k() {
        this.e = LayoutInflater.from(this.b).inflate(R.layout.frs_sidebar, (ViewGroup) null);
        this.d = (BdSwitchView) this.e.findViewById(R.id.thrift_mode_switch);
        this.d.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.a = (LinearLayout) this.e.findViewById(R.id.eyeshield_mode);
        this.c = (BdSwitchView) this.e.findViewById(R.id.eyeshield_mode_switch);
        this.c.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.b);
        this.c.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.g = (TextView) this.e.findViewById(R.id.message_btn);
        this.h = (LinearLayout) this.e.findViewById(R.id.message_layout);
        this.i = (TextView) this.e.findViewById(R.id.like_forum_text);
        this.j = (LinearLayout) this.e.findViewById(R.id.like_forum_layout);
        this.f = (LinearLayout) this.e.findViewById(R.id.inform_title_layout);
        this.k = (LinearLayout) this.e.findViewById(R.id.add_to_window_layout);
        this.q = (LinearLayout) this.e.findViewById(R.id.manage_mode);
        this.q.setVisibility(8);
        this.l = (LinearLayout) this.e.findViewById(R.id.account_manager_layout);
        this.n = (LinearLayout) this.e.findViewById(R.id.show_all);
        this.o = (LinearLayout) this.e.findViewById(R.id.show_good);
        this.p = (LinearLayout) this.e.findViewById(R.id.show_image);
        this.l.setVisibility(8);
    }

    public void a(boolean z) {
        if (z) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (z) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void a(int i) {
        this.m = (LinearLayout) this.e.findViewById(i);
        if (this.m != null) {
            if (this.m == this.n) {
                this.n.setSelected(true);
                this.o.setSelected(false);
                this.p.setSelected(false);
            } else if (this.m == this.o) {
                this.n.setSelected(false);
                this.o.setSelected(true);
                this.p.setSelected(false);
            } else if (this.m == this.p) {
                this.n.setSelected(false);
                this.o.setSelected(false);
                this.p.setSelected(true);
            }
        }
    }

    public BdSwitchView f() {
        return this.c;
    }

    public boolean g() {
        return this.s;
    }

    public void c(boolean z) {
        this.s = z;
    }

    public void h() {
    }

    public void i() {
        if (TiebaApplication.g().al() == 1) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    public void j() {
        this.d.setOnSwitchStateChangeListener(null);
        if (com.baidu.tieba.h.a.a().f()) {
            this.d.a();
        } else {
            this.d.b();
        }
        this.d.setOnSwitchStateChangeListener(this.t);
    }

    public void a(com.baidu.tieba.model.ae aeVar) {
        long a = aeVar.a() + aeVar.b();
        boolean z = TiebaApplication.g().al() == 1;
        if (a > 0) {
            this.g.setVisibility(0);
            if (a < 10) {
                this.g.setText(String.valueOf(a));
                this.g.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_one_1 : R.drawable.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.g.setText(String.valueOf(a));
                this.g.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_two_1 : R.drawable.icon_news_head_prompt_two);
                return;
            } else {
                this.g.setText("   ");
                this.g.setBackgroundResource(z ? R.drawable.icon_news_head_prompt_more_1 : R.drawable.icon_news_head_prompt_more);
                return;
            }
        }
        this.g.setVisibility(4);
    }

    public void a(View.OnClickListener onClickListener) {
        this.r = onClickListener;
        this.h.setOnClickListener(this.r);
        this.k.setOnClickListener(this.r);
        this.l.setOnClickListener(this.r);
        this.n.setOnClickListener(this.r);
        this.o.setOnClickListener(this.r);
        this.p.setOnClickListener(this.r);
        this.q.setOnClickListener(this.r);
    }

    public void a(ArrayList<com.baidu.tieba.data.ad> arrayList) {
        if (arrayList != null) {
            this.j.removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.b);
            int size = arrayList.size();
            if (size != 0) {
                int i = size > 10 ? 10 : size;
                int al = TiebaApplication.g().al();
                com.baidu.tieba.e layoutMode = ((com.baidu.tieba.f) this.b).getLayoutMode();
                layoutMode.a(al == 1);
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.frs_sidebar_item, (ViewGroup) null);
                    layoutMode.a((View) linearLayout);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.like_forum_name);
                    String b = arrayList.get(i2).b();
                    textView.setText(b);
                    textView.setTag(b);
                    textView.setOnClickListener(this.r);
                    this.j.addView(linearLayout);
                }
            }
        }
    }

    public void b(int i) {
        com.baidu.tieba.e layoutMode = ((com.baidu.tieba.f) this.b).getLayoutMode();
        layoutMode.a(i == 1);
        layoutMode.a(this.e);
    }
}
