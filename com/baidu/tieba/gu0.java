package com.baidu.tieba;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.nadcore.player.strategy.IVideoUpdateStrategy;
/* loaded from: classes6.dex */
public interface gu0 extends cu0, eu0 {
    public static final a a = zb1.a;

    /* loaded from: classes6.dex */
    public interface a {
        gu0 a(Context context, int i);

        gu0 b(Context context, int i, @Nullable hu0 hu0Var);
    }

    void a(du0 du0Var);

    void attachToContainer(@NonNull ViewGroup viewGroup);

    void c(@NonNull sr0 sr0Var);

    void d(@NonNull IVideoUpdateStrategy iVideoUpdateStrategy);

    void release();
}
