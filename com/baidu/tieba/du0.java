package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes5.dex */
public interface du0 extends zt0, bu0 {
    public static final a a = ub1.a;

    /* loaded from: classes5.dex */
    public interface a {
        du0 a(Context context, int i);

        du0 b(Context context, int i, @Nullable eu0 eu0Var);
    }

    void a(au0 au0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull pr0 pr0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
