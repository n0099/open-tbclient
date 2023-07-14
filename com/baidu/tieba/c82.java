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
/* loaded from: classes5.dex */
public final class c82 extends g72<TextView, d82> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppComponentContainerView i;
    public TextView j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c82(@NonNull Context context, @NonNull d82 d82Var) {
        super(context, d82Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, d82Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (h72) objArr2[1]);
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
    @Override // com.baidu.tieba.g72, com.baidu.tieba.i72, com.baidu.tieba.k72
    @NonNull
    /* renamed from: Z */
    public n82 k(@NonNull d82 d82Var, @NonNull d82 d82Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, d82Var, d82Var2)) == null) {
            n82 k = super.k(d82Var, d82Var2);
            if (!TextUtils.equals(d82Var.E, d82Var2.E) && (TextUtils.equals(d82Var.E, "scroll") || TextUtils.equals(d82Var2.E, "scroll"))) {
                k.b(7);
            }
            if (!TextUtils.equals(d82Var.E, d82Var2.E) || (TextUtils.equals(d82Var2.E, "scroll") && d82Var.D != d82Var2.D)) {
                k.b(8);
            }
            return k;
        }
        return (n82) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i72
    /* renamed from: c0 */
    public void Q(@NonNull TextView textView, @NonNull d82 d82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, textView, d82Var) == null) {
            if (k72.h) {
                Log.d("Component-CoverView", "renderBackground");
            }
            if (d82Var.j == null) {
                return;
            }
            SwanAppComponentContainerView m = m();
            if (m != null) {
                m.setModel(d82Var);
            }
            ViewParent parent = textView.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(d82Var.k);
            gradientDrawable.setCornerRadius(d82Var.n);
            gradientDrawable.setStroke(d82Var.l, d82Var.m);
            ((View) parent).setBackground(gradientDrawable);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.i72
    /* renamed from: b0 */
    public void P(@NonNull View view2, @NonNull d82 d82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view2, d82Var) == null) {
            if (k72.h) {
                Log.d("Component-CoverView", "renderAlpha");
            }
            if (d82Var.j == null) {
                return;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View)) {
                return;
            }
            super.P((View) parent, d82Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k72
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

    @Override // com.baidu.tieba.k72
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
