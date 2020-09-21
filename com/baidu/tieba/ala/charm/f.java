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
import com.baidu.live.data.br;
import com.baidu.live.data.u;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.RedPacketCharmView;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.u.a {
    private u aAP;
    private PendantParentView fTH;
    private PendantChildView fTI;
    private RedPacketCharmView fTJ;
    private RedPacketCharmInfo fTK;
    private CountDownTimer fTL;
    private boolean fTM;
    private CustomMessageListener fTN;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.u.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.fTH = (PendantParentView) viewGroup;
            bJu();
        }
        bJs();
    }

    @Override // com.baidu.live.u.a
    public boolean q(u uVar) {
        if (uVar == null || uVar.mLiveInfo == null) {
            if (this.fTI != null) {
                this.fTI.setVisibility(8);
            }
            return false;
        }
        this.aAP = uVar;
        return a(uVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.u.a
    public void setCanVisible(boolean z) {
        this.fTM = z;
        if (this.fTI != null) {
            this.fTI.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.u.a
    public void dD(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.fTI != null && (this.fTI.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.fTI.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.fTI.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.u.a
    public void FB() {
        reset(true);
    }

    @Override // com.baidu.live.u.a
    public void release() {
        FB();
    }

    private void bJs() {
        if (this.fTN == null) {
            this.fTN = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fTN);
        }
    }

    private void bJt() {
        if (this.fTN != null) {
            MessageManager.getInstance().unRegisterListener(this.fTN);
            this.fTN = null;
        }
    }

    private void bJu() {
        this.fTI = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                return this.bjp == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.fTI.setBackgroundColor(0);
        if (this.fTH != null) {
            this.fTH.a(this.fTI, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.fTI != null) {
                this.fTI.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.fTI == null) {
            bJu();
        }
        if (this.fTJ == null || (this.fTI != null && this.fTI.indexOfChild(this.fTJ) < 0)) {
            this.fTJ = new RedPacketCharmView(this.mContext);
            this.fTI.addView(this.fTJ, new FrameLayout.LayoutParams(-2, -2));
            this.fTJ.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void tp(int i2) {
                    f.this.Fu("show");
                }
            });
            this.fTJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bJv();
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
        to(i);
        this.fTJ.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.fTJ.tq(1);
                } else if (j > 10) {
                    this.fTJ.tq(2);
                } else {
                    this.fTJ.tq(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.fTJ.setCountDownTimer(String.valueOf(j), k.av(1000 * j));
                    dR(j * 1000);
                    break;
                }
                break;
            case 3:
                bJw();
                dS(0L);
                this.fTJ.tq(4);
                break;
            default:
                this.fTJ.tq(1);
                break;
        }
        this.fTK = redPacketCharmInfo;
        this.fTI.setVisibility(this.fTM ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJv() {
        if (this.aAP != null && this.fTK != null) {
            br brVar = new br();
            brVar.aLL = this.fTK.id;
            brVar.liveId = String.valueOf(this.aAP.mLiveInfo.live_id);
            brVar.aLM = String.valueOf(this.aAP.aEz.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, brVar));
            Fu("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.fTK == null || TextUtils.isEmpty(this.fTK.id) || !this.fTK.id.equals(redPacketCharmInfo.id) || this.fTK.status != redPacketCharmInfo.status || this.fTK.startTime <= 0 || this.fTK.startTime != redPacketCharmInfo.startTime;
    }

    private void dR(long j) {
        bJw();
        this.fTL = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.fTJ != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.fTJ.setCountDownTimer(String.valueOf(round), k.av(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.fTJ.tq(2);
                    } else if (round <= 10) {
                        f.this.fTJ.tq(3);
                    }
                    f.this.dS(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.fTJ != null) {
                    f.this.fTJ.tq(4);
                    if (f.this.fTK != null) {
                        f fVar = f.this;
                        if (f.this.fTK.count > 1) {
                            i = f.this.fTK.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.to(i);
                    }
                    f.this.dS(0L);
                }
            }
        };
        this.fTL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void to(int i) {
        if (this.fTJ != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.fTJ.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dS(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bJw() {
        if (this.fTL != null) {
            this.fTL.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bJt();
        }
        this.fTM = true;
        this.fTK = null;
        bJw();
        kD(z);
    }

    private void kD(boolean z) {
        if (this.fTJ != null) {
            this.fTJ.release();
            if (this.fTJ.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fTJ.getParent()).removeView(this.fTJ);
            }
        }
        if (z && this.fTI != null && (this.fTI.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fTI.getParent()).removeView(this.fTI);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fu(String str) {
        if (this.fTK != null && this.fTJ != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.fTK.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.fTJ.getStyle()) {
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
