package com.baidu.tieba.ala.charm;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.bh;
import com.baidu.live.data.q;
import com.baidu.live.pendantview.PendantChildView;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.utils.j;
/* loaded from: classes3.dex */
public class f implements com.baidu.live.r.a {
    private q aLQ;
    private boolean fAa;
    private PendantParentView fzV;
    private PendantChildView fzW;
    private RedPacketCharmView fzX;
    private RedPacketCharmInfo fzY;
    private CountDownTimer fzZ;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.r.a
    public void n(ViewGroup viewGroup) {
        reset(true);
        if (viewGroup instanceof PendantParentView) {
            this.fzV = (PendantParentView) viewGroup;
            bvX();
        }
    }

    @Override // com.baidu.live.r.a
    public boolean o(q qVar) {
        int i;
        if (qVar == null || qVar.mLiveInfo == null) {
            if (this.fzW != null) {
                this.fzW.setVisibility(8);
                return false;
            }
            return false;
        }
        this.aLQ = qVar;
        RedPacketCharmInfo redPacketCharmInfo = qVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.fzW != null) {
                this.fzW.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.fzW == null) {
            bvX();
        }
        if (this.fzX == null || (this.fzW != null && this.fzW.indexOfChild(this.fzX) < 0)) {
            this.fzX = new RedPacketCharmView(this.mContext);
            this.fzW.addView(this.fzX, new FrameLayout.LayoutParams(-2, -2));
            this.fzX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bvY();
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
        qv(i);
        this.fzX.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.fzX.qw(1);
                } else {
                    this.fzX.qw(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.fzX.setCountDownTimer(String.valueOf(j), j.at(1000 * j));
                    dr(j * 1000);
                    break;
                }
                break;
            case 3:
                bvZ();
                this.fzX.qw(3);
                break;
            default:
                this.fzX.qw(1);
                break;
        }
        this.fzY = redPacketCharmInfo;
        this.fzW.setVisibility(this.fAa ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.r.a
    public void setCanVisible(boolean z) {
        this.fAa = z;
        if (this.fzW != null) {
            this.fzW.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.r.a
    public void cA(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.fzW != null && (this.fzW.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.fzW.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.fzW.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.r.a
    public void yW() {
        reset(true);
    }

    @Override // com.baidu.live.r.a
    public void release() {
        yW();
    }

    private void bvX() {
        this.fzW = new PendantChildView(this.mContext) { // from class: com.baidu.tieba.ala.charm.f.2
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
        this.fzW.setBackgroundColor(0);
        if (this.fzV != null) {
            this.fzV.a(this.fzW, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvY() {
        if (this.aLQ != null && this.fzY != null) {
            bh bhVar = new bh();
            bhVar.aDC = this.fzY.id;
            bhVar.liveId = String.valueOf(this.aLQ.mLiveInfo.live_id);
            bhVar.aDD = String.valueOf(this.aLQ.axp.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bhVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.fzY == null || TextUtils.isEmpty(this.fzY.id) || !this.fzY.id.equals(redPacketCharmInfo.id) || this.fzY.status != redPacketCharmInfo.status || this.fzY.startTime <= 0 || this.fzY.startTime != redPacketCharmInfo.startTime;
    }

    private void dr(long j) {
        bvZ();
        this.fzZ = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.3
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.fzX != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.fzX.setCountDownTimer(String.valueOf(round), j.at(1000 * round));
                    if (round <= 60) {
                        f.this.fzX.qw(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.fzX != null) {
                    f.this.fzX.qw(3);
                    if (f.this.fzY != null) {
                        f fVar = f.this;
                        if (f.this.fzY.count > 1) {
                            i = f.this.fzY.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.qv(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.fzZ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qv(int i) {
        if (this.fzX != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.fzX.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bvZ() {
        if (this.fzZ != null) {
            this.fzZ.cancel();
        }
    }

    private void reset(boolean z) {
        this.fAa = true;
        this.fzY = null;
        bvZ();
        jx(z);
    }

    private void jx(boolean z) {
        if (this.fzX != null) {
            this.fzX.release();
            if (this.fzX.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.fzX.getParent()).removeView(this.fzX);
            }
        }
        if (z && this.fzW != null && (this.fzW.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.fzW.getParent()).removeView(this.fzW);
        }
    }
}
