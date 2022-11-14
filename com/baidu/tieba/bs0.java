package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes3.dex */
public interface bs0 extends xr0, zr0 {
    public static final a a = d71.a;

    /* loaded from: classes3.dex */
    public interface a {
        bs0 a(Context context, int i);

        bs0 b(Context context, int i, @Nullable cs0 cs0Var);
    }

    void a(yr0 yr0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull aq0 aq0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
