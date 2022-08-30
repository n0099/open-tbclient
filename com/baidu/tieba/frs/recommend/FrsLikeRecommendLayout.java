package com.baidu.tieba.frs.recommend;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.dp6;
import com.baidu.tieba.ep6;
import com.baidu.tieba.fp6;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.tieba.gp6;
import com.baidu.tieba.jx;
import com.baidu.tieba.os4;
import com.baidu.tieba.pn;
import com.baidu.tieba.xj8;
import com.baidu.tieba.zn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class FrsLikeRecommendLayout extends ConstraintLayout implements jx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public View b;
    public TextView c;
    public ImageView d;
    public BdTypeRecyclerView e;
    public dp6 f;
    public ep6 g;
    public ValueAnimator h;
    public fp6 i;
    public boolean j;
    public int k;

    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsLikeRecommendLayout a;

        public a(FrsLikeRecommendLayout frsLikeRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsLikeRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsLikeRecommendLayout;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.j = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.j = false;
                this.a.setVisibility(8);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.a.j = true;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsLikeRecommendLayout a;

        public b(FrsLikeRecommendLayout frsLikeRecommendLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsLikeRecommendLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = frsLikeRecommendLayout;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (this.a.b == null || this.a.b.getLayoutParams() == null) {
                    return;
                }
                this.a.k = intValue;
                if (this.a.i != null) {
                    this.a.i.a(intValue);
                }
                this.a.b.getLayoutParams().height = intValue;
                this.a.b.requestLayout();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendLayout(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private zn getItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new zn() { // from class: com.baidu.tieba.ap6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.zn
            public final void b(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, pnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    FrsLikeRecommendLayout.this.h(view2, pnVar, bdUniqueId, viewGroup, i, j);
                }
            }
        } : (zn) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.j) {
            return;
        }
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.h.removeAllUpdateListeners();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.a, 0);
        this.h = ofInt;
        ofInt.setInterpolator(new LinearInterpolator());
        this.h.addListener(new a(this));
        this.h.addUpdateListener(new b(this));
        this.h.start();
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e();
        }
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d032d, this);
            this.b = findViewById(R.id.obfuscated_res_0x7f091c1c);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090b6c);
            this.e = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090b6b);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b68);
            dp6 dp6Var = new dp6(getContext());
            this.f = dp6Var;
            dp6Var.setOnAdapterItemClickListener(getItemClickListener());
            BdTypeRecyclerView bdTypeRecyclerView = this.e;
            if (bdTypeRecyclerView != null) {
                bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
                this.e.addItemDecoration(new FrsLikeRecommendDecoration());
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f);
                this.e.a(arrayList);
            }
        }
    }

    public int getCurrentHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
    }

    public /* synthetic */ void h(View view2, pn pnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, final int i, long j) {
        ep6 ep6Var;
        if (pnVar instanceof xj8) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090b69) {
                ep6 ep6Var2 = this.g;
                if (ep6Var2 != null) {
                    ep6Var2.b((xj8) pnVar);
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090a66 || (ep6Var = this.g) == null) {
            } else {
                ep6Var.c((xj8) pnVar, i, new gp6() { // from class: com.baidu.tieba.cp6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                });
            }
        }
    }

    public /* synthetic */ void i(View.OnClickListener onClickListener, View view2) {
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
        ep6 ep6Var = this.g;
        if (ep6Var != null) {
            ep6Var.d();
        }
    }

    public void j() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (valueAnimator = this.h) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.h.removeAllUpdateListeners();
    }

    @Override // com.baidu.tieba.jx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            TextView textView = this.c;
            if (textView != null) {
                os4 d = os4.d(textView);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0101);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0622, null);
            }
            dp6 dp6Var = this.f;
            if (dp6Var != null) {
                dp6Var.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            ep6 ep6Var = this.g;
            if (ep6Var != null) {
                ep6Var.a();
            }
            j();
        }
    }

    public void setCloseListener(final View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) || (imageView = this.d) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.bp6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    FrsLikeRecommendLayout.this.i(onClickListener, view2);
                }
            }
        });
    }

    public void setHeightChangeListener(fp6 fp6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fp6Var) == null) {
            this.i = fp6Var;
        }
    }

    public void setThemeColor(ThemeColorInfo themeColorInfo) {
        dp6 dp6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, themeColorInfo) == null) || (dp6Var = this.f) == null) {
            return;
        }
        dp6Var.v(themeColorInfo);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsLikeRecommendLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.a = UtilHelper.getDimenPixelSize(R.dimen.tbds600);
        g(context);
    }
}
