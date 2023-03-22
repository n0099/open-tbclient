package com.baidu.tieba;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class a42 extends e32<TextView, b42> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a42(@NonNull Context context, @NonNull b42 b42Var) {
        super(context, b42Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, b42Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (f32) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        g(4);
        this.i = new SwanAppComponentContainerView(context);
        this.j = new TextView(context);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.e32, com.baidu.tieba.g32, com.baidu.tieba.i32
    @NonNull
    /* renamed from: Z */
    public l42 k(@NonNull b42 b42Var, @NonNull b42 b42Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, b42Var, b42Var2)) == null) {
            l42 k = super.k(b42Var, b42Var2);
            if (!TextUtils.equals(b42Var.E, b42Var2.E) && (TextUtils.equals(b42Var.E, "scroll") || TextUtils.equals(b42Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(b42Var.E, b42Var2.E) || (TextUtils.equals(b42Var2.E, "scroll") && b42Var.D != b42Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (l42) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g32
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull b42 b42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, b42Var) == null) {
            if (i32.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (b42Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(b42Var);
            }
            ViewParent parent = textView.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(b42Var.k);
            gradientDrawable.setCornerRadius(b42Var.n);
            gradientDrawable.setStroke(b42Var.l, b42Var.m);
            ((View) parent).setBackground(gradientDrawable);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.g32
    /* renamed from: b0 */
    public void P(@NonNull View view2, @NonNull b42 b42Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, b42Var) == null) {
            if (i32.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (b42Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            super.P((View) parent, b42Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i32
    @NonNull
    /* renamed from: a0 */
    public TextView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, context)) == null) {
            return this.j;
        }
        return (TextView) invokeL.objValue;
    }

    @Override // com.baidu.tieba.i32
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, context)) == null) {
            return this.i;
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }
}
