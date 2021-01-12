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
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.guess.a, c.a, c.InterfaceC0174c, a.InterfaceC0647a {
    private static String TAG = b.class.getSimpleName();
    private CustomMessageListener bdo;
    private com.baidu.live.guess.b hcY;
    private x hcZ;
    private CustomResponsedMessage<Long> hda;
    private g hdb;
    private d hdc;
    private com.baidu.tieba.ala.live.guess.a.a hdd;
    private f hde;
    private com.baidu.tieba.ala.live.guess.a hdf;
    private c hdg;
    private AlaGuessQuesData hdh;
    private AlaGuessQuesData hdi;
    private boolean hdj = false;
    private String hdk = "";
    private volatile int hdl = 0;
    private volatile boolean hdm = false;
    private int hdn = -1;
    private LinkedList<Long> hdo = new LinkedList<>();
    private LinkedList<Long> hdp = new LinkedList<>();
    private a hdq;
    private Activity mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface a {
        void bWK();
    }

    @Override // com.baidu.live.guess.a
    public void f(x xVar) {
        this.hdg.HN();
        b(xVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null) {
            this.hcZ = xVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.hcZ.mLiveInfo.room_id + " " + this.hcZ.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void HJ() {
        this.hdj = false;
        this.hdg.HJ();
        this.hdl = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.hcY = null;
        this.hdp.clear();
        this.hdo.clear();
        this.hdg.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bdo);
    }

    public boolean fo(long j) {
        if (this.hcZ == null || this.hcZ.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void p(Activity activity) {
        this.mContext = activity;
        this.hdf = new com.baidu.tieba.ala.live.guess.a();
        this.hdb = new g(this.mContext);
        this.hdc = new d(this.mContext);
        this.hdg = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bdo = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bWz();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.hdd != null && b.this.hdd.isShowing()) {
                        b.this.hdd.dismiss();
                    }
                }
            }
        };
        if (this.hdc != null) {
            this.hdc.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void ane() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void bWI() {
                    b.this.bWA();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bdo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWz() {
        if (this.hdd != null && this.hdd.isShowing()) {
            this.hdd.dismiss();
        }
        if (this.hde != null && this.hde.isShowing()) {
            this.hde.dismiss();
        }
        if (this.hcY != null && this.hcY.isShowing()) {
            this.hcY.dismiss();
        }
        if (this.hdc != null && this.hdc.isShowing()) {
            this.hdc.dismiss();
        }
        if (this.hdb != null && this.hdb.isShowing()) {
            this.hdb.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (fo(alaGuessQuesData.getRoomId()) && !fr(alaGuessQuesData.getQuesId())) {
                if (fp(alaGuessQuesData.getQuesId())) {
                    this.hdi = alaGuessQuesData;
                    bWH();
                    long j = this.hcZ.aGd.userId;
                    fq(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.hdl = 0;
                    this.hdf.bWy();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.hcZ.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.hdf.getId().longValue()) {
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!ft(alaGuessQuesData.getQuesId())) {
            fs(alaGuessQuesData.getQuesId());
            bWH();
            if (this.hdd != null) {
                this.hdd.uB(this.hdf.fn(alaGuessQuesData.getQuesId()));
                this.hdd.aw((float) alaGuessQuesData.getAmount());
                this.hdd.uC((int) alaGuessQuesData.getCorrectNum());
                this.hdd.setAverage(alaGuessQuesData.getAverage());
                this.hdd.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.hdd.et(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.hdd.show();
            }
        }
    }

    public void onTimeout() {
        this.hdb.show();
        this.hdf.bWq();
    }

    public void bWA() {
        if (this.hda == null && this.hdi != null) {
            this.hda = new CustomResponsedMessage<>(2913248, Long.valueOf(this.hdi.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.hda);
        this.hdf.bWt();
    }

    public boolean bWB() {
        return this.hdi.getVoucherNum() > 0;
    }

    public void bWC() {
        this.hdl = 0;
        if (this.hcY != null) {
            this.hcY.HL();
            this.hcY.dismiss();
        }
        if (this.hde == null) {
            this.hde = new f(this.mContext);
            this.hde.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void ane() {
                    b.this.hde.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void bWJ() {
                    b.this.hdf.bWv();
                    b.this.bWD();
                    b.this.hde.dismiss();
                }
            });
        }
        this.hde.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWD() {
        if (!TextUtils.isEmpty(this.hdk)) {
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            cVar.url = this.hdk;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.hdq = aVar;
        w(j, i);
    }

    public void w(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.hdg.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.hdi != null) {
                        b.this.hdi.setVoucherNum(i2);
                        b.this.hdj = z;
                        b.this.hdk = str;
                    }
                    if (b.this.hdq != null) {
                        b.this.hdq.bWK();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.hdq != null) {
                        CustomToast.newInstance().showToast(b.this.mContext.getString(a.h.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
    }

    public void c(long j, long j2, int i) {
        this.hdn = i;
        if (BdUtilHelper.isNetOk()) {
            this.hdg.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
        this.hdl = 1;
    }

    @Override // com.baidu.live.guess.a
    public void dq(int i) {
        if (this.hdg != null) {
            this.hdg.ds(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uA(final int i) {
        this.hdf.uz(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else if (bWB()) {
            c(this.hcZ.aGd.userId, this.hdi.getQuesId(), i);
        } else {
            a(this.hcZ.aGd.userId, (int) this.hdi.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bWK() {
                    if (!b.this.bWB()) {
                        b.this.hdf.bWw();
                        b.this.bWC();
                        return;
                    }
                    b.this.c(b.this.hcZ.aGd.userId, b.this.hdi.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWE() {
        if (!this.hdj) {
            if (this.hcY != null) {
                this.hcY.HL();
                this.hcY.dismiss();
            }
            if (this.hdc != null) {
                this.hdf.bWu();
                this.hdc.show();
            }
        }
    }

    private boolean fp(long j) {
        long longValue = this.hdf.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void x(long j, int i) {
        this.hdf.v(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.mContext, alaGuessQuesData);
        this.hcY.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.hcY = new c.a().nq(true).uD(0).nr(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
            @Override // com.baidu.live.guess.b.a
            public void HM() {
            }

            @Override // com.baidu.live.guess.b.a
            public void a(com.baidu.live.guess.b bVar) {
                b.this.uA(1);
            }

            @Override // com.baidu.live.guess.b.a
            public void b(com.baidu.live.guess.b bVar) {
                b.this.uA(0);
            }

            @Override // com.baidu.live.guess.b.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.b.a
            public void onTimeout() {
                if (b.this.hdl != 0) {
                    b.this.bWE();
                } else {
                    b.this.onTimeout();
                }
                if (b.this.hcY != null) {
                    b.this.hcY.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.bWE();
            }
        }).ap(activity);
        this.hcY.dr(alaGuessQuesData.getAnswerTime());
        this.hcY.gv("" + alaGuessQuesData.getAmount());
        this.hcY.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.hcY.gx(alaGuessQuesData.getSecondOpt());
        this.hcY.gw(alaGuessQuesData.getFirstOpt());
        this.hcY.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0174c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hcY == null) {
                a(this.mContext, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0174c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.hdh = alaGuessQuesData;
            if (this.hdd == null) {
                this.hdd = new com.baidu.tieba.ala.live.guess.a.a(this.mContext);
                this.hdd.a(this);
            }
            c(this.hdh);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void HR() {
        this.hdf.bWx();
        x(this.hdi.getQuesId(), this.hdn);
        this.hcY.HK();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.hdl = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void fq(long j) {
        this.hdo.add(Long.valueOf(j));
    }

    public boolean fr(long j) {
        return this.hdo.contains(Long.valueOf(j));
    }

    public void fs(long j) {
        this.hdp.add(Long.valueOf(j));
    }

    public boolean ft(long j) {
        return this.hdp.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0647a
    public void bWF() {
        this.hdf.bWs();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0647a
    public void bWG() {
        this.hdf.bWr();
    }

    private void bWH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "into_end_view"));
    }
}
