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
/* loaded from: classes11.dex */
public class b implements com.baidu.live.guess.a, e.a, e.InterfaceC0175e {
    private static String TAG = b.class.getSimpleName();
    private CustomMessageListener bgy;
    private c hfH;
    private ab hfI;
    private CustomResponsedMessage<Long> hfJ;
    private com.baidu.tieba.ala.live.guess.view.c hfK;
    private com.baidu.tieba.ala.live.guess.view.e hfL;
    private f hfM;
    private com.baidu.tieba.ala.live.guess.a hfN;
    private e hfO;
    private AlaGuessQuesData hfP;
    private a hfW;
    private com.baidu.tieba.ala.live.guess.b.a hfX;
    private com.baidu.tieba.ala.live.guess.group.a hfY;
    private com.baidu.tieba.ala.live.guess.group.b hfZ;
    private Activity mContext;
    private boolean hfQ = false;
    private String hfR = "";
    private volatile int hfS = 0;
    private int hfT = -1;
    private LinkedList<Long> hfU = new LinkedList<>();
    private LinkedList<Long> hfV = new LinkedList<>();
    private e.b hga = new e.b() { // from class: com.baidu.tieba.ala.live.guess.b.3
        @Override // com.baidu.live.guess.e.b
        public void N(List<n> list) {
            if (b.this.hfP != null) {
                if (b.this.hfY == null || !b.this.hfY.bXq()) {
                    long j = b.this.hfI.aIz.userId;
                    b.this.hfP.setGroupPerson(list);
                    b.this.a(j, (int) b.this.hfP.getQuesId(), null);
                    b.this.e(b.this.hfP);
                    b.this.hfS = 0;
                    return;
                }
                if (list != null && list.size() > 0) {
                    b.this.hfP.setGroupPerson(list);
                    b.this.hfY.o(b.this.hfP.getGroupPersons(), false);
                }
                b.this.hfY.bXo();
            } else if (BdLog.isDebugMode()) {
                BdUtilHelper.showToast(b.this.mContext, "获取组队信息失败 user_id " + b.this.hfI.mLiveInfo.user_id + " quesId " + b.this.hfP.getQuesId());
            }
        }

        @Override // com.baidu.live.guess.e.b
        public void onFailure(int i, String str) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface a {
        void bXk();
    }

    @Override // com.baidu.live.guess.a
    public void a(ab abVar, ViewGroup viewGroup) {
        this.hfO.Jg();
        this.hfX.a(abVar, viewGroup);
        b(abVar);
        bXh();
    }

    @Override // com.baidu.live.guess.a
    public void b(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.hfI = abVar;
            if (this.hfY != null) {
                this.hfY.a(this.hfI);
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.hfI.mLiveInfo.room_id + " " + this.hfI.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void IZ() {
        this.hfQ = false;
        this.hfO.IZ();
        this.hfS = 0;
        if (this.hfX != null) {
            this.hfX.IZ();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
        if (this.hfZ != null) {
            this.hfZ.unRegister();
        }
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.hfH = null;
        this.hfV.clear();
        this.hfU.clear();
        this.hfO.onDestroy();
    }

    public boolean ft(long j) {
        if (this.hfI == null || this.hfI.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void p(Activity activity) {
        this.mContext = activity;
        com.baidu.tieba.ala.live.guess.c.a.fY(this.mContext);
        this.hfN = new com.baidu.tieba.ala.live.guess.a();
        this.hfK = new com.baidu.tieba.ala.live.guess.view.c(this.mContext);
        this.hfO = new e(this);
        this.hfX = new com.baidu.tieba.ala.live.guess.b.a();
        this.hfX.init(this.mContext, false);
        this.hfY = new com.baidu.tieba.ala.live.guess.group.a(this.mContext, this.hfO);
        this.hfZ = new com.baidu.tieba.ala.live.guess.group.b(this.mContext);
        registerListener();
    }

    private void registerListener() {
        this.bgy = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bWZ();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.hfL != null) {
                        b.this.hfL.dismiss();
                    }
                }
            }
        };
        if (this.hfK != null) {
            this.hfK.a(new c.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.view.c.a
                public void anC() {
                }

                @Override // com.baidu.tieba.ala.live.guess.view.c.a
                public void bXi() {
                    b.this.bXb();
                }
            });
        }
        this.hfY.b(this.hga);
        MessageManager.getInstance().registerListener(this.bgy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWZ() {
        if (this.hfL != null) {
            this.hfL.dismiss();
        }
        if (this.hfM != null && this.hfM.isShowing()) {
            this.hfM.dismiss();
        }
        if (this.hfH != null && this.hfH.isShowing()) {
            this.hfH.dismiss();
        }
        if (this.hfY != null && this.hfH.Je() != null) {
            this.hfY.aw(this.hfH.Je());
        }
        if (this.hfK != null && this.hfK.isShowing()) {
            this.hfK.dismiss();
        }
    }

    private void bXa() {
        if (this.hfM != null && this.hfM.isShowing()) {
            this.hfM.dismiss();
        }
        if (this.hfH != null && this.hfH.isShowing()) {
            this.hfH.dismiss();
        }
        if (this.hfY != null && this.hfH.Je() != null) {
            this.hfY.aw(this.hfH.Je());
        }
        if (this.hfK != null && this.hfK.isShowing()) {
            this.hfK.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_im_info_three", alaGuessQuesData.getContentType())) {
            if (ft(alaGuessQuesData.getRoomId()) && !fw(alaGuessQuesData.getQuesId())) {
                if (fu(alaGuessQuesData.getQuesId())) {
                    this.hfP = alaGuessQuesData;
                    fv(this.hfP.getQuesId());
                    bXg();
                    this.hfY.bXp();
                    this.hfP.setIsFirst(1);
                    this.hfY.g(this.hfP);
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals("answer_im_info_three", alaGuessQuesData.getContentType())) {
            if (this.hfY != null) {
                this.hfY.bXp();
            }
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!fy(alaGuessQuesData.getQuesId())) {
            fx(alaGuessQuesData.getQuesId());
            bXa();
            String str = "0";
            List<n> groupPersons = alaGuessQuesData.getGroupPersons();
            if (groupPersons != null && groupPersons.size() == 3) {
                str = groupPersons.get(0).Bx();
            }
            String str2 = "";
            if (this.hfI != null && this.hfI.aIz != null && this.hfI.aIz.userId != 0) {
                str2 = EncryptionHelper.getEncryptionUserId(String.valueOf(this.hfI.aIz.userId));
            }
            this.hfO.a(alaGuessQuesData.getQuesId(), str2, str, this.hfI.mLiveInfo != null ? this.hfI.mLiveInfo.room_id : 0L, new e.c() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.e.c
                public void a(o oVar) {
                    if (oVar != null && oVar.BA() != null && !oVar.Bz()) {
                        b.this.hfL = new com.baidu.tieba.ala.live.guess.view.e(b.this.mContext);
                        b.this.hfL.c(oVar, b.this.hfI);
                        b.this.hfL.show();
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

    public void bXb() {
        if (this.hfJ == null && this.hfP != null) {
            this.hfJ = new CustomResponsedMessage<>(2913248, Long.valueOf(this.hfP.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.hfJ);
        this.hfN.bWU();
    }

    public boolean bXc() {
        return this.hfP != null && this.hfP.getVoucherNum() > 0;
    }

    public void bXd() {
        this.hfS = 0;
        if (this.hfH != null) {
            this.hfH.Jb();
            this.hfH.dismiss();
        }
        if (this.hfM == null) {
            this.hfM = new f(this.mContext);
            this.hfM.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.view.f.a
                public void anC() {
                    b.this.hfM.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.view.f.a
                public void bXj() {
                    b.this.hfN.bWW();
                    b.this.bXe();
                    b.this.hfM.dismiss();
                }
            });
        }
        this.hfM.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXe() {
        if (!TextUtils.isEmpty(this.hfR)) {
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            long j = 0;
            if (this.hfI != null && this.hfI.mLiveInfo != null) {
                j = this.hfI.mLiveInfo.room_id;
            }
            cVar.url = this.hfR + "?room_id=" + j;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.hfW = aVar;
        v(j, i);
    }

    public void v(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.hfO.a(j, i, new e.d() { // from class: com.baidu.tieba.ala.live.guess.b.6
                @Override // com.baidu.live.guess.e.d
                public void a(int i2, String str, boolean z, int i3) {
                    if (b.this.hfP != null) {
                        b.this.hfP.setVoucherNum(i2);
                        b.this.hfP.setDoubleTicketNumber(i3);
                        b.this.hfH.setDoubleTicketNumber(i3);
                        b.this.hfQ = z;
                        b.this.hfR = str;
                    }
                    if (b.this.hfW != null) {
                        b.this.hfW.bXk();
                    }
                }

                @Override // com.baidu.live.guess.e.d
                public void onFailure(int i2, String str) {
                    if (b.this.hfW != null) {
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
        this.hfT = i;
        if (BdUtilHelper.isNetOk()) {
            this.hfO.a(j, j2, i, i2, this);
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
        this.hfS = 1;
    }

    @Override // com.baidu.live.guess.a
    public void dv(int i) {
        if (this.hfO != null) {
            this.hfO.dx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(final int i) {
        this.hfN.k(i, this.hfH.Jd(), this.hfH.Jc());
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else if (bXc()) {
            a(this.hfI.aIz.userId, this.hfP.getQuesId(), i, this.hfH.Jd());
        } else {
            a(this.hfI.aIz.userId, (int) this.hfP.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.7
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bXk() {
                    if (!b.this.bXc()) {
                        b.this.hfN.bWX();
                        b.this.bXd();
                        return;
                    }
                    b.this.a(b.this.hfI.aIz.userId, b.this.hfP.getQuesId(), i, b.this.hfH.Jd());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXf() {
        if (!this.hfQ) {
            if (this.hfH != null) {
                this.hfH.Jb();
                this.hfH.dismiss();
            }
            if (this.hfK != null) {
                this.hfN.bWV();
                this.hfK.show();
            }
        }
    }

    private boolean fu(long j) {
        long longValue = this.hfN.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void c(long j, int i, boolean z) {
        this.hfN.b(j, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.mContext, alaGuessQuesData);
        f(alaGuessQuesData);
        this.hfH.show();
    }

    private void f(AlaGuessQuesData alaGuessQuesData) {
        if (this.hfY != null && this.hfH != null) {
            if (alaGuessQuesData.getGroupPersons() != null && alaGuessQuesData.getGroupPersons().size() == 3) {
                this.hfY.av(this.hfH.Je());
                this.hfY.o(alaGuessQuesData.getGroupPersons(), false);
                this.hfY.bXo();
                return;
            }
            this.hfY.aw(this.hfH.Je());
        }
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        boolean z = false;
        this.hfH = new b.a().nB(true).uN(0).nC(false).a(new c.a() { // from class: com.baidu.tieba.ala.live.guess.b.8
            @Override // com.baidu.live.guess.c.a
            public void Jf() {
            }

            @Override // com.baidu.live.guess.c.a
            public void a(com.baidu.live.guess.c cVar) {
                b.this.uF(1);
            }

            @Override // com.baidu.live.guess.c.a
            public void b(com.baidu.live.guess.c cVar) {
                b.this.uF(0);
            }

            @Override // com.baidu.live.guess.c.a
            public void onDismiss(DialogInterface dialogInterface) {
            }

            @Override // com.baidu.live.guess.c.a
            public void onTimeout() {
                if (b.this.hfS != 0) {
                    b.this.bXf();
                } else {
                    b.this.onTimeout();
                }
                if (b.this.hfH != null) {
                    b.this.hfY.bXp();
                    b.this.hfH.dismiss();
                }
            }

            @Override // com.baidu.live.guess.c.a
            public void onExit() {
                if (b.this.hfY != null) {
                    b.this.hfY.bXp();
                }
                b.this.bXf();
            }

            @Override // com.baidu.live.guess.c.a
            public void cg(boolean z2) {
                if (b.this.hfP != null) {
                    b.this.hfP.setUseDoubleTicket(z2);
                }
            }
        }).aj(activity);
        if (alaGuessQuesData.getGroupPersons() == null || alaGuessQuesData.getGroupPersons().size() != 3) {
            z = true;
        }
        this.hfH.ce(z);
        this.hfH.dw(alaGuessQuesData.getAnswerTime());
        this.hfH.gS("" + alaGuessQuesData.getAmount());
        this.hfH.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.hfH.gU(alaGuessQuesData.getSecondOpt());
        this.hfH.gT(alaGuessQuesData.getFirstOpt());
        this.hfH.setDoubleTicketTitle(alaGuessQuesData.getDoubleCouponTitle());
        this.hfH.setDoubleTicketNumber(alaGuessQuesData.getDoubleTicketNumber());
        this.hfH.gV(alaGuessQuesData.getDoubleCouponImgUrl());
        this.hfH.setDoubleTicketContent(alaGuessQuesData.getDoubleCouponContent());
        this.hfH.cf(alaGuessQuesData.isDoubleCoupon());
        this.hfH.a(new b.DialogInterface$OnKeyListenerC0647b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.9
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        }));
        this.hfN.nu(z);
    }

    @Override // com.baidu.live.guess.e.InterfaceC0175e
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hfH == null) {
                a(this.mContext, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.e.InterfaceC0175e
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hfP != null) {
                alaGuessQuesData.setGroupPerson(this.hfP.getGroupPersons());
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.e.a
    public void Jm() {
        this.hfN.bWY();
        c(this.hfP.getQuesId(), this.hfT, this.hfP.isUseDoubleTicket());
        if (this.hfH != null) {
            this.hfH.Ja();
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
            this.hfS = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void fv(long j) {
        this.hfU.add(Long.valueOf(j));
    }

    public boolean fw(long j) {
        return this.hfU.contains(Long.valueOf(j));
    }

    public void fx(long j) {
        this.hfV.add(Long.valueOf(j));
    }

    public boolean fy(long j) {
        return this.hfV.contains(Long.valueOf(j));
    }

    private void bXg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "into_end_view"));
    }

    private void bXh() {
        if (this.hfZ != null) {
            this.hfZ.register();
            this.hfZ.bXh();
        }
    }
}
