package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.tbadk.core.a.a;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements HostInvokeCallback {
    private final /* synthetic */ a.InterfaceC0033a ayW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a.InterfaceC0033a interfaceC0033a) {
        this.ayW = interfaceC0033a;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 0) {
            b.Os = (String) obj;
            str = b.pY;
            if (str == null) {
                b.Ef();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
            str2 = b.mUserId;
            str3 = b.pY;
            str4 = b.Os;
            com.baidu.tieba.model.b.a(str2, str3, str4, null, this.ayW);
        }
    }
}
