package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.message.s;
/* loaded from: classes.dex */
public interface IDuplicateProcess {

    /* loaded from: classes.dex */
    public enum RemoveState {
        NOT_REMOVE,
        REMOVE_ME,
        REMOVE_WAITINGS,
        REMOVE_ALL;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static RemoveState[] valuesCustom() {
            RemoveState[] valuesCustom = values();
            int length = valuesCustom.length;
            RemoveState[] removeStateArr = new RemoveState[length];
            System.arraycopy(valuesCustom, 0, removeStateArr, 0, length);
            return removeStateArr;
        }
    }

    boolean a(s sVar);

    RemoveState h();
}
