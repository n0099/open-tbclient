package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.tbadk.core.a.a;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements HostInvokeCallback {
    private final /* synthetic */ a.InterfaceC0031a aDl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a.InterfaceC0031a interfaceC0031a) {
        this.aDl = interfaceC0031a;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 0) {
            b.SH = (String) obj;
            str = b.xo;
            if (str == null) {
                b.Et();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
            str2 = b.mUserId;
            str3 = b.xo;
            str4 = b.SH;
            com.baidu.tieba.model.b.a(str2, str3, str4, null, this.aDl);
        }
    }
}
