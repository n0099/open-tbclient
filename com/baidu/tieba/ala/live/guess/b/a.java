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
/* loaded from: classes10.dex */
public class a implements b {
    private ViewGroup bSB;
    private ab hhF;
    private CountDownTimer hiA;
    private CustomMessageListener hiB;
    private ad hiD;
    private com.baidu.tieba.ala.live.guess.a hiF;
    private ForegroundColorSpan hiG;
    private AlaGuessPendantView hiz;
    private Context mContext;
    private int hiC = com.baidu.tieba.ala.live.guess.a.a.hif;
    private boolean hiE = false;
    private boolean isHost = false;
    private TimeCountTextView.a hiH = new TimeCountTextView.a() { // from class: com.baidu.tieba.ala.live.guess.b.a.2
        @Override // com.baidu.tieba.ala.live.guess.widget.TimeCountTextView.a
        public void onFinish() {
            if (a.this.hiD != null) {
                if (a.this.hiz != null && a.this.hiz.getImgActivity() != null && a.this.hiz.getTimerView() != null) {
                    a.this.hiz.getImgActivity().setImageResource(a.e.ala_guess_active_enter);
                    a.this.hiz.getTimerView().setVisibility(8);
                }
                a.this.hiE = true;
                a.this.bXN();
                a.this.bXM();
                a.this.Fq("抢券中");
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.guess.b.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.hiD != null) {
                if (!a.this.hiE || TextUtils.isEmpty(a.this.hiD.aKZ)) {
                    if (!TextUtils.isEmpty(a.this.hiD.url)) {
                        a.this.Hm(a.this.hiD.url);
                    }
                } else {
                    a.this.Hm(a.this.hiD.aKZ);
                }
                if (a.this.hiF != null) {
                    a.this.hiF.Hl(a.this.isHost ? "author_liveroom" : "liveroom");
                }
            }
        }
    };

    @Override // com.baidu.live.guess.b
    public void a(ab abVar, ViewGroup viewGroup) {
        if (viewGroup != null) {
            this.hhF = abVar;
            this.bSB = viewGroup;
            this.hiF = new com.baidu.tieba.ala.live.guess.a();
            registerListener();
        }
    }

