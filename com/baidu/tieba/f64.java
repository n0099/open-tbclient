package com.baidu.tieba;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@UiThread
/* loaded from: classes4.dex */
public class f64 implements g64 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public n64 b;
    public b c;
    public Handler d;
    public ViewGroup e;
    public int f;
    public boolean g;
    public ObjectAnimator h;
    public i64 i;

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f64 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f64 f64Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f64Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f64Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                int f = this.a.f();
                if (f > 0 && this.a.g) {
                    this.a.d.sendEmptyMessageDelayed(1, f);
                }
                this.a.k();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void b();

        void o();

        void u(int i);
    }

    public f64(@NonNull Context context, @NonNull i64 i64Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, i64Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.i = i64Var;
        j(i());
        h();
        b();
    }

    @NonNull
    public static f64 c(int i, @NonNull Context context, @NonNull i64 i64Var) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65538, null, i, context, i64Var)) == null) {
            if (i != 1) {
                if (i != 2) {
                    return new k64(context, i64Var);
                }
                return new m64(context, i64Var);
            }
            return new k64(context, i64Var);
        }
        return (f64) invokeILL.objValue;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e.setVisibility(8);
            s54.a(this.e, g());
        }
    }

    @Override // com.baidu.tieba.g64
    public void d(n64 n64Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, n64Var) == null) {
            this.b = n64Var;
        }
    }

    @Override // com.baidu.tieba.e64
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g = false;
            this.d.removeCallbacksAndMessages(null);
            s54.d(this.e);
        }
    }

    public final ObjectAnimator e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.e, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.2f, 6.0f), Keyframe.ofFloat(0.4f, -6.0f), Keyframe.ofFloat(0.6f, 6.0f), Keyframe.ofFloat(0.8f, -6.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            ofPropertyValuesHolder.setDuration(600L);
            return ofPropertyValuesHolder;
        }
        return (ObjectAnimator) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 5000;
        }
        return invokeV.intValue;
    }

    public final et2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            et2 et2Var = new et2();
            et2Var.l(o54.a(this.i.left) - this.f);
            et2Var.m(o54.a(this.i.top) - this.f);
            et2Var.n(-2);
            et2Var.j(-2);
            return et2Var;
        }
        return (et2) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.h = e();
            this.d = new a(this, Looper.getMainLooper());
        }
    }

    @Override // com.baidu.tieba.e64
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.g = false;
            this.d.removeMessages(1);
            this.e.setVisibility(8);
        }
    }

    @SuppressLint({"InflateParams"})
    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d083e, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final void j(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            this.f = (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070712);
            this.e = new FrameLayout(this.a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(o54.a(this.i.width), o54.a(this.i.height));
            int i = this.f;
            layoutParams.setMargins(i, i, i, i);
            this.e.setBackgroundColor(0);
            this.e.addView(view2, layoutParams);
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h.start();
        }
    }

    @Override // com.baidu.tieba.g64
    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && this.g) {
            this.d.removeMessages(1);
            if (z) {
                this.d.sendEmptyMessage(1);
            }
        }
    }

    @Override // com.baidu.tieba.e64
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.g = true;
            this.e.setVisibility(0);
            this.d.removeMessages(1);
            this.d.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.tieba.g64
    public void t(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.c = bVar;
        }
    }

    @Override // com.baidu.tieba.g64
    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            s54.f(this.e, g());
        }
    }
}
