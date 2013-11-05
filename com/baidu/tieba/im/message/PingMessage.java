package com.baidu.tieba.im.message;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
/* loaded from: classes.dex */
public class PingMessage extends Message implements IDuplicateProcess {
    private static final long serialVersionUID = -1754524739831357863L;
    private IDuplicateProcess.RemoveState mRemoveState = IDuplicateProcess.RemoveState.REMOVE_ME;

    public PingMessage() {
        setCmd(1003);
    }

    public void setRemoveState(IDuplicateProcess.RemoveState removeState) {
        this.mRemoveState = removeState;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public IDuplicateProcess.RemoveState getDuplicateRemoveType() {
        return this.mRemoveState;
    }

    @Override // com.baidu.tieba.im.messageCenter.IDuplicateProcess
    public boolean onDuplicateProcess(Message message) {
        return true;
    }
}
