package com.baidu.tieba.aiapps.apps.j;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.core.slave.AiAppsSlaveManager;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes4.dex */
public class a implements IAiAppMapIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean create(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean update(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean remove(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean translateMarker(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean openLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean moveToLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean includePoints(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean getScale(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean getRegion(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean getCenterLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean chooseLocation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean openWalkNavigation(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public void resume(AiAppsSlaveManager aiAppsSlaveManager) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public void pause(AiAppsSlaveManager aiAppsSlaveManager) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public void release(AiAppsSlaveManager aiAppsSlaveManager) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppMapIoc
    public boolean isTopWalkNavFragment() {
        return false;
    }
}
