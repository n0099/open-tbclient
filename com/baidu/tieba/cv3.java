package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface cv3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    cv3 e(Context context, @NonNull yt3 yt3Var);

    void g(wu3 wu3Var);

    int getCurrentPosition();

    int getDuration();

    void h(yt3 yt3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
