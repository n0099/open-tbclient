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
    public static final ThreadLocal<a> hPK = new ThreadLocal<>();
    private c hPN;
    private final SimpleArrayMap<b, Long> hPL = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0709a hPM = new C0709a();
    private long hPO = 0;
    private boolean hPP = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        boolean fp(long j);
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0709a {
        C0709a() {
        }

        void cmf() {
            a.this.hPO = SystemClock.uptimeMillis();
            a.this.fo(a.this.hPO);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.cmd().kY();
            }
        }
    }

    public static a cmc() {
        if (hPK.get() == null) {
            hPK.set(new a());
        }
        return hPK.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cmd() {
        if (this.hPN == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.hPN = new e(this.hPM);
            } else {
                this.hPN = new d(this.hPM);
            }
        }
        return this.hPN;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            cmd().kY();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.hPL.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.hPL.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.hPP = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mAnimationCallbacks.size()) {
                b bVar = this.mAnimationCallbacks.get(i2);
                if (bVar != null && b(bVar, uptimeMillis)) {
                    bVar.fp(j);
                }
                i = i2 + 1;
            } else {
                cme();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.hPL.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.hPL.remove(bVar);
            return true;
        }
        return false;
    }

    private void cme() {
        if (this.hPP) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.hPP = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer.FrameCallback hPU;
        private final Choreographer mChoreographer;

        e(C0709a c0709a) {
            super(c0709a);
            this.mChoreographer = Choreographer.getInstance();
            this.hPU = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.c.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.hPR.cmf();
                }
            };
        }

        @Override // com.baidu.tieba.c.a.c
        void kY() {
            this.mChoreographer.postFrameCallback(this.hPU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long hPS;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0709a c0709a) {
            super(c0709a);
            this.hPS = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.c.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hPS = SystemClock.uptimeMillis();
                    d.this.hPR.cmf();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.c.a.c
        void kY() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.hPS), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0709a hPR;

        abstract void kY();

        c(C0709a c0709a) {
            this.hPR = c0709a;
        }
    }
}
