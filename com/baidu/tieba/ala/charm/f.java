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
    private RedPacketCharmView foA;
    private RedPacketCharmInfo foB;
    private CountDownTimer foC;
    private boolean foD;
    private ViewGroup fox;
    private ViewGroup.LayoutParams foy;
    private ViewGroup foz;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.fox = viewGroup;
        this.foy = layoutParams;
        bta();
    }

    @Override // com.baidu.live.q.a
    public boolean m(q qVar) {
        int i;
        if (qVar == null || qVar.mLiveInfo == null) {
            if (this.foz != null) {
                this.foz.setVisibility(8);
                return false;
            }
            return false;
        }
        this.aJj = qVar;
        RedPacketCharmInfo redPacketCharmInfo = qVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.foz != null) {
                this.foz.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.foz == null || this.fox.indexOfChild(this.foz) < 0) {
            bta();
        }
        if (this.foA == null || (this.foz != null && this.foz.indexOfChild(this.foA) < 0)) {
            this.foA = new RedPacketCharmView(this.foz.getContext());
            this.foz.addView(this.foA, new FrameLayout.LayoutParams(-2, -2));
            this.foA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.btb();
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
        pU(i);
        this.foA.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.foA.pV(1);
                } else {
                    this.foA.pV(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.foA.setCountDownTimer(String.valueOf(j), j.at(1000 * j));
                    m32do(j * 1000);
                    break;
                }
                break;
            case 3:
                btc();
                this.foA.pV(3);
                break;
            default:
                this.foA.pV(1);
                break;
        }
        this.foB = redPacketCharmInfo;
        this.foz.setVisibility(this.foD ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.foD = z;
        if (this.foz != null) {
            this.foz.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void cs(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.foz != null && (this.foz.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.foz.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.foz.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.foy = layoutParams;
        if (this.foz != null) {
            this.foz.setLayoutParams(layoutParams);
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

    private void bta() {
        this.foz = new FrameLayout(this.fox.getContext());
        this.foz.setBackgroundColor(0);
        this.foz.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.fox.addView(this.foz, this.foy);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btb() {
        if (this.aJj != null && this.foB != null) {
            bc bcVar = new bc();
            bcVar.aBr = this.foB.id;
            bcVar.liveId = String.valueOf(this.aJj.mLiveInfo.live_id);
            bcVar.aBs = String.valueOf(this.aJj.avj.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, bcVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.foB == null || TextUtils.isEmpty(this.foB.id) || !this.foB.id.equals(redPacketCharmInfo.id) || this.foB.status != redPacketCharmInfo.status || this.foB.startTime <= 0 || this.foB.startTime != redPacketCharmInfo.startTime;
    }

    /* renamed from: do  reason: not valid java name */
    private void m32do(long j) {
        btc();
        this.foC = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.foA != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.foA.setCountDownTimer(String.valueOf(round), j.at(1000 * round));
                    if (round <= 60) {
                        f.this.foA.pV(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.foA != null) {
                    f.this.foA.pV(3);
                    if (f.this.foB != null) {
                        f fVar = f.this;
                        if (f.this.foB.count > 1) {
                            i = f.this.foB.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.pU(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.foC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU(int i) {
        if (this.foA != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.foA.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void btc() {
        if (this.foC != null) {
            this.foC.cancel();
        }
    }

    private void reset(boolean z) {
        this.foD = true;
        this.foB = null;
        btc();
        jk(z);
    }

    private void jk(boolean z) {
        if (this.foA != null) {
            this.foA.release();
            if (this.foA.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.foA.getParent()).removeView(this.foA);
            }
        }
        if (z && this.foz != null && (this.foz.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.foz.getParent()).removeView(this.foz);
        }
    }
}
