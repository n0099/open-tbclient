package com.baidu.tieba.aiapps.apps.media.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAiAppLiveIoc {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.aiapps.apps.media.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0201a {
        boolean a(Context context, b bVar, e eVar);
    }

    private JSONObject getParamsJSONObject(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            Log.e("Live", Log.getStackTraceString(e));
            jSONObject = null;
        }
        return jSONObject;
    }

    private e au(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        AiAppsPlayerContext playerContext = AiAppsPlayerManager.getPlayerContext(str);
        if (playerContext == null) {
            return new e(context, str);
        }
        if (playerContext.getPlayerObject() instanceof e) {
            return (e) playerContext.getPlayerObject();
        }
        return null;
    }

    private boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp, InterfaceC0201a interfaceC0201a) {
        JSONObject paramsJSONObject = getParamsJSONObject(unitedSchemeEntity.getParam("params"));
        if (paramsJSONObject == null) {
            AiAppsLog.e("Live", "object is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString = paramsJSONObject.optString("liveId");
        BdLog.d("parseEntity  playerID " + optString);
        e au = au(context, optString);
        if (au == null) {
            AiAppsLog.e("Live", "livePlayer is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        b a = b.a(paramsJSONObject, au.YL());
        if (interfaceC0201a != null) {
            return interfaceC0201a.a(context, a, au);
        }
        return false;
    }

    private boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return a(context, unitedSchemeEntity, callbackHandler, aiApp, new InterfaceC0201a() { // from class: com.baidu.tieba.aiapps.apps.media.b.a.1
            @Override // com.baidu.tieba.aiapps.apps.media.b.a.InterfaceC0201a
            public boolean a(Context context2, b bVar, e eVar) {
                eVar.f(bVar.bIQ, bVar.mDirection);
                return true;
            }
        });
    }

    private boolean b(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return a(context, unitedSchemeEntity, callbackHandler, aiApp, new InterfaceC0201a() { // from class: com.baidu.tieba.aiapps.apps.media.b.a.2
            @Override // com.baidu.tieba.aiapps.apps.media.b.a.InterfaceC0201a
            public boolean a(Context context2, b bVar, e eVar) {
                eVar.dD(bVar.bIK);
                return true;
            }
        });
    }

    private boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return a(context, unitedSchemeEntity, callbackHandler, aiApp, new InterfaceC0201a() { // from class: com.baidu.tieba.aiapps.apps.media.b.a.3
            @Override // com.baidu.tieba.aiapps.apps.media.b.a.InterfaceC0201a
            public boolean a(Context context2, b bVar, e eVar) {
                eVar.stop();
                return true;
            }
        });
    }

    private boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return a(context, unitedSchemeEntity, callbackHandler, aiApp, new InterfaceC0201a() { // from class: com.baidu.tieba.aiapps.apps.media.b.a.4
            @Override // com.baidu.tieba.aiapps.apps.media.b.a.InterfaceC0201a
            public boolean a(Context context2, b bVar, e eVar) {
                eVar.start();
                return false;
            }
        });
    }

    private boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return a(context, unitedSchemeEntity, callbackHandler, aiApp, new InterfaceC0201a() { // from class: com.baidu.tieba.aiapps.apps.media.b.a.5
            @Override // com.baidu.tieba.aiapps.apps.media.b.a.InterfaceC0201a
            public boolean a(Context context2, b bVar, e eVar) {
                eVar.e(bVar);
                if (bVar.hidden && eVar.isPlaying()) {
                    eVar.stop();
                    return true;
                }
                return true;
            }
        });
    }

    private boolean f(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return a(context, unitedSchemeEntity, callbackHandler, aiApp, new InterfaceC0201a() { // from class: com.baidu.tieba.aiapps.apps.media.b.a.6
            @Override // com.baidu.tieba.aiapps.apps.media.b.a.InterfaceC0201a
            public boolean a(Context context2, b bVar, e eVar) {
                eVar.a(bVar);
                return true;
            }
        });
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc
    public boolean open(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return f(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc
    public boolean update(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return e(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc
    public boolean play(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return d(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc
    public boolean stop(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return c(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc
    public boolean mute(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return b(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppLiveIoc
    public boolean setFullScreen(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return a(context, unitedSchemeEntity, callbackHandler, aiApp);
    }
}
