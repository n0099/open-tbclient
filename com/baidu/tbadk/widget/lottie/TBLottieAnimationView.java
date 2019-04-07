package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.e;
import com.airbnb.lottie.h;
import com.baidu.adp.lib.util.f;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.lottie.b;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    private boolean cAU;
    private b cAY;
    private com.airbnb.lottie.a cAZ;
    private LottieAnimationView.CacheStrategy cBa;
    private boolean cBb;
    private boolean cBc;
    private b.a cBd;
    private String mUrl;
    private LottieAnimationView.CacheStrategy nd;
    private static final Map<String, e> cAW = new HashMap();
    private static final Map<String, WeakReference<e>> cAX = new HashMap();
    public static final String cAS = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.nd = LottieAnimationView.CacheStrategy.Weak;
        this.cBa = this.nd;
        this.cBb = false;
        this.cAU = false;
        this.cBc = false;
        this.cBd = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void i(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cBa);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nd = LottieAnimationView.CacheStrategy.Weak;
        this.cBa = this.nd;
        this.cBb = false;
        this.cAU = false;
        this.cBc = false;
        this.cBd = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void i(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cBa);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nd = LottieAnimationView.CacheStrategy.Weak;
        this.cBa = this.nd;
        this.cBb = false;
        this.cAU = false;
        this.cBc = false;
        this.cBd = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void i(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cBa);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.nd);
    }

    public static String getAnimationPath() {
        return cAS + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean pX(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.j("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public static InputStream bX(String str, String str2) {
        String animationPath = getAnimationPath();
        if (pX(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.n(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void setAnimationUrl(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ap.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.cBa = cacheStrategy;
            this.cAY = new b(getAnimationPath(), str, this.cBd);
            this.cAY.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ap.isEmpty(str)) {
            qa(str);
            a(str, cacheStrategy);
        }
    }

    private void qa(String str) {
        if (!ap.isEmpty(str)) {
            a aVar = new a();
            aVar.setPath(str);
            aVar.setFirstLoadInternal(getFristLoadInternal());
            setImageAssetDelegate(aVar);
        }
    }

    private void a(final String str, final LottieAnimationView.CacheStrategy cacheStrategy) {
        e eVar;
        if (!ap.isEmpty(str)) {
            if (cAX.containsKey(str)) {
                e eVar2 = cAX.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (cAW.containsKey(str) && (eVar = cAW.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.cBb;
            cancelAnimation();
            asf();
            InputStream bX = bX(str, "data.json");
            if (bX != null) {
                this.cAZ = e.a.a(getContext(), bX, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.cAX.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.cAW.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.cu();
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void setComposition(@NonNull e eVar) {
        super.setComposition(eVar);
        if (this.cBb) {
            cu();
        }
    }

    private void asf() {
        if (this.cAZ != null) {
            this.cAZ.cancel();
            this.cAZ = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cu() {
        super.cu();
        this.cBb = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cw() {
        super.cw();
        this.cBb = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.cBb = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cv() {
        super.cv();
        this.cBb = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.cAU = z;
    }

    public boolean getFristLoadInternal() {
        return this.cAU;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.cBc) {
            super.onRestoreInstanceState(parcelable);
        }
        this.cBc = false;
    }

    public void asg() {
        this.cBc = true;
    }
}
