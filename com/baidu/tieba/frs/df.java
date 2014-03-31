package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class df extends com.baidu.adp.a.f {
    public LinearLayout a;
    private LinearLayout c;
    private BdSwitchView d;
    private BdSwitchView e;
    private View f;
    private TextView g;
    private LinearLayout h;
    private LinearLayout i;
    private TextView j;
    private View.OnClickListener k;
    private boolean l;
    private final com.baidu.adp.widget.BdSwitchView.c m;

    public df(Context context) {
        super(context);
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.a = null;
        this.j = null;
        this.k = null;
        this.m = new dg(this);
        this.f = LayoutInflater.from(this.b).inflate(com.baidu.tieba.a.i.frs_sidebar, (ViewGroup) null);
        this.j = (TextView) this.f.findViewById(com.baidu.tieba.a.h.add_recommend);
        this.a = (LinearLayout) this.f.findViewById(com.baidu.tieba.a.h.forum_manager_center);
        this.a.setVisibility(8);
        this.e = (BdSwitchView) this.f.findViewById(com.baidu.tieba.a.h.thrift_mode_switch);
        this.e.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.c = (LinearLayout) this.f.findViewById(com.baidu.tieba.a.h.eyeshield_mode);
        this.d = (BdSwitchView) this.f.findViewById(com.baidu.tieba.a.h.eyeshield_mode_switch);
        this.d.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.b);
        this.d.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.g = (TextView) this.f.findViewById(com.baidu.tieba.a.h.message_btn);
        this.h = (LinearLayout) this.f.findViewById(com.baidu.tieba.a.h.message_layout);
        this.i = (LinearLayout) this.f.findViewById(com.baidu.tieba.a.h.recommend_forum_layout);
    }

    public final View a() {
        return this.f;
    }

    public final void d() {
        if (TbadkApplication.j().l() == 1) {
            this.d.a();
        } else {
            this.d.b();
        }
        this.e.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.h.a().f()) {
            this.e.a();
        } else {
            this.e.b();
        }
        this.e.setOnSwitchStateChangeListener(this.m);
    }

    public final void a(boolean z) {
        if (z) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }

    public final BdSwitchView e() {
        return this.d;
    }

    public final boolean f() {
        return this.l;
    }

    public final void b(boolean z) {
        this.l = false;
    }

    public final void a(cu cuVar) {
        long a = cuVar.a() + cuVar.b();
        boolean z = TbadkApplication.j().l() == 1;
        if (a > 0) {
            this.g.setVisibility(0);
            if (a < 10) {
                this.g.setText(String.valueOf(a));
                this.g.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_one_1 : com.baidu.tieba.a.g.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.g.setText(String.valueOf(a));
                this.g.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_two_1 : com.baidu.tieba.a.g.icon_news_head_prompt_two);
                return;
            } else {
                this.g.setText("   ");
                this.g.setBackgroundResource(z ? com.baidu.tieba.a.g.icon_news_head_prompt_more_1 : com.baidu.tieba.a.g.icon_news_head_prompt_more);
                return;
            }
        }
        this.g.setVisibility(4);
    }

    public final void a(View.OnClickListener onClickListener) {
        this.k = onClickListener;
        this.h.setOnClickListener(this.k);
        this.a.setOnClickListener(this.k);
    }

    public final void a(ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            this.j.setVisibility(8);
            return;
        }
        this.j.setVisibility(0);
        this.i.removeAllViews();
        LayoutInflater from = LayoutInflater.from(this.b);
        com.baidu.tbadk.core.util.b bVar = new com.baidu.tbadk.core.util.b(this.b);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int l = TbadkApplication.j().l();
            com.baidu.tbadk.core.c layoutMode = ((com.baidu.tbadk.a) this.b).getLayoutMode();
            layoutMode.a(l == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) from.inflate(com.baidu.tieba.a.i.frs_sidebar_item, (ViewGroup) null);
                layoutMode.a(linearLayout);
                String str = arrayList.get(i2).a;
                String str2 = arrayList.get(i2).b;
                String str3 = arrayList.get(i2).d;
                di diVar = new di(this);
                diVar.a = str;
                diVar.b = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.a.h.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.a.h.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.k);
                linearLayout2.setTag(diVar);
                bVar.b(str2, new dh(this, (HeadImageView) linearLayout.findViewById(com.baidu.tieba.a.h.recommend_forum_image)));
                this.i.addView(linearLayout);
            }
        }
    }

    public final void b(ArrayList<com.baidu.tieba.data.x> arrayList) {
        if (arrayList != null) {
            this.i.removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.b);
            int size = arrayList.size();
            if (size != 0) {
                int i = size > 10 ? 10 : size;
                int l = TbadkApplication.j().l();
                com.baidu.tbadk.core.c layoutMode = ((com.baidu.tbadk.a) this.b).getLayoutMode();
                layoutMode.a(l == 1);
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) from.inflate(com.baidu.tieba.a.i.frs_sidebar_item, (ViewGroup) null);
                    layoutMode.a(linearLayout);
                    TextView textView = (TextView) linearLayout.findViewById(com.baidu.tieba.a.h.recommend_forum_name);
                    String b = arrayList.get(i2).b();
                    textView.setText(b);
                    textView.setTag(b);
                    textView.setOnClickListener(this.k);
                    this.i.addView(linearLayout);
                }
            }
        }
    }

    public final void a(int i) {
        com.baidu.tbadk.core.c layoutMode = ((com.baidu.tbadk.a) this.b).getLayoutMode();
        layoutMode.a(i == 1);
        layoutMode.a(this.f);
    }
}
