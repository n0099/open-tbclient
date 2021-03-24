package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.a.d;
import d.a.a.e;
import d.a.a.h;
import d.b.b.e.p.f;
import d.b.b.e.p.k;
import d.b.h0.b1.k.b;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    public static final String k = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.b1.k.b f14218e;

    /* renamed from: f  reason: collision with root package name */
    public String f14219f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f14220g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f14221h;
    public boolean i;
    public b.a j;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.b.h0.b1.k.b.a
        public void a(boolean z, String str) {
            if (!z || k.isEmpty(str)) {
                return;
            }
            TBLottieAnimationView.this.setAnimationDir(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements h<d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f14223a;

        public b(boolean z) {
            this.f14223a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.a.h
        /* renamed from: a */
        public void onResult(d dVar) {
            if (dVar == null) {
                return;
            }
            TBLottieAnimationView.this.setComposition(dVar);
            if (this.f14223a) {
                TBLottieAnimationView.this.playAnimation();
            }
        }
    }

    public TBLottieAnimationView(Context context) {
        super(context);
        this.f14220g = false;
        this.f14221h = false;
        this.i = false;
        this.j = new a();
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e2) {
            TiebaStatic.file(e2, k.join("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public static String getAnimationPath() {
        return k + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static InputStream o(String str, String str2) {
        String animationPath = getAnimationPath();
        if (a(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.x(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public final void b(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        d.b.h0.b1.k.a aVar = new d.b.h0.b1.k.a();
        aVar.e(str);
        aVar.d(getFristLoadInternal());
        setImageAssetDelegate(aVar);
    }

    public final void c(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        boolean z = this.f14220g;
        cancelAnimation();
        InputStream o = o(str, "data.json");
        if (o == null) {
            return;
        }
        e.f(o, str).h(new b(z));
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.f14220g = false;
    }

    public boolean getFristLoadInternal() {
        return this.f14221h;
    }

    public void n() {
        this.i = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.i) {
            super.onRestoreInstanceState(parcelable);
        }
        this.i = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        super.pauseAnimation();
        this.f14220g = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        super.playAnimation();
        this.f14220g = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        super.resumeAnimation();
        this.f14220g = true;
    }

    public void setAnimationDir(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        b(str);
        c(str);
    }

    public void setAnimationUrl(String str) {
        if (k.isEmpty(str) || str.equals(this.f14219f)) {
            return;
        }
        this.f14219f = str;
        d.b.h0.b1.k.b bVar = new d.b.h0.b1.k.b(getAnimationPath(), str, this.j);
        this.f14218e = bVar;
        bVar.execute(new Void[0]);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(@NonNull d dVar) {
        super.setComposition(dVar);
        if (this.f14220g) {
            playAnimation();
        }
    }

    public void setFirstLoadInternal(boolean z) {
        this.f14221h = z;
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14220g = false;
        this.f14221h = false;
        this.i = false;
        this.j = new a();
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14220g = false;
        this.f14221h = false;
        this.i = false;
        this.j = new a();
    }
}
