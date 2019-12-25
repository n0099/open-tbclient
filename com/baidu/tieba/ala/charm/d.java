package com.baidu.tieba.ala.charm;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ao;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
import com.baidu.live.utils.j;
/* loaded from: classes2.dex */
public class d implements com.baidu.live.m.a {
    private k aio;
    private ViewGroup eqG;
    private ViewGroup.LayoutParams eqH;
    private ViewGroup eqI;
    private RedPacketCharmView eqJ;
    private RedPacketCharmInfo eqK;
    private CountDownTimer eqL;
    private boolean eqM;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.m.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.eqG = viewGroup;
        this.eqH = layoutParams;
        bbg();
    }

    @Override // com.baidu.live.m.a
    public void a(k kVar) {
        int i;
        if (kVar != null && kVar.mLiveInfo != null) {
            this.aio = kVar;
            RedPacketCharmInfo redPacketCharmInfo = kVar.mLiveInfo.redpacketCharmInfo;
            if (!a(redPacketCharmInfo)) {
                reset(false);
                return;
            }
            if (this.eqI == null || this.eqG.indexOfChild(this.eqI) < 0) {
                bbg();
                this.eqI.setVisibility(this.eqM ? 0 : 8);
            }
            if (this.eqJ == null || (this.eqI != null && this.eqI.indexOfChild(this.eqJ) < 0)) {
                this.eqJ = new RedPacketCharmView(this.eqI.getContext());
                this.eqI.addView(this.eqJ, new FrameLayout.LayoutParams(-2, -2));
                this.eqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        d.this.bbh();
                    }
                });
            }
            long j = redPacketCharmInfo.startTime - redPacketCharmInfo.serverTime;
            if (j <= 0) {
                redPacketCharmInfo.status = 3;
            }
            if (redPacketCharmInfo.count > 1) {
                i = redPacketCharmInfo.status == 3 ? redPacketCharmInfo.count - 1 : redPacketCharmInfo.count;
            } else {
                i = 0;
            }
            oE(i);
            this.eqJ.setAvatar(redPacketCharmInfo.senderAvatar);
            switch (redPacketCharmInfo.status) {
                case 2:
                    if (j > 60) {
                        this.eqJ.oF(1);
                    } else {
                        this.eqJ.oF(2);
                    }
                    if (b(redPacketCharmInfo)) {
                        this.eqJ.setCountDownTimer(String.valueOf(j), j.I(j * 1000));
                        cw(j * 1000);
                        break;
                    }
                    break;
                case 3:
                    bbi();
                    this.eqJ.oF(3);
                    break;
                default:
                    this.eqJ.oF(1);
                    break;
            }
            this.eqK = redPacketCharmInfo;
        }
    }

    @Override // com.baidu.live.m.a
    public void setCanVisible(boolean z) {
        this.eqM = z;
        if (this.eqI != null) {
            this.eqI.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.m.a
    public void bN(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.eqI != null && (this.eqI.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.eqI.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.eqI.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.m.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.eqH = layoutParams;
        if (this.eqI != null) {
            this.eqI.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.m.a
    public void th() {
        reset(true);
    }

    @Override // com.baidu.live.m.a
    public void release() {
        th();
    }

    private void bbg() {
        this.eqI = new FrameLayout(this.eqG.getContext());
        this.eqI.setBackgroundColor(0);
        this.eqG.addView(this.eqI, this.eqH);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbh() {
        if (this.aio != null && this.eqK != null) {
            ao aoVar = new ao();
            aoVar.abk = this.eqK.id;
            aoVar.liveId = String.valueOf(this.aio.mLiveInfo.live_id);
            aoVar.abl = String.valueOf(this.aio.VP.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, aoVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.eqK == null || TextUtils.isEmpty(this.eqK.id) || !this.eqK.id.equals(redPacketCharmInfo.id) || this.eqK.status != redPacketCharmInfo.status || this.eqK.startTime <= 0 || this.eqK.startTime != redPacketCharmInfo.startTime;
    }

    private void cw(long j) {
        bbi();
        this.eqL = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.d.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (d.this.eqJ != null) {
                    long round = Math.round(j2 / 1000.0d);
                    d.this.eqJ.setCountDownTimer(String.valueOf(round), j.I(1000 * round));
                    if (round <= 60) {
                        d.this.eqJ.oF(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (d.this.eqJ != null) {
                    d.this.eqJ.oF(3);
                    if (d.this.eqK != null) {
                        d dVar = d.this;
                        if (d.this.eqK.count > 1) {
                            i = d.this.eqK.count - 1;
                        } else {
                            i = 0;
                        }
                        dVar.oE(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.eqL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oE(int i) {
        if (this.eqJ != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.eqJ.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bbi() {
        if (this.eqL != null) {
            this.eqL.cancel();
        }
    }

    private void reset(boolean z) {
        this.eqM = true;
        this.eqK = null;
        bbi();
        hG(z);
    }

    private void hG(boolean z) {
        if (this.eqJ != null) {
            this.eqJ.release();
            if (this.eqJ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.eqJ.getParent()).removeView(this.eqJ);
            }
        }
        if (z && this.eqI != null && (this.eqI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.eqI.getParent()).removeView(this.eqI);
        }
    }
}
