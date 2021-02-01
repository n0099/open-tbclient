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
    public static final ThreadLocal<a> ioc = new ThreadLocal<>();
    private c iof;
    private final SimpleArrayMap<b, Long> iod = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0696a ioe = new C0696a();
    private long iog = 0;
    private boolean ioh = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        boolean fY(long j);
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0696a {
        C0696a() {
        }

        void cqF() {
            a.this.iog = SystemClock.uptimeMillis();
            a.this.fX(a.this.iog);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.cqD().kw();
            }
        }
    }

    public static a cqC() {
        if (ioc.get() == null) {
            ioc.set(new a());
        }
        return ioc.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cqD() {
        if (this.iof == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.iof = new e(this.ioe);
            } else {
                this.iof = new d(this.ioe);
            }
        }
        return this.iof;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            cqD().kw();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.iod.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.iod.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.ioh = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fX(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mAnimationCallbacks.size()) {
                b bVar = this.mAnimationCallbacks.get(i2);
                if (bVar != null && b(bVar, uptimeMillis)) {
                    bVar.fY(j);
                }
                i = i2 + 1;
            } else {
                cqE();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.iod.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.iod.remove(bVar);
            return true;
        }
        return false;
    }

    private void cqE() {
        if (this.ioh) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.ioh = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer.FrameCallback iom;
        private final Choreographer mChoreographer;

        e(C0696a c0696a) {
            super(c0696a);
            this.mChoreographer = Choreographer.getInstance();
            this.iom = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.b.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.ioj.cqF();
                }
            };
        }

        @Override // com.baidu.tieba.b.a.c
        void kw() {
            this.mChoreographer.postFrameCallback(this.iom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long iok;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0696a c0696a) {
            super(c0696a);
            this.iok = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.b.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iok = SystemClock.uptimeMillis();
                    d.this.ioj.cqF();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.b.a.c
        void kw() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.iok), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0696a ioj;

        abstract void kw();

        c(C0696a c0696a) {
            this.ioj = c0696a;
        }
    }
}
