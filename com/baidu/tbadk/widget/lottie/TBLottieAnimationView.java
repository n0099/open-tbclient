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
    private boolean cKF;
    private b cKJ;
    private com.airbnb.lottie.a cKK;
    private LottieAnimationView.CacheStrategy cKL;
    private boolean cKM;
    private boolean cKN;
    private b.a cKO;
    private LottieAnimationView.CacheStrategy kC;
    private String mUrl;
    private static final Map<String, e> cKH = new HashMap();
    private static final Map<String, WeakReference<e>> cKI = new HashMap();
    public static final String cKD = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cKL = this.kC;
        this.cKM = false;
        this.cKF = false;
        this.cKN = false;
        this.cKO = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cKL);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cKL = this.kC;
        this.cKM = false;
        this.cKF = false;
        this.cKN = false;
        this.cKO = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cKL);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cKL = this.kC;
        this.cKM = false;
        this.cKF = false;
        this.cKN = false;
        this.cKO = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cKL);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.kC);
    }

    public static String getAnimationPath() {
        return cKD + "/" + TbConfig.getTempDirName() + "/animation/";
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
            this.cKL = cacheStrategy;
            this.cKJ = new b(getAnimationPath(), str, this.cKO);
            this.cKJ.execute(new Void[0]);
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
            if (cKI.containsKey(str)) {
                e eVar2 = cKI.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (cKH.containsKey(str) && (eVar = cKH.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.cKM;
            cancelAnimation();
            ayz();
            InputStream ci = ci(str, "data.json");
            if (ci != null) {
                this.cKK = e.a.a(getContext(), ci, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.cKI.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.cKH.put(str, eVar3);
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
        if (this.cKM) {
            br();
        }
    }

    private void ayz() {
        if (this.cKK != null) {
            this.cKK.cancel();
            this.cKK = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void br() {
        super.br();
        this.cKM = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bt() {
        super.bt();
        this.cKM = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.cKM = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bs() {
        super.bs();
        this.cKM = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.cKF = z;
    }

    public boolean getFristLoadInternal() {
        return this.cKF;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.cKN) {
            super.onRestoreInstanceState(parcelable);
        }
        this.cKN = false;
    }

    public void ayA() {
        this.cKN = true;
    }
}
