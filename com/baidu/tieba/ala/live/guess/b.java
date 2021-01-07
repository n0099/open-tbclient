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
/* loaded from: classes11.dex */
public class b implements com.baidu.live.guess.a, c.a, c.InterfaceC0183c, a.InterfaceC0664a {
    private static String TAG = b.class.getSimpleName();
    private CustomMessageListener bih;
    private com.baidu.live.guess.b hhE;
    private x hhF;
    private CustomResponsedMessage<Long> hhG;
    private g hhH;
    private d hhI;
    private com.baidu.tieba.ala.live.guess.a.a hhJ;
    private f hhK;
    private com.baidu.tieba.ala.live.guess.a hhL;
    private c hhM;
    private AlaGuessQuesData hhN;
    private AlaGuessQuesData hhO;
    private boolean hhP = false;
    private String hhQ = "";
    private volatile int hhR = 0;
    private volatile boolean hhS = false;
    private int hhT = -1;
    private LinkedList<Long> hhU = new LinkedList<>();
    private LinkedList<Long> hhV = new LinkedList<>();
    private a hhW;
    private Activity mContext;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface a {
        void caC();
    }

    @Override // com.baidu.live.guess.a
    public void f(x xVar) {
        this.hhM.LI();
        b(xVar);
    }

    @Override // com.baidu.live.guess.a
    public void b(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null) {
            this.hhF = xVar;
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.hhF.mLiveInfo.room_id + " " + this.hhF.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void LE() {
        this.hhP = false;
        this.hhM.LE();
        this.hhR = 0;
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.hhE = null;
        this.hhV.clear();
        this.hhU.clear();
        this.hhM.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.bih);
    }

