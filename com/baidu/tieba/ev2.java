package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface ev2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(ev2 ev2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(ev2 ev2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(ev2 ev2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(ev2 ev2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(ev2 ev2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(ev2 ev2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    ev2 e(Context context, @NonNull sz2 sz2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(sz2 sz2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(sz2 sz2Var);

    void o(sz2 sz2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
