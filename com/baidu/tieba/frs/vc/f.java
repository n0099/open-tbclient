package com.baidu.tieba.frs.vc;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel ccn;
    private Runnable drd;
    private FrsFragment fGZ;
    private com.baidu.tieba.frs.view.b fMj;
    private int fMk;
    private String fMl;
    private Runnable fMm;
    private int fMn;
    private boolean fMo;
    private w fMp;
    private boolean fMq;
    private com.baidu.tieba.frs.entelechy.b.a fMr;
    private boolean fMs;
    private com.baidu.tieba.f.a fMt;
    private BdUniqueId fMu;
    private FrsTabViewController fMv;
    private AntiHelper.a fMw;
    private CustomMessageListener fMx;
    private int flv;
    private final View.OnClickListener fqZ;
    private FrsHeaderViewContainer frt;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.frt = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fMl = null;
        this.fMo = false;
        this.ccn = null;
        this.fMp = null;
        this.fMq = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTd));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTd));
            }
        };
        this.fMw = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTf));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTf));
            }
        };
        this.fMx = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bkj;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fGZ != null && (customResponsedMessage instanceof SignMessage) && (bkj = f.this.fGZ.bkj()) != null && bkj.getForum() != null && (name = bkj.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fMu) {
                    TiebaStatic.eventStat(f.this.fGZ.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bkj.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aG(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aI(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTd));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bkj.getForum().getId())) {
                            f.this.xc(name2);
                            bkj.updateSignData(signData2);
                            signData2.forumId = bkj.getForum().getId();
                            signData2.forumName = bkj.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bkj.getForum().getUser_level();
                        if (f.this.bqy()) {
                            i = bkj.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bqw()) {
                            f.this.fGZ.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fGZ.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fGZ.bjM() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.anA().a(f.this.fGZ.getTbPageContext(), f.this.fGZ.bjM().bla());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.sD(1);
                    }
                    f.this.fGZ.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.drd = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.frt != null) {
                    int childCount = f.this.frt.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.frt.getChildAt(i));
                    }
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.fqZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bkj = f.this.fGZ.bkj();
                if (bkj != null && bkj.getForum() != null && f.this.fMj != null && (view == f.this.fMj.brr() || view == f.this.fMj.brs() || view == f.this.fMj.brt())) {
                    if (f.this.fGZ != null && bkj.getForum() != null) {
                        TiebaStatic.log(new am("c12046").bT("fid", bkj.getForum().getId()).P("obj_locate", f.this.fGZ.bkl() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bkj.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fGZ.bkk()) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            f.this.fGZ.showToast(R.string.neterror);
                        } else if (!bc.cE(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").P("obj_locate", 1).bT("fid", f.this.fGZ.getForumId()));
                        } else {
                            f.this.kF(true);
                            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.bT("fid", f.this.fGZ.getForumId());
                                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fGZ.bkk()) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            f.this.fGZ.showToast(R.string.neterror);
                        } else if (bc.cE(f.this.mContext.getPageActivity())) {
                            if (!f.this.bqx()) {
                                f.this.bqA();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fGZ.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(f.this.fGZ.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == R.id.frs_header_games) {
                    if (bc.cE(f.this.mContext.getPageActivity()) && bkj != null && bkj.getGameUrl() != null) {
                        ba.aiz().a((TbPageContext) f.this.getPageContext(), new String[]{bkj.getGameUrl()}, true);
                    }
                } else if (id == R.id.frs_bawu_center) {
                    if (bkj != null && bkj.getUserData() != null && bkj.getUserData().isBawu()) {
                        String bawuCenterUrl = bkj.getBawuCenterUrl();
                        if (!ap.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.af(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bkj.getForum() != null) {
                                TiebaStatic.log(new am("c10502").bT("fid", bkj.getForum().getId()).bT("uid", bkj.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == R.id.level_container && !f.this.fGZ.bkk() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fMj != null) {
                        f.this.fMj.k(view, false);
                    }
                }
            }
        };
        this.fGZ = frsFragment;
        this.fMr = aVar;
        this.frt = frsHeaderViewContainer;
        this.fMu = BdUniqueId.gen();
        this.fMt = new com.baidu.tieba.f.a();
        this.fMt.a(new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aT(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aU(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0302a
            public void aV(int i, int i2) {
            }
        });
    }

    public void R(Bundle bundle) {
        this.fGZ.registerListener(this.fMx);
        aIr();
        bqB();
        this.fMo = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.fMj != null) {
            this.fMj.onDestory();
        }
        if (this.ccn != null) {
            this.ccn.clJ();
        }
        if (this.fMm != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fMm);
        }
    }

    public void onActivityStop() {
        if (this.fMj != null) {
            this.fMj.onStop();
        }
        if (this.frt != null) {
            this.frt.removeCallbacks(this.drd);
        }
    }

    public void jI(boolean z) {
        if (this.fMj != null) {
            this.fMj.jI(z);
        }
    }

    public boolean sz(int i) {
        this.mSkinType = i;
        if (this.fMj != null) {
            this.fMj.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kE(boolean z) {
        if (z) {
            if (this.fMj != null) {
                this.frt.removeHeaderView(this.fMj.brq());
                this.fMq = false;
            }
        } else if (this.fMj != null && this.fMj.brq() != null && !this.fMq) {
            this.frt.addHeaderView(this.fMj.brq(), this.frt.getHeaderViewsCount());
            this.fMq = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bqo() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fMl, str);
        this.fMn = i2;
        this.fMl = str;
        bqq();
        if (this.fMj == null || z) {
            this.fMj = this.fMr.a(str, this.fGZ, i);
            this.fMj.changeSkinType(this.mSkinType);
            this.fMj.v(this.fqZ);
        }
        this.frt.addHeaderView(this.fMj.getView());
        xb(this.mPageType);
        bqs();
    }

    public void bqp() {
        if (!this.fMq && this.fMj != null) {
            this.frt.addHeaderView(this.fMj.brq());
            this.fMq = true;
        }
    }

    private void bqq() {
        if (this.fMj != null) {
            this.frt.removeHeaderView(this.fMj.getView());
            this.frt.removeHeaderView(this.fMj.brq());
            bqr();
        }
        this.fMq = false;
    }

    private void bqr() {
        if (this.fMv != null && this.fGZ != null && this.fGZ.ajY() != null) {
            this.fGZ.ajY().removeHeaderView(this.fMv.bqF());
        }
    }

    private void xb(String str) {
        RelativeLayout bqF;
        if (this.fMv != null && this.fGZ != null && this.fGZ.ajY() != null && (bqF = this.fMv.bqF()) != null) {
            if ("brand_page".equals(str)) {
                this.fGZ.ajY().removeHeaderView(bqF);
                return;
            }
            this.fGZ.ajY().removeHeaderView(bqF);
            this.fGZ.ajY().addHeaderView(bqF, 0);
        }
    }

    private void bqs() {
        if (this.fMm == null) {
            this.fMm = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fGZ.bjM() == null || !f.this.fGZ.bjM().bkk()) && f.this.frt.isShown() && f.this.fGZ.isPrimary() && !f.this.fMo && f.this.fMn == 1 && f.this.fGZ.bjM() != null && f.this.fGZ.bjM().bkG() != null && !f.this.fGZ.bjM().bkG().bql() && f.this.fGZ.bkp()) {
                            if (("frs_page".equals(f.this.fMl) || "normal_page".equals(f.this.fMl) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fMl)) && f.this.fMj != null && f.this.fMj.brp()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bmM();
                                f.this.fGZ.foC = true;
                                f.this.fMo = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.iB().postDelayed(this.fMm, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fMj.bmB();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fMj != null) {
                this.fMj.a(forumData, frsViewData);
                this.fMj.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fMj.sW(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fMj.kM(false);
                        return;
                    }
                    this.fMj.kM(true);
                    this.fMj.sW(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fMk = forumData.getLevelupScore();
        this.flv = forumData.getCurScore();
        if (this.fMk > 0) {
            return this.flv / this.fMk;
        }
        return 0.0f;
    }

    public void sA(int i) {
        if (i > 1) {
            if (this.fMj != null) {
                this.fMj.kN(false);
            }
        } else if (this.fMj != null) {
            this.fMj.kN(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bqt() {
        if (this.frt != null) {
            this.frt.removeCallbacks(this.drd);
            this.frt.postDelayed(this.drd, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bqu();
        }
    }

    public void setIsMem(int i) {
        if (this.fMj != null) {
            this.fMj.setMemberType(i);
        }
    }

    public void bmM() {
        if (("normal_page".equals(this.fMl) || "frs_page".equals(this.fMl) || "book_page".equals(this.fMl) || "brand_page".equals(this.mPageType)) && this.fMj != null) {
            this.fMj.bmM();
        }
    }

    public void bqu() {
        if (this.fMj != null) {
            this.fMj.bmO();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bqv() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            sC(0);
        }
    }

    public void sB(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            sC(i);
        }
    }

    public void sC(int i) {
        if (this.fMj != null) {
            this.fMj.sV(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fMj != null) {
            this.fMj.a(forumData, frsViewData);
            if (forumData != null) {
                this.fMj.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fMj.kM(false);
                }
            }
        }
    }

    public boolean bqw() {
        if (("normal_page".equals(this.fMl) || "frs_page".equals(this.fMl) || "book_page".equals(this.fMl) || "brand_page".equals(this.mPageType)) && this.fMj != null) {
            return this.fMj.bro();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fMk - this.flv) {
                z = true;
                this.fMk = signData.levelup_score;
            }
            this.flv = i + this.flv;
            if (this.flv > this.fMk) {
                this.flv = this.fMk;
            }
            if (this.fMk != 0) {
                f = this.flv / this.fMk;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void sD(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fMj != null) {
            this.fMj.sW(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fMj != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fMj.a(forum, frsViewData);
                this.fMj.sW(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fMj.bro()) {
                    a(this.fMj, signData);
                    forum.setCurScore(this.flv);
                    forum.setLevelupScore(this.fMk);
                    this.fMj.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bqx() {
        if (("normal_page".equals(this.fMl) || "frs_page".equals(this.fMl) || "book_page".equals(this.fMl) || "brand_page".equals(this.mPageType)) && this.fMj != null) {
            return this.fMj.bqx();
        }
        return false;
    }

    public boolean bqy() {
        if (("normal_page".equals(this.fMl) || "frs_page".equals(this.fMl) || "book_page".equals(this.fMl) || "brand_page".equals(this.mPageType)) && this.fMj != null) {
            return this.fMj.bqy();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kF(boolean z) {
        if (this.fGZ != null) {
            FrsViewData bkj = this.fGZ.bkj();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fGZ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bkj != null && bkj.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fGZ.getFrom())) {
                    TiebaStatic.log(new am("c10356").bT("fid", bkj.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fGZ.getFrom())) {
                    TiebaStatic.log(new am("c10590").P("obj_type", 2).bT("fid", bkj.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fGZ.getFrom())) {
                    TiebaStatic.log(new am("c10587").P("obj_type", 2).bT("fid", bkj.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fGZ.getFrom())) {
                    TiebaStatic.log(new am("c10578").P("obj_type", 2).bT("fid", bkj.getForum().getId()));
                }
                this.ccn.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fGZ.getFrom())) {
                    TiebaStatic.eventStat(this.fGZ.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fGZ.getFrom())) {
                    TiebaStatic.log(new am("c10359").bT("fid", bkj.getForum().getId()));
                }
                this.ccn.ac(bkj.getForum().getName(), bkj.getForum().getId(), "FRS");
                this.fMs = z;
            }
        }
    }

    public void bqz() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fGZ.bkj() != null && this.fGZ.bkj().getForum() != null && this.fGZ.bkj().getForum().getName() != null) {
            str = this.fGZ.bkj().getForum().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.mE(String.format(getPageContext().getString(R.string.attention_cancel_dialog_content), str));
        } else {
            aVar.mE(getPageContext().getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                FrsViewData bkj = f.this.fGZ.bkj();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fGZ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bkj != null && bkj.getForum() != null) {
                    f.this.fMp.C(bkj.getForum().getName(), com.baidu.adp.lib.g.b.c(bkj.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).afG();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bqA() {
        FrsViewData bkj = this.fGZ.bkj();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fGZ.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bkj != null && bkj.getForum() != null) {
            FrsActivityStatic.forumName = bkj.getForum().getName() == null ? "" : bkj.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bkj.getForum());
            customMessage.setTag(this.fMu);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(String str) {
        if (this.fGZ.bjH() != null && this.fGZ.bjH().boX() != null) {
            com.baidu.tieba.tbadkCore.d.clu().aw(com.baidu.tieba.tbadkCore.d.clu().c("1~" + str, this.fGZ.bjH().boX().getSortType(), this.fGZ.bjH().boX().getIsGood(), this.fGZ.bjH().boX().getCategoryId()), false);
        }
    }

    private void aIr() {
        this.ccn = new LikeModel(this.fGZ.getPageContext());
        this.ccn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                FrsViewData bkj = f.this.fGZ.bkj();
                if (bkj != null && bkj.getForum() != null && obj != null) {
                    if (AntiHelper.aG(f.this.ccn.getErrorCode(), f.this.ccn.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.ccn.getBlockPopInfoData(), f.this.fMw) != null) {
                            TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTf));
                            return;
                        }
                        return;
                    }
                    String name = bkj.getForum().getName();
                    String id = bkj.getForum().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.ccn.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).afO();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.ccn.getErrorCode() == 22) {
                            f.this.fGZ.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fGZ.showToast(f.this.ccn.getErrorString());
                        }
                    } else {
                        f.this.xc(name);
                        rVar.setLike(1);
                        bkj.updateLikeData(rVar);
                        bkj.setLikeFeedForumDataList(rVar.clC());
                        f.this.a(bkj, f.this.fMs);
                        f.this.fMs = true;
                        f.this.fGZ.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.k(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.fGZ.as(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bqB() {
        this.fMp = new w();
        this.fMp.setFrom("from_frs");
        this.fMp.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void u(String str, long j) {
                FrsViewData bkj = f.this.fGZ.bkj();
                if (bkj != null && bkj.getForum() != null) {
                    String name = bkj.getForum().getName();
                    String id = bkj.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.xc(str);
                        bkj.getForum().setLike(0);
                        f.this.sB(0);
                        f.this.fGZ.ar(true);
                        f.this.k(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        r rVar = new r();
                        rVar.setLike(0);
                        rVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void v(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bDH().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void J(int i, int i2, int i3) {
        FrsViewData bkj;
        if (i > 0 && i2 > 0 && (bkj = this.fGZ.bkj()) != null && bkj.getForum() != null && bkj.getSignData() != null) {
            ForumData forum = bkj.getForum();
            SignData signData = bkj.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bkj.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (bqy()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bmJ() {
        if (this.fMj != null) {
            this.fMj.bmJ();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().abL(), true) || frsViewData.getBookInfo().abL().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().clD() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.aa(frsViewData.getActivityHeadData().abJ())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().abS(), true)))) ? false : true;
        }
        return false;
    }

    public void sE(int i) {
        View findViewById;
        if (this.fMj != null && this.fMj.brq() != null && (findViewById = this.fMj.brq().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fMt != null) {
            this.fMt.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fMv = frsTabViewController;
    }
}
