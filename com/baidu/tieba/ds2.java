package com.baidu.tieba;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
/* loaded from: classes4.dex */
public interface ds2 {

    /* loaded from: classes4.dex */
    public interface a {
        void b(ds2 ds2Var);
    }

    /* loaded from: classes4.dex */
    public interface b {
        boolean f(ds2 ds2Var, int i, int i2);
    }

    /* loaded from: classes4.dex */
    public interface c {
        void c(ds2 ds2Var);
    }

    /* loaded from: classes4.dex */
    public interface d {
        void e(ds2 ds2Var);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(ds2 ds2Var);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void d(ds2 ds2Var);
    }

    void a(FrameLayout frameLayout);

    void b();

    void c();

    void d(boolean z);

    ds2 e(Context context, @NonNull rw2 rw2Var);

    void f();

    void g(a aVar);

    int getCurrentPosition();

    int getDuration();

    void h(rw2 rw2Var, boolean z);

    void i(String str);

    boolean isEnd();

    boolean isPlaying();

    void j(e eVar);

    void k(f fVar);

    void l(boolean z, int i);

    void m(d dVar);

    void mute(boolean z);

    void n(rw2 rw2Var);

    void o(rw2 rw2Var);

    boolean onBackPressed();

    void p(b bVar);

    void pause();

    int q(String str);

    void r(c cVar);

    void resume();

    void seekTo(int i);

    void stop();
}
