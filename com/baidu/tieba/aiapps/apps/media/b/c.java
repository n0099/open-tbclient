package com.baidu.tieba.aiapps.apps.media.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.u.b.m;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tbadk.core.util.aq;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c implements m {
    protected String dqw = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        boolean a(Context context, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar);
    }

    private JSONObject fT(String str) {
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

    private e d(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        com.baidu.swan.apps.media.a t = com.baidu.swan.apps.media.b.t(str, str2, str3);
        if (t == null && aq.equals("/swan/live/open", this.dqw)) {
            this.dqw = "";
            return new e(context, str3);
        } else if (t == null || !(t.LM() instanceof e)) {
            return null;
        } else {
            return (e) t.LM();
        }
    }

    private boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, a aVar) {
        JSONObject fT = fT(unitedSchemeEntity.getParam("params"));
        if (fT == null) {
            com.baidu.swan.apps.console.c.e("Live", "object is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString = fT.optString("liveId");
        BdLog.d("parseEntity  playerID " + optString);
        e d = d(context, fT.optString("slaveId"), fT.optString("sanId"), optString);
        if (context == null || d == null) {
            com.baidu.swan.apps.console.c.e("Live", "livePlayer is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.b.a a2 = com.baidu.tieba.aiapps.apps.media.b.a.a(fT, d.aGZ());
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

    private boolean n(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.1
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.start();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean o(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.2
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.stop();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean p(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.3
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                com.baidu.swan.apps.view.container.a ji = com.baidu.swan.apps.view.container.c.c.ji(aVar.aXH);
                SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, ji);
                if (ji != null && a2 != null) {
                    com.baidu.swan.apps.view.container.c.c.b(a2, ji);
                    com.baidu.swan.apps.view.container.c.c.d(a2, ji);
                }
                eVar.release();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean q(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.4
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.k(aVar.aWW, aVar.mDirection);
                return true;
            }
        });
    }

    private boolean r(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.5
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.bJ(aVar.dqr);
                return true;
            }
        });
    }

    private boolean s(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.6
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.stop();
                return true;
            }
        });
    }

    private boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.7
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.start();
                return false;
            }
        });
    }

    private boolean u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.8
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.f(aVar);
                if (aVar.hidden && eVar.isPlaying()) {
                    eVar.stop();
                    return true;
                }
                return true;
            }
        });
    }

    private boolean v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.c.9
            @Override // com.baidu.tieba.aiapps.apps.media.b.c.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, e eVar) {
                eVar.a(aVar);
                return true;
            }
        });
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        this.dqw = "/swan/live/open";
        return v(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return u(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean f(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return t(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return s(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return r(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return q(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return p(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return o(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return n(context, unitedSchemeEntity, callbackHandler, bVar);
    }
}
