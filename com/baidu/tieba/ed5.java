package com.baidu.tieba;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ed5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public final View b;
    public final int c;
    public final boolean d;
    public ad5 e;

    public ed5(View view2) {
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
        this.a = -1;
        this.b = view2;
        this.c = hd5.a(view2.getContext());
        this.d = id5.c((Activity) view2.getContext());
    }

    public final ad5 a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            ad5 ad5Var = this.e;
            if (ad5Var != null) {
                return ad5Var;
            }
            if (view2 instanceof ad5) {
                ad5 ad5Var2 = (ad5) view2;
                this.e = ad5Var2;
                return ad5Var2;
            } else if (view2 instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    if (i < viewGroup.getChildCount()) {
                        ad5 a = a(viewGroup.getChildAt(i));
                        if (a != null) {
                            this.e = a;
                            return a;
                        }
                        i++;
                    } else {
                        return null;
                    }
                }
            } else {
                return null;
            }
        } else {
            return (ad5) invokeL.objValue;
        }
    }

    @TargetApi(16)
    public void b(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
            if (this.d && Build.VERSION.SDK_INT >= 16 && this.b.getFitsSystemWindows()) {
                Rect rect = new Rect();
                this.b.getWindowVisibleDisplayFrame(rect);
                i2 = rect.bottom - rect.top;
            }
            Log.d("KPSRootLayoutHandler", "onMeasure, width: " + i + " height: " + i2);
            if (i2 < 0) {
                return;
            }
            int i3 = this.a;
            if (i3 < 0) {
                this.a = i2;
                return;
            }
            int i4 = i3 - i2;
            if (i4 == 0) {
                Log.d("KPSRootLayoutHandler", "" + i4 + " == 0 break;");
            } else if (Math.abs(i4) == this.c) {
                Log.w("KPSRootLayoutHandler", String.format("offset just equal statusBar height %d", Integer.valueOf(i4)));
            } else {
                this.a = i2;
                ad5 a = a(this.b);
                if (a == null) {
                    Log.w("KPSRootLayoutHandler", "can't find the valid panel conflict layout, give up!");
                } else if (Math.abs(i4) < gd5.f(this.b.getContext())) {
                    Log.w("KPSRootLayoutHandler", "system bottom-menu-bar(such as HuaWei Mate7) causes layout changed");
                } else if (i4 > 0) {
                    a.handleHide();
                } else if (a.b() && a.isVisible()) {
                    a.handleShow();
                }
            }
        }
    }
}
