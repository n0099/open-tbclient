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
import com.baidu.live.data.au;
import com.baidu.live.data.m;
import com.baidu.live.u.a;
import com.baidu.live.utils.j;
/* loaded from: classes3.dex */
public class d implements com.baidu.live.q.a {
    private m ald;
    private ViewGroup ewd;
    private ViewGroup.LayoutParams ewe;
    private ViewGroup ewf;
    private RedPacketCharmView ewg;
    private RedPacketCharmInfo ewh;
    private CountDownTimer ewi;
    private boolean ewj;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.q.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        reset(true);
        this.ewd = viewGroup;
        this.ewe = layoutParams;
        bdQ();
    }

    @Override // com.baidu.live.q.a
    public boolean m(m mVar) {
        int i;
        if (mVar == null || mVar.mLiveInfo == null) {
            if (this.ewf != null) {
                this.ewf.setVisibility(8);
                return false;
            }
            return false;
        }
        this.ald = mVar;
        RedPacketCharmInfo redPacketCharmInfo = mVar.mLiveInfo.redpacketCharmInfo;
        if (!a(redPacketCharmInfo)) {
            reset(false);
            if (this.ewf != null) {
                this.ewf.setVisibility(8);
                return false;
            }
            return false;
        }
        if (this.ewf == null || this.ewd.indexOfChild(this.ewf) < 0) {
            bdQ();
        }
        if (this.ewg == null || (this.ewf != null && this.ewf.indexOfChild(this.ewg) < 0)) {
            this.ewg = new RedPacketCharmView(this.ewf.getContext());
            this.ewf.addView(this.ewg, new FrameLayout.LayoutParams(-2, -2));
            this.ewg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    d.this.bdR();
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
        oW(i);
        this.ewg.setAvatar(redPacketCharmInfo.senderAvatar);
        switch (redPacketCharmInfo.status) {
            case 2:
                if (j > 60) {
                    this.ewg.oX(1);
                } else {
                    this.ewg.oX(2);
                }
                if (b(redPacketCharmInfo)) {
                    this.ewg.setCountDownTimer(String.valueOf(j), j.M(1000 * j));
                    cE(j * 1000);
                    break;
                }
                break;
            case 3:
                bdS();
                this.ewg.oX(3);
                break;
            default:
                this.ewg.oX(1);
                break;
        }
        this.ewh = redPacketCharmInfo;
        this.ewf.setVisibility(this.ewj ? 0 : 8);
        return true;
    }

    @Override // com.baidu.live.q.a
    public void setCanVisible(boolean z) {
        this.ewj = z;
        if (this.ewf != null) {
            this.ewf.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.live.q.a
    public void bW(int i) {
        LinearLayout.LayoutParams layoutParams;
        int dimensionPixelOffset;
        if (this.ewf != null && (this.ewf.getLayoutParams() instanceof LinearLayout.LayoutParams) && (layoutParams = (LinearLayout.LayoutParams) this.ewf.getLayoutParams()) != null) {
            if (i == 2) {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
            } else {
                dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            }
            layoutParams.topMargin = dimensionPixelOffset;
            this.ewf.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void b(ViewGroup.LayoutParams layoutParams) {
        this.ewe = layoutParams;
        if (this.ewf != null) {
            this.ewf.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.live.q.a
    public void sL() {
        reset(true);
    }

    @Override // com.baidu.live.q.a
    public void release() {
        sL();
    }

    private void bdQ() {
        this.ewf = new FrameLayout(this.ewd.getContext());
        this.ewf.setBackgroundColor(0);
        this.ewf.setTag(a.g.sdk_pvl_layout_priority_tag_key, 3);
        this.ewd.addView(this.ewf, this.ewe);
    }

    private boolean a(RedPacketCharmInfo redPacketCharmInfo) {
        return (redPacketCharmInfo == null || TextUtils.isEmpty(redPacketCharmInfo.id) || (redPacketCharmInfo.status != 2 && redPacketCharmInfo.status != 3) || redPacketCharmInfo.count <= 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdR() {
        if (this.ald != null && this.ewh != null) {
            au auVar = new au();
            auVar.adB = this.ewh.id;
            auVar.liveId = String.valueOf(this.ald.mLiveInfo.live_id);
            auVar.adC = String.valueOf(this.ald.XQ.userId);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913134, auVar));
        }
    }

    private boolean b(RedPacketCharmInfo redPacketCharmInfo) {
        return this.ewh == null || TextUtils.isEmpty(this.ewh.id) || !this.ewh.id.equals(redPacketCharmInfo.id) || this.ewh.status != redPacketCharmInfo.status || this.ewh.startTime <= 0 || this.ewh.startTime != redPacketCharmInfo.startTime;
    }

    private void cE(long j) {
        bdS();
        this.ewi = new CountDownTimer(j, 1000L) { // from class: com.baidu.tieba.ala.charm.d.2
            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                if (d.this.ewg != null) {
                    long round = Math.round(j2 / 1000.0d);
                    d.this.ewg.setCountDownTimer(String.valueOf(round), j.M(1000 * round));
                    if (round <= 60) {
                        d.this.ewg.oX(2);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, Long.valueOf(round)));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                int i;
                if (d.this.ewg != null) {
                    d.this.ewg.oX(3);
                    if (d.this.ewh != null) {
                        d dVar = d.this;
                        if (d.this.ewh.count > 1) {
                            i = d.this.ewh.count - 1;
                        } else {
                            i = 0;
                        }
                        dVar.oW(i);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913133, 0L));
                }
            }
        };
        this.ewi.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oW(int i) {
        if (this.ewg != null) {
            String str = "";
            if (i > 99) {
                str = "99+";
            } else if (i >= 1) {
                str = String.valueOf(i);
            }
            this.ewg.setBadge(TextUtils.isEmpty(str) ? false : true, str);
        }
    }

    private void bdS() {
        if (this.ewi != null) {
            this.ewi.cancel();
        }
    }

    private void reset(boolean z) {
        this.ewj = true;
        this.ewh = null;
        bdS();
        hS(z);
    }

    private void hS(boolean z) {
        if (this.ewg != null) {
            this.ewg.release();
            if (this.ewg.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.ewg.getParent()).removeView(this.ewg);
            }
        }
        if (z && this.ewf != null && (this.ewf.getParent() instanceof ViewGroup)) {
            ((ViewGroup) this.ewf.getParent()).removeView(this.ewf);
        }
    }
}
