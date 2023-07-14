package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.fc2;
/* loaded from: classes6.dex */
public interface gc2<T extends fc2> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
