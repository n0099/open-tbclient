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
import com.baidu.android.imsdk.internal.DefaultConfig;
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
    private LottieAnimationView.CacheStrategy cH;
    private b cUe;
    private com.airbnb.lottie.a cUf;
    private LottieAnimationView.CacheStrategy cUg;
    private boolean cUh;
    private b.a cUi;
    private boolean isFirstLoadInternal;
    private boolean isSettingForPlay;
    private String mUrl;
    private static final Map<String, e> REMOTE_STRONG_REF_CACHE = new HashMap();
    private static final Map<String, WeakReference<e>> REMOTE_WEAK_REF_CACHE = new HashMap();
    public static final String INTERNEL_STORAGE_DIRECTORY = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.cH = LottieAnimationView.CacheStrategy.Weak;
        this.cUg = this.cH;
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.cUh = false;
        this.cUi = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void onLoaded(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cUg);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cH = LottieAnimationView.CacheStrategy.Weak;
        this.cUg = this.cH;
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.cUh = false;
        this.cUi = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void onLoaded(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cUg);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cH = LottieAnimationView.CacheStrategy.Weak;
        this.cUg = this.cH;
        this.isSettingForPlay = false;
        this.isFirstLoadInternal = false;
        this.cUh = false;
        this.cUi = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void onLoaded(boolean z, String str) {
                if (z && !aq.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cUg);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.cH);
    }

    public static String getAnimationPath() {
        return INTERNEL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean checkInternalTempDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e) {
            TiebaStatic.file(e, k.join("FileHelper", DefaultConfig.TOKEN_SEPARATOR, "CheckTempDir", HanziToPinyin.Token.SEPARATOR, str));
            return false;
        }
    }

    public static InputStream getAnimationInputStream(String str, String str2) {
        String animationPath = getAnimationPath();
        if (checkInternalTempDir(animationPath)) {
            String str3 = animationPath + str + "/";
            if (new File(str3).exists()) {
                File file = new File(str3 + str2);
                if (file.exists()) {
                    return f.getInStreamFromFile(file);
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
            this.cUg = cacheStrategy;
            this.cUe = new b(getAnimationPath(), str, this.cUi);
            this.cUe.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!aq.isEmpty(str)) {
            dealImageAsset(str);
            a(str, cacheStrategy);
        }
    }

    private void dealImageAsset(String str) {
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
            if (REMOTE_WEAK_REF_CACHE.containsKey(str)) {
                e eVar2 = REMOTE_WEAK_REF_CACHE.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (REMOTE_STRONG_REF_CACHE.containsKey(str) && (eVar = REMOTE_STRONG_REF_CACHE.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.isSettingForPlay;
            cancelAnimation();
            cancelCompositionLoader();
            InputStream animationInputStream = getAnimationInputStream(str, com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView.JSON_FILE);
            if (animationInputStream != null) {
                this.cUf = e.a.a(getContext(), animationInputStream, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.REMOTE_WEAK_REF_CACHE.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.REMOTE_STRONG_REF_CACHE.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.playAnimation();
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
        if (this.isSettingForPlay) {
            playAnimation();
        }
    }

    private void cancelCompositionLoader() {
        if (this.cUf != null) {
            this.cUf.cancel();
            this.cUf = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void playAnimation() {
        super.playAnimation();
        this.isSettingForPlay = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void pauseAnimation() {
        super.pauseAnimation();
        this.isSettingForPlay = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.isSettingForPlay = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void resumeAnimation() {
        super.resumeAnimation();
        this.isSettingForPlay = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.isFirstLoadInternal = z;
    }

    public boolean getFristLoadInternal() {
        return this.isFirstLoadInternal;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.cUh) {
            super.onRestoreInstanceState(parcelable);
        }
        this.cUh = false;
    }

    public void ayV() {
        this.cUh = true;
    }
}
