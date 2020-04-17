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
import com.baidu.live.data.ax;
import com.baidu.live.data.n;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
/* loaded from: classes3.dex */
public class f implements com.baidu.live.q.a {
    private n aDE;
    private ViewGroup faQ;
    private ViewGroup.LayoutParams faR;
    private ViewGroup faS;
    private RedPacketCharmView faT;
    private RedPacketCharmInfo faU;
    private CountDownTimer faV;
    private boolean faW;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.faQ = viewGroup;
        this.faR = layoutParams;
        bnk();
    }

    @Override // com.baidu.live.q.a
    public boolean m(n nVar) {
        int i;
        if (nVar == null || nVar.mLiveInfo == null) {
            if (this.faS != null) {
                this.faS.setVisibility(8);
                return false;
            }
            return false;
        }
        this.aDE = nVar;
        RedPacketCharmInfo redPacketCharmInfo = nVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.faS != null) {
                this.faS.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.faS == null || this.faQ.indexOfChild(this.faS) < 0) {
            bnk();
        }
        if (this.faT == null || (this.faS != null && this.faS.indexOfChild(this.faT) < 0)) {
            this.faT = new RedPacketCharmView(this.faS.getContext());
            this.faS.addView(this.faT, new FrameLayout.LayoutParams(-2, -2));
            this.faT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bnl();
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
        pt(i);
        this.faT.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.faT.pu(1);
                } else {
                    this.faT.pu(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.faT.setCountDownTimer(String.valueOf(j), j.ao(1000 * j));
                    dm(j * 1000);
                    break;
                }
                break;
            case 3:
                bnm();
                this.faT.pu(3);
                break;
            default:
                this.faT.pu(1);
                break;
        }
        this.faU = redPacketCharmInfo;
        this.faS.setVisibility(this.faW ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.faW = z;
        if (this.faS != null) {
            this.faS.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void cl(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.faS != null && (this.faS.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.faS.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.faS.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.faR = layoutParams;
        if (this.faS != null) {
            this.faS.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void xj() {
        reset(true);
    }

    @Override // com.baidu.live.q.a
    public void release() {
        xj();
    }

    private void bnk() {
        this.faS = new FrameLayout(this.faQ.getContext());
        this.faS.setBackgroundColor(0);
        this.faS.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.faQ.addView(this.faS, this.faR);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnl() {
        if (this.aDE != null && this.faU != null) {
            ax axVar = new ax();
            axVar.awc = this.faU.id;
            axVar.liveId = String.valueOf(this.aDE.mLiveInfo.live_id);
            axVar.awd = String.valueOf(this.aDE.aqe.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, axVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.faU == null || TextUtils.isEmpty(this.faU.id) || !this.faU.id.equals(redPacketCharmInfo.id) || this.faU.status != redPacketCharmInfo.status || this.faU.startTime <= 0 || this.faU.startTime != redPacketCharmInfo.startTime;
    }

    private void dm(long j) {
        bnm();
        this.faV = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.faT != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.faT.setCountDownTimer(String.valueOf(round), j.ao(1000 * round));
                    if (round <= 60) {
                        f.this.faT.pu(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.faT != null) {
                    f.this.faT.pu(3);
                    if (f.this.faU != null) {
                        f fVar = f.this;
                        if (f.this.faU.count > 1) {
                            i = f.this.faU.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.pt(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.faV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(int i) {
        if (this.faT != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.faT.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bnm() {
        if (this.faV != null) {
            this.faV.cancel();
        }
    }

    private void reset(boolean z) {
        this.faW = true;
        this.faU = null;
        bnm();
        iS(z);
    }

    private void iS(boolean z) {
        if (this.faT != null) {
            this.faT.release();
            if (this.faT.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.faT.getParent()).removeView(this.faT);
            }
        }
        if (z && this.faS != null && (this.faS.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.faS.getParent()).removeView(this.faS);
        }
    }
}
