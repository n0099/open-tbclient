package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.share.QzonePublish;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static String c;
    public transient /* synthetic */ FieldHolder $fh;
    public c42 a;

    public static /* synthetic */ String f(String str) {
        return str;
    }

    /* loaded from: classes6.dex */
    public class a implements hs1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jc4 a;
        public final /* synthetic */ hc4 b;

        public a(hc4 hc4Var, jc4 jc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc4Var, jc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hc4Var;
            this.a = jc4Var;
        }

        @Override // com.baidu.tieba.hs1
        public void onResult(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i != 0) {
                    if (hc4.b) {
                        Log.d("ShareVideoApi", "login fail");
                    }
                    this.b.j("shareVideo: fail, no login in");
                    return;
                }
                if (hc4.b) {
                    Log.d("ShareVideoApi", "login success");
                }
                this.b.h(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements ic4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc4 a;

        public b(hc4 hc4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc4Var;
        }

        @Override // com.baidu.tieba.ic4
        public void a(jc4 jc4Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, jc4Var, str) == null) {
                if (hc4.b) {
                    Log.d("ShareVideoApi", String.format("onFail params = %s;errMsg = %s", jc4Var, str));
                }
                this.a.j(str);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                if (hc4.b) {
                    iOException.printStackTrace();
                }
                hc4.g();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    JSONObject jSONObject = (JSONObject) new JSONObject(response.body().string()).opt("data");
                    if (jSONObject == null) {
                        hc4.g();
                        return;
                    }
                    String unused = hc4.c = jSONObject.optString("community_id");
                    hc4.f(jSONObject.optString("url"));
                } catch (JSONException e) {
                    if (hc4.b) {
                        e.printStackTrace();
                    }
                    hc4.g();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947818896, "Lcom/baidu/tieba/hc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947818896, "Lcom/baidu/tieba/hc4;");
                return;
            }
        }
        b = fs1.a;
        String str = p82.c() + "/webpage";
        c = "";
    }

    public hc4(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jsObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = c42.F(jsObject);
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            c = "";
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            xi3 xi3Var = new xi3();
            xi3Var.b = "shareVideo";
            xi3Var.e = "fail";
            oi3.h(xi3Var);
        }
    }

    public final void h(jc4 jc4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, jc4Var) == null) {
            m84.i().a(jc4Var, new b(this));
        }
    }

    public final void j(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) || this.a == null) {
            return;
        }
        e64 e64Var = new e64();
        e64Var.errMsg = String.format(Locale.CHINA, "shareVideo: fail, %s", str);
        he4.call(this.a, false, e64Var);
        i();
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, null) == null) {
            ca4 ca4Var = (ca4) vb3.M().i0();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("app_type", 0);
                jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, vb3.g0());
            } catch (JSONException e) {
                if (b) {
                    e.printStackTrace();
                }
            }
            HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/ugc/query_community_by_app").newBuilder();
            newBuilder.addQueryParameter("data", jSONObject.toString());
            ca4Var.call(new Request.Builder().url(newBuilder.build()).build(), new c());
        }
    }

    public final jc4 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                i();
                return null;
            } else if (vb3.M() == null) {
                j("shareVideo: fail, swanApp is null");
                return null;
            } else {
                String B = this.a.B(QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH);
                if (TextUtils.isEmpty(B)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                String B2 = fo2.B(B);
                if (TextUtils.isEmpty(B2)) {
                    j("shareVideo: videoPath is invalid");
                    return null;
                }
                jc4 jc4Var = new jc4();
                jc4Var.a = B2;
                jc4Var.c = this.a.B("title");
                jc4Var.b = this.a.B("query");
                kc4 kc4Var = new kc4();
                kc4Var.a = this.a.y("clipMaxDuration", 30L);
                kc4Var.b = this.a.y("clipMinDuration", 3L);
                kc4Var.c = this.a.B("topicSource");
                kc4Var.d = this.a.C("publishTitle", cv2.c().getResources().getString(R.string.obfuscated_res_0x7f0f159a));
                kc4Var.e = this.a.C("publishURL", "/searchbox?action=ugc&cmd=177");
                kc4Var.i = this.a.r("sourceType", 1);
                kc4Var.j = this.a.C("sourceFrom", "tiny");
                kc4Var.g = this.a.C("atURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fmbd.baidu.com%2Fwebpage%3Ftype%3Dtopic%26action%3Dat&newbrowser=1");
                kc4Var.f = this.a.C("musicURL", "https://sv.baidu.com/feedvideoui/view/videomusic");
                kc4Var.h = this.a.C("topicURL", "baiduboxapp://v1/easybrowse/open?newbrowser=1&style=%7B%22menumode%22%3A%222%22%2C%22showtoolbar%22%3A%221%22%7D&url=https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Ftopiclist");
                kc4Var.k = this.a.C("publishType", "9");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(GameGuideConfigInfo.KEY_APP_KEY, vb3.g0());
                    jSONObject.put("frame_type", ub3.K().k());
                    jSONObject.put("query", jc4Var.b);
                    if (vb3.M() != null && vb3.M().Y() != null) {
                        jSONObject.put("title", vb3.M().Y().K());
                    }
                } catch (JSONException e) {
                    if (b) {
                        Log.d("ShareVideoApi", e.toString());
                    }
                }
                jSONObject.toString();
                if (!TextUtils.isEmpty(c)) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("id", c);
                        if (vb3.M() != null && vb3.M().Y() != null) {
                            jSONObject2.put("name", vb3.M().Y().K());
                        }
                        jSONObject2.put("type", "interest");
                        jSONObject2.put("post_id", "");
                    } catch (JSONException e2) {
                        if (b) {
                            Log.d("ShareVideoApi", e2.toString());
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("tag", jSONArray);
                    } catch (JSONException e3) {
                        if (b) {
                            Log.d("ShareVideoApi", e3.toString());
                        }
                    }
                    kc4Var.l = jSONObject3.toString();
                    kc4Var.m = -1;
                } else {
                    kc4Var.m = 0;
                }
                jc4Var.e = kc4Var;
                return jc4Var;
            }
        }
        return (jc4) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            xi3 xi3Var = new xi3();
            xi3Var.b = "shareVideo";
            oi3.h(xi3Var);
            jc4 k = k();
            if (k == null) {
                return;
            }
            is1 N = vb3.M().N();
            if (N.e(cv2.c())) {
                h(k);
                return;
            }
            SwanAppActivity activity = ix2.T().getActivity();
            if (activity == null) {
                j("shareVideo: swanAppActivity is null");
            } else {
                N.f(activity, null, new a(this, k));
            }
        }
    }
}
