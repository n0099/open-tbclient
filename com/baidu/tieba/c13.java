package com.baidu.tieba;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
/* loaded from: classes5.dex */
public interface c13 {
    @UiThread
    void a(String str);

    @UiThread
    void b();

    void c(@NonNull Runnable runnable, @NonNull String str);

    @UiThread
    void d(boolean z);

    @AnyThread
    void e(String str);

    String getName();
}
