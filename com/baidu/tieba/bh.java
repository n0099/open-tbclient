package com.baidu.tieba;

import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
/* loaded from: classes3.dex */
public interface bh {
    BdAsyncTaskParallel getAsyncTaskParallel();

    int getAsyncTaskPriority();

    Object getFromLocal(String str, String str2, int i, int i2, yg ygVar, Object... objArr);

    Object getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr);

    Object getFromRemote(String str, String str2, int i, int i2, yg ygVar, Object... objArr);

    boolean isNeedLoad();

    void updateMemory(String str, Object obj, int i, int i2, Object... objArr);
}
