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
    private c hfV;
    private ab hfW;
    private CustomResponsedMessage<Long> hfX;
    private com.baidu.tieba.ala.live.guess.view.c hfY;
    private com.baidu.tieba.ala.live.guess.view.e hfZ;
    private f hga;
    private com.baidu.tieba.ala.live.guess.a hgb;
    private e hgc;
    private AlaGuessQuesData hgd;
    private a hgk;
    private com.baidu.tieba.ala.live.guess.b.a hgl;
    private com.baidu.tieba.ala.live.guess.group.a hgm;
    private com.baidu.tieba.ala.live.guess.group.b hgn;
    private Activity mContext;
    private boolean hge = false;
    private String hgf = "";
    private volatile int hgg = 0;
    private int hgh = -1;
    private LinkedList<Long> hgi = new LinkedList<>();
    private LinkedList<Long> hgj = new LinkedList<>();
    private e.b hgo = new e.b() { // from class: com.baidu.tieba.ala.live.guess.b.3
        @Override // com.baidu.live.guess.e.b
        public void N(List<n> list) {
            if (b.this.hgd != null) {
                if (b.this.hgm == null || !b.this.hgm.bXx()) {
                    long j = b.this.hfW.aIz.userId;
                    b.this.hgd.setGroupPerson(list);
                    b.this.a(j, (int) b.this.hgd.getQuesId(), null);
                    b.this.e(b.this.hgd);
                    b.this.hgg = 0;
                    return;
                }
                if (list != null && list.size() > 0) {
                    b.this.hgd.setGroupPerson(list);
                    b.this.hgm.o(b.this.hgd.getGroupPersons(), false);
                }
                b.this.hgm.bXv();
            } else if (BdLog.isDebugMode()) {
                BdUtilHelper.showToast(b.this.mContext, "获取组队信息失败 user_id " + b.this.hfW.mLiveInfo.user_id + " quesId " + b.this.hgd.getQuesId());
            }
        }

        @Override // com.baidu.live.guess.e.b
        public void onFailure(int i, String str) {
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public interface a {
        void bXr();
    }

    @Override // com.baidu.live.guess.a
    public void a(ab abVar, ViewGroup viewGroup) {
        this.hgc.Jg();
        this.hgl.a(abVar, viewGroup);
        b(abVar);
        bXo();
    }

    @Override // com.baidu.live.guess.a
    public void b(ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null) {
            this.hfW = abVar;
            if (this.hgm != null) {
                this.hgm.a(this.hfW);
            }
            if (BdLog.isDebugMode()) {
                BdLog.e("AlaLiveGuessController Live guess room id " + this.hfW.mLiveInfo.room_id + " " + this.hfW.mLiveInfo.user_id);
            }
        }
    }

    @Override // com.baidu.live.guess.a
    public void IZ() {
        this.hge = false;
        this.hgc.IZ();
        this.hgg = 0;
        if (this.hgl != null) {
            this.hgl.IZ();
        }
        MessageManager.getInstance().unRegisterListener(this.bgy);
        if (this.hgn != null) {
            this.hgn.unRegister();
        }
    }

    @Override // com.baidu.live.guess.a
    public void onDestroy() {
        this.hfV = null;
        this.hgj.clear();
        this.hgi.clear();
        this.hgc.onDestroy();
    }

    public boolean ft(long j) {
        if (this.hfW == null || this.hfW.mLiveInfo.room_id != j) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.guess.a
    public void p(Activity activity) {
        this.mContext = activity;
        com.baidu.tieba.ala.live.guess.c.a.fY(this.mContext);
        this.hgb = new com.baidu.tieba.ala.live.guess.a();
        this.hfY = new com.baidu.tieba.ala.live.guess.view.c(this.mContext);
        this.hgc = new e(this);
        this.hgl = new com.baidu.tieba.ala.live.guess.b.a();
        this.hgl.init(this.mContext, false);
        this.hgm = new com.baidu.tieba.ala.live.guess.group.a(this.mContext, this.hgc);
        this.hgn = new com.baidu.tieba.ala.live.guess.group.b(this.mContext);
        registerListener();
    }

    private void registerListener() {
        this.bgy = new CustomMessageListener(2913253) { // from class: com.baidu.tieba.ala.live.guess.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                    if (TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                        b.this.bXg();
                    } else if (TextUtils.equals((String) customResponsedMessage.getData(), "ala/guess/cancelResult") && b.this.hfZ != null) {
                        b.this.hfZ.dismiss();
                    }
                }
            }
        };
        if (this.hfY != null) {
            this.hfY.a(new c.a() { // from class: com.baidu.tieba.ala.live.guess.b.2
                @Override // com.baidu.tieba.ala.live.guess.view.c.a
                public void anC() {
                }

                @Override // com.baidu.tieba.ala.live.guess.view.c.a
                public void bXp() {
                    b.this.bXi();
                }
            });
        }
        this.hgm.b(this.hgo);
        MessageManager.getInstance().registerListener(this.bgy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXg() {
        if (this.hfZ != null) {
            this.hfZ.dismiss();
        }
        if (this.hga != null && this.hga.isShowing()) {
            this.hga.dismiss();
        }
        if (this.hfV != null && this.hfV.isShowing()) {
            this.hfV.dismiss();
        }
        if (this.hgm != null && this.hfV.Je() != null) {
            this.hgm.aw(this.hfV.Je());
        }
        if (this.hfY != null && this.hfY.isShowing()) {
            this.hfY.dismiss();
        }
    }

    private void bXh() {
        if (this.hga != null && this.hga.isShowing()) {
            this.hga.dismiss();
        }
        if (this.hfV != null && this.hfV.isShowing()) {
            this.hfV.dismiss();
        }
        if (this.hgm != null && this.hfV.Je() != null) {
            this.hgm.aw(this.hfV.Je());
        }
        if (this.hfY != null && this.hfY.isShowing()) {
            this.hfY.dismiss();
        }
    }

    public void c(AlaGuessQuesData alaGuessQuesData) {
        if (TextUtils.equals("subject_im_info_three", alaGuessQuesData.getContentType())) {
            if (ft(alaGuessQuesData.getRoomId()) && !fw(alaGuessQuesData.getQuesId())) {
                if (fu(alaGuessQuesData.getQuesId())) {
                    this.hgd = alaGuessQuesData;
                    fv(this.hgd.getQuesId());
                    bXn();
                    this.hgm.bXw();
                    this.hgd.setIsFirst(1);
                    this.hgm.g(this.hgd);
                } else if (BdLog.isDebugMode()) {
                    BdLog.d(TAG + " Ala guess verify error:Is a old question");
                }
            }
        } else if (TextUtils.equals("answer_im_info_three", alaGuessQuesData.getContentType())) {
            if (this.hgm != null) {
                this.hgm.bXw();
            }
            d(alaGuessQuesData);
        }
    }

    private void d(AlaGuessQuesData alaGuessQuesData) {
        if (!fy(alaGuessQuesData.getQuesId())) {
            fx(alaGuessQuesData.getQuesId());
            bXh();
            String str = "0";
            List<n> groupPersons = alaGuessQuesData.getGroupPersons();
            if (groupPersons != null && groupPersons.size() == 3) {
                str = groupPersons.get(0).Bx();
            }
            String str2 = "";
            if (this.hfW != null && this.hfW.aIz != null && this.hfW.aIz.userId != 0) {
                str2 = EncryptionHelper.getEncryptionUserId(String.valueOf(this.hfW.aIz.userId));
            }
            this.hgc.a(alaGuessQuesData.getQuesId(), str2, str, this.hfW.mLiveInfo != null ? this.hfW.mLiveInfo.room_id : 0L, new e.c() { // from class: com.baidu.tieba.ala.live.guess.b.4
                @Override // com.baidu.live.guess.e.c
                public void a(o oVar) {
                    if (oVar != null && oVar.BA() != null && !oVar.Bz()) {
                        b.this.hfZ = new com.baidu.tieba.ala.live.guess.view.e(b.this.mContext);
                        b.this.hfZ.c(oVar, b.this.hfW);
                        b.this.hfZ.show();
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

    public void bXi() {
        if (this.hfX == null && this.hgd != null) {
            this.hfX = new CustomResponsedMessage<>(2913248, Long.valueOf(this.hgd.getAnchorId()));
        }
        MessageManager.getInstance().dispatchResponsedMessage(this.hfX);
        this.hgb.bXb();
    }

    public boolean bXj() {
        return this.hgd != null && this.hgd.getVoucherNum() > 0;
    }

    public void bXk() {
        this.hgg = 0;
        if (this.hfV != null) {
            this.hfV.Jb();
            this.hfV.dismiss();
        }
        if (this.hga == null) {
            this.hga = new f(this.mContext);
            this.hga.a(new f.a() { // from class: com.baidu.tieba.ala.live.guess.b.5
                @Override // com.baidu.tieba.ala.live.guess.view.f.a
                public void anC() {
                    b.this.hga.dismiss();
                }

                @Override // com.baidu.tieba.ala.live.guess.view.f.a
                public void bXq() {
                    b.this.hgb.bXd();
                    b.this.bXl();
                    b.this.hga.dismiss();
                }
            });
        }
        this.hga.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXl() {
        if (!TextUtils.isEmpty(this.hgf)) {
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            long j = 0;
            if (this.hfW != null && this.hfW.mLiveInfo != null) {
                j = this.hfW.mLiveInfo.room_id;
            }
            cVar.url = this.hgf + "?room_id=" + j;
            if (!TextUtils.isEmpty(cVar.url) && cVar.url.contains("fullscreen=1")) {
                cVar.isFullScreen = true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
        }
    }

    public void a(long j, int i, a aVar) {
        this.hgk = aVar;
        v(j, i);
    }

    public void v(long j, int i) {
        if (BdUtilHelper.isNetOk()) {
            this.hgc.a(j, i, new e.d() { // from class: com.baidu.tieba.ala.live.guess.b.6
                @Override // com.baidu.live.guess.e.d
                public void a(int i2, String str, boolean z, int i3) {
                    if (b.this.hgd != null) {
                        b.this.hgd.setVoucherNum(i2);
                        b.this.hgd.setDoubleTicketNumber(i3);
                        b.this.hfV.setDoubleTicketNumber(i3);
                        b.this.hge = z;
                        b.this.hgf = str;
                    }
                    if (b.this.hgk != null) {
                        b.this.hgk.bXr();
                    }
                }

                @Override // com.baidu.live.guess.e.d
                public void onFailure(int i2, String str) {
                    if (b.this.hgk != null) {
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
        this.hgh = i;
        if (BdUtilHelper.isNetOk()) {
            this.hgc.a(j, j2, i, i2, this);
        } else {
            CustomToast.newInstance().showToast(this.mContext.getString(a.h.ala_guess_net_error));
        }
        this.hgg = 1;
    }

    @Override // com.baidu.live.guess.a
    public void dv(int i) {
        if (this.hgc != null) {
            this.hgc.dx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uF(final int i) {
        this.hgb.k(i, this.hfV.Jd(), this.hfV.Jc());
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.mContext);
        } else if (bXj()) {
            a(this.hfW.aIz.userId, this.hgd.getQuesId(), i, this.hfV.Jd());
        } else {
            a(this.hfW.aIz.userId, (int) this.hgd.getQuesId(), new a() { // from class: com.baidu.tieba.ala.live.guess.b.7
                @Override // com.baidu.tieba.ala.live.guess.b.a
                public void bXr() {
                    if (!b.this.bXj()) {
                        b.this.hgb.bXe();
                        b.this.bXk();
                        return;
                    }
                    b.this.a(b.this.hfW.aIz.userId, b.this.hgd.getQuesId(), i, b.this.hfV.Jd());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXm() {
        if (!this.hge) {
            if (this.hfV != null) {
                this.hfV.Jb();
                this.hfV.dismiss();
            }
            if (this.hfY != null) {
                this.hgb.bXc();
                this.hfY.show();
            }
        }
    }

    private boolean fu(long j) {
        long longValue = this.hgb.getId().longValue();
        return longValue == -1 || longValue != j;
    }

    private void c(long j, int i, boolean z) {
        this.hgb.b(j, i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(AlaGuessQuesData alaGuessQuesData) {
        a(this.mContext, alaGuessQuesData);
        f(alaGuessQuesData);
        this.hfV.show();
    }

    private void f(AlaGuessQuesData alaGuessQuesData) {
        if (this.hgm != null && this.hfV != null) {
            if (alaGuessQuesData.getGroupPersons() != null && alaGuessQuesData.getGroupPersons().size() == 3) {
                this.hgm.av(this.hfV.Je());
                this.hgm.o(alaGuessQuesData.getGroupPersons(), false);
                this.hgm.bXv();
                return;
            }
            this.hgm.aw(this.hfV.Je());
        }
    }

    private void a(Activity activity, AlaGuessQuesData alaGuessQuesData) {
        boolean z = false;
        this.hfV = new b.a().nB(true).uN(0).nC(false).a(new c.a() { // from class: com.baidu.tieba.ala.live.guess.b.8
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
                if (b.this.hgg != 0) {
                    b.this.bXm();
                } else {
                    b.this.onTimeout();
                }
                if (b.this.hfV != null) {
                    b.this.hgm.bXw();
                    b.this.hfV.dismiss();
                }
            }

            @Override // com.baidu.live.guess.c.a
            public void onExit() {
                if (b.this.hgm != null) {
                    b.this.hgm.bXw();
                }
                b.this.bXm();
            }

            @Override // com.baidu.live.guess.c.a
            public void cg(boolean z2) {
                if (b.this.hgd != null) {
                    b.this.hgd.setUseDoubleTicket(z2);
                }
            }
        }).aj(activity);
        if (alaGuessQuesData.getGroupPersons() == null || alaGuessQuesData.getGroupPersons().size() != 3) {
            z = true;
        }
        this.hfV.ce(z);
        this.hfV.dw(alaGuessQuesData.getAnswerTime());
        this.hfV.gS("" + alaGuessQuesData.getAmount());
        this.hfV.setQuesContent("" + alaGuessQuesData.getQuesContent());
        this.hfV.gU(alaGuessQuesData.getSecondOpt());
        this.hfV.gT(alaGuessQuesData.getFirstOpt());
        this.hfV.setDoubleTicketTitle(alaGuessQuesData.getDoubleCouponTitle());
        this.hfV.setDoubleTicketNumber(alaGuessQuesData.getDoubleTicketNumber());
        this.hfV.gV(alaGuessQuesData.getDoubleCouponImgUrl());
        this.hfV.setDoubleTicketContent(alaGuessQuesData.getDoubleCouponContent());
        this.hfV.cf(alaGuessQuesData.isDoubleCoupon());
        this.hfV.a(new b.DialogInterface$OnKeyListenerC0648b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.b.9
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return i == 4;
            }
        }));
        this.hgb.nu(z);
    }

    @Override // com.baidu.live.guess.e.InterfaceC0175e
    public void a(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hfV == null) {
                a(this.mContext, alaGuessQuesData);
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.e.InterfaceC0175e
    public void b(AlaGuessQuesData alaGuessQuesData) {
        if (alaGuessQuesData != null) {
            if (this.hgd != null) {
                alaGuessQuesData.setGroupPerson(this.hgd.getGroupPersons());
            }
            c(alaGuessQuesData);
        }
    }

    @Override // com.baidu.live.guess.e.a
    public void Jm() {
        this.hgb.bXf();
        c(this.hgd.getQuesId(), this.hgh, this.hgd.isUseDoubleTicket());
        if (this.hfV != null) {
            this.hfV.Ja();
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
            this.hgg = 0;
        }
        CustomToast.newInstance().showToast(str);
    }

    public void fv(long j) {
        this.hgi.add(Long.valueOf(j));
    }

    public boolean fw(long j) {
        return this.hgi.contains(Long.valueOf(j));
    }

    public void fx(long j) {
        this.hgj.add(Long.valueOf(j));
    }

    public boolean fy(long j) {
        return this.hgj.contains(Long.valueOf(j));
    }

    private void bXn() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913253, "into_end_view"));
    }

    private void bXo() {
        if (this.hgn != null) {
            this.hgn.register();
            this.hgn.bXo();
        }
    }
}
