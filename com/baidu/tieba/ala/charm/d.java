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
import com.baidu.live.data.au;
import com.baidu.live.data.m;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.q.a {
    private m ald;
    private ViewGroup ewe;
    private ViewGroup.LayoutParams ewf;
    private ViewGroup ewg;
    private RedPacketCharmView ewh;
    private RedPacketCharmInfo ewi;
    private CountDownTimer ewj;
    private boolean ewk;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewe = viewGroup;
        this.ewf = layoutParams;
        bdS();
    }

    @Override // com.baidu.live.q.a
    public boolean m(m mVar) {
        int i;
        if (mVar == null || mVar.mLiveInfo == null) {
            if (this.ewg != null) {
                this.ewg.setVisibility(8);
                return false;
            }
            return false;
        }
        this.ald = mVar;
        RedPacketCharmInfo redPacketCharmInfo = mVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.ewg != null) {
                this.ewg.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.ewg == null || this.ewe.indexOfChild(this.ewg) < 0) {
            bdS();
        }
        if (this.ewh == null || (this.ewg != null && this.ewg.indexOfChild(this.ewh) < 0)) {
            this.ewh = new RedPacketCharmView(this.ewg.getContext());
            this.ewg.addView(this.ewh, new FrameLayout.LayoutParams(-2, -2));
            this.ewh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.bdT();
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
        oW(i);
        this.ewh.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ewh.oX(1);
                } else {
                    this.ewh.oX(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.ewh.setCountDownTimer(String.valueOf(j), j.M(1000 * j));
                    cE(j * 1000);
                    break;
                }
                break;
            case 3:
                bdU();
                this.ewh.oX(3);
                break;
            default:
                this.ewh.oX(1);
                break;
        }
        this.ewi = redPacketCharmInfo;
        this.ewg.setVisibility(this.ewk ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.ewk = z;
        if (this.ewg != null) {
            this.ewg.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void bW(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.ewg != null && (this.ewg.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.ewg.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.ewg.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.ewf = layoutParams;
        if (this.ewg != null) {
            this.ewg.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void sL() {
        reset(true);
    }

    @Override // com.baidu.live.q.a
    public void release() {
        sL();
    }

    private void bdS() {
        this.ewg = new FrameLayout(this.ewe.getContext());
        this.ewg.setBackgroundColor(0);
        this.ewg.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.ewe.addView(this.ewg, this.ewf);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdT() {
        if (this.ald != null && this.ewi != null) {
            au auVar = new au();
            auVar.adB = this.ewi.id;
            auVar.liveId = String.valueOf(this.ald.mLiveInfo.live_id);
            auVar.adC = String.valueOf(this.ald.XQ.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, auVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.ewi == null || TextUtils.isEmpty(this.ewi.id) || !this.ewi.id.equals(redPacketCharmInfo.id) || this.ewi.status != redPacketCharmInfo.status || this.ewi.startTime <= 0 || this.ewi.startTime != redPacketCharmInfo.startTime;
    }

    private void cE(long j) {
        bdU();
        this.ewj = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.d.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (d.this.ewh != null) {
                    long round = Math.round(j2 / 1000.0d);
                    d.this.ewh.setCountDownTimer(String.valueOf(round), j.M(1000 * round));
                    if (round <= 60) {
                        d.this.ewh.oX(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (d.this.ewh != null) {
                    d.this.ewh.oX(3);
                    if (d.this.ewi != null) {
                        d dVar = d.this;
                        if (d.this.ewi.count > 1) {
                            i = d.this.ewi.count - 1;
                        } else {
                            i = 0;
                        }
                        dVar.oW(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.ewj.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(int i) {
        if (this.ewh != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ewh.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bdU() {
        if (this.ewj != null) {
            this.ewj.cancel();
        }
    }

    private void reset(boolean z) {
        this.ewk = true;
        this.ewi = null;
        bdU();
        hS(z);
    }

    private void hS(boolean z) {
        if (this.ewh != null) {
            this.ewh.release();
            if (this.ewh.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ewh.getParent()).removeView(this.ewh);
            }
        }
        if (z && this.ewg != null && (this.ewg.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewg.getParent()).removeView(this.ewg);
        }
    }
}
