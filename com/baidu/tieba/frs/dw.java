package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dw extends com.baidu.adp.base.f {
    public LinearLayout a;
    private LinearLayout b;
    private BdSwitchView c;
    private BdSwitchView d;
    private View e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private LinearLayout k;
    private View l;
    private TextView m;
    private View n;
    private View.OnClickListener o;
    private boolean p;
    private final com.baidu.adp.widget.BdSwitchView.c q;

    public dw(Context context) {
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
        this.a = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.q = new dx(this);
        g();
    }

    public View a() {
        return this.e;
    }

    public void b() {
        e();
        f();
    }

    private void g() {
        this.e = com.baidu.adp.lib.e.b.a().a(this.mContext, com.baidu.tieba.v.frs_sidebar, null);
        this.m = (TextView) this.e.findViewById(com.baidu.tieba.u.add_recommend);
        this.n = this.e.findViewById(com.baidu.tieba.u.recommend_forum_layout_line);
        this.a = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.forum_manager_center);
        this.a.setVisibility(8);
        this.l = this.e.findViewById(com.baidu.tieba.u.forum_manager_center_line);
        this.l.setVisibility(8);
        this.d = (BdSwitchView) this.e.findViewById(com.baidu.tieba.u.thrift_mode_switch);
        this.d.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.b = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.eyeshield_mode);
        this.c = (BdSwitchView) this.e.findViewById(com.baidu.tieba.u.eyeshield_mode_switch);
        this.c.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext);
        this.c.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.f = (TextView) this.e.findViewById(com.baidu.tieba.u.message_btn);
        this.g = (TextView) this.e.findViewById(com.baidu.tieba.u.mention_btn);
        this.h = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.message_layout);
        this.i = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.mention_layout);
        this.j = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.history_layout);
        this.k = (LinearLayout) this.e.findViewById(com.baidu.tieba.u.recommend_forum_layout);
    }

    public void a(boolean z) {
        if (z) {
            this.a.setVisibility(0);
            this.l.setVisibility(0);
            return;
        }
        this.a.setVisibility(8);
        this.l.setVisibility(8);
    }

    public BdSwitchView c() {
        return this.c;
    }

    public boolean d() {
        return this.p;
    }

    public void b(boolean z) {
        this.p = z;
    }

    public void e() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.c.c();
        } else {
            this.c.d();
        }
    }

    public void f() {
        this.d.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.h.a().f()) {
            this.d.c();
        } else {
            this.d.d();
        }
        this.d.setOnSwitchStateChangeListener(this.q);
    }

    public void a(dk dkVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.f.setVisibility(4);
            this.g.setVisibility(4);
            return;
        }
        if (z) {
            a(this.f, dkVar.b());
        } else {
            this.f.setVisibility(4);
        }
        if (z2) {
            a(this.g, dkVar.a());
            return;
        }
        this.g.setVisibility(4);
    }

    private void a(TextView textView, long j) {
        if (textView != null) {
            boolean z = TbadkApplication.m252getInst().getSkinType() == 1;
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    textView.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_one_1 : com.baidu.tieba.t.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    textView.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_two_1 : com.baidu.tieba.t.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    textView.setBackgroundResource(z ? com.baidu.tieba.t.icon_news_head_prompt_more_1 : com.baidu.tieba.t.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.o = onClickListener;
        this.h.setOnClickListener(this.o);
        this.i.setOnClickListener(this.o);
        this.j.setOnClickListener(this.o);
        this.a.setOnClickListener(this.o);
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        this.k.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.m.setVisibility(8);
            this.n.setVisibility(0);
            return;
        }
        this.m.setVisibility(0);
        this.n.setVisibility(8);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int skinType = TbadkApplication.m252getInst().getSkinType();
            com.baidu.tbadk.core.c layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
            layoutMode.a(skinType == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.e.b.a().a(this.mContext, com.baidu.tieba.v.frs_sidebar_item, null);
                layoutMode.a((View) linearLayout);
                String str = arrayList.get(i2).a;
                String str2 = arrayList.get(i2).b;
                String str3 = arrayList.get(i2).d;
                dy dyVar = new dy(this);
                dyVar.a = str;
                dyVar.b = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.u.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.u.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.o);
                linearLayout2.setTag(dyVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.u.recommend_forum_image)).a(str2, 10, false);
                this.k.addView(linearLayout);
            }
        }
    }

    public void b(ArrayList<com.baidu.tieba.data.z> arrayList) {
        if (arrayList != null) {
            this.k.removeAllViews();
            int size = arrayList.size();
            if (size != 0) {
                int i = size > 10 ? 10 : size;
                int skinType = TbadkApplication.m252getInst().getSkinType();
                com.baidu.tbadk.core.c layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
                layoutMode.a(skinType == 1);
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.e.b.a().a(this.mContext, com.baidu.tieba.v.frs_sidebar_item, null);
                    layoutMode.a((View) linearLayout);
                    TextView textView = (TextView) linearLayout.findViewById(com.baidu.tieba.u.recommend_forum_name);
                    String b = arrayList.get(i2).b();
                    textView.setText(b);
                    textView.setTag(b);
                    textView.setOnClickListener(this.o);
                    this.k.addView(linearLayout);
                }
            }
        }
    }

    public void a(int i) {
        com.baidu.tbadk.core.c layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
        layoutMode.a(i == 1);
        layoutMode.a(this.e);
    }
}
