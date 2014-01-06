package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
import com.google.protobuf.MessageLite;
/* loaded from: classes.dex */
public class t extends o implements com.baidu.tieba.im.coder.g, IDuplicateProcess {
    private static final MessageLite a = new u();
    private IDuplicateProcess.RemoveState b = IDuplicateProcess.RemoveState.REMOVE_ME;

    public t() {
        e(1003);
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState h() {
        return this.b;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean a(o oVar) {
        return true;
    }

    @Override // com.baidu.tieba.im.coder.g
    public MessageLite a() {
        return a;
    }
}
