package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.tbadk.core.a.a;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements HostInvokeCallback {
    private final /* synthetic */ a.InterfaceC0042a axK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a.InterfaceC0042a interfaceC0042a) {
        this.axK = interfaceC0042a;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 0) {
            b.TU = (String) obj;
            str = b.wJ;
            if (str == null) {
                b.El();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
            str2 = b.mUserId;
            str3 = b.wJ;
            str4 = b.TU;
            com.baidu.tieba.model.a.a(str2, str3, str4, this.axK);
        }
    }
}
