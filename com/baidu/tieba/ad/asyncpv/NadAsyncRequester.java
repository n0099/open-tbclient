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
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.hi0;
import com.baidu.tieba.hr0;
import com.baidu.tieba.io5;
import com.baidu.tieba.ir0;
import com.baidu.tieba.jo5;
import com.baidu.tieba.or0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.sv4;
import com.baidu.tieba.th5;
import com.baidu.tieba.tv4;
import com.baidu.tieba.uh5;
import com.baidu.tieba.uw5;
import com.baidu.tieba.v38;
import com.baidu.tieba.wq0;
import com.baidu.tieba.zi0;
import com.baidu.tieba.zx5;
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
/* loaded from: classes3.dex */
public class NadAsyncRequester {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<PlaceId, String> d;
    public static final Map<String, String> e;
    public transient /* synthetic */ FieldHolder $fh;
    public final PlaceId a;
    public final b b;
    public final hr0<List<AdvertAppInfo>> c;

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, List<AdvertAppInfo> list);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a extends ir0<List<AdvertAppInfo>> {
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

        @Override // com.baidu.tieba.gr0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && this.a.b != null) {
                this.a.b.a(false, null);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: e */
        public void b(Headers headers, List<AdvertAppInfo> list, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(1048579, this, headers, list, i) == null) && this.a.b != null) {
                this.a.b.a(true, list);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.hr0
        /* renamed from: f */
        public List<AdvertAppInfo> d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                if (str == null) {
                    return null;
                }
                return zx5.a(str);
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
        String e2 = zi0.c().e(false);
        if (!TextUtils.isEmpty(e2)) {
            d("model", e2);
        }
        String h = zi0.c().h(false);
        if (!TextUtils.isEmpty(h)) {
            d("_os_version", h);
        }
        String b2 = zi0.c().b(false);
        if (!TextUtils.isEmpty(b2)) {
            d(HttpRequest.PHONE_IMEI, b2);
        }
        String a2 = zi0.c().a(false);
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
        d("app_transmit_data", jo5.a());
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

    public static void c(@NonNull or0 or0Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, or0Var, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            or0Var.a(str, str2);
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
            if (uw5.a().b("tieba_no_oaid_param", 0) != 1) {
                jSONArray.put(e(AdExtParam.KEY_IADEX, io5.e()));
                String f = zi0.c().f(false);
                if (!TextUtils.isEmpty(f)) {
                    jSONArray.put(e("oaid_v", f));
                }
                String d2 = zi0.c().d(false);
                if (!TextUtils.isEmpty(d2)) {
                    jSONArray.put(e("mac", d2));
                }
            }
            jSONArray.put(e(AdExtParam.KEY_NAD_CORE_VERSION, "5.11.0.5"));
            if (!v38.f(map)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONArray.put(e(entry.getKey(), entry.getValue()));
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public void b(@NonNull or0 or0Var) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, or0Var) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b2 = currentAccountInfo.getBDUSS();
            } else if (TbadkCoreApplication.getInst().isRemoteProcess()) {
                b2 = th5.b();
            } else {
                return;
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b2)) {
                currentAccountInfo = sv4.e();
                if (currentAccountInfo == null) {
                    return;
                }
                b2 = currentAccountInfo.getBDUSS();
            }
            if (!TextUtils.isEmpty(b2)) {
                c(or0Var, HttpRequest.BDUSS, b2);
                String a2 = tv4.a(currentAccountInfo);
                if (!StringUtils.isNull(a2)) {
                    c(or0Var, "stoken", a2);
                }
            }
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(TbSingleton.getInstance().getSampleId())) {
                TbSingleton.getInstance().setSampleId(uh5.e("multi_process_sample_id", ""));
            }
            return TbSingleton.getInstance().getSampleId();
        }
        return (String) invokeV.objValue;
    }

    public void i(Map<String, String> map, int i) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, map, i) == null) {
            wq0 b2 = wq0.b();
            pr0 pr0Var = new pr0();
            pr0Var.a("User-Agent", hi0.e());
            pr0Var.l(TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch?adcmd=" + d.get(this.a));
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie("tieba.baidu.com");
                if (!TextUtils.isEmpty(cookie)) {
                    pr0Var.a("Cookie", cookie);
                }
            }
            or0 e3 = or0.e(e);
            c(e3, "ext", f(map));
            c(e3, "pid", this.a.value);
            c(e3, "ac", String.valueOf(i));
            c(e3, TiebaStatic.Params.SAMPLE_ID, g());
            b(e3);
            pr0Var.f(e3);
            b2.a().a(pr0Var, this.c);
        }
    }
}
