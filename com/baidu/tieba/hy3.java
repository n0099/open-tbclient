package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface hy3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    hy3 e(Context context, @NonNull dx3 dx3Var);

    void g(by3 by3Var);

    int getCurrentPosition();

    int getDuration();

    void h(dx3 dx3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
