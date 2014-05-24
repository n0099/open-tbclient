package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dq extends com.baidu.adp.base.c {
    public LinearLayout a;
    private LinearLayout b;
    private BdSwitchView c;
    private BdSwitchView d;
    private View e;
    private TextView f;
    private LinearLayout g;
    private LinearLayout h;
    private TextView i;
    private View.OnClickListener j;
    private boolean k;
    private final com.baidu.adp.widget.BdSwitchView.c l;

    public dq(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.a = null;
        this.i = null;
        this.j = null;
        this.l = new dr(this);
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
        this.e = LayoutInflater.from(this.mContext).inflate(com.baidu.tieba.w.frs_sidebar, (ViewGroup) null);
        this.i = (TextView) this.e.findViewById(com.baidu.tieba.v.add_recommend);
        this.a = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.forum_manager_center);
        this.a.setVisibility(8);
        this.d = (BdSwitchView) this.e.findViewById(com.baidu.tieba.v.thrift_mode_switch);
        this.d.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.b = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.c = (BdSwitchView) this.e.findViewById(com.baidu.tieba.v.eyeshield_mode_switch);
        this.c.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext);
        this.c.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.f = (TextView) this.e.findViewById(com.baidu.tieba.v.message_btn);
        this.g = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.message_layout);
        this.h = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.recommend_forum_layout);
    }

    public void a(boolean z) {
        if (z) {
            this.a.setVisibility(0);
        } else {
            this.a.setVisibility(8);
        }
    }

    public BdSwitchView c() {
        return this.c;
    }

    public boolean d() {
        return this.k;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public void e() {
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    public void f() {
        this.d.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.g.a().f()) {
            this.d.a();
        } else {
            this.d.b();
        }
        this.d.setOnSwitchStateChangeListener(this.l);
    }

    public void a(de deVar, boolean z) {
        if (!z) {
            this.f.setVisibility(4);
            return;
        }
        long a = deVar.a() + deVar.b();
        boolean z2 = TbadkApplication.m252getInst().getSkinType() == 1;
        if (a > 0) {
            this.f.setVisibility(0);
            if (a < 10) {
                this.f.setText(String.valueOf(a));
                this.f.setBackgroundResource(z2 ? com.baidu.tieba.u.icon_news_head_prompt_one_1 : com.baidu.tieba.u.icon_news_head_prompt_one);
                return;
            } else if (a < 100) {
                this.f.setText(String.valueOf(a));
                this.f.setBackgroundResource(z2 ? com.baidu.tieba.u.icon_news_head_prompt_two_1 : com.baidu.tieba.u.icon_news_head_prompt_two);
                return;
            } else {
                this.f.setText("   ");
                this.f.setBackgroundResource(z2 ? com.baidu.tieba.u.icon_news_head_prompt_more_1 : com.baidu.tieba.u.icon_news_head_prompt_more);
                return;
            }
        }
        this.f.setVisibility(4);
    }

    public void a(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        this.g.setOnClickListener(this.j);
        this.a.setOnClickListener(this.j);
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.m> arrayList) {
        this.h.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.i.setVisibility(8);
            return;
        }
        this.i.setVisibility(0);
        LayoutInflater from = LayoutInflater.from(this.mContext);
        com.baidu.tbadk.core.util.b bVar = new com.baidu.tbadk.core.util.b(this.mContext);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int skinType = TbadkApplication.m252getInst().getSkinType();
            com.baidu.tbadk.core.c layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
            layoutMode.a(skinType == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) from.inflate(com.baidu.tieba.w.frs_sidebar_item, (ViewGroup) null);
                layoutMode.a((View) linearLayout);
                String str = arrayList.get(i2).a;
                String str2 = arrayList.get(i2).b;
                String str3 = arrayList.get(i2).d;
                dt dtVar = new dt(this);
                dtVar.a = str;
                dtVar.b = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.j);
                linearLayout2.setTag(dtVar);
                bVar.b(str2, new ds(this, (HeadImageView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_image)));
                this.h.addView(linearLayout);
            }
        }
    }

    public void b(ArrayList<com.baidu.tieba.data.x> arrayList) {
        if (arrayList != null) {
            this.h.removeAllViews();
            LayoutInflater from = LayoutInflater.from(this.mContext);
            int size = arrayList.size();
            if (size != 0) {
                int i = size > 10 ? 10 : size;
                int skinType = TbadkApplication.m252getInst().getSkinType();
                com.baidu.tbadk.core.c layoutMode = ((BaseActivity) this.mContext).getLayoutMode();
                layoutMode.a(skinType == 1);
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) from.inflate(com.baidu.tieba.w.frs_sidebar_item, (ViewGroup) null);
                    layoutMode.a((View) linearLayout);
                    TextView textView = (TextView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_name);
                    String b = arrayList.get(i2).b();
                    textView.setText(b);
                    textView.setTag(b);
                    textView.setOnClickListener(this.j);
                    this.h.addView(linearLayout);
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
