package com.baidu.tieba.c;

import android.os.Looper;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.util.AndroidRuntimeException;
import android.view.View;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.c.a;
import com.baidu.tieba.c.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class b<T extends b<T>> implements a.b {
    public static final d hPW = new d("translationX") { // from class: com.baidu.tieba.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setTranslationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getTranslationX();
        }
    };
    public static final d hPX = new d("translationY") { // from class: com.baidu.tieba.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setTranslationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getTranslationY();
        }
    };
    public static final d hPY = new d("translationZ") { // from class: com.baidu.tieba.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return ViewCompat.getTranslationZ(view);
        }
    };
    public static final d hPZ = new d("scaleX") { // from class: com.baidu.tieba.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setScaleX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getScaleX();
        }
    };
    public static final d hQa = new d("scaleY") { // from class: com.baidu.tieba.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setScaleY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getScaleY();
        }
    };
    public static final d hQb = new d(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION) { // from class: com.baidu.tieba.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setRotation(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getRotation();
        }
    };
    public static final d hQc = new d("rotationX") { // from class: com.baidu.tieba.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setRotationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getRotationX();
        }
    };
    public static final d hQd = new d("rotationY") { // from class: com.baidu.tieba.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setRotationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getRotationY();
        }
    };
    public static final d hQe = new d("x") { // from class: com.baidu.tieba.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getX();
        }
    };
    public static final d hQf = new d("y") { // from class: com.baidu.tieba.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getY();
        }
    };
    public static final d hQg = new d(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z) { // from class: com.baidu.tieba.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            ViewCompat.setZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return ViewCompat.getZ(view);
        }
    };
    public static final d hQh = new d("alpha") { // from class: com.baidu.tieba.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setAlpha(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getAlpha();
        }
    };
    public static final d hQi = new d("scrollX") { // from class: com.baidu.tieba.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setScrollX((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getScrollX();
        }
    };
    public static final d hQj = new d("scrollY") { // from class: com.baidu.tieba.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        public void setValue(View view, float f) {
            view.setScrollY((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cs */
        public float aI(View view) {
            return view.getScrollY();
        }
    };
    final com.baidu.tieba.c.c hQm;
    private float hQp;
    final Object mTarget;
    float hQk = 0.0f;
    float mValue = Float.MAX_VALUE;
    boolean hQl = false;
    boolean mRunning = false;
    float hQn = Float.MAX_VALUE;
    float hQo = -this.hQn;
    private long hPS = 0;
    private final ArrayList<InterfaceC0710b> hQq = new ArrayList<>();
    private final ArrayList<c> mUpdateListeners = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a {
        float hQk;
        float mValue;
    }

    /* renamed from: com.baidu.tieba.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0710b {
        void a(b bVar, boolean z, float f, float f2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(b bVar, float f, float f2);
    }

    abstract boolean C(float f, float f2);

    abstract boolean fq(long j);

    /* loaded from: classes.dex */
    public static abstract class d extends com.baidu.tieba.c.c<View> {
        private d(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> b(K k, com.baidu.tieba.c.c<K> cVar) {
        this.mTarget = k;
        this.hQm = cVar;
        if (this.hQm == hQb || this.hQm == hQc || this.hQm == hQd) {
            this.hQp = 0.1f;
        } else if (this.hQm == hQh) {
            this.hQp = 0.00390625f;
        } else if (this.hQm == hPZ || this.hQm == hQa) {
            this.hQp = 0.00390625f;
        } else {
            this.hQp = 1.0f;
        }
    }

    private static <T> void an(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    public void start() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (!this.mRunning) {
            cmg();
        }
    }

    private void cmg() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.hQl) {
                this.mValue = cmi();
            }
            if (this.mValue > this.hQn || this.mValue < this.hQo) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            com.baidu.tieba.c.a.cmc().a(this, 0L);
        }
    }

    @Override // com.baidu.tieba.c.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fp(long j) {
        if (this.hPS == 0) {
            this.hPS = j;
            ay(this.mValue);
            return false;
        }
        this.hPS = j;
        boolean fq = fq(j - this.hPS);
        this.mValue = Math.min(this.mValue, this.hQn);
        this.mValue = Math.max(this.mValue, this.hQo);
        ay(this.mValue);
        if (fq) {
            om(false);
        }
        return fq;
    }

    private void om(boolean z) {
        int i = 0;
        this.mRunning = false;
        com.baidu.tieba.c.a.cmc().a(this);
        this.hPS = 0L;
        this.hQl = false;
        while (true) {
            int i2 = i;
            if (i2 < this.hQq.size()) {
                if (this.hQq.get(i2) != null) {
                    this.hQq.get(i2).a(this, z, this.mValue, this.hQk);
                }
                i = i2 + 1;
            } else {
                an(this.hQq);
                return;
            }
        }
    }

    void ay(float f) {
        this.hQm.setValue(this.mTarget, f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mUpdateListeners.size()) {
                if (this.mUpdateListeners.get(i2) != null) {
                    this.mUpdateListeners.get(i2).a(this, this.mValue, this.hQk);
                }
                i = i2 + 1;
            } else {
                an(this.mUpdateListeners);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cmh() {
        return this.hQp * 0.75f;
    }

    private float cmi() {
        return this.hQm.aI(this.mTarget);
    }
}
