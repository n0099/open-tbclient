package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes4.dex */
public interface gs0 extends cs0, es0 {
    public static final a a = ta1.a;

    /* loaded from: classes4.dex */
    public interface a {
        gs0 a(Context context, int i);

        gs0 b(Context context, int i, @Nullable hs0 hs0Var);
    }

    void a(ds0 ds0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull vp0 vp0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
