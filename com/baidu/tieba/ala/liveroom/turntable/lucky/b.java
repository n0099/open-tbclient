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
    private a.InterfaceC0372a epf;
    private ViewGroup epg;
    private int eph;
    private int epi;
    private FrameLayout epj;
    private TurnTableLuckyBubbleView epk;
    private Handler epl;
    private com.baidu.tieba.ala.liveroom.turntable.a epm;
    private long epn;
    private CountDownTimer epo;
    private boolean epp;
    private Context mContext;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.epg = viewGroup;
        this.eph = i;
        this.epi = i2;
    }

    public void a(String str, a.InterfaceC0372a interfaceC0372a) {
        rs();
        this.epp = true;
        this.mLiveId = str;
        this.epf = interfaceC0372a;
        aWj();
    }

    public void bd(int i, int i2) {
        if (i != this.eph || i2 != this.epi) {
            this.eph = i;
            this.epi = i2;
            if (this.epj != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.epj.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.eph * 2;
                    layoutParams.bottomMargin = this.epi;
                }
                this.epj.setLayoutParams(layoutParams);
            }
        }
    }

    public void ii(boolean z) {
        this.epp = z;
        if (this.epj != null && this.epj.getParent() != null) {
            this.epj.setVisibility(z ? 0 : 8);
        }
    }

    public void rs() {
        this.mLiveId = "";
        aNN();
        this.epf = null;
        if (this.epl != null) {
            this.epl.removeCallbacksAndMessages(null);
        }
        if (this.epj != null) {
            this.epj.removeAllViews();
            if (this.epg != null) {
                this.epg.removeView(this.epj);
            }
            this.epj = null;
            this.epk = null;
        }
    }

    public void release() {
        rs();
        if (this.epm != null) {
            this.epm.release();
            this.epm = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWj() {
        if (this.epm == null) {
            this.epm = new com.baidu.tieba.ala.liveroom.turntable.c();
            this.epm.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0371a
                public void a(String str, c cVar) {
                    super.a(str, cVar);
                    b.this.b(str, cVar);
                }
            });
        }
        this.epm.ud(this.mLiveId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, c cVar) {
        if (!TextUtils.isEmpty(this.mLiveId) && !TextUtils.isEmpty(str) && this.mLiveId.equals(str) && cVar != null) {
            if (cVar.epx == 1 && cVar.epy - cVar.Pp > 0) {
                a(cVar);
            } else {
                aNN();
                aJf();
            }
            if (this.epl == null) {
                this.epl = new Handler();
            }
            this.epl.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.aWj();
                }
            }, 5000L);
        }
    }

    private void a(c cVar) {
        if (this.epn != cVar.epy) {
            aNN();
            this.epn = cVar.epy;
            long j = cVar.epy - cVar.Pp;
            a(cVar.epz, j);
            final long j2 = 100 + (j * 1000);
            this.epo = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.t(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.aWk();
                }
            };
            this.epo.start();
        }
    }

    private void aNN() {
        this.epn = 0L;
        if (this.epo != null) {
            this.epo.cancel();
            this.epo = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.epg != null && !TextUtils.isEmpty(str)) {
            if (this.epk == null) {
                this.epk = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.epj == null) {
                this.epj = new FrameLayout(this.mContext);
                this.epj.setBackgroundColor(0);
            }
            if (this.epj.indexOfChild(this.epk) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.epj.addView(this.epk, layoutParams);
            }
            if (this.epg.indexOfChild(this.epj) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.eph * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.epi;
                this.epg.addView(this.epj, layoutParams2);
            }
            this.epj.setVisibility(this.epp ? 0 : 8);
            this.epk.setContent(!TextUtils.isEmpty(aVar.epA) ? str + Config.EVENT_HEAT_X + aVar.epA : str);
        }
        if (this.epf != null) {
            this.epf.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(long j, long j2) {
        if (this.epf != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.epf.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                aWk();
            }
        }
    }

    private void aJf() {
        if (this.epj != null) {
            this.epj.removeAllViews();
            if (this.epg != null) {
                this.epg.removeView(this.epj);
            }
            this.epj = null;
            this.epk = null;
        }
        if (this.epf != null) {
            this.epf.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWk() {
        aNN();
        aJf();
        if (this.epl != null) {
            this.epl.removeCallbacksAndMessages(null);
        }
        aWj();
    }
}
