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
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.recommend.FrsLikeRecommendLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cl6;
import com.repackage.cx;
import com.repackage.dl6;
import com.repackage.fl6;
import com.repackage.gl6;
import com.repackage.jn;
import com.repackage.of8;
import com.repackage.tn;
import com.repackage.wq4;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public class FrsLikeRecommendLayout extends ConstraintLayout implements cx {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final int a;
    public View b;
    public TextView c;
    public ImageView d;
    public BdTypeRecyclerView e;
    public cl6 f;
    public dl6 g;
    public ValueAnimator h;
    public fl6 i;
    public boolean j;
    public List<of8> k;
    public int l;

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
                if (ListUtils.isEmpty(this.a.k)) {
                    return;
                }
                this.a.e.setData(this.a.k);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                this.a.setVisibility(0);
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
                this.a.l = intValue;
                if (this.a.i != null) {
                    this.a.i.a(intValue);
                }
                this.a.b.getLayoutParams().height = intValue;
                this.a.b.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsLikeRecommendLayout a;

        public c(FrsLikeRecommendLayout frsLikeRecommendLayout) {
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
    public class d implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ FrsLikeRecommendLayout a;

        public d(FrsLikeRecommendLayout frsLikeRecommendLayout) {
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
                this.a.l = intValue;
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

    private tn getItemClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) ? new tn() { // from class: com.repackage.zk6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.repackage.tn
            public final void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) {
                    FrsLikeRecommendLayout.this.l(view2, jnVar, bdUniqueId, viewGroup, i, j);
                }
            }
        } : (tn) invokeV.objValue;
    }

    public final void g() {
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
        this.h.addListener(new c(this));
        this.h.addUpdateListener(new d(this));
        this.h.start();
    }

    public int getCurrentHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.l : invokeV.intValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.j) {
            return;
        }
        ValueAnimator valueAnimator = this.h;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.h.removeAllUpdateListeners();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.a);
        this.h = ofInt;
        ofInt.setInterpolator(new LinearInterpolator());
        this.h.addListener(new a(this));
        this.h.addUpdateListener(new b(this));
        this.h.start();
    }

    public void i(@NonNull TbPageContext<?> tbPageContext, @NonNull String str, @NonNull List<of8> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, tbPageContext, str, list) == null) || this.e == null || ListUtils.isEmpty(list)) {
            return;
        }
        dl6 dl6Var = new dl6(tbPageContext, str);
        this.g = dl6Var;
        dl6Var.l(list.size());
        this.k = list;
        h();
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            g();
        }
    }

    public final void k(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d032a, this);
            this.b = findViewById(R.id.obfuscated_res_0x7f091ac5);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090b3f);
            this.e = (BdTypeRecyclerView) findViewById(R.id.obfuscated_res_0x7f090b3e);
            this.d = (ImageView) findViewById(R.id.obfuscated_res_0x7f090b3b);
            cl6 cl6Var = new cl6(getContext());
            this.f = cl6Var;
            cl6Var.V(getItemClickListener());
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

    public /* synthetic */ void l(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, final int i, long j) {
        dl6 dl6Var;
        if (jnVar instanceof of8) {
            if (view2.getId() == R.id.obfuscated_res_0x7f090b3c) {
                dl6 dl6Var2 = this.g;
                if (dl6Var2 != null) {
                    dl6Var2.g((of8) jnVar);
                }
            } else if (view2.getId() != R.id.obfuscated_res_0x7f090a3a || (dl6Var = this.g) == null) {
            } else {
                dl6Var.h((of8) jnVar, i, new gl6() { // from class: com.repackage.bl6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.repackage.gl6
                    public final void a() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            FrsLikeRecommendLayout.this.m(i);
                        }
                    }
                });
            }
        }
    }

    public /* synthetic */ void n(View.OnClickListener onClickListener, View view2) {
        if (onClickListener != null) {
            onClickListener.onClick(view2);
        }
        dl6 dl6Var = this.g;
        if (dl6Var != null) {
            dl6Var.i();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: o */
    public final void m(int i) {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || (bdTypeRecyclerView = this.e) == null || this.f == null) {
            return;
        }
        jn C = bdTypeRecyclerView.C(i);
        if (C instanceof of8) {
            ((of8) C).e = true;
            this.f.H();
        }
    }

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i) == null) {
            TextView textView = this.c;
            if (textView != null) {
                wq4 d2 = wq4.d(textView);
                d2.A(R.string.F_X02);
                d2.v(R.color.CAM_X0101);
            }
            ImageView imageView = this.d;
            if (imageView != null) {
                WebPManager.setPureDrawable(imageView, R.drawable.icon_pure_card_close22, R.color.CAM_X0622, null);
            }
            cl6 cl6Var = this.f;
            if (cl6Var != null) {
                cl6Var.H();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onDetachedFromWindow();
            dl6 dl6Var = this.g;
            if (dl6Var != null) {
                dl6Var.d();
            }
            q();
        }
    }

    public void q() {
        ValueAnimator valueAnimator;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (valueAnimator = this.h) == null) {
            return;
        }
        valueAnimator.removeAllListeners();
        this.h.removeAllUpdateListeners();
    }

    public void setCloseListener(final View.OnClickListener onClickListener) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, onClickListener) == null) || (imageView = this.d) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.repackage.al6
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    FrsLikeRecommendLayout.this.n(onClickListener, view2);
                }
            }
        });
    }

    public void setHeightChangeListener(fl6 fl6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fl6Var) == null) {
            this.i = fl6Var;
        }
    }

    public void setThemeColor(ThemeColorInfo themeColorInfo) {
        cl6 cl6Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, themeColorInfo) == null) || (cl6Var = this.f) == null) {
            return;
        }
        cl6Var.c0(themeColorInfo);
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
        k(context);
    }
}
