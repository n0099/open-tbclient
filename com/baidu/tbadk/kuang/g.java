package com.baidu.tbadk.kuang;

import com.baidu.searchbox.plugin.api.HostInvokeCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements HostInvokeCallback {
    private final /* synthetic */ HostInvokeCallback axL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(HostInvokeCallback hostInvokeCallback) {
        this.axL = hostInvokeCallback;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        if (i == 0) {
            b.wJ = (String) obj;
            b.a("getPToken", new Class[0], new Object[0], this.axL);
        }
    }
}
