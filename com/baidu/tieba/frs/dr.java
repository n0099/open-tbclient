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
public class dr extends com.baidu.adp.base.f {
    public LinearLayout a;
    private LinearLayout b;
    private BdSwitchView c;
    private BdSwitchView d;
    private View e;
    private TextView f;
    private LinearLayout g;
    private LinearLayout h;
    private LinearLayout i;
    private View j;
    private TextView k;
    private View l;
    private View.OnClickListener m;
    private boolean n;
    private final com.baidu.adp.widget.BdSwitchView.c o;

    public dr(Context context) {
        super(context);
        this.b = null;
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
        this.l = null;
        this.m = null;
        this.o = new ds(this);
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
        this.k = (TextView) this.e.findViewById(com.baidu.tieba.v.add_recommend);
        this.l = this.e.findViewById(com.baidu.tieba.v.recommend_forum_layout_line);
        this.a = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.forum_manager_center);
        this.a.setVisibility(8);
        this.j = this.e.findViewById(com.baidu.tieba.v.forum_manager_center_line);
        this.j.setVisibility(8);
        this.d = (BdSwitchView) this.e.findViewById(com.baidu.tieba.v.thrift_mode_switch);
        this.d.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.b = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.eyeshield_mode);
        this.c = (BdSwitchView) this.e.findViewById(com.baidu.tieba.v.eyeshield_mode_switch);
        this.c.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext);
        this.c.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.f = (TextView) this.e.findViewById(com.baidu.tieba.v.message_btn);
        this.g = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.message_layout);
        this.h = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.history_layout);
        this.i = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.recommend_forum_layout);
    }

    public void a(boolean z) {
        if (z) {
            this.a.setVisibility(0);
            this.j.setVisibility(0);
            return;
        }
        this.a.setVisibility(8);
        this.j.setVisibility(8);
    }

    public BdSwitchView c() {
        return this.c;
    }

    public boolean d() {
        return this.n;
    }

    public void b(boolean z) {
        this.n = z;
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
        this.d.setOnSwitchStateChangeListener(this.o);
    }

    public void a(df dfVar, boolean z) {
        if (!z) {
            this.f.setVisibility(4);
            return;
        }
        long a = dfVar.a() + dfVar.b();
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
        this.m = onClickListener;
        this.g.setOnClickListener(this.m);
        this.h.setOnClickListener(this.m);
        this.a.setOnClickListener(this.m);
    }

    public void a(ArrayList<com.baidu.tbadk.core.data.l> arrayList) {
        this.i.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            return;
        }
        this.k.setVisibility(0);
        this.l.setVisibility(8);
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
                HeadImageView headImageView = (HeadImageView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_image);
                String str = arrayList.get(i2).a;
                String str2 = arrayList.get(i2).b;
                String str3 = arrayList.get(i2).d;
                dt dtVar = new dt(this);
                dtVar.a = str;
                dtVar.b = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.v.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.m);
                linearLayout2.setTag(dtVar);
                headImageView.setDefaultResource(com.baidu.tieba.u.photo);
                headImageView.a(str2, 10, false);
                this.i.addView(linearLayout);
            }
        }
    }

    public void b(ArrayList<com.baidu.tieba.data.z> arrayList) {
        if (arrayList != null) {
            this.i.removeAllViews();
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
                    textView.setOnClickListener(this.m);
                    this.i.addView(linearLayout);
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
