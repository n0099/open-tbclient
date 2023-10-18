package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface gp0 extends cp0, ep0 {
    public static final a a = p61.a;

    /* loaded from: classes6.dex */
    public interface a {
        gp0 a(Context context, int i, @Nullable hp0 hp0Var);
    }

    void a(dp0 dp0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull sm0 sm0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
