package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes4.dex */
public interface fs0 extends bs0, ds0 {
    public static final a a = sa1.a;

    /* loaded from: classes4.dex */
    public interface a {
        fs0 a(Context context, int i);

        fs0 b(Context context, int i, @Nullable gs0 gs0Var);
    }

    void a(cs0 cs0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull up0 up0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
