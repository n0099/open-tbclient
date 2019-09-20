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
import com.baidu.tieba.tbadkCore.t;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.y;
/* loaded from: classes4.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel cer;
    private Runnable dvf;
    private FrsFragment fOE;
    private com.baidu.tieba.frs.view.b fTO;
    private int fTP;
    private String fTQ;
    private Runnable fTR;
    private int fTS;
    private boolean fTT;
    private y fTU;
    private boolean fTV;
    private com.baidu.tieba.frs.entelechy.b.a fTW;
    private boolean fTX;
    private com.baidu.tieba.f.a fTY;
    private BdUniqueId fTZ;
    private FrsTabViewController fUa;
    private AntiHelper.a fUb;
    private CustomMessageListener fUc;
    private int fsH;
    private FrsHeaderViewContainer fyD;
    private final View.OnClickListener fyk;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.fyD = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.fTQ = null;
        this.fTT = false;
        this.cer = null;
        this.fTU = null;
        this.fTV = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUO));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUO));
            }
        };
        this.fUb = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12536").P("obj_locate", at.a.bUQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new an("c12535").P("obj_locate", at.a.bUQ));
            }
        };
        this.fUc = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                FrsViewData bnj;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.fOE != null && (customResponsedMessage instanceof SignMessage) && (bnj = f.this.fOE.bnj()) != null && bnj.getForum() != null && (name = bnj.getForum().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.fTZ) {
                    TiebaStatic.eventStat(f.this.fOE.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = bnj.getForum().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.aG(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aQ(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUO));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(bnj.getForum().getId())) {
                            f.this.yj(name2);
                            bnj.updateSignData(signData2);
                            signData2.forumId = bnj.getForum().getId();
                            signData2.forumName = bnj.getForum().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = bnj.getForum().getUser_level();
                        if (f.this.btE()) {
                            i = bnj.getForum().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (!f.this.btC()) {
                            f.this.fOE.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.fOE.showToast(f.this.getPageContext().getResources().getString(R.string.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.fOE.bmJ() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.f.aoT().a(f.this.fOE.getTbPageContext(), f.this.fOE.bmJ().aYe());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.tb(1);
                    }
                    f.this.fOE.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.dvf = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.fyD != null) {
                    int childCount = f.this.fyD.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.fyD.getChildAt(i));
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
        this.fyk = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FrsViewData bnj = f.this.fOE.bnj();
                if (bnj != null && bnj.getForum() != null && f.this.fTO != null && (view == f.this.fTO.buy() || view == f.this.fTO.buz() || view == f.this.fTO.buA())) {
                    if (f.this.fOE != null && bnj.getForum() != null) {
                        TiebaStatic.log(new an("c12046").bT("fid", bnj.getForum().getId()).P("obj_locate", f.this.fOE.bnl() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), bnj.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                }
                int id = view.getId();
                if (id == R.id.tv_love) {
                    if (!f.this.fOE.bnk()) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            f.this.fOE.showToast(R.string.neterror);
                        } else if (!bc.cF(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new an("c10517").P("obj_locate", 1).bT("fid", f.this.fOE.getForumId()));
                        } else {
                            f.this.kT(true);
                            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                an anVar = new an("c10048");
                                anVar.bT("fid", f.this.fOE.getForumId());
                                anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(anVar);
                            }
                        }
                    }
                } else if (id == R.id.tv_sign) {
                    if (!f.this.fOE.bnk()) {
                        if (!com.baidu.adp.lib.util.j.kc()) {
                            f.this.fOE.showToast(R.string.neterror);
                        } else if (bc.cF(f.this.mContext.getPageActivity())) {
                            if (!f.this.btD()) {
                                f.this.btG();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.fOE.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.f(f.this.fOE.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == R.id.frs_header_games) {
                    if (bc.cF(f.this.mContext.getPageActivity()) && bnj != null && bnj.getGameUrl() != null) {
                        ba.ajK().a((TbPageContext) f.this.getPageContext(), new String[]{bnj.getGameUrl()}, true);
                    }
                } else if (id == R.id.frs_bawu_center) {
                    if (bnj != null && bnj.getUserData() != null && bnj.getUserData().isBawu()) {
                        String bawuCenterUrl = bnj.getBawuCenterUrl();
                        if (!aq.isEmpty(bawuCenterUrl)) {
                            com.baidu.tbadk.browser.a.ae(f.this.getPageContext().getPageActivity(), bawuCenterUrl);
                            if (bnj.getForum() != null) {
                                TiebaStatic.log(new an("c10502").bT("fid", bnj.getForum().getId()).bT("uid", bnj.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == R.id.level_container && !f.this.fOE.bnk() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.fTO != null) {
                        f.this.fTO.k(view, false);
                    }
                }
            }
        };
        this.fOE = frsFragment;
        this.fTW = aVar;
        this.fyD = frsHeaderViewContainer;
        this.fTZ = BdUniqueId.gen();
        this.fTY = new com.baidu.tieba.f.a();
        this.fTY.a(new a.InterfaceC0316a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void aY(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void aZ(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0316a
            public void ba(int i, int i2) {
            }
        });
    }

    public void R(Bundle bundle) {
        this.fOE.registerListener(this.fUc);
        aKB();
        btH();
        this.fTT = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void aGu() {
        if (this.fTO != null) {
            this.fTO.onDestory();
        }
        if (this.cer != null) {
            this.cer.cpO();
        }
        if (this.fTR != null) {
            com.baidu.adp.lib.g.e.iK().removeCallbacks(this.fTR);
        }
    }

    public void akI() {
        if (this.fTO != null) {
            this.fTO.onStop();
        }
        if (this.fyD != null) {
            this.fyD.removeCallbacks(this.dvf);
        }
    }

    public void jV(boolean z) {
        if (this.fTO != null) {
            this.fTO.jV(z);
        }
    }

    public boolean sX(int i) {
        this.mSkinType = i;
        if (this.fTO != null) {
            this.fTO.changeSkinType(i);
            return true;
        }
        return true;
    }

    public void kS(boolean z) {
        if (z) {
            if (this.fTO != null) {
                this.fyD.removeHeaderView(this.fTO.bux());
                this.fTV = false;
            }
        } else if (this.fTO != null && this.fTO.bux() != null && !this.fTV) {
            this.fyD.addHeaderView(this.fTO.bux(), this.fyD.getHeaderViewsCount());
            this.fTV = true;
        }
    }

    public void a(String str, FrsViewData frsViewData) {
        this.mPageType = str;
        if (frsViewData != null && frsViewData.getUserData() != null && frsViewData.getForum() != null) {
            u(str, frsViewData.getUserData().getIsMem(), frsViewData.getForum().isLike());
        }
    }

    public boolean btu() {
        return true;
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.fTQ, str);
        this.fTS = i2;
        this.fTQ = str;
        btw();
        if (this.fTO == null || z) {
            this.fTO = this.fTW.a(str, this.fOE, i);
            this.fTO.changeSkinType(this.mSkinType);
            this.fTO.v(this.fyk);
        }
        this.fyD.addHeaderView(this.fTO.getView());
        yi(this.mPageType);
        bty();
    }

    public void btv() {
        if (!this.fTV && this.fTO != null) {
            this.fyD.addHeaderView(this.fTO.bux());
            this.fTV = true;
        }
    }

    private void btw() {
        if (this.fTO != null) {
            this.fyD.removeHeaderView(this.fTO.getView());
            this.fyD.removeHeaderView(this.fTO.bux());
            btx();
        }
        this.fTV = false;
    }

    private void btx() {
        if (this.fUa != null && this.fOE != null && this.fOE.alr() != null) {
            this.fOE.alr().removeHeaderView(this.fUa.btL());
        }
    }

    private void yi(String str) {
        RelativeLayout btL;
        if (this.fUa != null && this.fOE != null && this.fOE.alr() != null && (btL = this.fUa.btL()) != null) {
            if ("brand_page".equals(str)) {
                this.fOE.alr().removeHeaderView(btL);
                return;
            }
            this.fOE.alr().removeHeaderView(btL);
            this.fOE.alr().addHeaderView(btL, 0);
        }
    }

    private void bty() {
        if (this.fTR == null) {
            this.fTR = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.fOE.bmJ() == null || !f.this.fOE.bmJ().bnk()) && f.this.fyD.isShown() && f.this.fOE.isPrimary() && !f.this.fTT && f.this.fTS == 1 && f.this.fOE.bmJ() != null && f.this.fOE.bmJ().bnG() != null && !f.this.fOE.bmJ().bnG().btr() && f.this.fOE.bnp()) {
                            if (("frs_page".equals(f.this.fTQ) || "normal_page".equals(f.this.fTQ) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.fTQ)) && f.this.fTO != null && f.this.fTO.buw()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.bpO();
                                f.this.fOE.fvO = true;
                                f.this.fTT = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.iK().postDelayed(this.fTR, 4000L);
    }

    public void i(FrsViewData frsViewData) {
        if (frsViewData != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(frsViewData.getForum(), frsViewData);
                if ("brand_page".equals(this.mPageType)) {
                    this.fTO.bpD();
                }
            }
        }
    }

    public void b(ForumData forumData, FrsViewData frsViewData) {
        if (forumData != null && frsViewData != null) {
            float b = b(forumData);
            if (this.fTO != null) {
                this.fTO.a(forumData, frsViewData);
                this.fTO.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.fTO.tu(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.fTO.la(false);
                        return;
                    }
                    this.fTO.la(true);
                    this.fTO.tu(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.fTP = forumData.getLevelupScore();
        this.fsH = forumData.getCurScore();
        if (this.fTP > 0) {
            return this.fsH / this.fTP;
        }
        return 0.0f;
    }

    public void sY(int i) {
        if (i > 1) {
            if (this.fTO != null) {
                this.fTO.lb(false);
            }
        } else if (this.fTO != null) {
            this.fTO.lb(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void btz() {
        if (this.fyD != null) {
            this.fyD.removeCallbacks(this.dvf);
            this.fyD.postDelayed(this.dvf, 100L);
        }
    }

    public void h(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            btA();
        }
    }

    public void setIsMem(int i) {
        if (this.fTO != null) {
            this.fTO.setMemberType(i);
        }
    }

    public void bpO() {
        if (("normal_page".equals(this.fTQ) || "frs_page".equals(this.fTQ) || "book_page".equals(this.fTQ) || "brand_page".equals(this.mPageType)) && this.fTO != null) {
            this.fTO.bpO();
        }
    }

    public void btA() {
        if (this.fTO != null) {
            this.fTO.bpQ();
        }
    }

    public void a(FrsViewData frsViewData, boolean z) {
        if (frsViewData != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, frsViewData.getForum(), frsViewData, z);
            }
        }
    }

    public void btB() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            ta(0);
        }
    }

    public void sZ(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            ta(i);
        }
    }

    public void ta(int i) {
        if (this.fTO != null) {
            this.fTO.tt(i);
        }
    }

    public void a(int i, ForumData forumData, FrsViewData frsViewData, boolean z) {
        if (this.fTO != null) {
            this.fTO.a(forumData, frsViewData);
            if (forumData != null) {
                this.fTO.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.fTO.la(false);
                }
            }
        }
    }

    public boolean btC() {
        if (("normal_page".equals(this.fTQ) || "frs_page".equals(this.fTQ) || "book_page".equals(this.fTQ) || "brand_page".equals(this.mPageType)) && this.fTO != null) {
            return this.fTO.buv();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.fTP - this.fsH) {
                z = true;
                this.fTP = signData.levelup_score;
            }
            this.fsH = i + this.fsH;
            if (this.fsH > this.fTP) {
                this.fsH = this.fTP;
            }
            if (this.fTP != 0) {
                f = this.fsH / this.fTP;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void tb(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fTO != null) {
            this.fTO.tu(i);
        }
    }

    public void j(FrsViewData frsViewData) {
        SignData signData;
        ForumData forum;
        if (frsViewData != null && frsViewData.getForum() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.fTO != null && (signData = frsViewData.getForum().getSignData()) != null && (forum = frsViewData.getForum()) != null) {
                this.fTO.a(forum, frsViewData);
                this.fTO.tu(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.fTO.buv()) {
                    a(this.fTO, signData);
                    forum.setCurScore(this.fsH);
                    forum.setLevelupScore(this.fTP);
                    this.fTO.a(forum, frsViewData);
                }
            }
        }
    }

    public boolean btD() {
        if (("normal_page".equals(this.fTQ) || "frs_page".equals(this.fTQ) || "book_page".equals(this.fTQ) || "brand_page".equals(this.mPageType)) && this.fTO != null) {
            return this.fTO.btD();
        }
        return false;
    }

    public boolean btE() {
        if (("normal_page".equals(this.fTQ) || "frs_page".equals(this.fTQ) || "book_page".equals(this.fTQ) || "brand_page".equals(this.mPageType)) && this.fTO != null) {
            return this.fTO.btE();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void kT(boolean z) {
        if (this.fOE != null) {
            FrsViewData bnj = this.fOE.bnj();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.fOE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, SapiGIDEvent.SYSTEM_NETWORK_CHANGE_MOB_TO_WIFI)));
            } else if (bnj != null && bnj.getForum() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.fOE.getFrom())) {
                    TiebaStatic.log(new an("c10356").bT("fid", bnj.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.fOE.getFrom())) {
                    TiebaStatic.log(new an("c10590").P("obj_type", 2).bT("fid", bnj.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.fOE.getFrom())) {
                    TiebaStatic.log(new an("c10587").P("obj_type", 2).bT("fid", bnj.getForum().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.fOE.getFrom())) {
                    TiebaStatic.log(new an("c10578").P("obj_type", 2).bT("fid", bnj.getForum().getId()));
                }
                this.cer.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.fOE.getFrom())) {
                    TiebaStatic.eventStat(this.fOE.getPageContext().getPageActivity(), "square_frs_focus", "click", 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.fOE.getFrom())) {
                    TiebaStatic.log(new an("c10359").bT("fid", bnj.getForum().getId()));
                }
                this.cer.ae(bnj.getForum().getName(), bnj.getForum().getId(), "FRS");
                this.fTX = z;
            }
        }
    }

    public void btF() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.fOE.bnj() != null && this.fOE.bnj().getForum() != null && this.fOE.bnj().getForum().getName() != null) {
            str = this.fOE.bnj().getForum().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.mQ(String.format(getPageContext().getString(R.string.attention_cancel_dialog_content), str));
        } else {
            aVar.mQ(getPageContext().getString(R.string.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(R.string.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                FrsViewData bnj = f.this.fOE.bnj();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.fOE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (bnj != null && bnj.getForum() != null) {
                    f.this.fTU.E(bnj.getForum().getName(), com.baidu.adp.lib.g.b.e(bnj.getForum().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(R.string.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).agO();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void btG() {
        FrsViewData bnj = this.fOE.bnj();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.fOE.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(getPageContext().getPageActivity(), true, 11014)));
        } else if (bnj != null && bnj.getForum() != null) {
            FrsActivityStatic.forumName = bnj.getForum().getName() == null ? "" : bnj.getForum().getName();
            CustomMessage customMessage = new CustomMessage(2001425, bnj.getForum());
            customMessage.setTag(this.fTZ);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yj(String str) {
        if (this.fOE.bmE() != null && this.fOE.bmE().bsc() != null) {
            com.baidu.tieba.tbadkCore.d.cpu().aA(com.baidu.tieba.tbadkCore.d.cpu().c("1~" + str, this.fOE.bmE().bsc().getSortType(), this.fOE.bmE().bsc().getIsGood(), this.fOE.bmE().bsc().getCategoryId()), false);
        }
    }

    private void aKB() {
        this.cer = new LikeModel(this.fOE.getPageContext());
        this.cer.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                t tVar;
                boolean z = false;
                FrsViewData bnj = f.this.fOE.bnj();
                if (bnj != null && bnj.getForum() != null && obj != null) {
                    if (AntiHelper.aG(f.this.cer.getErrorCode(), f.this.cer.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.cer.getBlockPopInfoData(), f.this.fUb) != null) {
                            TiebaStatic.log(new an("c12534").P("obj_locate", at.a.bUQ));
                            return;
                        }
                        return;
                    }
                    String name = bnj.getForum().getName();
                    String id = bnj.getForum().getId();
                    if (!(obj instanceof t)) {
                        tVar = null;
                    } else {
                        tVar = (t) obj;
                    }
                    boolean z2 = tVar != null && f.this.cer.getErrorCode() == 0;
                    if (tVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), tVar.getErrorMsg(), R.drawable.icon_pure_toast_mistake_n_svg, 3000, true).agW();
                    } else {
                        z = z2;
                    }
                    if (tVar == null || !z) {
                        if (f.this.cer.getErrorCode() == 22) {
                            f.this.fOE.showToast(f.this.getPageContext().getString(R.string.had_liked_forum));
                        } else {
                            f.this.fOE.showToast(f.this.cer.getErrorString());
                        }
                    } else {
                        f.this.yj(name);
                        tVar.setLike(1);
                        bnj.updateLikeData(tVar);
                        bnj.setLikeFeedForumDataList(tVar.cpG());
                        f.this.a(bnj, f.this.fTX);
                        f.this.fTX = true;
                        f.this.fOE.showToast(f.this.getPageContext().getResources().getString(R.string.attention_success));
                        f.this.l(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, tVar));
                    }
                    f.this.fOE.as(Boolean.valueOf(z));
                }
            }
        });
    }

    private void btH() {
        this.fTU = new y();
        this.fTU.setFrom("from_frs");
        this.fTU.a(new y.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.y.a
            public void w(String str, long j) {
                FrsViewData bnj = f.this.fOE.bnj();
                if (bnj != null && bnj.getForum() != null) {
                    String name = bnj.getForum().getName();
                    String id = bnj.getForum().getId();
                    if (j == com.baidu.adp.lib.g.b.e(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.yj(str);
                        bnj.getForum().setLike(0);
                        f.this.sZ(0);
                        f.this.fOE.ar(true);
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
            public void x(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.bHu().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void L(int i, int i2, int i3) {
        FrsViewData bnj;
        if (i > 0 && i2 > 0 && (bnj = this.fOE.bnj()) != null && bnj.getForum() != null && bnj.getSignData() != null) {
            ForumData forum = bnj.getForum();
            SignData signData = bnj.getSignData();
            signData.levelup_score = forum.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            bnj.updateSignData(signData);
            signData.forumId = forum.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (btE()) {
                i4 = forum.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(forum.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void bpL() {
        if (this.fTO != null) {
            this.fTO.bpL();
        }
    }

    public static boolean k(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return (frsViewData.getBookInfo() == null || StringUtils.isNull(frsViewData.getBookInfo().acS(), true) || frsViewData.getBookInfo().acS().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(FrsViewData frsViewData) {
        if (frsViewData != null) {
            return ((frsViewData.getStar() == null || frsViewData.getStar().cpH() != 1) && frsViewData.getHeadSdkData() == null && (frsViewData.getActivityHeadData() == null || v.aa(frsViewData.getActivityHeadData().acQ())) && ((frsViewData.getForum() == null || frsViewData.getForum().getFrsBannerData() == null || frsViewData.getForum().getFrsBannerData().getType() != 2) && (frsViewData.getHeadlineImgInfoData() == null || StringUtils.isNull(frsViewData.getHeadlineImgInfoData().acZ(), true)))) ? false : true;
        }
        return false;
    }

    public void tc(int i) {
        View findViewById;
        if (this.fTO != null && this.fTO.bux() != null && (findViewById = this.fTO.bux().findViewById(R.id.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void K(MotionEvent motionEvent) {
        if (this.fTY != null) {
            this.fTY.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.fUa = frsTabViewController;
    }
}
