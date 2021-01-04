package com.baidu.tieba.b;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.b.a;
import com.baidu.tieba.b.b;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class b<T extends b<T>> implements a.b {
    final Object inF;
    final com.baidu.tieba.b.c inG;
    private float inJ;
    public static final d ino = new d("translationX") { // from class: com.baidu.tieba.b.b.1
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
    public static final d inp = new d("translationY") { // from class: com.baidu.tieba.b.b.7
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
    public static final d inq = new d("translationZ") { // from class: com.baidu.tieba.b.b.8
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
    public static final d inr = new d("scaleX") { // from class: com.baidu.tieba.b.b.9
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

    /* renamed from: int  reason: not valid java name */
    public static final d f4int = new d("scaleY") { // from class: com.baidu.tieba.b.b.10
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
    public static final d inu = new d(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION) { // from class: com.baidu.tieba.b.b.11
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
    public static final d inv = new d("rotationX") { // from class: com.baidu.tieba.b.b.12
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
    public static final d inw = new d("rotationY") { // from class: com.baidu.tieba.b.b.13
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
    public static final d inx = new d("x") { // from class: com.baidu.tieba.b.b.14
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
    public static final d iny = new d("y") { // from class: com.baidu.tieba.b.b.2
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
    public static final d inz = new d(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z) { // from class: com.baidu.tieba.b.b.3
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
    public static final d inA = new d("alpha") { // from class: com.baidu.tieba.b.b.4
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
    public static final d inB = new d("scrollX") { // from class: com.baidu.tieba.b.b.5
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
    public static final d inC = new d("scrollY") { // from class: com.baidu.tieba.b.b.6
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
    float inD = 0.0f;
    float mValue = Float.MAX_VALUE;
    boolean inE = false;
    boolean mRunning = false;
    float inH = Float.MAX_VALUE;
    float inI = -this.inH;
    private long ink = 0;
    private final ArrayList<InterfaceC0714b> inK = new ArrayList<>();
    private final ArrayList<c> inL = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a {
        float inD;
        float mValue;
    }

    /* renamed from: com.baidu.tieba.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0714b {
        void a(b bVar, boolean z, float f, float f2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(b bVar, float f, float f2);
    }

    abstract boolean C(float f, float f2);

    abstract boolean fU(long j);

    /* loaded from: classes.dex */
    public static abstract class d extends com.baidu.tieba.b.c<View> {
        private d(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> b(K k, com.baidu.tieba.b.c<K> cVar) {
        this.inF = k;
        this.inG = cVar;
        if (this.inG == inu || this.inG == inv || this.inG == inw) {
            this.inJ = 0.1f;
        } else if (this.inG == inA) {
            this.inJ = 0.00390625f;
        } else if (this.inG == inr || this.inG == f4int) {
            this.inJ = 0.00390625f;
        } else {
            this.inJ = 1.0f;
        }
    }

    private static <T> void ao(ArrayList<T> arrayList) {
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
            ctn();
        }
    }

    private void ctn() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.inE) {
                this.mValue = ctp();
            }
            if (this.mValue > this.inH || this.mValue < this.inI) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            com.baidu.tieba.b.a.ctj().a(this, 0L);
        }
    }

    @Override // com.baidu.tieba.b.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fT(long j) {
        if (this.ink == 0) {
            this.ink = j;
            aB(this.mValue);
            return false;
        }
        this.ink = j;
        boolean fU = fU(j - this.ink);
        this.mValue = Math.min(this.mValue, this.inH);
        this.mValue = Math.max(this.mValue, this.inI);
        aB(this.mValue);
        if (fU) {
            ph(false);
        }
        return fU;
    }

    private void ph(boolean z) {
        int i = 0;
        this.mRunning = false;
        com.baidu.tieba.b.a.ctj().a(this);
        this.ink = 0L;
        this.inE = false;
        while (true) {
            int i2 = i;
            if (i2 < this.inK.size()) {
                if (this.inK.get(i2) != null) {
                    this.inK.get(i2).a(this, z, this.mValue, this.inD);
                }
                i = i2 + 1;
            } else {
                ao(this.inK);
                return;
            }
        }
    }

    void aB(float f) {
        this.inG.b(this.inF, f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.inL.size()) {
                if (this.inL.get(i2) != null) {
                    this.inL.get(i2).a(this, this.mValue, this.inD);
                }
                i = i2 + 1;
            } else {
                ao(this.inL);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cto() {
        return this.inJ * 0.75f;
    }

    private float ctp() {
        return this.inG.aJ(this.inF);
    }
}
