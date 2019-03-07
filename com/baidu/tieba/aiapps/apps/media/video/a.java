package com.baidu.tieba.aiapps.apps.media.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.u.b.v;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements v {
    @Override // com.baidu.swan.apps.u.b.v
    public boolean c(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a aV = aV(optParamsAsJo);
        if (aV == null) {
            com.baidu.tieba.aiapps.apps.media.video.view.a aVar = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
            com.baidu.swan.apps.media.b.a(aVar);
            aV = aVar;
        }
        c a = c.a(optParamsAsJo, aV.azF());
        a(context, aV, a);
        c azF = aV.azF();
        aV.a(a);
        if (a.isAutoPlay()) {
            if (!TextUtils.equals(azF.mSrc, a.mSrc)) {
                if (aV.ql()) {
                    aV.stopPlay();
                    aV.bSB();
                }
            } else if (aV.hasStart()) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            aV.cf(a.mSrc, null);
        } else {
            aV.setVideoUrl(a.mSrc, null);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a aV = aV(optParamsAsJo);
        if (aV == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        c a = c.a(optParamsAsJo, aV.azF());
        c azF = aV.azF();
        aV.a(a);
        if (!TextUtils.equals(azF.mSrc, a.mSrc)) {
            if (aV.ql()) {
                aV.stopPlay();
            }
            aV.cf(a.mSrc, null);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean f(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a aV = aV(optParamsAsJo);
        if (aV == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        c a = c.a(optParamsAsJo, aV.azF());
        c azF = aV.azF();
        if (aV.hasStart() && TextUtils.equals(a.mSrc, azF.mSrc)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        aV.a(a);
        aV.cf(a.mSrc, null);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean j(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a aV = aV(optParamsAsJo);
        if (aV == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        aV.pausePlay();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean l(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a aV = aV(optParamsAsJo);
        if (aV == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        aV.getVideoView().seekTo(c.a(optParamsAsJo, aV.azF()).mPos);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean m(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "json object is null");
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a aV = aV(optParamsAsJo);
        if (aV == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        aV.ga(optParamsAsJo.optBoolean("fullScreen", false));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean n(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        return false;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean Dw() {
        return false;
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.media.video.view.a aVar, c cVar) {
        SwanAppNAViewContainer swanAppNAViewContainer;
        if (aVar != null && aVar.bSW() != null) {
            SwanAppNAViewContainer a = com.baidu.swan.apps.view.container.c.b.a(cVar.aBC, cVar.id, aa.hM(cVar.aBC));
            if (aVar.bSW().getParent() != null) {
                ((ViewGroup) aVar.bSW().getParent()).removeView(aVar.bSW());
            }
            if (a == null) {
                swanAppNAViewContainer = new SwanAppNAViewContainer(context);
                swanAppNAViewContainer.a(aVar.bSW(), cVar);
            } else {
                com.baidu.swan.apps.model.a.a.a EM = cVar.EM();
                a.MK();
                EM.aBC = a.getSlaveId();
                EM.aBD = a.getParentId();
                EM.id = a.getViewId();
                EM.aBE.setTop(EM.aBE.getTop());
                EM.aBE.setHeight(EM.aBE.getHeight());
                a.a(aVar.bSW(), EM);
                swanAppNAViewContainer = a;
            }
            aVar.e(swanAppNAViewContainer);
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a aV(JSONObject jSONObject) {
        String optString = jSONObject.optString("videoId");
        if (StringUtils.isNULL(optString)) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "player id is invalid or context is null");
            return null;
        }
        com.baidu.swan.apps.media.a eQ = com.baidu.swan.apps.media.b.eQ(optString);
        if (eQ instanceof com.baidu.tieba.aiapps.apps.media.video.view.a) {
            return (com.baidu.tieba.aiapps.apps.media.video.view.a) eQ;
        }
        return null;
    }

    @Override // com.baidu.swan.apps.u.b.v
    public boolean e(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, com.baidu.swan.apps.ae.b bVar) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a aV = aV(optParamsAsJo);
        if (aV == null) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        c a = c.a(optParamsAsJo, aV.azF());
        if (!a.isValid()) {
            com.baidu.swan.apps.console.c.e("AiAppVideoIocImpl", "param is invalid");
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        com.baidu.swan.apps.view.container.a hR = com.baidu.swan.apps.view.container.c.c.hR(a.aBC);
        SwanAppNAViewContainer a2 = com.baidu.swan.apps.view.container.c.b.a(a, hR);
        if (hR != null && a2 != null) {
            com.baidu.swan.apps.view.container.c.c.b(a2, hR);
            com.baidu.swan.apps.view.container.c.c.d(a2, hR);
        }
        aV.onDestroy();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }
}
