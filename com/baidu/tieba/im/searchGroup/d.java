package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchGroupActivity f1875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(SearchGroupActivity searchGroupActivity) {
        this.f1875a = searchGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        g gVar;
        g gVar2;
        g gVar3;
        gVar = this.f1875a.b;
        gVar.b();
        if (message == null) {
            this.f1875a.showToast(R.string.neterror);
        } else if (message.getCmd() == 103007) {
            try {
                if (message instanceof ResponseSearchGroupMessage) {
                    ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) message;
                    if (!responseSearchGroupMessage.hasError()) {
                        gVar3 = this.f1875a.b;
                        gVar3.a(responseSearchGroupMessage);
                        this.f1875a.a();
                    }
                    gVar2 = this.f1875a.b;
                    gVar2.c();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.e.c("ResponseGroupInfoMessage invalid");
            }
        }
    }
}
