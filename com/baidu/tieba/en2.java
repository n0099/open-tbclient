package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface en2 {

    /* loaded from: classes3.dex */
    public interface a {
        void b(en2 en2Var);
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean f(en2 en2Var, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void c(en2 en2Var);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void e(en2 en2Var);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(en2 en2Var);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void d(en2 en2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    en2 e(Context context, @NonNull sr2 sr2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(sr2 sr2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(sr2 sr2Var);

    void o(sr2 sr2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
