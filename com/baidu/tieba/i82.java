package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.baidu.tieba.h82;
/* loaded from: classes4.dex */
public interface i82<T extends h82> {
    void a(@NonNull Handler handler);

    void b(T t);

    Looper getLooper();
}
