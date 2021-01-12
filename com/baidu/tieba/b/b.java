package com.baidu.tieba.b;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.baidu.mobstat.Config;
import com.baidu.tieba.b.a;
import com.baidu.tieba.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class b<T extends b<T>> implements a.b {
    public static final d iiG = new d("translationX") { // from class: com.baidu.tieba.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setTranslationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getTranslationX();
        }
    };
    public static final d iiH = new d("translationY") { // from class: com.baidu.tieba.b.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setTranslationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getTranslationY();
        }
    };
    public static final d iiI = new d("translationZ") { // from class: com.baidu.tieba.b.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return ViewCompat.getTranslationZ(view);
        }
    };
    public static final d iiJ = new d("scaleX") { // from class: com.baidu.tieba.b.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScaleX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getScaleX();
        }
    };
    public static final d iiK = new d("scaleY") { // from class: com.baidu.tieba.b.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScaleY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getScaleY();
        }
    };
    public static final d iiL = new d("rotation") { // from class: com.baidu.tieba.b.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotation(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getRotation();
        }
    };
    public static final d iiM = new d("rotationX") { // from class: com.baidu.tieba.b.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getRotationX();
        }
    };
    public static final d iiN = new d("rotationY") { // from class: com.baidu.tieba.b.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getRotationY();
        }
    };
    public static final d iiO = new d(Config.EVENT_HEAT_X) { // from class: com.baidu.tieba.b.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getX();
        }
    };
    public static final d iiP = new d("y") { // from class: com.baidu.tieba.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getY();
        }
    };
    public static final d iiQ = new d("z") { // from class: com.baidu.tieba.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            ViewCompat.setZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return ViewCompat.getZ(view);
        }
    };
    public static final d iiR = new d("alpha") { // from class: com.baidu.tieba.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setAlpha(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getAlpha();
        }
    };
    public static final d iiS = new d("scrollX") { // from class: com.baidu.tieba.b.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScrollX((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getScrollX();
        }
    };
    public static final d iiT = new d("scrollY") { // from class: com.baidu.tieba.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScrollY((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cJ */
        public float aJ(View view) {
            return view.getScrollY();
        }
    };
    final Object iiW;
    final com.baidu.tieba.b.c iiX;
    private float ija;
    float iiU = 0.0f;
    float mValue = Float.MAX_VALUE;
    boolean iiV = false;
    boolean mRunning = false;
    float iiY = Float.MAX_VALUE;
    float iiZ = -this.iiY;
    private long iiC = 0;
    private final ArrayList<InterfaceC0697b> ijb = new ArrayList<>();
    private final ArrayList<c> ijc = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a {
        float iiU;
        float mValue;
    }

    /* renamed from: com.baidu.tieba.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0697b {
        void a(b bVar, boolean z, float f, float f2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(b bVar, float f, float f2);
    }

    abstract boolean D(float f, float f2);

    abstract boolean fU(long j);

    /* loaded from: classes.dex */
    public static abstract class d extends com.baidu.tieba.b.c<View> {
        private d(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> b(K k, com.baidu.tieba.b.c<K> cVar) {
        this.iiW = k;
        this.iiX = cVar;
        if (this.iiX == iiL || this.iiX == iiM || this.iiX == iiN) {
            this.ija = 0.1f;
        } else if (this.iiX == iiR) {
            this.ija = 0.00390625f;
        } else if (this.iiX == iiJ || this.iiX == iiK) {
            this.ija = 0.00390625f;
        } else {
            this.ija = 1.0f;
        }
    }

    private static <T> void aj(ArrayList<T> arrayList) {
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
            cpw();
        }
    }

    private void cpw() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.iiV) {
                this.mValue = cpy();
            }
            if (this.mValue > this.iiY || this.mValue < this.iiZ) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            com.baidu.tieba.b.a.cps().a(this, 0L);
        }
    }

    @Override // com.baidu.tieba.b.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fT(long j) {
        if (this.iiC == 0) {
            this.iiC = j;
            aB(this.mValue);
            return false;
        }
        this.iiC = j;
        boolean fU = fU(j - this.iiC);
        this.mValue = Math.min(this.mValue, this.iiY);
        this.mValue = Math.max(this.mValue, this.iiZ);
        aB(this.mValue);
        if (fU) {
            pd(false);
        }
        return fU;
    }

    private void pd(boolean z) {
        int i = 0;
        this.mRunning = false;
        com.baidu.tieba.b.a.cps().a(this);
        this.iiC = 0L;
        this.iiV = false;
        while (true) {
            int i2 = i;
            if (i2 < this.ijb.size()) {
                if (this.ijb.get(i2) != null) {
                    this.ijb.get(i2).a(this, z, this.mValue, this.iiU);
                }
                i = i2 + 1;
            } else {
                aj(this.ijb);
                return;
            }
        }
    }

    void aB(float f) {
        this.iiX.b(this.iiW, f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ijc.size()) {
                if (this.ijc.get(i2) != null) {
                    this.ijc.get(i2).a(this, this.mValue, this.iiU);
                }
                i = i2 + 1;
            } else {
                aj(this.ijc);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cpx() {
        return this.ija * 0.75f;
    }

    private float cpy() {
        return this.iiX.aJ(this.iiW);
    }
}
