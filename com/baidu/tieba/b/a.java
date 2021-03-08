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
    public static final ThreadLocal<a> ipZ = new ThreadLocal<>();
    private c iqc;
    private final SimpleArrayMap<b, Long> iqa = new SimpleArrayMap<>();
    private final ArrayList<b> mAnimationCallbacks = new ArrayList<>();
    private final C0703a iqb = new C0703a();
    private long iqd = 0;
    private boolean iqe = false;

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
    public class C0703a {
        C0703a() {
        }

        void cqS() {
            a.this.iqd = SystemClock.uptimeMillis();
            a.this.fX(a.this.iqd);
            if (a.this.mAnimationCallbacks.size() > 0) {
                a.this.cqQ().kw();
            }
        }
    }

    public static a cqP() {
        if (ipZ.get() == null) {
            ipZ.set(new a());
        }
        return ipZ.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c cqQ() {
        if (this.iqc == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.iqc = new e(this.iqb);
            } else {
                this.iqc = new d(this.iqb);
            }
        }
        return this.iqc;
    }

    public void a(b bVar, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            cqQ().kw();
        }
        if (!this.mAnimationCallbacks.contains(bVar)) {
            this.mAnimationCallbacks.add(bVar);
        }
        if (j > 0) {
            this.iqa.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void a(b bVar) {
        this.iqa.remove(bVar);
        int indexOf = this.mAnimationCallbacks.indexOf(bVar);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.iqe = true;
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
                cqR();
                return;
            }
        }
    }

    private boolean b(b bVar, long j) {
        Long l = this.iqa.get(bVar);
        if (l == null) {
            return true;
        }
        if (l.longValue() < j) {
            this.iqa.remove(bVar);
            return true;
        }
        return false;
    }

    private void cqR() {
        if (this.iqe) {
            for (int size = this.mAnimationCallbacks.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbacks.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            this.iqe = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(16)
    /* loaded from: classes.dex */
    public static class e extends c {
        private final Choreographer.FrameCallback iqj;
        private final Choreographer mChoreographer;

        e(C0703a c0703a) {
            super(c0703a);
            this.mChoreographer = Choreographer.getInstance();
            this.iqj = new Choreographer.FrameCallback() { // from class: com.baidu.tieba.b.a.e.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j) {
                    e.this.iqg.cqS();
                }
            };
        }

        @Override // com.baidu.tieba.b.a.c
        void kw() {
            this.mChoreographer.postFrameCallback(this.iqj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends c {
        private long iqh;
        private final Handler mHandler;
        private final Runnable mRunnable;

        d(C0703a c0703a) {
            super(c0703a);
            this.iqh = -1L;
            this.mRunnable = new Runnable() { // from class: com.baidu.tieba.b.a.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.iqh = SystemClock.uptimeMillis();
                    d.this.iqg.cqS();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.baidu.tieba.b.a.c
        void kw() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.iqh), 0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c {
        final C0703a iqg;

        abstract void kw();

        c(C0703a c0703a) {
            this.iqg = c0703a;
        }
    }
}
