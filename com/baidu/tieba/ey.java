package com.baidu.tieba;

import android.os.Bundle;
/* loaded from: classes5.dex */
public interface ey<T> {
    void onError(int i, Throwable th, Bundle bundle);

    void onResult(T t, Bundle bundle);
}
