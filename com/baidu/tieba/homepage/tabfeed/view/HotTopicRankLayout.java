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
import com.baidu.tieba.d85;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.i05;
import com.baidu.tieba.o38;
import com.baidu.tieba.p78;
import com.baidu.tieba.p88;
import com.baidu.tieba.ry;
import com.baidu.tieba.sy;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HotTopicRankLayout extends LinearLayout implements sy, ry<p88>, View.OnClickListener {
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
    public i05<o38> k;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements i05<o38> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicRankLayout a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.i05
        /* renamed from: a */
        public void c(View view2, o38 o38Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, o38Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || o38Var == null) {
            }
        }

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
        @Override // com.baidu.tieba.i05
        /* renamed from: b */
        public void d(View view2, o38 o38Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, o38Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || o38Var == null) {
                return;
            }
            p78.a("c13753", o38Var, i + 1, this.a.j);
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

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.j = str;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.d = (TextView) findViewById(R.id.tv_title);
            this.f = (ImageView) findViewById(R.id.iv_into);
            this.e = findViewById(R.id.layout_into);
            this.g = findViewById(R.id.divider_line_top);
            this.h = findViewById(R.id.divider_line_bottom);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f0907b2);
            this.c = findViewById(R.id.title_layout);
            int g = yi.g(getContext(), R.dimen.M_H_X004);
            int g2 = yi.g(getContext(), R.dimen.M_H_X004);
            int g3 = yi.g(getContext(), R.dimen.M_W_X005);
            this.c.setPadding(g3, g, g3, g2);
            ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            this.c.setLayoutParams(layoutParams);
            this.d.setMaxLines(1);
            this.d.setEllipsize(TextUtils.TruncateAt.END);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.card_container);
            HotTopicTabRankListLayout hotTopicTabRankListLayout = new HotTopicTabRankListLayout(getContext());
            this.b = hotTopicTabRankListLayout;
            hotTopicTabRankListLayout.setOnItemCoverListener(this.k);
            linearLayout.addView(this.b);
            linearLayout.setPadding(0, 0, 0, g2);
            this.f.setClickable(false);
            this.e.setOnClickListener(this);
            this.f.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ry
    /* renamed from: d */
    public void b(p88 p88Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, p88Var) == null) {
            TextView textView = this.d;
            String str = p88Var.b;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.b.a(p88Var);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            HomeGroupUbsUIHelper.handleLine(this.g);
            p78.c("c13753", this.j);
        }
    }

    @Override // com.baidu.tieba.sy
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.a != i) {
            d85 d = d85.d(this.d);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X07);
            d.D(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            HomeGroupUbsUIHelper.handleLineColor(this.g);
            this.a = i;
            d85 d2 = d85.d(this.i);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0205);
        }
    }
}
