package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes5.dex */
public interface av0 extends wu0, yu0 {
    public static final a a = rc1.a;

    /* loaded from: classes5.dex */
    public interface a {
        av0 a(Context context, int i);

        av0 b(Context context, int i, @Nullable bv0 bv0Var);
    }

    void a(xu0 xu0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull ms0 ms0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
