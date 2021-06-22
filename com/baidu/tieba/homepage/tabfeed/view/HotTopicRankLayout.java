package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.i.q;
import d.a.n0.m.f;
import d.a.o0.b1.f.a.e.c;
import d.a.o0.b1.j.h.b;
/* loaded from: classes4.dex */
public class HotTopicRankLayout extends LinearLayout implements q, p<b>, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f16699e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabRankListLayout f16700f;

    /* renamed from: g  reason: collision with root package name */
    public View f16701g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16702h;

    /* renamed from: i  reason: collision with root package name */
    public View f16703i;
    public ImageView j;
    public View k;
    public View l;
    public LinearLayout m;
    public String n;
    public f<c> o;

    /* loaded from: classes4.dex */
    public class a implements f<c> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: b */
        public void c(View view, c cVar, int i2, long j) {
            if (cVar == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.m.f
        /* renamed from: d */
        public void a(View view, c cVar, int i2, long j) {
            if (cVar == null) {
                return;
            }
            d.a.o0.b1.j.c.a("c13753", cVar, i2 + 1, HotTopicRankLayout.this.n);
        }
    }

    public HotTopicRankLayout(Context context) {
        super(context, null);
        this.f16699e = 3;
        this.o = new a();
        c();
    }

    public final void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f16702h = (TextView) findViewById(R.id.tv_title);
        this.j = (ImageView) findViewById(R.id.iv_into);
        this.f16703i = findViewById(R.id.layout_into);
        this.k = findViewById(R.id.divider_line_top);
        this.l = findViewById(R.id.divider_line_bottom);
        this.m = (LinearLayout) findViewById(R.id.content);
        this.f16701g = findViewById(R.id.title_layout);
        int g2 = l.g(getContext(), R.dimen.M_H_X004);
        int g3 = l.g(getContext(), R.dimen.M_H_X004);
        int g4 = l.g(getContext(), R.dimen.M_W_X005);
        this.f16701g.setPadding(g4, g2, g4, g3);
        ViewGroup.LayoutParams layoutParams = this.f16701g.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f16701g.setLayoutParams(layoutParams);
        this.f16702h.setMaxLines(1);
        this.f16702h.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
        this.f16700f = hotTopicTabRankListLayout;
        hotTopicTabRankListLayout.setOnItemCoverListener(this.o);
        linearLayout.addView(this.f16700f);
        linearLayout.setPadding(0, 0, 0, g3);
        this.j.setClickable(false);
        this.f16703i.setOnClickListener(this);
        this.j.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: d */
    public void a(b bVar) {
        TextView textView = this.f16702h;
        String str = bVar.f55713f;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        this.f16700f.b(bVar);
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        d.a.n0.b.g.b.g(this.k);
        d.a.o0.b1.j.c.c("c13753", this.n);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.f16699e != i2) {
            d.a.n0.r.u.c d2 = d.a.n0.r.u.c.d(this.f16702h);
            d2.s(R.color.CAM_X0105);
            d2.w(R.dimen.T_X07);
            d2.x(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            d.a.n0.b.g.b.h(this.k);
            this.f16699e = i2;
            d.a.n0.r.u.c d3 = d.a.n0.r.u.c.d(this.m);
            d3.m(R.string.J_X06);
            d3.f(R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setTabCode(String str) {
        this.n = str;
    }
}
