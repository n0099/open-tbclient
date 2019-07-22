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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.lottie.b;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    private static final Map<String, e> cKA = new HashMap();
    private static final Map<String, WeakReference<e>> cKB = new HashMap();
    public static final String cKw = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private b cKC;
    private com.airbnb.lottie.a cKD;
    private LottieAnimationView.CacheStrategy cKE;
    private boolean cKF;
    private boolean cKG;
    private b.a cKH;
    private boolean cKy;
    private LottieAnimationView.CacheStrategy kC;
    private String mUrl;

    public TBLottieAnimationView(Context context) {
        super(context);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cKE = this.kC;
        this.cKF = false;
        this.cKy = false;
        this.cKG = false;
        this.cKH = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cKE);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cKE = this.kC;
        this.cKF = false;
        this.cKy = false;
        this.cKG = false;
        this.cKH = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cKE);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cKE = this.kC;
        this.cKF = false;
        this.cKy = false;
        this.cKG = false;
        this.cKH = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cKE);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.kC);
    }

    public static String getAnimationPath() {
        return cKw + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean rx(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.i("FileHelper", ".", "CheckTempDir", " ", str));
            return false;
        }
    }

    public static InputStream ci(String str, String str2) {
        String animationPath = getAnimationPath();
        if (rx(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.h(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void setAnimationUrl(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!aq.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.cKE = cacheStrategy;
            this.cKC = new b(getAnimationPath(), str, this.cKH);
            this.cKC.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!aq.isEmpty(str)) {
            rA(str);
            a(str, cacheStrategy);
        }
    }

    private void rA(String str) {
        if (!aq.isEmpty(str)) {
            a aVar = new a();
            aVar.setPath(str);
            aVar.setFirstLoadInternal(getFristLoadInternal());
            setImageAssetDelegate(aVar);
        }
    }

    private void a(final String str, final LottieAnimationView.CacheStrategy cacheStrategy) {
        e eVar;
        if (!aq.isEmpty(str)) {
            if (cKB.containsKey(str)) {
                e eVar2 = cKB.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (cKA.containsKey(str) && (eVar = cKA.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.cKF;
            cancelAnimation();
            ayx();
            InputStream ci = ci(str, "data.json");
            if (ci != null) {
                this.cKD = e.a.a(getContext(), ci, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.cKB.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.cKA.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.br();
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
        if (this.cKF) {
            br();
        }
    }

    private void ayx() {
        if (this.cKD != null) {
            this.cKD.cancel();
            this.cKD = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void br() {
        super.br();
        this.cKF = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bt() {
        super.bt();
        this.cKF = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.cKF = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bs() {
        super.bs();
        this.cKF = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.cKy = z;
    }

    public boolean getFristLoadInternal() {
        return this.cKy;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.cKG) {
            super.onRestoreInstanceState(parcelable);
        }
        this.cKG = false;
    }

    public void ayy() {
        this.cKG = true;
    }
}
