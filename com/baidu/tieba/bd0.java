package com.baidu.tieba;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class bd0 {
    public static /* synthetic */ Interceptable $ic;
    public static final ThreadLocal<Matrix> a;
    public static final ThreadLocal<RectF> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947640987, "Lcom/baidu/tieba/bd0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947640987, "Lcom/baidu/tieba/bd0;");
                return;
            }
        }
        a = new ThreadLocal<>();
        b = new ThreadLocal<>();
    }

    public static void a(ViewGroup viewGroup, View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, viewGroup, view2, rect) == null) {
            rect.set(0, 0, view2.getWidth(), view2.getHeight());
            c(viewGroup, view2, rect);
        }
    }

    public static void b(ViewParent viewParent, View view2, Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, viewParent, view2, matrix) == null) {
            ViewParent parent = view2.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                View view3 = (View) parent;
                b(viewParent, view3, matrix);
                matrix.preTranslate(-view3.getScrollX(), -view3.getScrollY());
            }
            matrix.preTranslate(view2.getLeft(), view2.getTop());
            if (!view2.getMatrix().isIdentity()) {
                matrix.preConcat(view2.getMatrix());
            }
        }
    }

    public static void c(ViewGroup viewGroup, View view2, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, viewGroup, view2, rect) == null) {
            Matrix matrix = a.get();
            if (matrix == null) {
                matrix = new Matrix();
                a.set(matrix);
            } else {
                matrix.reset();
            }
            b(viewGroup, view2, matrix);
            RectF rectF = b.get();
            if (rectF == null) {
                rectF = new RectF();
                b.set(rectF);
            }
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }
    }
}
