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
    private ab hfI;
    private AlaGuessPendantView hgB;
    private CountDownTimer hgC;
    private CustomMessageListener hgD;
    private ad hgF;
    private com.baidu.tieba.ala.live.guess.a hgH;
    private ForegroundColorSpan hgI;
    private Context mContext;
    private int hgE = com.baidu.tieba.ala.live.guess.a.a.hgh;
    private boolean hgG = false;
    private boolean isHost = false;
    private TimeCountTextView.a hgJ = new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.b.a.2
        @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
        public void onFinish() {
            if (a.this.hgF != null) {
                if (a.this.hgB != null && a.this.hgB.getImgActivity() != null && a.this.hgB.getTimerView() != null) {
                    a.this.hgB.getImgActivity().setImageResource(a.e.ala_guess_active_enter);
                    a.this.hgB.getTimerView().setVisibility(8);
                }
                a.this.hgG = true;
                a.this.bXA();
                a.this.bXz();
                a.this.Fi("抢券中");
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.guess.b.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hgF != null) {
                if (!a.this.hgG || TextUtils.isEmpty(a.this.hgF.aJz)) {
                    if (!TextUtils.isEmpty(a.this.hgF.url)) {
                        a.this.Hc(a.this.hgF.url);
                    }
                } else {
                    a.this.Hc(a.this.hgF.aJz);
                }
                if (a.this.hgH != null) {
                    a.this.hgH.Hb(a.this.isHost ? "author_liveroom" : "liveroom");
                }
            }
        }
    };

    @Override // com.baidu.live.guess.b
    public void a(ab abVar, ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.hfI = abVar;
            this.bRb = viewGroup;
            this.hgH = new com.baidu.tieba.ala.live.guess.a();
            registerListener();
        }
    }

    private void registerListener() {
        if (this.hgD == null) {
            this.hgD = new CustomMessageListener(2913275) { // from class: com.baidu.tieba.ala.live.guess.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        a.this.hgF = (ad) customResponsedMessage.getData();
                        a.this.bXt();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hgD);
    }

    private void removeListener() {
        if (this.hgD != null) {
            MessageManager.getInstance().unRegisterListener(this.hgD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXt() {
        if (this.hgF != null) {
            if (this.hgF.status == com.baidu.tieba.ala.live.guess.a.a.hgf && bXD() != com.baidu.tieba.ala.live.guess.a.a.hgh) {
                bXv();
                if (bXD() == com.baidu.tieba.ala.live.guess.a.a.hgi) {
                    showToast(a.h.ala_guess_active_finish);
                }
            } else if (this.hgF.status == com.baidu.tieba.ala.live.guess.a.a.hgd && this.hgF.aJx >= 0) {
                bXu();
            } else if (this.hgF.status == com.baidu.tieba.ala.live.guess.a.a.hge) {
                bXA();
            }
        }
    }

    public void bXu() {
        if (bXD() == com.baidu.tieba.ala.live.guess.a.a.hgh) {
            bXx();
            uG(this.hgF.aJx * 1000);
        } else if (bXD() == com.baidu.tieba.ala.live.guess.a.a.hgg && this.hgF.aJy) {
            uG(this.hgF.aJx * 1000);
        } else if (bXD() == com.baidu.tieba.ala.live.guess.a.a.hgd && this.hgF.status == com.baidu.tieba.ala.live.guess.a.a.hge) {
            uH(this.hgF.status);
        }
    }

    @Override // com.baidu.live.guess.b
    public void IZ() {
        Jb();
        bXv();
        removeListener();
    }

    @Override // com.baidu.live.guess.b
    public void init(Context context, boolean z) {
        this.mContext = context;
        this.isHost = z;
    }

    public void bXv() {
        uH(com.baidu.tieba.ala.live.guess.a.a.hgh);
        if (this.hgB != null && this.bRb != null) {
            this.hgB.removeView();
            this.bRb.removeView(this.hgB);
            this.hgB = null;
        }
    }

    public void Jb() {
        if (this.hgC != null) {
            this.hgC.cancel();
        }
        if (this.hgB != null && this.hgB.getTimerView() != null) {
            this.hgB.getTimerView().cancel();
        }
    }

    private AlaGuessPendantView bXw() {
        if (this.hgB == null) {
            this.hgB = new AlaGuessPendantView(this.mContext);
            this.hgB.e(new FrameLayout.LayoutParams(-2, -2));
            this.hgB.c(this.mOnClickListener);
            this.hgB.getTvCountDown().setVisibility(0);
        }
        return this.hgB;
    }

    public void bXx() {
        if (this.bRb != null) {
            if (this.bRb instanceof PendantParentView) {
                ((PendantParentView) this.bRb).a(bXw(), bXy());
            } else {
                this.bRb.addView(bXw());
            }
            if (this.hgH != null) {
                this.hgH.Ha(this.isHost ? "author_liveroom" : "liveroom");
            }
            uH(com.baidu.tieba.ala.live.guess.a.a.hgg);
        }
    }

    private LinearLayout.LayoutParams bXy() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.sdk_ds20);
        layoutParams.setMargins(0, dimension, dimension, 0);
        return layoutParams;
    }

    private void uG(int i) {
        if (this.hgC != null) {
            this.hgC.cancel();
            this.hgC = null;
        }
        this.hgC = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.ala.live.guess.b.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (a.this.hgB != null && a.this.hgB.getTvCountDown() != null) {
                    a.this.hgG = false;
                    long round = Math.round(j / 1000.0d);
                    if (round <= 30) {
                        if (a.this.hgI == null) {
                            a.this.hgI = new ForegroundColorSpan(a.this.mContext.getResources().getColor(a.c.ala_guess_act_text_color));
                        }
                        String bw = k.bw(round * 1000);
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bw);
                        spannableStringBuilder.setSpan(a.this.hgI, 0, bw.length(), 34);
                        a.this.s(spannableStringBuilder);
                        return;
                    }
                    a.this.Fi(k.bw(round * 1000));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.bXA();
                a.this.bXz();
                a.this.Fi("抢券中");
            }
        };
        this.hgC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXz() {
        this.hgB.getTvCountDown().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fi(String str) {
        this.hgB.getTvCountDown().setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(CharSequence charSequence) {
        this.hgB.getTvCountDown().setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXA() {
        this.hgG = true;
        if (bXD() != com.baidu.tieba.ala.live.guess.a.a.hgi) {
            if (this.hgC != null) {
                this.hgC.cancel();
            }
            if (bXD() == com.baidu.tieba.ala.live.guess.a.a.hgh) {
                bXx();
            }
            Fi("抢券中");
            uH(com.baidu.tieba.ala.live.guess.a.a.hgi);
        }
    }

    private String bXB() {
        return this.isHost ? "is_host=1" : "is_host=0";
    }

    private String bXC() {
        if (this.hfI == null || this.hfI.aIz == null || this.hfI.mLiveInfo == null) {
            return "";
        }
        return "&anchor_author_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(this.hfI.aId.userId)) + "&room_id=" + this.hfI.mLiveInfo.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
            return;
        }
        c cVar = new c();
        cVar.url = str + bXB() + bXC();
        cVar.isFullScreen = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    private void uH(int i) {
        this.hgE = i;
    }

    public int bXD() {
        return this.hgE;
    }

    private void showToast(int i) {
        if (this.mContext != null) {
            BdUtilHelper.showToast(this.mContext, i);
        }
    }
}
