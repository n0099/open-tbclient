package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes3.dex */
public interface as2 {

    /* loaded from: classes3.dex */
    public interface a {
        void b(as2 as2Var);
    }

    /* loaded from: classes3.dex */
    public interface b {
        boolean f(as2 as2Var, int i, int i2);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void c(as2 as2Var);
    }

    /* loaded from: classes3.dex */
    public interface d {
        void e(as2 as2Var);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(as2 as2Var);
    }

    /* loaded from: classes3.dex */
    public interface f {
        void d(as2 as2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    as2 e(Context context, @NonNull ow2 ow2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(ow2 ow2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(ow2 ow2Var);

    void o(ow2 ow2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
