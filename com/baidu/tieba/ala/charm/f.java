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
import com.baidu.live.data.bi;
import com.baidu.live.data.q;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.j;
/* loaded from: classes4.dex */
public class f implements com.baidu.live.r.a {
    private q avf;
    private PendantParentView fFc;
    private PendantChildView fFd;
    private RedPacketCharmView fFe;
    private RedPacketCharmInfo fFf;
    private CountDownTimer fFg;
    private boolean fFh;
    private CustomMessageListener fFi;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.r.a
    public void o(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.fFc = (PendantParentView) viewGroup;
            bzi();
        }
        bzg();
    }

    @Override // com.baidu.live.r.a
    public boolean o(q qVar) {
        if (qVar == null || qVar.mLiveInfo == null) {
            if (this.fFd != null) {
                this.fFd.setVisibility(8);
            }
            return false;
        }
        this.avf = qVar;
        return a(qVar.mLiveInfo.redpacketCharmInfo);
    }

    @Override // com.baidu.live.r.a
    public void setCanVisible(boolean z) {
        this.fFh = z;
        if (this.fFd != null) {
            this.fFd.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.r.a
    public void bN(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.fFd != null && (this.fFd.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.fFd.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.fFd.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.r.a
    public void zy() {
        reset(true);
    }

    @Override // com.baidu.live.r.a
    public void release() {
        zy();
    }

    private void bzg() {
        if (this.fFi == null) {
            this.fFi = new CustomMessageListener(2913221) { // from class: com.baidu.tieba.ala.charm.f.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof RedPacketCharmInfo)) {
                        f.this.a((RedPacketCharmInfo) customResponsedMessage.getData());
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.fFi);
        }
    }

    private void bzh() {
        if (this.fFi != null) {
            MessageManager.getInstance().unRegisterListener(this.fFi);
            this.fFi = null;
        }
    }

    private void bzi() {
        this.fFd = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
                return this.bba == PendantParentView.Model.VERTICAL ? 95 : 10;
            }
        };
        this.fFd.setBackgroundColor(0);
        if (this.fFc != null) {
            this.fFc.a(this.fFd, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        int i;
        if (!b(redPacketCharmInfo)) {
            reset(false);
            if (this.fFd != null) {
                this.fFd.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.fFd == null) {
            bzi();
        }
        if (this.fFe == null || (this.fFd != null && this.fFd.indexOfChild(this.fFe) < 0)) {
            this.fFe = new RedPacketCharmView(this.mContext);
            this.fFd.addView(this.fFe, new FrameLayout.LayoutParams(-2, -2));
            this.fFe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bzj();
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
        qK(i);
        this.fFe.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.fFe.qL(1);
                } else if (j > 10) {
                    this.fFe.qL(2);
                } else {
                    this.fFe.qL(3);
                }
                if (c(redPacketCharmInfo)) {
                    this.fFe.setCountDownTimer(String.valueOf(j), j.at(1000 * j));
                    dF(j * 1000);
                    break;
                }
                break;
            case 3:
                bzk();
                this.fFe.qL(4);
                break;
            default:
                this.fFe.qL(1);
                break;
        }
        this.fFf = redPacketCharmInfo;
        this.fFd.setVisibility(this.fFh ? 0 : 8);
        return true;
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzj() {
        if (this.avf != null && this.fFf != null) {
            bi biVar = new bi();
            biVar.aEW = this.fFf.id;
            biVar.liveId = String.valueOf(this.avf.mLiveInfo.live_id);
            biVar.aEX = String.valueOf(this.avf.ayC.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, biVar));
        }
    }

    private boolean c(RedPacketCharmInfo redPacketCharmInfo) {
        return this.fFf == null || TextUtils.isEmpty(this.fFf.id) || !this.fFf.id.equals(redPacketCharmInfo.id) || this.fFf.status != redPacketCharmInfo.status || this.fFf.startTime <= 0 || this.fFf.startTime != redPacketCharmInfo.startTime;
    }

    private void dF(long j) {
        bzk();
        this.fFg = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.4
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.fFe != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.fFe.setCountDownTimer(String.valueOf(round), j.at(1000 * round));
                    if (round > 10 && round <= 60) {
                        f.this.fFe.qL(2);
                    } else if (round <= 10) {
                        f.this.fFe.qL(3);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.fFe != null) {
                    f.this.fFe.qL(4);
                    if (f.this.fFf != null) {
                        f fVar = f.this;
                        if (f.this.fFf.count > 1) {
                            i = f.this.fFf.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.qK(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.fFg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(int i) {
        if (this.fFe != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.fFe.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bzk() {
        if (this.fFg != null) {
            this.fFg.cancel();
        }
    }

    private void reset(boolean z) {
        if (z) {
            bzh();
        }
        this.fFh = true;
        this.fFf = null;
        bzk();
        kb(z);
    }

    private void kb(boolean z) {
        if (this.fFe != null) {
            this.fFe.release();
            if (this.fFe.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fFe.getParent()).removeView(this.fFe);
            }
        }
        if (z && this.fFd != null && (this.fFd.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fFd.getParent()).removeView(this.fFd);
        }
    }
}
