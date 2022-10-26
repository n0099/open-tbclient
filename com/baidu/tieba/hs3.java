package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
/* loaded from: classes4.dex */
public interface hs3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    hs3 e(Context context, dr3 dr3Var);

    void g(bs3 bs3Var);

    int getCurrentPosition();

    int getDuration();

    void h(dr3 dr3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
