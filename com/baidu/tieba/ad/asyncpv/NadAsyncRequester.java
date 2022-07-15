package com.baidu.tieba.ad.asyncpv;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.mobstat.Config;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.sofire.d.D;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cn4;
import com.repackage.co0;
import com.repackage.en4;
import com.repackage.gd7;
import com.repackage.hh0;
import com.repackage.mk5;
import com.repackage.mo0;
import com.repackage.ni;
import com.repackage.no0;
import com.repackage.p65;
import com.repackage.pj5;
import com.repackage.q65;
import com.repackage.to0;
import com.repackage.uo0;
import com.repackage.xc5;
import com.repackage.yc5;
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
    public final mo0<List<AdvertAppInfo>> c;

    /* loaded from: classes3.dex */
    public class a extends no0<List<AdvertAppInfo>> {
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

        @Override // com.repackage.lo0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.a(false, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: e */
        public void b(Headers headers, List<AdvertAppInfo> list, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, list, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.a(true, list);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.mo0
        /* renamed from: f */
        public List<AdvertAppInfo> d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                if (str == null) {
                    return null;
                }
                return mk5.a(str);
            }
            return (List) invokeLLI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z, List<AdvertAppInfo> list);
    }

    static {
        InterceptResult invokeClinit;
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
        d("model", Build.MODEL);
        d(HttpRequest.CLIENT_TYPE, "2");
        d("_os_version", Build.VERSION.RELEASE);
        d("net_type", String.valueOf(ni.I()));
        d(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
        d(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
        d(CommonUrlParamManager.PARAM_CMODE, PermissionUtil.isAgreePrivacyPolicy() ? "1" : "2");
        String sampleId = TbSingleton.getInstance().getSampleId();
        d("eid", sampleId == null ? "" : sampleId.replace(SignatureImpl.SEP, ','));
        d("app_transmit_data", yc5.a());
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

    public static void c(@NonNull to0 to0Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, to0Var, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        to0Var.a(str, str2);
    }

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        e.put(str, str2);
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
            if (pj5.a().b("tieba_no_oaid_param", 0) != 1) {
                jSONArray.put(e(AdExtParam.KEY_IADEX, xc5.e()));
                jSONArray.put(e("oaid_v", PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst())));
                jSONArray.put(e("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst())));
            }
            jSONArray.put(e(AdExtParam.KEY_NAD_CORE_VERSION, "5.5.0.11"));
            if (!gd7.f(map)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONArray.put(e(entry.getKey(), entry.getValue()));
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public void b(@NonNull to0 to0Var) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, to0Var) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b2 = currentAccountInfo.getBDUSS();
            } else if (!TbadkCoreApplication.getInst().isRemoteProcess()) {
                return;
            } else {
                b2 = p65.b();
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b2)) {
                currentAccountInfo = cn4.e();
                if (currentAccountInfo == null) {
                    return;
                }
                b2 = currentAccountInfo.getBDUSS();
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            c(to0Var, HttpRequest.BDUSS, b2);
            String a2 = en4.a(currentAccountInfo);
            if (StringUtils.isNull(a2)) {
                return;
            }
            c(to0Var, "stoken", a2);
        }
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (TextUtils.isEmpty(TbSingleton.getInstance().getSampleId())) {
                TbSingleton.getInstance().setSampleId(q65.d("multi_process_sample_id", ""));
            }
            return TbSingleton.getInstance().getSampleId();
        }
        return (String) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    public void i(Map<String, String> map, int i) {
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, map, i) == null) {
            co0 b2 = co0.b();
            uo0 uo0Var = new uo0();
            uo0Var.a("User-Agent", hh0.e());
            uo0Var.k(TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch?adcmd=" + d.get(this.a));
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
                cookieManager = null;
            }
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie("tieba.baidu.com");
                if (!TextUtils.isEmpty(cookie)) {
                    uo0Var.a("Cookie", cookie);
                }
            }
            to0 e3 = to0.e(e);
            c(e3, "ext", f(map));
            c(e3, "pid", this.a.value);
            c(e3, D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, String.valueOf(i));
            c(e3, TiebaStatic.Params.SAMPLE_ID, g());
            b(e3);
            uo0Var.f(e3);
            b2.a().a(uo0Var, this.c);
        }
    }
}
