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
    private r aAh;
    private PendantParentView fQt;
    private PendantChildView fQu;
    private RedPacketCharmView fQv;
    private RedPacketCharmInfo fQw;
    private CountDownTimer fQx;
    private boolean fQy;
    private CustomMessageListener fQz;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.s.a
    public void p(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.fQt = (PendantParentView) viewGroup;
            bIl();
        }
        bIj();
    }

    @Override // com.baidu.live.s.a
    public boolean p(r rVar) {
        if (rVar == null || rVar.mLiveInfo == null) {
            if (this.fQu != null) {
                this.fQu.setVisibility(8);
            }
            return false;
        }
        this.aAh = rVar;
        return a(rVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.s.a
    public void setCanVisible(boolean z) {
        this.fQy = z;
        if (this.fQu != null) {
            this.fQu.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.s.a
    public void dz(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.fQu != null && (this.fQu.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.fQu.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.fQu.setLayoutParams(layoutParams);
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

    private void bIj() {
        if (this.fQz == null) {
            this.fQz = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fQz);
        }
    }

    private void bIk() {
        if (this.fQz != null) {
            MessageManager.getInstance().unRegisterListener(this.fQz);
            this.fQz = null;
        }
    }

    private void bIl() {
        this.fQu = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                return this.bgw == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.fQu.setBackgroundColor(0);
        if (this.fQt != null) {
            this.fQt.a(this.fQu, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.fQu != null) {
                this.fQu.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.fQu == null) {
            bIl();
        }
        if (this.fQv == null || (this.fQu != null && this.fQu.indexOfChild(this.fQv) < 0)) {
            this.fQv = new RedPacketCharmView(this.mContext);
            this.fQu.addView(this.fQv, new FrameLayout.LayoutParams(-2, -2));
            this.fQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bIm();
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
        this.fQv.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.fQv.sX(1);
                } else if (j > 10) {
                    this.fQv.sX(2);
                } else {
                    this.fQv.sX(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.fQv.setCountDownTimer(String.valueOf(j), j.au(1000 * j));
                    dQ(j * 1000);
                    break;
                }
                break;
            case 3:
                bIn();
                this.fQv.sX(4);
                break;
            default:
                this.fQv.sX(1);
                break;
        }
        this.fQw = redPacketCharmInfo;
        this.fQu.setVisibility(this.fQy ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIm() {
        if (this.aAh != null && this.fQw != null) {
            bk bkVar = new bk();
            bkVar.aKg = this.fQw.id;
            bkVar.liveId = String.valueOf(this.aAh.mLiveInfo.live_id);
            bkVar.aKh = String.valueOf(this.aAh.aDE.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bkVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.fQw == null || TextUtils.isEmpty(this.fQw.id) || !this.fQw.id.equals(redPacketCharmInfo.id) || this.fQw.status != redPacketCharmInfo.status || this.fQw.startTime <= 0 || this.fQw.startTime != redPacketCharmInfo.startTime;
    }

    private void dQ(long j) {
        bIn();
        this.fQx = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.fQv != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.fQv.setCountDownTimer(String.valueOf(round), j.au(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.fQv.sX(2);
                    } else if (round <= 10) {
                        f.this.fQv.sX(3);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.fQv != null) {
                    f.this.fQv.sX(4);
                    if (f.this.fQw != null) {
                        f fVar = f.this;
                        if (f.this.fQw.count > 1) {
                            i = f.this.fQw.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.sW(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.fQx.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(int i) {
        if (this.fQv != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.fQv.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bIn() {
        if (this.fQx != null) {
            this.fQx.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bIk();
        }
        this.fQy = true;
        this.fQw = null;
        bIn();
        kz(z);
    }

    private void kz(boolean z) {
        if (this.fQv != null) {
            this.fQv.release();
            if (this.fQv.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fQv.getParent()).removeView(this.fQv);
            }
        }
        if (z && this.fQu != null && (this.fQu.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fQu.getParent()).removeView(this.fQu);
        }
    }
}
