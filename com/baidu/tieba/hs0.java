package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes4.dex */
public interface hs0 extends ds0, fs0 {
    public static final a a = ua1.a;

    /* loaded from: classes4.dex */
    public interface a {
        hs0 a(Context context, int i);

        hs0 b(Context context, int i, @Nullable is0 is0Var);
    }

    void a(es0 es0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull wp0 wp0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
