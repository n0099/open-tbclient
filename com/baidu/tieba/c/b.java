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
    public static final d iaP = new d("translationX") { // from class: com.baidu.tieba.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setTranslationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getTranslationX();
        }
    };
    public static final d iaQ = new d("translationY") { // from class: com.baidu.tieba.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setTranslationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getTranslationY();
        }
    };
    public static final d iaR = new d("translationZ") { // from class: com.baidu.tieba.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            ViewCompat.setTranslationZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return ViewCompat.getTranslationZ(view);
        }
    };
    public static final d iaS = new d("scaleX") { // from class: com.baidu.tieba.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScaleX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getScaleX();
        }
    };
    public static final d iaT = new d("scaleY") { // from class: com.baidu.tieba.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScaleY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getScaleY();
        }
    };
    public static final d iaU = new d(MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION) { // from class: com.baidu.tieba.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotation(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getRotation();
        }
    };
    public static final d iaV = new d("rotationX") { // from class: com.baidu.tieba.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotationX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getRotationX();
        }
    };
    public static final d iaW = new d("rotationY") { // from class: com.baidu.tieba.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setRotationY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getRotationY();
        }
    };
    public static final d iaX = new d("x") { // from class: com.baidu.tieba.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setX(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getX();
        }
    };
    public static final d iaY = new d("y") { // from class: com.baidu.tieba.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setY(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getY();
        }
    };
    public static final d iaZ = new d(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z) { // from class: com.baidu.tieba.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            ViewCompat.setZ(view, f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return ViewCompat.getZ(view);
        }
    };
    public static final d iba = new d("alpha") { // from class: com.baidu.tieba.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setAlpha(f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getAlpha();
        }
    };
    public static final d ibb = new d("scrollX") { // from class: com.baidu.tieba.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScrollX((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getScrollX();
        }
    };
    public static final d ibc = new d("scrollY") { // from class: com.baidu.tieba.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: o */
        public void b(View view, float f) {
            view.setScrollY((int) f);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.c.c
        /* renamed from: cz */
        public float aI(View view) {
            return view.getScrollY();
        }
    };
    final Object ibf;
    final com.baidu.tieba.c.c ibg;
    private float ibj;
    float ibd = 0.0f;
    float mValue = Float.MAX_VALUE;
    boolean ibe = false;
    boolean mRunning = false;
    float ibh = Float.MAX_VALUE;
    float ibi = -this.ibh;
    private long iaK = 0;
    private final ArrayList<InterfaceC0724b> ibk = new ArrayList<>();
    private final ArrayList<c> ibl = new ArrayList<>();

    /* loaded from: classes.dex */
    static class a {
        float ibd;
        float mValue;
    }

    /* renamed from: com.baidu.tieba.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0724b {
        void a(b bVar, boolean z, float f, float f2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(b bVar, float f, float f2);
    }

    abstract boolean C(float f, float f2);

    abstract boolean fU(long j);

    /* loaded from: classes.dex */
    public static abstract class d extends com.baidu.tieba.c.c<View> {
        private d(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> b(K k, com.baidu.tieba.c.c<K> cVar) {
        this.ibf = k;
        this.ibg = cVar;
        if (this.ibg == iaU || this.ibg == iaV || this.ibg == iaW) {
            this.ibj = 0.1f;
        } else if (this.ibg == iba) {
            this.ibj = 0.00390625f;
        } else if (this.ibg == iaS || this.ibg == iaT) {
            this.ibj = 0.00390625f;
        } else {
            this.ibj = 1.0f;
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
            cqu();
        }
    }

    private void cqu() {
        if (!this.mRunning) {
            this.mRunning = true;
            if (!this.ibe) {
                this.mValue = cqw();
            }
            if (this.mValue > this.ibh || this.mValue < this.ibi) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            com.baidu.tieba.c.a.cqq().a(this, 0L);
        }
    }

    @Override // com.baidu.tieba.c.a.b
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean fT(long j) {
        if (this.iaK == 0) {
            this.iaK = j;
            az(this.mValue);
            return false;
        }
        this.iaK = j;
        boolean fU = fU(j - this.iaK);
        this.mValue = Math.min(this.mValue, this.ibh);
        this.mValue = Math.max(this.mValue, this.ibi);
        az(this.mValue);
        if (fU) {
            oI(false);
        }
        return fU;
    }

    private void oI(boolean z) {
        int i = 0;
        this.mRunning = false;
        com.baidu.tieba.c.a.cqq().a(this);
        this.iaK = 0L;
        this.ibe = false;
        while (true) {
            int i2 = i;
            if (i2 < this.ibk.size()) {
                if (this.ibk.get(i2) != null) {
                    this.ibk.get(i2).a(this, z, this.mValue, this.ibd);
                }
                i = i2 + 1;
            } else {
                ao(this.ibk);
                return;
            }
        }
    }

    void az(float f) {
        this.ibg.b(this.ibf, f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ibl.size()) {
                if (this.ibl.get(i2) != null) {
                    this.ibl.get(i2).a(this, this.mValue, this.ibd);
                }
                i = i2 + 1;
            } else {
                ao(this.ibl);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float cqv() {
        return this.ibj * 0.75f;
    }

    private float cqw() {
        return this.ibg.aI(this.ibf);
    }
}
