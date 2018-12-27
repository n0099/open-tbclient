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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.lottie.b;
import java.io.File;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    private LottieAnimationView.CacheStrategy bpA;
    private boolean bpB;
    private b.a bpC;
    private boolean bpu;
    private b bpy;
    private com.airbnb.lottie.a bpz;
    private String mUrl;
    private LottieAnimationView.CacheStrategy ni;
    private static final Map<String, e> bpw = new HashMap();
    private static final Map<String, WeakReference<e>> bpx = new HashMap();
    public static final String bps = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.ni = LottieAnimationView.CacheStrategy.Weak;
        this.bpA = this.ni;
        this.bpB = false;
        this.bpu = false;
        this.bpC = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bpA);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ni = LottieAnimationView.CacheStrategy.Weak;
        this.bpA = this.ni;
        this.bpB = false;
        this.bpu = false;
        this.bpC = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bpA);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ni = LottieAnimationView.CacheStrategy.Weak;
        this.bpA = this.ni;
        this.bpB = false;
        this.bpu = false;
        this.bpC = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bpA);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.ni);
    }

    public static String getAnimationPath() {
        return bps + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean iW(String str) {
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

    public static InputStream aR(String str, String str2) {
        String animationPath = getAnimationPath();
        if (iW(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.m(file);
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public void setAnimationUrl(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ao.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.bpA = cacheStrategy;
            this.bpy = new b(getAnimationPath(), str, this.bpC);
            this.bpy.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ao.isEmpty(str)) {
            iZ(str);
            a(str, cacheStrategy);
        }
    }

    private void iZ(String str) {
        if (!ao.isEmpty(str)) {
            a aVar = new a();
            aVar.setPath(str);
            aVar.setFirstLoadInternal(getFristLoadInternal());
            setImageAssetDelegate(aVar);
        }
    }

    private void a(final String str, final LottieAnimationView.CacheStrategy cacheStrategy) {
        e eVar;
        if (!ao.isEmpty(str)) {
            if (bpx.containsKey(str)) {
                e eVar2 = bpx.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (bpw.containsKey(str) && (eVar = bpw.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.bpB;
            cancelAnimation();
            RO();
            InputStream aR = aR(str, "data.json");
            if (aR != null) {
                this.bpz = e.a.a(getContext(), aR, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.bpx.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.bpw.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.cv();
                            }
                        }
                    }
                });
            }
        }
    }

    private void RO() {
        if (this.bpz != null) {
            this.bpz.cancel();
            this.bpz = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cv() {
        super.cv();
        this.bpB = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cx() {
        super.cx();
        this.bpB = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.bpB = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cw() {
        super.cw();
        this.bpB = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.bpu = z;
    }

    public boolean getFristLoadInternal() {
        return this.bpu;
    }
}
