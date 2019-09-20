package com.baidu.tieba.aiapps.apps.n;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.o;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.z;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends z {
    public a(j jVar) {
        super(jVar, "/swan/getCommonSysInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.z
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            c.i("GetSysInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        final String optString = o.df(unitedSchemeEntity.getParam("params")).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.i("GetSysInfo", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        bVar.Ml().a((Activity) context, "mapp_i_get_common_sys_info", new com.baidu.swan.apps.an.d.a<Boolean>() { // from class: com.baidu.tieba.aiapps.apps.n.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.d.a
            /* renamed from: b */
            public void D(Boolean bool) {
                if (bool.booleanValue()) {
                    a.this.a(context, optString, callbackHandler);
                    return;
                }
                c.i("GetSysInfo", "non-authorized");
                callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(402).toString());
            }
        });
        c.i("GetSysInfo", "callback success");
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, CallbackHandler callbackHandler) {
        Context appContext = AppRuntime.getAppContext();
        String bd = com.baidu.swan.apps.u.a.Et().bd(appContext);
        String PR = ac.PR();
        String ds = com.baidu.tieba.aiapps.apps.a.c.ds(context);
        String bc = com.baidu.swan.apps.u.a.Et().bc(appContext);
        String cookie = com.baidu.swan.apps.u.a.EL().Fj().getCookie(".baidu.com");
        String cu = cu(cookie, "BAIDUID");
        String cu2 = cu(cookie, "H_WISE_SIDS");
        if (DEBUG) {
            Log.d("GetSysInfoAction", "cuid = " + bd + ", imei = " + PR + ", zid = " + ds + ", uid = " + bc + ", baiDuId = " + cu + ", sid = " + cu2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DpStatConstants.KEY_CUID, bd);
            jSONObject.put("imei", PR);
            jSONObject.put("zid", ds);
            jSONObject.put("uid", bc);
            jSONObject.put("baidu_id", cu);
            jSONObject.put("sid", cu2);
            c.i("GetSysInfo", "fetch commonSysInfo success");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private static String cu(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        int length = split.length;
        for (int i = 0; i != length; i++) {
            String trim = split[i].trim();
            String[] split2 = trim.split("=");
            if (split2.length >= 2 && TextUtils.equals(str2, split2[0])) {
                if (split2.length == 2) {
                    return split2[1];
                } else {
                    return trim.substring(split2[0].length() + 1);
                }
            }
        }
        return null;
    }
}
