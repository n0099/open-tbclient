package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface by3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    by3 e(Context context, @NonNull xw3 xw3Var);

    void g(vx3 vx3Var);

    int getCurrentPosition();

    int getDuration();

    void h(xw3 xw3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
