package com.baidu.tieba.ad.asyncpv;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import c.a.e.e.p.j;
import c.a.q0.d1.g;
import c.a.r0.q1.o.k.a;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AdAsyncRequestData extends HttpMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAsyncRequestData(PlaceId placeId, Map<String, String> map, int i2) {
        super(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);
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
        addHeader("Cookie", CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        addParam("is_https", 1);
        addParam("flr", 1);
        addParam("sw", 0);
        addParam(IAdRequestParam.SCREEN_HEIGHT, 0);
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
            addParam("net_type", String.valueOf(j.I()));
            addParam(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            addParam(IAdRequestParam.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
            addParam("cmode", PermissionUtil.isAgreePrivacyPolicy() ? 1 : 2);
            addParam("app_transmit_data", g.a());
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
            if (a.f(map)) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONArray.put(create(entry.getKey(), entry.getValue()));
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }
}
