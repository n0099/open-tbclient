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
    public static final ThreadLocal<a> iaC = new ThreadLocal<>();
    private c iaF;
    private final SimpleArrayMap<b, Long> iaD = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0723a iaE = new C0723a();
    private long iaG = 0;
    private boolean iaH = false;

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

        void cqt() {
            a.this.iaG = SystemClock.uptimeMillis();
            a.this.fS(a.this.iaG);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.cqr().kY();
            }
        }
    }

    public static a cqq() {
        if (iaC.get() == null) {
            iaC.set(new a());
        }
        return iaC.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cqr() {
        if (this.iaF == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.iaF = new e(this.iaE);
            } else {
                this.iaF = new d(this.iaE);
            }
        }
        return this.iaF;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            cqr().kY();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.iaD.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.iaD.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.iaH = true;
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
                cqs();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.iaD.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.iaD.remove(bVar);
            return true;
        }
        return false;
    }

    private void cqs() {
        if (this.iaH) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.iaH = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer iaM;
        private final Choreographer.FrameCallback iaN;

        e(C0723a c0723a) {
            super(c0723a);
            this.iaM = Choreographer.getInstance();
            this.iaN = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.c.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.iaJ.cqt();
                }
            };
        }

        @Override // com.baidu.tieba.c.a.c
        void kY() {
            this.iaM.postFrameCallback(this.iaN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long iaK;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0723a c0723a) {
            super(c0723a);
            this.iaK = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.c.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iaK = SystemClock.uptimeMillis();
                    d.this.iaJ.cqt();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.c.a.c
        void kY() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.iaK), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0723a iaJ;

        abstract void kY();

        c(C0723a c0723a) {
            this.iaJ = c0723a;
        }
    }
}
