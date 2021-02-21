package com.baidu.tieba.ala.live.guess.b;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.an.c;
import com.baidu.live.data.ab;
import com.baidu.live.data.ad;
import com.baidu.live.guess.b;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.live.guess.view.gift.AlaGuessPendantView;
import com.baidu.tieba.ala.live.guess.widget.TimeCountTextView;
/* loaded from: classes11.dex */
public class a implements b {
    private ViewGroup bRb;
    private ab hfW;
    private AlaGuessPendantView hgP;
    private CountDownTimer hgQ;
    private CustomMessageListener hgR;
    private ad hgT;
    private com.baidu.tieba.ala.live.guess.a hgV;
    private ForegroundColorSpan hgW;
    private Context mContext;
    private int hgS = com.baidu.tieba.ala.live.guess.a.a.hgv;
    private boolean hgU = false;
    private boolean isHost = false;
    private TimeCountTextView.a hgX = new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.b.a.2
        @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
        public void onFinish() {
            if (a.this.hgT != null) {
                if (a.this.hgP != null && a.this.hgP.getImgActivity() != null && a.this.hgP.getTimerView() != null) {
                    a.this.hgP.getImgActivity().setImageResource(a.e.ala_guess_active_enter);
                    a.this.hgP.getTimerView().setVisibility(8);
                }
                a.this.hgU = true;
                a.this.bXH();
                a.this.bXG();
                a.this.Fj("抢券中");
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.guess.b.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hgT != null) {
                if (!a.this.hgU || TextUtils.isEmpty(a.this.hgT.aJz)) {
                    if (!TextUtils.isEmpty(a.this.hgT.url)) {
                        a.this.Hd(a.this.hgT.url);
                    }
                } else {
                    a.this.Hd(a.this.hgT.aJz);
                }
                if (a.this.hgV != null) {
                    a.this.hgV.Hc(a.this.isHost ? "author_liveroom" : "liveroom");
                }
            }
        }
    };

    @Override // com.baidu.live.guess.b
    public void a(ab abVar, ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.hfW = abVar;
            this.bRb = viewGroup;
            this.hgV = new com.baidu.tieba.ala.live.guess.a();
            registerListener();
        }
    }

    private void registerListener() {
        if (this.hgR == null) {
            this.hgR = new CustomMessageListener(2913275) { // from class: com.baidu.tieba.ala.live.guess.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        a.this.hgT = (ad) customResponsedMessage.getData();
                        a.this.bXA();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hgR);
    }

    private void removeListener() {
        if (this.hgR != null) {
            MessageManager.getInstance().unRegisterListener(this.hgR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXA() {
        if (this.hgT != null) {
            if (this.hgT.status == com.baidu.tieba.ala.live.guess.a.a.hgt && bXK() != com.baidu.tieba.ala.live.guess.a.a.hgv) {
                bXC();
                if (bXK() == com.baidu.tieba.ala.live.guess.a.a.hgw) {
                    showToast(a.h.ala_guess_active_finish);
                }
            } else if (this.hgT.status == com.baidu.tieba.ala.live.guess.a.a.hgr && this.hgT.aJx >= 0) {
                bXB();
            } else if (this.hgT.status == com.baidu.tieba.ala.live.guess.a.a.hgs) {
                bXH();
            }
        }
    }

    public void bXB() {
        if (bXK() == com.baidu.tieba.ala.live.guess.a.a.hgv) {
            bXE();
            uG(this.hgT.aJx * 1000);
        } else if (bXK() == com.baidu.tieba.ala.live.guess.a.a.hgu && this.hgT.aJy) {
            uG(this.hgT.aJx * 1000);
        } else if (bXK() == com.baidu.tieba.ala.live.guess.a.a.hgr && this.hgT.status == com.baidu.tieba.ala.live.guess.a.a.hgs) {
            uH(this.hgT.status);
        }
    }

    @Override // com.baidu.live.guess.b
    public void IZ() {
        Jb();
        bXC();
        removeListener();
    }

    @Override // com.baidu.live.guess.b
    public void init(Context context, boolean z) {
        this.mContext = context;
        this.isHost = z;
    }

    public void bXC() {
        uH(com.baidu.tieba.ala.live.guess.a.a.hgv);
        if (this.hgP != null && this.bRb != null) {
            this.hgP.removeView();
            this.bRb.removeView(this.hgP);
            this.hgP = null;
        }
    }

    public void Jb() {
        if (this.hgQ != null) {
            this.hgQ.cancel();
        }
        if (this.hgP != null && this.hgP.getTimerView() != null) {
            this.hgP.getTimerView().cancel();
        }
    }

    private AlaGuessPendantView bXD() {
        if (this.hgP == null) {
            this.hgP = new AlaGuessPendantView(this.mContext);
            this.hgP.e(new FrameLayout.LayoutParams(-2, -2));
            this.hgP.c(this.mOnClickListener);
            this.hgP.getTvCountDown().setVisibility(0);
        }
        return this.hgP;
    }

    public void bXE() {
        if (this.bRb != null) {
            if (this.bRb instanceof PendantParentView) {
                ((PendantParentView) this.bRb).a(bXD(), bXF());
            } else {
                this.bRb.addView(bXD());
            }
            if (this.hgV != null) {
                this.hgV.Hb(this.isHost ? "author_liveroom" : "liveroom");
            }
            uH(com.baidu.tieba.ala.live.guess.a.a.hgu);
        }
    }

    private LinearLayout.LayoutParams bXF() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.sdk_ds20);
        layoutParams.setMargins(0, dimension, dimension, 0);
        return layoutParams;
    }

    private void uG(int i) {
        if (this.hgQ != null) {
            this.hgQ.cancel();
            this.hgQ = null;
        }
        this.hgQ = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.ala.live.guess.b.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (a.this.hgP != null && a.this.hgP.getTvCountDown() != null) {
                    a.this.hgU = false;
                    long round = Math.round(j / 1000.0d);
                    if (round <= 30) {
                        if (a.this.hgW == null) {
                            a.this.hgW = new ForegroundColorSpan(a.this.mContext.getResources().getColor(a.c.ala_guess_act_text_color));
                        }
                        String bw = k.bw(round * 1000);
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bw);
                        spannableStringBuilder.setSpan(a.this.hgW, 0, bw.length(), 34);
                        a.this.s(spannableStringBuilder);
                        return;
                    }
                    a.this.Fj(k.bw(round * 1000));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.bXH();
                a.this.bXG();
                a.this.Fj("抢券中");
            }
        };
        this.hgQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXG() {
        this.hgP.getTvCountDown().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fj(String str) {
        this.hgP.getTvCountDown().setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(CharSequence charSequence) {
        this.hgP.getTvCountDown().setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXH() {
        this.hgU = true;
        if (bXK() != com.baidu.tieba.ala.live.guess.a.a.hgw) {
            if (this.hgQ != null) {
                this.hgQ.cancel();
            }
            if (bXK() == com.baidu.tieba.ala.live.guess.a.a.hgv) {
                bXE();
            }
            Fj("抢券中");
            uH(com.baidu.tieba.ala.live.guess.a.a.hgw);
        }
    }

    private String bXI() {
        return this.isHost ? "is_host=1" : "is_host=0";
    }

    private String bXJ() {
        if (this.hfW == null || this.hfW.aIz == null || this.hfW.mLiveInfo == null) {
            return "";
        }
        return "&anchor_author_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(this.hfW.aId.userId)) + "&room_id=" + this.hfW.mLiveInfo.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
            return;
        }
        c cVar = new c();
        cVar.url = str + bXI() + bXJ();
        cVar.isFullScreen = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    private void uH(int i) {
        this.hgS = i;
    }

    public int bXK() {
        return this.hgS;
    }

    private void showToast(int i) {
        if (this.mContext != null) {
            BdUtilHelper.showToast(this.mContext, i);
        }
    }
}
