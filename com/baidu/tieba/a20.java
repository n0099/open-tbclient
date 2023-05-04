package com.baidu.tieba;

import android.os.Bundle;
/* loaded from: classes3.dex */
public interface a20<T> {
    void onError(int i, Throwable th, Bundle bundle);

    void onResult(T t, Bundle bundle);
}
