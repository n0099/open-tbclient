package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.request.task.ProgressInfo;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class g32 extends x22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.b02
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? "PreviewImageApi" : (String) invokeV.objValue;
    }

    /* loaded from: classes5.dex */
    public class a implements rq3<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ArrayMap a;
        public final /* synthetic */ JSONArray b;
        public final /* synthetic */ JSONArray c;
        public final /* synthetic */ JSONArray d;
        public final /* synthetic */ JSONObject e;
        public final /* synthetic */ g32 f;

        public a(g32 g32Var, ArrayMap arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g32Var, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f = g32Var;
            this.a = arrayMap;
            this.b = jSONArray;
            this.c = jSONArray2;
            this.d = jSONArray3;
            this.e = jSONObject;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rq3
        /* renamed from: b */
        public void a(String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) != null) || TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = null;
            try {
                jSONArray = new JSONArray(str);
            } catch (JSONException unused) {
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("fileID");
                    String optString2 = optJSONObject.optString("tempFileURL");
                    if (optJSONObject.optString("status").equals("0") && !TextUtils.isEmpty(optString2)) {
                        this.a.put(optString, optString2);
                    }
                }
                this.f.G(this.a, this.b, "images");
                this.f.G(this.a, this.c, "urls");
                this.f.G(this.a, this.d, "url");
                try {
                    this.e.put("images", this.b);
                    this.e.put("urls", this.c);
                    this.e.put("url", this.d);
                } catch (JSONException unused2) {
                }
                SwanAppActivity activity = lx2.T().getActivity();
                if (activity != null) {
                    fv2.C().b(activity, this.e);
                } else {
                    fv2.C().b(this.f.getContext(), this.e);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g32(@NonNull zz1 zz1Var) {
        super(zz1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zz1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((zz1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final String A(JSONArray jSONArray, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048576, this, jSONArray, str, i)) == null) {
            if (str.equals("images")) {
                return jSONArray.optJSONObject(i).optString("url");
            }
            return jSONArray.optString(i);
        }
        return (String) invokeLLI.objValue;
    }

    public y32 B(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            q("#handlePreviewImage", false);
            if (n()) {
                y82.c("PreviewImageApi", "PreviewImageApi does not supported when app is invisible.");
                return new y32(1001, "PreviewImageApi does not supported when app is invisible.");
            } else if (TextUtils.isEmpty(str)) {
                return new y32(202);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optBoolean("only_support_wifi") && !SwanAppNetworkUtils.j(getContext())) {
                        return new y32(403);
                    }
                    String optString = jSONObject.optString("source", "unitedscheme");
                    String optString2 = jSONObject.optString("type", "0");
                    JSONArray optJSONArray = jSONObject.optJSONArray("urls");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("images");
                        if (optJSONArray2 != null) {
                            F(optJSONArray2);
                            jSONObject.put("images", optJSONArray2);
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject jSONObject2 = new JSONObject();
                                String optString3 = optJSONArray.optString(i);
                                jSONObject2.put("url", optString3);
                                String b = fp3.b();
                                if (fp3.c(optString3) && !TextUtils.isEmpty(b)) {
                                    jSONObject2.put("referer", b);
                                }
                                String g0 = si2.U().g0();
                                if (!TextUtils.isEmpty(g0)) {
                                    jSONObject2.put(HttpRequest.USER_AGENT, g0);
                                }
                                jSONArray.put(jSONObject2);
                            }
                            jSONObject.put("images", jSONArray);
                        }
                        if (TextUtils.equals(optString, "swan")) {
                            C(optJSONArray);
                        }
                        jSONObject.put("url", optJSONArray);
                        jSONObject.put("type", optString2);
                        int z = z(jSONObject, optJSONArray);
                        if (z >= 0 && z < optJSONArray.length()) {
                            jSONObject.put("index", String.valueOf(z));
                            ArrayMap<String, String> arrayMap = new ArrayMap<>();
                            JSONArray optJSONArray3 = jSONObject.optJSONArray("images");
                            JSONArray optJSONArray4 = jSONObject.optJSONArray("urls");
                            JSONArray optJSONArray5 = jSONObject.optJSONArray("url");
                            D(arrayMap, optJSONArray3, "images");
                            D(arrayMap, optJSONArray4, "urls");
                            D(arrayMap, optJSONArray5, "url");
                            if (arrayMap.keySet().size() > 0) {
                                E(jSONObject, arrayMap, optJSONArray3, optJSONArray4, optJSONArray5);
                            } else {
                                Context activity = lx2.T().getActivity();
                                if (activity != null) {
                                    fv2.C().b(activity, jSONObject);
                                } else {
                                    fv2.C().b(getContext(), jSONObject);
                                }
                            }
                            return y32.f();
                        }
                        return new y32(202);
                    }
                    return new y32(202);
                } catch (JSONException unused) {
                    return new y32(202);
                }
            }
        }
        return (y32) invokeL.objValue;
    }

    public final JSONArray C(JSONArray jSONArray) {
        InterceptResult invokeL;
        yb3 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONArray)) == null) {
            int length = jSONArray.length();
            if (jSONArray != null && length > 0 && (M = yb3.M()) != null && !TextUtils.isEmpty(M.b) && !TextUtils.isEmpty(M.k0())) {
                for (int i = 0; i < length; i++) {
                    try {
                        String optString = jSONArray.optString(i);
                        PathType s = gj3.s(optString);
                        if (s == PathType.BD_FILE) {
                            optString = gj3.M(optString, M.b);
                        } else if (s == PathType.RELATIVE) {
                            optString = gj3.L(optString, M, M.k0());
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            jSONArray.put(i, optString);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
            return jSONArray;
        }
        return (JSONArray) invokeL.objValue;
    }

    public final void F(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, jSONArray) == null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("url");
                        String b = fp3.b();
                        if (fp3.c(optString) && !TextUtils.isEmpty(b)) {
                            optJSONObject.put("referer", b);
                        }
                        String g0 = si2.U().g0();
                        if (!TextUtils.isEmpty(g0)) {
                            optJSONObject.put(HttpRequest.USER_AGENT, g0);
                        }
                    }
                } catch (JSONException unused) {
                    return;
                }
            }
        }
    }

    public final void D(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048579, this, arrayMap, jSONArray, str) == null) && jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String A = A(jSONArray, str, i);
                if (!TextUtils.isEmpty(A) && gj3.s(A) == PathType.CLOUD) {
                    arrayMap.put(A, A);
                }
            }
        }
    }

    public final void E(JSONObject jSONObject, ArrayMap<String, String> arrayMap, JSONArray jSONArray, JSONArray jSONArray2, JSONArray jSONArray3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(1048580, this, jSONObject, arrayMap, jSONArray, jSONArray2, jSONArray3) == null) && jSONObject != null && arrayMap != null && arrayMap.keySet().size() > 0) {
            JSONArray jSONArray4 = new JSONArray();
            for (String str : arrayMap.values()) {
                jSONArray4.put(str);
            }
            gw1 l = fv2.l();
            if (l == null) {
                return;
            }
            l.c(getContext(), jSONArray4, new a(this, arrayMap, jSONArray, jSONArray2, jSONArray3, jSONObject));
        }
    }

    public final void G(ArrayMap<String, String> arrayMap, JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048582, this, arrayMap, jSONArray, str) == null) && arrayMap != null && jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String str2 = arrayMap.get(A(jSONArray, str, i));
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        if (str.equals("images")) {
                            jSONArray.optJSONObject(i).put("url", str2);
                        } else {
                            jSONArray.put(i, str2);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final int z(@NonNull JSONObject jSONObject, @NonNull JSONArray jSONArray) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject, jSONArray)) == null) {
            int optInt = jSONObject.optInt(ProgressInfo.JSON_KEY_CURRENT, -1);
            if (optInt >= 0) {
                return optInt;
            }
            String optString = jSONObject.optString(ProgressInfo.JSON_KEY_CURRENT);
            if (TextUtils.isEmpty(optString)) {
                return 0;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                if (TextUtils.equals(optString, jSONArray.getString(i))) {
                    return i;
                }
            }
            return -1;
        }
        return invokeLL.intValue;
    }
}
