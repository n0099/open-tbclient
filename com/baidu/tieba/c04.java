package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface c04 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    c04 e(Context context, @NonNull yy3 yy3Var);

    void g(wz3 wz3Var);

    int getCurrentPosition();

    int getDuration();

    void h(yy3 yy3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
