package com.baidu.tieba.ala.live.guess;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaGuessQuesData;
import com.baidu.live.data.w;
import com.baidu.live.guess.b;
import com.baidu.live.guess.c;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.tieba.ala.live.guess.a.a;
import com.baidu.tieba.ala.live.guess.a.c;
import com.baidu.tieba.ala.live.guess.a.d;
import com.baidu.tieba.ala.live.guess.a.f;
import com.baidu.tieba.ala.live.guess.a.g;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class b implements com.baidu.live.guess.a, c.a, c.InterfaceC0184c, a.InterfaceC0647a {
    private static String TAG = b.class.getSimpleName();
    private Activity bIs;
    private CustomMessageListener bcQ;
    private a gHB;
    private com.baidu.live.guess.b gHj;
    private w gHk;
    private CustomResponsedMessage<Long> gHl;
    private g gHm;
    private d gHn;
    private com.baidu.tieba.ala.live.guess.a.a gHo;
    private f gHp;
    private com.baidu.tieba.ala.live.guess.a gHq;
    private c gHr;
    private AlaGuessQuesData gHs;
    private AlaGuessQuesData gHt;
    private boolean gHu = false;
    private String gHv = "";
    private volatile int gHw = 0;
    private volatile boolean gHx = false;
    private int gHy = -1;
    private LinkedList<Long> gHz = new LinkedList<>();
    private LinkedList<Long> gHA = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void bSu();
    }

    @Override // com.baidu.live.guess.a
    public void f(w wVar) {
        this.gHr.Ks();
        b(wVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.gHk = wVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.gHk.mLiveInfo.room_id + " " + this.gHk.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void Kn() {
        this.gHu = false;
        this.gHr.Kn();
        this.gHw = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.gHj = null;
        this.gHA.clear();
        this.gHz.clear();
        this.gHr.onDestroy();
    }

    public boolean eo(long j) {
        if (this.gHk == null || this.gHk.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void r(Activity activity) {
        this.bIs = activity;
        this.gHq = new com.baidu.tieba.ala.live.guess.a();
        this.gHm = new g(this.bIs);
        this.gHn = new d(this.bIs);
        this.gHr = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bcQ = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bSj();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.gHo != null && b.this.gHo.isShowing()) {
                        b.this.gHo.dismiss();
                    }
                }
            }
        };
        if (this.gHn != null) {
            this.gHn.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void akM() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void bSs() {
                    b.this.bSk();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bcQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSj() {
        if (this.gHo != null && this.gHo.isShowing()) {
            this.gHo.dismiss();
        }
        if (this.gHp != null && this.gHp.isShowing()) {
            this.gHp.dismiss();
        }
        if (this.gHj != null && this.gHj.isShowing()) {
            this.gHj.dismiss();
        }
        if (this.gHn != null && this.gHn.isShowing()) {
            this.gHn.dismiss();
        }
        if (this.gHm != null && this.gHm.isShowing()) {
            this.gHm.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (eo(alaGuessQuesData.getRoomId()) && !er(alaGuessQuesData.getQuesId())) {
                if (ep(alaGuessQuesData.getQuesId())) {
                    this.gHt = alaGuessQuesData;
                    bSr();
                    long j = this.gHk.aIA.userId;
                    eq(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.gHw = 0;
                    this.gHq.bSi();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.gHk.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.gHq.getId().longValue()) {
            bSr();
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!et(alaGuessQuesData.getQuesId())) {
            es(alaGuessQuesData.getQuesId());
            if (this.gHo != null) {
                this.gHo.uH(this.gHq.en(alaGuessQuesData.getQuesId()));
                this.gHo.ap((float) alaGuessQuesData.getAmount());
                this.gHo.uI((int) alaGuessQuesData.getCorrectNum());
                this.gHo.setAverage(alaGuessQuesData.getAverage());
                this.gHo.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.gHo.eo(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.gHo.show();
            }
        }
    }

    public void Kr() {
        this.gHm.show();
        this.gHq.bSa();
    }

    public void bSk() {
        if (this.gHl == null && this.gHt != null) {
            this.gHl = new CustomResponsedMessage<>(2913248, Long.valueOf(this.gHt.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.gHl);
        this.gHq.bSd();
    }

    public boolean bSl() {
        return this.gHt.getVoucherNum() > 0;
    }

    public void bSm() {
        this.gHw = 0;
        if (this.gHj != null) {
            this.gHj.Kp();
            this.gHj.dismiss();
        }
        if (this.gHp == null) {
            this.gHp = new f(this.bIs);
            this.gHp.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void akM() {
                    b.this.gHp.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void bSt() {
                    b.this.gHq.bSf();
                    b.this.bSn();
                    b.this.gHp.dismiss();
                }
            });
        }
        this.gHp.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSn() {
        if (!TextUtils.isEmpty(this.gHv)) {
            com.baidu.live.ai.c cVar = new com.baidu.live.ai.c();
            cVar.url = this.gHv;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.gHB = aVar;
        o(j, i);
    }

    public void o(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.gHr.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.gHt != null) {
                        b.this.gHt.setVoucherNum(i2);
                        b.this.gHu = z;
                        b.this.gHv = str;
                    }
                    if (b.this.gHB != null) {
                        b.this.gHB.bSu();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.gHB != null) {
                        CustomToast.newInstance().showToast(b.this.bIs.getString(a.i.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.bIs.getString(a.i.ala_guess_net_error));
        }
    }

    public void b(long j, long j2, int i) {
        this.gHy = i;
        if (BdUtilHelper.isNetOk()) {
            this.gHr.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.bIs.getString(a.i.ala_guess_net_error));
        }
        this.gHw = 1;
    }

    @Override // com.baidu.live.guess.a
    public void eG(int i) {
        if (this.gHr != null) {
            this.gHr.eI(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(final int i) {
        this.gHq.uF(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.bIs);
        } else if (bSl()) {
            b(this.gHk.aIA.userId, this.gHt.getQuesId(), i);
        } else {
            a(this.gHk.aIA.userId, (int) this.gHt.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bSu() {
                    if (!b.this.bSl()) {
                        b.this.gHq.bSg();
                        b.this.bSm();
                        return;
                    }
                    b.this.b(b.this.gHk.aIA.userId, b.this.gHt.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSo() {
        if (!this.gHu) {
            if (this.gHj != null) {
                this.gHj.Kp();
                this.gHj.dismiss();
            }
            if (this.gHn != null) {
                this.gHq.bSe();
                this.gHn.show();
            }
        }
    }

    private boolean ep(long j) {
        long longValue = this.gHq.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void p(long j, int i) {
        this.gHq.n(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.bIs, alaGuessQuesData);
        this.gHj.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.gHj = new c.a().mp(true).uJ(0).mq(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
            @Override // com.baidu.live.guess.b.a
            public void Kq() {
            }

            @Override // com.baidu.live.guess.b.a
            public void a(com.baidu.live.guess.b bVar) {
                b.this.uG(1);
            }

            @Override // com.baidu.live.guess.b.a
            public void b(com.baidu.live.guess.b bVar) {
                b.this.uG(0);
            }

            @Override // com.baidu.live.guess.b.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.b.a
            public void Kr() {
                if (b.this.gHw != 0) {
                    b.this.bSo();
                } else {
                    b.this.Kr();
                }
                if (b.this.gHj != null) {
                    b.this.gHj.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.bSo();
            }
        }).an(activity);
        this.gHj.eH(alaGuessQuesData.getAnswerTime());
        this.gHj.hu("" + alaGuessQuesData.getAmount());
        this.gHj.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.gHj.hw(alaGuessQuesData.getSecondOpt());
        this.gHj.hv(alaGuessQuesData.getFirstOpt());
        this.gHj.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0184c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.gHj == null) {
                a(this.bIs, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0184c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.gHs = alaGuessQuesData;
            if (this.gHo == null) {
                this.gHo = new com.baidu.tieba.ala.live.guess.a.a(this.bIs);
                this.gHo.a(this);
            }
            c(this.gHs);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void Kw() {
        this.gHq.bSh();
        p(this.gHt.getQuesId(), this.gHy);
        this.gHj.Ko();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.gHw = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void eq(long j) {
        this.gHz.add(Long.valueOf(j));
    }

    public boolean er(long j) {
        return this.gHz.contains(Long.valueOf(j));
    }

    public void es(long j) {
        this.gHA.add(Long.valueOf(j));
    }

    public boolean et(long j) {
        return this.gHA.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0647a
    public void bSp() {
        this.gHq.bSc();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0647a
    public void bSq() {
        this.gHq.bSb();
    }

    private void bSr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
    }
}
