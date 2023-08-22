package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public abstract class dl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    public abstract void m(Map<String, Object> map);

    /* loaded from: classes5.dex */
    public class a extends bl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 c;
        public final /* synthetic */ String d;

        public a(dl2 dl2Var, ba2 ba2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl2Var, ba2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ba2Var;
            this.d = str;
        }

        @Override // com.baidu.tieba.bl2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.c.isDestroyed()) {
                    if (dl2.b) {
                        Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + this.d)));
                        return;
                    }
                    return;
                }
                this.c.evaluateJavascript(this.d, null);
                h43.a("postMessage", "dispatchJSEvent evaluateJavascript");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends bl2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba2 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ dl2 e;

        public b(dl2 dl2Var, ba2 ba2Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dl2Var, ba2Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = dl2Var;
            this.c = ba2Var;
            this.d = str;
        }

        @Override // com.baidu.tieba.bl2
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.e.l(this.c, this.d);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947708319, "Lcom/baidu/tieba/dl2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947708319, "Lcom/baidu/tieba/dl2;");
                return;
            }
        }
        b = nr1.a;
    }

    public dl2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final void b(@NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jSONObject) == null) {
            try {
                jSONObject.put("type", this.a);
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String c(ba2 ba2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ba2Var)) == null) {
            return d("event", ba2Var);
        }
        return (String) invokeL.objValue;
    }

    public boolean f(ba2 ba2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ba2Var)) == null) {
            if (ba2Var != null && !ba2Var.isWebView() && (ba2Var instanceof ni2)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void g(ba2 ba2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, ba2Var) != null) || ba2Var == null) {
            return;
        }
        h43.a("postMessage", "dispatchJSEvent start.");
        if (cl2.b) {
            r(ba2Var);
        } else {
            q(ba2Var);
        }
        h43.a("postMessage", "dispatchJSEvent buildEvent");
    }

    public final boolean p(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, obj)) == null) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof String)) {
                return true;
            }
            return !TextUtils.isEmpty((String) obj);
        }
        return invokeL.booleanValue;
    }

    public final void r(@NonNull ba2 ba2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ba2Var) == null) {
            if (f(ba2Var)) {
                h(ba2Var);
            } else {
                i(ba2Var);
            }
        }
    }

    public String d(String str, ba2 ba2Var) {
        InterceptResult invokeLL;
        String format;
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ba2Var)) == null) {
            if (ba2Var != null && !TextUtils.isEmpty(this.a)) {
                if (TextUtils.isEmpty(str)) {
                    str = "event";
                }
                Locale locale = Locale.getDefault();
                if (ba2Var.isWebView()) {
                    format = String.format(locale, "var %s = new Event('%s');", str, this.a);
                    b2 = "";
                } else {
                    format = String.format(locale, "var %s = new Object();", str);
                    b2 = zk2.b(str, "type", this.a);
                }
                return format + (b2 + o(str)) + String.format(locale, "%s.dispatchEvent(%s);", zk2.c(ba2Var), str);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public JSEvent e(ba2 ba2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ba2Var)) == null) {
            if (ba2Var != null && !TextUtils.isEmpty(this.a)) {
                JSEvent jSEvent = new JSEvent(this.a);
                JSONObject jSONObject = new JSONObject();
                try {
                    n(jSONObject);
                } catch (Exception e) {
                    if (b) {
                        e.printStackTrace();
                    }
                }
                b(jSONObject);
                jSEvent.data = jSONObject;
                return jSEvent;
            }
            return null;
        }
        return (JSEvent) invokeL.objValue;
    }

    public void n(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, jSONObject) == null) {
            HashMap hashMap = new HashMap();
            m(hashMap);
            for (String str : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    Object obj = hashMap.get(str);
                    if (p(obj)) {
                        jSONObject.put(str, obj);
                    }
                }
            }
        }
    }

    public void h(ba2 ba2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, ba2Var) != null) || ba2Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on v8");
        }
        JSEvent e = e(ba2Var);
        if (e == null) {
            return;
        }
        j(ba2Var, e);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action - " + e.type + " on v8 : " + e.data);
        }
    }

    public final void q(ba2 ba2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, ba2Var) == null) {
            String c = c(ba2Var);
            if (TextUtils.isEmpty(c)) {
                return;
            }
            String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
            if (b) {
                Log.d("JSEventDispatcher", "dispatchJSEvent action: " + format);
            }
            if (ba2Var.isWebView()) {
                al2.b().c(new b(this, ba2Var, format), null);
            } else {
                l(ba2Var, format);
            }
        }
    }

    public void i(ba2 ba2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, ba2Var) != null) || ba2Var == null) {
            return;
        }
        if (b) {
            Log.d("JSEventDispatcher", "dispatch event - " + this.a + " on webView");
        }
        String c = c(ba2Var);
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String format = String.format(Locale.getDefault(), "javascript:(function(){%s})();", c);
        k(ba2Var, format);
        if (b) {
            Log.d("JSEventDispatcher", "dispatchJSEvent action on webView: " + format);
        }
    }

    public String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            Map<String, Object> hashMap = new HashMap<>();
            m(hashMap);
            StringBuilder sb = new StringBuilder();
            for (String str2 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str2)) {
                    Object obj = hashMap.get(str2);
                    if (p(obj)) {
                        if (obj instanceof String) {
                            obj = JSONObject.quote((String) obj);
                        }
                        sb.append(str);
                        sb.append(".");
                        sb.append(str2);
                        sb.append("=");
                        sb.append(obj);
                        sb.append(ParamableElem.DIVIDE_PARAM);
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public void j(ba2 ba2Var, JSEvent jSEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ba2Var, jSEvent) != null) || ba2Var.isDestroyed()) {
            return;
        }
        if (ba2Var instanceof ni2) {
            ((ni2) ba2Var).dispatchEvent(jSEvent);
        }
        h43.a("postMessage", "dispatchJSEvent evaluateJavascript");
    }

    public void k(ba2 ba2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, ba2Var, str) == null) && ba2Var != null && !TextUtils.isEmpty(str)) {
            al2.b().c(new a(this, ba2Var, str), null);
        }
    }

    public final void l(ba2 ba2Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, ba2Var, str) == null) {
            if (ba2Var.isDestroyed()) {
                if (b) {
                    Log.e("JSEventDispatcher", Log.getStackTraceString(new Exception("webview is destroyed. dispatch action:" + str)));
                    return;
                }
                return;
            }
            ba2Var.evaluateJavascript(str, null);
            h43.a("postMessage", "dispatchJSEvent evaluateJavascript");
        }
    }
}
