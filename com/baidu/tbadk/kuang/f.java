package com.baidu.tbadk.kuang;

import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.plugin.api.HostInvokeCallback;
import com.baidu.tbadk.core.a.a;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements HostInvokeCallback {
    private final /* synthetic */ a.InterfaceC0032a axR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a.InterfaceC0032a interfaceC0032a) {
        this.axR = interfaceC0032a;
    }

    @Override // com.baidu.searchbox.plugin.api.HostInvokeCallback
    public void onResult(int i, Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        if (i == 0) {
            b.ND = (String) obj;
            str = b.pS;
            if (str == null) {
                b.Ea();
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
            str2 = b.mUserId;
            str3 = b.pS;
            str4 = b.ND;
            com.baidu.tieba.model.b.a(str2, str3, str4, null, this.axR);
        }
    }
}
