package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.video.plugin.videoplayer.model.BdVideoAd;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.swan.game.ad.utils.NetworkUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class dx3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public JSONObject b;

    /* loaded from: classes4.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) ? response : invokeLI.objValue;
        }

        public a(dx3 dx3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dx3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    public dx3(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = jSONObject;
    }

    public final void a(@NonNull Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, request) == null) {
            we4 we4Var = new we4(request.url().toString(), new a(this));
            we4Var.f = true;
            we4Var.g = false;
            we4Var.h = false;
            xe4.g().d(we4Var);
        }
    }

    public void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            d(str, new HashMap<>());
        }
    }

    public final String b(String str, HashMap<String, String> hashMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap)) == null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("origin_time", String.valueOf(System.currentTimeMillis()));
            hashMap.putAll(hashMap2);
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
            }
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                str = str.replaceAll("%%" + entry.getKey() + "%%", entry.getValue());
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public void d(String str, HashMap<String, String> hashMap) {
        int i;
        JSONArray jSONArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hashMap) == null) {
            if (TextUtils.equals(str, "da_area")) {
                hashMap.put(BdVideoAd.AD_VIDEO_DAPAGE, "VIDEODETAIL_TAIL");
            } else if (!TextUtils.equals(str, "lpin") && !TextUtils.equals(str, "lpout")) {
                hashMap.put(BdVideoAd.AD_VIDEO_DAPAGE, "VIDEOADDETAI");
            } else {
                hashMap.put(BdVideoAd.AD_VIDEO_DAPAGE, "MINIAPP");
            }
            if (NetworkUtils.g(this.a) && TextUtils.equals(str, "vstart")) {
                i = 0;
            } else {
                i = 1;
            }
            hashMap.put("play_mode", String.valueOf(i));
            JSONObject jSONObject = this.b;
            if (jSONObject != null) {
                jSONArray = jSONObject.optJSONArray(str);
            } else {
                jSONArray = null;
            }
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String optString = jSONArray.optString(i2);
                    if (NetworkUtils.f(this.a) && !TextUtils.isEmpty(optString)) {
                        HttpUrl parse = HttpUrl.parse(b(optString, hashMap));
                        if (parse == null) {
                            return;
                        }
                        a(new Request.Builder().url(parse.newBuilder().build()).build());
                    }
                }
            }
        }
    }

    public void e(String str) {
        HttpUrl parse;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, str) != null) || !NetworkUtils.f(this.a) || TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return;
        }
        a(new Request.Builder().url(parse.newBuilder().build()).build());
    }
}
