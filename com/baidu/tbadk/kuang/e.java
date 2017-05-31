package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.tbadk.core.a.a;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements HostInvokeCallback {
    private final /* synthetic */ a.InterfaceC0035a aDp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a.InterfaceC0035a interfaceC0035a) {
        this.aDp = interfaceC0035a;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 0) {
            a.Sh = (String) obj;
            str = a.mBduss;
            if (str == null) {
                a.DP();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
            str2 = a.mUserId;
            str3 = a.mBduss;
            str4 = a.Sh;
            com.baidu.tieba.model.c.a(str2, str3, str4, null, this.aDp);
        }
    }
}
