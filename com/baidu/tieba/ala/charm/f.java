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
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.bk;
import com.baidu.live.data.r;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.j;
/* loaded from: classes7.dex */
public class f implements com.baidu.live.s.a {
    private r aAj;
    private RedPacketCharmInfo fQA;
    private CountDownTimer fQB;
    private boolean fQC;
    private CustomMessageListener fQD;
    private PendantParentView fQx;
    private PendantChildView fQy;
    private RedPacketCharmView fQz;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.s.a
    public void p(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.fQx = (PendantParentView) viewGroup;
            bIm();
        }
        bIk();
    }

    @Override // com.baidu.live.s.a
    public boolean p(r rVar) {
        if (rVar == null || rVar.mLiveInfo == null) {
            if (this.fQy != null) {
                this.fQy.setVisibility(8);
            }
            return false;
        }
        this.aAj = rVar;
        return a(rVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.s.a
    public void setCanVisible(boolean z) {
        this.fQC = z;
        if (this.fQy != null) {
            this.fQy.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.s.a
    public void dz(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.fQy != null && (this.fQy.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.fQy.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.fQy.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.s.a
    public void Fb() {
        reset(true);
    }

    @Override // com.baidu.live.s.a
    public void release() {
        Fb();
    }

    private void bIk() {
        if (this.fQD == null) {
            this.fQD = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fQD);
        }
    }

    private void bIl() {
        if (this.fQD != null) {
            MessageManager.getInstance().unRegisterListener(this.fQD);
            this.fQD = null;
        }
    }

    private void bIm() {
        this.fQy = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                return this.bgy == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.fQy.setBackgroundColor(0);
        if (this.fQx != null) {
            this.fQx.a(this.fQy, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.fQy != null) {
                this.fQy.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.fQy == null) {
            bIm();
        }
        if (this.fQz == null || (this.fQy != null && this.fQy.indexOfChild(this.fQz) < 0)) {
            this.fQz = new RedPacketCharmView(this.mContext);
            this.fQy.addView(this.fQz, new FrameLayout.LayoutParams(-2, -2));
            this.fQz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bIn();
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
        sW(i);
        this.fQz.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.fQz.sX(1);
                } else if (j > 10) {
                    this.fQz.sX(2);
                } else {
                    this.fQz.sX(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.fQz.setCountDownTimer(String.valueOf(j), j.au(1000 * j));
                    dQ(j * 1000);
                    break;
                }
                break;
            case 3:
                bIo();
                this.fQz.sX(4);
                break;
            default:
                this.fQz.sX(1);
                break;
        }
        this.fQA = redPacketCharmInfo;
        this.fQy.setVisibility(this.fQC ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIn() {
        if (this.aAj != null && this.fQA != null) {
            bk bkVar = new bk();
            bkVar.aKi = this.fQA.id;
            bkVar.liveId = String.valueOf(this.aAj.mLiveInfo.live_id);
            bkVar.aKj = String.valueOf(this.aAj.aDG.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bkVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.fQA == null || TextUtils.isEmpty(this.fQA.id) || !this.fQA.id.equals(redPacketCharmInfo.id) || this.fQA.status != redPacketCharmInfo.status || this.fQA.startTime <= 0 || this.fQA.startTime != redPacketCharmInfo.startTime;
    }

    private void dQ(long j) {
        bIo();
        this.fQB = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.fQz != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.fQz.setCountDownTimer(String.valueOf(round), j.au(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.fQz.sX(2);
                    } else if (round <= 10) {
                        f.this.fQz.sX(3);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.fQz != null) {
                    f.this.fQz.sX(4);
                    if (f.this.fQA != null) {
                        f fVar = f.this;
                        if (f.this.fQA.count > 1) {
                            i = f.this.fQA.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.sW(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.fQB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(int i) {
        if (this.fQz != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.fQz.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bIo() {
        if (this.fQB != null) {
            this.fQB.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bIl();
        }
        this.fQC = true;
        this.fQA = null;
        bIo();
        kB(z);
    }

    private void kB(boolean z) {
        if (this.fQz != null) {
            this.fQz.release();
            if (this.fQz.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fQz.getParent()).removeView(this.fQz);
            }
        }
        if (z && this.fQy != null && (this.fQy.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fQy.getParent()).removeView(this.fQy);
        }
    }
}
