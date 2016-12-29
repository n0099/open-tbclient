package com.baidu.tbadk.kuang;

import com.baidu.searchbox.plugin.api.HostInvokeCallback;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements HostInvokeCallback {
    private final /* synthetic */ HostInvokeCallback ayY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(HostInvokeCallback hostInvokeCallback) {
        this.ayY = hostInvokeCallback;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        if (i == 0) {
            b.mUserId = (String) obj;
            b.a("getBduss", new Class[0], new Object[0], this.ayY);
        }
    }
}
