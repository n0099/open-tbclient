package com.baidu.tieba.ad.asyncpv;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.task.HttpMessageTask;
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
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c65;
import com.repackage.ip0;
import com.repackage.jp0;
import com.repackage.ki;
import com.repackage.ki0;
import com.repackage.nc5;
import com.repackage.oc5;
import com.repackage.on4;
import com.repackage.pd7;
import com.repackage.pp0;
import com.repackage.qn4;
import com.repackage.qp0;
import com.repackage.sj5;
import com.repackage.vi5;
import com.repackage.yo0;
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
    public static final Map<PlaceId, String> e;
    public static final Map<String, String> f;
    public transient /* synthetic */ FieldHolder $fh;
    public final PlaceId a;
    public final c b;
    public final HttpMessageListener c;
    public final ip0<List<AdvertAppInfo>> d;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadAsyncRequester a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(NadAsyncRequester nadAsyncRequester, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadAsyncRequester, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadAsyncRequester;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof AdAsyncResponseData) && httpResponsedMessage.getCmd() == 1003491) {
                AdAsyncResponseData adAsyncResponseData = (AdAsyncResponseData) httpResponsedMessage;
                Message<?> orginalMessage = adAsyncResponseData.getOrginalMessage();
                if (orginalMessage instanceof AdAsyncRequestData) {
                    if (!TextUtils.equals(this.a.a.value, (String) ((AdAsyncRequestData) orginalMessage).getParams().get("pid"))) {
                        return;
                    }
                }
                if (this.a.b != null) {
                    this.a.b.a(adAsyncResponseData.isSuccess(), adAsyncResponseData.getAds());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends jp0<List<AdvertAppInfo>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadAsyncRequester a;

        public b(NadAsyncRequester nadAsyncRequester) {
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

        @Override // com.repackage.hp0
        public void a(Exception exc, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.a(false, null);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: e */
        public void b(Headers headers, List<AdvertAppInfo> list, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(1048579, this, headers, list, i) == null) || this.a.b == null) {
                return;
            }
            this.a.b.a(true, list);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.ip0
        /* renamed from: f */
        public List<AdvertAppInfo> d(Headers headers, String str, int i) throws Exception {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048580, this, headers, str, i)) == null) {
                if (str == null) {
                    return null;
                }
                return sj5.a(str);
            }
            return (List) invokeLLI.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
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
        e = new HashMap<PlaceId, String>() { // from class: com.baidu.tieba.ad.asyncpv.NadAsyncRequester.1
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
        f = new HashMap();
        e("_client_version", TbConfig.getVersion());
        e("uid", TbadkCoreApplication.getCurrentAccount());
        e("cuid", TbadkCoreApplication.getInst().getCuid());
        e("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        e("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        e("model", Build.MODEL);
        e(HttpRequest.CLIENT_TYPE, "2");
        e("_os_version", Build.VERSION.RELEASE);
        e("net_type", String.valueOf(ki.I()));
        e(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
        e(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
        e(CommonUrlParamManager.PARAM_CMODE, PermissionUtil.isAgreePrivacyPolicy() ? "1" : "2");
        String sampleId = TbSingleton.getInstance().getSampleId();
        e("eid", sampleId == null ? "" : sampleId.replace(SignatureImpl.SEP, ','));
        e("app_transmit_data", oc5.a());
        e("is_https", "1");
        e("flr", "1");
        e(TbConfig.SW_APID, "0");
        e("sh", "0");
        e("apna", TbadkCoreApplication.getInst().getPackageName());
        e("fc", "1");
        e("ft", "3");
        e(Config.EXCEPTION_CRASH_TYPE, "2");
    }

    public NadAsyncRequester(@NonNull c cVar, @NonNull PlaceId placeId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar, placeId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new a(this, CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);
        this.d = new b(this);
        this.a = placeId;
        this.b = cVar;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST, TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch?adcmd=" + e.get(placeId));
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setIsNeedAddStatisticsParam(false);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setmIsNBaiduServer(false);
        tbHttpMessageTask.setResponsedClass(AdAsyncResponseData.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.c);
    }

    public static void d(@NonNull pp0 pp0Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pp0Var, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        pp0Var.a(str, str2);
    }

    public static void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65541, null, str, str2) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f.put(str, str2);
    }

    public static JSONObject f(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, str2)) == null) {
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

    public static String g(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (vi5.a().b("tieba_no_oaid_param", 0) != 1) {
                jSONArray.put(f(AdExtParam.KEY_IADEX, nc5.e()));
                jSONArray.put(f("oaid_v", PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst())));
                jSONArray.put(f("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst())));
            }
            jSONArray.put(f(AdExtParam.KEY_NAD_CORE_VERSION, "5.2.0.21"));
            if (!pd7.f(map)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONArray.put(f(entry.getKey(), entry.getValue()));
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }

    public void c(@NonNull pp0 pp0Var) {
        String b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pp0Var) == null) {
            AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
            if (currentAccountInfo != null) {
                b2 = currentAccountInfo.getBDUSS();
            } else if (!TbadkCoreApplication.getInst().isRemoteProcess()) {
                return;
            } else {
                b2 = c65.b();
            }
            if (TbadkCoreApplication.getInst().isRemoteProcess() && TextUtils.isEmpty(b2)) {
                currentAccountInfo = on4.e();
                if (currentAccountInfo == null) {
                    return;
                }
                b2 = currentAccountInfo.getBDUSS();
            }
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            d(pp0Var, HttpRequest.BDUSS, b2);
            String a2 = qn4.a(currentAccountInfo);
            if (StringUtils.isNull(a2)) {
                return;
            }
            d(pp0Var, "stoken", a2);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.c);
        }
    }

    public void i(Map<String, String> map, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, map, i) == null) {
            if (vi5.a().b("tieba_ad_net_sdk_swtich", 0) == 0) {
                MessageManager.getInstance().sendMessage(new AdAsyncRequestData(this.a, map, i));
                return;
            }
            yo0 b2 = yo0.b();
            qp0 qp0Var = new qp0();
            qp0Var.a("User-Agent", ki0.e());
            qp0Var.k(TbConfig.SERVER_ADDRESS + "tiebaads/commonbatch?adcmd=" + e.get(this.a));
            CookieManager cookieManager = null;
            try {
                cookieManager = CookieManager.getInstance();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (cookieManager != null) {
                String cookie = cookieManager.getCookie(TbPatternsCompat.TB_DOMAIN_NAME);
                if (!TextUtils.isEmpty(cookie)) {
                    qp0Var.a("Cookie", cookie);
                }
            }
            pp0 e3 = pp0.e(f);
            d(e3, "ext", g(map));
            d(e3, "pid", this.a.value);
            d(e3, D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, String.valueOf(i));
            c(e3);
            qp0Var.f(e3);
            b2.a().a(qp0Var, this.d);
        }
    }
}
