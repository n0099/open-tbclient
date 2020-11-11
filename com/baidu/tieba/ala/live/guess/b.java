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
public class b implements com.baidu.live.guess.a, c.a, c.InterfaceC0186c, a.InterfaceC0659a {
    private static String TAG = b.class.getSimpleName();
    private Activity bNY;
    private CustomMessageListener bek;
    private com.baidu.live.guess.b gMV;
    private w gMW;
    private CustomResponsedMessage<Long> gMX;
    private g gMY;
    private d gMZ;
    private com.baidu.tieba.ala.live.guess.a.a gNa;
    private f gNb;
    private com.baidu.tieba.ala.live.guess.a gNc;
    private c gNd;
    private AlaGuessQuesData gNe;
    private AlaGuessQuesData gNf;
    private boolean gNg = false;
    private String gNh = "";
    private volatile int gNi = 0;
    private volatile boolean gNj = false;
    private int gNk = -1;
    private LinkedList<Long> gNl = new LinkedList<>();
    private LinkedList<Long> gNm = new LinkedList<>();
    private a gNn;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void bUT();
    }

    @Override // com.baidu.live.guess.a
    public void e(w wVar) {
        this.gNd.KS();
        b(wVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.gMW = wVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.gMW.mLiveInfo.room_id + " " + this.gMW.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void KN() {
        this.gNg = false;
        this.gNd.KN();
        this.gNi = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.gMV = null;
        this.gNm.clear();
        this.gNl.clear();
        this.gNd.onDestroy();
    }

    public boolean eK(long j) {
        if (this.gMW == null || this.gMW.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void r(Activity activity) {
        this.bNY = activity;
        this.gNc = new com.baidu.tieba.ala.live.guess.a();
        this.gMY = new g(this.bNY);
        this.gMZ = new d(this.bNY);
        this.gNd = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bek = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bUI();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.gNa != null && b.this.gNa.isShowing()) {
                        b.this.gNa.dismiss();
                    }
                }
            }
        };
        if (this.gMZ != null) {
            this.gMZ.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void anm() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void bUR() {
                    b.this.bUJ();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bek);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUI() {
        if (this.gNa != null && this.gNa.isShowing()) {
            this.gNa.dismiss();
        }
        if (this.gNb != null && this.gNb.isShowing()) {
            this.gNb.dismiss();
        }
        if (this.gMV != null && this.gMV.isShowing()) {
            this.gMV.dismiss();
        }
        if (this.gMZ != null && this.gMZ.isShowing()) {
            this.gMZ.dismiss();
        }
        if (this.gMY != null && this.gMY.isShowing()) {
            this.gMY.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (eK(alaGuessQuesData.getRoomId()) && !eN(alaGuessQuesData.getQuesId())) {
                if (eL(alaGuessQuesData.getQuesId())) {
                    this.gNf = alaGuessQuesData;
                    bUQ();
                    long j = this.gMW.aJr.userId;
                    eM(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.gNi = 0;
                    this.gNc.bUH();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.gMW.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.gNc.getId().longValue()) {
            bUQ();
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!eP(alaGuessQuesData.getQuesId())) {
            eO(alaGuessQuesData.getQuesId());
            if (this.gNa != null) {
                this.gNa.uR(this.gNc.eJ(alaGuessQuesData.getQuesId()));
                this.gNa.ar((float) alaGuessQuesData.getAmount());
                this.gNa.uS((int) alaGuessQuesData.getCorrectNum());
                this.gNa.setAverage(alaGuessQuesData.getAverage());
                this.gNa.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.gNa.eo(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.gNa.show();
            }
        }
    }

    public void KR() {
        this.gMY.show();
        this.gNc.bUz();
    }

    public void bUJ() {
        if (this.gMX == null && this.gNf != null) {
            this.gMX = new CustomResponsedMessage<>(2913248, Long.valueOf(this.gNf.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.gMX);
        this.gNc.bUC();
    }

    public boolean bUK() {
        return this.gNf.getVoucherNum() > 0;
    }

    public void bUL() {
        this.gNi = 0;
        if (this.gMV != null) {
            this.gMV.KP();
            this.gMV.dismiss();
        }
        if (this.gNb == null) {
            this.gNb = new f(this.bNY);
            this.gNb.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void anm() {
                    b.this.gNb.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void bUS() {
                    b.this.gNc.bUE();
                    b.this.bUM();
                    b.this.gNb.dismiss();
                }
            });
        }
        this.gNb.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUM() {
        if (!TextUtils.isEmpty(this.gNh)) {
            com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
            cVar.url = this.gNh;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.gNn = aVar;
        s(j, i);
    }

    public void s(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.gNd.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.gNf != null) {
                        b.this.gNf.setVoucherNum(i2);
                        b.this.gNg = z;
                        b.this.gNh = str;
                    }
                    if (b.this.gNn != null) {
                        b.this.gNn.bUT();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.gNn != null) {
                        CustomToast.newInstance().showToast(b.this.bNY.getString(a.h.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.bNY.getString(a.h.ala_guess_net_error));
        }
    }

    public void b(long j, long j2, int i) {
        this.gNk = i;
        if (BdUtilHelper.isNetOk()) {
            this.gNd.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.bNY.getString(a.h.ala_guess_net_error));
        }
        this.gNi = 1;
    }

    @Override // com.baidu.live.guess.a
    public void eG(int i) {
        if (this.gNd != null) {
            this.gNd.eI(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(final int i) {
        this.gNc.uP(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.bNY);
        } else if (bUK()) {
            b(this.gMW.aJr.userId, this.gNf.getQuesId(), i);
        } else {
            a(this.gMW.aJr.userId, (int) this.gNf.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bUT() {
                    if (!b.this.bUK()) {
                        b.this.gNc.bUF();
                        b.this.bUL();
                        return;
                    }
                    b.this.b(b.this.gMW.aJr.userId, b.this.gNf.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUN() {
        if (!this.gNg) {
            if (this.gMV != null) {
                this.gMV.KP();
                this.gMV.dismiss();
            }
            if (this.gMZ != null) {
                this.gNc.bUD();
                this.gMZ.show();
            }
        }
    }

    private boolean eL(long j) {
        long longValue = this.gNc.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void t(long j, int i) {
        this.gNc.r(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.bNY, alaGuessQuesData);
        this.gMV.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.gMV = new c.a().my(true).uT(0).mz(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
            @Override // com.baidu.live.guess.b.a
            public void KQ() {
            }

            @Override // com.baidu.live.guess.b.a
            public void a(com.baidu.live.guess.b bVar) {
                b.this.uQ(1);
            }

            @Override // com.baidu.live.guess.b.a
            public void b(com.baidu.live.guess.b bVar) {
                b.this.uQ(0);
            }

            @Override // com.baidu.live.guess.b.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.b.a
            public void KR() {
                if (b.this.gNi != 0) {
                    b.this.bUN();
                } else {
                    b.this.KR();
                }
                if (b.this.gMV != null) {
                    b.this.gMV.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.bUN();
            }
        }).an(activity);
        this.gMV.eH(alaGuessQuesData.getAnswerTime());
        this.gMV.hB("" + alaGuessQuesData.getAmount());
        this.gMV.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.gMV.hD(alaGuessQuesData.getSecondOpt());
        this.gMV.hC(alaGuessQuesData.getFirstOpt());
        this.gMV.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0186c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.gMV == null) {
                a(this.bNY, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0186c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.gNe = alaGuessQuesData;
            if (this.gNa == null) {
                this.gNa = new com.baidu.tieba.ala.live.guess.a.a(this.bNY);
                this.gNa.a(this);
            }
            c(this.gNe);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void KW() {
        this.gNc.bUG();
        t(this.gNf.getQuesId(), this.gNk);
        this.gMV.KO();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.gNi = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void eM(long j) {
        this.gNl.add(Long.valueOf(j));
    }

    public boolean eN(long j) {
        return this.gNl.contains(Long.valueOf(j));
    }

    public void eO(long j) {
        this.gNm.add(Long.valueOf(j));
    }

    public boolean eP(long j) {
        return this.gNm.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0659a
    public void bUO() {
        this.gNc.bUB();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0659a
    public void bUP() {
        this.gNc.bUA();
    }

    private void bUQ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
    }
}
