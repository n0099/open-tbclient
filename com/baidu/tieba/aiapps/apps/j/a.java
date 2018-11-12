package com.baidu.tieba.aiapps.apps.j;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.core.fragment.AiAppsFragmentManager;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.MapViewManager;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.MapCreateAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.MapRemoveAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.MapUpdateAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.GetCenterLocationAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.GetRegionAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.GetScaleAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.IncludePointsAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.MoveToLocationAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.OpenLocationAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.action.function.TranslateMarkerAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.action.ChooseLocationAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.action.WalkNavigationAction;
import com.baidu.searchbox.ng.ai.apps.impl.map.location.walknav.WalkARNavFragment;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc;
import com.baidu.searchbox.ng.ai.apps.lifecycle.AiAppsController;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes4.dex */
public class a implements IAiAppMapIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean create(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new MapCreateAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean update(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new MapUpdateAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean remove(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new MapRemoveAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean translateMarker(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new TranslateMarkerAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean openLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new OpenLocationAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean moveToLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new MoveToLocationAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean includePoints(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new IncludePointsAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean getScale(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new GetScaleAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean getRegion(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new GetRegionAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean getCenterLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new GetCenterLocationAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean chooseLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new ChooseLocationAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean openWalkNavigation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return new WalkNavigationAction().handle(context, unitedSchemeEntity, callbackHandler, aiApp);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public void resume(AiAppsSlaveManager aiAppsSlaveManager) {
        MapViewManager.get().getMapViewHelper(aiAppsSlaveManager).resume();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public void pause(AiAppsSlaveManager aiAppsSlaveManager) {
        MapViewManager.get().getMapViewHelper(aiAppsSlaveManager).pause();
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public void release(AiAppsSlaveManager aiAppsSlaveManager) {
        MapViewManager.get().releaseMapViewHelper(aiAppsSlaveManager);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean isTopWalkNavFragment() {
        AiAppsFragmentManager aiAppsFragmentManager = AiAppsController.getInstance().getAiAppsFragmentManager();
        if (aiAppsFragmentManager == null) {
            return false;
        }
        return aiAppsFragmentManager.getTopFragment() instanceof WalkARNavFragment;
    }
}
