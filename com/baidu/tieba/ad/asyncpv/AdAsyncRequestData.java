package com.baidu.tieba.ad.asyncpv;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.recapp.constants.PlaceId;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import d.b.c.e.p.j;
import d.b.j0.j1.o.k.a;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AdAsyncRequestData extends HttpMessage {
    public AdAsyncRequestData(PlaceId placeId, Map<String, String> map, int i) {
        super(CmdConfigHttp.CMD_AD_ASYNC_BATCH_REQUEST);
        addCommonParams();
        addHeader("Cookie", CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        addParam("is_https", 1);
        addParam("flr", 1);
        addParam("sw", 0);
        addParam(IAdRequestParam.SCREEN_HEIGHT, 0);
        addParam("apna", TbadkCoreApplication.getInst().getPackageName());
        addParam("fc", 1);
        addParam("ft", 3);
        addParam(Config.EXCEPTION_CRASH_TYPE, "2");
        addParam("pid", placeId.value);
        String ext = getExt(map);
        if (!TextUtils.isEmpty(ext)) {
            addParam("ext", ext);
        }
        addParam("ac", i);
    }

    private void addCommonParams() {
        addParam(HttpRequest.CLIENT_VERSION, TbConfig.getVersion());
        addParam("uid", TbadkCoreApplication.getCurrentAccount());
        addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        addParam(TiebaStatic.Params.CUID_GALAXY2, TbadkCoreApplication.getInst().getCuidGalaxy2());
        addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        addParam("model", Build.MODEL);
        addParam(HttpRequest.CLIENT_TYPE, "2");
        addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
        addParam("net_type", String.valueOf(j.I()));
        addParam(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
        addParam(IAdRequestParam.ANDROID_ID, TbadkCoreApplication.getInst().getAndroidId());
    }

    public static JSONObject create(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_KEY, str);
            jSONObject.put("v", str2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String getExt(Map<String, String> map) {
        if (a.f(map)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONArray.put(create(entry.getKey(), entry.getValue()));
        }
        return jSONArray.toString();
    }
}
