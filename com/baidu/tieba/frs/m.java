package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m extends a {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.g.ao aoVar;
        com.baidu.tieba.frs.g.ao aoVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bNJ.bME.rI(1 - this.bNJ.bME.bgl());
                com.baidu.tieba.frs.f.t.g(this.bNJ.bME);
            } else {
                this.bNJ.showToast(w.l.setdefualt_error);
            }
            aoVar2 = this.bNJ.bMQ;
            aoVar2.em(this.bNJ.bME.bgl() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bNJ.bME.rI(1 - this.bNJ.bME.bgl());
                com.baidu.tieba.frs.f.t.g(this.bNJ.bME);
            } else {
                this.bNJ.showToast(w.l.setdefualt_error);
            }
            aoVar = this.bNJ.bMQ;
            aoVar.em(this.bNJ.bME.bgl() == 1);
        }
    }
}
