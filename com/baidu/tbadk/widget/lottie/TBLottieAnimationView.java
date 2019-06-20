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
    private boolean cJe;
    private b cJi;
    private com.airbnb.lottie.a cJj;
    private LottieAnimationView.CacheStrategy cJk;
    private boolean cJl;
    private boolean cJm;
    private b.a cJn;
    private LottieAnimationView.CacheStrategy kD;
    private String mUrl;
    private static final Map<String, e> cJg = new HashMap();
    private static final Map<String, WeakReference<e>> cJh = new HashMap();
    public static final String cJc = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath();

    public TBLottieAnimationView(Context context) {
        super(context);
        this.kD = LottieAnimationView.CacheStrategy.Weak;
        this.cJk = this.kD;
        this.cJl = false;
        this.cJe = false;
        this.cJm = false;
        this.cJn = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cJk);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kD = LottieAnimationView.CacheStrategy.Weak;
        this.cJk = this.kD;
        this.cJl = false;
        this.cJe = false;
        this.cJm = false;
        this.cJn = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cJk);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kD = LottieAnimationView.CacheStrategy.Weak;
        this.cJk = this.kD;
        this.cJl = false;
        this.cJe = false;
        this.cJm = false;
        this.cJn = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void h(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.cJk);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.kD);
    }

    public static String getAnimationPath() {
        return cJc + "/" + TbConfig.getTempDirName() + "/animation/";
    }

    public static boolean rf(String str) {
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

    public static InputStream ch(String str, String str2) {
        String animationPath = getAnimationPath();
        if (rf(animationPath)) {
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
        if (!ap.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.cJk = cacheStrategy;
            this.cJi = new b(getAnimationPath(), str, this.cJn);
            this.cJi.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ap.isEmpty(str)) {
            ri(str);
            a(str, cacheStrategy);
        }
    }

    private void ri(String str) {
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
            if (cJh.containsKey(str)) {
                e eVar2 = cJh.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (cJg.containsKey(str) && (eVar = cJg.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.cJl;
            cancelAnimation();
            axl();
            InputStream ch = ch(str, "data.json");
            if (ch != null) {
                this.cJj = e.a.a(getContext(), ch, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.cJh.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.cJg.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.bo();
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
        if (this.cJl) {
            bo();
        }
    }

    private void axl() {
        if (this.cJj != null) {
            this.cJj.cancel();
            this.cJj = null;
        }
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bo() {
        super.bo();
        this.cJl = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bq() {
        super.bq();
        this.cJl = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void cancelAnimation() {
        super.cancelAnimation();
        this.cJl = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bp() {
        super.bp();
        this.cJl = true;
    }

    public void setFirstLoadInternal(boolean z) {
        this.cJe = z;
    }

    public boolean getFristLoadInternal() {
        return this.cJe;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.airbnb.lottie.LottieAnimationView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.cJm) {
            super.onRestoreInstanceState(parcelable);
        }
        this.cJm = false;
    }

    public void axm() {
        this.cJm = true;
    }
}
