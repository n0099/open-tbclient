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
public class if3 {
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

    public static void a(h22 h22Var, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, h22Var, context) == null) {
            b(h22Var, context, 2);
        }
    }

    public static void b(h22 h22Var, Context context, int i) {
        View V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, h22Var, context, i) == null) || h22Var == null || h22Var.k() < i) {
            return;
        }
        e22 j = h22Var.j(h22Var.k() - i);
        e22 m = h22Var.m();
        if (m == null || !m.D0) {
            float o = pg3.o(context) >> 2;
            if (j == null || (V = j.V()) == null) {
                return;
            }
            ObjectAnimator.ofFloat(V, Key.TRANSLATION_X, -o, 0.0f).setDuration(300L).start();
        }
    }

    public static void c(h22 h22Var, Context context) {
        View V;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65538, null, h22Var, context) == null) || h22Var == null || h22Var.k() < 2) {
            return;
        }
        e22 j = h22Var.j(h22Var.k() - 2);
        float o = pg3.o(context) >> 2;
        if (j == null || (V = j.V()) == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(V, Key.TRANSLATION_X, 0.0f, -o);
        ofFloat.setDuration(300L).start();
        ofFloat.addListener(new a(V));
    }

    public static void d(@NonNull wg4 wg4Var, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLII(65539, null, wg4Var, str, i, i2) == null) || wg4Var == null) {
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
            if (c == 1 || c == 2) {
                return;
            }
            wg4Var.i(i, i2);
            return;
        }
        h22 V = lo2.U().V();
        e22 j = V.j(V.k() - 1);
        if (j == null || !j.D0) {
            wg4Var.i(i, i2);
        }
    }
}
