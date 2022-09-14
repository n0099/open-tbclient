package com.baidu.tieba;

import android.content.Context;
/* loaded from: classes3.dex */
public interface cj5 {
    void a();

    void b(int i, int i2, int i3, int i4);

    Context getContext();

    boolean post(Runnable runnable);

    boolean removeCallbacks(Runnable runnable);
}
