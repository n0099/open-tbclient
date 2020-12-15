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
import com.baidu.live.data.bz;
import com.baidu.live.data.w;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.RedPacketCharmView;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.aa.a {
    private w aFN;
    private PendantParentView gEk;
    private PendantChildView gEl;
    private RedPacketCharmView gEm;
    private RedPacketCharmInfo gEn;
    private CountDownTimer gEo;
    private boolean gEp;
    private CustomMessageListener gEq;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.aa.a
    public void p(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gEk = (PendantParentView) viewGroup;
            bUk();
        }
        bUi();
    }

    @Override // com.baidu.live.aa.a
    public boolean o(w wVar) {
        if (wVar == null || wVar.mLiveInfo == null) {
            if (this.gEl != null) {
                this.gEl.setVisibility(8);
            }
            return false;
        }
        this.aFN = wVar;
        return a(wVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.aa.a
    public void setCanVisible(boolean z) {
        this.gEp = z;
        if (this.gEl != null) {
            this.gEl.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void dX(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gEl != null && (this.gEl.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gEl.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gEl.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.aa.a
    public void IB() {
        reset(true);
    }

    @Override // com.baidu.live.aa.a
    public void release() {
        IB();
    }

    private void bUi() {
        if (this.gEq == null) {
            this.gEq = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gEq);
        }
    }

    private void bUj() {
        if (this.gEq != null) {
            MessageManager.getInstance().unRegisterListener(this.gEq);
            this.gEq = null;
        }
    }

    private void bUk() {
        this.gEl = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                return this.btr == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.gEl.setBackgroundColor(0);
        if (this.gEk != null) {
            this.gEk.a(this.gEl, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gEl != null) {
                this.gEl.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gEl == null) {
            bUk();
        }
        if (this.gEm == null || (this.gEl != null && this.gEl.indexOfChild(this.gEm) < 0)) {
            this.gEm = new RedPacketCharmView(this.mContext);
            this.gEl.addView(this.gEm, new FrameLayout.LayoutParams(-2, -2));
            this.gEm.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void vv(int i2) {
                    f.this.Hh("show");
                }
            });
            this.gEm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bUl();
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
        vu(i);
        this.gEm.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.gEm.vw(1);
                } else if (j > 10) {
                    this.gEm.vw(2);
                } else {
                    this.gEm.vw(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.gEm.setCountDownTimer(String.valueOf(j), k.bs(1000 * j));
                    fb(j * 1000);
                    break;
                }
                break;
            case 3:
                bUm();
                fc(0L);
                this.gEm.vw(4);
                break;
            default:
                this.gEm.vw(1);
                break;
        }
        this.gEn = redPacketCharmInfo;
        this.gEl.setVisibility(this.gEp ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUl() {
        if (this.aFN != null && this.gEn != null) {
            bz bzVar = new bz();
            bzVar.aRN = this.gEn.id;
            bzVar.liveId = String.valueOf(this.aFN.mLiveInfo.live_id);
            bzVar.aRO = String.valueOf(this.aFN.aJV.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bzVar));
            Hh("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gEn == null || TextUtils.isEmpty(this.gEn.id) || !this.gEn.id.equals(redPacketCharmInfo.id) || this.gEn.status != redPacketCharmInfo.status || this.gEn.startTime <= 0 || this.gEn.startTime != redPacketCharmInfo.startTime;
    }

    private void fb(long j) {
        bUm();
        this.gEo = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.gEm != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.gEm.setCountDownTimer(String.valueOf(round), k.bs(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.gEm.vw(2);
                    } else if (round <= 10) {
                        f.this.gEm.vw(3);
                    }
                    f.this.fc(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.gEm != null) {
                    f.this.gEm.vw(4);
                    if (f.this.gEn != null) {
                        f fVar = f.this;
                        if (f.this.gEn.count > 1) {
                            i = f.this.gEn.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.vu(i);
                    }
                    f.this.fc(0L);
                }
            }
        };
        this.gEo.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        if (this.gEm != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.gEm.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bUm() {
        if (this.gEo != null) {
            this.gEo.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bUj();
        }
        this.gEp = true;
        this.gEn = null;
        bUm();
        lY(z);
    }

    private void lY(boolean z) {
        if (this.gEm != null) {
            this.gEm.release();
            if (this.gEm.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gEm.getParent()).removeView(this.gEm);
            }
        }
        if (z && this.gEl != null && (this.gEl.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gEl.getParent()).removeView(this.gEl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh(String str) {
        if (this.gEn != null && this.gEm != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.gEn.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.gEm.getStyle()) {
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
