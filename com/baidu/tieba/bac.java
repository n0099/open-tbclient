package com.baidu.tieba;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.baidu.searchbox.download.apkcheck.ApkCheckUBCManagerKt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bac {
    public static /* synthetic */ Interceptable $ic;
    public static Point a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947639685, "Lcom/baidu/tieba/bac;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947639685, "Lcom/baidu/tieba/bac;");
                return;
            }
        }
        a = new Point();
    }

    public static Point a(Context context, Point point) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, point)) == null) {
            Point point2 = a;
            if (point2 != null && point2.x > 0 && point2.y > 0) {
                if (point == null) {
                    point = new Point();
                }
                Point point3 = a;
                point.x = point3.x;
                point.y = point3.y;
                return point;
            }
            WindowManager windowManager = (WindowManager) context.getSystemService(ApkCheckUBCManagerKt.VALUE_WINDOW);
            if (point == null) {
                point = new Point();
            }
            if (Build.VERSION.SDK_INT >= 17) {
                windowManager.getDefaultDisplay().getRealSize(point);
            } else {
                windowManager.getDefaultDisplay().getSize(point);
            }
            if (point.x > 0 && point.y > 0) {
                if (a == null) {
                    a = new Point();
                }
                Point point4 = a;
                point4.x = point.x;
                point4.y = point.y;
            }
            return point;
        }
        return (Point) invokeLL.objValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return a(context, null).x;
        }
        return invokeL.intValue;
    }
}
