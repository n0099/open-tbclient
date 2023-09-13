package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.nadcore.webpanel.PanelScrollView;
import com.baidu.nadcore.webpanel.model.AdData;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d91 extends PopupWindow implements j91, ViewTreeObserver.OnWindowFocusChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public AdImageView b;
    public ViewGroup c;
    public a91 d;
    public l91 e;
    public k91 f;

    /* loaded from: classes5.dex */
    public class a implements PanelScrollView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d91 a;

        public a(d91 d91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d91Var;
        }

        @Override // com.baidu.nadcore.webpanel.PanelScrollView.c
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.c();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements PanelScrollView.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d91 a;

        public b(d91 d91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d91Var;
        }

        @Override // com.baidu.nadcore.webpanel.PanelScrollView.d
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.f != null) {
                this.a.f.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l91 a;
        public final /* synthetic */ d91 b;

        public c(d91 d91Var, l91 l91Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d91Var, l91Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d91Var;
            this.a = l91Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.b.f != null) {
                if (!this.a.w()) {
                    fn0.a().a(new g91(8, this.b.e.a()));
                    return;
                }
                this.b.h();
                this.b.b.setVisibility(8);
                this.b.f.a();
            }
        }
    }

    public d91(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(R.style.obfuscated_res_0x7f1003f3);
        setClippingEnabled(true);
        setWidth(-1);
        setHeight(-1);
        setContentView(g(context, R.layout.nad_panel_pop_view));
    }

    public void i(l91 l91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, l91Var) == null) {
            this.e = l91Var;
            a91 a91Var = new a91((Activity) this.a.getContext(), (ViewGroup) this.a);
            this.d = a91Var;
            a91Var.f(l91Var);
            this.d.a(this);
            PanelScrollView b2 = this.d.b();
            if (b2 != null) {
                b2.setOnGestureScrollListener(new a(this));
                b2.setOnGestureSingleTapUpListener(new b(this));
            }
            m(l91Var);
        }
    }

    public d91(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = null;
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setAnimationStyle(R.style.obfuscated_res_0x7f1003f3);
        setClippingEnabled(true);
        setWidth(-1);
        setHeight(-1);
        setContentView(g(context, i));
    }

    public void j(@NonNull k91 k91Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, k91Var) == null) {
            this.f = k91Var;
        }
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && this.e.t()) {
            t91.a(this.a.getContext(), this);
        }
    }

    @Override // com.baidu.tieba.j91
    public void a(int i) {
        ClogBuilder.Page page;
        ClogBuilder.LogType logType;
        k91 k91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            if (this.e.q() && this.f != null) {
                fn0.a().a(new g91(8, this.e.a()));
                return;
            }
            if (this.e.v()) {
                page = ClogBuilder.Page.WELFAREWEB;
            } else {
                page = ClogBuilder.Page.NAD_POP_WEB_PANEL;
            }
            if (this.e.v()) {
                logType = ClogBuilder.LogType.REWARD_HALF_TAIL_SLIDE;
            } else {
                logType = ClogBuilder.LogType.NAVIDEO_POP_CLOSE;
            }
            s91.b(page, logType, String.valueOf(i), "", this.e.f());
            h();
            if (i == 0 && (k91Var = this.f) != null) {
                k91Var.d();
            }
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            try {
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace.length >= 2 && stackTrace[1] != null && "dispatchKeyEvent".equals(stackTrace[1].getMethodName())) {
                    if (this.e.u()) {
                        if (this.d != null) {
                            this.d.d("javascript:onAndroidBack()");
                        }
                    } else if (!this.d.g()) {
                        a(0);
                    }
                } else {
                    a(0);
                }
            } catch (Exception unused) {
                a(0);
            }
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            fn0.a().a(new g91(5, this.e.a()));
            this.d.e();
            this.a.getViewTreeObserver().removeOnWindowFocusChangeListener(this);
            if (this.e.p()) {
                this.c = t91.b(this.a.getContext(), this.c, false);
            }
            z81.b.c(false);
            z81.b.b(false);
            super.dismiss();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h();
        }
    }

    public final View g(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, context, i)) == null) {
            View inflate = LayoutInflater.from(context).inflate(i, (ViewGroup) null);
            this.a = inflate;
            this.b = (AdImageView) inflate.findViewById(R.id.top_right_icon);
            return this.a;
        }
        return (View) invokeLI.objValue;
    }

    public void k() {
        ClogBuilder.Page page;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.getViewTreeObserver().addOnWindowFocusChangeListener(this);
            if (this.e.t()) {
                t91.a(this.a.getContext(), this);
            }
            View.OnTouchListener c2 = this.d.c();
            if (c2 != null && !this.e.r()) {
                setTouchInterceptor(c2);
            }
            if (this.e.p()) {
                this.c = t91.b(this.a.getContext(), this.c, true);
            }
            fn0.a().a(new g91(7, this.d.b()));
            l(this.a.getContext(), ((Activity) this.a.getContext()).getWindow().getDecorView(), 80, 0, 0);
            z81.b.c(true);
            z81.b.b(false);
            if (this.e.v()) {
                page = ClogBuilder.Page.WELFAREWEB;
            } else {
                page = ClogBuilder.Page.NAD_POP_WEB_PANEL;
            }
            s91.b(page, ClogBuilder.LogType.FREE_SHOW, "", "", this.e.f());
        }
    }

    public final void l(Context context, View view2, int i, int i2, int i3) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{context, view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)}) == null) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                try {
                    showAtLocation(view2, i, i2, i3);
                    fn0.a().a(new g91(0, (AdData) null));
                } catch (Exception e) {
                    jb1.d(e);
                }
            }
        }
    }

    public final void m(l91 l91Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, l91Var) != null) || !l91Var.y()) {
            return;
        }
        if (l91Var.w()) {
            this.b.setImageResource(R.drawable.nad_reward_video_lp_down_arrow);
        } else {
            this.b.setImageResource(R.drawable.nad_reward_video_lp_close_btn);
        }
        this.b.setVisibility(0);
        this.b.setOnClickListener(new c(this, l91Var));
    }
}
