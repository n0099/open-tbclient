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
    private m ale;
    private ViewGroup ewr;
    private ViewGroup.LayoutParams ews;
    private ViewGroup ewt;
    private RedPacketCharmView ewu;
    private RedPacketCharmInfo ewv;
    private CountDownTimer eww;
    private boolean ewx;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewr = viewGroup;
        this.ews = layoutParams;
        bdT();
    }

    @Override // com.baidu.live.q.a
    public boolean m(m mVar) {
        int i;
        if (mVar == null || mVar.mLiveInfo == null) {
            if (this.ewt != null) {
                this.ewt.setVisibility(8);
                return false;
            }
            return false;
        }
        this.ale = mVar;
        RedPacketCharmInfo redPacketCharmInfo = mVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.ewt != null) {
                this.ewt.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.ewt == null || this.ewr.indexOfChild(this.ewt) < 0) {
            bdT();
        }
        if (this.ewu == null || (this.ewt != null && this.ewt.indexOfChild(this.ewu) < 0)) {
            this.ewu = new RedPacketCharmView(this.ewt.getContext());
            this.ewt.addView(this.ewu, new FrameLayout.LayoutParams(-2, -2));
            this.ewu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.bdU();
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
        this.ewu.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ewu.oX(1);
                } else {
                    this.ewu.oX(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.ewu.setCountDownTimer(String.valueOf(j), j.M(1000 * j));
                    cE(j * 1000);
                    break;
                }
                break;
            case 3:
                bdV();
                this.ewu.oX(3);
                break;
            default:
                this.ewu.oX(1);
                break;
        }
        this.ewv = redPacketCharmInfo;
        this.ewt.setVisibility(this.ewx ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.ewx = z;
        if (this.ewt != null) {
            this.ewt.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void bW(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.ewt != null && (this.ewt.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.ewt.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.ewt.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.ews = layoutParams;
        if (this.ewt != null) {
            this.ewt.setLayoutParams(layoutParams);
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

    private void bdT() {
        this.ewt = new FrameLayout(this.ewr.getContext());
        this.ewt.setBackgroundColor(0);
        this.ewt.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.ewr.addView(this.ewt, this.ews);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdU() {
        if (this.ale != null && this.ewv != null) {
            au auVar = new au();
            auVar.adB = this.ewv.id;
            auVar.liveId = String.valueOf(this.ale.mLiveInfo.live_id);
            auVar.adC = String.valueOf(this.ale.XQ.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, auVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.ewv == null || TextUtils.isEmpty(this.ewv.id) || !this.ewv.id.equals(redPacketCharmInfo.id) || this.ewv.status != redPacketCharmInfo.status || this.ewv.startTime <= 0 || this.ewv.startTime != redPacketCharmInfo.startTime;
    }

    private void cE(long j) {
        bdV();
        this.eww = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.d.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (d.this.ewu != null) {
                    long round = Math.round(j2 / 1000.0d);
                    d.this.ewu.setCountDownTimer(String.valueOf(round), j.M(1000 * round));
                    if (round <= 60) {
                        d.this.ewu.oX(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (d.this.ewu != null) {
                    d.this.ewu.oX(3);
                    if (d.this.ewv != null) {
                        d dVar = d.this;
                        if (d.this.ewv.count > 1) {
                            i = d.this.ewv.count - 1;
                        } else {
                            i = 0;
                        }
                        dVar.oW(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.eww.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(int i) {
        if (this.ewu != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ewu.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bdV() {
        if (this.eww != null) {
            this.eww.cancel();
        }
    }

    private void reset(boolean z) {
        this.ewx = true;
        this.ewv = null;
        bdV();
        hS(z);
    }

    private void hS(boolean z) {
        if (this.ewu != null) {
            this.ewu.release();
            if (this.ewu.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ewu.getParent()).removeView(this.ewu);
            }
        }
        if (z && this.ewt != null && (this.ewt.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewt.getParent()).removeView(this.ewt);
        }
    }
}
