package com.baidu.tieba.frs.vc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.SupplementSignActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.q;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.message.SignMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.f.a;
import com.baidu.tieba.frs.FrsActivityStatic;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsHeaderViewContainer;
import com.baidu.tieba.im.message.SettingChangeMessage;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.l;
import com.baidu.tieba.tbadkCore.r;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.w;
/* loaded from: classes6.dex */
public class f extends com.baidu.adp.base.c<BaseFragmentActivity> {
    private LikeModel aLl;
    private final View.OnClickListener dJU;
    private FrsHeaderViewContainer dKp;
    private FrsFragment dZP;
    private Runnable edA;
    private com.baidu.tieba.frs.view.b edh;
    private int edi;
    private int edj;
    private String edk;
    private Runnable edl;
    private int edm;
    private boolean edn;
    private w edo;
    private boolean edp;
    private com.baidu.tieba.frs.entelechy.b.a edq;
    private boolean edr;
    private com.baidu.tieba.f.a eds;
    private boolean edt;
    private com.baidu.tieba.frs.c.a.a edu;
    private com.baidu.tieba.frs.c.a.a edv;
    private BdUniqueId edw;
    private FrsTabViewController edx;
    private AntiHelper.a edy;
    private CustomMessageListener edz;
    private AntiHelper.a mInjectListener;
    private String mPageType;
    private int mScrollState;
    private int mSkinType;

