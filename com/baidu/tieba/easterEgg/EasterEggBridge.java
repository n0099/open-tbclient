package com.baidu.tieba.easterEgg;

import android.webkit.JsPromptResult;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c46;
import com.repackage.d46;
import com.repackage.dj8;
import com.repackage.e46;
import com.repackage.oi;
import com.repackage.y36;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class EasterEggBridge implements dj8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_ARGS = "args";
    public static final String KEY_ARGS_EXT = "native_exts";
    public static final String KEY_CALLBACK = "native_clbk";
    public static final String KEY_INTERFACE_NAME = "EasterEggBridge";
    public static final String KEY_METHOD_NAME = "method_name";
    public transient /* synthetic */ FieldHolder $fh;
    public List<y36> mListener;

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
        addListener(new d46());
        addListener(new e46());
        addListener(new c46());
    }

    public void addListener(y36 y36Var) {
        List<y36> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, y36Var) == null) || y36Var == null || (list = this.mListener) == null) {
            return;
        }
        list.add(y36Var);
    }

    public void clearListener() {
        List<y36> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.mListener) == null) {
            return;
        }
        list.clear();
    }

    @Override // com.repackage.dj8
    public boolean dealJsInterface(String str, String str2, String str3, JsPromptResult jsPromptResult) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, str3, jsPromptResult)) == null) {
            if (KEY_INTERFACE_NAME.equals(str2)) {
                try {
                    JSONObject jSONObject = new JSONObject(str3);
                    String optString = jSONObject.optString(KEY_METHOD_NAME);
                    if (oi.isEmpty(str2)) {
                        return false;
                    }
                    String trim = optString.trim();
                    for (y36 y36Var : this.mListener) {
                        if (trim.equals(y36Var.b())) {
                            y36Var.a(trim, jSONObject.optString("args"), jSONObject.optString(KEY_ARGS_EXT), jSONObject.optString(KEY_CALLBACK), jsPromptResult);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public void removeListener(y36 y36Var) {
        List<y36> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, y36Var) == null) || y36Var == null || (list = this.mListener) == null) {
            return;
        }
        list.remove(y36Var);
    }
}
