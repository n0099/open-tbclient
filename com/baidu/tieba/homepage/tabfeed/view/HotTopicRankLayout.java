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
import c.a.o0.m.f;
import c.a.p0.q1.k.h.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class HotTopicRankLayout extends LinearLayout implements q, p<c>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public HotTopicTabRankListLayout f33478b;

    /* renamed from: c  reason: collision with root package name */
    public View f33479c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f33480d;

    /* renamed from: e  reason: collision with root package name */
    public View f33481e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f33482f;

    /* renamed from: g  reason: collision with root package name */
    public View f33483g;

    /* renamed from: h  reason: collision with root package name */
    public View f33484h;
    public LinearLayout i;
    public String j;
    public f<c.a.p0.q1.g.a.e.c> k;

    /* loaded from: classes5.dex */
    public class a implements f<c.a.p0.q1.g.a.e.c> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicRankLayout a;

        public a(HotTopicRankLayout hotTopicRankLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicRankLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hotTopicRankLayout;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.f
        /* renamed from: b */
        public void c(View view, c.a.p0.q1.g.a.e.c cVar, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, cVar, Integer.valueOf(i), Long.valueOf(j)}) != null) || cVar == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.m.f
        /* renamed from: d */
        public void a(View view, c.a.p0.q1.g.a.e.c cVar, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, cVar, Integer.valueOf(i), Long.valueOf(j)}) == null) || cVar == null) {
                return;
            }
            c.a.p0.q1.k.c.a("c13753", cVar, i + 1, this.a.j);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 3;
        this.k = new a(this);
        c();
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d038e, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f33480d = (TextView) findViewById(R.id.obfuscated_res_0x7f09221e);
            this.f33482f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fdb);
            this.f33481e = findViewById(R.id.obfuscated_res_0x7f0911e2);
            this.f33483g = findViewById(R.id.obfuscated_res_0x7f0907ff);
            this.f33484h = findViewById(R.id.obfuscated_res_0x7f0907f9);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906d7);
            this.f33479c = findViewById(R.id.obfuscated_res_0x7f092047);
            int f2 = n.f(getContext(), R.dimen.M_H_X004);
            int f3 = n.f(getContext(), R.dimen.M_H_X004);
            int f4 = n.f(getContext(), R.dimen.M_W_X005);
            this.f33479c.setPadding(f4, f2, f4, f3);
            ViewGroup.LayoutParams layoutParams = this.f33479c.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.f33479c.setLayoutParams(layoutParams);
            this.f33480d.setMaxLines(1);
            this.f33480d.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904f0);
            HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
            this.f33478b = hotTopicTabRankListLayout;
            hotTopicTabRankListLayout.setOnItemCoverListener(this.k);
            linearLayout.addView(this.f33478b);
            linearLayout.setPadding(0, 0, 0, f3);
            this.f33482f.setClickable(false);
            this.f33481e.setOnClickListener(this);
            this.f33482f.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.l.p
    /* renamed from: d */
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            TextView textView = this.f33480d;
            String str = cVar.f17520b;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.f33478b.b(cVar);
            this.f33483g.setVisibility(0);
            this.f33484h.setVisibility(8);
            HomeGroupUbsUIHelper.handleLine(this.f33483g);
            c.a.p0.q1.k.c.c("c13753", this.j);
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(this.f33480d);
        d2.v(R.color.CAM_X0105);
        d2.z(R.dimen.T_X07);
        d2.A(R.string.F_X02);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f33482f, R.drawable.obfuscated_res_0x7f080915, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        HomeGroupUbsUIHelper.handleLineColor(this.f33483g);
        this.a = i;
        c.a.o0.r.v.c d3 = c.a.o0.r.v.c.d(this.i);
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
            this.j = str;
        }
    }
}
