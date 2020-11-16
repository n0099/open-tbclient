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
public class b implements com.baidu.live.guess.a, c.a, c.InterfaceC0184c, a.InterfaceC0659a {
    private static String TAG = b.class.getSimpleName();
    private Activity bMo;
    private CustomMessageListener bcy;
    private com.baidu.live.guess.b gMC;
    private w gMD;
    private CustomResponsedMessage<Long> gME;
    private g gMF;
    private d gMG;
    private com.baidu.tieba.ala.live.guess.a.a gMH;
    private f gMI;
    private com.baidu.tieba.ala.live.guess.a gMJ;
    private c gMK;
    private AlaGuessQuesData gML;
    private AlaGuessQuesData gMM;
    private boolean gMN = false;
    private String gMO = "";
    private volatile int gMP = 0;
    private volatile boolean gMQ = false;
    private int gMR = -1;
    private LinkedList<Long> gMS = new LinkedList<>();
    private LinkedList<Long> gMT = new LinkedList<>();
    private a gMU;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void bUm();
    }

    @Override // com.baidu.live.guess.a
    public void e(w wVar) {
        this.gMK.Kj();
        b(wVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.gMD = wVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.gMD.mLiveInfo.room_id + " " + this.gMD.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void Ke() {
        this.gMN = false;
        this.gMK.Ke();
        this.gMP = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.gMC = null;
        this.gMT.clear();
        this.gMS.clear();
        this.gMK.onDestroy();
    }

    public boolean eK(long j) {
        if (this.gMD == null || this.gMD.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void q(Activity activity) {
        this.bMo = activity;
        this.gMJ = new com.baidu.tieba.ala.live.guess.a();
        this.gMF = new g(this.bMo);
        this.gMG = new d(this.bMo);
        this.gMK = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bcy = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bUb();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.gMH != null && b.this.gMH.isShowing()) {
                        b.this.gMH.dismiss();
                    }
                }
            }
        };
        if (this.gMG != null) {
            this.gMG.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void amE() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void bUk() {
                    b.this.bUc();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bcy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUb() {
        if (this.gMH != null && this.gMH.isShowing()) {
            this.gMH.dismiss();
        }
        if (this.gMI != null && this.gMI.isShowing()) {
            this.gMI.dismiss();
        }
        if (this.gMC != null && this.gMC.isShowing()) {
            this.gMC.dismiss();
        }
        if (this.gMG != null && this.gMG.isShowing()) {
            this.gMG.dismiss();
        }
        if (this.gMF != null && this.gMF.isShowing()) {
            this.gMF.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (eK(alaGuessQuesData.getRoomId()) && !eN(alaGuessQuesData.getQuesId())) {
                if (eL(alaGuessQuesData.getQuesId())) {
                    this.gMM = alaGuessQuesData;
                    bUj();
                    long j = this.gMD.aHG.userId;
                    eM(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.gMP = 0;
                    this.gMJ.bUa();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.gMD.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.gMJ.getId().longValue()) {
            bUj();
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!eP(alaGuessQuesData.getQuesId())) {
            eO(alaGuessQuesData.getQuesId());
            if (this.gMH != null) {
                this.gMH.vp(this.gMJ.eJ(alaGuessQuesData.getQuesId()));
                this.gMH.at((float) alaGuessQuesData.getAmount());
                this.gMH.vq((int) alaGuessQuesData.getCorrectNum());
                this.gMH.setAverage(alaGuessQuesData.getAverage());
                this.gMH.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.gMH.eo(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.gMH.show();
            }
        }
    }

    public void Ki() {
        this.gMF.show();
        this.gMJ.bTS();
    }

    public void bUc() {
        if (this.gME == null && this.gMM != null) {
            this.gME = new CustomResponsedMessage<>(2913248, Long.valueOf(this.gMM.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.gME);
        this.gMJ.bTV();
    }

    public boolean bUd() {
        return this.gMM.getVoucherNum() > 0;
    }

    public void bUe() {
        this.gMP = 0;
        if (this.gMC != null) {
            this.gMC.Kg();
            this.gMC.dismiss();
        }
        if (this.gMI == null) {
            this.gMI = new f(this.bMo);
            this.gMI.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void amE() {
                    b.this.gMI.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void bUl() {
                    b.this.gMJ.bTX();
                    b.this.bUf();
                    b.this.gMI.dismiss();
                }
            });
        }
        this.gMI.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
        if (!TextUtils.isEmpty(this.gMO)) {
            com.baidu.live.ak.c cVar = new com.baidu.live.ak.c();
            cVar.url = this.gMO;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.gMU = aVar;
        s(j, i);
    }

    public void s(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.gMK.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.gMM != null) {
                        b.this.gMM.setVoucherNum(i2);
                        b.this.gMN = z;
                        b.this.gMO = str;
                    }
                    if (b.this.gMU != null) {
                        b.this.gMU.bUm();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.gMU != null) {
                        CustomToast.newInstance().showToast(b.this.bMo.getString(a.h.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.bMo.getString(a.h.ala_guess_net_error));
        }
    }

    public void b(long j, long j2, int i) {
        this.gMR = i;
        if (BdUtilHelper.isNetOk()) {
            this.gMK.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.bMo.getString(a.h.ala_guess_net_error));
        }
        this.gMP = 1;
    }

    @Override // com.baidu.live.guess.a
    public void eC(int i) {
        if (this.gMK != null) {
            this.gMK.eE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vo(final int i) {
        this.gMJ.vn(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.bMo);
        } else if (bUd()) {
            b(this.gMD.aHG.userId, this.gMM.getQuesId(), i);
        } else {
            a(this.gMD.aHG.userId, (int) this.gMM.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bUm() {
                    if (!b.this.bUd()) {
                        b.this.gMJ.bTY();
                        b.this.bUe();
                        return;
                    }
                    b.this.b(b.this.gMD.aHG.userId, b.this.gMM.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUg() {
        if (!this.gMN) {
            if (this.gMC != null) {
                this.gMC.Kg();
                this.gMC.dismiss();
            }
            if (this.gMG != null) {
                this.gMJ.bTW();
                this.gMG.show();
            }
        }
    }

    private boolean eL(long j) {
        long longValue = this.gMJ.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void t(long j, int i) {
        this.gMJ.r(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.bMo, alaGuessQuesData);
        this.gMC.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.gMC = new c.a().mz(true).vr(0).mA(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
            @Override // com.baidu.live.guess.b.a
            public void Kh() {
            }

            @Override // com.baidu.live.guess.b.a
            public void a(com.baidu.live.guess.b bVar) {
                b.this.vo(1);
            }

            @Override // com.baidu.live.guess.b.a
            public void b(com.baidu.live.guess.b bVar) {
                b.this.vo(0);
            }

            @Override // com.baidu.live.guess.b.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.b.a
            public void Ki() {
                if (b.this.gMP != 0) {
                    b.this.bUg();
                } else {
                    b.this.Ki();
                }
                if (b.this.gMC != null) {
                    b.this.gMC.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.bUg();
            }
        }).am(activity);
        this.gMC.eD(alaGuessQuesData.getAnswerTime());
        this.gMC.hv("" + alaGuessQuesData.getAmount());
        this.gMC.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.gMC.hx(alaGuessQuesData.getSecondOpt());
        this.gMC.hw(alaGuessQuesData.getFirstOpt());
        this.gMC.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0184c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.gMC == null) {
                a(this.bMo, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0184c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.gML = alaGuessQuesData;
            if (this.gMH == null) {
                this.gMH = new com.baidu.tieba.ala.live.guess.a.a(this.bMo);
                this.gMH.a(this);
            }
            c(this.gML);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void Kn() {
        this.gMJ.bTZ();
        t(this.gMM.getQuesId(), this.gMR);
        this.gMC.Kf();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.gMP = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void eM(long j) {
        this.gMS.add(Long.valueOf(j));
    }

    public boolean eN(long j) {
        return this.gMS.contains(Long.valueOf(j));
    }

    public void eO(long j) {
        this.gMT.add(Long.valueOf(j));
    }

    public boolean eP(long j) {
        return this.gMT.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0659a
    public void bUh() {
        this.gMJ.bTU();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0659a
    public void bUi() {
        this.gMJ.bTT();
    }

    private void bUj() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913097, "into_end_view"));
    }
}
