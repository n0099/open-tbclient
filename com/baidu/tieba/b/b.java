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
    final Object ioE;
    final com.baidu.tieba.b.c ioF;
    private float ioI;
    public static final d ioo = new d("translationX") { // from class: com.baidu.tieba.b.b.1
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
    public static final d iop = new d("translationY") { // from class: com.baidu.tieba.b.b.7
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
    public static final d ioq = new d("translationZ") { // from class: com.baidu.tieba.b.b.8
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
    public static final d ior = new d("scaleX") { // from class: com.baidu.tieba.b.b.9
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
    public static final d ios = new d("scaleY") { // from class: com.baidu.tieba.b.b.10
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
    public static final d iot = new d("rotation") { // from class: com.baidu.tieba.b.b.11
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
    public static final d iou = new d("rotationX") { // from class: com.baidu.tieba.b.b.12
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
    public static final d iov = new d("rotationY") { // from class: com.baidu.tieba.b.b.13
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
    public static final d iow = new d(Config.EVENT_HEAT_X) { // from class: com.baidu.tieba.b.b.14
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
    public static final d iox = new d("y") { // from class: com.baidu.tieba.b.b.2
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
    public static final d ioy = new d("z") { // from class: com.baidu.tieba.b.b.3
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
    public static final d ioz = new d("alpha") { // from class: com.baidu.tieba.b.b.4
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
    public static final d ioA = new d("scrollX") { // from class: com.baidu.tieba.b.b.5
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
    public static final d ioB = new d("scrollY") { // from class: com.baidu.tieba.b.b.6
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
    float ioC = 0.0f;
    float mValue = Float.MAX_VALUE;
    boolean ioD = false;
    boolean mRunning = false;
    float ioG = Float.MAX_VALUE;
    float ioH = -this.ioG;
    private long iok = 0;
    private final ArrayList<InterfaceC0697b> ioJ = new ArrayList<>();
    private final ArrayList<c> ioK = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a {
        float ioC;
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

    abstract boolean fZ(long j);

    /* loaded from: classes.dex */
    public static abstract class d extends com.baidu.tieba.b.c<View> {
        private d(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> b(K k, com.baidu.tieba.b.c<K> cVar) {
        this.ioE = k;
        this.ioF = cVar;
        if (this.ioF == iot || this.ioF == iou || this.ioF == iov) {
            this.ioI = 0.1f;
        } else if (this.ioF == ioz) {
            this.ioI = 0.00390625f;
        } else if (this.ioF == ior || this.ioF == ios) {
            this.ioI = 0.00390625f;
        } else {
            this.ioI = 1.0f;
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
            cqG();
        }
    }

    private void cqG() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.ioD) {
                this.mValue = cqI();
            }
            if (this.mValue > this.ioG || this.mValue < this.ioH) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            com.baidu.tieba.b.a.cqC().a(this, 0L);
        }
    }

    @Override // com.baidu.tieba.b.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fY(long j) {
        if (this.iok == 0) {
            this.iok = j;
            aE(this.mValue);
            return false;
        }
        this.iok = j;
        boolean fZ = fZ(j - this.iok);
        this.mValue = Math.min(this.mValue, this.ioG);
        this.mValue = Math.max(this.mValue, this.ioH);
        aE(this.mValue);
        if (fZ) {
            pn(false);
        }
        return fZ;
    }

    private void pn(boolean z) {
        int i = 0;
        this.mRunning = false;
        com.baidu.tieba.b.a.cqC().a(this);
        this.iok = 0L;
        this.ioD = false;
        while (true) {
            int i2 = i;
            if (i2 < this.ioJ.size()) {
                if (this.ioJ.get(i2) != null) {
                    this.ioJ.get(i2).a(this, z, this.mValue, this.ioC);
                }
                i = i2 + 1;
            } else {
                ai(this.ioJ);
                return;
            }
        }
    }

    void aE(float f) {
        this.ioF.b(this.ioE, f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioK.size()) {
                if (this.ioK.get(i2) != null) {
                    this.ioK.get(i2).a(this, this.mValue, this.ioC);
                }
                i = i2 + 1;
            } else {
                ai(this.ioK);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cqH() {
        return this.ioI * 0.75f;
    }

    private float cqI() {
        return this.ioF.aJ(this.ioE);
    }
}
