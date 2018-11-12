package com.baidu.tieba.aiapps.apps.media.video;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.console.AiAppsLog;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerContext;
import com.baidu.searchbox.ng.ai.apps.media.AiAppsPlayerManager;
import com.baidu.searchbox.ng.ai.apps.model.view.base.AiAppsNaViewModel;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsUtils;
import com.baidu.searchbox.ng.ai.apps.view.container.AiAppsNAViewContainer;
import com.baidu.searchbox.ng.ai.apps.view.container.util.NAViewFinder;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements IAiAppVideoIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean open(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a L = L(optParamsAsJo);
        if (L == null) {
            com.baidu.tieba.aiapps.apps.media.video.view.a aVar = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
            AiAppsPlayerManager.addPlayerContext(aVar);
            L = aVar;
        }
        b a = b.a(optParamsAsJo, L.XL());
        a(context, L, a);
        b XL = L.XL();
        L.a(a);
        if (a.isAutoPlay()) {
            if (!TextUtils.equals(XL.mSrc, a.mSrc)) {
                if (L.bpd()) {
                    L.stopPlay();
                    L.boT();
                }
            } else if (L.hasStart()) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            L.aW(a.mSrc, null);
        } else {
            L.setVideoUrl(a.mSrc, null);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean update(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a L = L(optParamsAsJo);
        if (L == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        b a = b.a(optParamsAsJo, L.XL());
        b XL = L.XL();
        L.a(a);
        if (!TextUtils.equals(XL.mSrc, a.mSrc)) {
            if (L.bpd()) {
                L.stopPlay();
            }
            L.aW(a.mSrc, null);
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean play(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a L = L(optParamsAsJo);
        if (L == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        b a = b.a(optParamsAsJo, L.XL());
        b XL = L.XL();
        if (L.hasStart() && TextUtils.equals(a.mSrc, XL.mSrc)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        L.a(a);
        L.aW(a.mSrc, null);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean pause(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a L = L(optParamsAsJo);
        if (L == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        L.pausePlay();
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean seekTo(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "json object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a L = L(optParamsAsJo);
        if (L == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        L.getVideoView().seekTo(b.a(optParamsAsJo, L.XL()).mPos);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean setFullScreen(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "json object is null");
            return false;
        }
        com.baidu.tieba.aiapps.apps.media.video.view.a L = L(optParamsAsJo);
        if (L == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        L.dE(optParamsAsJo.optBoolean("fullScreen", false));
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean sendDanmu(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppVideoIoc
    public boolean onKeyBack() {
        return false;
    }

    private void a(Context context, com.baidu.tieba.aiapps.apps.media.video.view.a aVar, b bVar) {
        AiAppsNAViewContainer aiAppsNAViewContainer;
        if (aVar != null && aVar.bpp() != null) {
            AiAppsNAViewContainer findNAViewById = NAViewFinder.findNAViewById(bVar.slaveId, bVar.id, AiAppsUtils.getCurrentNAViewRoot(bVar.slaveId));
            if (aVar.bpp().getParent() != null) {
                ((ViewGroup) aVar.bpp().getParent()).removeView(aVar.bpp());
            }
            if (findNAViewById == null) {
                aiAppsNAViewContainer = new AiAppsNAViewContainer(context);
                aiAppsNAViewContainer.insertView(aVar.bpp(), bVar);
            } else {
                AiAppsNaViewModel cloneModel = bVar.cloneModel();
                findNAViewById.removeView();
                cloneModel.slaveId = findNAViewById.getSlaveId();
                cloneModel.parentId = findNAViewById.getParentId();
                cloneModel.id = findNAViewById.getViewId();
                cloneModel.position.setTop(cloneModel.position.getTop());
                cloneModel.position.setHeight(cloneModel.position.getHeight());
                findNAViewById.insertView(aVar.bpp(), cloneModel);
                aiAppsNAViewContainer = findNAViewById;
            }
            aVar.a(aiAppsNAViewContainer);
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a L(JSONObject jSONObject) {
        String optString = jSONObject.optString("videoId");
        if (StringUtils.isNULL(optString)) {
            AiAppsLog.e("AiAppVideoIocImpl", "player id is invalid or context is null");
            return null;
        }
        AiAppsPlayerContext playerContext = AiAppsPlayerManager.getPlayerContext(optString);
        if (playerContext instanceof com.baidu.tieba.aiapps.apps.media.video.view.a) {
            return (com.baidu.tieba.aiapps.apps.media.video.view.a) playerContext;
        }
        return null;
    }
}
