package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f05 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public View b;
    public ViewGroup c;
    public View d;
    public TextView e;
    public WindowManager f;
    public WindowManager.LayoutParams g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;
    public int m;
    public int n;
    public Drawable o;
    public View.OnClickListener p;
    public final Runnable q;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f05 a;

        public a(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f05Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    public f05(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 1.0f;
        this.k = 5000;
        this.q = new a(this);
        if (activity == null) {
            return;
        }
        this.a = activity;
        this.n = hi.g(activity, R.dimen.tbds114);
        this.l = hi.g(activity, R.dimen.tbds84);
        this.m = hi.g(activity, R.dimen.tbds44);
        this.i = hi.g(activity, R.dimen.tbds222);
        this.h = hi.g(activity, R.dimen.tbds29);
        View inflate = LayoutInflater.from(activity).inflate(R.layout.text_toast_layout, (ViewGroup) null);
        this.c = (ViewGroup) inflate.findViewById(R.id.layout_container);
        this.d = inflate.findViewById(R.id.obfuscated_res_0x7f090328);
        this.e = (TextView) inflate.findViewById(R.id.toast_tv);
        this.b = inflate;
        this.d.setBackgroundDrawable(b());
        this.e.setMaxLines(1);
        this.e.setGravity(17);
        this.e.setTextSize(0, hi.g(activity, R.dimen.tbfontsize40));
        this.e.setTextColor(this.a.getResources().getColor(R.color.CAM_X0101));
        TextView textView = this.e;
        int i3 = this.m;
        textView.setPadding(i3, 0, i3, 0);
        this.f = (WindowManager) this.a.getSystemService("window");
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.g = layoutParams;
        layoutParams.width = hi.l(this.a) - (this.h * 2);
        WindowManager.LayoutParams layoutParams2 = this.g;
        layoutParams2.height = this.n;
        layoutParams2.type = 1000;
        layoutParams2.format = -3;
        layoutParams2.windowAnimations = R.style.obfuscated_res_0x7f1002ae;
        layoutParams2.flags = 262152;
        layoutParams2.gravity = 81;
        layoutParams2.y = d();
        this.g.alpha = this.j;
    }

    public static f05 f(Activity activity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, activity, str)) == null) {
            f05 f05Var = new f05(activity);
            f05Var.a(str);
            return f05Var;
        }
        return (f05) invokeLL.objValue;
    }

    public final f05 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                String g = dq5.g(str, 34);
                int w = hi.w(this.e.getPaint(), g);
                ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                layoutParams.width = w + (this.m * 2);
                this.c.setLayoutParams(layoutParams);
                this.e.setText(g);
            }
            return this;
        }
        return (f05) invokeL.objValue;
    }

    public final Drawable b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.o == null) {
                this.o = c();
            }
            return this.o;
        }
        return (Drawable) invokeV.objValue;
    }

    public final int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.i + UtilHelper.getNavigationBarHeight(this.a);
        }
        return invokeV.intValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            jg.a().removeCallbacks(this.q);
            if (this.b.getWindowToken() != null) {
                this.f.removeView(this.b);
            }
        }
    }

    public final GradientDrawable c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{w38.b("#FF722B"), w38.b("#FF2b5D")});
            gradientDrawable.setCornerRadius(this.l);
            return gradientDrawable;
        }
        return (GradientDrawable) invokeV.objValue;
    }

    public f05 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            jg.a().removeCallbacks(this.q);
            View view2 = this.b;
            if (view2 != null && view2.getWindowToken() != null) {
                this.f.removeView(this.b);
            }
            this.f.addView(this.b, this.g);
            jg.a().postDelayed(this.q, this.k);
            return this;
        }
        return (f05) invokeV.objValue;
    }

    public f05 g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (i > 0) {
                this.k = i * 1000;
            }
            return this;
        }
        return (f05) invokeI.objValue;
    }

    public void h(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, onClickListener) == null) {
            this.p = onClickListener;
        }
    }

    public void i(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            this.c.setTag(obj);
            this.c.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            View.OnClickListener onClickListener = this.p;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
            e();
        }
    }
}
