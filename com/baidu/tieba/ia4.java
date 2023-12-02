package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JSRuntime;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.games.view.webview.GameWebViewManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes6.dex */
public class ia4 extends EventTargetImpl {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean d;
    public transient /* synthetic */ FieldHolder $fh;
    public vs1 a;
    public volatile String b;
    public e c;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ia4 b;

        public a(ia4 ia4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ia4Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.b.a == null) {
                    this.b.E();
                }
                if (!this.b.a.c()) {
                    this.b.a.F();
                }
                this.b.a.loadUrl(this.a);
                this.b.C("open", new ja4(this.a));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia4 a;

        public b(ia4 ia4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.a.c()) {
                this.a.a.removeFromParent();
                this.a.a.destroy();
                this.a.a = null;
                ia4 ia4Var = this.a;
                ia4Var.C("close", new ja4(ia4Var.b));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ia4 b;

        public c(ia4 ia4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia4Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ia4Var;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.a != null) {
                if (TextUtils.equals("1", this.a)) {
                    this.b.a.f(true);
                } else {
                    this.b.a.f(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ia4 a;

        public d(ia4 ia4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ia4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.close();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public long c;
        public long d;

        public e(String str, String str2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = j;
        }

        public /* synthetic */ e(String str, String str2, long j, a aVar) {
            this(str, str2, j);
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "H5GameInfo{mGameId='" + this.a + "', mGameName='" + this.b + "', mStartLoadingTimestamp=" + this.c + ", mFinishLoadingTimestamp=" + this.d + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947846765, "Lcom/baidu/tieba/ia4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947846765, "Lcom/baidu/tieba/ia4;");
                return;
            }
        }
        d = vm1.a;
    }

    public static ia4 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            sd2 n = k24.m().n();
            if (n == null) {
                return null;
            }
            EventTarget m = n.m();
            if (!(m instanceof r04)) {
                return null;
            }
            return ((r04) m).getWebViewManager();
        }
        return (ia4) invokeV.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a == null) {
            GameWebViewManager gameWebViewManager = new GameWebViewManager(rp2.c());
            this.a = gameWebViewManager;
            gameWebViewManager.h(new d(this));
        }
    }

    @JavascriptInterface
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ek3.e0(new b(this));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ia4(ud2 ud2Var) {
        super(ud2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ud2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((JSRuntime) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final boolean F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @JavascriptInterface
    public void setCloseViewVisibility(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsObject) == null) {
            sy1 G = sy1.G(jsObject);
            if (G == null) {
                C("error", B(null, "1001"));
            } else {
                ek3.e0(new c(this, G.D("setCloseViewVisibility", null)));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final ka4 B(String str, @NonNull String str2) {
        InterceptResult invokeLL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            switch (str2.hashCode()) {
                case 1507424:
                    if (str2.equals("1001")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 1507425:
                    if (str2.equals("1002")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    return null;
                }
                return new ka4(str, str2, "open:host not in white list");
            }
            return new ka4(str, str2, "open:url is invalid");
        }
        return (ka4) invokeLL.objValue;
    }

    public final void C(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, obj) == null) {
            if (d) {
                Log.i("GameWebViewApi", "dispatchEvent:" + str + "," + obj);
            }
            dispatchEvent(new JSEvent(str, obj));
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.c == null) {
                if (d) {
                    Log.d("GameWebViewApi", "onGameLoadingFinish: H5GameInfo is null.");
                    return;
                }
                return;
            }
            k63 c0 = k63.c0();
            if (c0 == null) {
                if (d) {
                    Log.d("GameWebViewApi", "onGameLoadingFinish: SwanApp is null.");
                    return;
                }
                return;
            }
            this.c.d = System.currentTimeMillis();
            if (d) {
                Log.d("GameWebViewApi", "onGameLoadingFinish: " + this.c);
            }
            la4.a(c0, this.c);
            this.c = null;
        }
    }

    @JavascriptInterface
    public void onGameLoadingStart(JsObject jsObject) {
        sy1 G;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, jsObject) != null) || (G = sy1.G(jsObject)) == null) {
            return;
        }
        String C = G.C("gameId");
        String C2 = G.C("gameName");
        if (!TextUtils.isEmpty(C) && !TextUtils.isEmpty(C2)) {
            this.c = new e(C, C2, System.currentTimeMillis(), null);
            if (d) {
                Log.d("GameWebViewApi", "onGameLoadingStart: " + this.c);
            }
            w84.a(G, true, null);
            return;
        }
        w84.a(G, false, null);
    }

    @JavascriptInterface
    public void open(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, jsObject) == null) {
            sy1 G = sy1.G(jsObject);
            if (G == null) {
                C("error", B(null, "1001"));
                return;
            }
            String D = G.D("url", null);
            if (!F(D)) {
                C("error", B(D, "1001"));
            } else if (!b73.h(D)) {
                C("error", B(D, "1002"));
            } else {
                if (d) {
                    Log.i("GameWebViewApi", "open:" + D);
                }
                this.b = D;
                ek3.e0(new a(this, D));
            }
        }
    }
}
