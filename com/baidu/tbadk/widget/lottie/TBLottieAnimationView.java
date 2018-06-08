package com.baidu.tbadk.widget.lottie;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.e;
import com.airbnb.lottie.h;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.widget.lottie.b;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class TBLottieAnimationView extends LottieAnimationView {
    private static final Map<String, e> bbZ = new HashMap();
    private static final Map<String, WeakReference<e>> bca = new HashMap();
    private b bcb;
    private com.airbnb.lottie.a bcc;
    private LottieAnimationView.CacheStrategy bcd;
    private boolean bce;
    private b.a bcf;
    private LottieAnimationView.CacheStrategy jZ;
    private String mUrl;

    public TBLottieAnimationView(Context context) {
        super(context);
        this.jZ = LottieAnimationView.CacheStrategy.Weak;
        this.bcd = this.jZ;
        this.bce = false;
        this.bcf = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bcd);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jZ = LottieAnimationView.CacheStrategy.Weak;
        this.bcd = this.jZ;
        this.bce = false;
        this.bcf = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bcd);
                }
            }
        };
    }

    public TBLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jZ = LottieAnimationView.CacheStrategy.Weak;
        this.bcd = this.jZ;
        this.bce = false;
        this.bcf = new b.a() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.1
            @Override // com.baidu.tbadk.widget.lottie.b.a
            public void e(boolean z, String str) {
                if (z && !ao.isEmpty(str)) {
                    TBLottieAnimationView.this.setAnimationDir(str, TBLottieAnimationView.this.bcd);
                }
            }
        };
    }

    public void setAnimationUrl(String str) {
        setAnimationUrl(str, this.jZ);
    }

    public void setAnimationUrl(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (MQ() && !ao.isEmpty(str) && !str.equals(this.mUrl)) {
            this.mUrl = str;
            this.bcd = cacheStrategy;
            this.bcb = new b(l.yh(), str, this.bcf);
            this.bcb.execute(new Void[0]);
        }
    }

    public void setAnimationDir(String str, LottieAnimationView.CacheStrategy cacheStrategy) {
        if (!ao.isEmpty(str)) {
            hR(str);
            a(str, cacheStrategy);
        }
    }

    private void hR(String str) {
        if (!ao.isEmpty(str)) {
            a aVar = new a();
            aVar.setPath(str);
            setImageAssetDelegate(aVar);
        }
    }

    private void a(final String str, final LottieAnimationView.CacheStrategy cacheStrategy) {
        e eVar;
        if (!ao.isEmpty(str)) {
            if (bca.containsKey(str)) {
                e eVar2 = bca.get(str).get();
                if (eVar2 != null) {
                    setComposition(eVar2);
                    return;
                }
            } else if (bbZ.containsKey(str) && (eVar = bbZ.get(str)) != null) {
                setComposition(eVar);
                return;
            }
            final boolean z = this.bce;
            bb();
            MP();
            InputStream ag = l.ag(str, "data.json");
            if (ag != null) {
                this.bcc = e.a.a(getContext(), ag, new h() { // from class: com.baidu.tbadk.widget.lottie.TBLottieAnimationView.2
                    @Override // com.airbnb.lottie.h
                    public void a(@Nullable e eVar3) {
                        if (eVar3 != null) {
                            if (cacheStrategy == LottieAnimationView.CacheStrategy.Weak) {
                                TBLottieAnimationView.bca.put(str, new WeakReference(eVar3));
                            } else if (cacheStrategy == LottieAnimationView.CacheStrategy.Strong) {
                                TBLottieAnimationView.bbZ.put(str, eVar3);
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

    private void MP() {
        if (this.bcc != null) {
            this.bcc.cancel();
            this.bcc = null;
        }
    }

    private boolean MQ() {
        return com.baidu.d.a.a.N(getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void ba() {
        super.ba();
        this.bce = true;
    }

    @Override // com.airbnb.lottie.LottieAnimationView
    public void bb() {
        super.bb();
        this.bce = false;
    }
}
