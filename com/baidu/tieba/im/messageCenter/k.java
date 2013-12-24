package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
/* loaded from: classes.dex */
/* synthetic */ class k {
    static final /* synthetic */ int[] a = new int[IDuplicateProcess.RemoveState.values().length];

    static {
        try {
            a[IDuplicateProcess.RemoveState.REMOVE_ALL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[IDuplicateProcess.RemoveState.REMOVE_WAITINGS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[IDuplicateProcess.RemoveState.REMOVE_ME.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
