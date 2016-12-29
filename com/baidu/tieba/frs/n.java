package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class n extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(FrsActivity frsActivity, int i, int i2) {
        super(i, i2);
        this.bzl = frsActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        com.baidu.tieba.frs.h.ak akVar;
        com.baidu.tieba.frs.h.ak akVar2;
        if (responsedMessage instanceof ResponseSetCommForumStateHttpMessage) {
            if (((ResponseSetCommForumStateHttpMessage) responsedMessage).getError() == 0) {
                this.bzl.byh.qY(1 - this.bzl.byh.bdW());
                com.baidu.tieba.frs.utils.t.h(this.bzl.byh);
            } else {
                this.bzl.showToast(r.j.setdefualt_error);
            }
            akVar2 = this.bzl.byt;
            akVar2.ei(this.bzl.byh.bdW() == 1);
        } else if (responsedMessage instanceof ResponseSetCommForumStateSocketMessage) {
            if (((ResponseSetCommForumStateSocketMessage) responsedMessage).getError() == 0) {
                this.bzl.byh.qY(1 - this.bzl.byh.bdW());
                com.baidu.tieba.frs.utils.t.h(this.bzl.byh);
            } else {
                this.bzl.showToast(r.j.setdefualt_error);
            }
            akVar = this.bzl.byt;
            akVar.ei(this.bzl.byh.bdW() == 1);
        }
    }
}
