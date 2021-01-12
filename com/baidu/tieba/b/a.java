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
    public static final ThreadLocal<a> iiu = new ThreadLocal<>();
    private c iix;
    private final SimpleArrayMap<b, Long> iiv = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0696a iiw = new C0696a();
    private long iiy = 0;
    private boolean iiz = false;

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
    public class C0696a {
        C0696a() {
        }

        void cpv() {
            a.this.iiy = SystemClock.uptimeMillis();
            a.this.fS(a.this.iiy);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.cpt().kx();
            }
        }
    }

    public static a cps() {
        if (iiu.get() == null) {
            iiu.set(new a());
        }
        return iiu.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cpt() {
        if (this.iix == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.iix = new e(this.iiw);
            } else {
                this.iix = new d(this.iiw);
            }
        }
        return this.iix;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            cpt().kx();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.iiv.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.iiv.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.iiz = true;
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
                cpu();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.iiv.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.iiv.remove(bVar);
            return true;
        }
        return false;
    }

    private void cpu() {
        if (this.iiz) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.iiz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer.FrameCallback iiE;
        private final Choreographer mChoreographer;

        e(C0696a c0696a) {
            super(c0696a);
            this.mChoreographer = Choreographer.getInstance();
            this.iiE = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.b.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.iiB.cpv();
                }
            };
        }

        @Override // com.baidu.tieba.b.a.c
        void kx() {
            this.mChoreographer.postFrameCallback(this.iiE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long iiC;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0696a c0696a) {
            super(c0696a);
            this.iiC = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.b.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iiC = SystemClock.uptimeMillis();
                    d.this.iiB.cpv();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.b.a.c
        void kx() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.iiC), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0696a iiB;

        abstract void kx();

        c(C0696a c0696a) {
            this.iiB = c0696a;
        }
    }
}
