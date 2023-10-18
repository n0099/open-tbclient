package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class i35 extends PopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h35 a;
    public int b;
    public int c;
    public int d;
    public View e;
    public View f;
    public Activity g;

    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i35 a;

        public a(i35 i35Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i35Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i35Var;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.e != null) {
                this.a.e();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i35(Activity activity) {
        super(activity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = activity;
        View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.keyboard_height_popupwindow, (ViewGroup) null, false);
        this.e = inflate;
        setContentView(inflate);
        GreyUtil.grey(this);
        setSoftInputMode(21);
        setInputMethodMode(1);
        this.f = activity.findViewById(16908290);
        setWidth(0);
        setHeight(-1);
        this.e.getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public void g(h35 h35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h35Var) == null) {
            this.a = h35Var;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
            dismiss();
        }
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g.getResources().getConfiguration().orientation;
        }
        return invokeV.intValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && !isShowing() && this.f.getWindowToken() != null) {
            setBackgroundDrawable(new ColorDrawable(0));
            hb.m(this, this.f, 0, 0, 0);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Point point = new Point();
            this.g.getWindowManager().getDefaultDisplay().getSize(point);
            Rect rect = new Rect();
            this.e.getWindowVisibleDisplayFrame(rect);
            int d = d();
            int i = point.y - rect.bottom;
            if (i == 0) {
                f(0, d);
            } else if (d == 1) {
                this.d = i;
                f(i, d);
            } else {
                this.c = i;
                f(i, d);
            }
        }
    }

    public final void f(int i, int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            if (i <= 0) {
                this.b = i;
                i3 = 0;
            } else {
                i3 = i - this.b;
            }
            h35 h35Var = this.a;
            if (h35Var != null) {
                h35Var.a(i3, i2);
            }
        }
    }
}
