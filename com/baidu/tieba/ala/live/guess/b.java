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
import com.baidu.live.data.u;
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
public class b implements com.baidu.live.guess.a, c.a, c.InterfaceC0183c, a.InterfaceC0631a {
    private static String TAG = b.class.getSimpleName();
    private Activity bFt;
    private CustomMessageListener bbC;
    private com.baidu.tieba.ala.live.guess.a.a gvA;
    private f gvB;
    private com.baidu.tieba.ala.live.guess.a gvC;
    private c gvD;
    private AlaGuessQuesData gvE;
    private AlaGuessQuesData gvF;
    private boolean gvG = false;
    private String gvH = "";
    private volatile int gvI = 0;
    private volatile boolean gvJ = false;
    private int gvK = -1;
    private LinkedList<Long> gvL = new LinkedList<>();
    private LinkedList<Long> gvM = new LinkedList<>();
    private a gvN;
    private com.baidu.live.guess.b gvv;
    private u gvw;
    private CustomResponsedMessage<Long> gvx;
    private g gvy;
    private d gvz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void bPx();
    }

    @Override // com.baidu.live.guess.a
    public void f(u uVar) {
        this.gvD.JY();
        b(uVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null) {
            this.gvw = uVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.gvw.mLiveInfo.room_id + " " + this.gvw.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void JT() {
        this.gvG = false;
        this.gvD.JT();
        this.gvI = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.gvv = null;
        this.gvM.clear();
        this.gvL.clear();
        this.gvD.onDestroy();
    }

    public boolean em(long j) {
        if (this.gvw == null || this.gvw.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void r(Activity activity) {
        this.bFt = activity;
        this.gvC = new com.baidu.tieba.ala.live.guess.a();
        this.gvy = new g(this.bFt);
        this.gvz = new d(this.bFt);
        this.gvD = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bbC = new CustomMessageListener(2913249) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bPm();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.gvA != null && b.this.gvA.isShowing()) {
                        b.this.gvA.dismiss();
                    }
                }
            }
        };
        if (this.gvz != null) {
            this.gvz.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void aiS() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void bPv() {
                    b.this.bPn();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bbC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPm() {
        if (this.gvA != null && this.gvA.isShowing()) {
            this.gvA.dismiss();
        }
        if (this.gvB != null && this.gvB.isShowing()) {
            this.gvB.dismiss();
        }
        if (this.gvv != null && this.gvv.isShowing()) {
            this.gvv.dismiss();
        }
        if (this.gvz != null && this.gvz.isShowing()) {
            this.gvz.dismiss();
        }
        if (this.gvy != null && this.gvy.isShowing()) {
            this.gvy.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (em(alaGuessQuesData.getRoomId()) && !ep(alaGuessQuesData.getQuesId())) {
                if (en(alaGuessQuesData.getQuesId())) {
                    this.gvF = alaGuessQuesData;
                    bPu();
                    long j = this.gvw.aIf.userId;
                    eo(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.gvI = 0;
                    this.gvC.bPl();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.gvw.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.gvC.getId().longValue()) {
            bPu();
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!er(alaGuessQuesData.getQuesId())) {
            eq(alaGuessQuesData.getQuesId());
            if (this.gvA != null) {
                this.gvA.uo(this.gvC.el(alaGuessQuesData.getQuesId()));
                this.gvA.an((float) alaGuessQuesData.getAmount());
                this.gvA.up((int) alaGuessQuesData.getCorrectNum());
                this.gvA.setAverage(alaGuessQuesData.getAverage());
                this.gvA.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.gvA.eh(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.gvA.show();
            }
        }
    }

    public void JX() {
        this.gvy.show();
        this.gvC.bPd();
    }

    public void bPn() {
        if (this.gvx == null && this.gvF != null) {
            this.gvx = new CustomResponsedMessage<>(2913240, Long.valueOf(this.gvF.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.gvx);
        this.gvC.bPg();
    }

    public boolean bPo() {
        return this.gvF.getVoucherNum() > 0;
    }

    public void bPp() {
        this.gvI = 0;
        if (this.gvv != null) {
            this.gvv.JV();
            this.gvv.dismiss();
        }
        if (this.gvB == null) {
            this.gvB = new f(this.bFt);
            this.gvB.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void aiS() {
                    b.this.gvB.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void bPw() {
                    b.this.gvC.bPi();
                    b.this.bPq();
                    b.this.gvB.dismiss();
                }
            });
        }
        this.gvB.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPq() {
        if (!TextUtils.isEmpty(this.gvH)) {
            com.baidu.live.af.c cVar = new com.baidu.live.af.c();
            cVar.url = this.gvH;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.gvN = aVar;
        o(j, i);
    }

    public void o(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.gvD.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.gvF != null) {
                        b.this.gvF.setVoucherNum(i2);
                        b.this.gvG = z;
                        b.this.gvH = str;
                    }
                    if (b.this.gvN != null) {
                        b.this.gvN.bPx();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.gvN != null) {
                        CustomToast.newInstance().showToast(b.this.bFt.getString(a.i.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.bFt.getString(a.i.ala_guess_net_error));
        }
    }

    public void b(long j, long j2, int i) {
        this.gvK = i;
        if (BdUtilHelper.isNetOk()) {
            this.gvD.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.bFt.getString(a.i.ala_guess_net_error));
        }
        this.gvI = 1;
    }

    @Override // com.baidu.live.guess.a
    public void eF(int i) {
        if (this.gvD != null) {
            this.gvD.eH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void un(final int i) {
        this.gvC.um(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.bFt);
        } else if (bPo()) {
            b(this.gvw.aIf.userId, this.gvF.getQuesId(), i);
        } else {
            a(this.gvw.aIf.userId, (int) this.gvF.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bPx() {
                    if (!b.this.bPo()) {
                        b.this.gvC.bPj();
                        b.this.bPp();
                        return;
                    }
                    b.this.b(b.this.gvw.aIf.userId, b.this.gvF.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPr() {
        if (!this.gvG) {
            if (this.gvv != null) {
                this.gvv.JV();
                this.gvv.dismiss();
            }
            if (this.gvz != null) {
                this.gvC.bPh();
                this.gvz.show();
            }
        }
    }

    private boolean en(long j) {
        long longValue = this.gvC.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void p(long j, int i) {
        this.gvC.n(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.bFt, alaGuessQuesData);
        this.gvv.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.gvv = new c.a().lY(true).uq(0).lZ(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
            @Override // com.baidu.live.guess.b.a
            public void JW() {
            }

            @Override // com.baidu.live.guess.b.a
            public void a(com.baidu.live.guess.b bVar) {
                b.this.un(1);
            }

            @Override // com.baidu.live.guess.b.a
            public void b(com.baidu.live.guess.b bVar) {
                b.this.un(0);
            }

            @Override // com.baidu.live.guess.b.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.b.a
            public void JX() {
                if (b.this.gvI != 0) {
                    b.this.bPr();
                } else {
                    b.this.JX();
                }
                if (b.this.gvv != null) {
                    b.this.gvv.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.bPr();
            }
        }).an(activity);
        this.gvv.eG(alaGuessQuesData.getAnswerTime());
        this.gvv.hm("" + alaGuessQuesData.getAmount());
        this.gvv.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.gvv.ho(alaGuessQuesData.getSecondOpt());
        this.gvv.hn(alaGuessQuesData.getFirstOpt());
        this.gvv.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0183c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.gvv == null) {
                a(this.bFt, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0183c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.gvE = alaGuessQuesData;
            if (this.gvA == null) {
                this.gvA = new com.baidu.tieba.ala.live.guess.a.a(this.bFt);
                this.gvA.a(this);
            }
            c(this.gvE);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void Kc() {
        this.gvC.bPk();
        p(this.gvF.getQuesId(), this.gvK);
        this.gvv.JU();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.gvI = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void eo(long j) {
        this.gvL.add(Long.valueOf(j));
    }

    public boolean ep(long j) {
        return this.gvL.contains(Long.valueOf(j));
    }

    public void eq(long j) {
        this.gvM.add(Long.valueOf(j));
    }

    public boolean er(long j) {
        return this.gvM.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0631a
    public void bPs() {
        this.gvC.bPf();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0631a
    public void bPt() {
        this.gvC.bPe();
    }

    private void bPu() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
    }
}
