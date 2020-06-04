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
import com.baidu.live.data.bc;
import com.baidu.live.data.q;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
/* loaded from: classes3.dex */
public class f implements com.baidu.live.q.a {
    private q aJj;
    private ViewGroup foI;
    private ViewGroup.LayoutParams foJ;
    private ViewGroup foK;
    private RedPacketCharmView foL;
    private RedPacketCharmInfo foM;
    private CountDownTimer foN;
    private boolean foO;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.foI = viewGroup;
        this.foJ = layoutParams;
        btc();
    }

    @Override // com.baidu.live.q.a
    public boolean m(q qVar) {
        int i;
        if (qVar == null || qVar.mLiveInfo == null) {
            if (this.foK != null) {
                this.foK.setVisibility(8);
                return false;
            }
            return false;
        }
        this.aJj = qVar;
        RedPacketCharmInfo redPacketCharmInfo = qVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.foK != null) {
                this.foK.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.foK == null || this.foI.indexOfChild(this.foK) < 0) {
            btc();
        }
        if (this.foL == null || (this.foK != null && this.foK.indexOfChild(this.foL) < 0)) {
            this.foL = new RedPacketCharmView(this.foK.getContext());
            this.foK.addView(this.foL, new FrameLayout.LayoutParams(-2, -2));
            this.foL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.btd();
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
        pW(i);
        this.foL.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.foL.pX(1);
                } else {
                    this.foL.pX(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.foL.setCountDownTimer(String.valueOf(j), j.at(1000 * j));
                    m32do(j * 1000);
                    break;
                }
                break;
            case 3:
                bte();
                this.foL.pX(3);
                break;
            default:
                this.foL.pX(1);
                break;
        }
        this.foM = redPacketCharmInfo;
        this.foK.setVisibility(this.foO ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.foO = z;
        if (this.foK != null) {
            this.foK.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void cu(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.foK != null && (this.foK.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.foK.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.foK.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.foJ = layoutParams;
        if (this.foK != null) {
            this.foK.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void yw() {
        reset(true);
    }

    @Override // com.baidu.live.q.a
    public void release() {
        yw();
    }

    private void btc() {
        this.foK = new FrameLayout(this.foI.getContext());
        this.foK.setBackgroundColor(0);
        this.foK.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.foI.addView(this.foK, this.foJ);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btd() {
        if (this.aJj != null && this.foM != null) {
            bc bcVar = new bc();
            bcVar.aBr = this.foM.id;
            bcVar.liveId = String.valueOf(this.aJj.mLiveInfo.live_id);
            bcVar.aBs = String.valueOf(this.aJj.avj.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bcVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.foM == null || TextUtils.isEmpty(this.foM.id) || !this.foM.id.equals(redPacketCharmInfo.id) || this.foM.status != redPacketCharmInfo.status || this.foM.startTime <= 0 || this.foM.startTime != redPacketCharmInfo.startTime;
    }

    /* renamed from: do  reason: not valid java name */
    private void m32do(long j) {
        bte();
        this.foN = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.foL != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.foL.setCountDownTimer(String.valueOf(round), j.at(1000 * round));
                    if (round <= 60) {
                        f.this.foL.pX(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.foL != null) {
                    f.this.foL.pX(3);
                    if (f.this.foM != null) {
                        f fVar = f.this;
                        if (f.this.foM.count > 1) {
                            i = f.this.foM.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.pW(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.foN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pW(int i) {
        if (this.foL != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.foL.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bte() {
        if (this.foN != null) {
            this.foN.cancel();
        }
    }

    private void reset(boolean z) {
        this.foO = true;
        this.foM = null;
        bte();
        jk(z);
    }

    private void jk(boolean z) {
        if (this.foL != null) {
            this.foL.release();
            if (this.foL.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.foL.getParent()).removeView(this.foL);
            }
        }
        if (z && this.foK != null && (this.foK.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.foK.getParent()).removeView(this.foK);
        }
    }
}