    private void registerListener() {
        if (this.hiB == null) {
            this.hiB = new CustomMessageListener(2913275) { // from class: com.baidu.tieba.ala.live.guess.b.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null) {
                        a.this.hiD = (ad) customResponsedMessage.getData();
                        a.this.bXG();
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hiB);
    }

    private void removeListener() {
        if (this.hiB != null) {
            MessageManager.getInstance().unRegisterListener(this.hiB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXG() {
        if (this.hiD != null) {
            if (this.hiD.status == com.baidu.tieba.ala.live.guess.a.a.hic && bXQ() != com.baidu.tieba.ala.live.guess.a.a.hif) {
                bXI();
                if (bXQ() == com.baidu.tieba.ala.live.guess.a.a.hig) {
                    showToast(a.h.ala_guess_active_finish);
                }
            } else if (this.hiD.status == com.baidu.tieba.ala.live.guess.a.a.hia && this.hiD.aKX >= 0) {
                bXH();
            } else if (this.hiD.status == com.baidu.tieba.ala.live.guess.a.a.hib) {
                bXN();
            }
        }
    }

    public void bXH() {
        if (bXQ() == com.baidu.tieba.ala.live.guess.a.a.hif) {
            bXK();
            uI(this.hiD.aKX * 1000);
        } else if (bXQ() == com.baidu.tieba.ala.live.guess.a.a.hie && this.hiD.aKY) {
            uI(this.hiD.aKX * 1000);
        } else if (bXQ() == com.baidu.tieba.ala.live.guess.a.a.hia && this.hiD.status == com.baidu.tieba.ala.live.guess.a.a.hib) {
            uJ(this.hiD.status);
        }
    }

    @Override // com.baidu.live.guess.b
    public void Jc() {
        Je();
        bXI();
        removeListener();
    }

    @Override // com.baidu.live.guess.b
    public void init(Context context, boolean z) {
        this.mContext = context;
        this.isHost = z;
    }

    public void bXI() {
        uJ(com.baidu.tieba.ala.live.guess.a.a.hif);
        if (this.hiz != null && this.bSB != null) {
            this.hiz.removeView();
            this.bSB.removeView(this.hiz);
            this.hiz = null;
        }
    }

    public void Je() {
        if (this.hiA != null) {
            this.hiA.cancel();
        }
        if (this.hiz != null && this.hiz.getTimerView() != null) {
            this.hiz.getTimerView().cancel();
        }
    }

    private AlaGuessPendantView bXJ() {
        if (this.hiz == null) {
            this.hiz = new AlaGuessPendantView(this.mContext);
            this.hiz.e(new FrameLayout.LayoutParams(-2, -2));
            this.hiz.c(this.mOnClickListener);
            this.hiz.getTvCountDown().setVisibility(0);
        }
        return this.hiz;
    }

    public void bXK() {
        if (this.bSB != null) {
            if (this.bSB instanceof PendantParentView) {
                ((PendantParentView) this.bSB).a(bXJ(), bXL());
            } else {
                this.bSB.addView(bXJ());
            }
            if (this.hiF != null) {
                this.hiF.Hk(this.isHost ? "author_liveroom" : "liveroom");
            }
            uJ(com.baidu.tieba.ala.live.guess.a.a.hie);
        }
    }

    private LinearLayout.LayoutParams bXL() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int dimension = (int) this.mContext.getResources().getDimension(a.d.sdk_ds20);
        layoutParams.setMargins(0, dimension, dimension, 0);
        return layoutParams;
    }

    private void uI(int i) {
        if (this.hiA != null) {
            this.hiA.cancel();
            this.hiA = null;
        }
        this.hiA = new CountDownTimer(i, 1000L) { // from class: com.baidu.tieba.ala.live.guess.b.a.4
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (a.this.hiz != null && a.this.hiz.getTvCountDown() != null) {
                    a.this.hiE = false;
                    long round = Math.round(j / 1000.0d);
                    if (round <= 30) {
                        if (a.this.hiG == null) {
                            a.this.hiG = new ForegroundColorSpan(a.this.mContext.getResources().getColor(a.c.ala_guess_act_text_color));
                        }
                        String bw = k.bw(round * 1000);
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bw);
                        spannableStringBuilder.setSpan(a.this.hiG, 0, bw.length(), 34);
                        a.this.s(spannableStringBuilder);
                        return;
                    }
                    a.this.Fq(k.bw(round * 1000));
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                a.this.bXN();
                a.this.bXM();
                a.this.Fq("抢券中");
            }
        };
        this.hiA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXM() {
        this.hiz.getTvCountDown().setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fq(String str) {
        this.hiz.getTvCountDown().setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(CharSequence charSequence) {
        this.hiz.getTvCountDown().setText(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXN() {
        this.hiE = true;
        if (bXQ() != com.baidu.tieba.ala.live.guess.a.a.hig) {
            if (this.hiA != null) {
                this.hiA.cancel();
            }
            if (bXQ() == com.baidu.tieba.ala.live.guess.a.a.hif) {
                bXK();
            }
            Fq("抢券中");
            uJ(com.baidu.tieba.ala.live.guess.a.a.hig);
        }
    }

    private String bXO() {
        return this.isHost ? "is_host=1" : "is_host=0";
    }

    private String bXP() {
        if (this.hhF == null || this.hhF.aJZ == null || this.hhF.mLiveInfo == null) {
            return "";
        }
        return "&anchor_author_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(this.hhF.aJD.userId)) + "&room_id=" + this.hhF.mLiveInfo.room_id;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm(String str) {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity();
            return;
        }
        c cVar = new c();
        cVar.url = str + bXO() + bXP();
        cVar.isFullScreen = true;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
    }

    private void uJ(int i) {
        this.hiC = i;
    }

    public int bXQ() {
        return this.hiC;
    }

    private void showToast(int i) {
        if (this.mContext != null) {
            BdUtilHelper.showToast(this.mContext, i);
        }
    }
}
