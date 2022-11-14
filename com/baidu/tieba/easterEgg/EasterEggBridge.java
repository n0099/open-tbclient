package com.baidu.tieba.easterEgg;

import android.webkit.JsPromptResult;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ca6;
import com.baidu.tieba.ga6;
import com.baidu.tieba.ha6;
import com.baidu.tieba.ia6;
import com.baidu.tieba.xi;
import com.baidu.tieba.yp8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EasterEggBridge implements yp8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ARGS = "args";
    public static final String KEY_ARGS_EXT = "native_exts";
    public static final String KEY_CALLBACK = "native_clbk";
    public static final String KEY_INTERFACE_NAME = "EasterEggBridge";
    public static final String KEY_METHOD_NAME = "method_name";
    public transient /* synthetic */ FieldHolder $fh;
    public List<ca6> mListener;

    public EasterEggBridge() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mListener = new ArrayList();
        addListener(new ha6());
        addListener(new ia6());
        addListener(new ga6());
    }

    public void addListener(ca6 ca6Var) {
        List<ca6> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ca6Var) == null) && ca6Var != null && (list = this.mListener) != null) {
            list.add(ca6Var);
        }
    }

    public void removeListener(ca6 ca6Var) {
        List<ca6> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, ca6Var) == null) && ca6Var != null && (list = this.mListener) != null) {
            list.remove(ca6Var);
        }
    }

    public void clearListener() {
        List<ca6> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.mListener) != null) {
            list.clear();
        }
    }

    @Override // com.baidu.tieba.yp8
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, jsPromptResult)) == null) {
            if (KEY_INTERFACE_NAME.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString(KEY_METHOD_NAME);
                    if (xi.isEmpty(str2)) {
                        return false;
                    }
                    String trim = optString.trim();
                    for (ca6 ca6Var : this.mListener) {
                        if (trim.equals(ca6Var.b())) {
                            ca6Var.a(trim, jSONObject.optString("args"), jSONObject.optString(KEY_ARGS_EXT), jSONObject.optString(KEY_CALLBACK), jsPromptResult);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }
}
