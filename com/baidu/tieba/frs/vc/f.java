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
    private Runnable dre;
    private FrsFragment fHa;
    private com.baidu.tieba.frs.view.b fMk;
    private int fMl;
    private String fMm;
    private Runnable fMn;
    private int fMo;
    private boolean fMp;
    private w fMq;
    private boolean fMr;
    private com.baidu.tieba.frs.entelechy.b.a fMs;
    private boolean fMt;
    private com.baidu.tieba.f.a fMu;
    private BdUniqueId fMv;
    private FrsTabViewController fMw;
    private AntiHelper.a fMx;
    private CustomMessageListener fMy;
    private int flw;
    private final View.OnClickListener fra;
    private FrsHeaderViewContainer fru;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fru = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fMm = null;
        this.fMp = false;
        this.ccn = null;
        this.fMq = null;
        this.fMr = false;
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
        this.fMx = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTf));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTf));
            }
        };
        this.fMy = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bkm;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fHa != null && (customResponsedMessage instanceof SignMessage) && (bkm = f.this.fHa.bkm()) != null && bkm.getForum() != null && (name = bkm.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fMv) {
                    TiebaStatic.eventStat(f.this.fHa.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bkm.getForum().getName();
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
                        if (signData2.forumId != null && signData2.forumId.equals(bkm.getForum().getId())) {
                            f.this.xc(name2);
                            bkm.updateSignData(signData2);
                            signData2.forumId = bkm.getForum().getId();
                            signData2.forumName = bkm.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bkm.getForum().getUser_level();
                        if (f.this.bqB()) {
                            i = bkm.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bqz()) {
                            f.this.fHa.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fHa.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fHa.bjP() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.anA().a(f.this.fHa.getTbPageContext(), f.this.fHa.bjP().bld());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.sD(1);
                    }
                    f.this.fHa.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dre = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fru != null) {
                    int childCount = f.this.fru.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fru.getChildAt(i));
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
        this.fra = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bkm = f.this.fHa.bkm();
                if (bkm != null && bkm.getForum() != null && f.this.fMk != null && (view == f.this.fMk.bru() || view == f.this.fMk.brv() || view == f.this.fMk.brw())) {
                    if (f.this.fHa != null && bkm.getForum() != null) {
                        TiebaStatic.log(new am("c12046").bT("fid", bkm.getForum().getId()).P("obj_locate", f.this.fHa.bko() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bkm.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fHa.bkn()) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            f.this.fHa.showToast(R.string.neterror);
                        } else if (!bc.cE(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").P("obj_locate", 1).bT("fid", f.this.fHa.getForumId()));
                        } else {
                            f.this.kF(true);
                            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.bT("fid", f.this.fHa.getForumId());
                                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fHa.bkn()) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            f.this.fHa.showToast(R.string.neterror);
                        } else if (bc.cE(f.this.mContext.getPageActivity())) {
                            if (!f.this.bqA()) {
                                f.this.bqD();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fHa.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(f.this.fHa.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == R.id.frs_header_games) {
                    if (bc.cE(f.this.mContext.getPageActivity()) && bkm != null && bkm.getGameUrl() != null) {
                        ba.aiz().a((TbPageContext) f.this.getPageContext(), new String[]{bkm.getGameUrl()}, true);
                    }
                } else if (id == R.id.frs_bawu_center) {
                    if (bkm != null && bkm.getUserData() != null && bkm.getUserData().isBawu()) {
                        String bawuCenterUrl = bkm.getBawuCenterUrl();
                        if (!ap.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.af(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bkm.getForum() != null) {
                                TiebaStatic.log(new am("c10502").bT("fid", bkm.getForum().getId()).bT("uid", bkm.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == R.id.level_container && !f.this.fHa.bkn() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fMk != null) {
                        f.this.fMk.k(view, false);
                    }
                }
            }
        };
        this.fHa = frsFragment;
        this.fMs = aVar;
        this.fru = frsHeaderViewContainer;
        this.fMv = BdUniqueId.gen();
        this.fMu = new com.baidu.tieba.f.a();
        this.fMu.a(new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.vc.f.6
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
        this.fHa.registerListener(this.fMy);
        aIu();
        bqE();
        this.fMp = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.fMk != null) {
            this.fMk.onDestory();
        }
        if (this.ccn != null) {
            this.ccn.clL();
        }
        if (this.fMn != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fMn);
        }
    }

    public void onActivityStop() {
        if (this.fMk != null) {
            this.fMk.onStop();
        }
        if (this.fru != null) {
            this.fru.removeCallbacks(this.dre);
        }
    }

    public void jI(boolean z) {
        if (this.fMk != null) {
            this.fMk.jI(z);
        }
    }

    public boolean sz(int i) {
        this.mSkinType = i;
        if (this.fMk != null) {
            this.fMk.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kE(boolean z) {
        if (z) {
            if (this.fMk != null) {
                this.fru.removeHeaderView(this.fMk.brt());
                this.fMr = false;
            }
        } else if (this.fMk != null && this.fMk.brt() != null && !this.fMr) {
            this.fru.addHeaderView(this.fMk.brt(), this.fru.getHeaderViewsCount());
            this.fMr = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bqr() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fMm, str);
        this.fMo = i2;
        this.fMm = str;
        bqt();
        if (this.fMk == null || z) {
            this.fMk = this.fMs.a(str, this.fHa, i);
            this.fMk.changeSkinType(this.mSkinType);
            this.fMk.v(this.fra);
        }
        this.fru.addHeaderView(this.fMk.getView());
        xb(this.mPageType);
        bqv();
    }

    public void bqs() {
        if (!this.fMr && this.fMk != null) {
            this.fru.addHeaderView(this.fMk.brt());
            this.fMr = true;
        }
    }

    private void bqt() {
        if (this.fMk != null) {
            this.fru.removeHeaderView(this.fMk.getView());
            this.fru.removeHeaderView(this.fMk.brt());
            bqu();
        }
        this.fMr = false;
    }

    private void bqu() {
        if (this.fMw != null && this.fHa != null && this.fHa.ajY() != null) {
            this.fHa.ajY().removeHeaderView(this.fMw.bqI());
        }
    }

    private void xb(String str) {
        RelativeLayout bqI;
        if (this.fMw != null && this.fHa != null && this.fHa.ajY() != null && (bqI = this.fMw.bqI()) != null) {
            if ("brand_page".equals(str)) {
                this.fHa.ajY().removeHeaderView(bqI);
                return;
            }
            this.fHa.ajY().removeHeaderView(bqI);
            this.fHa.ajY().addHeaderView(bqI, 0);
        }
    }

    private void bqv() {
        if (this.fMn == null) {
            this.fMn = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fHa.bjP() == null || !f.this.fHa.bjP().bkn()) && f.this.fru.isShown() && f.this.fHa.isPrimary() && !f.this.fMp && f.this.fMo == 1 && f.this.fHa.bjP() != null && f.this.fHa.bjP().bkJ() != null && !f.this.fHa.bjP().bkJ().bqo() && f.this.fHa.bks()) {
                            if (("frs_page".equals(f.this.fMm) || "normal_page".equals(f.this.fMm) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fMm)) && f.this.fMk != null && f.this.fMk.brs()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bmP();
                                f.this.fHa.foD = true;
                                f.this.fMp = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.iB().postDelayed(this.fMn, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fMk.bmE();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fMk != null) {
                this.fMk.a(forumData, frsViewData);
                this.fMk.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fMk.sW(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fMk.kM(false);
                        return;
                    }
                    this.fMk.kM(true);
                    this.fMk.sW(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fMl = forumData.getLevelupScore();
        this.flw = forumData.getCurScore();
        if (this.fMl > 0) {
            return this.flw / this.fMl;
        }
        return 0.0f;
    }

    public void sA(int i) {
        if (i > 1) {
            if (this.fMk != null) {
                this.fMk.kN(false);
            }
        } else if (this.fMk != null) {
            this.fMk.kN(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bqw() {
        if (this.fru != null) {
            this.fru.removeCallbacks(this.dre);
            this.fru.postDelayed(this.dre, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bqx();
        }
    }

    public void setIsMem(int i) {
        if (this.fMk != null) {
            this.fMk.setMemberType(i);
        }
    }

    public void bmP() {
        if (("normal_page".equals(this.fMm) || "frs_page".equals(this.fMm) || "book_page".equals(this.fMm) || "brand_page".equals(this.mPageType)) && this.fMk != null) {
            this.fMk.bmP();
        }
    }

    public void bqx() {
        if (this.fMk != null) {
            this.fMk.bmR();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bqy() {
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
        if (this.fMk != null) {
            this.fMk.sV(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fMk != null) {
            this.fMk.a(forumData, frsViewData);
            if (forumData != null) {
                this.fMk.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fMk.kM(false);
                }
            }
        }
    }

    public boolean bqz() {
        if (("normal_page".equals(this.fMm) || "frs_page".equals(this.fMm) || "book_page".equals(this.fMm) || "brand_page".equals(this.mPageType)) && this.fMk != null) {
            return this.fMk.brr();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fMl - this.flw) {
                z = true;
                this.fMl = signData.levelup_score;
            }
            this.flw = i + this.flw;
            if (this.flw > this.fMl) {
                this.flw = this.fMl;
            }
            if (this.fMl != 0) {
                f = this.flw / this.fMl;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void sD(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fMk != null) {
            this.fMk.sW(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fMk != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fMk.a(forum, frsViewData);
                this.fMk.sW(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fMk.brr()) {
                    a(this.fMk, signData);
                    forum.setCurScore(this.flw);
                    forum.setLevelupScore(this.fMl);
                    this.fMk.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bqA() {
        if (("normal_page".equals(this.fMm) || "frs_page".equals(this.fMm) || "book_page".equals(this.fMm) || "brand_page".equals(this.mPageType)) && this.fMk != null) {
            return this.fMk.bqA();
        }
        return false;
    }

    public boolean bqB() {
        if (("normal_page".equals(this.fMm) || "frs_page".equals(this.fMm) || "book_page".equals(this.fMm) || "brand_page".equals(this.mPageType)) && this.fMk != null) {
            return this.fMk.bqB();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kF(boolean z) {
        if (this.fHa != null) {
            FrsViewData bkm = this.fHa.bkm();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fHa.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bkm != null && bkm.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fHa.getFrom())) {
                    TiebaStatic.log(new am("c10356").bT("fid", bkm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fHa.getFrom())) {
                    TiebaStatic.log(new am("c10590").P("obj_type", 2).bT("fid", bkm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fHa.getFrom())) {
                    TiebaStatic.log(new am("c10587").P("obj_type", 2).bT("fid", bkm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fHa.getFrom())) {
                    TiebaStatic.log(new am("c10578").P("obj_type", 2).bT("fid", bkm.getForum().getId()));
                }
                this.ccn.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fHa.getFrom())) {
                    TiebaStatic.eventStat(this.fHa.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fHa.getFrom())) {
                    TiebaStatic.log(new am("c10359").bT("fid", bkm.getForum().getId()));
                }
                this.ccn.ac(bkm.getForum().getName(), bkm.getForum().getId(), "FRS");
                this.fMt = z;
            }
        }
    }

    public void bqC() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fHa.bkm() != null && this.fHa.bkm().getForum() != null && this.fHa.bkm().getForum().getName() != null) {
            str = this.fHa.bkm().getForum().getName();
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
                FrsViewData bkm = f.this.fHa.bkm();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fHa.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bkm != null && bkm.getForum() != null) {
                    f.this.fMq.C(bkm.getForum().getName(), com.baidu.adp.lib.g.b.c(bkm.getForum().getId(), 0L));
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
    public void bqD() {
        FrsViewData bkm = this.fHa.bkm();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fHa.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bkm != null && bkm.getForum() != null) {
            FrsActivityStatic.forumName = bkm.getForum().getName() == null ? "" : bkm.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bkm.getForum());
            customMessage.setTag(this.fMv);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xc(String str) {
        if (this.fHa.bjK() != null && this.fHa.bjK().bpa() != null) {
            com.baidu.tieba.tbadkCore.d.clw().aw(com.baidu.tieba.tbadkCore.d.clw().c("1~" + str, this.fHa.bjK().bpa().getSortType(), this.fHa.bjK().bpa().getIsGood(), this.fHa.bjK().bpa().getCategoryId()), false);
        }
    }

    private void aIu() {
        this.ccn = new LikeModel(this.fHa.getPageContext());
        this.ccn.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                FrsViewData bkm = f.this.fHa.bkm();
                if (bkm != null && bkm.getForum() != null && obj != null) {
                    if (AntiHelper.aG(f.this.ccn.getErrorCode(), f.this.ccn.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.ccn.getBlockPopInfoData(), f.this.fMx) != null) {
                            TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTf));
                            return;
                        }
                        return;
                    }
                    String name = bkm.getForum().getName();
                    String id = bkm.getForum().getId();
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
                            f.this.fHa.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fHa.showToast(f.this.ccn.getErrorString());
                        }
                    } else {
                        f.this.xc(name);
                        rVar.setLike(1);
                        bkm.updateLikeData(rVar);
                        bkm.setLikeFeedForumDataList(rVar.clE());
                        f.this.a(bkm, f.this.fMt);
                        f.this.fMt = true;
                        f.this.fHa.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.k(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.fHa.as(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bqE() {
        this.fMq = new w();
        this.fMq.setFrom("from_frs");
        this.fMq.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void u(String str, long j) {
                FrsViewData bkm = f.this.fHa.bkm();
                if (bkm != null && bkm.getForum() != null) {
                    String name = bkm.getForum().getName();
                    String id = bkm.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.xc(str);
                        bkm.getForum().setLike(0);
                        f.this.sB(0);
                        f.this.fHa.ar(true);
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
        com.baidu.tieba.im.settingcache.d.bDK().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void J(int i, int i2, int i3) {
        FrsViewData bkm;
        if (i > 0 && i2 > 0 && (bkm = this.fHa.bkm()) != null && bkm.getForum() != null && bkm.getSignData() != null) {
            ForumData forum = bkm.getForum();
            SignData signData = bkm.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bkm.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (bqB()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bmM() {
        if (this.fMk != null) {
            this.fMk.bmM();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().clF() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.aa(frsViewData.getActivityHeadData().abJ())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().abS(), true)))) ? false : true;
        }
        return false;
    }

    public void sE(int i) {
        View findViewById;
        if (this.fMk != null && this.fMk.brt() != null && (findViewById = this.fMk.brt().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fMu != null) {
            this.fMu.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fMw = frsTabViewController;
    }
}
