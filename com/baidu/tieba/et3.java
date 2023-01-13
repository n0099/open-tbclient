package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface et3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    et3 e(Context context, @NonNull as3 as3Var);

    void g(ys3 ys3Var);

    int getCurrentPosition();

    int getDuration();

    void h(as3 as3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
