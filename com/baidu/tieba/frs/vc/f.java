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
import com.baidu.sapi2.utils.SapiGIDEvent;
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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
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
    private LikeModel cdr;
    private Runnable dtn;
    private FrsFragment fMb;
    private com.baidu.tieba.frs.view.b fRj;
    private int fRk;
    private String fRl;
    private Runnable fRm;
    private int fRn;
    private boolean fRo;
    private w fRp;
    private boolean fRq;
    private com.baidu.tieba.frs.entelechy.b.a fRr;
    private boolean fRs;
    private com.baidu.tieba.f.a fRt;
    private BdUniqueId fRu;
    private FrsTabViewController fRv;
    private AntiHelper.a fRw;
    private CustomMessageListener fRx;
    private int fqu;
    private final View.OnClickListener fvY;
    private FrsHeaderViewContainer fwr;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fwr = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fRl = null;
        this.fRo = false;
        this.cdr = null;
        this.fRp = null;
        this.fRq = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUf));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUf));
            }
        };
        this.fRw = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUh));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUh));
            }
        };
        this.fRx = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bmo;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fMb != null && (customResponsedMessage instanceof SignMessage) && (bmo = f.this.fMb.bmo()) != null && bmo.getForum() != null && (name = bmo.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fRu) {
                    TiebaStatic.eventStat(f.this.fMb.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bmo.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aG(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aJ(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUf));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bmo.getForum().getId())) {
                            f.this.xJ(name2);
                            bmo.updateSignData(signData2);
                            signData2.forumId = bmo.getForum().getId();
                            signData2.forumName = bmo.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bmo.getForum().getUser_level();
                        if (f.this.bsE()) {
                            i = bmo.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bsC()) {
                            f.this.fMb.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fMb.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fMb.blR() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aoF().a(f.this.fMb.getTbPageContext(), f.this.fMb.blR().aXy());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.sV(1);
                    }
                    f.this.fMb.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dtn = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fwr != null) {
                    int childCount = f.this.fwr.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fwr.getChildAt(i));
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
        this.fvY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bmo = f.this.fMb.bmo();
                if (bmo != null && bmo.getForum() != null && f.this.fRj != null && (view == f.this.fRj.btx() || view == f.this.fRj.bty() || view == f.this.fRj.btz())) {
                    if (f.this.fMb != null && bmo.getForum() != null) {
                        TiebaStatic.log(new an("c12046").bT("fid", bmo.getForum().getId()).P("obj_locate", f.this.fMb.bmq() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bmo.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fMb.bmp()) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            f.this.fMb.showToast(R.string.neterror);
                        } else if (!bd.cF(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").P("obj_locate", 1).bT("fid", f.this.fMb.getForumId()));
                        } else {
                            f.this.kQ(true);
                            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                an anVar = new an("c10048");
                                anVar.bT("fid", f.this.fMb.getForumId());
                                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fMb.bmp()) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            f.this.fMb.showToast(R.string.neterror);
                        } else if (bd.cF(f.this.mContext.getPageActivity())) {
                            if (!f.this.bsD()) {
                                f.this.bsG();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fMb.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(f.this.fMb.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == R.id.frs_header_games) {
                    if (bd.cF(f.this.mContext.getPageActivity()) && bmo != null && bmo.getGameUrl() != null) {
                        bb.ajC().a((TbPageContext) f.this.getPageContext(), new String[]{bmo.getGameUrl()}, true);
                    }
                } else if (id == R.id.frs_bawu_center) {
                    if (bmo != null && bmo.getUserData() != null && bmo.getUserData().isBawu()) {
                        String bawuCenterUrl = bmo.getBawuCenterUrl();
                        if (!aq.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.ae(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bmo.getForum() != null) {
                                TiebaStatic.log(new an("c10502").bT("fid", bmo.getForum().getId()).bT("uid", bmo.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == R.id.level_container && !f.this.fMb.bmp() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fRj != null) {
                        f.this.fRj.k(view, false);
                    }
                }
            }
        };
        this.fMb = frsFragment;
        this.fRr = aVar;
        this.fwr = frsHeaderViewContainer;
        this.fRu = BdUniqueId.gen();
        this.fRt = new com.baidu.tieba.f.a();
        this.fRt.a(new a.InterfaceC0305a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0305a
            public void ba(int i, int i2) {
            }
        });
    }

    public void R(Bundle bundle) {
        this.fMb.registerListener(this.fRx);
        aJV();
        bsH();
        this.fRo = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aFO() {
        if (this.fRj != null) {
            this.fRj.onDestory();
        }
        if (this.cdr != null) {
            this.cdr.coE();
        }
        if (this.fRm != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fRm);
        }
    }

    public void aku() {
        if (this.fRj != null) {
            this.fRj.onStop();
        }
        if (this.fwr != null) {
            this.fwr.removeCallbacks(this.dtn);
        }
    }

    public void jS(boolean z) {
        if (this.fRj != null) {
            this.fRj.jS(z);
        }
    }

    public boolean sR(int i) {
        this.mSkinType = i;
        if (this.fRj != null) {
            this.fRj.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kP(boolean z) {
        if (z) {
            if (this.fRj != null) {
                this.fwr.removeHeaderView(this.fRj.btw());
                this.fRq = false;
            }
        } else if (this.fRj != null && this.fRj.btw() != null && !this.fRq) {
            this.fwr.addHeaderView(this.fRj.btw(), this.fwr.getHeaderViewsCount());
            this.fRq = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bsu() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fRl, str);
        this.fRn = i2;
        this.fRl = str;
        bsw();
        if (this.fRj == null || z) {
            this.fRj = this.fRr.a(str, this.fMb, i);
            this.fRj.changeSkinType(this.mSkinType);
            this.fRj.v(this.fvY);
        }
        this.fwr.addHeaderView(this.fRj.getView());
        xI(this.mPageType);
        bsy();
    }

    public void bsv() {
        if (!this.fRq && this.fRj != null) {
            this.fwr.addHeaderView(this.fRj.btw());
            this.fRq = true;
        }
    }

    private void bsw() {
        if (this.fRj != null) {
            this.fwr.removeHeaderView(this.fRj.getView());
            this.fwr.removeHeaderView(this.fRj.btw());
            bsx();
        }
        this.fRq = false;
    }

    private void bsx() {
        if (this.fRv != null && this.fMb != null && this.fMb.ald() != null) {
            this.fMb.ald().removeHeaderView(this.fRv.bsL());
        }
    }

    private void xI(String str) {
        RelativeLayout bsL;
        if (this.fRv != null && this.fMb != null && this.fMb.ald() != null && (bsL = this.fRv.bsL()) != null) {
            if ("brand_page".equals(str)) {
                this.fMb.ald().removeHeaderView(bsL);
                return;
            }
            this.fMb.ald().removeHeaderView(bsL);
            this.fMb.ald().addHeaderView(bsL, 0);
        }
    }

    private void bsy() {
        if (this.fRm == null) {
            this.fRm = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fMb.blR() == null || !f.this.fMb.blR().bmp()) && f.this.fwr.isShown() && f.this.fMb.isPrimary() && !f.this.fRo && f.this.fRn == 1 && f.this.fMb.blR() != null && f.this.fMb.blR().bmL() != null && !f.this.fMb.blR().bmL().bsr() && f.this.fMb.bmu()) {
                            if (("frs_page".equals(f.this.fRl) || "normal_page".equals(f.this.fRl) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fRl)) && f.this.fRj != null && f.this.fRj.btv()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.boQ();
                                f.this.fMb.ftC = true;
                                f.this.fRo = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fRm, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fRj.boF();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fRj != null) {
                this.fRj.a(forumData, frsViewData);
                this.fRj.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fRj.to(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fRj.kX(false);
                        return;
                    }
                    this.fRj.kX(true);
                    this.fRj.to(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fRk = forumData.getLevelupScore();
        this.fqu = forumData.getCurScore();
        if (this.fRk > 0) {
            return this.fqu / this.fRk;
        }
        return 0.0f;
    }

    public void sS(int i) {
        if (i > 1) {
            if (this.fRj != null) {
                this.fRj.kY(false);
            }
        } else if (this.fRj != null) {
            this.fRj.kY(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bsz() {
        if (this.fwr != null) {
            this.fwr.removeCallbacks(this.dtn);
            this.fwr.postDelayed(this.dtn, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bsA();
        }
    }

    public void setIsMem(int i) {
        if (this.fRj != null) {
            this.fRj.setMemberType(i);
        }
    }

    public void boQ() {
        if (("normal_page".equals(this.fRl) || "frs_page".equals(this.fRl) || "book_page".equals(this.fRl) || "brand_page".equals(this.mPageType)) && this.fRj != null) {
            this.fRj.boQ();
        }
    }

    public void bsA() {
        if (this.fRj != null) {
            this.fRj.boS();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bsB() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            sU(0);
        }
    }

    public void sT(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            sU(i);
        }
    }

    public void sU(int i) {
        if (this.fRj != null) {
            this.fRj.tn(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fRj != null) {
            this.fRj.a(forumData, frsViewData);
            if (forumData != null) {
                this.fRj.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fRj.kX(false);
                }
            }
        }
    }

    public boolean bsC() {
        if (("normal_page".equals(this.fRl) || "frs_page".equals(this.fRl) || "book_page".equals(this.fRl) || "brand_page".equals(this.mPageType)) && this.fRj != null) {
            return this.fRj.btu();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fRk - this.fqu) {
                z = true;
                this.fRk = signData.levelup_score;
            }
            this.fqu = i + this.fqu;
            if (this.fqu > this.fRk) {
                this.fqu = this.fRk;
            }
            if (this.fRk != 0) {
                f = this.fqu / this.fRk;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void sV(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fRj != null) {
            this.fRj.to(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fRj != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fRj.a(forum, frsViewData);
                this.fRj.to(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fRj.btu()) {
                    a(this.fRj, signData);
                    forum.setCurScore(this.fqu);
                    forum.setLevelupScore(this.fRk);
                    this.fRj.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bsD() {
        if (("normal_page".equals(this.fRl) || "frs_page".equals(this.fRl) || "book_page".equals(this.fRl) || "brand_page".equals(this.mPageType)) && this.fRj != null) {
            return this.fRj.bsD();
        }
        return false;
    }

    public boolean bsE() {
        if (("normal_page".equals(this.fRl) || "frs_page".equals(this.fRl) || "book_page".equals(this.fRl) || "brand_page".equals(this.mPageType)) && this.fRj != null) {
            return this.fRj.bsE();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kQ(boolean z) {
        if (this.fMb != null) {
            FrsViewData bmo = this.fMb.bmo();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fMb.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, SapiGIDEvent.SYSTEM_NETWORK_CHANGE_MOB_TO_WIFI)));
            } else if (bmo != null && bmo.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fMb.getFrom())) {
                    TiebaStatic.log(new an("c10356").bT("fid", bmo.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fMb.getFrom())) {
                    TiebaStatic.log(new an("c10590").P("obj_type", 2).bT("fid", bmo.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fMb.getFrom())) {
                    TiebaStatic.log(new an("c10587").P("obj_type", 2).bT("fid", bmo.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fMb.getFrom())) {
                    TiebaStatic.log(new an("c10578").P("obj_type", 2).bT("fid", bmo.getForum().getId()));
                }
                this.cdr.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fMb.getFrom())) {
                    TiebaStatic.eventStat(this.fMb.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fMb.getFrom())) {
                    TiebaStatic.log(new an("c10359").bT("fid", bmo.getForum().getId()));
                }
                this.cdr.ac(bmo.getForum().getName(), bmo.getForum().getId(), "FRS");
                this.fRs = z;
            }
        }
    }

    public void bsF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fMb.bmo() != null && this.fMb.bmo().getForum() != null && this.fMb.bmo().getForum().getName() != null) {
            str = this.fMb.bmo().getForum().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.mO(String.format(getPageContext().getString(R.string.attention_cancel_dialog_content), str));
        } else {
            aVar.mO(getPageContext().getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                FrsViewData bmo = f.this.fMb.bmo();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fMb.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bmo != null && bmo.getForum() != null) {
                    f.this.fRp.C(bmo.getForum().getName(), com.baidu.adp.lib.g.b.c(bmo.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).agI();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bsG() {
        FrsViewData bmo = this.fMb.bmo();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fMb.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bmo != null && bmo.getForum() != null) {
            FrsActivityStatic.forumName = bmo.getForum().getName() == null ? "" : bmo.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bmo.getForum());
            customMessage.setTag(this.fRu);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xJ(String str) {
        if (this.fMb.blM() != null && this.fMb.blM().brd() != null) {
            com.baidu.tieba.tbadkCore.d.cop().aA(com.baidu.tieba.tbadkCore.d.cop().c("1~" + str, this.fMb.blM().brd().getSortType(), this.fMb.blM().brd().getIsGood(), this.fMb.blM().brd().getCategoryId()), false);
        }
    }

    private void aJV() {
        this.cdr = new LikeModel(this.fMb.getPageContext());
        this.cdr.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                FrsViewData bmo = f.this.fMb.bmo();
                if (bmo != null && bmo.getForum() != null && obj != null) {
                    if (AntiHelper.aG(f.this.cdr.getErrorCode(), f.this.cdr.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cdr.getBlockPopInfoData(), f.this.fRw) != null) {
                            TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUh));
                            return;
                        }
                        return;
                    }
                    String name = bmo.getForum().getName();
                    String id = bmo.getForum().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.cdr.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.b(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).agQ();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.cdr.getErrorCode() == 22) {
                            f.this.fMb.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fMb.showToast(f.this.cdr.getErrorString());
                        }
                    } else {
                        f.this.xJ(name);
                        rVar.setLike(1);
                        bmo.updateLikeData(rVar);
                        bmo.setLikeFeedForumDataList(rVar.cox());
                        f.this.a(bmo, f.this.fRs);
                        f.this.fRs = true;
                        f.this.fMb.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.fMb.as(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bsH() {
        this.fRp = new w();
        this.fRp.setFrom("from_frs");
        this.fRp.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void u(String str, long j) {
                FrsViewData bmo = f.this.fMb.bmo();
                if (bmo != null && bmo.getForum() != null) {
                    String name = bmo.getForum().getName();
                    String id = bmo.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.xJ(str);
                        bmo.getForum().setLike(0);
                        f.this.sT(0);
                        f.this.fMb.ar(true);
                        f.this.l(false, id);
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
    public void l(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bGs().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void K(int i, int i2, int i3) {
        FrsViewData bmo;
        if (i > 0 && i2 > 0 && (bmo = this.fMb.bmo()) != null && bmo.getForum() != null && bmo.getSignData() != null) {
            ForumData forum = bmo.getForum();
            SignData signData = bmo.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bmo.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (bsE()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void boN() {
        if (this.fRj != null) {
            this.fRj.boN();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().acN(), true) || frsViewData.getBookInfo().acN().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().coy() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.aa(frsViewData.getActivityHeadData().acL())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().acU(), true)))) ? false : true;
        }
        return false;
    }

    public void sW(int i) {
        View findViewById;
        if (this.fRj != null && this.fRj.btw() != null && (findViewById = this.fRj.btw().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void L(MotionEvent motionEvent) {
        if (this.fRt != null) {
            this.fRt.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fRv = frsTabViewController;
    }
}
