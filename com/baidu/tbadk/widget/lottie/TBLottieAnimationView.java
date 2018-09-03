package com.baidu.tbadk.widget.lottie;

import android.content.Context;
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
    private static final Map<String, e> bdA = new HashMap();
    private static final Map<String, WeakReference<e>> bdB = new HashMap();
    public static final String bdw = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();
    private b bdC;
    private com.airbnb.lottie.a bdD;
    private LottieAnimationView.CacheStrategy bdE;
    private boolean bdF;
    private b.a bdG;
    private boolean bdy;
    private LottieAnimationView.CacheStrategy jS;
    private String mUrl;

    public TBLottieAnimationView(Context context) {
        super(context);
        this.jS = LottieAnimationView.CacheStrategy.Weak;
        this.bdE = this.jS;
        this.bdF = false;
        this.bdy = false;
        this.bdG = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdE);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jS = LottieAnimationView.CacheStrategy.Weak;
        this.bdE = this.jS;
        this.bdF = false;
        this.bdy = false;
        this.bdG = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdE);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jS = LottieAnimationView.CacheStrategy.Weak;
        this.bdE = this.jS;
        this.bdF = false;
        this.bdy = false;
        this.bdG = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdE);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.jS);
    }

    public static String getAnimationPath() {
        return bdw + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean hQ(String str) {
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

    public static InputStream av(String str, String str2) {
        String animationPath = getAnimationPath();
        if (hQ(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.g(file);
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
            this.bdE = cacheStrategy;
            this.bdC = new b(getAnimationPath(), str, this.bdG);
            this.bdC.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ap.isEmpty(str)) {
            hT(str);
            a(str, cacheStrategy);
        }
    }

    private void hT(String str) {
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
            if (bdB.containsKey(str)) {
                e eVar2 = bdB.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (bdA.containsKey(str) && (eVar = bdA.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.bdF;
            aY();
            Ni();
            InputStream av = av(str, "data.json");
            if (av != null) {
                this.bdD = e.a.a(getContext(), av, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.bdB.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.bdA.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.aX();
                            }
                        }
                    }
                });
            }
        }
    }

    private void Ni() {
        if (this.bdD != null) {
            this.bdD.cancel();
            this.bdD = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void aX() {
        super.aX();
        this.bdF = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void aZ() {
        super.aZ();
        this.bdF = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void aY() {
        super.aY();
        this.bdF = false;
    }

    public void setFirstLoadInternal(boolean z) {
        this.bdy = z;
    }

    public boolean getFristLoadInternal() {
        return this.bdy;
    }
}
