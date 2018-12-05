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
    private boolean bpr;
    private b bpv;
    private com.airbnb.lottie.a bpw;
    private LottieAnimationView.CacheStrategy bpx;
    private boolean bpy;
    private b.a bpz;
    private String mUrl;
    private LottieAnimationView.CacheStrategy ni;
    private static final Map<String, e> bpt = new HashMap();
    private static final Map<String, WeakReference<e>> bpu = new HashMap();
    public static final String bpp = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.ni = LottieAnimationView.CacheStrategy.Weak;
        this.bpx = this.ni;
        this.bpy = false;
        this.bpr = false;
        this.bpz = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bpx);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ni = LottieAnimationView.CacheStrategy.Weak;
        this.bpx = this.ni;
        this.bpy = false;
        this.bpr = false;
        this.bpz = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bpx);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ni = LottieAnimationView.CacheStrategy.Weak;
        this.bpx = this.ni;
        this.bpy = false;
        this.bpr = false;
        this.bpz = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bpx);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.ni);
    }

    public static String getAnimationPath() {
        return bpp + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean iV(String str) {
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
        if (iV(animationPath)) {
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
            this.bpx = cacheStrategy;
            this.bpv = new b(getAnimationPath(), str, this.bpz);
            this.bpv.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ao.isEmpty(str)) {
            iY(str);
            a(str, cacheStrategy);
        }
    }

    private void iY(String str) {
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
            if (bpu.containsKey(str)) {
                e eVar2 = bpu.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (bpt.containsKey(str) && (eVar = bpt.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.bpy;
            cancelAnimation();
            RM();
            InputStream aR = aR(str, "data.json");
            if (aR != null) {
                this.bpw = e.a.a(getContext(), aR, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.bpu.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.bpt.put(str, eVar3);
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

    private void RM() {
        if (this.bpw != null) {
            this.bpw.cancel();
            this.bpw = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cv() {
        super.cv();
        this.bpy = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cx() {
        super.cx();
        this.bpy = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.bpy = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cw() {
        super.cw();
        this.bpy = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.bpr = z;
    }

    public boolean getFristLoadInternal() {
        return this.bpr;
    }
}
