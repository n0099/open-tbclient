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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel cdy;
    private Runnable dtu;
    private FrsFragment fMP;
    private com.baidu.tieba.frs.view.b fRX;
    private int fRY;
    private String fRZ;
    private Runnable fSa;
    private int fSb;
    private boolean fSc;
    private y fSd;
    private boolean fSe;
    private com.baidu.tieba.frs.entelechy.b.a fSf;
    private boolean fSg;
    private com.baidu.tieba.f.a fSh;
    private BdUniqueId fSi;
    private FrsTabViewController fSj;
    private AntiHelper.a fSk;
    private CustomMessageListener fSl;
    private int fqT;
    private FrsHeaderViewContainer fwQ;
    private final View.OnClickListener fwx;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fwQ = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fRZ = null;
        this.fSc = false;
        this.cdy = null;
        this.fSd = null;
        this.fSe = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUl));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUl));
            }
        };
        this.fSk = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").P("obj_locate", au.a.bUn));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").P("obj_locate", au.a.bUn));
            }
        };
        this.fSl = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bmy;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fMP != null && (customResponsedMessage instanceof SignMessage) && (bmy = f.this.fMP.bmy()) != null && bmy.getForum() != null && (name = bmy.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fSi) {
                    TiebaStatic.eventStat(f.this.fMP.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bmy.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aG(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aJ(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUl));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bmy.getForum().getId())) {
                            f.this.xK(name2);
                            bmy.updateSignData(signData2);
                            signData2.forumId = bmy.getForum().getId();
                            signData2.forumName = bmy.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bmy.getForum().getUser_level();
                        if (f.this.bsR()) {
                            i = bmy.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.bsP()) {
                            f.this.fMP.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fMP.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fMP.blY() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aoH().a(f.this.fMP.getTbPageContext(), f.this.fMP.blY().aXA());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.sX(1);
                    }
                    f.this.fMP.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dtu = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fwQ != null) {
                    int childCount = f.this.fwQ.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fwQ.getChildAt(i));
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
        this.fwx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bmy = f.this.fMP.bmy();
                if (bmy != null && bmy.getForum() != null && f.this.fRX != null && (view == f.this.fRX.btK() || view == f.this.fRX.btL() || view == f.this.fRX.btM())) {
                    if (f.this.fMP != null && bmy.getForum() != null) {
                        TiebaStatic.log(new an("c12046").bT("fid", bmy.getForum().getId()).P("obj_locate", f.this.fMP.bmA() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bmy.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fMP.bmz()) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            f.this.fMP.showToast(R.string.neterror);
                        } else if (!bd.cF(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").P("obj_locate", 1).bT("fid", f.this.fMP.getForumId()));
                        } else {
                            f.this.kQ(true);
                            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                an anVar = new an("c10048");
                                anVar.bT("fid", f.this.fMP.getForumId());
                                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fMP.bmz()) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            f.this.fMP.showToast(R.string.neterror);
                        } else if (bd.cF(f.this.mContext.getPageActivity())) {
                            if (!f.this.bsQ()) {
                                f.this.bsT();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fMP.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(f.this.fMP.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == R.id.frs_header_games) {
                    if (bd.cF(f.this.mContext.getPageActivity()) && bmy != null && bmy.getGameUrl() != null) {
                        bb.ajE().a((TbPageContext) f.this.getPageContext(), new String[]{bmy.getGameUrl()}, true);
                    }
                } else if (id == R.id.frs_bawu_center) {
                    if (bmy != null && bmy.getUserData() != null && bmy.getUserData().isBawu()) {
                        String bawuCenterUrl = bmy.getBawuCenterUrl();
                        if (!aq.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.ae(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bmy.getForum() != null) {
                                TiebaStatic.log(new an("c10502").bT("fid", bmy.getForum().getId()).bT("uid", bmy.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == R.id.level_container && !f.this.fMP.bmz() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fRX != null) {
                        f.this.fRX.k(view, false);
                    }
                }
            }
        };
        this.fMP = frsFragment;
        this.fSf = aVar;
        this.fwQ = frsHeaderViewContainer;
        this.fSi = BdUniqueId.gen();
        this.fSh = new com.baidu.tieba.f.a();
        this.fSh.a(new a.InterfaceC0305a() { // from class: com.baidu.tieba.frs.vc.f.6
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
        this.fMP.registerListener(this.fSl);
        aJX();
        bsU();
        this.fSc = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aFQ() {
        if (this.fRX != null) {
            this.fRX.onDestory();
        }
        if (this.cdy != null) {
            this.cdy.cpa();
        }
        if (this.fSa != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fSa);
        }
    }

    public void akw() {
        if (this.fRX != null) {
            this.fRX.onStop();
        }
        if (this.fwQ != null) {
            this.fwQ.removeCallbacks(this.dtu);
        }
    }

    public void jS(boolean z) {
        if (this.fRX != null) {
            this.fRX.jS(z);
        }
    }

    public boolean sT(int i) {
        this.mSkinType = i;
        if (this.fRX != null) {
            this.fRX.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kP(boolean z) {
        if (z) {
            if (this.fRX != null) {
                this.fwQ.removeHeaderView(this.fRX.btJ());
                this.fSe = false;
            }
        } else if (this.fRX != null && this.fRX.btJ() != null && !this.fSe) {
            this.fwQ.addHeaderView(this.fRX.btJ(), this.fwQ.getHeaderViewsCount());
            this.fSe = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean bsH() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fRZ, str);
        this.fSb = i2;
        this.fRZ = str;
        bsJ();
        if (this.fRX == null || z) {
            this.fRX = this.fSf.a(str, this.fMP, i);
            this.fRX.changeSkinType(this.mSkinType);
            this.fRX.v(this.fwx);
        }
        this.fwQ.addHeaderView(this.fRX.getView());
        xJ(this.mPageType);
        bsL();
    }

    public void bsI() {
        if (!this.fSe && this.fRX != null) {
            this.fwQ.addHeaderView(this.fRX.btJ());
            this.fSe = true;
        }
    }

    private void bsJ() {
        if (this.fRX != null) {
            this.fwQ.removeHeaderView(this.fRX.getView());
            this.fwQ.removeHeaderView(this.fRX.btJ());
            bsK();
        }
        this.fSe = false;
    }

    private void bsK() {
        if (this.fSj != null && this.fMP != null && this.fMP.alf() != null) {
            this.fMP.alf().removeHeaderView(this.fSj.bsY());
        }
    }

    private void xJ(String str) {
        RelativeLayout bsY;
        if (this.fSj != null && this.fMP != null && this.fMP.alf() != null && (bsY = this.fSj.bsY()) != null) {
            if ("brand_page".equals(str)) {
                this.fMP.alf().removeHeaderView(bsY);
                return;
            }
            this.fMP.alf().removeHeaderView(bsY);
            this.fMP.alf().addHeaderView(bsY, 0);
        }
    }

    private void bsL() {
        if (this.fSa == null) {
            this.fSa = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fMP.blY() == null || !f.this.fMP.blY().bmz()) && f.this.fwQ.isShown() && f.this.fMP.isPrimary() && !f.this.fSc && f.this.fSb == 1 && f.this.fMP.blY() != null && f.this.fMP.blY().bmV() != null && !f.this.fMP.blY().bmV().bsE() && f.this.fMP.bmE()) {
                            if (("frs_page".equals(f.this.fRZ) || "normal_page".equals(f.this.fRZ) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fRZ)) && f.this.fRX != null && f.this.fRX.btI()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bpd();
                                f.this.fMP.fub = true;
                                f.this.fSc = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fSa, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fRX.boS();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fRX != null) {
                this.fRX.a(forumData, frsViewData);
                this.fRX.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fRX.tq(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fRX.kX(false);
                        return;
                    }
                    this.fRX.kX(true);
                    this.fRX.tq(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fRY = forumData.getLevelupScore();
        this.fqT = forumData.getCurScore();
        if (this.fRY > 0) {
            return this.fqT / this.fRY;
        }
        return 0.0f;
    }

    public void sU(int i) {
        if (i > 1) {
            if (this.fRX != null) {
                this.fRX.kY(false);
            }
        } else if (this.fRX != null) {
            this.fRX.kY(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void bsM() {
        if (this.fwQ != null) {
            this.fwQ.removeCallbacks(this.dtu);
            this.fwQ.postDelayed(this.dtu, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            bsN();
        }
    }

    public void setIsMem(int i) {
        if (this.fRX != null) {
            this.fRX.setMemberType(i);
        }
    }

    public void bpd() {
        if (("normal_page".equals(this.fRZ) || "frs_page".equals(this.fRZ) || "book_page".equals(this.fRZ) || "brand_page".equals(this.mPageType)) && this.fRX != null) {
            this.fRX.bpd();
        }
    }

    public void bsN() {
        if (this.fRX != null) {
            this.fRX.bpf();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void bsO() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            sW(0);
        }
    }

    public void sV(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            sW(i);
        }
    }

    public void sW(int i) {
        if (this.fRX != null) {
            this.fRX.tp(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fRX != null) {
            this.fRX.a(forumData, frsViewData);
            if (forumData != null) {
                this.fRX.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fRX.kX(false);
                }
            }
        }
    }

    public boolean bsP() {
        if (("normal_page".equals(this.fRZ) || "frs_page".equals(this.fRZ) || "book_page".equals(this.fRZ) || "brand_page".equals(this.mPageType)) && this.fRX != null) {
            return this.fRX.btH();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fRY - this.fqT) {
                z = true;
                this.fRY = signData.levelup_score;
            }
            this.fqT = i + this.fqT;
            if (this.fqT > this.fRY) {
                this.fqT = this.fRY;
            }
            if (this.fRY != 0) {
                f = this.fqT / this.fRY;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void sX(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fRX != null) {
            this.fRX.tq(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fRX != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fRX.a(forum, frsViewData);
                this.fRX.tq(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fRX.btH()) {
                    a(this.fRX, signData);
                    forum.setCurScore(this.fqT);
                    forum.setLevelupScore(this.fRY);
                    this.fRX.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean bsQ() {
        if (("normal_page".equals(this.fRZ) || "frs_page".equals(this.fRZ) || "book_page".equals(this.fRZ) || "brand_page".equals(this.mPageType)) && this.fRX != null) {
            return this.fRX.bsQ();
        }
        return false;
    }

    public boolean bsR() {
        if (("normal_page".equals(this.fRZ) || "frs_page".equals(this.fRZ) || "book_page".equals(this.fRZ) || "brand_page".equals(this.mPageType)) && this.fRX != null) {
            return this.fRX.bsR();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kQ(boolean z) {
        if (this.fMP != null) {
            FrsViewData bmy = this.fMP.bmy();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fMP.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, SapiGIDEvent.SYSTEM_NETWORK_CHANGE_MOB_TO_WIFI)));
            } else if (bmy != null && bmy.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fMP.getFrom())) {
                    TiebaStatic.log(new an("c10356").bT("fid", bmy.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fMP.getFrom())) {
                    TiebaStatic.log(new an("c10590").P("obj_type", 2).bT("fid", bmy.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fMP.getFrom())) {
                    TiebaStatic.log(new an("c10587").P("obj_type", 2).bT("fid", bmy.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fMP.getFrom())) {
                    TiebaStatic.log(new an("c10578").P("obj_type", 2).bT("fid", bmy.getForum().getId()));
                }
                this.cdy.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fMP.getFrom())) {
                    TiebaStatic.eventStat(this.fMP.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fMP.getFrom())) {
                    TiebaStatic.log(new an("c10359").bT("fid", bmy.getForum().getId()));
                }
                this.cdy.ac(bmy.getForum().getName(), bmy.getForum().getId(), "FRS");
                this.fSg = z;
            }
        }
    }

    public void bsS() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fMP.bmy() != null && this.fMP.bmy().getForum() != null && this.fMP.bmy().getForum().getName() != null) {
            str = this.fMP.bmy().getForum().getName();
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
                FrsViewData bmy = f.this.fMP.bmy();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fMP.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bmy != null && bmy.getForum() != null) {
                    f.this.fSd.C(bmy.getForum().getName(), com.baidu.adp.lib.g.b.c(bmy.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).agK();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void bsT() {
        FrsViewData bmy = this.fMP.bmy();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fMP.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bmy != null && bmy.getForum() != null) {
            FrsActivityStatic.forumName = bmy.getForum().getName() == null ? "" : bmy.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bmy.getForum());
            customMessage.setTag(this.fSi);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xK(String str) {
        if (this.fMP.blT() != null && this.fMP.blT().brq() != null) {
            com.baidu.tieba.tbadkCore.d.coH().aA(com.baidu.tieba.tbadkCore.d.coH().c("1~" + str, this.fMP.blT().brq().getSortType(), this.fMP.blT().brq().getIsGood(), this.fMP.blT().brq().getCategoryId()), false);
        }
    }

    private void aJX() {
        this.cdy = new LikeModel(this.fMP.getPageContext());
        this.cdy.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                t tVar;
                boolean z = false;
                FrsViewData bmy = f.this.fMP.bmy();
                if (bmy != null && bmy.getForum() != null && obj != null) {
                    if (AntiHelper.aG(f.this.cdy.getErrorCode(), f.this.cdy.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cdy.getBlockPopInfoData(), f.this.fSk) != null) {
                            TiebaStatic.log(new an("c12534").P("obj_locate", au.a.bUn));
                            return;
                        }
                        return;
                    }
                    String name = bmy.getForum().getName();
                    String id = bmy.getForum().getId();
                    if (!(obj instanceof t)) {
                        tVar = null;
                    } else {
                        tVar = (t) obj;
                    }
                    boolean z2 = tVar != null && f.this.cdy.getErrorCode() == 0;
                    if (tVar.getErrorCode() == 3250013) {
                        BdToast.b(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_toast_game_error, 3000).agS();
                    } else {
                        z = z2;
                    }
                    if (tVar == null || !z) {
                        if (f.this.cdy.getErrorCode() == 22) {
                            f.this.fMP.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fMP.showToast(f.this.cdy.getErrorString());
                        }
                    } else {
                        f.this.xK(name);
                        tVar.setLike(1);
                        bmy.updateLikeData(tVar);
                        bmy.setLikeFeedForumDataList(tVar.coT());
                        f.this.a(bmy, f.this.fSg);
                        f.this.fSg = true;
                        f.this.fMP.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                    }
                    f.this.fMP.as(Boolean.valueOf(z));
                }
            }
        });
    }

    private void bsU() {
        this.fSd = new y();
        this.fSd.setFrom("from_frs");
        this.fSd.a(new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void u(String str, long j) {
                FrsViewData bmy = f.this.fMP.bmy();
                if (bmy != null && bmy.getForum() != null) {
                    String name = bmy.getForum().getName();
                    String id = bmy.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.c(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.xK(str);
                        bmy.getForum().setLike(0);
                        f.this.sV(0);
                        f.this.fMP.ar(true);
                        f.this.l(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        t tVar = new t();
                        tVar.setLike(0);
                        tVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.y.a
            public void v(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bGG().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void K(int i, int i2, int i3) {
        FrsViewData bmy;
        if (i > 0 && i2 > 0 && (bmy = this.fMP.bmy()) != null && bmy.getForum() != null && bmy.getSignData() != null) {
            ForumData forum = bmy.getForum();
            SignData signData = bmy.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bmy.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (bsR()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bpa() {
        if (this.fRX != null) {
            this.fRX.bpa();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().acO(), true) || frsViewData.getBookInfo().acO().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().coU() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.aa(frsViewData.getActivityHeadData().acM())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().acV(), true)))) ? false : true;
        }
        return false;
    }

    public void sY(int i) {
        View findViewById;
        if (this.fRX != null && this.fRX.btJ() != null && (findViewById = this.fRX.btJ().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void L(MotionEvent motionEvent) {
        if (this.fSh != null) {
            this.fSh.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fSj = frsTabViewController;
    }
}
