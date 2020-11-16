package com.baidu.tieba.ala.charm;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.bx;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.RedPacketCharmView;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.w.a {
    private w aDh;
    private RedPacketCharmView gvA;
    private RedPacketCharmInfo gvB;
    private CountDownTimer gvC;
    private boolean gvD;
    private CustomMessageListener gvE;
    private PendantParentView gvy;
    private PendantChildView gvz;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.w.a
    public void p(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gvy = (PendantParentView) viewGroup;
            bQz();
        }
        bQx();
    }

    @Override // com.baidu.live.w.a
    public boolean o(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gvz != null) {
                this.gvz.setVisibility(8);
            }
            return false;
        }
        this.aDh = wVar;
        return a(wVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.w.a
    public void setCanVisible(boolean z) {
        this.gvD = z;
        if (this.gvz != null) {
            this.gvz.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.w.a
    public void dE(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gvz != null && (this.gvz.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gvz.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gvz.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.w.a
    public void GK() {
        reset(true);
    }

    @Override // com.baidu.live.w.a
    public void release() {
        GK();
    }

    private void bQx() {
        if (this.gvE == null) {
            this.gvE = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gvE);
        }
    }

    private void bQy() {
        if (this.gvE != null) {
            MessageManager.getInstance().unRegisterListener(this.gvE);
            this.gvE = null;
        }
    }

    private void bQz() {
        this.gvz = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getHorizontalFullPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public int getPriority() {
                return this.boi == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.gvz.setBackgroundColor(0);
        if (this.gvy != null) {
            this.gvy.a(this.gvz, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gvz != null) {
                this.gvz.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gvz == null) {
            bQz();
        }
        if (this.gvA == null || (this.gvz != null && this.gvz.indexOfChild(this.gvA) < 0)) {
            this.gvA = new RedPacketCharmView(this.mContext);
            this.gvz.addView(this.gvA, new FrameLayout.LayoutParams(-2, -2));
            this.gvA.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void uO(int i2) {
                    f.this.Gt("show");
                }
            });
            this.gvA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bQA();
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
        uN(i);
        this.gvA.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.gvA.uP(1);
                } else if (j > 10) {
                    this.gvA.uP(2);
                } else {
                    this.gvA.uP(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.gvA.setCountDownTimer(String.valueOf(j), k.aU(1000 * j));
                    ey(j * 1000);
                    break;
                }
                break;
            case 3:
                bQB();
                ez(0L);
                this.gvA.uP(4);
                break;
            default:
                this.gvA.uP(1);
                break;
        }
        this.gvB = redPacketCharmInfo;
        this.gvz.setVisibility(this.gvD ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQA() {
        if (this.aDh != null && this.gvB != null) {
            bx bxVar = new bx();
            bxVar.aOL = this.gvB.id;
            bxVar.liveId = String.valueOf(this.aDh.mLiveInfo.live_id);
            bxVar.aOM = String.valueOf(this.aDh.aHk.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bxVar));
            Gt("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gvB == null || TextUtils.isEmpty(this.gvB.id) || !this.gvB.id.equals(redPacketCharmInfo.id) || this.gvB.status != redPacketCharmInfo.status || this.gvB.startTime <= 0 || this.gvB.startTime != redPacketCharmInfo.startTime;
    }

    private void ey(long j) {
        bQB();
        this.gvC = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.gvA != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.gvA.setCountDownTimer(String.valueOf(round), k.aU(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.gvA.uP(2);
                    } else if (round <= 10) {
                        f.this.gvA.uP(3);
                    }
                    f.this.ez(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.gvA != null) {
                    f.this.gvA.uP(4);
                    if (f.this.gvB != null) {
                        f fVar = f.this;
                        if (f.this.gvB.count > 1) {
                            i = f.this.gvB.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.uN(i);
                    }
                    f.this.ez(0L);
                }
            }
        };
        this.gvC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(int i) {
        if (this.gvA != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.gvA.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ez(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bQB() {
        if (this.gvC != null) {
            this.gvC.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bQy();
        }
        this.gvD = true;
        this.gvB = null;
        bQB();
        lD(z);
    }

    private void lD(boolean z) {
        if (this.gvA != null) {
            this.gvA.release();
            if (this.gvA.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gvA.getParent()).removeView(this.gvA);
            }
        }
        if (z && this.gvz != null && (this.gvz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gvz.getParent()).removeView(this.gvz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt(String str) {
        if (this.gvB != null && this.gvA != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.gvB.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.gvA.getStyle()) {
                case 1:
                    str2 = "longTimer";
                    break;
                case 2:
                case 3:
                    str2 = "shortTimer";
                    break;
                case 4:
                    str2 = "startTimer";
                    break;
            }
            alaStatsItem.addValue("state", str2);
            AlaStatManager.getInstance().debug("redpacket_pendant", "", "", alaStatsItem);
        }
    }
}
