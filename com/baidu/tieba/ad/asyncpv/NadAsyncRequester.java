package com.baidu.tieba.ad.asyncpv;

import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.account.AccountStorage;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.d46;
import com.baidu.tieba.g29;
import com.baidu.tieba.i56;
import com.baidu.tieba.it0;
import com.baidu.tieba.jt0;
import com.baidu.tieba.k05;
import com.baidu.tieba.kk0;
import com.baidu.tieba.pp5;
import com.baidu.tieba.pt0;
import com.baidu.tieba.pv5;
import com.baidu.tieba.qp5;
import com.baidu.tieba.qt0;
import com.baidu.tieba.qv5;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.sj0;
import com.baidu.tieba.xs0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NadAsyncRequester {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<PlaceId, String> d;
    public static final Map<String, String> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final PlaceId a;
    public final b b;
    public final it0<List<AdvertAppInfo>> c;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, List<AdvertAppInfo> list);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends jt0<List<AdvertAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadAsyncRequester a;

        public a(NadAsyncRequester nadAsyncRequester) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadAsyncRequester};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadAsyncRequester;
        }

        @Override // com.baidu.tieba.ht0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.b != null) {
                this.a.b.a(false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: e */
        public void b(Headers headers, List<AdvertAppInfo> list, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, list, i) == null) && this.a.b != null) {
                this.a.b.a(true, list);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.it0
        /* renamed from: f */
        public List<AdvertAppInfo> d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                if (str == null) {
                    return null;
                }
                return i56.a(str);
            }
            return (List) invokeLLI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        String str;
        String replace;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-868117835, "Lcom/baidu/tieba/ad/asyncpv/NadAsyncRequester;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-868117835, "Lcom/baidu/tieba/ad/asyncpv/NadAsyncRequester;");
                return;
            }
        }
        d = new HashMap<PlaceId, String>() { // from class: com.baidu.tieba.ad.asyncpv.NadAsyncRequester.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                put(PlaceId.PIC_PAGE_BANNER, "picbanner");
                put(PlaceId.PIC_PAGE_INSERT, "picpage");
                put(PlaceId.VIDEO_FLOW, "videoflow");
            }
        };
        e = new HashMap();
        d("_client_version", TbConfig.getVersion());
        d("uid", TbadkCoreApplication.getCurrentAccount());
        d("cuid", TbadkCoreApplication.getInst().getCuid());
        d("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        d("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        d(HttpRequest.CLIENT_TYPE, "2");
        d("net_type", String.valueOf(BdNetTypeUtil.netType()));
        if (!PermissionUtil.isAgreePrivacyPolicy()) {
            str = "2";
        } else {
            str = "1";
        }
        d("cmode", str);
        String e2 = kk0.c().e(false);
        if (!TextUtils.isEmpty(e2)) {
            d("model", e2);
        }
        String h = kk0.c().h(false);
        if (!TextUtils.isEmpty(h)) {
            d(HttpRequest.OS_VERSION, h);
        }
        String b2 = kk0.c().b(false);
        if (!TextUtils.isEmpty(b2)) {
            d(HttpRequest.PHONE_IMEI, b2);
        }
        String a2 = kk0.c().a(false);
        if (!TextUtils.isEmpty(a2)) {
            d(HttpRequest.ANDROID_ID, a2);
        }
        String sampleId = TbSingleton.getInstance().getSampleId();
        if (sampleId == null) {
            replace = "";
        } else {
            replace = sampleId.replace(SignatureImpl.SEP, ',');
        }
        d("eid", replace);
        d("app_transmit_data", qv5.a());
        d("is_https", "1");
        d("flr", "1");
        d(TbConfig.SW_APID, "0");
        d("sh", "0");
        d("apna", TbadkCoreApplication.getInst().getPackageName());
        d("fc", "1");
        d("ft", "3");
        d(Config.EXCEPTION_CRASH_TYPE, "2");
    }

    public NadAsyncRequester(@NonNull b bVar, @NonNull PlaceId placeId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, placeId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.a = placeId;
        this.b = bVar;
    }

    public static void c(@NonNull pt0 pt0Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, pt0Var, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            pt0Var.a(str, str2);
        }
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            e.put(str, str2);
        }
    }

    public static JSONObject e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k", str);
                jSONObject.put("v", str2);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String f(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, map)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (d46.a().b("tieba_no_oaid_param", 0) != 1) {
                jSONArray.put(e(AdExtParam.KEY_IADEX, pv5.e()));
                String f = kk0.c().f(false);
                if (!TextUtils.isEmpty(f)) {
                    jSONArray.put(e("oaid_v", f));
                }
                String d2 = kk0.c().d(false);
                if (!TextUtils.isEmpty(d2)) {
                    jSONArray.put(e("mac", d2));
                }
            }
            jSONArray.put(e(AdExtParam.KEY_NAD_CORE_VERSION, "5.12.0.98"));
            if (!g29.f(map)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONArray.put(e(entry.getKey(), entry.getValue()));
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public void b(@NonNull pt0 pt0Var) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pt0Var) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b2 = currentAccountInfo.getBDUSS();
            } else if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                b2 = pp5.b();
            } else {
                return;
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b2)) {
                currentAccountInfo = AccountStorage.getActiveAccountData();
                if (currentAccountInfo == null) {
                    return;
                }
                b2 = currentAccountInfo.getBDUSS();
            }
            if (!TextUtils.isEmpty(b2)) {
                c(pt0Var, HttpRequest.BDUSS, b2);
                String a2 = k05.a(currentAccountInfo);
                if (!StringUtils.isNull(a2)) {
                    c(pt0Var, "stoken", a2);
                }
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(TbSingleton.getInstance().getSampleId())) {
                TbSingleton.getInstance().setSampleId(qp5.i("multi_process_sample_id", ""));
            }
            return TbSingleton.getInstance().getSampleId();
        }
        return (String) invokeV.objValue;
    }

    public void i(Map<String, String> map, int i) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, map, i) == null) {
            xs0 b2 = xs0.b();
            qt0 qt0Var = new qt0();
            qt0Var.a("User-Agent", sj0.e());
            qt0Var.l(TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch?adcmd=" + d.get(this.a));
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie("tieba.baidu.com");
                if (!TextUtils.isEmpty(cookie)) {
                    qt0Var.a("Cookie", cookie);
                }
            }
            pt0 e3 = pt0.e(e);
            c(e3, "ext", f(map));
            c(e3, "pid", this.a.value);
            c(e3, "ac", String.valueOf(i));
            c(e3, TiebaStatic.Params.SAMPLE_ID, g());
            b(e3);
            qt0Var.f(e3);
            b2.a().a(qt0Var, this.c);
        }
    }
}
