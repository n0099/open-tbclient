package com.baidu.tieba;

import android.os.Bundle;
/* loaded from: classes4.dex */
public interface g30<T> {
    void onError(int i, Throwable th, Bundle bundle);

    void onResult(T t, Bundle bundle);
}
