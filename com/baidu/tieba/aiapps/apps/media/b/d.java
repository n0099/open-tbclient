package com.baidu.tieba.aiapps.apps.media.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class d implements com.baidu.swan.apps.w.b.e {
    protected String eea = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public interface a {
        boolean a(Context context, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar);
    }

    private JSONObject iZ(String str) {
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

    private f d(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        com.baidu.swan.apps.media.a B = com.baidu.swan.apps.media.b.B(str, str2, str3);
        if (B == null && aq.equals("/swanAPI/live/open", this.eea)) {
            this.eea = "";
            return new f(context, str3);
        } else if (B == null || !(B.Xc() instanceof f)) {
            return null;
        } else {
            return (f) B.Xc();
        }
    }

    private boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar, a aVar) {
        JSONObject iZ = iZ(unitedSchemeEntity.getParam("params"));
        if (iZ == null) {
            com.baidu.swan.apps.console.c.e("Live", "object is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString = iZ.optString("liveId");
        BdLog.d("parseEntity  playerID " + optString);
        f d = d(context, iZ.optString("slaveId"), iZ.optString("sanId"), optString);
        if (context == null || d == null) {
            com.baidu.swan.apps.console.c.e("Live", "livePlayer is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.b.a a2 = com.baidu.tieba.aiapps.apps.media.b.a.a(iZ, d.aZX());
        if (!a2.isValid()) {
            com.baidu.swan.apps.console.c.e("Live", "params is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        } else if (aVar != null) {
            return aVar.a(context, a2, d);
        } else {
            return false;
        }
    }

    private boolean o(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.1
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.start();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean p(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.2
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.stop();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean q(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.3
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                if (fVar != null) {
                    fVar.release();
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.4
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.f(aVar.bEl, aVar.mDirection);
                return true;
            }
        });
    }

    private boolean s(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.5
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.cJ(aVar.edT);
                return true;
            }
        });
    }

    private boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.6
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.stop();
                return true;
            }
        });
    }

    private boolean u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.7
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.start();
                return false;
            }
        });
    }

    private boolean v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.8
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.e(aVar);
                if (aVar.hidden && fVar.isPlaying()) {
                    fVar.stop();
                    return true;
                }
                return true;
            }
        });
    }

    private boolean w(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return a(context, unitedSchemeEntity, callbackHandler, eVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.9
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.a(aVar);
                return true;
            }
        });
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        this.eea = "/swanAPI/live/open";
        return w(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return v(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean f(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return u(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return t(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return s(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return r(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return q(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return p(context, unitedSchemeEntity, callbackHandler, eVar);
    }

    @Override // com.baidu.swan.apps.w.b.e
    public boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.runtime.e eVar) {
        return o(context, unitedSchemeEntity, callbackHandler, eVar);
    }
}
