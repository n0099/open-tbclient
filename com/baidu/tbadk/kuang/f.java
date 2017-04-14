package com.baidu.tbadk.kuang;

import com.baidu.searchbox.plugin.api.HostInvokeCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements HostInvokeCallback {
    private final /* synthetic */ HostInvokeCallback aDC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(HostInvokeCallback hostInvokeCallback) {
        this.aDC = hostInvokeCallback;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        if (i == 0) {
            a.mBduss = (String) obj;
            a.a("getPToken", new Class[0], new Object[0], this.aDC);
        }
    }
}
