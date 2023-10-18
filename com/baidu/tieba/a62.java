package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.z52;
/* loaded from: classes5.dex */
public interface a62<T extends z52> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
