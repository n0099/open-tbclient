package com.baidu.tieba.aiapps.apps.p;

import com.baidu.ubc.UBC;
/* loaded from: classes4.dex */
public class d implements com.baidu.pyramid.runtime.multiprocess.e {
    @Override // com.baidu.pyramid.runtime.multiprocess.e
    public void dh(String str) {
        UBC.onMutilProcessEvent("765", str, com.baidu.pyramid.runtime.multiprocess.a.getProcessName());
    }
}
