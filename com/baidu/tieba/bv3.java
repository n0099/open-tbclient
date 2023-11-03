package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface bv3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    bv3 e(Context context, @NonNull xt3 xt3Var);

    void g(vu3 vu3Var);

    int getCurrentPosition();

    int getDuration();

    void h(xt3 xt3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
