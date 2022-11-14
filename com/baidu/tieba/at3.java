package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface at3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    at3 e(Context context, @NonNull wr3 wr3Var);

    void g(us3 us3Var);

    int getCurrentPosition();

    int getDuration();

    void h(wr3 wr3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
