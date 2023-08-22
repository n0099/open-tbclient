package com.baidu.tieba;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.view.button.base.ApiButton;
import com.baidu.tieba.zd4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ae4 extends EventTargetImpl implements zd4.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ApiButton a;
    @V8JavascriptField
    public String image;
    @V8JavascriptField
    public zd4 style;
    @V8JavascriptField
    public String text;
    @V8JavascriptField
    public String type;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae4 a;

        public a(ae4 ae4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (apiButton = this.a.a) != null) {
                xd4.d(apiButton);
                this.a.a = null;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae4 a;

        public b(ae4 ae4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (apiButton = this.a.a) != null) {
                apiButton.hide();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae4 a;

        public c(ae4 ae4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApiButton apiButton;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (apiButton = this.a.a) != null) {
                apiButton.show();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ae4 b;

        public d(ae4 ae4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ae4Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (nr1.a) {
                    Log.d("BaseButtonProxy", "onFieldChangedCallback fieldName=" + this.a);
                }
                if (this.b.a == null) {
                    return;
                }
                String str = this.a;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 3556653) {
                    if (hashCode == 100313435 && str.equals("image")) {
                        c = 1;
                    }
                } else if (str.equals("text")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c == 1) {
                        ae4 ae4Var = this.b;
                        ae4Var.a.setImageUrl(ae4Var.image);
                        return;
                    }
                    return;
                }
                ae4 ae4Var2 = this.b;
                ae4Var2.a.setButtonText(ae4Var2.text);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae4 a;

        public e(ae4 ae4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ae4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ae4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ae4 ae4Var = this.a;
                if (ae4Var.a != null && !ae4Var.A()) {
                    this.a.a.l();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae4(JsObject jsObject, ni2 ni2Var) {
        super(ni2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject, ni2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.type = "text";
        this.text = ku2.c().getString(R.string.obfuscated_res_0x7f0f0133);
        z(jsObject);
    }

    @JavascriptInterface
    public void onFieldChangedCallback(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            xo3.e0(new d(this, str));
        }
    }

    public final boolean A() {
        InterceptResult invokeV;
        j13 y;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.a == null || this.style == null || (y = y()) == null || !xd4.f(this.a, y)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @JavascriptInterface
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xo3.e0(new a(this));
        }
    }

    @JavascriptInterface
    public void hide() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            xo3.e0(new b(this));
        }
    }

    @Override // com.baidu.tieba.zd4.a
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xo3.e0(new e(this));
        }
    }

    @JavascriptInterface
    public void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            xo3.e0(new c(this));
        }
    }

    public boolean x() {
        InterceptResult invokeV;
        zd4 zd4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.a == null || (zd4Var = this.style) == null) {
                return false;
            }
            zd4Var.b(this);
            j13 y = y();
            if (y == null || !xd4.a(this.a, y)) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final j13 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            zd4 zd4Var = this.style;
            if (zd4Var == null || this.a == null) {
                return null;
            }
            int g = uo3.g(zd4Var.width);
            int g2 = uo3.g(this.style.height);
            int g3 = uo3.g(this.style.left);
            int g4 = uo3.g(this.style.top);
            int g5 = uo3.g(this.style.borderWidth) * 2;
            if (g < g5) {
                g = g5;
            }
            if (g2 < g5) {
                g2 = g5;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            if (layoutParams != null && layoutParams.width == g && layoutParams.height == g2 && layoutParams.leftMargin == g3 && layoutParams.topMargin == g4) {
                return null;
            }
            return new j13(g3, g4, g, g2);
        }
        return (j13) invokeV.objValue;
    }

    public final void z(JsObject jsObject) {
        zd4 zd4Var;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            k32 F = k32.F(jsObject);
            if (nr1.a) {
                if (("parse jsObject = " + F) != null) {
                    str = F.toString();
                } else {
                    str = null;
                }
                Log.d("BaseButtonProxy", str);
            }
            if (F == null) {
                return;
            }
            this.type = F.C("type", this.type);
            this.text = F.C("text", this.text);
            this.image = F.C("image", this.image);
            k32 x = F.x("style", null);
            if (x == null) {
                zd4Var = this.style;
            } else {
                zd4Var = new zd4(x);
            }
            this.style = zd4Var;
        }
    }
}
