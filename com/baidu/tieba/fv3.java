package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes6.dex */
public interface fv3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    fv3 e(Context context, @NonNull bu3 bu3Var);

    void g(zu3 zu3Var);

    int getCurrentPosition();

    int getDuration();

    void h(bu3 bu3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
