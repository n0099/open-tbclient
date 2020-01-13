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
import com.baidu.live.data.as;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.utils.j;
/* loaded from: classes2.dex */
public class d implements com.baidu.live.n.a {
    private l aiW;
    private ViewGroup erT;
    private ViewGroup.LayoutParams erU;
    private ViewGroup erV;
    private RedPacketCharmView erW;
    private RedPacketCharmInfo erX;
    private CountDownTimer erY;
    private boolean erZ;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.n.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.erT = viewGroup;
        this.erU = layoutParams;
        bbB();
    }

    @Override // com.baidu.live.n.a
    public boolean h(l lVar) {
        int i;
        if (lVar == null || lVar.mLiveInfo == null) {
            return false;
        }
        this.aiW = lVar;
        RedPacketCharmInfo redPacketCharmInfo = lVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            return false;
        }
        if (this.erV == null || this.erT.indexOfChild(this.erV) < 0) {
            bbB();
            this.erV.setVisibility(this.erZ ? 0 : 8);
        }
        if (this.erW == null || (this.erV != null && this.erV.indexOfChild(this.erW) < 0)) {
            this.erW = new RedPacketCharmView(this.erV.getContext());
            this.erV.addView(this.erW, new FrameLayout.LayoutParams(-2, -2));
            this.erW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.bbC();
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
        oF(i);
        this.erW.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.erW.oG(1);
                } else {
                    this.erW.oG(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.erW.setCountDownTimer(String.valueOf(j), j.I(j * 1000));
                    cB(j * 1000);
                    break;
                }
                break;
            case 3:
                bbD();
                this.erW.oG(3);
                break;
            default:
                this.erW.oG(1);
                break;
        }
        this.erX = redPacketCharmInfo;
        return true;
    }

    @Override // com.baidu.live.n.a
    public void setCanVisible(boolean z) {
        this.erZ = z;
        if (this.erV != null) {
            this.erV.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.n.a
    public void bN(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.erV != null && (this.erV.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.erV.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.erV.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.n.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.erU = layoutParams;
        if (this.erV != null) {
            this.erV.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.n.a
    public void tz() {
        reset(true);
    }

    @Override // com.baidu.live.n.a
    public void release() {
        tz();
    }

    private void bbB() {
        this.erV = new FrameLayout(this.erT.getContext());
        this.erV.setBackgroundColor(0);
        this.erV.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.erT.addView(this.erV, this.erU);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbC() {
        if (this.aiW != null && this.erX != null) {
            as asVar = new as();
            asVar.abw = this.erX.id;
            asVar.liveId = String.valueOf(this.aiW.mLiveInfo.live_id);
            asVar.abx = String.valueOf(this.aiW.Wf.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, asVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.erX == null || TextUtils.isEmpty(this.erX.id) || !this.erX.id.equals(redPacketCharmInfo.id) || this.erX.status != redPacketCharmInfo.status || this.erX.startTime <= 0 || this.erX.startTime != redPacketCharmInfo.startTime;
    }

    private void cB(long j) {
        bbD();
        this.erY = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.d.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (d.this.erW != null) {
                    long round = Math.round(j2 / 1000.0d);
                    d.this.erW.setCountDownTimer(String.valueOf(round), j.I(1000 * round));
                    if (round <= 60) {
                        d.this.erW.oG(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (d.this.erW != null) {
                    d.this.erW.oG(3);
                    if (d.this.erX != null) {
                        d dVar = d.this;
                        if (d.this.erX.count > 1) {
                            i = d.this.erX.count - 1;
                        } else {
                            i = 0;
                        }
                        dVar.oF(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.erY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(int i) {
        if (this.erW != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.erW.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bbD() {
        if (this.erY != null) {
            this.erY.cancel();
        }
    }

    private void reset(boolean z) {
        this.erZ = true;
        this.erX = null;
        bbD();
        hL(z);
    }

    private void hL(boolean z) {
        if (this.erW != null) {
            this.erW.release();
            if (this.erW.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.erW.getParent()).removeView(this.erW);
            }
        }
        if (z && this.erV != null && (this.erV.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.erV.getParent()).removeView(this.erV);
        }
    }
}
