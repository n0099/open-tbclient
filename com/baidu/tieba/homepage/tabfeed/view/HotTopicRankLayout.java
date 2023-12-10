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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tieba.R;
import com.baidu.tieba.av4;
import com.baidu.tieba.cj8;
import com.baidu.tieba.ck8;
import com.baidu.tieba.homepage.hotTopic.tab.view.HotTopicTabRankListLayout;
import com.baidu.tieba.it;
import com.baidu.tieba.jt;
import com.baidu.tieba.se8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class HotTopicRankLayout extends LinearLayout implements jt, it<ck8>, View.OnClickListener {
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
    public av4<se8> k;

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements av4<se8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HotTopicRankLayout a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.av4
        /* renamed from: a */
        public void d(View view2, se8 se8Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, se8Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || se8Var == null) {
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
        @Override // com.baidu.tieba.av4
        /* renamed from: c */
        public void b(View view2, se8 se8Var, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, se8Var, Integer.valueOf(i), Long.valueOf(j)}) != null) || se8Var == null) {
                return;
            }
            cj8.a("c13753", se8Var, i + 1, this.a.j);
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
        b();
    }

    public void setTabCode(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.j = str;
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.group_title_layout, (ViewGroup) this, true);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.d = (TextView) findViewById(R.id.tv_title);
            this.f = (ImageView) findViewById(R.id.iv_into);
            this.e = findViewById(R.id.layout_into);
            this.g = findViewById(R.id.divider_line_top);
            this.h = findViewById(R.id.divider_line_bottom);
            this.i = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f090808);
            this.c = findViewById(R.id.title_layout);
            int dimens = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004);
            int dimens2 = BdUtilHelper.getDimens(getContext(), R.dimen.M_H_X004);
            int dimens3 = BdUtilHelper.getDimens(getContext(), R.dimen.M_W_X005);
            this.c.setPadding(dimens3, dimens, dimens3, dimens2);
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
            linearLayout.setPadding(0, 0, 0, dimens2);
            this.f.setClickable(false);
            this.e.setOnClickListener(this);
            this.f.setVisibility(8);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.it
    /* renamed from: c */
    public void onBindDataToView(ck8 ck8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ck8Var) == null) {
            TextView textView = this.d;
            String str = ck8Var.b;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            this.b.a(ck8Var);
            this.g.setVisibility(0);
            this.h.setVisibility(8);
            HomeGroupUbsUIHelper.handleLine(this.g);
            cj8.c("c13753", this.j);
        }
    }

    @Override // com.baidu.tieba.jt
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) && this.a != i) {
            EMManager.from(this.d).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X07).setTextStyle(R.string.F_X02);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f, R.drawable.icon_pure_list_arrow12_right_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
            HomeGroupUbsUIHelper.handleLineColor(this.g);
            this.a = i;
            EMManager.from(this.i).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0205);
        }
    }
}
