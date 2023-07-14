package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface bw2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(bw2 bw2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(bw2 bw2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(bw2 bw2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(bw2 bw2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(bw2 bw2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(bw2 bw2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    bw2 e(Context context, @NonNull p03 p03Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(p03 p03Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(p03 p03Var);

    void o(p03 p03Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
