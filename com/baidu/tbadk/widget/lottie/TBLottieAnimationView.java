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
    private com.airbnb.lottie.a cLA;
    private LottieAnimationView.CacheStrategy cLB;
    private boolean cLC;
    private boolean cLD;
    private b.a cLE;
    private boolean cLv;
    private b cLz;
    private LottieAnimationView.CacheStrategy kC;
    private String mUrl;
    private static final Map<String, e> cLx = new HashMap();
    private static final Map<String, WeakReference<e>> cLy = new HashMap();
    public static final String cLt = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cLB = this.kC;
        this.cLC = false;
        this.cLv = false;
        this.cLD = false;
        this.cLE = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cLB);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cLB = this.kC;
        this.cLC = false;
        this.cLv = false;
        this.cLD = false;
        this.cLE = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cLB);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kC = LottieAnimationView.CacheStrategy.Weak;
        this.cLB = this.kC;
        this.cLC = false;
        this.cLv = false;
        this.cLD = false;
        this.cLE = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cLB);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.kC);
    }

    public static String getAnimationPath() {
        return cLt + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean rI(String str) {
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
        if (rI(animationPath)) {
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
            this.cLB = cacheStrategy;
            this.cLz = new b(getAnimationPath(), str, this.cLE);
            this.cLz.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!aq.isEmpty(str)) {
            rL(str);
            a(str, cacheStrategy);
        }
    }

    private void rL(String str) {
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
            if (cLy.containsKey(str)) {
                e eVar2 = cLy.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (cLx.containsKey(str) && (eVar = cLx.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.cLC;
            cancelAnimation();
            ayL();
            InputStream ci = ci(str, "data.json");
            if (ci != null) {
                this.cLA = e.a.a(getContext(), ci, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.cLy.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.cLx.put(str, eVar3);
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
        if (this.cLC) {
            br();
        }
    }

    private void ayL() {
        if (this.cLA != null) {
            this.cLA.cancel();
            this.cLA = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void br() {
        super.br();
        this.cLC = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bt() {
        super.bt();
        this.cLC = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.cLC = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bs() {
        super.bs();
        this.cLC = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.cLv = z;
    }

    public boolean getFristLoadInternal() {
        return this.cLv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.cLD) {
            super.onRestoreInstanceState(parcelable);
        }
        this.cLD = false;
    }

    public void ayM() {
        this.cLD = true;
    }
}
