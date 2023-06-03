package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface ew2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(ew2 ew2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(ew2 ew2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(ew2 ew2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(ew2 ew2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(ew2 ew2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(ew2 ew2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    ew2 e(Context context, @NonNull s03 s03Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(s03 s03Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(s03 s03Var);

    void o(s03 s03Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
