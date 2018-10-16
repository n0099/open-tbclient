package com.baidu.tieba.aiapps.apps.abtest;

import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsBlinkAbTestIoc;
/* loaded from: classes4.dex */
public class c implements IAiAppsBlinkAbTestIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsBlinkAbTestIoc
    public int getPreloadABSwitch() {
        return 0;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsBlinkAbTestIoc
    public boolean isDisablePreload(int i) {
        return false;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppsBlinkAbTestIoc
    public boolean isEnableDelayPreload(int i) {
        return i >= 10;
    }
}
