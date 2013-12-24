package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
/* loaded from: classes.dex */
public class q extends n implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private static final MessageLite a = new r();
    private IDuplicateProcess.RemoveState b = IDuplicateProcess.RemoveState.REMOVE_ME;

    public q() {
        e(1003);
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(n nVar) {
        return true;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return a;
    }
}
