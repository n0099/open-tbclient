package com.baidu.tieba.im;

import java.util.concurrent.ThreadFactory;
/* loaded from: classes.dex */
class k implements ThreadFactory {
    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread thread;
        Exception e;
        try {
            thread = new Thread(runnable);
        } catch (Exception e2) {
            thread = null;
            e = e2;
        }
        try {
            thread.setName(j.class.getSimpleName());
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return thread;
        }
        return thread;
    }
}
