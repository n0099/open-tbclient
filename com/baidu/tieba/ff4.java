package com.baidu.tieba;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.menu.BaseMenuView;
import com.baidu.swan.menu.MainMenuView;
import com.baidu.swan.menu.PopupWindow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ff4 extends PopupWindow implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View Q;
    public BaseMenuView R;
    public Context S;
    public View T;
    public MainMenuView U;
    public FrameLayout V;
    public xe4 W;
    public boolean X;
    public int Y;

    /* loaded from: classes4.dex */
    public class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ff4 a;

        public a(ff4 ff4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ff4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ff4Var;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                Context context = this.a.S;
                if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                    return;
                }
                ff4.super.r();
                ff4 ff4Var = this.a;
                BaseMenuView baseMenuView = ff4Var.R;
                if (baseMenuView != ff4Var.U) {
                    baseMenuView.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ff4(Context context, View view2, @Nullable xe4 xe4Var) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, view2, xe4Var};
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
        this.X = true;
        this.Y = 0;
        this.S = context;
        this.T = view2;
        this.W = xe4Var;
        D(false);
        F(true);
        K(true);
        C(new ColorDrawable(0));
        M(-1);
        G(-1);
        if (Build.VERSION.SDK_INT > 29) {
            H(true);
        }
        U();
    }

    public void W(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.Y = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            int id = view2.getId();
            if (id == R.id.obfuscated_res_0x7f0904ad || id == R.id.obfuscated_res_0x7f0915aa) {
                T(true);
            }
        }
    }

    public void S() {
        xe4 xe4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (xe4Var = this.W) != null) {
            xe4Var.a(this.U);
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.U.e();
        }
    }

    @Override // com.baidu.swan.menu.PopupWindow
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            T(true);
        }
    }

    public void T(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            if (!z) {
                super.r();
            } else if (!x()) {
            } else {
                ObjectAnimator c = ze4.c(this.Q);
                ObjectAnimator e = ze4.e(this.R);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.addListener(new a(this));
                animatorSet.playTogether(c, e);
                animatorSet.start();
            }
        }
    }

    public final void U() {
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.S).inflate(R.layout.obfuscated_res_0x7f0d008d, (ViewGroup) null);
            this.V = frameLayout;
            this.Q = frameLayout.findViewById(R.id.obfuscated_res_0x7f0915aa);
            this.U = (MainMenuView) this.V.findViewById(R.id.obfuscated_res_0x7f090189);
            if (bp4.d() && (this.S instanceof Activity)) {
                FrameLayout frameLayout2 = (FrameLayout) this.V.findViewById(R.id.obfuscated_res_0x7f0915f2);
                if (bp4.e((Activity) this.S)) {
                    b = bp4.a((Activity) this.S);
                } else {
                    b = (int) bp4.b((Activity) this.S);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b, -1);
                layoutParams.gravity = 17;
                if (frameLayout2 != null) {
                    frameLayout2.setLayoutParams(layoutParams);
                }
            }
            this.Q.setOnClickListener(this);
            this.U.setClickListener(this);
            this.U.setFitsSystemWindows(true);
            this.V.measure(0, 0);
            E(this.V);
        }
    }

    public void X(List<List<ef4>> list, View view2, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{list, view2, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            this.U.update(list, view2, z, i);
            Z();
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.Q.setAlpha(0.0f);
            MainMenuView mainMenuView = this.U;
            mainMenuView.setTranslationY(mainMenuView.getHeight());
            ObjectAnimator d = ze4.d(this.Q, this.U);
            ObjectAnimator b = ze4.b(this.U);
            ArrayList arrayList = new ArrayList();
            arrayList.add(d);
            arrayList.add(b);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.start();
        }
    }

    public final void Z() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || x()) {
            return;
        }
        S();
        this.U.f();
        this.R = this.U;
        if (this.X) {
            F(false);
        }
        Activity activity = (Activity) this.S;
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            O(this.T, 81, 0, 0);
            if (this.X) {
                v().setSystemUiVisibility(this.Y | 1024 | 4096);
                F(true);
                update();
            }
            Y();
        }
    }
}
