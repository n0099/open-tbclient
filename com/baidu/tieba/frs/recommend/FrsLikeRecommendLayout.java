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
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ix;
import com.repackage.ms4;
import com.repackage.on;
import com.repackage.qj8;
import com.repackage.vo6;
import com.repackage.wo6;
import com.repackage.xo6;
import com.repackage.yn;
import com.repackage.yo6;
import java.util.ArrayList;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class FrsLikeRecommendLayout extends ConstraintLayout implements ix {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public View b;
    public TextView c;
    public ImageView d;
    public BdTypeRecyclerView e;
    public vo6 f;
    public wo6 g;
    public ValueAnimator h;
    public xo6 i;
    public boolean j;
    public int k;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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

    private yn getItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) ? new yn() { // from class: com.repackage.so6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.repackage.yn
            public final void b(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, onVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    FrsLikeRecommendLayout.this.h(view2, onVar, bdUniqueId, viewGroup, i, j);
                }
            }
        } : (yn) invokeV.objValue;
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d032c, this);
            this.b = findViewById(R.id.obfuscated_res_0x7f091c1a);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090b6b);
            this.e = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090b6a);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b67);
            vo6 vo6Var = new vo6(getContext());
            this.f = vo6Var;
            vo6Var.setOnAdapterItemClickListener(getItemClickListener());
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

    public /* synthetic */ void h(View view2, on onVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, final int i, long j) {
        wo6 wo6Var;
        if (onVar instanceof qj8) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090b68) {
                wo6 wo6Var2 = this.g;
                if (wo6Var2 != null) {
                    wo6Var2.b((qj8) onVar);
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090a65 || (wo6Var = this.g) == null) {
            } else {
                wo6Var.c((qj8) onVar, i, new yo6() { // from class: com.repackage.uo6
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
        wo6 wo6Var = this.g;
        if (wo6Var != null) {
            wo6Var.d();
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

    @Override // com.repackage.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            TextView textView = this.c;
            if (textView != null) {
                ms4 d = ms4.d(textView);
                d.A(R.string.F_X02);
                d.v(R.color.CAM_X0101);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0622, null);
            }
            vo6 vo6Var = this.f;
            if (vo6Var != null) {
                vo6Var.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDetachedFromWindow();
            wo6 wo6Var = this.g;
            if (wo6Var != null) {
                wo6Var.a();
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
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.to6
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

    public void setHeightChangeListener(xo6 xo6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, xo6Var) == null) {
            this.i = xo6Var;
        }
    }

    public void setThemeColor(ThemeColorInfo themeColorInfo) {
        vo6 vo6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, themeColorInfo) == null) || (vo6Var = this.f) == null) {
            return;
        }
        vo6Var.v(themeColorInfo);
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
