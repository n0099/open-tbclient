package com.baidu.tieba.c;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v4.util.SimpleArrayMap;
import android.view.Choreographer;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a {
    public static final ThreadLocal<a> iaA = new ThreadLocal<>();
    private c iaD;
    private final SimpleArrayMap<b, Long> iaB = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0723a iaC = new C0723a();
    private long iaE = 0;
    private boolean iaF = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        boolean fT(long j);
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0723a {
        C0723a() {
        }

        void cqs() {
            a.this.iaE = SystemClock.uptimeMillis();
            a.this.fS(a.this.iaE);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.cqq().kY();
            }
        }
    }

    public static a cqp() {
        if (iaA.get() == null) {
            iaA.set(new a());
        }
        return iaA.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cqq() {
        if (this.iaD == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.iaD = new e(this.iaC);
            } else {
                this.iaD = new d(this.iaC);
            }
        }
        return this.iaD;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            cqq().kY();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.iaB.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.iaB.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.iaF = true;
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
                cqr();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.iaB.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.iaB.remove(bVar);
            return true;
        }
        return false;
    }

    private void cqr() {
        if (this.iaF) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.iaF = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer iaK;
        private final Choreographer.FrameCallback iaL;

        e(C0723a c0723a) {
            super(c0723a);
            this.iaK = Choreographer.getInstance();
            this.iaL = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.c.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.iaH.cqs();
                }
            };
        }

        @Override // com.baidu.tieba.c.a.c
        void kY() {
            this.iaK.postFrameCallback(this.iaL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long iaI;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0723a c0723a) {
            super(c0723a);
            this.iaI = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.c.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iaI = SystemClock.uptimeMillis();
                    d.this.iaH.cqs();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.c.a.c
        void kY() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.iaI), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0723a iaH;

        abstract void kY();

        c(C0723a c0723a) {
            this.iaH = c0723a;
        }
    }
}
