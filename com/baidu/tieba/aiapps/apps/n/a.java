package com.baidu.tieba.aiapps.apps.n;

import android.content.res.Resources;
import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc;
import com.baidu.searchbox.ng.ai.apps.skin.AiAppNightModeChangeListener;
/* loaded from: classes4.dex */
public class a implements IAiAppNightModeIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc
    public void setNightModeSwitcherState(boolean z) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc
    public void forceSyncNightModeState(boolean z) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc
    public void setNightMode(boolean z) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc
    public boolean getNightModeSwitcherState() {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc
    public void subscribeNightModeChangeEvent(Object obj, AiAppNightModeChangeListener aiAppNightModeChangeListener) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc
    public void unsubscribeNightModeChangedEvent(Object obj) {
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppNightModeIoc
    public Resources getSkinResources() {
        return null;
    }
}
