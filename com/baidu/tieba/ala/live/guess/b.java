package com.baidu.tieba.ala.live.guess;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaGuessQuesData;
import com.baidu.live.data.ab;
import com.baidu.live.data.n;
import com.baidu.live.data.o;
import com.baidu.live.guess.c;
import com.baidu.live.guess.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.CustomToast;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.encryption.EncryptionHelper;
import com.baidu.tieba.ala.live.guess.view.b;
import com.baidu.tieba.ala.live.guess.view.c;
import com.baidu.tieba.ala.live.guess.view.f;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class b implements com.baidu.live.guess.a, e.a, e.InterfaceC0181e {
    private static String TAG = b.class.getSimpleName();
    private CustomMessageListener bhY;
    private c hhE;
    private ab hhF;
    private CustomResponsedMessage<Long> hhG;
    private com.baidu.tieba.ala.live.guess.view.c hhH;
    private com.baidu.tieba.ala.live.guess.view.e hhI;
    private f hhJ;
    private com.baidu.tieba.ala.live.guess.a hhK;
    private e hhL;
    private AlaGuessQuesData hhM;
    private a hhT;
    private com.baidu.tieba.ala.live.guess.b.a hhU;
    private com.baidu.tieba.ala.live.guess.group.a hhV;
    private com.baidu.tieba.ala.live.guess.group.b hhW;
    private Activity mContext;
    private boolean hhN = false;
    private String hhO = "";
    private volatile int hhP = 0;
    private int hhQ = -1;
    private LinkedList<Long> hhR = new LinkedList<>();
    private LinkedList<Long> hhS = new LinkedList<>();
    private e.b hhX = new e.b() { // from class: com.baidu.tieba.ala.live.guess.b.3
        @Override // com.baidu.live.guess.e.b
        public void N(List<n> list) {
            if (b.this.hhM != null) {
                if (b.this.hhV == null || !b.this.hhV.bXD()) {
                    long j = b.this.hhF.aJZ.userId;
                    b.this.hhM.setGroupPerson(list);
                    b.this.a(j, (int) b.this.hhM.getQuesId(), null);
                    b.this.e(b.this.hhM);
                    b.this.hhP = 0;
                    return;
                }
                if (list != null && list.size() > 0) {
                    b.this.hhM.setGroupPerson(list);
                    b.this.hhV.o(b.this.hhM.getGroupPersons(), false);
                }
                b.this.hhV.bXB();
            } else if (BdLog.isDebugMode()) {
                BdUtilHelper.showToast(b.this.mContext, "获取组队信息失败 user_id " + b.this.hhF.mLiveInfo.user_id + " quesId " + b.this.hhM.getQuesId());
            }
        }

        @Override // com.baidu.live.guess.e.b
        public void onFailure(int i, String str) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public interface a {
        void bXx();
    }

    @Override // com.baidu.live.guess.a
    public void a(ab abVar, ViewGroup viewGroup) {
        this.hhL.Jj();
        this.hhU.a(abVar, viewGroup);
        b(abVar);
        bXu();
    }

    @Override // com.baidu.live.guess.a
    public void b(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.hhF = abVar;
            if (this.hhV != null) {
                this.hhV.a(this.hhF);
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.hhF.mLiveInfo.room_id + " " + this.hhF.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void Jc() {
        this.hhN = false;
        this.hhL.Jc();
        this.hhP = 0;
        if (this.hhU != null) {
            this.hhU.Jc();
        }
        MessageManager.getInstance().unRegisterListener(this.bhY);
        if (this.hhW != null) {
            this.hhW.unRegister();
        }
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.hhE = null;
        this.hhS.clear();
        this.hhR.clear();
        this.hhL.onDestroy();
    }

    public boolean ft(long j) {
        if (this.hhF == null || this.hhF.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void p(Activity activity) {
        this.mContext = activity;
        com.baidu.tieba.ala.live.guess.c.a.fX(this.mContext);
        this.hhK = new com.baidu.tieba.ala.live.guess.a();
        this.hhH = new com.baidu.tieba.ala.live.guess.view.c(this.mContext);
        this.hhL = new e(this);
        this.hhU = new com.baidu.tieba.ala.live.guess.b.a();
        this.hhU.init(this.mContext, false);
        this.hhV = new com.baidu.tieba.ala.live.guess.group.a(this.mContext, this.hhL);
        this.hhW = new com.baidu.tieba.ala.live.guess.group.b(this.mContext);
        registerListener();
    }

    private void registerListener() {
        this.bhY = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bXm();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.hhI != null) {
                        b.this.hhI.dismiss();
                    }
                }
            }
        };
        if (this.hhH != null) {
            this.hhH.a(new c.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.view.c.a
                public void anF() {
                }

                @Override // com.baidu.tieba.ala.live.guess.view.c.a
                public void bXv() {
                    b.this.bXo();
                }
            });
        }
        this.hhV.b(this.hhX);
        MessageManager.getInstance().registerListener(this.bhY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXm() {
        if (this.hhI != null) {
            this.hhI.dismiss();
        }
        if (this.hhJ != null && this.hhJ.isShowing()) {
            this.hhJ.dismiss();
        }
        if (this.hhE != null && this.hhE.isShowing()) {
            this.hhE.dismiss();
        }
        if (this.hhV != null && this.hhE.Jh() != null) {
            this.hhV.aw(this.hhE.Jh());
        }
        if (this.hhH != null && this.hhH.isShowing()) {
            this.hhH.dismiss();
        }
    }

    private void bXn() {
        if (this.hhJ != null && this.hhJ.isShowing()) {
            this.hhJ.dismiss();
        }
        if (this.hhE != null && this.hhE.isShowing()) {
            this.hhE.dismiss();
        }
        if (this.hhV != null && this.hhE.Jh() != null) {
            this.hhV.aw(this.hhE.Jh());
        }
        if (this.hhH != null && this.hhH.isShowing()) {
            this.hhH.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_im_info_three", alaGuessQuesData.getContentType())) {
            if (ft(alaGuessQuesData.getRoomId()) && !fw(alaGuessQuesData.getQuesId())) {
                if (fu(alaGuessQuesData.getQuesId())) {
                    this.hhM = alaGuessQuesData;
                    fv(this.hhM.getQuesId());
                    bXt();
                    this.hhV.bXC();
                    this.hhM.setIsFirst(1);
                    this.hhV.g(this.hhM);
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals("answer_im_info_three", alaGuessQuesData.getContentType())) {
            if (this.hhV != null) {
                this.hhV.bXC();
            }
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!fy(alaGuessQuesData.getQuesId())) {
            fx(alaGuessQuesData.getQuesId());
            bXn();
            String str = "0";
            List<n> groupPersons = alaGuessQuesData.getGroupPersons();
            if (groupPersons != null && groupPersons.size() == 3) {
                str = groupPersons.get(0).BA();
            }
            String str2 = "";
            if (this.hhF != null && this.hhF.aJZ != null && this.hhF.aJZ.userId != 0) {
                str2 = EncryptionHelper.getEncryptionUserId(String.valueOf(this.hhF.aJZ.userId));
            }
            this.hhL.a(alaGuessQuesData.getQuesId(), str2, str, this.hhF.mLiveInfo != null ? this.hhF.mLiveInfo.room_id : 0L, new e.c() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.e.c
                public void a(o oVar) {
                    if (oVar != null && oVar.BD() != null && !oVar.BC()) {
                        b.this.hhI = new com.baidu.tieba.ala.live.guess.view.e(b.this.mContext);
                        b.this.hhI.c(oVar, b.this.hhF);
                        b.this.hhI.show();
                    }
                }

                @Override // com.baidu.live.guess.e.c
                public void onFailure(int i, String str3) {
                    BdLog.e("AlaGuessResultController mGuessModel.getResultInfo onFailure " + str3);
                }
            });
        }
    }

    public void onTimeout() {
    }

    public void bXo() {
        if (this.hhG == null && this.hhM != null) {
            this.hhG = new CustomResponsedMessage<>(2913248, Long.valueOf(this.hhM.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.hhG);
        this.hhK.bXh();
    }

    public boolean bXp() {
        return this.hhM != null && this.hhM.getVoucherNum() > 0;
    }

    public void bXq() {
        this.hhP = 0;
        if (this.hhE != null) {
            this.hhE.Je();
            this.hhE.dismiss();
        }
        if (this.hhJ == null) {
            this.hhJ = new f(this.mContext);
            this.hhJ.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.view.f.a
                public void anF() {
                    b.this.hhJ.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.view.f.a
                public void bXw() {
                    b.this.hhK.bXj();
                    b.this.bXr();
                    b.this.hhJ.dismiss();
                }
            });
        }
        this.hhJ.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXr() {
        if (!TextUtils.isEmpty(this.hhO)) {
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            long j = 0;
            if (this.hhF != null && this.hhF.mLiveInfo != null) {
                j = this.hhF.mLiveInfo.room_id;
            }
            cVar.url = this.hhO + "?room_id=" + j;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.hhT = aVar;
        v(j, i);
    }

    public void v(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.hhL.a(j, i, new e.d() { // from class: com.baidu.tieba.ala.live.guess.b.6
                @Override // com.baidu.live.guess.e.d
                public void a(int i2, String str, boolean z, int i3) {
                    if (b.this.hhM != null) {
                        b.this.hhM.setVoucherNum(i2);
                        b.this.hhM.setDoubleTicketNumber(i3);
                        b.this.hhE.setDoubleTicketNumber(i3);
                        b.this.hhN = z;
                        b.this.hhO = str;
                    }
                    if (b.this.hhT != null) {
                        b.this.hhT.bXx();
                    }
                }

                @Override // com.baidu.live.guess.e.d
                public void onFailure(int i2, String str) {
                    if (b.this.hhT != null) {
                        if (TextUtils.isEmpty(str)) {
                            str = b.this.mContext.getString(a.h.ala_guess_net_error);
                        }
                        CustomToast.newInstance().showToast(str);
                    }
                }
            });
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
    }

    public void a(long j, long j2, int i, int i2) {
        this.hhQ = i;
        if (BdUtilHelper.isNetOk()) {
            this.hhL.a(j, j2, i, i2, this);
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
        this.hhP = 1;
    }

    @Override // com.baidu.live.guess.a
    public void dw(int i) {
        if (this.hhL != null) {
            this.hhL.dy(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uH(final int i) {
        this.hhK.k(i, this.hhE.Jg(), this.hhE.Jf());
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else if (bXp()) {
            a(this.hhF.aJZ.userId, this.hhM.getQuesId(), i, this.hhE.Jg());
        } else {
            a(this.hhF.aJZ.userId, (int) this.hhM.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.7
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bXx() {
                    if (!b.this.bXp()) {
                        b.this.hhK.bXk();
                        b.this.bXq();
                        return;
                    }
                    b.this.a(b.this.hhF.aJZ.userId, b.this.hhM.getQuesId(), i, b.this.hhE.Jg());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXs() {
        if (!this.hhN) {
            if (this.hhE != null) {
                this.hhE.Je();
                this.hhE.dismiss();
            }
            if (this.hhH != null) {
                this.hhK.bXi();
                this.hhH.show();
            }
        }
    }

    private boolean fu(long j) {
        long longValue = this.hhK.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void b(long j, int i, boolean z) {
        this.hhK.a(j, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.mContext, alaGuessQuesData);
        f(alaGuessQuesData);
        this.hhE.show();
    }

    private void f(AlaGuessQuesData alaGuessQuesData) {
        if (this.hhV != null && this.hhE != null) {
            if (alaGuessQuesData.getGroupPersons() != null && alaGuessQuesData.getGroupPersons().size() == 3) {
                this.hhV.av(this.hhE.Jh());
                this.hhV.o(alaGuessQuesData.getGroupPersons(), false);
                this.hhV.bXB();
                return;
            }
            this.hhV.aw(this.hhE.Jh());
        }
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        boolean z = false;
        this.hhE = new b.a().nB(true).uP(0).nC(false).a(new c.a() { // from class: com.baidu.tieba.ala.live.guess.b.8
            @Override // com.baidu.live.guess.c.a
            public void Ji() {
            }

            @Override // com.baidu.live.guess.c.a
            public void a(com.baidu.live.guess.c cVar) {
                b.this.uH(1);
            }

            @Override // com.baidu.live.guess.c.a
            public void b(com.baidu.live.guess.c cVar) {
                b.this.uH(0);
            }

            @Override // com.baidu.live.guess.c.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.c.a
            public void onTimeout() {
                if (b.this.hhP != 0) {
                    b.this.bXs();
                } else {
                    b.this.onTimeout();
                }
                if (b.this.hhE != null) {
                    b.this.hhV.bXC();
                    b.this.hhE.dismiss();
                }
            }

            @Override // com.baidu.live.guess.c.a
            public void onExit() {
                if (b.this.hhV != null) {
                    b.this.hhV.bXC();
                }
                b.this.bXs();
            }

            @Override // com.baidu.live.guess.c.a
            public void cg(boolean z2) {
                if (b.this.hhM != null) {
                    b.this.hhM.setUseDoubleTicket(z2);
                }
            }
        }).aj(activity);
        if (alaGuessQuesData.getGroupPersons() == null || alaGuessQuesData.getGroupPersons().size() != 3) {
            z = true;
        }
        this.hhE.ce(z);
        this.hhE.dx(alaGuessQuesData.getAnswerTime());
        this.hhE.gY("" + alaGuessQuesData.getAmount());
        this.hhE.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.hhE.ha(alaGuessQuesData.getSecondOpt());
        this.hhE.gZ(alaGuessQuesData.getFirstOpt());
        this.hhE.setDoubleTicketTitle(alaGuessQuesData.getDoubleCouponTitle());
        this.hhE.setDoubleTicketNumber(alaGuessQuesData.getDoubleTicketNumber());
        this.hhE.hb(alaGuessQuesData.getDoubleCouponImgUrl());
        this.hhE.setDoubleTicketContent(alaGuessQuesData.getDoubleCouponContent());
        this.hhE.cf(alaGuessQuesData.isDoubleCoupon());
        this.hhE.a(new b.DialogInterface$OnKeyListenerC0654b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.9
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        }));
        this.hhK.nu(z);
    }

    @Override // com.baidu.live.guess.e.InterfaceC0181e
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hhE == null) {
                a(this.mContext, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.e.InterfaceC0181e
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hhM != null) {
                alaGuessQuesData.setGroupPerson(this.hhM.getGroupPersons());
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.e.a
    public void Jp() {
        this.hhK.bXl();
        b(this.hhM.getQuesId(), this.hhQ, this.hhM.isUseDoubleTicket());
        if (this.hhE != null) {
            this.hhE.Jd();
        }
        CustomToast.newInstance().showToast(this.mContext.getResources().getString(a.h.ala_guess_upload_success));
    }

    @Override // com.baidu.live.guess.e.a
    public void onFailure(int i, String str) {
        if (i == 2) {
            if (BdLog.isDebugMode()) {
                BdLog.d(TAG + " repeat answer");
            }
        } else {
            this.hhP = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void fv(long j) {
        this.hhR.add(Long.valueOf(j));
    }

    public boolean fw(long j) {
        return this.hhR.contains(Long.valueOf(j));
    }

    public void fx(long j) {
        this.hhS.add(Long.valueOf(j));
    }

    public boolean fy(long j) {
        return this.hhS.contains(Long.valueOf(j));
    }

    private void bXt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "into_end_view"));
    }

    private void bXu() {
        if (this.hhW != null) {
            this.hhW.register();
            this.hhW.bXu();
        }
    }
}
