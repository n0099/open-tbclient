package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface ct2 {

    /* loaded from: classes4.dex */
    public interface a {
        void b(ct2 ct2Var);
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean f(ct2 ct2Var, int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void c(ct2 ct2Var);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void e(ct2 ct2Var);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(ct2 ct2Var);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void d(ct2 ct2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    ct2 e(Context context, @NonNull qx2 qx2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(qx2 qx2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(qx2 qx2Var);

    void o(qx2 qx2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
