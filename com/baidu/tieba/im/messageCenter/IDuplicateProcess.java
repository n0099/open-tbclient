package com.baidu.tieba.im.messageCenter;
/* loaded from: classes.dex */
public interface IDuplicateProcess {

    /* loaded from: classes.dex */
    public enum RemoveState {
        NOT_REMOVE,
        REMOVE_ME,
        REMOVE_WAITINGS,
        REMOVE_ALL
    }

    boolean a(com.baidu.tieba.im.message.o oVar);

    RemoveState h();
}
