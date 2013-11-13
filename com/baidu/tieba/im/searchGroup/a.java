package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchGroupActivity f1785a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SearchGroupActivity searchGroupActivity) {
        this.f1785a = searchGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        d dVar;
        d dVar2;
        d dVar3;
        dVar = this.f1785a.b;
        dVar.b();
        if (message == null) {
            this.f1785a.showToast(R.string.neterror);
        } else if (message.getCmd() == 103007) {
            try {
                if (message instanceof ResponseSearchGroupMessage) {
                    ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) message;
                    if (!responseSearchGroupMessage.hasError()) {
                        dVar3 = this.f1785a.b;
                        dVar3.a(responseSearchGroupMessage);
                        this.f1785a.a();
                    }
                    dVar2 = this.f1785a.b;
                    dVar2.c();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.h.d.c("ResponseGroupInfoMessage invalid");
            }
        }
    }
}
