package com.baidu.tieba.aiapps.apps.m;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.sofire.ac.FH;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/getCommonSysInfo");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            c.i("GetSysInfo", "swanApp is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "illegal swanApp");
            return false;
        }
        final String optString = n.dk(unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS)).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            c.i("GetSysInfo", "cb is empty");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        bVar.Jb().a((Activity) context, "mapp_i_get_common_sys_info", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.tieba.aiapps.apps.m.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.an.c.a
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
        String bJ = com.baidu.swan.apps.u.a.CD().bJ(appContext);
        String imei = TbadkCoreApplication.getInst().getImei();
        String gz = FH.gz(TbadkCoreApplication.getInst());
        String bI = com.baidu.swan.apps.u.a.CD().bI(appContext);
        String cookie = new com.baidu.swan.apps.q.a.b.a().getCookie(".baidu.com");
        String cg = cg(cookie, "BAIDUID");
        String cg2 = cg(cookie, "H_WISE_SIDS");
        if (DEBUG) {
            Log.d("GetSysInfoAction", "cuid = " + bJ + ", imei = " + imei + ", zid = " + gz + ", uid = " + bI + ", baiDuId = " + cg + ", sid = " + cg2);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cuid", bJ);
            jSONObject.put("imei", imei);
            jSONObject.put("zid", gz);
            jSONObject.put("uid", bI);
            jSONObject.put("baidu_id", cg);
            jSONObject.put("sid", cg2);
            c.i("GetSysInfo", "fetch commonSysInfo success");
            callbackHandler.handleSchemeDispatchCallback(str, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private static String cg(String str, String str2) {
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
