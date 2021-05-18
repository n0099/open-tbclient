package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.c.e.p.f;
import d.a.c.e.p.k;
import d.a.j0.b1.k.b;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    public static final String k = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.b1.k.b f13263e;

    /* renamed from: f  reason: collision with root package name */
    public String f13264f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13265g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13266h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13267i;
    public b.a j;

    /* loaded from: classes3.dex */
    public class a implements b.a {
        public a() {
        }

        @Override // d.a.j0.b1.k.b.a
        public void a(boolean z, String str) {
            if (!z || k.isEmpty(str)) {
                return;
            }
            TBLottieAnimationView.this.setAnimationDir(str);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements LottieListener<LottieComposition> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f13269a;

        public b(boolean z) {
            this.f13269a = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.airbnb.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            if (lottieComposition == null) {
                return;
            }
            TBLottieAnimationView.this.setComposition(lottieComposition);
            if (this.f13269a) {
                TBLottieAnimationView.this.playAnimation();
            }
        }
    }

    public TBLottieAnimationView(Context context) {
        super(context);
        this.f13265g = false;
        this.f13266h = false;
        this.f13267i = false;
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

    public static InputStream n(String str, String str2) {
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
        d.a.j0.b1.k.a aVar = new d.a.j0.b1.k.a();
        aVar.d(str);
        aVar.c(getFristLoadInternal());
        setImageAssetDelegate(aVar);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.f13265g = false;
    }

    public boolean getFristLoadInternal() {
        return this.f13266h;
    }

    public final void i(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        boolean z = this.f13265g;
        cancelAnimation();
        InputStream n = n(str, "data.json");
        if (n == null) {
            return;
        }
        LottieCompositionFactory.fromJsonInputStream(n, str).addListener(new b(z));
    }

    public void l() {
        this.f13267i = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.f13267i) {
            super.onRestoreInstanceState(parcelable);
        }
        this.f13267i = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        super.pauseAnimation();
        this.f13265g = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        super.playAnimation();
        this.f13265g = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        super.resumeAnimation();
        this.f13265g = true;
    }

    public void setAnimationDir(String str) {
        if (k.isEmpty(str)) {
            return;
        }
        b(str);
        i(str);
    }

    public void setAnimationUrl(String str) {
        if (k.isEmpty(str) || str.equals(this.f13264f)) {
            return;
        }
        this.f13264f = str;
        d.a.j0.b1.k.b bVar = new d.a.j0.b1.k.b(getAnimationPath(), str, this.j);
        this.f13263e = bVar;
        bVar.execute(new Void[0]);
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(@NonNull LottieComposition lottieComposition) {
        super.setComposition(lottieComposition);
        if (this.f13265g) {
            playAnimation();
        }
    }

    public void setFirstLoadInternal(boolean z) {
        this.f13266h = z;
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13265g = false;
        this.f13266h = false;
        this.f13267i = false;
        this.j = new a();
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13265g = false;
        this.f13266h = false;
        this.f13267i = false;
        this.j = new a();
    }
}
