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
    private LikeModel cco;
    private Runnable dre;
    private FrsFragment fHd;
    private CustomMessageListener fMA;
    private com.baidu.tieba.frs.view.b fMm;
    private int fMn;
    private String fMo;
    private Runnable fMp;
    private int fMq;
    private boolean fMr;
    private w fMs;
    private boolean fMt;
    private com.baidu.tieba.frs.entelechy.b.a fMu;
    private boolean fMv;
    private com.baidu.tieba.f.a fMw;
    private BdUniqueId fMx;
    private FrsTabViewController fMy;
    private AntiHelper.a fMz;
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
        this.fMo = null;
        this.fMr = false;
        this.cco = null;
        this.fMs = null;
        this.fMt = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTe));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTe));
            }
        };
        this.fMz = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").P("obj_locate", at.a.bTg));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").P("obj_locate", at.a.bTg));
            }
        };
        this.fMA = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bkm;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fHd != null && (customResponsedMessage instanceof SignMessage) && (bkm = f.this.fHd.bkm()) != null && bkm.getForum() != null && (name = bkm.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fMx) {
                    TiebaStatic.eventStat(f.this.fHd.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bkm.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aG(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aI(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTe));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bkm.getForum().getId())) {
                            f.this.xe(name2);
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
                        if (f.this.bqD()) {
                            i = bkm.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bqB()) {
                            f.this.fHd.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fHd.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fHd.bjP() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.anA().a(f.this.fHd.getTbPageContext(), f.this.fHd.bjP().bld());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.sD(1);
                    }
                    f.this.fHd.showToast(signMessage.mSignErrorString);
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
                FrsViewData bkm = f.this.fHd.bkm();
                if (bkm != null && bkm.getForum() != null && f.this.fMm != null && (view == f.this.fMm.brw() || view == f.this.fMm.brx() || view == f.this.fMm.bry())) {
                    if (f.this.fHd != null && bkm.getForum() != null) {
                        TiebaStatic.log(new am("c12046").bT("fid", bkm.getForum().getId()).P("obj_locate", f.this.fHd.bko() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bkm.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fHd.bkn()) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            f.this.fHd.showToast(R.string.neterror);
                        } else if (!bc.cE(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").P("obj_locate", 1).bT("fid", f.this.fHd.getForumId()));
                        } else {
                            f.this.kG(true);
                            if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.bT("fid", f.this.fHd.getForumId());
                                amVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fHd.bkn()) {
                        if (!com.baidu.adp.lib.util.j.jS()) {
                            f.this.fHd.showToast(R.string.neterror);
                        } else if (bc.cE(f.this.mContext.getPageActivity())) {
                            if (!f.this.bqC()) {
                                f.this.bqF();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fHd.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(f.this.fHd.getForumId(), 0), 24002)));
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
                } else if (id == R.id.level_container && !f.this.fHd.bkn() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fMm != null) {
                        f.this.fMm.k(view, false);
                    }
                }
            }
        };
        this.fHd = frsFragment;
        this.fMu = aVar;
        this.fru = frsHeaderViewContainer;
        this.fMx = BdUniqueId.gen();
        this.fMw = new com.baidu.tieba.f.a();
        this.fMw.a(new a.InterfaceC0302a() { // from class: com.baidu.tieba.frs.vc.f.6
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
        this.fHd.registerListener(this.fMA);
        aIu();
        bqG();
        this.fMr = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.fMm != null) {
            this.fMm.onDestory();
        }
        if (this.cco != null) {
            this.cco.clM();
        }
        if (this.fMp != null) {
            com.baidu.adp.lib.g.e.iB().removeCallbacks(this.fMp);
        }
    }

    public void onActivityStop() {
        if (this.fMm != null) {
            this.fMm.onStop();
        }
        if (this.fru != null) {
            this.fru.removeCallbacks(this.dre);
        }
    }

    public void jI(boolean z) {
        if (this.fMm != null) {
            this.fMm.jI(z);
        }
    }

    public boolean sz(int i) {
        this.mSkinType = i;
        if (this.fMm != null) {
            this.fMm.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kF(boolean z) {
        if (z) {
            if (this.fMm != null) {
                this.fru.removeHeaderView(this.fMm.brv());
                this.fMt = false;
            }
        } else if (this.fMm != null && this.fMm.brv() != null && !this.fMt) {
            this.fru.addHeaderView(this.fMm.brv(), this.fru.getHeaderViewsCount());
            this.fMt = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bqt() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fMo, str);
        this.fMq = i2;
        this.fMo = str;
        bqv();
        if (this.fMm == null || z) {
            this.fMm = this.fMu.a(str, this.fHd, i);
            this.fMm.changeSkinType(this.mSkinType);
            this.fMm.v(this.fra);
        }
        this.fru.addHeaderView(this.fMm.getView());
        xd(this.mPageType);
        bqx();
    }

    public void bqu() {
        if (!this.fMt && this.fMm != null) {
            this.fru.addHeaderView(this.fMm.brv());
            this.fMt = true;
        }
    }

    private void bqv() {
        if (this.fMm != null) {
            this.fru.removeHeaderView(this.fMm.getView());
            this.fru.removeHeaderView(this.fMm.brv());
            bqw();
        }
        this.fMt = false;
    }

    private void bqw() {
        if (this.fMy != null && this.fHd != null && this.fHd.ajY() != null) {
            this.fHd.ajY().removeHeaderView(this.fMy.bqK());
        }
    }

    private void xd(String str) {
        RelativeLayout bqK;
        if (this.fMy != null && this.fHd != null && this.fHd.ajY() != null && (bqK = this.fMy.bqK()) != null) {
            if ("brand_page".equals(str)) {
                this.fHd.ajY().removeHeaderView(bqK);
                return;
            }
            this.fHd.ajY().removeHeaderView(bqK);
            this.fHd.ajY().addHeaderView(bqK, 0);
        }
    }

    private void bqx() {
        if (this.fMp == null) {
            this.fMp = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fHd.bjP() == null || !f.this.fHd.bjP().bkn()) && f.this.fru.isShown() && f.this.fHd.isPrimary() && !f.this.fMr && f.this.fMq == 1 && f.this.fHd.bjP() != null && f.this.fHd.bjP().bkJ() != null && !f.this.fHd.bjP().bkJ().bqq() && f.this.fHd.bks()) {
                            if (("frs_page".equals(f.this.fMo) || "normal_page".equals(f.this.fMo) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fMo)) && f.this.fMm != null && f.this.fMm.bru()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bmP();
                                f.this.fHd.foD = true;
                                f.this.fMr = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.iB().postDelayed(this.fMp, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fMm.bmE();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fMm != null) {
                this.fMm.a(forumData, frsViewData);
                this.fMm.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fMm.sW(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fMm.kN(false);
                        return;
                    }
                    this.fMm.kN(true);
                    this.fMm.sW(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fMn = forumData.getLevelupScore();
        this.flw = forumData.getCurScore();
        if (this.fMn > 0) {
            return this.flw / this.fMn;
        }
        return 0.0f;
    }

    public void sA(int i) {
        if (i > 1) {
            if (this.fMm != null) {
                this.fMm.kO(false);
            }
        } else if (this.fMm != null) {
            this.fMm.kO(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bqy() {
        if (this.fru != null) {
            this.fru.removeCallbacks(this.dre);
            this.fru.postDelayed(this.dre, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bqz();
        }
    }

    public void setIsMem(int i) {
        if (this.fMm != null) {
            this.fMm.setMemberType(i);
        }
    }

    public void bmP() {
        if (("normal_page".equals(this.fMo) || "frs_page".equals(this.fMo) || "book_page".equals(this.fMo) || "brand_page".equals(this.mPageType)) && this.fMm != null) {
            this.fMm.bmP();
        }
    }

    public void bqz() {
        if (this.fMm != null) {
            this.fMm.bmR();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bqA() {
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
        if (this.fMm != null) {
            this.fMm.sV(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fMm != null) {
            this.fMm.a(forumData, frsViewData);
            if (forumData != null) {
                this.fMm.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fMm.kN(false);
                }
            }
        }
    }

    public boolean bqB() {
        if (("normal_page".equals(this.fMo) || "frs_page".equals(this.fMo) || "book_page".equals(this.fMo) || "brand_page".equals(this.mPageType)) && this.fMm != null) {
            return this.fMm.brt();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fMn - this.flw) {
                z = true;
                this.fMn = signData.levelup_score;
            }
            this.flw = i + this.flw;
            if (this.flw > this.fMn) {
                this.flw = this.fMn;
            }
            if (this.fMn != 0) {
                f = this.flw / this.fMn;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void sD(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fMm != null) {
            this.fMm.sW(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fMm != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fMm.a(forum, frsViewData);
                this.fMm.sW(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fMm.brt()) {
                    a(this.fMm, signData);
                    forum.setCurScore(this.flw);
                    forum.setLevelupScore(this.fMn);
                    this.fMm.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bqC() {
        if (("normal_page".equals(this.fMo) || "frs_page".equals(this.fMo) || "book_page".equals(this.fMo) || "brand_page".equals(this.mPageType)) && this.fMm != null) {
            return this.fMm.bqC();
        }
        return false;
    }

    public boolean bqD() {
        if (("normal_page".equals(this.fMo) || "frs_page".equals(this.fMo) || "book_page".equals(this.fMo) || "brand_page".equals(this.mPageType)) && this.fMm != null) {
            return this.fMm.bqD();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kG(boolean z) {
        if (this.fHd != null) {
            FrsViewData bkm = this.fHd.bkm();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fHd.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11002)));
            } else if (bkm != null && bkm.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fHd.getFrom())) {
                    TiebaStatic.log(new am("c10356").bT("fid", bkm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fHd.getFrom())) {
                    TiebaStatic.log(new am("c10590").P("obj_type", 2).bT("fid", bkm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fHd.getFrom())) {
                    TiebaStatic.log(new am("c10587").P("obj_type", 2).bT("fid", bkm.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fHd.getFrom())) {
                    TiebaStatic.log(new am("c10578").P("obj_type", 2).bT("fid", bkm.getForum().getId()));
                }
                this.cco.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fHd.getFrom())) {
                    TiebaStatic.eventStat(this.fHd.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fHd.getFrom())) {
                    TiebaStatic.log(new am("c10359").bT("fid", bkm.getForum().getId()));
                }
                this.cco.ac(bkm.getForum().getName(), bkm.getForum().getId(), "FRS");
                this.fMv = z;
            }
        }
    }

    public void bqE() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fHd.bkm() != null && this.fHd.bkm().getForum() != null && this.fHd.bkm().getForum().getName() != null) {
            str = this.fHd.bkm().getForum().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.mD(String.format(getPageContext().getString(R.string.attention_cancel_dialog_content), str));
        } else {
            aVar.mD(getPageContext().getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                FrsViewData bkm = f.this.fHd.bkm();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fHd.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bkm != null && bkm.getForum() != null) {
                    f.this.fMs.C(bkm.getForum().getName(), com.baidu.adp.lib.g.b.c(bkm.getForum().getId(), 0L));
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
    public void bqF() {
        FrsViewData bkm = this.fHd.bkm();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fHd.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bkm != null && bkm.getForum() != null) {
            FrsActivityStatic.forumName = bkm.getForum().getName() == null ? "" : bkm.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bkm.getForum());
            customMessage.setTag(this.fMx);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xe(String str) {
        if (this.fHd.bjK() != null && this.fHd.bjK().bpc() != null) {
            com.baidu.tieba.tbadkCore.d.clx().aw(com.baidu.tieba.tbadkCore.d.clx().c("1~" + str, this.fHd.bjK().bpc().getSortType(), this.fHd.bjK().bpc().getIsGood(), this.fHd.bjK().bpc().getCategoryId()), false);
        }
    }

    private void aIu() {
        this.cco = new LikeModel(this.fHd.getPageContext());
        this.cco.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                FrsViewData bkm = f.this.fHd.bkm();
                if (bkm != null && bkm.getForum() != null && obj != null) {
                    if (AntiHelper.aG(f.this.cco.getErrorCode(), f.this.cco.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cco.getBlockPopInfoData(), f.this.fMz) != null) {
                            TiebaStatic.log(new am("c12534").P("obj_locate", at.a.bTg));
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
                    boolean z2 = rVar != null && f.this.cco.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).afO();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.cco.getErrorCode() == 22) {
                            f.this.fHd.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fHd.showToast(f.this.cco.getErrorString());
                        }
                    } else {
                        f.this.xe(name);
                        rVar.setLike(1);
                        bkm.updateLikeData(rVar);
                        bkm.setLikeFeedForumDataList(rVar.clF());
                        f.this.a(bkm, f.this.fMv);
                        f.this.fMv = true;
                        f.this.fHd.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.k(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.fHd.as(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bqG() {
        this.fMs = new w();
        this.fMs.setFrom("from_frs");
        this.fMs.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void u(String str, long j) {
                FrsViewData bkm = f.this.fHd.bkm();
                if (bkm != null && bkm.getForum() != null) {
                    String name = bkm.getForum().getName();
                    String id = bkm.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.xe(str);
                        bkm.getForum().setLike(0);
                        f.this.sB(0);
                        f.this.fHd.ar(true);
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
        com.baidu.tieba.im.settingcache.d.bDL().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void J(int i, int i2, int i3) {
        FrsViewData bkm;
        if (i > 0 && i2 > 0 && (bkm = this.fHd.bkm()) != null && bkm.getForum() != null && bkm.getSignData() != null) {
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
            if (bqD()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bmM() {
        if (this.fMm != null) {
            this.fMm.bmM();
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
            return ((frsViewData.getStar() == null || frsViewData.getStar().clG() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.aa(frsViewData.getActivityHeadData().abJ())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().abS(), true)))) ? false : true;
        }
        return false;
    }

    public void sE(int i) {
        View findViewById;
        if (this.fMm != null && this.fMm.brv() != null && (findViewById = this.fMm.brv().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.fMw != null) {
            this.fMw.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fMy = frsTabViewController;
    }
}
