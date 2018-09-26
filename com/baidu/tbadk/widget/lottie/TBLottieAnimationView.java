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
    private boolean bgT;
    private b bgX;
    private com.airbnb.lottie.a bgY;
    private LottieAnimationView.CacheStrategy bgZ;
    private boolean bha;
    private b.a bhb;
    private String mUrl;
    private LottieAnimationView.CacheStrategy mq;
    private static final Map<String, e> bgV = new HashMap();
    private static final Map<String, WeakReference<e>> bgW = new HashMap();
    public static final String bgR = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.mq = LottieAnimationView.CacheStrategy.Weak;
        this.bgZ = this.mq;
        this.bha = false;
        this.bgT = false;
        this.bhb = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bgZ);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mq = LottieAnimationView.CacheStrategy.Weak;
        this.bgZ = this.mq;
        this.bha = false;
        this.bgT = false;
        this.bhb = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bgZ);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mq = LottieAnimationView.CacheStrategy.Weak;
        this.bgZ = this.mq;
        this.bha = false;
        this.bgT = false;
        this.bhb = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void d(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bgZ);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.mq);
    }

    public static String getAnimationPath() {
        return bgR + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean io(String str) {
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

    public static InputStream aD(String str, String str2) {
        String animationPath = getAnimationPath();
        if (io(animationPath)) {
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
            this.bgZ = cacheStrategy;
            this.bgX = new b(getAnimationPath(), str, this.bhb);
            this.bgX.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ao.isEmpty(str)) {
            ir(str);
            a(str, cacheStrategy);
        }
    }

    private void ir(String str) {
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
            if (bgW.containsKey(str)) {
                e eVar2 = bgW.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (bgV.containsKey(str) && (eVar = bgV.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.bha;
            cf();
            OB();
            InputStream aD = aD(str, "data.json");
            if (aD != null) {
                this.bgY = e.a.a(getContext(), aD, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.bgW.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.bgV.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.ce();
                            }
                        }
                    }
                });
            }
        }
    }

    private void OB() {
        if (this.bgY != null) {
            this.bgY.cancel();
            this.bgY = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void ce() {
        super.ce();
        this.bha = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cg() {
        super.cg();
        this.bha = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cf() {
        super.cf();
        this.bha = false;
    }

    public void setFirstLoadInternal(boolean z) {
        this.bgT = z;
    }

    public boolean getFristLoadInternal() {
        return this.bgT;
    }
}
