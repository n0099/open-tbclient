package com.baidu.tieba.homepage.tabfeed.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.j.p;
import d.a.j.q;
import d.a.r0.m.f;
import d.a.s0.e1.f.a.e.c;
import d.a.s0.e1.j.h.b;
/* loaded from: classes5.dex */
public class HotTopicRankLayout extends LinearLayout implements q, p<b>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f16835e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabRankListLayout f16836f;

    /* renamed from: g  reason: collision with root package name */
    public View f16837g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16838h;

    /* renamed from: i  reason: collision with root package name */
    public View f16839i;
    public ImageView j;
    public View k;
    public View l;
    public LinearLayout m;
    public String n;
    public f<c> o;

    /* loaded from: classes5.dex */
    public class a implements f<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicRankLayout f16840e;

        public a(HotTopicRankLayout hotTopicRankLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicRankLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16840e = hotTopicRankLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: b */
        public void c(View view, c cVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, cVar, Integer.valueOf(i2), Long.valueOf(j)}) != null) || cVar == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.r0.m.f
        /* renamed from: d */
        public void a(View view, c cVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, cVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) || cVar == null) {
                return;
            }
            d.a.s0.e1.j.c.a("c13753", cVar, i2 + 1, this.f16840e.n);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotTopicRankLayout(Context context) {
        super(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16835e = 3;
        this.o = new a(this);
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f16838h = (TextView) findViewById(R.id.tv_title);
            this.j = (ImageView) findViewById(R.id.iv_into);
            this.f16839i = findViewById(R.id.layout_into);
            this.k = findViewById(R.id.divider_line_top);
            this.l = findViewById(R.id.divider_line_bottom);
            this.m = (LinearLayout) findViewById(R.id.content);
            this.f16837g = findViewById(R.id.title_layout);
            int g2 = l.g(getContext(), R.dimen.M_H_X004);
            int g3 = l.g(getContext(), R.dimen.M_H_X004);
            int g4 = l.g(getContext(), R.dimen.M_W_X005);
            this.f16837g.setPadding(g4, g2, g4, g3);
            ViewGroup.LayoutParams layoutParams = this.f16837g.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.f16837g.setLayoutParams(layoutParams);
            this.f16838h.setMaxLines(1);
            this.f16838h.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
            HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
            this.f16836f = hotTopicTabRankListLayout;
            hotTopicTabRankListLayout.setOnItemCoverListener(this.o);
            linearLayout.addView(this.f16836f);
            linearLayout.setPadding(0, 0, 0, g3);
            this.j.setClickable(false);
            this.f16839i.setOnClickListener(this);
            this.j.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: d */
    public void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            TextView textView = this.f16838h;
            String str = bVar.f58979f;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.f16836f.b(bVar);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            d.a.r0.b.g.b.g(this.k);
            d.a.s0.e1.j.c.c("c13753", this.n);
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f16835e == i2) {
            return;
        }
        d.a.r0.r.u.c d2 = d.a.r0.r.u.c.d(this.f16838h);
        d2.t(R.color.CAM_X0105);
        d2.x(R.dimen.T_X07);
        d2.y(R.string.F_X02);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        d.a.r0.b.g.b.h(this.k);
        this.f16835e = i2;
        d.a.r0.r.u.c d3 = d.a.r0.r.u.c.d(this.m);
        d3.n(R.string.J_X06);
        d3.f(R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
        }
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.n = str;
        }
    }
}
