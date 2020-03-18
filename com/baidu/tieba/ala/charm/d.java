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
    private m alp;
    private ViewGroup ewN;
    private ViewGroup.LayoutParams ewO;
    private ViewGroup ewP;
    private RedPacketCharmView ewQ;
    private RedPacketCharmInfo ewR;
    private CountDownTimer ewS;
    private boolean ewT;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewN = viewGroup;
        this.ewO = layoutParams;
        bdY();
    }

    @Override // com.baidu.live.q.a
    public boolean m(m mVar) {
        int i;
        if (mVar == null || mVar.mLiveInfo == null) {
            if (this.ewP != null) {
                this.ewP.setVisibility(8);
                return false;
            }
            return false;
        }
        this.alp = mVar;
        RedPacketCharmInfo redPacketCharmInfo = mVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.ewP != null) {
                this.ewP.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.ewP == null || this.ewN.indexOfChild(this.ewP) < 0) {
            bdY();
        }
        if (this.ewQ == null || (this.ewP != null && this.ewP.indexOfChild(this.ewQ) < 0)) {
            this.ewQ = new RedPacketCharmView(this.ewP.getContext());
            this.ewP.addView(this.ewQ, new FrameLayout.LayoutParams(-2, -2));
            this.ewQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.bdZ();
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
        oY(i);
        this.ewQ.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ewQ.oZ(1);
                } else {
                    this.ewQ.oZ(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.ewQ.setCountDownTimer(String.valueOf(j), j.M(1000 * j));
                    cE(j * 1000);
                    break;
                }
                break;
            case 3:
                bea();
                this.ewQ.oZ(3);
                break;
            default:
                this.ewQ.oZ(1);
                break;
        }
        this.ewR = redPacketCharmInfo;
        this.ewP.setVisibility(this.ewT ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.ewT = z;
        if (this.ewP != null) {
            this.ewP.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void bW(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.ewP != null && (this.ewP.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.ewP.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.ewP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.ewO = layoutParams;
        if (this.ewP != null) {
            this.ewP.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void sQ() {
        reset(true);
    }

    @Override // com.baidu.live.q.a
    public void release() {
        sQ();
    }

    private void bdY() {
        this.ewP = new FrameLayout(this.ewN.getContext());
        this.ewP.setBackgroundColor(0);
        this.ewP.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.ewN.addView(this.ewP, this.ewO);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdZ() {
        if (this.alp != null && this.ewR != null) {
            au auVar = new au();
            auVar.adL = this.ewR.id;
            auVar.liveId = String.valueOf(this.alp.mLiveInfo.live_id);
            auVar.adM = String.valueOf(this.alp.Ya.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, auVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.ewR == null || TextUtils.isEmpty(this.ewR.id) || !this.ewR.id.equals(redPacketCharmInfo.id) || this.ewR.status != redPacketCharmInfo.status || this.ewR.startTime <= 0 || this.ewR.startTime != redPacketCharmInfo.startTime;
    }

    private void cE(long j) {
        bea();
        this.ewS = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.d.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (d.this.ewQ != null) {
                    long round = Math.round(j2 / 1000.0d);
                    d.this.ewQ.setCountDownTimer(String.valueOf(round), j.M(1000 * round));
                    if (round <= 60) {
                        d.this.ewQ.oZ(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (d.this.ewQ != null) {
                    d.this.ewQ.oZ(3);
                    if (d.this.ewR != null) {
                        d dVar = d.this;
                        if (d.this.ewR.count > 1) {
                            i = d.this.ewR.count - 1;
                        } else {
                            i = 0;
                        }
                        dVar.oY(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.ewS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oY(int i) {
        if (this.ewQ != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ewQ.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bea() {
        if (this.ewS != null) {
            this.ewS.cancel();
        }
    }

    private void reset(boolean z) {
        this.ewT = true;
        this.ewR = null;
        bea();
        hT(z);
    }

    private void hT(boolean z) {
        if (this.ewQ != null) {
            this.ewQ.release();
            if (this.ewQ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ewQ.getParent()).removeView(this.ewQ);
            }
        }
        if (z && this.ewP != null && (this.ewP.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewP.getParent()).removeView(this.ewP);
        }
    }
}
