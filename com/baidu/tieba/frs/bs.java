package com.baidu.tieba.frs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
public class bs extends com.baidu.adp.a.e {
    private BdSwitchView a;
    private BdSwitchView c;
    private View d;
    private LinearLayout e;
    private LinearLayout f;
    private TextView g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private AlertDialog n;
    private View.OnClickListener o;
    private boolean p;
    private com.baidu.adp.widget.BdSwitchView.c q;
    private final DialogInterface.OnClickListener r;

    public bs(Context context) {
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
        this.q = new bt(this);
        this.r = new bu(this);
        k();
    }

    public View a() {
        return this.d;
    }

    public void e() {
        h();
        i();
        j();
    }

    private void k() {
        this.d = LayoutInflater.from(this.b).inflate(R.layout.frs_sidebar, (ViewGroup) null);
        this.c = (BdSwitchView) this.d.findViewById(R.id.thrift_mode_switch);
        this.c.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.a = (BdSwitchView) this.d.findViewById(R.id.eyeshield_mode_switch);
        this.a.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.b);
        this.a.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.g = (TextView) this.d.findViewById(R.id.message_btn);
        this.e = (LinearLayout) this.d.findViewById(R.id.message_layout);
        this.h = (LinearLayout) this.d.findViewById(R.id.like_forum_layout);
        this.f = (LinearLayout) this.d.findViewById(R.id.inform_title_layout);
        this.i = (LinearLayout) this.d.findViewById(R.id.add_to_window_layout);
        this.k = (LinearLayout) this.d.findViewById(R.id.show_all);
        this.l = (LinearLayout) this.d.findViewById(R.id.show_good);
        this.m = (LinearLayout) this.d.findViewById(R.id.show_image);
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

    public BdSwitchView f() {
        return this.a;
    }

    public boolean g() {
        return this.p;
    }

    public void b(boolean z) {
        this.p = z;
    }

    public void h() {
    }

    public void i() {
        if (TiebaApplication.h().an() == 1) {
            this.a.a();
        } else {
            this.a.b();
        }
    }

    public void j() {
        this.c.setOnSwitchStateChangeListener(null);
        if (com.baidu.tieba.d.a.a().f()) {
            this.c.a();
        } else {
            this.c.b();
        }
        this.c.setOnSwitchStateChangeListener(this.q);
    }

    public void a(com.baidu.tieba.model.ap apVar) {
        long a = apVar.a() + apVar.b();
        boolean z = TiebaApplication.h().an() == 1;
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
        this.o = onClickListener;
        this.e.setOnClickListener(this.o);
        this.i.setOnClickListener(this.o);
        this.k.setOnClickListener(this.o);
        this.l.setOnClickListener(this.o);
        this.m.setOnClickListener(this.o);
    }

    public void a(boolean z, String str) {
    }

    public void a(com.baidu.tieba.data.t tVar) {
        if (tVar != null) {
            this.h.removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.b);
            ArrayList<com.baidu.tieba.data.s> c = tVar.c();
            int size = c.size();
            if (size != 0) {
                int i = size > 10 ? 10 : size;
                int an = TiebaApplication.h().an();
                com.baidu.tieba.e layoutMode = ((com.baidu.tieba.j) this.b).getLayoutMode();
                layoutMode.a(an == 1);
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) from.inflate(R.layout.frs_sidebar_item, (ViewGroup) null);
                    layoutMode.a(linearLayout);
                    TextView textView = (TextView) linearLayout.findViewById(R.id.like_forum_name);
                    String a = c.get(i2).a();
                    textView.setText(a);
                    textView.setTag(a);
                    textView.setOnClickListener(this.o);
                    this.h.addView(linearLayout);
                }
            }
        }
    }

    public void b(int i) {
        com.baidu.tieba.e layoutMode = ((com.baidu.tieba.j) this.b).getLayoutMode();
        layoutMode.a(i == 1);
        layoutMode.a(this.d);
    }
}
