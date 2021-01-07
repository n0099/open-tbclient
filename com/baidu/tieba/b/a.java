package com.baidu.tieba.b;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    public static final ThreadLocal<a> inc = new ThreadLocal<>();
    private c inf;
    private final SimpleArrayMap<b, Long> ind = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0713a ine = new C0713a();
    private long ing = 0;
    private boolean inh = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        boolean fT(long j);
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0713a {
        C0713a() {
        }

        void ctn() {
            a.this.ing = SystemClock.uptimeMillis();
            a.this.fS(a.this.ing);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.ctl().kx();
            }
        }
    }

    public static a ctk() {
        if (inc.get() == null) {
            inc.set(new a());
        }
        return inc.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ctl() {
        if (this.inf == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.inf = new e(this.ine);
            } else {
                this.inf = new d(this.ine);
            }
        }
        return this.inf;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            ctl().kx();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.ind.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.ind.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.inh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fS(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mAnimationCallbacks.size()) {
                b bVar = this.mAnimationCallbacks.get(i2);
                if (bVar != null && b(bVar, uptimeMillis)) {
                    bVar.fT(j);
                }
                i = i2 + 1;
            } else {
                ctm();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.ind.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.ind.remove(bVar);
            return true;
        }
        return false;
    }

    private void ctm() {
        if (this.inh) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.inh = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer.FrameCallback inm;
        private final Choreographer mChoreographer;

        e(C0713a c0713a) {
            super(c0713a);
            this.mChoreographer = Choreographer.getInstance();
            this.inm = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.b.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.inj.ctn();
                }
            };
        }

        @Override // com.baidu.tieba.b.a.c
        void kx() {
            this.mChoreographer.postFrameCallback(this.inm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long ink;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0713a c0713a) {
            super(c0713a);
            this.ink = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.b.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ink = SystemClock.uptimeMillis();
                    d.this.inj.ctn();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.b.a.c
        void kx() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.ink), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0713a inj;

        abstract void kx();

        c(C0713a c0713a) {
            this.inj = c0713a;
        }
    }
}
