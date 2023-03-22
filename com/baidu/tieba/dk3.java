package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.Key;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class dk3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.setTranslationX(0.0f);
            }
        }
    }

    public static void a(c72 c72Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, c72Var, context) == null) {
            b(c72Var, context, 2);
        }
    }

    public static void b(c72 c72Var, Context context, int i) {
        View b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65537, null, c72Var, context, i) == null) && c72Var != null && c72Var.k() >= i) {
            z62 j = c72Var.j(c72Var.k() - i);
            z62 m = c72Var.m();
            if (m != null && m.E0) {
                return;
            }
            float o = kl3.o(context) >> 2;
            if (j != null && (b0 = j.b0()) != null) {
                ObjectAnimator.ofFloat(b0, Key.TRANSLATION_X, -o, 0.0f).setDuration(300L).start();
            }
        }
    }

    public static void c(c72 c72Var, Context context) {
        View b0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, c72Var, context) == null) && c72Var != null && c72Var.k() >= 2) {
            z62 j = c72Var.j(c72Var.k() - 2);
            float o = kl3.o(context) >> 2;
            if (j != null && (b0 = j.b0()) != null) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b0, Key.TRANSLATION_X, 0.0f, -o);
                ofFloat.setDuration(300L).start();
                ofFloat.addListener(new a(b0));
            }
        }
    }

    public static void d(@NonNull rl4 rl4Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLII(65539, null, rl4Var, str, i, i2) != null) || rl4Var == null) {
            return;
        }
        char c = 65535;
        int hashCode = str.hashCode();
        if (hashCode != -1876181062) {
            if (hashCode != -983638536) {
                if (hashCode == 1528366175 && str.equals("showModalPage")) {
                    c = 1;
                }
            } else if (str.equals("navigateBack")) {
                c = 0;
            }
        } else if (str.equals("hideModalPage")) {
            c = 2;
        }
        if (c != 0) {
            if (c != 1 && c != 2) {
                rl4Var.i(i, i2);
                return;
            }
            return;
        }
        c72 V = gt2.U().V();
        z62 j = V.j(V.k() - 1);
        if (j != null && j.E0) {
            return;
        }
        rl4Var.i(i, i2);
    }
}
