package com.baidu.tieba.aiapps.apps.r;

import com.baidu.ubc.UBC;
/* loaded from: classes4.dex */
public class d implements com.baidu.pyramid.runtime.multiprocess.d {
    @Override // com.baidu.pyramid.runtime.multiprocess.d
    public void cU(String str) {
        UBC.onMutilProcessEvent("765", str, com.baidu.pyramid.runtime.multiprocess.a.getProcessName());
    }
}
