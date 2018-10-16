package com.baidu.tieba.aiapps.apps.p;

import android.content.Context;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppTTSIoc;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
/* loaded from: classes4.dex */
public class a implements IAiAppTTSIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppTTSIoc
    public boolean speak(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppTTSIoc
    public boolean suspend(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppTTSIoc
    public boolean resume(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppTTSIoc
    public boolean stop(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        return false;
    }
}
