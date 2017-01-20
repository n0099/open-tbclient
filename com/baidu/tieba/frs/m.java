package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m extends a {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bGL = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.f.am amVar;
        com.baidu.tieba.frs.f.am amVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bGL.bFG.rL(1 - this.bGL.bFG.bfK());
                com.baidu.tieba.frs.utils.t.g(this.bGL.bFG);
            } else {
                this.bGL.showToast(r.l.setdefualt_error);
            }
            amVar2 = this.bGL.bFS;
            amVar2.em(this.bGL.bFG.bfK() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bGL.bFG.rL(1 - this.bGL.bFG.bfK());
                com.baidu.tieba.frs.utils.t.g(this.bGL.bFG);
            } else {
                this.bGL.showToast(r.l.setdefualt_error);
            }
            amVar = this.bGL.bFS;
            amVar.em(this.bGL.bFG.bfK() == 1);
        }
    }
}
