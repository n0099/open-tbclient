package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ff3 extends x62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String j;
    public String k;
    public String l;
    public boolean m;
    public List<String> n;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947762166, "Lcom/baidu/tieba/ff3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947762166, "Lcom/baidu/tieba/ff3;");
                return;
            }
        }
        boolean z = rr1.a;
    }

    @Override // com.baidu.tieba.x62, com.baidu.tieba.g13
    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return !TextUtils.isEmpty(this.c);
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ff3() {
        super("webView", "viewId");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super((String) objArr[0], (String) objArr[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = true;
    }

    public static ff3 h(UnitedSchemeEntity unitedSchemeEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, unitedSchemeEntity)) == null) {
            if (unitedSchemeEntity == null) {
                return null;
            }
            String str = unitedSchemeEntity.getParams().get("params");
            ff3 ff3Var = new ff3();
            try {
                ff3Var.a(new JSONObject(str));
                return ff3Var;
            } catch (JSONException e) {
                h82.d(WebView.LOGTAG, "parsing params occurs exception", e);
                return null;
            }
        }
        return (ff3) invokeL.objValue;
    }

    @Override // com.baidu.tieba.x62, com.baidu.tieba.g13
    public void a(JSONObject jSONObject) throws JSONException {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        super.a(jSONObject);
        this.j = jSONObject.optString("src");
        this.k = jSONObject.optString(TTDownloadField.TT_USERAGENT);
        this.l = jSONObject.optString("type");
        JSONArray optJSONArray = jSONObject.optJSONArray("targetUrls");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            this.n = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                this.n.add(optJSONArray.optString(i));
            }
        }
    }
}
