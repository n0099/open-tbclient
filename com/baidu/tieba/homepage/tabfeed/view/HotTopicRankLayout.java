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
import b.a.e.e.p.l;
import b.a.l.p;
import b.a.l.q;
import b.a.q0.n.f;
import b.a.r0.h1.f.a.e.c;
import b.a.r0.h1.j.h.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class HotTopicRankLayout extends LinearLayout implements q, p<b>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f49800e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabRankListLayout f49801f;

    /* renamed from: g  reason: collision with root package name */
    public View f49802g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f49803h;

    /* renamed from: i  reason: collision with root package name */
    public View f49804i;
    public ImageView j;
    public View k;
    public View l;
    public LinearLayout m;
    public String n;
    public f<c> o;

    /* loaded from: classes9.dex */
    public class a implements f<c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicRankLayout f49805e;

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
            this.f49805e = hotTopicRankLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.f
        /* renamed from: b */
        public void c(View view, c cVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, cVar, Integer.valueOf(i2), Long.valueOf(j)}) != null) || cVar == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.n.f
        /* renamed from: d */
        public void a(View view, c cVar, int i2, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, cVar, Integer.valueOf(i2), Long.valueOf(j)}) == null) || cVar == null) {
                return;
            }
            b.a.r0.h1.j.c.a("c13753", cVar, i2 + 1, this.f49805e.n);
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
        this.f49800e = 3;
        this.o = new a(this);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f49803h = (TextView) findViewById(R.id.tv_title);
            this.j = (ImageView) findViewById(R.id.iv_into);
            this.f49804i = findViewById(R.id.layout_into);
            this.k = findViewById(R.id.divider_line_top);
            this.l = findViewById(R.id.divider_line_bottom);
            this.m = (LinearLayout) findViewById(R.id.content);
            this.f49802g = findViewById(R.id.title_layout);
            int g2 = l.g(getContext(), R.dimen.M_H_X004);
            int g3 = l.g(getContext(), R.dimen.M_H_X004);
            int g4 = l.g(getContext(), R.dimen.M_W_X005);
            this.f49802g.setPadding(g4, g2, g4, g3);
            ViewGroup.LayoutParams layoutParams = this.f49802g.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.f49802g.setLayoutParams(layoutParams);
            this.f49803h.setMaxLines(1);
            this.f49803h.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
            HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
            this.f49801f = hotTopicTabRankListLayout;
            hotTopicTabRankListLayout.setOnItemCoverListener(this.o);
            linearLayout.addView(this.f49801f);
            linearLayout.setPadding(0, 0, 0, g3);
            this.j.setClickable(false);
            this.f49804i.setOnClickListener(this);
            this.j.setVisibility(8);
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f49800e == i2) {
            return;
        }
        b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.f49803h);
        d2.v(R.color.CAM_X0105);
        d2.z(R.dimen.T_X07);
        d2.A(R.string.F_X02);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        b.a.q0.b.g.b.j(this.k);
        this.f49800e = i2;
        b.a.q0.s.u.c d3 = b.a.q0.s.u.c.d(this.m);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            TextView textView = this.f49803h;
            String str = bVar.f17563f;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.f49801f.bindData(bVar);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            b.a.q0.b.g.b.i(this.k);
            b.a.r0.h1.j.c.c("c13753", this.n);
        }
    }
}
