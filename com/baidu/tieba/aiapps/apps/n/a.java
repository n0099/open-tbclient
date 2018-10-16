package com.baidu.tieba.aiapps.apps.n;

import com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppExtentSchemeIoc;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
/* loaded from: classes4.dex */
public class a implements IAiAppExtentSchemeIoc {
    @Override // com.baidu.searchbox.ng.ai.apps.ioc.interfaces.IAiAppExtentSchemeIoc
    public void regAiAppExtentSchemeList(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        if (unitedSchemeAiAppDispatcher != null) {
            unitedSchemeAiAppDispatcher.regAction(new b(unitedSchemeAiAppDispatcher));
        }
    }
}
