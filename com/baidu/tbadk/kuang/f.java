package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.tbadk.core.a.a;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements HostInvokeCallback {
    private final /* synthetic */ a.InterfaceC0041a awT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a.InterfaceC0041a interfaceC0041a) {
        this.awT = interfaceC0041a;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 0) {
            b.Uv = (String) obj;
            str = b.wA;
            if (str == null) {
                b.CU();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
            str2 = b.mUserId;
            str3 = b.wA;
            str4 = b.Uv;
            com.baidu.tieba.model.a.a(str2, str3, str4, this.awT);
        }
    }
}
