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
    private n aDK;
    private ViewGroup faV;
    private ViewGroup.LayoutParams faW;
    private ViewGroup faX;
    private RedPacketCharmView faY;
    private RedPacketCharmInfo faZ;
    private CountDownTimer fba;
    private boolean fbb;
    private Context mContext;

    public f(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.faV = viewGroup;
        this.faW = layoutParams;
        bni();
    }

    @Override // com.baidu.live.q.a
    public boolean m(n nVar) {
        int i;
        if (nVar == null || nVar.mLiveInfo == null) {
            if (this.faX != null) {
                this.faX.setVisibility(8);
                return false;
            }
            return false;
        }
        this.aDK = nVar;
        RedPacketCharmInfo redPacketCharmInfo = nVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.faX != null) {
                this.faX.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.faX == null || this.faV.indexOfChild(this.faX) < 0) {
            bni();
        }
        if (this.faY == null || (this.faX != null && this.faX.indexOfChild(this.faY) < 0)) {
            this.faY = new RedPacketCharmView(this.faX.getContext());
            this.faX.addView(this.faY, new FrameLayout.LayoutParams(-2, -2));
            this.faY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    f.this.bnj();
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
        this.faY.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.faY.pu(1);
                } else {
                    this.faY.pu(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.faY.setCountDownTimer(String.valueOf(j), j.ao(1000 * j));
                    dm(j * 1000);
                    break;
                }
                break;
            case 3:
                bnk();
                this.faY.pu(3);
                break;
            default:
                this.faY.pu(1);
                break;
        }
        this.faZ = redPacketCharmInfo;
        this.faX.setVisibility(this.fbb ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.fbb = z;
        if (this.faX != null) {
            this.faX.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void cl(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.faX != null && (this.faX.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.faX.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.faX.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.faW = layoutParams;
        if (this.faX != null) {
            this.faX.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void xi() {
        reset(true);
    }

    @Override // com.baidu.live.q.a
    public void release() {
        xi();
    }

    private void bni() {
        this.faX = new FrameLayout(this.faV.getContext());
        this.faX.setBackgroundColor(0);
        this.faX.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.faV.addView(this.faX, this.faW);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnj() {
        if (this.aDK != null && this.faZ != null) {
            ax axVar = new ax();
            axVar.awi = this.faZ.id;
            axVar.liveId = String.valueOf(this.aDK.mLiveInfo.live_id);
            axVar.awj = String.valueOf(this.aDK.aqk.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, axVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.faZ == null || TextUtils.isEmpty(this.faZ.id) || !this.faZ.id.equals(redPacketCharmInfo.id) || this.faZ.status != redPacketCharmInfo.status || this.faZ.startTime <= 0 || this.faZ.startTime != redPacketCharmInfo.startTime;
    }

    private void dm(long j) {
        bnk();
        this.fba = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (f.this.faY != null) {
                    long round = Math.round(j2 / 1000.0d);
                    f.this.faY.setCountDownTimer(String.valueOf(round), j.ao(1000 * round));
                    if (round <= 60) {
                        f.this.faY.pu(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (f.this.faY != null) {
                    f.this.faY.pu(3);
                    if (f.this.faZ != null) {
                        f fVar = f.this;
                        if (f.this.faZ.count > 1) {
                            i = f.this.faZ.count - 1;
                        } else {
                            i = 0;
                        }
                        fVar.pt(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.fba.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pt(int i) {
        if (this.faY != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.faY.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bnk() {
        if (this.fba != null) {
            this.fba.cancel();
        }
    }

    private void reset(boolean z) {
        this.fbb = true;
        this.faZ = null;
        bnk();
        iS(z);
    }

    private void iS(boolean z) {
        if (this.faY != null) {
            this.faY.release();
            if (this.faY.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.faY.getParent()).removeView(this.faY);
            }
        }
        if (z && this.faX != null && (this.faX.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.faX.getParent()).removeView(this.faX);
        }
    }
}
