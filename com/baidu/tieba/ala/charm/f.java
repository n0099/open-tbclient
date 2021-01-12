package com.baidu.tieba.ala.charm;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.live.data.cb;
import com.baidu.live.data.x;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.RedPacketCharmView;
/* loaded from: classes10.dex */
public class f implements com.baidu.live.ab.a {
    private x aBr;
    private RedPacketCharmView gLq;
    private RedPacketCharmInfo gLr;
    private CountDownTimer gLs;
    private boolean gLt;
    private CustomMessageListener gLu;
    private PendantParentView glA;
    private PendantChildView glB;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ab.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.glA = (PendantParentView) viewGroup;
            bNr();
        }
        bSW();
    }

    @Override // com.baidu.live.ab.a
    public boolean p(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            if (this.glB != null) {
                this.glB.setVisibility(8);
            }
            return false;
        }
        this.aBr = xVar;
        return a(xVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.ab.a
    public void setCanVisible(boolean z) {
        this.gLt = z;
        if (this.glB != null) {
            Log.e("pendent_check", "==>> redpacket mCharmParentView.setVisibility() canVisible : " + z);
            this.glB.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.ab.a
    public void co(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.glB != null && (this.glB.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.glB.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.glB.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.ab.a
    public void Ei() {
        reset(true);
    }

    @Override // com.baidu.live.ab.a
    public void release() {
        Ei();
    }

    private void bSW() {
        if (this.gLu == null) {
            this.gLu = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gLu);
        }
    }

    private void bSX() {
        if (this.gLu != null) {
            MessageManager.getInstance().unRegisterListener(this.gLu);
            this.gLu = null;
        }
    }

    private void bNr() {
        this.glB = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalPkPosition() {
                return PendantParentView.Position.RIGHT;
            }

            @Override // com.baidu.live.pendantview.PendantChildView
            public PendantParentView.Position getVerticalBBChattingPosition() {
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
                switch (AnonymousClass6.gLw[this.btq.ordinal()]) {
                    case 1:
                    case 2:
                        return 95;
                    default:
                        return 10;
                }
            }
        };
        this.glB.setBackgroundColor(0);
        if (this.glA != null) {
            this.glA.a(this.glB, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: com.baidu.tieba.ala.charm.f$6  reason: invalid class name */
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] gLw = new int[PendantParentView.Model.values().length];

        static {
            try {
                gLw[PendantParentView.Model.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gLw[PendantParentView.Model.VERTICAL_BB_CHATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.glB != null) {
                this.glB.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.glB == null) {
            bNr();
        }
        if (this.gLq == null || (this.glB != null && this.glB.indexOfChild(this.gLq) < 0)) {
            this.gLq = new RedPacketCharmView(this.mContext);
            this.glB.addView(this.gLq, new FrameLayout.LayoutParams(-2, -2));
            this.gLq.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void ua(int i2) {
                    f.this.FU("show");
                }
            });
            this.gLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bSY();
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
        tZ(i);
        this.gLq.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.gLq.ub(1);
                } else if (j > 10) {
                    this.gLq.ub(2);
                } else {
                    this.gLq.ub(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.gLq.setCountDownTimer(String.valueOf(j), k.bs(1000 * j));
                    fb(j * 1000);
                    break;
                }
                break;
            case 3:
                bSZ();
                fc(0L);
                this.gLq.ub(4);
                break;
            default:
                this.gLq.ub(1);
                break;
        }
        this.gLr = redPacketCharmInfo;
        this.glB.setVisibility(this.gLt ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSY() {
        if (this.aBr != null && this.gLr != null) {
            cb cbVar = new cb();
            cbVar.aNP = this.gLr.id;
            cbVar.liveId = String.valueOf(this.aBr.mLiveInfo.live_id);
            cbVar.aHi = String.valueOf(this.aBr.aFH.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, cbVar));
            FU("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gLr == null || TextUtils.isEmpty(this.gLr.id) || !this.gLr.id.equals(redPacketCharmInfo.id) || this.gLr.status != redPacketCharmInfo.status || this.gLr.startTime <= 0 || this.gLr.startTime != redPacketCharmInfo.startTime;
    }

    private void fb(long j) {
        bSZ();
        this.gLs = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.gLq != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.gLq.setCountDownTimer(String.valueOf(round), k.bs(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.gLq.ub(2);
                    } else if (round <= 10) {
                        f.this.gLq.ub(3);
                    }
                    f.this.fc(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.gLq != null) {
                    f.this.gLq.ub(4);
                    if (f.this.gLr != null) {
                        f fVar = f.this;
                        if (f.this.gLr.count > 1) {
                            i = f.this.gLr.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.tZ(i);
                    }
                    f.this.fc(0L);
                }
            }
        };
        this.gLs.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tZ(int i) {
        if (this.gLq != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.gLq.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bSZ() {
        if (this.gLs != null) {
            this.gLs.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bSX();
        }
        this.gLt = true;
        this.gLr = null;
        bSZ();
        mr(z);
    }

    private void mr(boolean z) {
        if (this.gLq != null) {
            this.gLq.release();
            if (this.gLq.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gLq.getParent()).removeView(this.gLq);
            }
        }
        if (z && this.glB != null && (this.glB.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.glB.getParent()).removeView(this.glB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FU(String str) {
        if (this.gLr != null && this.gLq != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.gLr.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.gLq.getStyle()) {
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
