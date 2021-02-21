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
    public static final d ioC = new d("translationX") { // from class: com.baidu.tieba.b.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setTranslationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getTranslationX();
        }
    };
    public static final d ioD = new d("translationY") { // from class: com.baidu.tieba.b.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setTranslationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getTranslationY();
        }
    };
    public static final d ioE = new d("translationZ") { // from class: com.baidu.tieba.b.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return ViewCompat.getTranslationZ(view);
        }
    };
    public static final d ioF = new d("scaleX") { // from class: com.baidu.tieba.b.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScaleX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getScaleX();
        }
    };
    public static final d ioG = new d("scaleY") { // from class: com.baidu.tieba.b.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScaleY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getScaleY();
        }
    };
    public static final d ioH = new d("rotation") { // from class: com.baidu.tieba.b.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotation(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getRotation();
        }
    };
    public static final d ioI = new d("rotationX") { // from class: com.baidu.tieba.b.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getRotationX();
        }
    };
    public static final d ioJ = new d("rotationY") { // from class: com.baidu.tieba.b.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getRotationY();
        }
    };
    public static final d ioK = new d(Config.EVENT_HEAT_X) { // from class: com.baidu.tieba.b.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getX();
        }
    };
    public static final d ioL = new d("y") { // from class: com.baidu.tieba.b.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getY();
        }
    };
    public static final d ioM = new d("z") { // from class: com.baidu.tieba.b.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            ViewCompat.setZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return ViewCompat.getZ(view);
        }
    };
    public static final d ioN = new d("alpha") { // from class: com.baidu.tieba.b.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setAlpha(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getAlpha();
        }
    };
    public static final d ioO = new d("scrollX") { // from class: com.baidu.tieba.b.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScrollX((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getScrollX();
        }
    };
    public static final d ioP = new d("scrollY") { // from class: com.baidu.tieba.b.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScrollY((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b.c
        /* renamed from: cH */
        public float aJ(View view) {
            return view.getScrollY();
        }
    };
    final Object ioS;
    final com.baidu.tieba.b.c ioT;
    private float ioW;
    float ioQ = 0.0f;
    float mValue = Float.MAX_VALUE;
    boolean ioR = false;
    boolean mRunning = false;
    float ioU = Float.MAX_VALUE;
    float ioV = -this.ioU;
    private long ioy = 0;
    private final ArrayList<InterfaceC0698b> ioX = new ArrayList<>();
    private final ArrayList<c> ioY = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a {
        float ioQ;
        float mValue;
    }

    /* renamed from: com.baidu.tieba.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0698b {
        void a(b bVar, boolean z, float f, float f2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(b bVar, float f, float f2);
    }

    abstract boolean D(float f, float f2);

    abstract boolean fZ(long j);

    /* loaded from: classes.dex */
    public static abstract class d extends com.baidu.tieba.b.c<View> {
        private d(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> b(K k, com.baidu.tieba.b.c<K> cVar) {
        this.ioS = k;
        this.ioT = cVar;
        if (this.ioT == ioH || this.ioT == ioI || this.ioT == ioJ) {
            this.ioW = 0.1f;
        } else if (this.ioT == ioN) {
            this.ioW = 0.00390625f;
        } else if (this.ioT == ioF || this.ioT == ioG) {
            this.ioW = 0.00390625f;
        } else {
            this.ioW = 1.0f;
        }
    }

    private static <T> void ai(ArrayList<T> arrayList) {
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
            cqN();
        }
    }

    private void cqN() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.ioR) {
                this.mValue = cqP();
            }
            if (this.mValue > this.ioU || this.mValue < this.ioV) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            com.baidu.tieba.b.a.cqJ().a(this, 0L);
        }
    }

    @Override // com.baidu.tieba.b.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fY(long j) {
        if (this.ioy == 0) {
            this.ioy = j;
            aE(this.mValue);
            return false;
        }
        this.ioy = j;
        boolean fZ = fZ(j - this.ioy);
        this.mValue = Math.min(this.mValue, this.ioU);
        this.mValue = Math.max(this.mValue, this.ioV);
        aE(this.mValue);
        if (fZ) {
            pn(false);
        }
        return fZ;
    }

    private void pn(boolean z) {
        int i = 0;
        this.mRunning = false;
        com.baidu.tieba.b.a.cqJ().a(this);
        this.ioy = 0L;
        this.ioR = false;
        while (true) {
            int i2 = i;
            if (i2 < this.ioX.size()) {
                if (this.ioX.get(i2) != null) {
                    this.ioX.get(i2).a(this, z, this.mValue, this.ioQ);
                }
                i = i2 + 1;
            } else {
                ai(this.ioX);
                return;
            }
        }
    }

    void aE(float f) {
        this.ioT.b(this.ioS, f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioY.size()) {
                if (this.ioY.get(i2) != null) {
                    this.ioY.get(i2).a(this, this.mValue, this.ioQ);
                }
                i = i2 + 1;
            } else {
                ai(this.ioY);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cqO() {
        return this.ioW * 0.75f;
    }

    private float cqP() {
        return this.ioT.aJ(this.ioS);
    }
}
