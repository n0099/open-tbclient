package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes5.dex */
public interface fw2 {

    /* loaded from: classes5.dex */
    public interface a {
        void b(fw2 fw2Var);
    }

    /* loaded from: classes5.dex */
    public interface b {
        boolean f(fw2 fw2Var, int i, int i2);
    }

    /* loaded from: classes5.dex */
    public interface c {
        void c(fw2 fw2Var);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void e(fw2 fw2Var);
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a(fw2 fw2Var);
    }

    /* loaded from: classes5.dex */
    public interface f {
        void d(fw2 fw2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    fw2 e(Context context, @NonNull t03 t03Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(t03 t03Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(t03 t03Var);

    void o(t03 t03Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
