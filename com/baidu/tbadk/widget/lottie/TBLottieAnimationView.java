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
    private static final Map<String, e> bdn = new HashMap();
    private static final Map<String, WeakReference<e>> bdo = new HashMap();
    private b bdp;
    private com.airbnb.lottie.a bdq;
    private LottieAnimationView.CacheStrategy bdr;
    private boolean bds;
    private b.a bdt;
    private LottieAnimationView.CacheStrategy jZ;
    private String mUrl;

    public TBLottieAnimationView(Context context) {
        super(context);
        this.jZ = LottieAnimationView.CacheStrategy.Weak;
        this.bdr = this.jZ;
        this.bds = false;
        this.bdt = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdr);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZ = LottieAnimationView.CacheStrategy.Weak;
        this.bdr = this.jZ;
        this.bds = false;
        this.bdt = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdr);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZ = LottieAnimationView.CacheStrategy.Weak;
        this.bdr = this.jZ;
        this.bds = false;
        this.bdt = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ap.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bdr);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.jZ);
    }

    public void setAnimationUrl(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (Nj() && !ap.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.bdr = cacheStrategy;
            this.bdp = new b(l.yv(), str, this.bdt);
            this.bdp.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ap.isEmpty(str)) {
            hV(str);
            a(str, cacheStrategy);
        }
    }

    private void hV(String str) {
        if (!ap.isEmpty(str)) {
            a aVar = new a();
            aVar.setPath(str);
            setImageAssetDelegate(aVar);
        }
    }

    private void a(final String str, final LottieAnimationView.CacheStrategy cacheStrategy) {
        e eVar;
        if (!ap.isEmpty(str)) {
            if (bdo.containsKey(str)) {
                e eVar2 = bdo.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (bdn.containsKey(str) && (eVar = bdn.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.bds;
            bb();
            Ni();
            InputStream ag = l.ag(str, "data.json");
            if (ag != null) {
                this.bdq = e.a.a(getContext(), ag, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.bdo.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.bdn.put(str, eVar3);
                            }
                            TBLottieAnimationView.this.setComposition(eVar3);
                            if (z) {
                                TBLottieAnimationView.this.ba();
                            }
                        }
                    }
                });
            }
        }
    }

    private void Ni() {
        if (this.bdq != null) {
            this.bdq.cancel();
            this.bdq = null;
        }
    }

    private boolean Nj() {
        return com.baidu.d.a.a.N(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void ba() {
        super.ba();
        this.bds = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bb() {
        super.bb();
        this.bds = false;
    }
}
