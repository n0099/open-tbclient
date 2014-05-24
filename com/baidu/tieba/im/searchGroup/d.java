package com.baidu.tieba.im.searchGroup;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ SearchGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(SearchGroupActivity searchGroupActivity, int i) {
        super(i);
        this.a = searchGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        g gVar;
        g gVar2;
        g gVar3;
        gVar = this.a.b;
        gVar.b();
        if (socketResponsedMessage == null) {
            this.a.showToast(y.neterror);
        } else if (socketResponsedMessage.getCmd() == 103007) {
            try {
                if (socketResponsedMessage instanceof ResponseSearchGroupMessage) {
                    ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage;
                    if (responseSearchGroupMessage.getError() == 0) {
                        gVar3 = this.a.b;
                        gVar3.a(responseSearchGroupMessage);
                        this.a.a();
                    }
                    gVar2 = this.a.b;
                    gVar2.c();
                }
            } catch (Exception e) {
                BdLog.i("ResponseGroupInfoMessage invalid");
            }
        }
    }
}
