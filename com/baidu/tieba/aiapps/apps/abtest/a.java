package com.baidu.tieba.aiapps.apps.abtest;

import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAbTestIoc;
/* loaded from: classes4.dex */
public class a implements IAiAppAbTestIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAbTestIoc
    public boolean isGetLocalImgDataOn() {
        return true;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAbTestIoc
    public int getAiAppsNavigateMaxValue() {
        return 10;
    }

    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppAbTestIoc
    public int whiteScreenMonitorDelayTime() {
        return 6;
    }
}
