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
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.a37;
import com.baidu.tieba.a47;
import com.baidu.tieba.dp4;
import com.baidu.tieba.ej;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.iz6;
import com.baidu.tieba.uu4;
import com.baidu.tieba.wx;
import com.baidu.tieba.xx;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class HotTopicRankLayout extends LinearLayout implements xx, wx<a47>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public HotTopicTabRankListLayout b;
    public View c;
    public TextView d;
    public View e;
    public ImageView f;
    public View g;
    public View h;
    public LinearLayout i;
    public String j;
    public dp4<iz6> k;

    /* loaded from: classes4.dex */
    public class a implements dp4<iz6> {
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
        @Override // com.baidu.tieba.dp4
        /* renamed from: a */
        public void d(View view2, iz6 iz6Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, iz6Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || iz6Var == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.dp4
        /* renamed from: b */
        public void c(View view2, iz6 iz6Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, iz6Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || iz6Var == null) {
                return;
            }
            a37.a("c13753", iz6Var, i + 1, this.a.j);
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
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0385, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f092417);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f091010);
            this.e = findViewById(R.id.obfuscated_res_0x7f091294);
            this.g = findViewById(R.id.obfuscated_res_0x7f090817);
            this.h = findViewById(R.id.obfuscated_res_0x7f090811);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906e3);
            this.c = findViewById(R.id.obfuscated_res_0x7f09222f);
            int f = ej.f(getContext(), R.dimen.M_H_X004);
            int f2 = ej.f(getContext(), R.dimen.M_H_X004);
            int f3 = ej.f(getContext(), R.dimen.M_W_X005);
            this.c.setPadding(f3, f, f3, f2);
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.c.setLayoutParams(layoutParams);
            this.d.setMaxLines(1);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904fb);
            HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
            this.b = hotTopicTabRankListLayout;
            hotTopicTabRankListLayout.setOnItemCoverListener(this.k);
            linearLayout.addView(this.b);
            linearLayout.setPadding(0, 0, 0, f2);
            this.f.setClickable(false);
            this.e.setOnClickListener(this);
            this.f.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.wx
    /* renamed from: d */
    public void a(a47 a47Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a47Var) == null) {
            TextView textView = this.d;
            String str = a47Var.b;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.b.b(a47Var);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            HomeGroupUbsUIHelper.handleLine(this.g);
            a37.c("c13753", this.j);
        }
    }

    @Override // com.baidu.tieba.xx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        uu4 d = uu4.d(this.d);
        d.v(R.color.CAM_X0105);
        d.z(R.dimen.T_X07);
        d.A(R.string.F_X02);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f08096a, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        HomeGroupUbsUIHelper.handleLineColor(this.g);
        this.a = i;
        uu4 d2 = uu4.d(this.i);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0205);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.j = str;
        }
    }
}
