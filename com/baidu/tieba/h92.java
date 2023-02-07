package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.g92;
/* loaded from: classes4.dex */
public interface h92<T extends g92> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
