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
import c.a.d.f.p.n;
import c.a.l.p;
import c.a.l.q;
import c.a.t0.b.g.b;
import c.a.t0.n.f;
import c.a.u0.p1.k.h.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class HotTopicRankLayout extends LinearLayout implements q, p<c>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f44728e;

    /* renamed from: f  reason: collision with root package name */
    public HotTopicTabRankListLayout f44729f;

    /* renamed from: g  reason: collision with root package name */
    public View f44730g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f44731h;

    /* renamed from: i  reason: collision with root package name */
    public View f44732i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f44733j;
    public View k;
    public View l;
    public LinearLayout m;
    public String n;
    public f<c.a.u0.p1.g.a.e.c> o;

    /* loaded from: classes12.dex */
    public class a implements f<c.a.u0.p1.g.a.e.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicRankLayout f44734e;

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
            this.f44734e = hotTopicRankLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.n.f
        /* renamed from: b */
        public void c(View view, c.a.u0.p1.g.a.e.c cVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, cVar, Integer.valueOf(i2), Long.valueOf(j2)}) != null) || cVar == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.n.f
        /* renamed from: d */
        public void a(View view, c.a.u0.p1.g.a.e.c cVar, int i2, long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, cVar, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || cVar == null) {
                return;
            }
            c.a.u0.p1.k.c.a("c13753", cVar, i2 + 1, this.f44734e.n);
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
        this.f44728e = 3;
        this.o = new a(this);
        b();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f44731h = (TextView) findViewById(R.id.tv_title);
            this.f44733j = (ImageView) findViewById(R.id.iv_into);
            this.f44732i = findViewById(R.id.layout_into);
            this.k = findViewById(R.id.divider_line_top);
            this.l = findViewById(R.id.divider_line_bottom);
            this.m = (LinearLayout) findViewById(R.id.content);
            this.f44730g = findViewById(R.id.title_layout);
            int f2 = n.f(getContext(), R.dimen.M_H_X004);
            int f3 = n.f(getContext(), R.dimen.M_H_X004);
            int f4 = n.f(getContext(), R.dimen.M_W_X005);
            this.f44730g.setPadding(f4, f2, f4, f3);
            ViewGroup.LayoutParams layoutParams = this.f44730g.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.f44730g.setLayoutParams(layoutParams);
            this.f44731h.setMaxLines(1);
            this.f44731h.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
            HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
            this.f44729f = hotTopicTabRankListLayout;
            hotTopicTabRankListLayout.setOnItemCoverListener(this.o);
            linearLayout.addView(this.f44729f);
            linearLayout.setPadding(0, 0, 0, f3);
            this.f44733j.setClickable(false);
            this.f44732i.setOnClickListener(this);
            this.f44733j.setVisibility(8);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || this.f44728e == i2) {
            return;
        }
        c.a.t0.s.v.c d2 = c.a.t0.s.v.c.d(this.f44731h);
        d2.v(R.color.CAM_X0105);
        d2.z(R.dimen.T_X07);
        d2.A(R.string.F_X02);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f44733j, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        b.j(this.k);
        this.f44728e = i2;
        c.a.t0.s.v.c d3 = c.a.t0.s.v.c.d(this.m);
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
    @Override // c.a.l.p
    public void onBindDataToView(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            TextView textView = this.f44731h;
            String str = cVar.f20849f;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.f44729f.bindData(cVar);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            b.i(this.k);
            c.a.u0.p1.k.c.c("c13753", this.n);
        }
    }
}
