package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.e82;
/* loaded from: classes4.dex */
public interface f82<T extends e82> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
