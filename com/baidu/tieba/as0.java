package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes3.dex */
public interface as0 extends wr0, yr0 {
    public static final a a = c71.a;

    /* loaded from: classes3.dex */
    public interface a {
        as0 a(Context context, int i);

        as0 b(Context context, int i, @Nullable bs0 bs0Var);
    }

    void a(xr0 xr0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull zp0 zp0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