    public f(FrsFragment frsFragment, com.baidu.tieba.frs.entelechy.b.a aVar, FrsHeaderViewContainer frsHeaderViewContainer) {
        super(frsFragment.getPageContext());
        this.dKp = null;
        this.mScrollState = 0;
        this.mSkinType = 0;
        this.mPageType = "normal_page";
        this.edk = null;
        this.edn = false;
        this.aLl = null;
        this.edo = null;
        this.edp = false;
        this.edt = false;
        this.mInjectListener = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCO));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCO));
            }
        };
        this.edy = new AntiHelper.a() { // from class: com.baidu.tieba.frs.vc.f.4
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12536").x("obj_locate", as.a.aCQ));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
            public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log(new am("c12535").x("obj_locate", as.a.aCQ));
            }
        };
        this.edz = new CustomMessageListener(2001425) { // from class: com.baidu.tieba.frs.vc.f.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                l aAZ;
                String name;
                SignData signData;
                boolean z;
                int i;
                if (f.this.dZP != null && (customResponsedMessage instanceof SignMessage) && (aAZ = f.this.dZP.aAZ()) != null && aAZ.bgh() != null && (name = aAZ.bgh().getName()) != null && name.equals(FrsActivityStatic.forumName) && customResponsedMessage.getOrginalMessage().getTag() == f.this.edw) {
                    TiebaStatic.eventStat(f.this.dZP.getContext(), "sign_end_time", System.currentTimeMillis() + "");
                    String name2 = aAZ.bgh().getName();
                    SignMessage signMessage = (SignMessage) customResponsedMessage;
                    if (AntiHelper.ai(signMessage.mSignErrorCode, signMessage.mSignErrorString)) {
                        if (signMessage.signData != null) {
                            AntiHelper.a(f.this.getPageContext().getPageActivity(), signMessage.signData.blockPopInfoData, f.this.mInjectListener);
                        } else {
                            AntiHelper.aJ(f.this.getPageContext().getPageActivity(), signMessage.mSignErrorString);
                        }
                        TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCO));
                        return;
                    }
                    if (signMessage == null || signMessage.signData == null) {
                        signData = null;
                        z = false;
                    } else {
                        SignData signData2 = signMessage.signData;
                        if (signData2.forumId != null && signData2.forumId.equals(aAZ.bgh().getId())) {
                            f.this.oO(name2);
                            aAZ.d(signData2);
                            signData2.forumId = aAZ.bgh().getId();
                            signData2.forumName = aAZ.bgh().getName();
                            signData = signData2;
                            z = true;
                        } else {
                            return;
                        }
                    }
                    if (z) {
                        int user_level = aAZ.bgh().getUser_level();
                        if (f.this.aHo()) {
                            i = aAZ.bgh().getUser_level();
                            if (user_level >= i) {
                                i++;
                            }
                        } else {
                            i = user_level;
                        }
                        TbadkCoreApplication.getInst().addSignedForum(name2, signData.sign_bonus_point, i);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
                        if (signData.mContriInfo != null && signData.mContriInfo.isShowToast()) {
                            f.this.dZP.a(signData.mContriInfo);
                            return;
                        }
                        if (!f.this.aHm()) {
                            f.this.dZP.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_success, Integer.valueOf(signData.user_sign_rank)));
                        } else {
                            f.this.dZP.showToast(f.this.getPageContext().getResources().getString(e.j.frs_sign_pointer, Integer.valueOf(signData.sign_bonus_point), Integer.valueOf(signData.user_sign_rank)));
                        }
                        if (f.this.dZP.aAI() != null) {
                            com.baidu.tbadk.coreExtra.messageCenter.d.IR().a(f.this.dZP.getTbPageContext(), f.this.dZP.aAI().aBQ());
                            return;
                        }
                        return;
                    }
                    if (signMessage.mSignErrorCode == 160002) {
                        f.this.nw(1);
                    }
                    f.this.dZP.showToast(signMessage.mSignErrorString);
                }
            }
        };
        this.edA = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.8
            @Override // java.lang.Runnable
            public void run() {
                if (f.this.dKp != null) {
                    int childCount = f.this.dKp.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        refreshImage(f.this.dKp.getChildAt(i));
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
        this.dJU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.f.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                l aAZ = f.this.dZP.aAZ();
                if (aAZ != null && aAZ.bgh() != null && f.this.edh != null && (view == f.this.edh.aHU() || view == f.this.edh.aHV() || view == f.this.edh.aHW())) {
                    if (f.this.dZP != null && aAZ.bgh() != null) {
                        TiebaStatic.log(new am("c12046").aA(ImageViewerConfig.FORUM_ID, aAZ.bgh().getId()).x("obj_locate", f.this.dZP.aBb() ? 1 : 2));
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumDetailActivityConfig(f.this.getPageContext().getPageActivity(), aAZ.bgh().getId(), ForumDetailActivityConfig.FromType.FRS)));
                    return;
                }
                int id = view.getId();
                if (id == e.g.tv_love) {
                    if (!f.this.dZP.aBa()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.dZP.showToast(e.j.neterror);
                        } else if (!ba.bJ(f.this.mContext.getPageActivity())) {
                            TiebaStatic.log(new am("c10517").x("obj_locate", 1).aA(ImageViewerConfig.FORUM_ID, f.this.dZP.getForumId()));
                        } else {
                            f.this.hp(true);
                            if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                                am amVar = new am("c10048");
                                amVar.aA(ImageViewerConfig.FORUM_ID, f.this.dZP.getForumId());
                                amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
                                TiebaStatic.log(amVar);
                            }
                        }
                    }
                } else if (id == e.g.tv_sign) {
                    if (!f.this.dZP.aBa()) {
                        if (!com.baidu.adp.lib.util.j.kV()) {
                            f.this.dZP.showToast(e.j.neterror);
                        } else if (ba.bJ(f.this.mContext.getPageActivity())) {
                            if (!f.this.aHn()) {
                                f.this.aHq();
                            } else if (TbadkCoreApplication.getInst().getUseNewResign() == 1) {
                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SupplementSignActivityConfig(f.this.dZP.getPageContext().getPageActivity(), com.baidu.adp.lib.g.b.l(f.this.dZP.getForumId(), 0), 24002)));
                            }
                        }
                    }
                } else if (id == e.g.frs_header_games) {
                    if (ba.bJ(f.this.mContext.getPageActivity()) && aAZ != null && aAZ.bBz() != null) {
                        ay.Ef().a((TbPageContext) f.this.getPageContext(), new String[]{aAZ.bBz()}, true);
                    }
                } else if (id == e.g.frs_bawu_center) {
                    if (aAZ != null && aAZ.getUserData() != null && aAZ.getUserData().isBawu()) {
                        String bBD = aAZ.bBD();
                        if (!ao.isEmpty(bBD)) {
                            com.baidu.tbadk.browser.a.ad(f.this.getPageContext().getPageActivity(), bBD);
                            if (aAZ.bgh() != null) {
                                TiebaStatic.log(new am("c10502").aA(ImageViewerConfig.FORUM_ID, aAZ.bgh().getId()).aA("uid", aAZ.getUserData().getUserId()));
                            }
                        }
                    }
                } else if (id == e.g.level_container && !f.this.dZP.aBa() && f.this.mScrollState == 0) {
                    if ((f.this.mPageType.equals("normal_page") || f.this.mPageType.equals("frs_page") || f.this.mPageType.equals("book_page") || f.this.mPageType.equals("brand_page")) && f.this.edh != null) {
                        f.this.edh.h(view, false);
                    }
                }
            }
        };
        this.dZP = frsFragment;
        this.edq = aVar;
        this.dKp = frsHeaderViewContainer;
        this.edu = new com.baidu.tieba.frs.c.b(frsFragment.getTbPageContext());
        this.edv = new com.baidu.tieba.frs.c.a(frsFragment.getTbPageContext());
        this.edw = BdUniqueId.gen();
        this.eds = new com.baidu.tieba.f.a();
        this.eds.a(new a.InterfaceC0214a() { // from class: com.baidu.tieba.frs.vc.f.6
            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void aq(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void ar(int i, int i2) {
            }

            @Override // com.baidu.tieba.f.a.InterfaceC0214a
            public void as(int i, int i2) {
            }
        });
    }

    public void t(Bundle bundle) {
        this.dZP.registerListener(this.edz);
        aaJ();
        aHr();
        this.edn = TbadkSettings.getInst().loadBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), false);
    }

    public void onActivityDestroy() {
        if (this.edh != null) {
            this.edh.onDestory();
        }
        if (this.aLl != null) {
            this.aLl.bCG();
        }
        if (this.edl != null) {
            com.baidu.adp.lib.g.e.jG().removeCallbacks(this.edl);
        }
    }

    public void onActivityStop() {
        if (this.edh != null) {
            this.edh.onStop();
        }
        if (this.dKp != null) {
            this.dKp.removeCallbacks(this.edA);
        }
    }

    public void gu(boolean z) {
        if (this.edh != null) {
            this.edh.gu(z);
        }
    }

    public boolean ns(int i) {
        this.mSkinType = i;
        if (this.edh != null) {
            this.edh.changeSkinType(i);
        }
        if (this.edu != null) {
            this.edu.onChangeSkinType(i);
        }
        if (this.edv != null) {
            this.edv.onChangeSkinType(i);
            return true;
        }
        return true;
    }

    public void ho(boolean z) {
        if (z) {
            if (this.edh != null) {
                this.dKp.removeHeaderView(this.edh.aHT());
                this.edp = false;
            }
        } else if (this.edh != null && this.edh.aHT() != null && !this.edp) {
            this.dKp.addHeaderView(this.edh.aHT(), this.dKp.getHeaderViewsCount());
            this.edp = true;
        }
    }

    public void a(String str, l lVar) {
        this.mPageType = str;
        if ("frs_page".equals(str) || "normal_page".equals(str) || "book_page".equals(str) || "brand_page".equals(str)) {
            if (!"brand_page".equals(str) && lVar != null && lVar.bBr() != null && lVar.bBr().yj() != null && lVar.bBr().yj().size() >= 1) {
                a(lVar.bBr().yj().get(0), false, lVar);
            } else if (!"brand_page".equals(str) && lVar != null && lVar.bBq() != null && !StringUtils.isNull(lVar.bBq().bCf())) {
                q qVar = new q();
                qVar.setLinkUrl("");
                qVar.setImageUrl(lVar.bBq().bCf());
                a(qVar, true, lVar);
            } else if (lVar != null && "brand_page".equals(str) && lVar.bBr() != null && lVar.bBr().yj() != null && lVar.bBr().yj().size() >= 1) {
                v(str, lVar.getUserData().getIsMem(), lVar.bgh().isLike());
                h(lVar);
            } else {
                this.edt = false;
                if (this.dKp != null && this.edu != null && this.edu.getHeaderView() != null) {
                    this.dKp.removeHeaderView(this.edu.getHeaderView());
                }
                if (this.dKp != null && this.edv != null && this.edv.getHeaderView() != null) {
                    this.dKp.removeHeaderView(this.edv.getHeaderView());
                }
            }
            if (lVar != null && lVar.getUserData() != null && lVar.bgh() != null && !"brand_page".equals(str)) {
                u(str, lVar.getUserData().getIsMem(), lVar.bgh().isLike());
            }
        }
    }

    public boolean aHf() {
        return this.edt;
    }

    private void a(q qVar, boolean z, l lVar) {
        if (qVar == null) {
            this.edt = false;
        } else if (this.dKp == null || this.edu == null || this.edu.getHeaderView() == null) {
            this.edt = false;
        } else {
            this.edt = true;
            this.dKp.removeHeaderView(this.edu.getHeaderView());
            this.dKp.addHeaderView(this.edu.getHeaderView());
            this.edu.a(lVar, qVar.getImageUrl());
            this.edu.setTitle(qVar.getTitle());
            this.edu.setSchemaUrl(qVar.getLinkUrl());
            if (z) {
                this.edu.hideTitle();
            }
        }
        if (lVar != null && lVar.bgh() != null && !TextUtils.isEmpty(lVar.bgh().getId()) && lVar.bBr() != null && !TextUtils.isEmpty(lVar.bBr().yk())) {
            am amVar = new am("c13326");
            amVar.aA(ImageViewerConfig.FORUM_ID, lVar.bgh().getId());
            amVar.aA(VideoPlayActivityConfig.OBJ_ID, lVar.bBr().yk());
            TiebaStatic.log(amVar);
        }
    }

    private void h(l lVar) {
        if (lVar == null || lVar.bBr() == null || v.I(lVar.bBr().yj()) || this.dKp == null || this.edh == null || this.edh.getView() == null || this.edv == null || this.edv.getHeaderView() == null) {
            this.edt = false;
            return;
        }
        q qVar = lVar.bBr().yj().get(0);
        if (qVar == null) {
            this.edt = false;
            return;
        }
        this.edt = true;
        this.edh.getView().setBackgroundColor(0);
        this.edv.aFT().removeView(this.edh.getView());
        this.edv.aFT().addView(this.edh.getView());
        this.dKp.removeHeaderView(this.edv.getHeaderView());
        this.dKp.addHeaderView(this.edv.getHeaderView());
        this.edv.a(lVar, qVar.getImageUrl());
        this.edv.setSchemaUrl(qVar.getLinkUrl());
        this.edv.setTitle(qVar.getTitle());
        if (this.edv instanceof com.baidu.tieba.frs.c.a) {
            ((com.baidu.tieba.frs.c.a) this.edv).bM(lVar.hjz);
        }
    }

    private void u(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.edk, str);
        this.edm = i2;
        this.edk = str;
        aHh();
        if (this.edh == null || z) {
            this.edh = this.edq.a(str, this.dZP, i);
            this.edh.changeSkinType(this.mSkinType);
            this.edh.s(this.dJU);
        }
        this.dKp.addHeaderView(this.edh.getView());
        int h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44);
        this.edh.q(0, h, 0, h);
        aHi();
        if (this.edx != null) {
            this.edx.aT(this.edh.aDr());
        }
    }

    private void v(String str, int i, int i2) {
        boolean z = !TextUtils.equals(this.edk, str);
        this.edm = i2;
        this.edk = str;
        aHh();
        if (this.edh == null || z) {
            this.edh = this.edq.a(str, this.dZP, i);
            this.edh.changeSkinType(this.mSkinType);
            this.edh.s(this.dJU);
            this.edh.aDw();
        }
        this.edh.q(0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds132), 0, com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst(), e.C0210e.tbds44));
        aHi();
        if (this.edx != null) {
            this.edx.aT(this.edh.aDr());
        }
    }

    public void aHg() {
        if (!this.edp && this.edh != null) {
            this.dKp.addHeaderView(this.edh.aHT());
            if (this.edh.aDr() != null && this.dZP.Fu() != null) {
                this.dZP.Fu().addHeaderView(this.edh.aDr(), 0);
            }
            this.edp = true;
        }
    }

    private void aHh() {
        if (("normal_page".equals(this.edk) || "frs_page".equals(this.edk) || "book_page".equals(this.edk) || "brand_page".equals(this.edk)) && this.edh != null) {
            this.dKp.removeHeaderView(this.edh.getView());
            this.dKp.removeHeaderView(this.edh.aHT());
            if (this.edh.aDr() != null && this.dZP.Fu() != null) {
                this.dZP.Fu().removeHeaderView(this.edh.aDr());
            }
        }
        this.edp = false;
    }

    private void aHi() {
        if (this.edl == null) {
            this.edl = new Runnable() { // from class: com.baidu.tieba.frs.vc.f.7
                @Override // java.lang.Runnable
                public void run() {
                    if (f.this.mScrollState == 0) {
                        if ((f.this.dZP.aAI() == null || !f.this.dZP.aAI().aBa()) && f.this.dKp.isShown() && f.this.dZP.isPrimary() && !f.this.edn && f.this.edm == 1 && f.this.dZP.aAI() != null && f.this.dZP.aAI().aBz() != null && !f.this.dZP.aAI().aBz().aEc() && f.this.dZP.aBe()) {
                            if (("frs_page".equals(f.this.edk) || "normal_page".equals(f.this.edk) || "brand_page".equals(f.this.mPageType) || "book_page".equals(f.this.edk)) && f.this.edh != null && f.this.edh.aHS()) {
                                TbadkSettings.getInst().saveBoolean("speed_icon_show" + TbadkCoreApplication.getCurrentAccount(), true);
                                f.this.aDE();
                                f.this.dZP.dHQ = true;
                                f.this.edn = true;
                            }
                        }
                    }
                }
            };
        }
        com.baidu.adp.lib.g.e.jG().postDelayed(this.edl, 4000L);
    }

    public void i(l lVar) {
        if (lVar != null) {
            if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                b(lVar.bgh(), lVar);
                if ("brand_page".equals(this.mPageType)) {
                    this.edh.aDx();
                }
            }
        }
    }

    public void b(ForumData forumData, l lVar) {
        if (forumData != null && lVar != null) {
            float b = b(forumData);
            if (this.edh != null) {
                this.edh.a(forumData, lVar);
                this.edh.a(forumData.isLike(), forumData.getLevelName(), forumData.getUser_level(), b, false);
                if (forumData.getSignData() != null) {
                    this.edh.nN(forumData.getSignData().is_signed);
                    if (forumData.getSignData().forum_rank == -2) {
                        this.edh.hy(false);
                        return;
                    }
                    this.edh.hy(true);
                    this.edh.nN(forumData.getSignData().is_signed);
                }
            }
        }
    }

    private float b(ForumData forumData) {
        if (forumData == null) {
            return 0.0f;
        }
        this.edi = forumData.getLevelupScore();
        this.edj = forumData.getCurScore();
        if (this.edi > 0) {
            return this.edj / this.edi;
        }
        return 0.0f;
    }

    public void nt(int i) {
        if (i > 1) {
            if (this.edh != null) {
                this.edh.hz(false);
            }
        } else if (this.edh != null) {
            this.edh.hz(true);
        }
    }

    public void setScrollState(int i) {
        this.mScrollState = i;
    }

    public void aHj() {
        if (this.dKp != null) {
            this.dKp.removeCallbacks(this.edA);
            this.dKp.postDelayed(this.edA, 100L);
        }
    }

    public void g(Integer num) {
        setIsMem(num.intValue());
        if ("frs_page".equals(this.mPageType) || "normal_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            aHk();
        }
    }

    public void setIsMem(int i) {
        if (this.edh != null) {
            this.edh.setMemberType(i);
        }
    }

    public void aDE() {
        if (("normal_page".equals(this.edk) || "frs_page".equals(this.edk) || "book_page".equals(this.edk) || "brand_page".equals(this.mPageType)) && this.edh != null) {
            this.edh.aDE();
        }
    }

    public void aHk() {
        if (this.edh != null) {
            this.edh.aDG();
        }
    }

    public void a(l lVar, boolean z) {
        if (lVar != null) {
            if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
                a(1, lVar.bgh(), lVar, z);
            }
        }
    }

    public void aHl() {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nv(0);
        }
    }

    public void nu(int i) {
        if ("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) {
            nv(i);
        }
    }

    public void nv(int i) {
        if (this.edh != null) {
            this.edh.nM(i);
        }
    }

    public void a(int i, ForumData forumData, l lVar, boolean z) {
        if (this.edh != null) {
            this.edh.a(forumData, lVar);
            if (forumData != null) {
                this.edh.a(i, forumData.getLevelName(), forumData.getUser_level(), b(forumData), z);
                if (forumData.getSignData() != null && forumData.getSignData().forum_rank == -2) {
                    this.edh.hy(false);
                }
            }
        }
    }

    public boolean aHm() {
        if (("normal_page".equals(this.edk) || "frs_page".equals(this.edk) || "book_page".equals(this.edk) || "brand_page".equals(this.mPageType)) && this.edh != null) {
            return this.edh.aHR();
        }
        return false;
    }

    private void a(com.baidu.tieba.frs.view.b bVar, SignData signData) {
        if (bVar != null && signData != null) {
            int i = signData.sign_bonus_point;
            boolean z = false;
            float f = 0.0f;
            if (i >= this.edi - this.edj) {
                z = true;
                this.edi = signData.levelup_score;
            }
            this.edj = i + this.edj;
            if (this.edj > this.edi) {
                this.edj = this.edi;
            }
            if (this.edi != 0) {
                f = this.edj / this.edi;
            }
            if (f > 0.999f) {
                f = 1.0f;
            }
            bVar.d(z, f);
        }
    }

    public void nw(int i) {
        if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.edh != null) {
            this.edh.nN(i);
        }
    }

    public void j(l lVar) {
        SignData signData;
        ForumData bgh;
        if (lVar != null && lVar.bgh() != null) {
            if (("normal_page".equals(this.mPageType) || "frs_page".equals(this.mPageType) || "book_page".equals(this.mPageType) || "brand_page".equals(this.mPageType)) && this.edh != null && (signData = lVar.bgh().getSignData()) != null && (bgh = lVar.bgh()) != null) {
                this.edh.a(bgh, lVar);
                this.edh.nN(signData.is_signed);
                if (signData.sign_bonus_point > 0 && this.edh.aHR()) {
                    a(this.edh, signData);
                    bgh.setCurScore(this.edj);
                    bgh.setLevelupScore(this.edi);
                    this.edh.a(bgh, lVar);
                }
            }
        }
    }

    public boolean aHn() {
        if (("normal_page".equals(this.edk) || "frs_page".equals(this.edk) || "book_page".equals(this.edk) || "brand_page".equals(this.mPageType)) && this.edh != null) {
            return this.edh.aHn();
        }
        return false;
    }

    public boolean aHo() {
        if (("normal_page".equals(this.edk) || "frs_page".equals(this.edk) || "book_page".equals(this.edk) || "brand_page".equals(this.mPageType)) && this.edh != null) {
            return this.edh.aHo();
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void hp(boolean z) {
        if (this.dZP != null) {
            l aAZ = this.dZP.aAZ();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.dZP.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 11002)));
            } else if (aAZ != null && aAZ.bgh() != null) {
                if (FrsActivityConfig.FRS_FROM_ENTERFORUM_RECOMMEND.equals(this.dZP.getFrom())) {
                    TiebaStatic.log(new am("c10356").aA(ImageViewerConfig.FORUM_ID, aAZ.bgh().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_HOT.equals(this.dZP.getFrom())) {
                    TiebaStatic.log(new am("c10590").x("obj_type", 2).aA(ImageViewerConfig.FORUM_ID, aAZ.bgh().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_TOP.equals(this.dZP.getFrom())) {
                    TiebaStatic.log(new am("c10587").x("obj_type", 2).aA(ImageViewerConfig.FORUM_ID, aAZ.bgh().getId()));
                } else if (FrsActivityConfig.FRS_FROM_SQUARE_RECOMMEND.equals(this.dZP.getFrom())) {
                    TiebaStatic.log(new am("c10578").x("obj_type", 2).aA(ImageViewerConfig.FORUM_ID, aAZ.bgh().getId()));
                }
                this.aLl.setFrom("recom_flist_like_frs");
                if (FrsActivityConfig.FRS_FROM_SQUARE.equals(this.dZP.getFrom())) {
                    TiebaStatic.eventStat(this.dZP.getPageContext().getPageActivity(), "square_frs_focus", AiAppsUBCStatistic.TYPE_CLICK, 1, new Object[0]);
                } else if (FrsActivityConfig.FRS_FROM_FOLLOWED_RECOMMEND.equals(this.dZP.getFrom())) {
                    TiebaStatic.log(new am("c10359").aA(ImageViewerConfig.FORUM_ID, aAZ.bgh().getId()));
                }
                this.aLl.Q(aAZ.bgh().getName(), aAZ.bgh().getId(), "FRS");
                this.edr = z;
            }
        }
    }

    public void aHp() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
        String str = "";
        if (this.dZP.aAZ() != null && this.dZP.aAZ().bgh() != null && this.dZP.aAZ().bgh().getName() != null) {
            str = this.dZP.aAZ().bgh().getName();
        }
        if (!StringUtils.isNull(str)) {
            aVar.eB(String.format(getPageContext().getString(e.j.attention_cancel_dialog_content), str));
        } else {
            aVar.eB(getPageContext().getString(e.j.attention_cancel_dialog_content_default));
        }
        aVar.a(getPageContext().getString(e.j.editor_dialog_yes), new a.b() { // from class: com.baidu.tieba.frs.vc.f.10
            /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: com.baidu.tieba.frs.FrsFragment */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
                l aAZ = f.this.dZP.aAZ();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (currentAccount == null || currentAccount.length() <= 0) {
                    TbadkCoreApplication.getInst().login(f.this.dZP.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) f.this.getPageContext().getPageActivity(), true, 11036)));
                } else if (aAZ != null && aAZ.bgh() != null) {
                    f.this.edo.w(aAZ.bgh().getName(), com.baidu.adp.lib.g.b.d(aAZ.bgh().getId(), 0L));
                }
            }
        });
        aVar.b(getPageContext().getString(e.j.editor_dialog_no), new a.b() { // from class: com.baidu.tieba.frs.vc.f.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(getPageContext()).BF();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
    /* JADX WARN: Multi-variable type inference failed */
    public void aHq() {
        l aAZ = this.dZP.aAZ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(this.dZP.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) getPageContext().getPageActivity(), true, 11014)));
        } else if (aAZ != null && aAZ.bgh() != null) {
            FrsActivityStatic.forumName = aAZ.bgh().getName() == null ? "" : aAZ.bgh().getName();
            CustomMessage customMessage = new CustomMessage(2001425, aAZ.bgh());
            customMessage.setTag(this.edw);
            MessageManager.getInstance().sendMessage(customMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oO(String str) {
        if (this.dZP.aAD() != null && this.dZP.aAD().aGi() != null) {
            com.baidu.tieba.tbadkCore.c.bBc().ad(com.baidu.tieba.tbadkCore.c.bBc().d(str, this.dZP.aAD().aGi().abZ(), this.dZP.aAD().aGi().getIsGood(), this.dZP.aAD().aGi().getCategoryId()), false);
        }
    }

    private void aaJ() {
        this.aLl = new LikeModel(this.dZP.getPageContext());
        this.aLl.setLoadDataCallBack(new com.baidu.adp.base.d() { // from class: com.baidu.tieba.frs.vc.f.2
            @Override // com.baidu.adp.base.d
            public void m(Object obj) {
                r rVar;
                boolean z = false;
                l aAZ = f.this.dZP.aAZ();
                if (aAZ != null && aAZ.bgh() != null && obj != null) {
                    if (AntiHelper.ai(f.this.aLl.getErrorCode(), f.this.aLl.getErrorString())) {
                        if (AntiHelper.a(f.this.getPageContext().getPageActivity(), f.this.aLl.getBlockPopInfoData(), f.this.edy) != null) {
                            TiebaStatic.log(new am("c12534").x("obj_locate", as.a.aCQ));
                            return;
                        }
                        return;
                    }
                    String name = aAZ.bgh().getName();
                    String id = aAZ.bgh().getId();
                    if (!(obj instanceof r)) {
                        rVar = null;
                    } else {
                        rVar = (r) obj;
                    }
                    boolean z2 = rVar != null && f.this.aLl.getErrorCode() == 0;
                    if (rVar.getErrorCode() == 3250013) {
                        BdToast.a(TbadkCoreApplication.getInst().getContext(), rVar.getErrorMsg(), e.f.icon_toast_game_error, 3000).BN();
                    } else {
                        z = z2;
                    }
                    if (rVar == null || !z) {
                        if (f.this.aLl.getErrorCode() == 22) {
                            f.this.dZP.showToast(f.this.getPageContext().getString(e.j.had_liked_forum));
                        } else {
                            f.this.dZP.showToast(f.this.aLl.getErrorString());
                        }
                    } else {
                        f.this.oO(name);
                        rVar.setLike(1);
                        aAZ.c(rVar);
                        aAZ.dH(rVar.bBj());
                        f.this.a(aAZ, f.this.edr);
                        f.this.edr = true;
                        f.this.dZP.showToast(f.this.getPageContext().getResources().getString(e.j.attention_success));
                        f.this.g(true, id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                    f.this.dZP.ad(Boolean.valueOf(z));
                }
            }
        });
    }

    private void aHr() {
        this.edo = new w();
        this.edo.setFrom("from_frs");
        this.edo.a(new w.a() { // from class: com.baidu.tieba.frs.vc.f.3
            @Override // com.baidu.tieba.tbadkCore.w.a
            public void p(String str, long j) {
                l aAZ = f.this.dZP.aAZ();
                if (aAZ != null && aAZ.bgh() != null) {
                    String name = aAZ.bgh().getName();
                    String id = aAZ.bgh().getId();
                    if (j == com.baidu.adp.lib.g.b.d(id, 0L) && TextUtils.equals(name, str)) {
                        f.this.oO(str);
                        aAZ.bgh().setLike(0);
                        f.this.nu(0);
                        f.this.dZP.ac(true);
                        f.this.g(false, id);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2003004, id));
                        r rVar = new r();
                        rVar.setLike(0);
                        rVar.setFid(id);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001266, rVar));
                    }
                }
            }

            @Override // com.baidu.tieba.tbadkCore.w.a
            public void q(String str, long j) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z, String str) {
        com.baidu.tieba.im.settingcache.d.aUj().a(TbadkCoreApplication.getCurrentAccount(), str, z, null);
        MessageManager.getInstance().dispatchResponsedMessage(new SettingChangeMessage(2));
    }

    public void F(int i, int i2, int i3) {
        l aAZ;
        if (i > 0 && i2 > 0 && (aAZ = this.dZP.aAZ()) != null && aAZ.bgh() != null && aAZ.getSignData() != null) {
            ForumData bgh = aAZ.bgh();
            SignData signData = aAZ.getSignData();
            signData.levelup_score = bgh.getLevelupScore();
            signData.sign_bonus_point = i3;
            signData.miss_sign_num -= i2;
            signData.count_sign_num = i;
            aAZ.d(signData);
            signData.forumId = bgh.getId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001222, signData));
            int i4 = -1;
            if (aHo()) {
                i4 = bgh.getUser_level() + 1;
            }
            TbadkCoreApplication.getInst().addSignedForum(bgh.getName(), signData.sign_bonus_point, i4);
        }
    }

    public void aDm() {
        if (this.edh != null) {
            this.edh.aDm();
        }
    }

    public static boolean k(l lVar) {
        if (lVar != null) {
            return (lVar.bBH() == null || StringUtils.isNull(lVar.bBH().yl(), true) || lVar.bBH().yl().equals("0")) ? false : true;
        }
        return false;
    }

    public static boolean l(l lVar) {
        if (lVar != null) {
            return ((lVar.bBq() == null || lVar.bBq().bCb() != 1) && lVar.bBG() == null && (lVar.bBr() == null || v.I(lVar.bBr().yj())) && ((lVar.bgh() == null || lVar.bgh().getFrsBannerData() == null || lVar.bgh().getFrsBannerData().getType() != 2) && (lVar.bBI() == null || StringUtils.isNull(lVar.bBI().ys(), true)))) ? false : true;
        }
        return false;
    }

    public void nx(int i) {
        View findViewById;
        if (this.edh != null && this.edh.aHT() != null && (findViewById = this.edh.aHT().findViewById(e.g.divider_bottom)) != null) {
            findViewById.setVisibility(i);
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        if (this.eds != null) {
            this.eds.onTouchEvent(motionEvent);
        }
    }

    public void a(FrsTabViewController frsTabViewController) {
        this.edx = frsTabViewController;
    }
}
