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
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gs4;
import com.repackage.mi;
import com.repackage.oy;
import com.repackage.py;
import com.repackage.r07;
import com.repackage.rz6;
import com.repackage.vm4;
import com.repackage.zv6;
/* loaded from: classes3.dex */
public class HotTopicRankLayout extends LinearLayout implements py, oy<r07>, View.OnClickListener {
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
    public vm4<zv6> k;

    /* loaded from: classes3.dex */
    public class a implements vm4<zv6> {
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
        @Override // com.repackage.vm4
        /* renamed from: b */
        public void c(View view2, zv6 zv6Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, zv6Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || zv6Var == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.vm4
        /* renamed from: d */
        public void a(View view2, zv6 zv6Var, int i, long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view2, zv6Var, Integer.valueOf(i), Long.valueOf(j)}) == null) || zv6Var == null) {
                return;
            }
            rz6.a("c13753", zv6Var, i + 1, this.a.j);
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
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f09225a);
            this.f = (ImageView) findViewById(R.id.obfuscated_res_0x7f090fe3);
            this.e = findViewById(R.id.obfuscated_res_0x7f0911e7);
            this.g = findViewById(R.id.obfuscated_res_0x7f0907ff);
            this.h = findViewById(R.id.obfuscated_res_0x7f0907f9);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0906db);
            this.c = findViewById(R.id.obfuscated_res_0x7f09208a);
            int f = mi.f(getContext(), R.dimen.M_H_X004);
            int f2 = mi.f(getContext(), R.dimen.M_H_X004);
            int f3 = mi.f(getContext(), R.dimen.M_W_X005);
            this.c.setPadding(f3, f, f3, f2);
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.c.setLayoutParams(layoutParams);
            this.d.setMaxLines(1);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0904f5);
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
    @Override // com.repackage.oy
    /* renamed from: d */
    public void a(r07 r07Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, r07Var) == null) {
            TextView textView = this.d;
            String str = r07Var.b;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.b.b(r07Var);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            HomeGroupUbsUIHelper.handleLine(this.g);
            rz6.c("c13753", this.j);
        }
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        gs4 d = gs4.d(this.d);
        d.v(R.color.CAM_X0105);
        d.z(R.dimen.T_X07);
        d.A(R.string.F_X02);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.obfuscated_res_0x7f080933, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
        HomeGroupUbsUIHelper.handleLineColor(this.g);
        this.a = i;
        gs4 d2 = gs4.d(this.i);
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
