package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import d.a.c.e.p.l;
import d.a.i.p;
import d.a.i.q;
import d.a.m0.m.f;
import d.a.n0.b1.e.a.e.c;
import d.a.n0.b1.i.e.b;
/* loaded from: classes4.dex */
public class HotTopicRankLayout extends LinearLayout implements q, p<b>, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f16541e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabRankListLayout f16542f;

    /* renamed from: g  reason: collision with root package name */
    public View f16543g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16544h;

    /* renamed from: i  reason: collision with root package name */
    public View f16545i;
    public ImageView j;
    public View k;
    public View l;
    public f<c> m;

    /* loaded from: classes4.dex */
    public class a implements f<c> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: b */
        public void c(View view, c cVar, int i2, long j) {
            if (cVar == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.m.f
        /* renamed from: d */
        public void a(View view, c cVar, int i2, long j) {
            if (cVar == null) {
                return;
            }
            d.a.n0.b1.i.b.a("c13753", cVar, i2 + 1);
        }
    }

    public HotTopicRankLayout(Context context) {
        super(context, null);
        this.f16541e = 3;
        this.m = new a();
        b();
    }

    public final void b() {
        LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f16544h = (TextView) findViewById(R.id.tv_title);
        this.j = (ImageView) findViewById(R.id.iv_into);
        this.f16545i = findViewById(R.id.layout_into);
        this.k = findViewById(R.id.divider_line_top);
        this.l = findViewById(R.id.divider_line_bottom);
        this.f16543g = findViewById(R.id.title_layout);
        this.f16543g.setPadding(0, l.g(getContext(), R.dimen.tbds44), 0, l.g(getContext(), R.dimen.tbds22));
        ViewGroup.LayoutParams layoutParams = this.f16543g.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f16543g.setLayoutParams(layoutParams);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
        HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
        this.f16542f = hotTopicTabRankListLayout;
        hotTopicTabRankListLayout.setOnItemCoverListener(this.m);
        linearLayout.addView(this.f16542f);
        linearLayout.setPadding(0, 0, 0, l.g(getContext(), R.dimen.tbds48));
        this.j.setClickable(false);
        this.f16545i.setOnClickListener(this);
        this.j.setVisibility(8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i.p
    /* renamed from: c */
    public void a(b bVar) {
        TextView textView = this.f16544h;
        String str = bVar.f51902f;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        this.f16542f.b(bVar);
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        d.a.m0.b.g.b.g(this.k);
        d.a.n0.b1.i.b.b("c13753");
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.f16541e != i2) {
            SkinManager.setViewTextColor(this.f16544h, R.color.CAM_X0108);
            SkinManager.setBackgroundResource(this, R.drawable.addresslist_item_bg);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        }
        this.f16541e = i2;
        d.a.m0.b.g.b.h(this.k);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
