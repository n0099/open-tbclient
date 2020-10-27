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
import com.baidu.live.data.bw;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.RedPacketCharmView;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.v.a {
    private w aEc;
    private PendantParentView gqd;
    private PendantChildView gqe;
    private RedPacketCharmView gqf;
    private RedPacketCharmInfo gqg;
    private CountDownTimer gqh;
    private boolean gqi;
    private CustomMessageListener gqj;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.v.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gqd = (PendantParentView) viewGroup;
            bOG();
        }
        bOE();
    }

    @Override // com.baidu.live.v.a
    public boolean p(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gqe != null) {
                this.gqe.setVisibility(8);
            }
            return false;
        }
        this.aEc = wVar;
        return a(wVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.v.a
    public void setCanVisible(boolean z) {
        this.gqi = z;
        if (this.gqe != null) {
            this.gqe.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.v.a
    public void dI(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gqe != null && (this.gqe.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gqe.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gqe.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.v.a
    public void GS() {
        reset(true);
    }

    @Override // com.baidu.live.v.a
    public void release() {
        GS();
    }

    private void bOE() {
        if (this.gqj == null) {
            this.gqj = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gqj);
        }
    }

    private void bOF() {
        if (this.gqj != null) {
            MessageManager.getInstance().unRegisterListener(this.gqj);
            this.gqj = null;
        }
    }

    private void bOG() {
        this.gqe = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                return this.boA == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.gqe.setBackgroundColor(0);
        if (this.gqd != null) {
            this.gqd.a(this.gqe, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gqe != null) {
                this.gqe.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gqe == null) {
            bOG();
        }
        if (this.gqf == null || (this.gqe != null && this.gqe.indexOfChild(this.gqf) < 0)) {
            this.gqf = new RedPacketCharmView(this.mContext);
            this.gqe.addView(this.gqf, new FrameLayout.LayoutParams(-2, -2));
            this.gqf.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void ug(int i2) {
                    f.this.GE("show");
                }
            });
            this.gqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bOH();
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
        uf(i);
        this.gqf.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.gqf.uh(1);
                } else if (j > 10) {
                    this.gqf.uh(2);
                } else {
                    this.gqf.uh(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.gqf.setCountDownTimer(String.valueOf(j), k.ay(1000 * j));
                    ec(j * 1000);
                    break;
                }
                break;
            case 3:
                bOI();
                ed(0L);
                this.gqf.uh(4);
                break;
            default:
                this.gqf.uh(1);
                break;
        }
        this.gqg = redPacketCharmInfo;
        this.gqe.setVisibility(this.gqi ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        if (this.aEc != null && this.gqg != null) {
            bw bwVar = new bw();
            bwVar.aPz = this.gqg.id;
            bwVar.liveId = String.valueOf(this.aEc.mLiveInfo.live_id);
            bwVar.aPA = String.valueOf(this.aEc.aIe.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bwVar));
            GE("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gqg == null || TextUtils.isEmpty(this.gqg.id) || !this.gqg.id.equals(redPacketCharmInfo.id) || this.gqg.status != redPacketCharmInfo.status || this.gqg.startTime <= 0 || this.gqg.startTime != redPacketCharmInfo.startTime;
    }

    private void ec(long j) {
        bOI();
        this.gqh = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.gqf != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.gqf.setCountDownTimer(String.valueOf(round), k.ay(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.gqf.uh(2);
                    } else if (round <= 10) {
                        f.this.gqf.uh(3);
                    }
                    f.this.ed(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.gqf != null) {
                    f.this.gqf.uh(4);
                    if (f.this.gqg != null) {
                        f fVar = f.this;
                        if (f.this.gqg.count > 1) {
                            i = f.this.gqg.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.uf(i);
                    }
                    f.this.ed(0L);
                }
            }
        };
        this.gqh.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
        if (this.gqf != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.gqf.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ed(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bOI() {
        if (this.gqh != null) {
            this.gqh.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bOF();
        }
        this.gqi = true;
        this.gqg = null;
        bOI();
        lt(z);
    }

    private void lt(boolean z) {
        if (this.gqf != null) {
            this.gqf.release();
            if (this.gqf.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gqf.getParent()).removeView(this.gqf);
            }
        }
        if (z && this.gqe != null && (this.gqe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqe.getParent()).removeView(this.gqe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GE(String str) {
        if (this.gqg != null && this.gqf != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.gqg.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.gqf.getStyle()) {
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
