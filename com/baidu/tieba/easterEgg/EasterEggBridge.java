package com.baidu.tieba.easterEgg;

import android.webkit.JsPromptResult;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.np8;
import com.baidu.tieba.q96;
import com.baidu.tieba.u96;
import com.baidu.tieba.v96;
import com.baidu.tieba.w96;
import com.baidu.tieba.wi;
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
public class EasterEggBridge implements np8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ARGS = "args";
    public static final String KEY_ARGS_EXT = "native_exts";
    public static final String KEY_CALLBACK = "native_clbk";
    public static final String KEY_INTERFACE_NAME = "EasterEggBridge";
    public static final String KEY_METHOD_NAME = "method_name";
    public transient /* synthetic */ FieldHolder $fh;
    public List<q96> mListener;

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
        addListener(new v96());
        addListener(new w96());
        addListener(new u96());
    }

    public void addListener(q96 q96Var) {
        List<q96> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, q96Var) == null) && q96Var != null && (list = this.mListener) != null) {
            list.add(q96Var);
        }
    }

    public void removeListener(q96 q96Var) {
        List<q96> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, q96Var) == null) && q96Var != null && (list = this.mListener) != null) {
            list.remove(q96Var);
        }
    }

    public void clearListener() {
        List<q96> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.mListener) != null) {
            list.clear();
        }
    }

    @Override // com.baidu.tieba.np8
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, jsPromptResult)) == null) {
            if (KEY_INTERFACE_NAME.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString(KEY_METHOD_NAME);
                    if (wi.isEmpty(str2)) {
                        return false;
                    }
                    String trim = optString.trim();
                    for (q96 q96Var : this.mListener) {
                        if (trim.equals(q96Var.b())) {
                            q96Var.a(trim, jSONObject.optString("args"), jSONObject.optString(KEY_ARGS_EXT), jSONObject.optString(KEY_CALLBACK), jsPromptResult);
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
