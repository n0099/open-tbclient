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
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.util.ap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d implements m {
    protected String cVl = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public interface a {
        boolean a(Context context, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar);
    }

    private JSONObject eV(String str) {
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
        com.baidu.swan.apps.media.a p = com.baidu.swan.apps.media.b.p(str, str2, str3);
        if (p == null && ap.equals("/swan/live/open", this.cVl)) {
            this.cVl = "";
            return new f(context, str3);
        } else if (p == null || !(p.Ek() instanceof f)) {
            return null;
        } else {
            return (f) p.Ek();
        }
    }

    private boolean a(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar, a aVar) {
        JSONObject eV = eV(unitedSchemeEntity.getParam(LegoListActivityConfig.PARAMS));
        if (eV == null) {
            com.baidu.swan.apps.console.c.e("Live", "object is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        String optString = eV.optString("liveId");
        BdLog.d("parseEntity  playerID " + optString);
        f d = d(context, eV.optString("slaveId"), eV.optString("sanId"), optString);
        if (context == null || d == null) {
            com.baidu.swan.apps.console.c.e("Live", "livePlayer is null");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.b.a a2 = com.baidu.tieba.aiapps.apps.media.b.a.a(eV, d.azA());
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

    private boolean q(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.1
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.stop();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean r(Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.2
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                com.baidu.swan.apps.view.container.a hR = com.baidu.swan.apps.view.container.c.c.hR(aVar.aBC);
                SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(aVar, hR);
                if (hR != null && a2 != null) {
                    com.baidu.swan.apps.view.container.c.c.b(a2, hR);
                    com.baidu.swan.apps.view.container.c.c.d(a2, hR);
                }
                fVar.release();
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
        });
    }

    private boolean s(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.3
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.j(aVar.cVj, aVar.mDirection);
                return true;
            }
        });
    }

    private boolean t(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.4
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.fY(aVar.cVd);
                return true;
            }
        });
    }

    private boolean u(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.5
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.stop();
                return true;
            }
        });
    }

    private boolean v(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.6
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.start();
                return false;
            }
        });
    }

    private boolean w(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.7
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

    private boolean x(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return a(context, unitedSchemeEntity, callbackHandler, bVar, new a() { // from class: com.baidu.tieba.aiapps.apps.media.b.d.8
            @Override // com.baidu.tieba.aiapps.apps.media.b.d.a
            public boolean a(Context context2, com.baidu.tieba.aiapps.apps.media.b.a aVar, f fVar) {
                fVar.a(aVar);
                return true;
            }
        });
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        this.cVl = "/swan/live/open";
        return x(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return w(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean f(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return v(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return u(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean h(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return t(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean i(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return s(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return r(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return q(context, unitedSchemeEntity, callbackHandler, bVar);
    }

    @Override // com.baidu.swan.apps.u.b.m
    public boolean k(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return r(context, unitedSchemeEntity, callbackHandler, bVar);
    }
}
