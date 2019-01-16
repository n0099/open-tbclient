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
        com.baidu.tieba.aiapps.apps.media.video.view.a M = M(optParamsAsJo);
        if (M == null) {
            com.baidu.tieba.aiapps.apps.media.video.view.a aVar = new com.baidu.tieba.aiapps.apps.media.video.view.a((Activity) context, false);
            AiAppsPlayerManager.addPlayerContext(aVar);
            M = aVar;
        }
        b a = b.a(optParamsAsJo, M.Zn());
        a(context, M, a);
        b Zn = M.Zn();
        M.a(a);
        if (a.isAutoPlay()) {
            if (!TextUtils.equals(Zn.mSrc, a.mSrc)) {
                if (M.bsq()) {
                    M.stopPlay();
                    M.bsg();
                }
            } else if (M.hasStart()) {
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            M.ba(a.mSrc, null);
        } else {
            M.setVideoUrl(a.mSrc, null);
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
        com.baidu.tieba.aiapps.apps.media.video.view.a M = M(optParamsAsJo);
        if (M == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        b a = b.a(optParamsAsJo, M.Zn());
        b Zn = M.Zn();
        M.a(a);
        if (!TextUtils.equals(Zn.mSrc, a.mSrc)) {
            if (M.bsq()) {
                M.stopPlay();
            }
            M.ba(a.mSrc, null);
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
        com.baidu.tieba.aiapps.apps.media.video.view.a M = M(optParamsAsJo);
        if (M == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        b a = b.a(optParamsAsJo, M.Zn());
        b Zn = M.Zn();
        if (M.hasStart() && TextUtils.equals(a.mSrc, Zn.mSrc)) {
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
            return true;
        }
        M.a(a);
        M.ba(a.mSrc, null);
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
        com.baidu.tieba.aiapps.apps.media.video.view.a M = M(optParamsAsJo);
        if (M == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        M.pausePlay();
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
        com.baidu.tieba.aiapps.apps.media.video.view.a M = M(optParamsAsJo);
        if (M == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        M.getVideoView().seekTo(b.a(optParamsAsJo, M.Zn()).mPos);
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
        com.baidu.tieba.aiapps.apps.media.video.view.a M = M(optParamsAsJo);
        if (M == null) {
            AiAppsLog.e("AiAppVideoIocImpl", "videoView object is null");
            UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001));
            return false;
        }
        M.dI(optParamsAsJo.optBoolean("fullScreen", false));
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
        if (aVar != null && aVar.bsC() != null) {
            AiAppsNAViewContainer findNAViewById = NAViewFinder.findNAViewById(bVar.slaveId, bVar.id, AiAppsUtils.getCurrentNAViewRoot(bVar.slaveId));
            if (aVar.bsC().getParent() != null) {
                ((ViewGroup) aVar.bsC().getParent()).removeView(aVar.bsC());
            }
            if (findNAViewById == null) {
                aiAppsNAViewContainer = new AiAppsNAViewContainer(context);
                aiAppsNAViewContainer.insertView(aVar.bsC(), bVar);
            } else {
                AiAppsNaViewModel cloneModel = bVar.cloneModel();
                findNAViewById.removeView();
                cloneModel.slaveId = findNAViewById.getSlaveId();
                cloneModel.parentId = findNAViewById.getParentId();
                cloneModel.id = findNAViewById.getViewId();
                cloneModel.position.setTop(cloneModel.position.getTop());
                cloneModel.position.setHeight(cloneModel.position.getHeight());
                findNAViewById.insertView(aVar.bsC(), cloneModel);
                aiAppsNAViewContainer = findNAViewById;
            }
            aVar.a(aiAppsNAViewContainer);
        }
    }

    private com.baidu.tieba.aiapps.apps.media.video.view.a M(JSONObject jSONObject) {
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
