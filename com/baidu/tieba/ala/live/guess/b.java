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
    private com.baidu.live.guess.b gVR;
    private w gVS;
    private CustomResponsedMessage<Long> gVT;
    private g gVU;
    private d gVV;
    private com.baidu.tieba.ala.live.guess.a.a gVW;
    private f gVX;
    private com.baidu.tieba.ala.live.guess.a gVY;
    private c gVZ;
    private AlaGuessQuesData gWa;
    private AlaGuessQuesData gWb;
    private boolean gWc = false;
    private String gWd = "";
    private volatile int gWe = 0;
    private volatile boolean gWf = false;
    private int gWg = -1;
    private LinkedList<Long> gWh = new LinkedList<>();
    private LinkedList<Long> gWi = new LinkedList<>();
    private a gWj;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface a {
        void bXW();
    }

    @Override // com.baidu.live.guess.a
    public void e(w wVar) {
        this.gVZ.Ml();
        b(wVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null) {
            this.gVS = wVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.gVS.mLiveInfo.room_id + " " + this.gVS.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void Mg() {
        this.gWc = false;
        this.gVZ.Mg();
        this.gWe = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.gVR = null;
        this.gWi.clear();
        this.gWh.clear();
        this.gVZ.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bgy);
    }

    public boolean fo(long j) {
        if (this.gVS == null || this.gVS.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void q(Activity activity) {
        this.beD = activity;
        this.gVY = new com.baidu.tieba.ala.live.guess.a();
        this.gVU = new g(this.beD);
        this.gVV = new d(this.beD);
        this.gVZ = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bgy = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bXL();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.gVW != null && b.this.gVW.isShowing()) {
                        b.this.gVW.dismiss();
                    }
                }
            }
        };
        if (this.gVV != null) {
            this.gVV.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void apM() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void bXU() {
                    b.this.bXM();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bgy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXL() {
        if (this.gVW != null && this.gVW.isShowing()) {
            this.gVW.dismiss();
        }
        if (this.gVX != null && this.gVX.isShowing()) {
            this.gVX.dismiss();
        }
        if (this.gVR != null && this.gVR.isShowing()) {
            this.gVR.dismiss();
        }
        if (this.gVV != null && this.gVV.isShowing()) {
            this.gVV.dismiss();
        }
        if (this.gVU != null && this.gVU.isShowing()) {
            this.gVU.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (fo(alaGuessQuesData.getRoomId()) && !fr(alaGuessQuesData.getQuesId())) {
                if (fp(alaGuessQuesData.getQuesId())) {
                    this.gWb = alaGuessQuesData;
                    bXT();
                    long j = this.gVS.aKr.userId;
                    fq(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.gWe = 0;
                    this.gVY.bXK();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.gVS.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.gVY.getId().longValue()) {
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!ft(alaGuessQuesData.getQuesId())) {
            fs(alaGuessQuesData.getQuesId());
            bXT();
            if (this.gVW != null) {
                this.gVW.vW(this.gVY.fn(alaGuessQuesData.getQuesId()));
                this.gVW.au((float) alaGuessQuesData.getAmount());
                this.gVW.vX((int) alaGuessQuesData.getCorrectNum());
                this.gVW.setAverage(alaGuessQuesData.getAverage());
                this.gVW.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.gVW.ev(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.gVW.show();
            }
        }
    }

    public void Mk() {
        this.gVU.show();
        this.gVY.bXC();
    }

    public void bXM() {
        if (this.gVT == null && this.gWb != null) {
            this.gVT = new CustomResponsedMessage<>(2913248, Long.valueOf(this.gWb.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.gVT);
        this.gVY.bXF();
    }

    public boolean bXN() {
        return this.gWb.getVoucherNum() > 0;
    }

    public void bXO() {
        this.gWe = 0;
        if (this.gVR != null) {
            this.gVR.Mi();
            this.gVR.dismiss();
        }
        if (this.gVX == null) {
            this.gVX = new f(this.beD);
            this.gVX.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void apM() {
                    b.this.gVX.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void bXV() {
                    b.this.gVY.bXH();
                    b.this.bXP();
                    b.this.gVX.dismiss();
                }
            });
        }
        this.gVX.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXP() {
        if (!TextUtils.isEmpty(this.gWd)) {
            com.baidu.live.ao.c cVar = new com.baidu.live.ao.c();
            cVar.url = this.gWd;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.gWj = aVar;
        u(j, i);
    }

    public void u(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.gVZ.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.gWb != null) {
                        b.this.gWb.setVoucherNum(i2);
                        b.this.gWc = z;
                        b.this.gWd = str;
                    }
                    if (b.this.gWj != null) {
                        b.this.gWj.bXW();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.gWj != null) {
                        CustomToast.newInstance().showToast(b.this.beD.getString(a.h.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.beD.getString(a.h.ala_guess_net_error));
        }
    }

    public void b(long j, long j2, int i) {
        this.gWg = i;
        if (BdUtilHelper.isNetOk()) {
            this.gVZ.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.beD.getString(a.h.ala_guess_net_error));
        }
        this.gWe = 1;
    }

    @Override // com.baidu.live.guess.a
    public void eY(int i) {
        if (this.gVZ != null) {
            this.gVZ.fa(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vV(final int i) {
        this.gVY.vU(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.beD);
        } else if (bXN()) {
            b(this.gVS.aKr.userId, this.gWb.getQuesId(), i);
        } else {
            a(this.gVS.aKr.userId, (int) this.gWb.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bXW() {
                    if (!b.this.bXN()) {
                        b.this.gVY.bXI();
                        b.this.bXO();
                        return;
                    }
                    b.this.b(b.this.gVS.aKr.userId, b.this.gWb.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXQ() {
        if (!this.gWc) {
            if (this.gVR != null) {
                this.gVR.Mi();
                this.gVR.dismiss();
            }
            if (this.gVV != null) {
                this.gVY.bXG();
                this.gVV.show();
            }
        }
    }

    private boolean fp(long j) {
        long longValue = this.gVY.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void v(long j, int i) {
        this.gVY.t(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.beD, alaGuessQuesData);
        this.gVR.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.gVR = new c.a().mU(true).vY(0).mV(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
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
                if (b.this.gWe != 0) {
                    b.this.bXQ();
                } else {
                    b.this.Mk();
                }
                if (b.this.gVR != null) {
                    b.this.gVR.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.bXQ();
            }
        }).an(activity);
        this.gVR.eZ(alaGuessQuesData.getAnswerTime());
        this.gVR.hV("" + alaGuessQuesData.getAmount());
        this.gVR.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.gVR.hX(alaGuessQuesData.getSecondOpt());
        this.gVR.hW(alaGuessQuesData.getFirstOpt());
        this.gVR.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0189c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.gVR == null) {
                a(this.beD, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0189c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.gWa = alaGuessQuesData;
            if (this.gVW == null) {
                this.gVW = new com.baidu.tieba.ala.live.guess.a.a(this.beD);
                this.gVW.a(this);
            }
            c(this.gWa);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void Mp() {
        this.gVY.bXJ();
        v(this.gWb.getQuesId(), this.gWg);
        this.gVR.Mh();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.gWe = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void fq(long j) {
        this.gWh.add(Long.valueOf(j));
    }

    public boolean fr(long j) {
        return this.gWh.contains(Long.valueOf(j));
    }

    public void fs(long j) {
        this.gWi.add(Long.valueOf(j));
    }

    public boolean ft(long j) {
        return this.gWi.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0672a
    public void bXR() {
        this.gVY.bXE();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0672a
    public void bXS() {
        this.gVY.bXD();
    }

    private void bXT() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "into_end_view"));
    }
}
