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
    public static final ThreadLocal<a> ioq = new ThreadLocal<>();
    private c iot;
    private final SimpleArrayMap<b, Long> ior = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0697a ios = new C0697a();
    private long iou = 0;
    private boolean iov = false;

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
    public class C0697a {
        C0697a() {
        }

        void cqM() {
            a.this.iou = SystemClock.uptimeMillis();
            a.this.fX(a.this.iou);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.cqK().kw();
            }
        }
    }

    public static a cqJ() {
        if (ioq.get() == null) {
            ioq.set(new a());
        }
        return ioq.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cqK() {
        if (this.iot == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.iot = new e(this.ios);
            } else {
                this.iot = new d(this.ios);
            }
        }
        return this.iot;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            cqK().kw();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.ior.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.ior.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.iov = true;
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
                cqL();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.ior.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.ior.remove(bVar);
            return true;
        }
        return false;
    }

    private void cqL() {
        if (this.iov) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.iov = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer.FrameCallback ioA;
        private final Choreographer mChoreographer;

        e(C0697a c0697a) {
            super(c0697a);
            this.mChoreographer = Choreographer.getInstance();
            this.ioA = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.b.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.iox.cqM();
                }
            };
        }

        @Override // com.baidu.tieba.b.a.c
        void kw() {
            this.mChoreographer.postFrameCallback(this.ioA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long ioy;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0697a c0697a) {
            super(c0697a);
            this.ioy = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.b.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ioy = SystemClock.uptimeMillis();
                    d.this.iox.cqM();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.b.a.c
        void kw() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.ioy), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0697a iox;

        abstract void kw();

        c(C0697a c0697a) {
            this.iox = c0697a;
        }
    }
}
