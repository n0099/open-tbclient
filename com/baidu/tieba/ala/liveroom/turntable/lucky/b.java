package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.mobstat.Config;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
/* loaded from: classes6.dex */
public class b implements a {
    private a.InterfaceC0367a eoo;
    private ViewGroup eop;
    private int eoq;
    private int eor;
    private FrameLayout eos;
    private TurnTableLuckyBubbleView eot;
    private Handler eou;
    private com.baidu.tieba.ala.liveroom.turntable.a eov;
    private long eow;
    private CountDownTimer eox;
    private boolean eoy;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.eop = viewGroup;
        this.eoq = i;
        this.eor = i2;
    }

    public void a(String str, a.InterfaceC0367a interfaceC0367a) {
        rt();
        this.eoy = true;
        this.mLiveId = str;
        this.eoo = interfaceC0367a;
        aWh();
    }

    public void bb(int i, int i2) {
        if (i != this.eoq || i2 != this.eor) {
            this.eoq = i;
            this.eor = i2;
            if (this.eos != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eos.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eoq * 2;
                    layoutParams.bottomMargin = this.eor;
                }
                this.eos.setLayoutParams(layoutParams);
            }
        }
    }

    public void ii(boolean z) {
        this.eoy = z;
        if (this.eos != null && this.eos.getParent() != null) {
            this.eos.setVisibility(z ? 0 : 8);
        }
    }

    public void rt() {
        this.mLiveId = "";
        aNL();
        this.eoo = null;
        if (this.eou != null) {
            this.eou.removeCallbacksAndMessages(null);
        }
        if (this.eos != null) {
            this.eos.removeAllViews();
            if (this.eop != null) {
                this.eop.removeView(this.eos);
            }
            this.eos = null;
            this.eot = null;
        }
    }

    public void release() {
        rt();
        if (this.eov != null) {
            this.eov.release();
            this.eov = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWh() {
        if (this.eov == null) {
            this.eov = new com.baidu.tieba.ala.liveroom.turntable.c();
            this.eov.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0366a
                public void a(String str, c cVar) {
                    super.a(str, cVar);
                    b.this.b(str, cVar);
                }
            });
        }
        this.eov.ud(this.mLiveId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, c cVar) {
        if (!TextUtils.isEmpty(this.mLiveId) && !TextUtils.isEmpty(str) && this.mLiveId.equals(str) && cVar != null) {
            if (cVar.eoG == 1 && cVar.eoH - cVar.OO > 0) {
                a(cVar);
            } else {
                aNL();
                aJd();
            }
            if (this.eou == null) {
                this.eou = new Handler();
            }
            this.eou.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aWh();
                }
            }, 5000L);
        }
    }

    private void a(c cVar) {
        if (this.eow != cVar.eoH) {
            aNL();
            this.eow = cVar.eoH;
            long j = cVar.eoH - cVar.OO;
            a(cVar.eoI, j);
            final long j2 = 100 + (j * 1000);
            this.eox = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.t(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.aWi();
                }
            };
            this.eox.start();
        }
    }

    private void aNL() {
        this.eow = 0L;
        if (this.eox != null) {
            this.eox.cancel();
            this.eox = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.eop != null && !TextUtils.isEmpty(str)) {
            if (this.eot == null) {
                this.eot = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.eos == null) {
                this.eos = new FrameLayout(this.mContext);
                this.eos.setBackgroundColor(0);
            }
            if (this.eos.indexOfChild(this.eot) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.eos.addView(this.eot, layoutParams);
            }
            if (this.eop.indexOfChild(this.eos) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eoq * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.eor;
                this.eop.addView(this.eos, layoutParams2);
            }
            this.eos.setVisibility(this.eoy ? 0 : 8);
            this.eot.setContent(!TextUtils.isEmpty(aVar.eoJ) ? str + Config.EVENT_HEAT_X + aVar.eoJ : str);
        }
        if (this.eoo != null) {
            this.eoo.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j, long j2) {
        if (this.eoo != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.eoo.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                aWi();
            }
        }
    }

    private void aJd() {
        if (this.eos != null) {
            this.eos.removeAllViews();
            if (this.eop != null) {
                this.eop.removeView(this.eos);
            }
            this.eos = null;
            this.eot = null;
        }
        if (this.eoo != null) {
            this.eoo.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWi() {
        aNL();
        aJd();
        if (this.eou != null) {
            this.eou.removeCallbacksAndMessages(null);
        }
        aWh();
    }
}
