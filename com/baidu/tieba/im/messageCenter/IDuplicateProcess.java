package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public interface IDuplicateProcess {

    /* loaded from: classes.dex */
    public enum RemoveState {
        NOT_REMOVE,
        REMOVE_ME,
        REMOVE_WAITINGS,
        REMOVE_ALL
    }

    RemoveState getDuplicateRemoveType();

    boolean onDuplicateProcess(Message message);
}