    public boolean fo(long j) {
        if (this.hhF == null || this.hhF.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void p(Activity activity) {
        this.mContext = activity;
        this.hhL = new com.baidu.tieba.ala.live.guess.a();
        this.hhH = new g(this.mContext);
        this.hhI = new d(this.mContext);
        this.hhM = new c(this);
        registerListener();
    }

    private void registerListener() {
        this.bih = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.car();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.hhJ != null && b.this.hhJ.isShowing()) {
                        b.this.hhJ.dismiss();
                    }
                }
            }
        };
        if (this.hhI != null) {
            this.hhI.a(new d.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void aqZ() {
                }

                @Override // com.baidu.tieba.ala.live.guess.a.d.a
                public void caA() {
                    b.this.cas();
                }
            });
        }
        MessageManager.getInstance().registerListener(this.bih);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void car() {
        if (this.hhJ != null && this.hhJ.isShowing()) {
            this.hhJ.dismiss();
        }
        if (this.hhK != null && this.hhK.isShowing()) {
            this.hhK.dismiss();
        }
        if (this.hhE != null && this.hhE.isShowing()) {
            this.hhE.dismiss();
        }
        if (this.hhI != null && this.hhI.isShowing()) {
            this.hhI.dismiss();
        }
        if (this.hhH != null && this.hhH.isShowing()) {
            this.hhH.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_mi_info", alaGuessQuesData.getContentType())) {
            if (fo(alaGuessQuesData.getRoomId()) && !fr(alaGuessQuesData.getQuesId())) {
                if (fp(alaGuessQuesData.getQuesId())) {
                    this.hhO = alaGuessQuesData;
                    caz();
                    long j = this.hhF.aKQ.userId;
                    fq(alaGuessQuesData.getQuesId());
                    a(j, (int) alaGuessQuesData.getQuesId(), null);
                    e(alaGuessQuesData);
                    this.hhR = 0;
                    this.hhL.caq();
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals(AlaGuessQuesData.ANSWER_INFO, alaGuessQuesData.getContentType()) && alaGuessQuesData.getRoomId() == this.hhF.mLiveInfo.room_id && alaGuessQuesData.getQuesId() == this.hhL.getId().longValue()) {
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!ft(alaGuessQuesData.getQuesId())) {
            fs(alaGuessQuesData.getQuesId());
            caz();
            if (this.hhJ != null) {
                this.hhJ.wh(this.hhL.fn(alaGuessQuesData.getQuesId()));
                this.hhJ.aw((float) alaGuessQuesData.getAmount());
                this.hhJ.wi((int) alaGuessQuesData.getCorrectNum());
                this.hhJ.setAverage(alaGuessQuesData.getAverage());
                this.hhJ.h(alaGuessQuesData.getAnswer(), (float) alaGuessQuesData.getCorrectPercent());
                this.hhJ.eu(alaGuessQuesData.getFirstOpt(), alaGuessQuesData.getSecondOpt());
                this.hhJ.show();
            }
        }
    }

    public void onTimeout() {
        this.hhH.show();
        this.hhL.cai();
    }

    public void cas() {
        if (this.hhG == null && this.hhO != null) {
            this.hhG = new CustomResponsedMessage<>(2913248, Long.valueOf(this.hhO.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.hhG);
        this.hhL.cal();
    }

    public boolean cat() {
        return this.hhO.getVoucherNum() > 0;
    }

    public void cau() {
        this.hhR = 0;
        if (this.hhE != null) {
            this.hhE.LG();
            this.hhE.dismiss();
        }
        if (this.hhK == null) {
            this.hhK = new f(this.mContext);
            this.hhK.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.3
                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void aqZ() {
                    b.this.hhK.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.a.f.a
                public void caB() {
                    b.this.hhL.can();
                    b.this.cav();
                    b.this.hhK.dismiss();
                }
            });
        }
        this.hhK.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cav() {
        if (!TextUtils.isEmpty(this.hhQ)) {
            com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
            cVar.url = this.hhQ;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.hhW = aVar;
        w(j, i);
    }

    public void w(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.hhM.a(j, i, new c.b() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.c.b
                public void d(int i2, String str, boolean z) {
                    if (b.this.hhO != null) {
                        b.this.hhO.setVoucherNum(i2);
                        b.this.hhP = z;
                        b.this.hhQ = str;
                    }
                    if (b.this.hhW != null) {
                        b.this.hhW.caC();
                    }
                }

                @Override // com.baidu.live.guess.c.b
                public void onFailure(int i2) {
                    if (b.this.hhW != null) {
                        CustomToast.newInstance().showToast(b.this.mContext.getString(a.h.ala_guess_net_error));
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
    }

    public void c(long j, long j2, int i) {
        this.hhT = i;
        if (BdUtilHelper.isNetOk()) {
            this.hhM.a(j, j2, i, this);
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
        this.hhR = 1;
    }

    @Override // com.baidu.live.guess.a
    public void eW(int i) {
        if (this.hhM != null) {
            this.hhM.eY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wg(final int i) {
        this.hhL.wf(i);
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else if (cat()) {
            c(this.hhF.aKQ.userId, this.hhO.getQuesId(), i);
        } else {
            a(this.hhF.aKQ.userId, (int) this.hhO.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void caC() {
                    if (!b.this.cat()) {
                        b.this.hhL.cao();
                        b.this.cau();
                        return;
                    }
                    b.this.c(b.this.hhF.aKQ.userId, b.this.hhO.getQuesId(), i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caw() {
        if (!this.hhP) {
            if (this.hhE != null) {
                this.hhE.LG();
                this.hhE.dismiss();
            }
            if (this.hhI != null) {
                this.hhL.cam();
                this.hhI.show();
            }
        }
    }

    private boolean fp(long j) {
        long longValue = this.hhL.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void x(long j, int i) {
        this.hhL.v(j, i);
    }

    private void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.mContext, alaGuessQuesData);
        this.hhE.show();
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        this.hhE = new c.a().nu(true).wj(0).nv(false).a(new b.a() { // from class: com.baidu.tieba.ala.live.guess.b.6
            @Override // com.baidu.live.guess.b.a
            public void LH() {
            }

            @Override // com.baidu.live.guess.b.a
            public void a(com.baidu.live.guess.b bVar) {
                b.this.wg(1);
            }

            @Override // com.baidu.live.guess.b.a
            public void b(com.baidu.live.guess.b bVar) {
                b.this.wg(0);
            }

            @Override // com.baidu.live.guess.b.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.b.a
            public void onTimeout() {
                if (b.this.hhR != 0) {
                    b.this.caw();
                } else {
                    b.this.onTimeout();
                }
                if (b.this.hhE != null) {
                    b.this.hhE.dismiss();
                }
            }

            @Override // com.baidu.live.guess.b.a
            public void onExit() {
                b.this.caw();
            }
        }).ap(activity);
        this.hhE.eX(alaGuessQuesData.getAnswerTime());
        this.hhE.hG("" + alaGuessQuesData.getAmount());
        this.hhE.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.hhE.hI(alaGuessQuesData.getSecondOpt());
        this.hhE.hH(alaGuessQuesData.getFirstOpt());
        this.hhE.a(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.7
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // com.baidu.live.guess.c.InterfaceC0183c
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hhE == null) {
                a(this.mContext, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.c.InterfaceC0183c
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            this.hhN = alaGuessQuesData;
            if (this.hhJ == null) {
                this.hhJ = new com.baidu.tieba.ala.live.guess.a.a(this.mContext);
                this.hhJ.a(this);
            }
            c(this.hhN);
        }
    }

    @Override // com.baidu.live.guess.c.a
    public void LM() {
        this.hhL.cap();
        x(this.hhO.getQuesId(), this.hhT);
        this.hhE.LF();
    }

    @Override // com.baidu.live.guess.c.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.hhR = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void fq(long j) {
        this.hhU.add(Long.valueOf(j));
    }

    public boolean fr(long j) {
        return this.hhU.contains(Long.valueOf(j));
    }

    public void fs(long j) {
        this.hhV.add(Long.valueOf(j));
    }

    public boolean ft(long j) {
        return this.hhV.contains(Long.valueOf(j));
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0664a
    public void cax() {
        this.hhL.cak();
    }

    @Override // com.baidu.tieba.ala.live.guess.a.a.InterfaceC0664a
    public void cay() {
        this.hhL.caj();
    }

    private void caz() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "into_end_view"));
    }
}
