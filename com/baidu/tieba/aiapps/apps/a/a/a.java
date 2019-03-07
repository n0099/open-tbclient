package com.baidu.tieba.aiapps.apps.a.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.scheme.actions.y;
import com.baidu.swan.apps.scheme.j;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends y {
    public a(j jVar) {
        super(jVar, "/swan/getBDUSS");
    }

    @Override // com.baidu.swan.apps.scheme.actions.y
    public boolean a(final Context context, UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        if (bVar == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty joParams");
            return false;
        }
        final String optString = optParamsAsJo.optString("cb");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "empty cb");
            return false;
        } else if (!(context instanceof Activity)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "the context is not an activity");
            return false;
        } else {
            bVar.Jb().a((Activity) context, "mapp_i_get_bduss", new com.baidu.swan.apps.an.c.a<Boolean>() { // from class: com.baidu.tieba.aiapps.apps.a.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.swan.apps.an.c.a
                /* renamed from: b */
                public void D(Boolean bool) {
                    JSONObject wrapCallbackParams;
                    if (!bool.booleanValue()) {
                        callbackHandler.handleSchemeDispatchCallback(optString, UnitedSchemeUtility.wrapCallbackParams(1001, "Permission denied").toString());
                        return;
                    }
                    String dC = com.baidu.tieba.aiapps.apps.a.a.dC(context);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bduss", dC);
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0);
                    } catch (JSONException e) {
                        if (a.DEBUG) {
                            e.printStackTrace();
                        }
                        wrapCallbackParams = UnitedSchemeUtility.wrapCallbackParams(1001, "result JSONException");
                    }
                    callbackHandler.handleSchemeDispatchCallback(optString, wrapCallbackParams.toString());
                }
            });
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, 0);
            return true;
        }
    }
}
