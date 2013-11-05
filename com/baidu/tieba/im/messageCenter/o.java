package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
/* loaded from: classes.dex */
/* synthetic */ class o {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ int[] f1651a = new int[IDuplicateProcess.RemoveState.values().length];

    static {
        try {
            f1651a[IDuplicateProcess.RemoveState.REMOVE_ALL.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1651a[IDuplicateProcess.RemoveState.REMOVE_WAITINGS.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1651a[IDuplicateProcess.RemoveState.REMOVE_ME.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
