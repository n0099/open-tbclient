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
public class b implements com.baidu.live.guess.a, c.a, c.InterfaceC0189c, a.InterfaceC0672a {
    private static String TAG = b.class.getSimpleName();
    private Activity beD;
    private CustomMessageListener bgy;
    private com.baidu.live.guess.b gVP;
    private w gVQ;
    private CustomResponsedMessage<Long> gVR;
    private g gVS;
    private d gVT;
    private com.baidu.tieba.ala.live.guess.a.a gVU;
    private f gVV;
    private com.baidu.tieba.ala.live.guess.a gVW;
    private c gVX;
    private AlaGuessQuesData gVY;
    private AlaGuessQuesData gVZ;
    private boolean gWa = false;
    private String gWb = "";
    private volatile int gWc = 0;
    private volatile boolean gWd = false;
    private int gWe = -1;
    private LinkedList<Long> gWf = new LinkedList<>();
    private LinkedList<Long> gWg = new LinkedList<>();
    private a gWh;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void bXV();
    }

    @Override // com.baidu.live.guess.a
    public void e(w wVar) {
        this.gVX.Ml();
        b(wVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.gVQ = wVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.gVQ.mLiveInfo.room_id + " " + this.gVQ.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void Mg() {
        this.gWa = false;
        this.gVX.Mg();
        this.gWc = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.gVP = null;
        this.gWg.clear();
        this.gWf.clear();
        this.gVX.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public boolean fo(long j) {
        if (this.gVQ == null || this.gVQ.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void q(Activity activity) {
        this.beD = activity;
        this.gVW = new com.baidu.tieba.ala.live.guess.a();
        this.gVS = new g(this.beD);
        this.gVT = new d(this.beD);
        this.gVX = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bgy = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bXK();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.gVU != null && b.this.gVU.isShowing()) {
                        b.this.gVU.dismiss();
                    }
                }
            }
        };
        if (this.gVT != null) {
            this.gVT.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void apM() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void bXT() {
                    b.this.bXL();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bgy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXK() {
        if (this.gVU != null && this.gVU.isShowing()) {
            this.gVU.dismiss();
        }
        if (this.gVV != null && this.gVV.isShowing()) {
            this.gVV.dismiss();
        }
        if (this.gVP != null && this.gVP.isShowing()) {
            this.gVP.dismiss();
        }
        if (this.gVT != null && this.gVT.isShowing()) {
            this.gVT.dismiss();
        }
        if (this.gVS != null && this.gVS.isShowing()) {
            this.gVS.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (fo(alaGuessQuesData.getRoomId()) && !fr(alaGuessQuesData.getQuesId())) {
                if (fp(alaGuessQuesData.getQuesId())) {
                    this.gVZ = alaGuessQuesData;
                    bXS();
                    long j = this.gVQ.aKr.userId;
                    fq(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.gWc = 0;
                    this.gVW.bXJ();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.gVQ.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.gVW.getId().longValue()) {
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!ft(alaGuessQuesData.getQuesId())) {
            fs(alaGuessQuesData.getQuesId());
            bXS();
            if (this.gVU != null) {
                this.gVU.vW(this.gVW.fn(alaGuessQuesData.getQuesId()));
                this.gVU.au((float) alaGuessQuesData.getAmount());
                this.gVU.vX((int) alaGuessQuesData.getCorrectNum());
                this.gVU.setAverage(alaGuessQuesData.getAverage());
                this.gVU.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.gVU.ev(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.gVU.show();
            }
        }
    }

    public void Mk() {
        this.gVS.show();
        this.gVW.bXB();
    }

    public void bXL() {
        if (this.gVR == null && this.gVZ != null) {
            this.gVR = new CustomResponsedMessage<>(2913248, Long.valueOf(this.gVZ.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.gVR);
        this.gVW.bXE();
    }

    public boolean bXM() {
        return this.gVZ.getVoucherNum() > 0;
    }

    public void bXN() {
        this.gWc = 0;
        if (this.gVP != null) {
            this.gVP.Mi();
            this.gVP.dismiss();
        }
        if (this.gVV == null) {
            this.gVV = new f(this.beD);
            this.gVV.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void apM() {
                    b.this.gVV.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void bXU() {
                    b.this.gVW.bXG();
                    b.this.bXO();
                    b.this.gVV.dismiss();
                }
            });
        }
        this.gVV.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXO() {
        if (!TextUtils.isEmpty(this.gWb)) {
            com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
            cVar.url = this.gWb;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.gWh = aVar;
        u(j, i);
    }

    public void u(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.gVX.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.gVZ != null) {
                        b.this.gVZ.setVoucherNum(i2);
                        b.this.gWa = z;
                        b.this.gWb = str;
                    }
                    if (b.this.gWh != null) {
                        b.this.gWh.bXV();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.gWh != null) {
                        CustomToast.newInstance().showToast(b.this.beD.getString(a.h.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.beD.getString(a.h.ala_guess_net_error));
        }
    }

    public void b(long j, long j2, int i) {
        this.gWe = i;
        if (BdUtilHelper.isNetOk()) {
            this.gVX.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.beD.getString(a.h.ala_guess_net_error));
        }
        this.gWc = 1;
    }

    @Override // com.baidu.live.guess.a
    public void eY(int i) {
        if (this.gVX != null) {
            this.gVX.fa(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV(final int i) {
        this.gVW.vU(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.beD);
        } else if (bXM()) {
            b(this.gVQ.aKr.userId, this.gVZ.getQuesId(), i);
        } else {
            a(this.gVQ.aKr.userId, (int) this.gVZ.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bXV() {
                    if (!b.this.bXM()) {
                        b.this.gVW.bXH();
                        b.this.bXN();
                        return;
                    }
                    b.this.b(b.this.gVQ.aKr.userId, b.this.gVZ.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXP() {
        if (!this.gWa) {
            if (this.gVP != null) {
                this.gVP.Mi();
                this.gVP.dismiss();
            }
            if (this.gVT != null) {
                this.gVW.bXF();
                this.gVT.show();
            }
        }
    }

    private boolean fp(long j) {
        long longValue = this.gVW.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void v(long j, int i) {
        this.gVW.t(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.beD, alaGuessQuesData);
        this.gVP.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.gVP = new c.a().mU(true).vY(0).mV(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
            @Override // com.baidu.live.guess.b.a
            public void Mj() {
            }

            @Override // com.baidu.live.guess.b.a
            public void a(com.baidu.live.guess.b bVar) {
                b.this.vV(1);
            }

            @Override // com.baidu.live.guess.b.a
            public void b(com.baidu.live.guess.b bVar) {
                b.this.vV(0);
            }

            @Override // com.baidu.live.guess.b.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.b.a
            public void Mk() {
                if (b.this.gWc != 0) {
                    b.this.bXP();
                } else {
                    b.this.Mk();
                }
                if (b.this.gVP != null) {
                    b.this.gVP.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.bXP();
            }
        }).an(activity);
        this.gVP.eZ(alaGuessQuesData.getAnswerTime());
        this.gVP.hV("" + alaGuessQuesData.getAmount());
        this.gVP.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.gVP.hX(alaGuessQuesData.getSecondOpt());
        this.gVP.hW(alaGuessQuesData.getFirstOpt());
        this.gVP.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0189c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.gVP == null) {
                a(this.beD, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0189c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.gVY = alaGuessQuesData;
            if (this.gVU == null) {
                this.gVU = new com.baidu.tieba.ala.live.guess.a.a(this.beD);
                this.gVU.a(this);
            }
            c(this.gVY);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void Mp() {
        this.gVW.bXI();
        v(this.gVZ.getQuesId(), this.gWe);
        this.gVP.Mh();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.gWc = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void fq(long j) {
        this.gWf.add(Long.valueOf(j));
    }

    public boolean fr(long j) {
        return this.gWf.contains(Long.valueOf(j));
    }

    public void fs(long j) {
        this.gWg.add(Long.valueOf(j));
    }

    public boolean ft(long j) {
        return this.gWg.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0672a
    public void bXQ() {
        this.gVW.bXD();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0672a
    public void bXR() {
        this.gVW.bXC();
    }

    private void bXS() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "into_end_view"));
    }
}
