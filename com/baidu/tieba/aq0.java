package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes5.dex */
public interface aq0 extends wp0, yp0 {
    public static final a a = j71.a;

    /* loaded from: classes5.dex */
    public interface a {
        aq0 a(Context context, int i, @Nullable bq0 bq0Var);
    }

    void a(xp0 xp0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull ln0 ln0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
