package com.baidu.tieba;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.res.ui.SwanAppScrollView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e03 extends zz2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public a b;

    /* loaded from: classes3.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;
        public final e03 b;
        public Context c;
        public boolean d;
        public int e;

        /* renamed from: com.baidu.tieba.e03$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class View$OnClickListenerC0237a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public View$OnClickListenerC0237a(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.e(-1);
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -1);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ DialogInterface.OnClickListener b;
            public final /* synthetic */ a c;

            public b(a aVar, int i, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i), onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = i;
                this.b = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.c.b.e(this.a);
                    this.c.b.dismiss();
                    this.b.onClick(this.c.b, this.a);
                }
            }
        }

        /* loaded from: classes3.dex */
        public class c implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public c(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.e(-2);
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -2);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class d implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DialogInterface.OnClickListener a;
            public final /* synthetic */ a b;

            public d(a aVar, DialogInterface.OnClickListener onClickListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, onClickListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = onClickListener;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                    this.b.b.e(-3);
                    this.b.b.dismiss();
                    DialogInterface.OnClickListener onClickListener = this.a;
                    if (onClickListener != null) {
                        onClickListener.onClick(this.b.b, -3);
                    }
                }
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-884817852, "Lcom/baidu/tieba/e03$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-884817852, "Lcom/baidu/tieba/e03$a;");
            }
        }

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.d = false;
            e03 h = h(context);
            this.b = h;
            h.f(this);
            this.a = new b((ViewGroup) this.b.getWindow().getDecorView());
            this.c = context;
            this.e = context.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070123);
        }

        public final void A() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0907b4);
                this.a.t.setLayoutParams(layoutParams);
            }
        }

        public a B(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, onClickListener)) == null) {
                C(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a C(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.f.setVisibility(8);
                    if (this.a.e.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.f.setVisibility(0);
                if (this.a.e.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.f.setText(charSequence);
                this.a.f.setOnClickListener(new c(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a D(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                G(this.c.getResources().getColor(i));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a E(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, str, i)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        G(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException e) {
                        if (e03.c) {
                            e.printStackTrace();
                        }
                    }
                }
                if (i > 0) {
                    D(i);
                }
                return this;
            }
            return (a) invokeLI.objValue;
        }

        public a F(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.a.y = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a G(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.a.x = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a H(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048583, this, i, onClickListener)) == null) {
                I(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a I(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, onClickListener)) == null) {
                this.a.g.setVisibility(0);
                if (this.a.e.getVisibility() == 0) {
                    this.a.j.setVisibility(0);
                }
                this.a.g.setText(charSequence);
                this.a.g.setOnClickListener(new d(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a J(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
                this.a.B.setVisibility(z ? 0 : 8);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a K(DialogInterface.OnCancelListener onCancelListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, onCancelListener)) == null) {
                this.a.l = onCancelListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a L(DialogInterface.OnDismissListener onDismissListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, onDismissListener)) == null) {
                this.a.m = onDismissListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a M(DialogInterface.OnKeyListener onKeyListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, onKeyListener)) == null) {
                this.a.p = onKeyListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a N(DialogInterface.OnShowListener onShowListener) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, onShowListener)) == null) {
                this.a.n = onShowListener;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a O(int i, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048590, this, i, onClickListener)) == null) {
                P(this.c.getText(i), onClickListener);
                return this;
            }
            return (a) invokeIL.objValue;
        }

        public a P(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, charSequence, onClickListener)) == null) {
                if (TextUtils.isEmpty(charSequence)) {
                    this.a.e.setVisibility(8);
                    if (this.a.f.getVisibility() == 0) {
                        this.a.i.setVisibility(8);
                    }
                    return this;
                }
                this.a.e.setVisibility(0);
                if (this.a.f.getVisibility() == 0) {
                    this.a.i.setVisibility(0);
                }
                this.a.e.setText(charSequence);
                this.a.e.setOnClickListener(new View$OnClickListenerC0237a(this, onClickListener));
                return this;
            }
            return (a) invokeLL.objValue;
        }

        public a Q(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
                S(d().getColor(i));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a R(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048593, this, str, i)) == null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        S(Color.parseColor(str));
                        return this;
                    } catch (IllegalArgumentException e) {
                        if (e03.c) {
                            e.printStackTrace();
                        }
                    }
                }
                if (i > 0) {
                    Q(i);
                }
                return this;
            }
            return (a) invokeLI.objValue;
        }

        public a S(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) {
                b bVar = this.a;
                bVar.w = i;
                bVar.e.setTextColor(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a T(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048595, this, z)) == null) {
                this.a.E = z;
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a U(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                this.a.b.setText(this.c.getText(i));
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a V(CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, charSequence)) == null) {
                if (!TextUtils.isEmpty(charSequence)) {
                    this.a.b.setText(charSequence);
                } else {
                    f(true);
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a W(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, view2)) == null) {
                this.a.o.removeAllViews();
                this.a.o.addView(view2);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.e);
                layoutParams.addRule(3, R.id.obfuscated_res_0x7f0907aa);
                this.a.t.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeL.objValue;
        }

        public e03 X() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
                e03 c2 = c();
                if (this.d) {
                    c2.getWindow().setType(2003);
                }
                try {
                    c2.show();
                } catch (WindowManager.BadTokenException e) {
                    if (e03.c) {
                        e.printStackTrace();
                    }
                }
                BdEventBus.Companion.getDefault().post(new xz2("show"));
                return c2;
            }
            return (e03) invokeV.objValue;
        }

        @Deprecated
        public e03 Y(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) ? X() : (e03) invokeZ.objValue;
        }

        public final void Z() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
                int color = d().getColor(R.color.obfuscated_res_0x7f0603a7);
                int color2 = d().getColor(R.color.obfuscated_res_0x7f0603a3);
                int color3 = d().getColor(R.color.obfuscated_res_0x7f0603a3);
                int color4 = d().getColor(R.color.obfuscated_res_0x7f06039a);
                int color5 = d().getColor(R.color.obfuscated_res_0x7f0603a4);
                RelativeLayout relativeLayout = this.a.r;
                Resources d2 = d();
                int i = this.a.C;
                if (i == -1) {
                    i = R.drawable.obfuscated_res_0x7f080142;
                }
                relativeLayout.setBackground(d2.getDrawable(i));
                this.a.b.setTextColor(color);
                if (this.a.a.getVisibility() == 0) {
                    this.a.c.setTextColor(color4);
                } else {
                    this.a.c.setTextColor(color);
                    this.a.c.setTextSize(1, 21.0f);
                    this.a.c.setLineSpacing(re3.h(5.0f), 1.0f);
                }
                b bVar = this.a;
                TextView textView = bVar.e;
                int i2 = bVar.w;
                if (i2 != color3) {
                    color3 = i2;
                }
                textView.setTextColor(color3);
                b bVar2 = this.a;
                int i3 = bVar2.x;
                if (i3 != color2) {
                    bVar2.f.setTextColor(i3);
                } else {
                    int i4 = bVar2.y;
                    if (i4 != -1) {
                        this.a.f.setTextColor(AppCompatResources.getColorStateList(this.c, i4));
                    } else {
                        bVar2.f.setTextColor(color2);
                    }
                }
                this.a.g.setTextColor(color2);
                if (this.a.D != -1) {
                    color5 = d().getColor(this.a.D);
                }
                this.a.h.setBackgroundColor(color5);
                this.a.i.setBackgroundColor(color5);
                this.a.j.setBackgroundColor(color5);
                this.a.e.setBackground(d().getDrawable(R.drawable.obfuscated_res_0x7f0800cb));
                this.a.f.setBackground(d().getDrawable(R.drawable.obfuscated_res_0x7f0800ca));
                this.a.g.setBackground(d().getDrawable(R.drawable.obfuscated_res_0x7f0800c9));
                TextView g = g();
                if (g != null) {
                    g.setBackground(this.a.E ? d().getDrawable(R.drawable.obfuscated_res_0x7f0800c9) : null);
                }
            }
        }

        public a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
                if (re3.J()) {
                    r(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070126));
                    z(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070125));
                    return this;
                }
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
                ((ViewGroup.MarginLayoutParams) this.a.u.getLayoutParams()).setMargins(0, 0, 0, 0);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public e03 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
                this.b.setCancelable(this.a.k.booleanValue());
                if (this.a.k.booleanValue()) {
                    this.b.setCanceledOnTouchOutside(false);
                }
                this.b.setOnCancelListener(this.a.l);
                this.b.setOnDismissListener(this.a.m);
                this.b.setOnShowListener(this.a.n);
                DialogInterface.OnKeyListener onKeyListener = this.a.p;
                if (onKeyListener != null) {
                    this.b.setOnKeyListener(onKeyListener);
                }
                Z();
                b bVar = this.a;
                c cVar = bVar.z;
                if (cVar != null) {
                    cVar.a(this.b, bVar);
                }
                this.b.f(this);
                return this.b;
            }
            return (e03) invokeV.objValue;
        }

        public Resources d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.c.getResources() : (Resources) invokeV.objValue;
        }

        public ViewGroup e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.a.o : (ViewGroup) invokeV.objValue;
        }

        public a f(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048607, this, z)) == null) {
                this.a.a.setVisibility(z ? 8 : 0);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public TextView g() {
            InterceptResult invokeV;
            int i;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
                TextView textView2 = this.a.e;
                if (textView2 == null || textView2.getVisibility() != 0) {
                    i = 0;
                    textView = null;
                } else {
                    textView = this.a.e;
                    i = 1;
                }
                TextView textView3 = this.a.f;
                if (textView3 != null && textView3.getVisibility() == 0) {
                    i++;
                    textView = this.a.f;
                }
                TextView textView4 = this.a.g;
                if (textView4 != null && textView4.getVisibility() == 0) {
                    i++;
                    textView = this.a.g;
                }
                if (i != 1) {
                    return null;
                }
                return textView;
            }
            return (TextView) invokeV.objValue;
        }

        public e03 h(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, context)) == null) ? new e03(context, R.style.obfuscated_res_0x7f1001a8) : (e03) invokeL.objValue;
        }

        public a i(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048610, this, z)) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.u.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, z ? 0 : this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070124), 0, 0);
                }
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a j() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
                this.a.A.setPadding(0, 0, 0, 0);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a k(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
                this.a.t.setVisibility(z ? 0 : 8);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public void l(View view2, int i, DialogInterface.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048613, this, view2, i, onClickListener) == null) || view2 == null || onClickListener == null) {
                return;
            }
            view2.setOnClickListener(new b(this, i, onClickListener));
        }

        public a m(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048614, this, z)) == null) {
                this.a.k = Boolean.valueOf(z);
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a n(c cVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, cVar)) == null) {
                this.a.z = cVar;
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a o(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i)) == null) {
                this.a.D = i;
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a p(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048617, this, i)) == null) {
                b bVar = this.a;
                bVar.C = i;
                bVar.r.setBackgroundResource(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public void q(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
                this.a.r.getLayoutParams().height = i;
                this.a.r.requestLayout();
            }
        }

        public void r(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
                this.a.r.getLayoutParams().width = i;
                this.a.r.requestLayout();
            }
        }

        public a s(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
                layoutParams.addRule(2, R.id.obfuscated_res_0x7f09043e);
                this.a.h.setLayoutParams(layoutParams);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a t(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048621, this, z)) == null) {
                if (z) {
                    this.a.h.setVisibility(0);
                } else {
                    this.a.h.setVisibility(8);
                }
                return this;
            }
            return (a) invokeZ.objValue;
        }

        public a u(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048622, this, i)) == null) {
                this.a.q.setImageResource(i);
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a v(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
                if (this.a.d.getVisibility() != 0) {
                    this.a.d.setVisibility(0);
                }
                this.a.c.setText(this.c.getText(i));
                A();
                return this;
            }
            return (a) invokeI.objValue;
        }

        public a w(Spanned spanned) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, spanned)) == null) {
                if (this.a.d.getVisibility() != 0) {
                    this.a.d.setVisibility(0);
                }
                if (spanned != null) {
                    this.a.c.setMovementMethod(LinkMovementMethod.getInstance());
                    this.a.c.setText(spanned);
                    A();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a x(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, str)) == null) {
                if (this.a.d.getVisibility() != 0) {
                    this.a.d.setVisibility(0);
                }
                if (str != null) {
                    this.a.c.setText(str);
                    A();
                }
                return this;
            }
            return (a) invokeL.objValue;
        }

        public a y() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
                this.a.c.setGravity(3);
                return this;
            }
            return (a) invokeV.objValue;
        }

        public a z(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048627, this, i)) == null) {
                this.a.a(i);
                return this;
            }
            return (a) invokeI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FrameLayout A;
        public View B;
        public int C;
        public int D;
        public boolean E;
        public LinearLayout a;
        public TextView b;
        public TextView c;
        public LinearLayout d;
        public TextView e;
        public TextView f;
        public TextView g;
        public View h;
        public View i;
        public View j;
        public Boolean k;
        public DialogInterface.OnCancelListener l;
        public DialogInterface.OnDismissListener m;
        public DialogInterface.OnShowListener n;
        public FrameLayout o;
        public DialogInterface.OnKeyListener p;
        public ImageView q;
        public RelativeLayout r;
        public SwanAppScrollView s;
        public LinearLayout t;
        public View u;
        public ViewGroup v;
        public int w;
        public int x;
        public int y;
        public c z;

        public b(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = Boolean.TRUE;
            this.y = -1;
            this.C = -1;
            this.D = -1;
            this.E = true;
            this.v = viewGroup;
            this.a = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0921e5);
            this.b = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907bd);
            this.c = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b3);
            this.d = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907b4);
            this.e = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0919f9);
            this.f = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091642);
            this.g = (TextView) viewGroup.findViewById(R.id.obfuscated_res_0x7f09164f);
            this.i = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e7);
            this.j = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e8);
            this.o = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907ab);
            this.q = (ImageView) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907ae);
            this.r = (RelativeLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f091dcb);
            this.h = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907e6);
            this.s = (SwanAppScrollView) viewGroup.findViewById(R.id.obfuscated_res_0x7f091502);
            this.t = (LinearLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f09043e);
            this.u = viewGroup.findViewById(R.id.obfuscated_res_0x7f0907aa);
            this.A = (FrameLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0907ba);
            this.B = viewGroup.findViewById(R.id.obfuscated_res_0x7f091690);
            if (hd3.k() || hd3.l()) {
                int dimensionPixelSize = this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07012a);
                this.c.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            SwanAppActivity activity = nm2.U().getActivity();
            if (dh4.d() && jd3.d(activity) && dh4.e(activity)) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (dh4.a(activity) * 0.8f), -2);
                layoutParams.gravity = 17;
                this.r.setLayoutParams(layoutParams);
            }
            int color = this.v.getResources().getColor(R.color.obfuscated_res_0x7f0603a3);
            this.w = color;
            this.x = color;
        }

        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.s.setMaxHeight(i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(e03 e03Var, b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947680481, "Lcom/baidu/tieba/e03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947680481, "Lcom/baidu/tieba/e03;");
                return;
            }
        }
        c = kh1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e03(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d();
    }

    public a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (a) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setContentView(R.layout.obfuscated_res_0x7f0d0094);
            getWindow().setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.dismiss();
            BdEventBus.Companion.getDefault().post(new xz2("hide"));
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
        }
    }

    public void f(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.b = aVar;
        }
    }
}
