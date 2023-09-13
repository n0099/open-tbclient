package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes5.dex */
public interface fg<T> {
    BdAsyncTaskParallel getAsyncTaskParallel();

    int getAsyncTaskPriority();

    T getFromLocal(String str, String str2, int i, int i2, eg egVar, Object... objArr);

    T getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr);

    T getFromRemote(String str, String str2, int i, int i2, eg egVar, Object... objArr);

    boolean isNeedLoad();

    void updateMemory(String str, Object obj, int i, int i2, Object... objArr);
}
