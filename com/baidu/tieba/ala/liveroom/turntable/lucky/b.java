package com.baidu.tieba.ala.liveroom.turntable.lucky;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.baidu.live.data.bv;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.utils.q;
import com.baidu.tieba.ala.liveroom.turntable.lucky.a;
import com.baidu.tieba.ala.liveroom.turntable.lucky.c;
import com.baidu.webkit.internal.ETAG;
/* loaded from: classes10.dex */
public class b implements a {
    private int fpf;
    private CountDownTimer gPV;
    private a.InterfaceC0681a hQJ;
    private ViewGroup hQK;
    private int hQL;
    private FrameLayout hQM;
    private TurnTableLuckyBubbleView hQN;
    private Handler hQO;
    private com.baidu.tieba.ala.liveroom.turntable.a hQP;
    private boolean hQQ;
    private Context mContext;
    private long mExpiredTime;
    private String mLiveId;

    public b(Context context) {
        this.mContext = context;
    }

    public void d(ViewGroup viewGroup, int i, int i2) {
        this.hQK = viewGroup;
        this.fpf = i;
        this.hQL = i2;
    }

    public void a(String str, a.InterfaceC0681a interfaceC0681a) {
        FB();
        this.hQQ = true;
        this.mLiveId = str;
        this.hQJ = interfaceC0681a;
        ckU();
    }

    public void bV(int i, int i2) {
        if (i != this.fpf || i2 != this.hQL) {
            this.fpf = i;
            this.hQL = i2;
            if (this.hQM != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hQM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = this.fpf * 2;
                    layoutParams.bottomMargin = this.hQL;
                }
                this.hQM.setLayoutParams(layoutParams);
            }
        }
    }

    public void oM(boolean z) {
        this.hQQ = z;
        if (this.hQM != null && this.hQM.getParent() != null) {
            this.hQM.setVisibility(z ? 0 : 8);
        }
    }

    public void FB() {
        this.mLiveId = "";
        bTP();
        this.hQJ = null;
        if (this.hQO != null) {
            this.hQO.removeCallbacksAndMessages(null);
        }
        if (this.hQM != null) {
            this.hQM.removeAllViews();
            if (this.hQK != null) {
                this.hQK.removeView(this.hQM);
            }
            this.hQM = null;
            this.hQN = null;
        }
    }

    public void release() {
        FB();
        if (this.hQP != null) {
            this.hQP.release();
            this.hQP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckU() {
        bv bvVar = com.baidu.live.ae.a.Qm().bCs;
        if (bvVar == null || bvVar.aRp == null || bvVar.aRp.aTW) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRotaryTableUnabled()) {
                if (this.hQP == null) {
                    this.hQP = new com.baidu.tieba.ala.liveroom.turntable.c();
                    this.hQP.a(new com.baidu.tieba.ala.liveroom.turntable.b() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.1
                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0680a
                        public void a(String str, c cVar) {
                            super.a(str, cVar);
                            b.this.a(true, str, cVar);
                        }

                        @Override // com.baidu.tieba.ala.liveroom.turntable.b, com.baidu.tieba.ala.liveroom.turntable.a.InterfaceC0680a
                        public void bs(int i, String str) {
                            super.bs(i, str);
                            b.this.a(false, (String) null, (c) null);
                        }
                    });
                }
                this.hQP.Il(this.mLiveId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, String str, c cVar) {
        if (!z) {
            ckV();
        } else if (TextUtils.isEmpty(this.mLiveId)) {
        } else {
            if (TextUtils.isEmpty(str) || this.mLiveId.equals(str)) {
                if (cVar != null && cVar.hQW == 1 && cVar.expiredTime - cVar.aJA > 0) {
                    a(cVar);
                    if (this.hQN != null && cVar.hQX != null) {
                        this.hQN.setContent(cVar.hQX.giftName, cVar.hQX.hQY);
                    }
                } else {
                    bTP();
                    bRy();
                }
                ckV();
            }
        }
    }

    private void ckV() {
        if (this.hQO == null) {
            this.hQO = new Handler();
        }
        this.hQO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.ckU();
            }
        }, 5000L);
    }

    private void a(c cVar) {
        if (this.mExpiredTime != cVar.expiredTime) {
            bTP();
            this.mExpiredTime = cVar.expiredTime;
            long j = cVar.expiredTime - cVar.aJA;
            a(cVar.hQX, j);
            final long j2 = 100 + (j * 1000);
            this.gPV = new CountDownTimer(j2, 1000L) { // from class: com.baidu.tieba.ala.liveroom.turntable.lucky.b.3
                @Override // android.os.CountDownTimer
                public void onTick(long j3) {
                    b.this.C(j3, j2);
                }

                @Override // android.os.CountDownTimer
                public void onFinish() {
                    b.this.ckW();
                }
            };
            this.gPV.start();
        }
    }

    private void bTP() {
        this.mExpiredTime = 0L;
        if (this.gPV != null) {
            this.gPV.cancel();
            this.gPV = null;
        }
    }

    private void a(c.a aVar, long j) {
        String str = aVar.giftName;
        if (this.hQK != null && !TextUtils.isEmpty(str)) {
            if (this.hQN == null) {
                this.hQN = new TurnTableLuckyBubbleView(this.mContext);
            }
            if (this.hQM == null) {
                this.hQM = new FrameLayout(this.mContext);
                this.hQM.setBackgroundColor(0);
            }
            if (this.hQM.indexOfChild(this.hQN) < 0) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 1;
                this.hQM.addView(this.hQN, layoutParams);
            }
            if (this.hQK.indexOfChild(this.hQM) < 0) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.fpf * 2, -2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(12);
                layoutParams2.bottomMargin = this.hQL;
                this.hQK.addView(this.hQM, layoutParams2);
            }
            this.hQM.setVisibility(this.hQQ ? 0 : 8);
            this.hQN.setContent(str, aVar.hQY);
        }
        if (this.hQJ != null) {
            this.hQJ.a(100.0f, j + "s");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(long j, long j2) {
        if (this.hQJ != null) {
            long j3 = j / 1000;
            if (j3 >= 1) {
                this.hQJ.a((((float) j) * 1.0f) / ((float) j2), j3 + "s");
            } else {
                ckW();
            }
        }
    }

    private void bRy() {
        if (this.hQM != null) {
            this.hQM.removeAllViews();
            if (this.hQK != null) {
                this.hQK.removeView(this.hQM);
            }
            this.hQM = null;
            this.hQN = null;
        }
        if (this.hQJ != null) {
            this.hQJ.a(0.0f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckW() {
        bTP();
        bRy();
        if (this.hQO != null) {
            this.hQO.removeCallbacksAndMessages(null);
        }
        ckU();
    }

    public String b(String str, long j, long j2, long j3) {
        String encryptionUserId = ExtraParamsManager.getEncryptionUserId(String.valueOf(j2));
        String encryptionUserId2 = ExtraParamsManager.getEncryptionUserId(String.valueOf(j3));
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            sb.append(ETAG.ITEM_SEPARATOR);
        } else {
            sb.append("?");
        }
        sb.append("live_id=");
        sb.append(j);
        sb.append("&user_id=");
        sb.append(encryptionUserId);
        sb.append("&anchor_id=");
        sb.append(encryptionUserId2);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&client_type=");
        sb.append("2");
        sb.append("&_sdk_version=");
        sb.append(TbConfig.SDK_VERSION);
        sb.append("&scene_from=");
        sb.append(q.Vx());
        return sb.toString();
    }
}
