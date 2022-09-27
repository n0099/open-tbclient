package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface gs3 {
    void a(FrameLayout frameLayout);

    void d(boolean z);

    gs3 e(Context context, @NonNull cr3 cr3Var);

    void g(as3 as3Var);

    int getCurrentPosition();

    int getDuration();

    void h(cr3 cr3Var);

    boolean isEnd();

    boolean isPlaying();

    void mute(boolean z);

    void pause();

    void resume();

    void stop();
}
