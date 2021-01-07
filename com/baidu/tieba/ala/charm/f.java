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
/* loaded from: classes11.dex */
public class f implements com.baidu.live.ab.a {
    private x aGe;
    private RedPacketCharmView gPW;
    private RedPacketCharmInfo gPX;
    private CountDownTimer gPY;
    private boolean gPZ;
    private CustomMessageListener gQa;
    private PendantParentView gqh;
    private PendantChildView gqi;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.ab.a
    public void s(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gqh = (PendantParentView) viewGroup;
            bRj();
        }
        bWO();
    }

    @Override // com.baidu.live.ab.a
    public boolean p(x xVar) {
        if (xVar == null || xVar.mLiveInfo == null) {
            if (this.gqi != null) {
                this.gqi.setVisibility(8);
            }
            return false;
        }
        this.aGe = xVar;
        return a(xVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.ab.a
    public void setCanVisible(boolean z) {
        this.gPZ = z;
        if (this.gqi != null) {
            Log.e("pendent_check", "==>> redpacket mCharmParentView.setVisibility() canVisible : " + z);
            this.gqi.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.ab.a
    public void dU(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gqi != null && (this.gqi.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gqi.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gqi.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.ab.a
    public void Id() {
        reset(true);
    }

    @Override // com.baidu.live.ab.a
    public void release() {
        Id();
    }

    private void bWO() {
        if (this.gQa == null) {
            this.gQa = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gQa);
        }
    }

    private void bWP() {
        if (this.gQa != null) {
            MessageManager.getInstance().unRegisterListener(this.gQa);
            this.gQa = null;
        }
    }

    private void bRj() {
        this.gqi = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                switch (AnonymousClass6.gQc[this.byd.ordinal()]) {
                    case 1:
                    case 2:
                        return 95;
                    default:
                        return 10;
                }
            }
        };
        this.gqi.setBackgroundColor(0);
        if (this.gqh != null) {
            this.gqh.a(this.gqi, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: com.baidu.tieba.ala.charm.f$6  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] gQc = new int[PendantParentView.Model.values().length];

        static {
            try {
                gQc[PendantParentView.Model.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gQc[PendantParentView.Model.VERTICAL_BB_CHATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gqi != null) {
                this.gqi.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gqi == null) {
            bRj();
        }
        if (this.gPW == null || (this.gqi != null && this.gqi.indexOfChild(this.gPW) < 0)) {
            this.gPW = new RedPacketCharmView(this.mContext);
            this.gqi.addView(this.gPW, new FrameLayout.LayoutParams(-2, -2));
            this.gPW.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void vG(int i2) {
                    f.this.Hf("show");
                }
            });
            this.gPW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bWQ();
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
        vF(i);
        this.gPW.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.gPW.vH(1);
                } else if (j > 10) {
                    this.gPW.vH(2);
                } else {
                    this.gPW.vH(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.gPW.setCountDownTimer(String.valueOf(j), k.bs(1000 * j));
                    fb(j * 1000);
                    break;
                }
                break;
            case 3:
                bWR();
                fc(0L);
                this.gPW.vH(4);
                break;
            default:
                this.gPW.vH(1);
                break;
        }
        this.gPX = redPacketCharmInfo;
        this.gqi.setVisibility(this.gPZ ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWQ() {
        if (this.aGe != null && this.gPX != null) {
            cb cbVar = new cb();
            cbVar.aSC = this.gPX.id;
            cbVar.liveId = String.valueOf(this.aGe.mLiveInfo.live_id);
            cbVar.aLV = String.valueOf(this.aGe.aKu.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, cbVar));
            Hf("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gPX == null || TextUtils.isEmpty(this.gPX.id) || !this.gPX.id.equals(redPacketCharmInfo.id) || this.gPX.status != redPacketCharmInfo.status || this.gPX.startTime <= 0 || this.gPX.startTime != redPacketCharmInfo.startTime;
    }

    private void fb(long j) {
        bWR();
        this.gPY = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.gPW != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.gPW.setCountDownTimer(String.valueOf(round), k.bs(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.gPW.vH(2);
                    } else if (round <= 10) {
                        f.this.gPW.vH(3);
                    }
                    f.this.fc(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.gPW != null) {
                    f.this.gPW.vH(4);
                    if (f.this.gPX != null) {
                        f fVar = f.this;
                        if (f.this.gPX.count > 1) {
                            i = f.this.gPX.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.vF(i);
                    }
                    f.this.fc(0L);
                }
            }
        };
        this.gPY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vF(int i) {
        if (this.gPW != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.gPW.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bWR() {
        if (this.gPY != null) {
            this.gPY.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bWP();
        }
        this.gPZ = true;
        this.gPX = null;
        bWR();
        mv(z);
    }

    private void mv(boolean z) {
        if (this.gPW != null) {
            this.gPW.release();
            if (this.gPW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gPW.getParent()).removeView(this.gPW);
            }
        }
        if (z && this.gqi != null && (this.gqi.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqi.getParent()).removeView(this.gqi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf(String str) {
        if (this.gPX != null && this.gPW != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.gPX.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.gPW.getStyle()) {
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
