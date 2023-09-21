package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface b04 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    b04 e(Context context, @NonNull xy3 xy3Var);

    void g(vz3 vz3Var);

    int getCurrentPosition();

    int getDuration();

    void h(xy3 xy3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
