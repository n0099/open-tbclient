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
    private u aDU;
    private PendantParentView gga;
    private PendantChildView ggb;
    private RedPacketCharmView ggc;
    private RedPacketCharmInfo ggd;
    private CountDownTimer gge;
    private boolean ggf;
    private CustomMessageListener ggg;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.u.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gga = (PendantParentView) viewGroup;
            bMe();
        }
        bMc();
    }

    @Override // com.baidu.live.u.a
    public boolean q(u uVar) {
        if (uVar == null || uVar.mLiveInfo == null) {
            if (this.ggb != null) {
                this.ggb.setVisibility(8);
            }
            return false;
        }
        this.aDU = uVar;
        return a(uVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.u.a
    public void setCanVisible(boolean z) {
        this.ggf = z;
        if (this.ggb != null) {
            this.ggb.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.u.a
    public void dI(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.ggb != null && (this.ggb.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.ggb.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.ggb.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.u.a
    public void Gx() {
        reset(true);
    }

    @Override // com.baidu.live.u.a
    public void release() {
        Gx();
    }

    private void bMc() {
        if (this.ggg == null) {
            this.ggg = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.ggg);
        }
    }

    private void bMd() {
        if (this.ggg != null) {
            MessageManager.getInstance().unRegisterListener(this.ggg);
            this.ggg = null;
        }
    }

    private void bMe() {
        this.ggb = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                return this.bnc == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.ggb.setBackgroundColor(0);
        if (this.gga != null) {
            this.gga.a(this.ggb, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.ggb != null) {
                this.ggb.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.ggb == null) {
            bMe();
        }
        if (this.ggc == null || (this.ggb != null && this.ggb.indexOfChild(this.ggc) < 0)) {
            this.ggc = new RedPacketCharmView(this.mContext);
            this.ggb.addView(this.ggc, new FrameLayout.LayoutParams(-2, -2));
            this.ggc.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void tN(int i2) {
                    f.this.Gf("show");
                }
            });
            this.ggc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bMf();
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
        tM(i);
        this.ggc.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ggc.tO(1);
                } else if (j > 10) {
                    this.ggc.tO(2);
                } else {
                    this.ggc.tO(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.ggc.setCountDownTimer(String.valueOf(j), k.aw(1000 * j));
                    ea(j * 1000);
                    break;
                }
                break;
            case 3:
                bMg();
                eb(0L);
                this.ggc.tO(4);
                break;
            default:
                this.ggc.tO(1);
                break;
        }
        this.ggd = redPacketCharmInfo;
        this.ggb.setVisibility(this.ggf ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMf() {
        if (this.aDU != null && this.ggd != null) {
            br brVar = new br();
            brVar.aOQ = this.ggd.id;
            brVar.liveId = String.valueOf(this.aDU.mLiveInfo.live_id);
            brVar.aOR = String.valueOf(this.aDU.aHD.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, brVar));
            Gf("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.ggd == null || TextUtils.isEmpty(this.ggd.id) || !this.ggd.id.equals(redPacketCharmInfo.id) || this.ggd.status != redPacketCharmInfo.status || this.ggd.startTime <= 0 || this.ggd.startTime != redPacketCharmInfo.startTime;
    }

    private void ea(long j) {
        bMg();
        this.gge = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.ggc != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.ggc.setCountDownTimer(String.valueOf(round), k.aw(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.ggc.tO(2);
                    } else if (round <= 10) {
                        f.this.ggc.tO(3);
                    }
                    f.this.eb(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.ggc != null) {
                    f.this.ggc.tO(4);
                    if (f.this.ggd != null) {
                        f fVar = f.this;
                        if (f.this.ggd.count > 1) {
                            i = f.this.ggd.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.tM(i);
                    }
                    f.this.eb(0L);
                }
            }
        };
        this.gge.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tM(int i) {
        if (this.ggc != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ggc.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bMg() {
        if (this.gge != null) {
            this.gge.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bMd();
        }
        this.ggf = true;
        this.ggd = null;
        bMg();
        lb(z);
    }

    private void lb(boolean z) {
        if (this.ggc != null) {
            this.ggc.release();
            if (this.ggc.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ggc.getParent()).removeView(this.ggc);
            }
        }
        if (z && this.ggb != null && (this.ggb.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ggb.getParent()).removeView(this.ggb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gf(String str) {
        if (this.ggd != null && this.ggc != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.ggd.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.ggc.getStyle()) {
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
