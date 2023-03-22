package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ch6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public int D;
    public boolean E;
    public int F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    @Nullable
    public d M;
    public Runnable N;
    public Runnable O;
    public ye a;
    public TbPageContext b;
    public View c;
    public boolean d;
    public String e;
    public String f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public View.OnClickListener x;
    public boolean y;
    public boolean z;

    /* loaded from: classes3.dex */
    public interface d {
        void onDismiss();
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch6 a;

        public a(ch6 ch6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b()) {
                this.a.g();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements xe {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch6 a;

        public b(ch6 ch6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch6Var;
        }

        @Override // com.baidu.tieba.xe
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.w;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.v;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.p;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.a.q;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.xe
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            int dimensionPixelSize;
            Drawable drawable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) {
                if (this.a.b == null) {
                    return null;
                }
                TextView textView = new TextView(this.a.b.getPageActivity());
                textView.setText(this.a.e);
                int i = this.a.H;
                if (i != 0) {
                    textView.setGravity(i);
                } else {
                    textView.setGravity(17);
                }
                int i2 = this.a.F;
                int i3 = R.color.CAM_X0101;
                if (i2 != 0) {
                    SkinManager.setViewTextColor(textView, i2);
                } else {
                    SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
                }
                if (this.a.G != 0) {
                    dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(this.a.G);
                } else {
                    dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0702b5);
                }
                textView.setTextSize(0, dimensionPixelSize);
                int i4 = this.a.B;
                if (i4 != 0) {
                    textView.setHeight(i4);
                } else {
                    textView.setHeight(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07026f));
                }
                int i5 = this.a.C;
                if (i5 != 0) {
                    ch6.F(textView, 0, i5);
                }
                int i6 = this.a.D;
                if (i6 != 0) {
                    textView.setWidth(i6);
                }
                ch6 ch6Var = this.a;
                textView.setPadding(ch6Var.r, ch6Var.s, ch6Var.t, ch6Var.u);
                textView.setLines(this.a.A);
                if (this.a.E) {
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                }
                ch6 ch6Var2 = this.a;
                int i7 = ch6Var2.I;
                if (i7 != 0) {
                    if (ch6Var2.J) {
                        int i8 = ch6Var2.F;
                        if (i8 != 0) {
                            i3 = i8;
                        }
                        drawable = WebPManager.getPureDrawable(this.a.I, SkinManager.getColor(i3), WebPManager.ResourceStateType.NORMAL);
                    } else {
                        drawable = SkinManager.getDrawable(i7);
                    }
                    int g = hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds42);
                    drawable.setBounds(0, 0, g, g);
                    textView.setCompoundDrawablePadding(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16));
                    textView.setCompoundDrawables(drawable, null, null, null);
                }
                ch6 ch6Var3 = this.a;
                int i9 = ch6Var3.i;
                if (i9 != 0) {
                    SkinManager.setBackgroundResourceWithTintColor(textView, ch6Var3.h, i9);
                } else {
                    SkinManager.setBackgroundResource(textView, ch6Var3.h);
                }
                View.OnClickListener onClickListener = this.a.x;
                if (onClickListener != null) {
                    textView.setOnClickListener(onClickListener);
                }
                return textView;
            }
            return (View) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ch6 a;

        public c(ch6 ch6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ch6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ch6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d();
            }
        }
    }

    public ch6(TbPageContext tbPageContext, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.h = R.drawable.pic_sign_tip;
        this.j = 0;
        this.k = false;
        this.l = 1;
        this.m = 1000;
        this.n = 3000;
        this.o = true;
        this.p = 5;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 48;
        this.w = 4;
        this.z = false;
        this.A = 1;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = false;
        this.K = true;
        this.N = new a(this);
        this.O = new c(this);
        this.b = tbPageContext;
        this.c = view2;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701e8);
        this.r = dimensionPixelSize;
        this.s = dimensionPixelSize;
        this.t = dimensionPixelSize;
        this.u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070231);
    }

    public static void F(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65537, null, view2, i, i2) == null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            if (i > 0) {
                layoutParams.width = i;
            }
            if (i2 > 0) {
                layoutParams.height = i2;
            }
            view2.setLayoutParams(layoutParams);
        }
    }

    public boolean L(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048586, this, str, str2, z)) == null) {
            return M(str, str2, z, false);
        }
        return invokeLLZ.booleanValue;
    }

    public void A(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.G = i;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.H = i;
        }
    }

    public void C(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && i > 0) {
            this.h = i;
        }
    }

    public void D(@ColorInt int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.i = i;
        }
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.z = z;
        }
    }

    public void G(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.D = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.p = i;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.q = i;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.e = str;
        jg.a().postDelayed(this.N, this.m);
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.w = i;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i) == null) && i > 0) {
            this.n = i;
        }
    }

    public void k(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.v = i;
        }
    }

    public void l(@DimenRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            this.B = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(i);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.E = z;
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.J = z;
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.A = i;
        }
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && i > 0) {
            this.l = i;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.y = z;
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.o = z;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i) == null) && i > 0) {
            this.m = i;
        }
    }

    public void t(@ColorRes int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.F = i;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.I = i;
        }
    }

    public void w(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.u = i;
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.r = i;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.t = i;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048612, this, i) == null) {
            this.s = i;
        }
    }

    public void K(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, str, str2) == null) {
            L(str, str2, false);
        }
    }

    @Deprecated
    public boolean M(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        View view2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (this.d || StringUtils.isNull(str) || StringUtils.isNull(str2) || (view2 = this.c) == null || view2.getVisibility() != 0) {
                return false;
            }
            this.e = str;
            this.f = str2;
            this.k = z2;
            int n = m35.m().n(str2, 0);
            this.j = n;
            if (n >= this.l && !this.k) {
                return false;
            }
            if (z) {
                f();
                this.d = true;
            }
            jg.a().postDelayed(this.N, this.m);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Deprecated
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.a != null || StringUtils.isNull(this.e)) {
                return false;
            }
            if (this.y && !c()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            View view2 = this.c;
            if (view2 == null || view2.getVisibility() != 0 || this.c.getAlpha() < 0.4d) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && !this.k) {
            m35.m().z(this.f, this.j + 1);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ye yeVar = this.a;
            if (yeVar != null) {
                yeVar.d();
                this.a = null;
            }
            jg.a().removeCallbacks(this.N);
            jg.a().removeCallbacks(this.O);
            d dVar = this.M;
            if (dVar != null && this.g) {
                dVar.onDismiss();
            }
            this.g = false;
            this.b = null;
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048593, this) != null) || this.b == null) {
            return;
        }
        ze zeVar = new ze();
        zeVar.k(this.c);
        zeVar.c(0);
        zeVar.j(true);
        zeVar.i(true);
        zeVar.d(this.K);
        zeVar.g(this.L);
        zeVar.a(new b(this));
        ye b2 = zeVar.b();
        this.a = b2;
        b2.k(false);
        this.a.l(this.z);
        this.a.n(this.b.getPageActivity(), this.o);
        this.d = true;
        f();
        this.g = true;
        jg.a().postDelayed(this.O, this.n);
    }

    public void v(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048608, this, i, i2, i3, i4) == null) {
            this.r = i;
            this.s = i2;
            this.t = i3;
            this.u = i4;
        }
    }
}
