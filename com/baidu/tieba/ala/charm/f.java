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
/* loaded from: classes11.dex */
public class f implements com.baidu.live.aa.a {
    private ab aDd;
    private RedPacketCharmView gOk;
    private RedPacketCharmInfo gOl;
    private CountDownTimer gOm;
    private boolean gOn;
    private CustomMessageListener gOo;
    private PendantParentView gou;
    private PendantChildView gov;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.aa.a
    public void q(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.gou = (PendantParentView) viewGroup;
            bNZ();
        }
        bTG();
    }

    @Override // com.baidu.live.aa.a
    public boolean p(ab abVar) {
        if (abVar == null || abVar.mLiveInfo == null) {
            if (this.gov != null) {
                this.gov.setVisibility(8);
            }
            return false;
        }
        this.aDd = abVar;
        return a(abVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.aa.a
    public void setCanVisible(boolean z) {
        this.gOn = z;
        if (this.gov != null) {
            this.gov.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.aa.a
    public void cr(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.gov != null && (this.gov.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.gov.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.gov.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.aa.a
    public void Fy() {
        reset(true);
    }

    @Override // com.baidu.live.aa.a
    public void release() {
        Fy();
    }

    private void bTG() {
        if (this.gOo == null) {
            this.gOo = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.gOo);
        }
    }

    private void bTH() {
        if (this.gOo != null) {
            MessageManager.getInstance().unRegisterListener(this.gOo);
            this.gOo = null;
        }
    }

    private void bNZ() {
        this.gov = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                switch (AnonymousClass6.gOq[this.bwT.ordinal()]) {
                    case 1:
                    case 2:
                        return 97;
                    default:
                        return 10;
                }
            }
        };
        this.gov.setBackgroundColor(0);
        if (this.gou != null) {
            this.gou.a(this.gov, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: com.baidu.tieba.ala.charm.f$6  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] gOq = new int[PendantParentView.Model.values().length];

        static {
            try {
                gOq[PendantParentView.Model.VERTICAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                gOq[PendantParentView.Model.VERTICAL_BB_CHATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.gov != null) {
                this.gov.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.gov == null) {
            bNZ();
        }
        if (this.gOk == null || (this.gov != null && this.gov.indexOfChild(this.gOk) < 0)) {
            this.gOk = new RedPacketCharmView(this.mContext);
            this.gov.addView(this.gOk, new FrameLayout.LayoutParams(-2, -2));
            this.gOk.setCallback(new RedPacketCharmView.a() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // com.baidu.tieba.ala.charm.RedPacketCharmView.a
                public void ug(int i2) {
                    f.this.Gu("show");
                }
            });
            this.gOk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bTI();
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
        this.gOk.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.gOk.uh(1);
                } else if (j > 10) {
                    this.gOk.uh(2);
                } else {
                    this.gOk.uh(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.gOk.setCountDownTimer(String.valueOf(j), k.bw(1000 * j));
                    fh(j * 1000);
                    break;
                }
                break;
            case 3:
                bTJ();
                fi(0L);
                this.gOk.uh(4);
                break;
            default:
                this.gOk.uh(1);
                break;
        }
        this.gOl = redPacketCharmInfo;
        this.gov.setVisibility(this.gOn ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTI() {
        if (this.aDd != null && this.gOl != null) {
            ci ciVar = new ci();
            ciVar.aQQ = this.gOl.id;
            ciVar.liveId = String.valueOf(this.aDd.mLiveInfo.live_id);
            ciVar.aJM = String.valueOf(this.aDd.aId.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, ciVar));
            Gu("click");
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.gOl == null || TextUtils.isEmpty(this.gOl.id) || !this.gOl.id.equals(redPacketCharmInfo.id) || this.gOl.status != redPacketCharmInfo.status || this.gOl.startTime <= 0 || this.gOl.startTime != redPacketCharmInfo.startTime;
    }

    private void fh(long j) {
        bTJ();
        this.gOm = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.5
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.gOk != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.gOk.setCountDownTimer(String.valueOf(round), k.bw(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.gOk.uh(2);
                    } else if (round <= 10) {
                        f.this.gOk.uh(3);
                    }
                    f.this.fi(round);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.gOk != null) {
                    f.this.gOk.uh(4);
                    if (f.this.gOl != null) {
                        f fVar = f.this;
                        if (f.this.gOl.count > 1) {
                            i = f.this.gOl.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.uf(i);
                    }
                    f.this.fi(0L);
                }
            }
        };
        this.gOm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uf(int i) {
        if (this.gOk != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.gOk.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(long j) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(j)));
    }

    private void bTJ() {
        if (this.gOm != null) {
            this.gOm.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bTH();
        }
        this.gOn = true;
        this.gOl = null;
        bTJ();
        mv(z);
    }

    private void mv(boolean z) {
        if (this.gOk != null) {
            this.gOk.release();
            if (this.gOk.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.gOk.getParent()).removeView(this.gOk);
            }
        }
        if (z && this.gov != null && (this.gov.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.gov.getParent()).removeView(this.gov);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gu(String str) {
        if (this.gOl != null && this.gOk != null) {
            AlaStatsItem alaStatsItem = new AlaStatsItem();
            alaStatsItem.addValue("redpacketId", this.gOl.id);
            alaStatsItem.addValue("actionType", str);
            String str2 = "";
            switch (this.gOk.getStyle()) {
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
