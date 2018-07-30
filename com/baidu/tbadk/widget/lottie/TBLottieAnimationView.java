package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.e;
import com.airbnb.lottie.h;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.lottie.b;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    private static final Map<String, e> bdx = new HashMap();
    private static final Map<String, WeakReference<e>> bdy = new HashMap();
    private com.airbnb.lottie.a bdA;
    private LottieAnimationView.CacheStrategy bdB;
    private boolean bdC;
    private b.a bdD;
    private b bdz;
    private LottieAnimationView.CacheStrategy jR;
    private String mUrl;

    public TBLottieAnimationView(Context context) {
        super(context);
        this.jR = LottieAnimationView.CacheStrategy.Weak;
        this.bdB = this.jR;
        this.bdC = false;
        this.bdD = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdB);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jR = LottieAnimationView.CacheStrategy.Weak;
        this.bdB = this.jR;
        this.bdC = false;
        this.bdD = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdB);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jR = LottieAnimationView.CacheStrategy.Weak;
        this.bdB = this.jR;
        this.bdC = false;
        this.bdD = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdB);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.jR);
    }

    public void setAnimationUrl(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (Nf() && !ap.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.bdB = cacheStrategy;
            this.bdz = new b(l.ym(), str, this.bdD);
            this.bdz.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ap.isEmpty(str)) {
            hS(str);
            a(str, cacheStrategy);
        }
    }

    private void hS(String str) {
        if (!ap.isEmpty(str)) {
            a aVar = new a();
            aVar.setPath(str);
            setImageAssetDelegate(aVar);
        }
    }

    private void a(final String str, final LottieAnimationView.CacheStrategy cacheStrategy) {
        e eVar;
        if (!ap.isEmpty(str)) {
            if (bdy.containsKey(str)) {
                e eVar2 = bdy.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (bdx.containsKey(str) && (eVar = bdx.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.bdC;
            aY();
            Ne();
            InputStream ae = l.ae(str, "data.json");
            if (ae != null) {
                this.bdA = e.a.a(getContext(), ae, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.bdy.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.bdx.put(str, eVar3);
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

    private void Ne() {
        if (this.bdA != null) {
            this.bdA.cancel();
            this.bdA = null;
        }
    }

    private boolean Nf() {
        return com.baidu.e.a.a.P(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void aX() {
        super.aX();
        this.bdC = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void aZ() {
        super.aZ();
        this.bdC = false;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void aY() {
        super.aY();
        this.bdC = false;
    }
}
