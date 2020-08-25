package com.baidu.tbadk.mvc.e;

import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes2.dex */
public abstract class b<T> implements CustomMessageTask.CustomRunnable<T> {
    protected int cmd;

    public b(int i) {
        this.cmd = i;
    }
}
