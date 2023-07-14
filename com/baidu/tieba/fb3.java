package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.gb3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public abstract class fb3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final View a;
    public Context b;
    public Resources c;
    public List<gb3> d;
    public hb3 e;
    public gb3.a f;
    public PopupWindow g;
    public View.OnKeyListener h;
    public int i;
    public View j;
    public boolean k;
    public f l;
    public boolean m;
    public float n;
    public boolean o;
    public int p;
    public boolean q;
    public Runnable r;

    /* loaded from: classes5.dex */
    public interface f {
        void onMenuItemUpdated(List<gb3> list);
    }

    /* loaded from: classes5.dex */
    public interface g {
    }

    public abstract void l(View view2, List<gb3> list);

    public abstract View m(Context context);

    public abstract void u(PopupWindow popupWindow);

    /* loaded from: classes5.dex */
    public class a implements gb3.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb3 a;

        public a(fb3 fb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb3Var;
        }

        @Override // com.baidu.tieba.gb3.a
        public void a(gb3 gb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gb3Var) == null) {
                if (gb3Var.f()) {
                    this.a.k(gb3Var.a());
                }
                gb3.a aVar = this.a.f;
                if (aVar != null) {
                    aVar.a(gb3Var);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnKeyListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb3 a;

        public b(fb3 fb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb3Var;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view2, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, view2, i, keyEvent)) == null) {
                if (keyEvent.getAction() == 1) {
                    if (i == 4 || i == 82) {
                        this.a.j();
                        View.OnKeyListener onKeyListener = this.a.h;
                        if (onKeyListener != null) {
                            onKeyListener.onKey(view2, i, keyEvent);
                        }
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements PopupWindow.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb3 a;

        public c(fb3 fb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb3Var;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.m) {
                    this.a.h();
                }
                hb3 hb3Var = this.a.e;
                if (hb3Var != null) {
                    hb3Var.onDismissMenu();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb3 a;

        public d(fb3 fb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.a.m) {
                        this.a.i(this.a.n);
                    }
                    this.a.u(this.a.g);
                } catch (Exception e) {
                    if (fs1.a) {
                        Log.w("PopupWindow", "Exception", e);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fb3 a;

        public e(fb3 fb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j();
            }
        }
    }

    public fb3(View view2) {
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
        this.k = true;
        this.m = false;
        this.n = 0.5f;
        this.o = false;
        this.p = R.style.obfuscated_res_0x7f10042a;
        this.r = new e(this);
        this.a = view2;
        this.b = view2.getContext();
        this.c = this.a.getResources();
        this.d = new ArrayList();
        this.i = -2;
        this.q = cv2.M().a();
        o(this.b);
    }

    public final void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            hb3 hb3Var = this.e;
            if (hb3Var != null) {
                hb3Var.onShowMenu();
            }
            w(this.d);
            l(this.j, this.d);
            j();
            if (this.g == null) {
                PopupWindow popupWindow = new PopupWindow(this.j, this.i, -2, true);
                this.g = popupWindow;
                if (this.o) {
                    popupWindow.setAnimationStyle(this.p);
                }
                if (z) {
                    this.g.setBackgroundDrawable(this.c.getDrawable(R.drawable.obfuscated_res_0x7f0801cb));
                    this.g.setTouchable(true);
                } else {
                    this.g.setTouchable(false);
                }
                this.g.setOnDismissListener(new c(this));
            }
            View view2 = this.a;
            if (view2 == null) {
                hb3 hb3Var2 = this.e;
                if (hb3Var2 != null) {
                    hb3Var2.onDismissMenu();
                    return;
                }
                return;
            }
            view2.post(new d(this));
            this.j.postInvalidate();
        }
    }

    public gb3 g(gb3 gb3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gb3Var)) == null) {
            gb3Var.g(this);
            if (this.k) {
                gb3Var.h(new a(this));
            } else {
                gb3Var.h(this.f);
            }
            this.d.add(gb3Var);
            return gb3Var;
        }
        return (gb3) invokeL.objValue;
    }

    public void k(long j) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048582, this, j) == null) && (view2 = this.a) != null) {
            view2.removeCallbacks(this.r);
            if (j > 0) {
                this.a.postDelayed(this.r, j);
            } else {
                j();
            }
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.m = z;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.o = z;
        }
    }

    public void r(gb3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) {
            this.f = aVar;
        }
    }

    public void s(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            this.i = i;
        }
    }

    public void w(List<gb3> list) {
        f fVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, list) == null) && (fVar = this.l) != null) {
            fVar.onMenuItemUpdated(list);
        }
    }

    public gb3 e(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            return f(i, this.c.getString(i2), null);
        }
        return (gb3) invokeII.objValue;
    }

    public gb3 f(int i, CharSequence charSequence, Drawable drawable) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, charSequence, drawable)) == null) {
            gb3 gb3Var = new gb3(this.b, i, charSequence, drawable);
            g(gb3Var);
            return gb3Var;
        }
        return (gb3) invokeILL.objValue;
    }

    public final void h() {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (view2 = this.a) != null) {
            ((ViewGroup) view2.getRootView()).getOverlay().clear();
        }
    }

    public void j() {
        PopupWindow popupWindow;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (popupWindow = this.g) != null) {
            try {
                popupWindow.dismiss();
            } catch (Exception e2) {
                if (fs1.a) {
                    Log.w("PopupWindow", "Exception", e2);
                }
            }
        }
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            PopupWindow popupWindow = this.g;
            if (popupWindow != null && popupWindow.isShowing()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (cv2.M().a() != this.q) {
                o(this.b);
                this.g = null;
            }
            v(true);
            this.q = cv2.M().a();
        }
    }

    public final void i(float f2) {
        View view2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048580, this, f2) == null) && (view2 = this.a) != null) {
            ViewGroup viewGroup = (ViewGroup) view2.getRootView();
            ColorDrawable colorDrawable = new ColorDrawable(-16777216);
            colorDrawable.setBounds(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
            colorDrawable.setAlpha((int) (f2 * 255.0f));
            viewGroup.getOverlay().add(colorDrawable);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void o(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            View m = m(context);
            this.j = m;
            m.setFocusable(true);
            this.j.setFocusableInTouchMode(true);
            if (!(this.j instanceof g) && fs1.a) {
                throw new IllegalArgumentException("The view returned by getMenuView() MUST implement OnMenuSetChangedListener!");
            }
            this.j.setOnKeyListener(new b(this));
        }
    }
}
