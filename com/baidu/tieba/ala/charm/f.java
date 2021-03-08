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
import com.baidu.live.data.ab;
import com.baidu.live.data.ci;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.charm.RedPacketCharmView;
/* loaded from: classes10.dex */
public class f implements com.baidu.live.aa.a {
    private ab aED;
    private RedPacketCharmView gPT;
    private RedPacketCharmInfo gPU;
    private CountDownTimer gPV;
    private boolean gPW;
    private CustomMessageListener gPX;
    private PendantParentView gqd;
    private PendantChildView gqe;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.aa.a
    public void q(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gqd = (PendantParentView) viewGroup;
            bOf();
        }
        bTM();
    }

    @Override // com.baidu.live.aa.a
    public boolean p(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            if (this.gqe != null) {
                this.gqe.setVisibility(8);
            }
            return false;
        }
        this.aED = abVar;
        return a(abVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.aa.a
    public void setCanVisible(boolean z) {
        this.gPW = z;
        if (this.gqe != null) {
            this.gqe.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void cs(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gqe != null && (this.gqe.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gqe.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gqe.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.aa.a
    public void FB() {
        reset(true);
    }

    @Override // com.baidu.live.aa.a
    public void release() {
        FB();
    }

    private void bTM() {
        if (this.gPX == null) {
            this.gPX = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gPX);
        }
    }

    private void bTN() {
        if (this.gPX != null) {
            MessageManager.getInstance().unRegisterListener(this.gPX);
            this.gPX = null;
        }
    }

    private void bOf() {
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
                switch (AnonymousClass6.gPZ[this.byt.ordinal()]) {
                    case 1:
                    case 2:
                        return 97;
                    default:
                        return 10;
                }
            }
        };
        this.gqe.setBackgroundColor(0);
        if (this.gqd != null) {
            this.gqd.a(this.gqe, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: com.baidu.tieba.ala.charm.f$6  reason: invalid class name */
    /* loaded from: classes10.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] gPZ = new int[PendantParentView.Model.values().length];

        static {
            try {
                gPZ[PendantParentView.Model.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gPZ[PendantParentView.Model.VERTICAL_BB_CHATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
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
            bOf();
        }
        if (this.gPT == null || (this.gqe != null && this.gqe.indexOfChild(this.gPT) < 0)) {
            this.gPT = new RedPacketCharmView(this.mContext);
            this.gqe.addView(this.gPT, new FrameLayout.LayoutParams(-2, -2));
            this.gPT.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void ui(int i2) {
                    f.this.GD("show");
                }
            });
            this.gPT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bTO();
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
        uh(i);
        this.gPT.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.gPT.uj(1);
                } else if (j > 10) {
                    this.gPT.uj(2);
                } else {
                    this.gPT.uj(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.gPT.setCountDownTimer(String.valueOf(j), k.bw(1000 * j));
                    fh(j * 1000);
                    break;
                }
                break;
            case 3:
                bTP();
                fi(0L);
                this.gPT.uj(4);
                break;
            default:
                this.gPT.uj(1);
                break;
        }
        this.gPU = redPacketCharmInfo;
        this.gqe.setVisibility(this.gPW ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTO() {
        if (this.aED != null && this.gPU != null) {
            ci ciVar = new ci();
            ciVar.aSq = this.gPU.id;
            ciVar.liveId = String.valueOf(this.aED.mLiveInfo.live_id);
            ciVar.aLm = String.valueOf(this.aED.aJD.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, ciVar));
            GD("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gPU == null || TextUtils.isEmpty(this.gPU.id) || !this.gPU.id.equals(redPacketCharmInfo.id) || this.gPU.status != redPacketCharmInfo.status || this.gPU.startTime <= 0 || this.gPU.startTime != redPacketCharmInfo.startTime;
    }

    private void fh(long j) {
        bTP();
        this.gPV = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.gPT != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.gPT.setCountDownTimer(String.valueOf(round), k.bw(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.gPT.uj(2);
                    } else if (round <= 10) {
                        f.this.gPT.uj(3);
                    }
                    f.this.fi(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.gPT != null) {
                    f.this.gPT.uj(4);
                    if (f.this.gPU != null) {
                        f fVar = f.this;
                        if (f.this.gPU.count > 1) {
                            i = f.this.gPU.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.uh(i);
                    }
                    f.this.fi(0L);
                }
            }
        };
        this.gPV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uh(int i) {
        if (this.gPT != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.gPT.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bTP() {
        if (this.gPV != null) {
            this.gPV.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bTN();
        }
        this.gPW = true;
        this.gPU = null;
        bTP();
        mv(z);
    }

    private void mv(boolean z) {
        if (this.gPT != null) {
            this.gPT.release();
            if (this.gPT.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gPT.getParent()).removeView(this.gPT);
            }
        }
        if (z && this.gqe != null && (this.gqe.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gqe.getParent()).removeView(this.gqe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GD(String str) {
        if (this.gPU != null && this.gPT != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.gPU.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.gPT.getStyle()) {
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
