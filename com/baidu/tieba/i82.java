package com.baidu.tieba;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.component.components.textarea.SwanEditText;
import com.baidu.tieba.ru2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class i82 extends f72<SwanEditText, j82> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public SwanAppActivity i;
    public hb2 j;
    public ru2 k;
    public int l;

    /* loaded from: classes6.dex */
    public interface g {
        void a(String str, JSONObject jSONObject);
    }

    /* loaded from: classes6.dex */
    public class a extends wo2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ i82 b;

        public a(i82 i82Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i82Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i82Var;
            this.a = swanEditText;
        }

        @Override // com.baidu.tieba.wo2, com.baidu.tieba.xo2
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.k != null) {
                this.b.k.dismiss();
                this.b.p0(this.a);
            }
        }

        @Override // com.baidu.tieba.wo2, com.baidu.tieba.xo2
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, keyEvent)) == null) {
                if (i == 4 && this.b.k != null) {
                    this.b.k.dismiss();
                    this.b.p0(this.a);
                    return true;
                }
                return false;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ru2.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ j82 b;
        public final /* synthetic */ wo2 c;
        public final /* synthetic */ i82 d;

        public b(i82 i82Var, SwanEditText swanEditText, j82 j82Var, wo2 wo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i82Var, swanEditText, j82Var, wo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = i82Var;
            this.a = swanEditText;
            this.b = j82Var;
            this.c = wo2Var;
        }

        @Override // com.baidu.tieba.ru2.d
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (o72.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardHide");
                }
                this.d.y0(this.a);
                this.d.i.G0(this.c);
            }
        }

        @Override // com.baidu.tieba.ru2.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                if (o72.h) {
                    Log.d("Component-Input", "numeric keyboard onKeyboardShow");
                }
                i82 i82Var = this.d;
                i82Var.z0(i82Var.i, this.a, this.b, i);
                this.d.i.u0(this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j82 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ i82 c;

        public c(i82 i82Var, j82 j82Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i82Var, j82Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i82Var;
            this.a = j82Var;
            this.b = swanEditText;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                nu2.d(mu2.d().c(), this.c.l);
                if (this.a.M) {
                    return true;
                }
                this.b.clearFocus();
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ i82 b;

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        public d(i82 i82Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i82Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i82Var;
            this.a = swanEditText;
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            char charAt;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) && i2 != i3) {
                if (i2 > i3) {
                    charAt = '\b';
                } else {
                    charAt = charSequence.charAt((i + i3) - 1);
                }
                nu2.c((j82) this.b.n(), this.a, charAt);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j82 a;
        public final /* synthetic */ SwanEditText b;
        public final /* synthetic */ i82 c;

        public e(i82 i82Var, j82 j82Var, SwanEditText swanEditText) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i82Var, j82Var, swanEditText};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i82Var;
            this.a = j82Var;
            this.b = swanEditText;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (o72.h) {
                    Log.d("Component-Input", "onFocusChange:" + z);
                }
                if (!z) {
                    z82.i("Component-Input", "send blur callback");
                    if (!TextUtils.equals("text", this.a.L) && this.c.k != null) {
                        this.c.k.dismiss();
                    }
                    nu2.b(this.b, this.c.l);
                    this.c.p0(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements mn3 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanEditText a;
        public final /* synthetic */ SwanAppActivity b;
        public final /* synthetic */ j82 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ i82 e;

        @Override // com.baidu.tieba.mn3
        public void c(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            }
        }

        public f(i82 i82Var, SwanEditText swanEditText, SwanAppActivity swanAppActivity, j82 j82Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i82Var, swanEditText, swanAppActivity, j82Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i82Var;
            this.a = swanEditText;
            this.b = swanAppActivity;
            this.c = j82Var;
            this.d = view2;
        }

        @Override // com.baidu.tieba.mn3
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, str, i) != null) {
                return;
            }
            this.e.y0(this.a);
            on3.i().k(this.d);
        }

        @Override // com.baidu.tieba.mn3
        public void b(String str, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i) != null) || !this.a.hasFocus()) {
                return;
            }
            this.e.z0(this.b, this.a, this.c, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i82(@Nullable Context context, @NonNull j82 j82Var, @NonNull SwanAppActivity swanAppActivity, @NonNull hb2 hb2Var, @NonNull g gVar) {
        super(context, j82Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, j82Var, swanAppActivity, hb2Var, gVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (g72) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = swanAppActivity;
        this.j = hb2Var;
        nu2.a(gVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o72
    @NonNull
    /* renamed from: r0 */
    public SwanEditText v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, context)) == null) {
            q0();
            return mu2.d().a(context);
        }
        return (SwanEditText) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.m72
    /* renamed from: u0 */
    public void R(@NonNull SwanEditText swanEditText, @NonNull j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, swanEditText, j82Var) == null) {
            if (o72.h) {
                Log.d("Component-Input", "renderPadding");
            }
            swanEditText.setPadding(0, -6, 0, 0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k72
    /* renamed from: x0 */
    public void X(@NonNull SwanEditText swanEditText, @NonNull j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, swanEditText, j82Var) == null) {
            Y(swanEditText, j82Var, 16);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            p0(mu2.d().c());
        }
    }

    @Override // com.baidu.tieba.o72
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.z();
        }
    }

    public final void A0(SwanEditText swanEditText, j82 j82Var, SwanAppActivity swanAppActivity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, swanEditText, j82Var, swanAppActivity) == null) {
            swanEditText.setOnEditorActionListener(new c(this, j82Var, swanEditText));
            d dVar = new d(this, swanEditText);
            swanEditText.setOnFocusChangeListener(new e(this, j82Var, swanEditText));
            if (TextUtils.equals("text", j82Var.L)) {
                View decorView = swanAppActivity.getWindow().getDecorView();
                on3.i().l(decorView, j82Var.b, new f(this, swanEditText, swanAppActivity, j82Var, decorView));
            }
            mu2.d().f(dVar);
            swanEditText.addTextChangedListener(dVar);
        }
    }

    public final void B0(SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, swanEditText) == null) {
            try {
                Method method = SwanEditText.class.getMethod("setShowSoftInputOnFocus", Boolean.TYPE);
                method.setAccessible(true);
                method.invoke(swanEditText, Boolean.FALSE);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
                if (o72.h) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void p0(@Nullable SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, swanEditText) == null) {
            SwanAppActivity activity = mx2.T().getActivity();
            if (activity == null) {
                z82.o("Component-Input", "activity is null when close input");
                return;
            }
            ap3.a(activity, activity.getWindow().getDecorView().getWindowToken());
            if (swanEditText == null) {
                return;
            }
            swanEditText.setOnFocusChangeListener(null);
            z82.i("Component-Input", "remove input");
            if (B().a()) {
                z82.i("Component-Input", "remove input success");
            } else {
                z82.o("Component-Input", "remove input fail");
            }
            mu2.d().b();
        }
    }

    public final void y0(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, swanEditText) == null) {
            if (o72.h) {
                Log.d("Component-Input", "scrollBackWhenKeyboardHide, mKeyboardHeight：" + this.l);
            }
            if (this.l != 0) {
                this.l = 0;
                swanEditText.clearFocus();
                if (this.j.z3().getScrollY() > 0) {
                    this.j.z3().setScrollY(0);
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.o72
    /* renamed from: s0 */
    public void A(@NonNull SwanEditText swanEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, swanEditText) == null) {
            super.A(swanEditText);
            j82 j82Var = (j82) n();
            swanEditText.setText(j82Var.t);
            int i = 1;
            swanEditText.setSingleLine(true);
            swanEditText.setTag(j82Var.e);
            if (!TextUtils.equals("text", j82Var.L)) {
                String str = j82Var.L;
                char c2 = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1193508181) {
                    if (hashCode == 95582509 && str.equals("digit")) {
                        c2 = 0;
                    }
                } else if (str.equals("idcard")) {
                    c2 = 1;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        i = 0;
                    }
                } else {
                    i = 2;
                }
                this.k = new ru2(this.i, swanEditText, i, j82Var.D);
                this.k.e(new b(this, swanEditText, j82Var, new a(this, swanEditText)));
                this.k.f();
            }
            if (j82Var.J) {
                swanEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // com.baidu.tieba.o72
    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            super.x(z);
            if (!z) {
                s82.a("Component-Input", "attach fail");
            }
            SwanEditText swanEditText = (SwanEditText) q();
            if (swanEditText == null) {
                s82.a("Component-Input", "onAttached with null editText");
                swanEditText = mu2.d().c();
            }
            swanEditText.setFocusable(true);
            swanEditText.setFocusableInTouchMode(true);
            swanEditText.requestFocus();
            if (TextUtils.equals(((j82) n()).L, "text")) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.i.getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(swanEditText, 0);
                }
            } else if (Build.VERSION.SDK_INT >= 21) {
                swanEditText.setShowSoftInputOnFocus(false);
            } else {
                B0(swanEditText);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.f72
    /* renamed from: t0 */
    public void a0(@NonNull SwanEditText swanEditText, @NonNull j82 j82Var, @NonNull r82 r82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048591, this, swanEditText, j82Var, r82Var) == null) {
            boolean t = t();
            if (t) {
                swanEditText.removeTextChangedListener(mu2.d().e());
            }
            super.T(swanEditText, j82Var, r82Var);
            if (t) {
                swanEditText.addTextChangedListener(mu2.d().e());
            } else {
                A0(swanEditText, j82Var, this.i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k72
    /* renamed from: v0 */
    public void U(@NonNull SwanEditText swanEditText, @NonNull j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanEditText, j82Var) == null) {
            if (o72.h) {
                Log.d("Component-Input", "renderText");
            }
            if (t()) {
                super.U(swanEditText, j82Var);
                try {
                    swanEditText.setSelection(j82Var.t.length());
                } catch (IndexOutOfBoundsException e2) {
                    if (o72.h) {
                        e2.printStackTrace();
                    }
                    s82.a("Component-Input", "value is invalid, out of max length");
                }
            } else if (!TextUtils.equals(swanEditText.getText(), j82Var.t)) {
                s82.a("Component-Input", "insert input: set text must before render");
                super.U(swanEditText, j82Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.k72
    /* renamed from: w0 */
    public void W(@NonNull SwanEditText swanEditText, @NonNull j82 j82Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, swanEditText, j82Var) == null) {
            if (o72.h) {
                Log.d("Component-Input", "renderTextStyleFontWeight");
            }
            String str = j82Var.A;
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1178781136) {
                if (hashCode == -841373419 && str.equals("boldItalic")) {
                    c2 = 1;
                }
            } else if (str.equals("italic")) {
                c2 = 0;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    super.W(swanEditText, j82Var);
                    return;
                } else {
                    swanEditText.setTypeface(Typeface.SANS_SERIF, 3);
                    return;
                }
            }
            swanEditText.setTypeface(Typeface.SANS_SERIF, 2);
        }
    }

    public final void z0(@NonNull SwanAppActivity swanAppActivity, @NonNull SwanEditText swanEditText, j82 j82Var, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048600, this, swanAppActivity, swanEditText, j82Var, i) == null) {
            gy1 i3 = mx2.T().i();
            if (o72.h) {
                Log.d("Component-Input", "scrollUpWhenKeyboardShow, mKeyboardHeight：" + this.l + "，keyboardHeight : " + i);
            }
            if (this.l != i && i3 != null) {
                this.l = i;
                nu2.f(swanEditText, i);
                if (j82Var.N) {
                    if (j82Var.h == null) {
                        j82Var.h = new f23();
                    }
                    int webViewScrollY = i3.getWebViewScrollY();
                    int height = swanEditText.getHeight();
                    if (height == 0) {
                        height = j82Var.h.c();
                    }
                    int height2 = ((this.j.z3().getHeight() - j82Var.h.e()) - height) + webViewScrollY + qp3.k(swanAppActivity);
                    int i4 = j82Var.E;
                    if (i4 > height2) {
                        i4 = height2;
                    }
                    int i5 = height2 - i;
                    int scrollY = this.j.z3().getScrollY();
                    if (i5 < 0) {
                        i2 = i4 - i5;
                    } else {
                        if (i4 > i5) {
                            scrollY = i4 - i5;
                        }
                        i2 = scrollY;
                    }
                    this.j.z3().setScrollY(i2);
                }
            }
        }
    }
}
