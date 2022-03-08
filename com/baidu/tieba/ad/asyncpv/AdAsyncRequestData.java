package com.baidu.tieba.ad.asyncpv;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import c.a.d.f.p.l;
import c.a.q0.c1.h;
import c.a.q0.c1.i;
import c.a.r0.m.a;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.util.AdExtParam;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class AdAsyncRequestData extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAsyncRequestData(PlaceId placeId, Map<String, String> map, int i2) {
        super(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);
        CookieManager cookieManager;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {placeId, map, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        addCommonParams();
        try {
            cookieManager = CookieManager.getInstance();
        } catch (Exception e2) {
            e2.printStackTrace();
            cookieManager = null;
        }
        if (cookieManager != null) {
            addHeader("Cookie", cookieManager.getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        }
        addParam("is_https", 1);
        addParam("flr", 1);
        addParam(TbConfig.SW_APID, 0);
        addParam("sh", 0);
        addParam("apna", TbadkCoreApplication.getInst().getPackageName());
        addParam("fc", 1);
        addParam("ft", 3);
        addParam("ct", "2");
        addParam("pid", placeId.value);
        String ext = getExt(map);
        if (!TextUtils.isEmpty(ext)) {
            addParam("ext", ext);
        }
        addParam("ac", i2);
    }

    private void addCommonParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            addParam("_client_version", TbConfig.getVersion());
            addParam("uid", TbadkCoreApplication.getCurrentAccount());
            addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            addParam("model", Build.MODEL);
            addParam(HttpRequest.CLIENT_TYPE, "2");
            addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            addParam("net_type", String.valueOf(l.I()));
            addParam(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            addParam(HttpRequest.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
            addParam(CommonUrlParamManager.PARAM_CMODE, PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2);
            String sampleId = TbSingleton.getInstance().getSampleId();
            addParam("eid", sampleId == null ? "" : sampleId.replace(SignatureImpl.SEP, ','));
            addParam("app_transmit_data", i.a());
        }
    }

    public static JSONObject create(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
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

    public static String getExt(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            JSONArray jSONArray = new JSONArray();
            if (a.a().b("tieba_no_oaid_param", 0) != 1) {
                jSONArray.put(create(AdExtParam.KEY_IADEX, h.e()));
                jSONArray.put(create("oaid_v", PermissionUtil.getLastCachedOid(TbadkCoreApplication.getInst())));
                jSONArray.put(create("mac", PermissionUtil.getLocalMacAddress(TbadkCoreApplication.getInst())));
            }
            if (c.a.r0.a.h().y()) {
                jSONArray.put(create(AdExtParam.KEY_NAD_CORE_VERSION, "5.0.0.12"));
            }
            if (!c.a.r0.z1.o.k.a.f(map)) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONArray.put(create(entry.getKey(), entry.getValue()));
                }
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }
}
