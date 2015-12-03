package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.tbadkCore.s {
    final /* synthetic */ FrsActivity bag;
    private long startTime = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void fX(int i) {
        this.startTime = System.nanoTime();
        if (this.bag.aZq != null) {
            switch (i) {
                case 1:
                    this.bag.aZq.cs(true);
                    this.bag.aZq.ND();
                    return;
                case 2:
                    this.bag.aZq.ct(true);
                    this.bag.aZq.ND();
                    return;
                case 3:
                case 6:
                    this.bag.aZq.cr(true);
                    return;
                case 4:
                case 5:
                default:
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b7, code lost:
        if (r1.aBH().size() == 0) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0720  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a0  */
    @Override // com.baidu.tieba.tbadkCore.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, boolean z, e.a aVar) {
        com.baidu.tieba.frs.loadmore.a aVar2;
        com.baidu.tieba.tbadkCore.p pVar;
        int i2;
        com.baidu.tieba.tbadkCore.p pVar2;
        com.baidu.tieba.tbadkCore.p pVar3;
        boolean z2;
        com.baidu.tieba.tbadkCore.p pVar4;
        com.baidu.tieba.tbadkCore.p pVar5;
        com.baidu.tieba.tbadkCore.p pVar6;
        com.baidu.tieba.tbadkCore.p pVar7;
        boolean z3;
        com.baidu.tieba.tbadkCore.p pVar8;
        com.baidu.tieba.frs.b.a aVar3;
        com.baidu.tieba.tbadkCore.p pVar9;
        com.baidu.tieba.tbadkCore.p pVar10;
        com.baidu.tieba.tbadkCore.p pVar11;
        com.baidu.tieba.frs.b.l lVar;
        com.baidu.tieba.tbadkCore.p pVar12;
        com.baidu.tieba.frs.loadmore.a aVar4;
        com.baidu.tieba.tbadkCore.p pVar13;
        ArrayList<com.baidu.adp.widget.ListView.u> a;
        com.baidu.tieba.tbadkCore.p pVar14;
        com.baidu.tieba.tbadkCore.data.e eVar;
        com.baidu.tieba.frs.b.a aVar5;
        com.baidu.tieba.tbadkCore.p pVar15;
        com.baidu.tieba.tbadkCore.data.e eVar2;
        int i3;
        com.baidu.tieba.tbadkCore.p pVar16;
        com.baidu.tieba.tbadkCore.p pVar17;
        com.baidu.tieba.frs.b.l lVar2;
        com.baidu.tieba.tbadkCore.p pVar18;
        com.baidu.tieba.tbadkCore.p pVar19;
        com.baidu.tieba.tbadkCore.p pVar20;
        com.baidu.tieba.frs.b.l lVar3;
        com.baidu.tieba.tbadkCore.p pVar21;
        com.baidu.tieba.tbadkCore.p pVar22;
        int i4;
        int i5;
        com.baidu.tieba.tbadkCore.p pVar23;
        com.baidu.tieba.tbadkCore.p pVar24;
        com.baidu.tieba.tbadkCore.p pVar25;
        com.baidu.tieba.tbadkCore.p pVar26;
        com.baidu.tieba.tbadkCore.p pVar27;
        com.baidu.tieba.tbadkCore.p pVar28;
        com.baidu.tieba.tbadkCore.p pVar29;
        com.baidu.tieba.tbadkCore.p pVar30;
        com.baidu.tieba.tbadkCore.p pVar31;
        com.baidu.tieba.tbadkCore.p pVar32;
        com.baidu.tieba.tbadkCore.p pVar33;
        com.baidu.tieba.tbadkCore.p pVar34;
        com.baidu.tieba.tbadkCore.p pVar35;
        com.baidu.tieba.tbadkCore.p pVar36;
        com.baidu.tieba.frs.b.a aVar6;
        com.baidu.tieba.tbadkCore.p pVar37;
        com.baidu.tieba.frs.loadmore.a aVar7;
        com.baidu.tieba.tbadkCore.p pVar38;
        com.baidu.tieba.tbadkCore.data.e eVar3;
        com.baidu.tieba.tbadkCore.p pVar39;
        int i6;
        com.baidu.tieba.tbadkCore.p pVar40;
        int i7;
        com.baidu.tieba.tbadkCore.p pVar41;
        com.baidu.tieba.tbadkCore.p pVar42;
        com.baidu.tieba.tbadkCore.p pVar43;
        com.baidu.tieba.tbadkCore.p pVar44;
        int i8;
        com.baidu.tieba.tbadkCore.p pVar45;
        int i9;
        com.baidu.tieba.tbadkCore.p pVar46;
        this.bag.aZO = true;
        if (aVar != null && aVar.isSuccess) {
            this.bag.aZq.NM().ck(com.baidu.tbadk.core.util.ay.vq().vs());
            FrsActivity.aZw = 0L;
            FrsActivity.aZx = 0L;
            FrsActivity.aZy = 0;
        } else {
            FrsActivity.aZy = 1;
        }
        if (i == 3 || i == 6) {
            aVar2 = this.bag.aZH;
            aVar2.resetData();
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.bag.aZq.cr(false);
        if (this.bag.MX().OH() != null) {
            this.bag.aZs = this.bag.MX().OH();
        }
        FrsActivity frsActivity = this.bag;
        pVar = this.bag.aZs;
        frsActivity.aZI = pVar.getPage().sf();
        i2 = this.bag.aZI;
        if (i2 == 0) {
            pVar42 = this.bag.aZs;
            if (pVar42.aBH() != null) {
                pVar46 = this.bag.aZs;
            }
            pVar43 = this.bag.aZs;
            if (pVar43.getThreadList() != null) {
                pVar44 = this.bag.aZs;
                if (pVar44.getThreadList().size() != 0) {
                    cd cdVar = this.bag.aZq;
                    i8 = FrsActivity.aZa;
                    pVar45 = this.bag.aZs;
                    int size = pVar45.getThreadList().size();
                    i9 = FrsActivity.aZb;
                    cdVar.gg(i8 - (size * i9));
                    this.bag.aZq.NS();
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                this.bag.aZq.cs(false);
                                this.bag.aZq.ND();
                                break;
                            case 2:
                                this.bag.aZq.ct(false);
                                this.bag.aZq.ND();
                                break;
                            case 3:
                            case 6:
                                pVar2 = this.bag.aZs;
                                if (pVar2 != null) {
                                    pVar3 = this.bag.aZs;
                                    pVar3.aCc();
                                    break;
                                }
                                break;
                        }
                        this.bag.hideLoadingView(this.bag.aZq.getRootView());
                        this.bag.aZq.NK();
                        if (z || (aVar != null && aVar.errorCode != 0)) {
                            z2 = this.bag.aZd;
                            if (!z2) {
                                if (aVar != null) {
                                    if (aVar.dwT) {
                                        if (340001 == aVar.errorCode) {
                                            this.bag.showNetRefreshViewNoClick(this.bag.aZq.getRootView(), this.bag.getPageContext().getResources().getString(n.i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        } else {
                                            this.bag.showNetRefreshView(this.bag.aZq.getRootView(), this.bag.getPageContext().getResources().getString(n.i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)), true);
                                        }
                                    } else if (340001 == aVar.errorCode) {
                                        this.bag.showNetRefreshViewNoClick(this.bag.aZq.getRootView(), aVar.errorMsg, true);
                                    } else {
                                        this.bag.showNetRefreshView(this.bag.aZq.getRootView(), aVar.errorMsg, true);
                                    }
                                    this.bag.aZq.gf(8);
                                }
                            } else if (aVar != null && aVar.dwT) {
                                this.bag.aZq.gf(0);
                                this.bag.showToast(this.bag.getPageContext().getResources().getString(n.i.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
                            }
                        } else {
                            this.bag.aZd = true;
                            this.bag.aZp = true;
                            this.bag.aZq.gf(0);
                            pVar7 = this.bag.aZs;
                            if (pVar7 != null) {
                                FrsActivity frsActivity2 = this.bag;
                                pVar32 = this.bag.aZs;
                                frsActivity2.aZi = pVar32.ajy().getName();
                                FrsActivity frsActivity3 = this.bag;
                                pVar33 = this.bag.aZs;
                                frsActivity3.forumId = pVar33.ajy().getId();
                                pVar34 = this.bag.aZs;
                                if (pVar34.ajy().getFrsBannerData().getType() == 2) {
                                    aVar6 = this.bag.aZF;
                                    pVar37 = this.bag.aZs;
                                    aVar6.gB(pVar37.getUserData().getIsMem());
                                }
                                cd cdVar2 = this.bag.aZq;
                                pVar35 = this.bag.aZs;
                                ForumData ajy = pVar35.ajy();
                                pVar36 = this.bag.aZs;
                                cdVar2.a(ajy, pVar36.getUserData(), 1);
                            }
                            z3 = this.bag.aZC;
                            if (z3) {
                                pVar24 = this.bag.aZs;
                                if (pVar24 != null && this.bag.aZD.Pb() == 1) {
                                    pVar25 = this.bag.aZs;
                                    pVar25.aCf();
                                    pVar26 = this.bag.aZs;
                                    pVar26.aCk();
                                    if (!this.bag.MX().OX() && TbadkCoreApplication.m411getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                                        pVar29 = this.bag.aZs;
                                        pVar29.aCj();
                                        pVar30 = this.bag.aZs;
                                        pVar30.aCi();
                                        pVar31 = this.bag.aZs;
                                        pVar31.aCh();
                                    }
                                    pVar27 = this.bag.aZs;
                                    pVar27.aCm();
                                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                                        pVar28 = this.bag.aZs;
                                        pVar28.aN(this.bag.getPageContext().getPageActivity());
                                    }
                                }
                            }
                            pVar8 = this.bag.aZs;
                            com.baidu.tbadk.core.data.ab top_notice_data = pVar8.ajy().getTop_notice_data();
                            if (top_notice_data != null && top_notice_data.getTitle() != null) {
                                com.baidu.tbadk.core.data.z zVar = new com.baidu.tbadk.core.data.z();
                                zVar.setTitle(top_notice_data.getTitle());
                                zVar.bJ(2);
                                zVar.cu(top_notice_data.to());
                                zVar.parser_title();
                                pVar23 = this.bag.aZs;
                                pVar23.f(zVar);
                            }
                            aVar3 = this.bag.aZF;
                            String OW = this.bag.MX().OW();
                            pVar9 = this.bag.aZs;
                            aVar3.a(OW, pVar9);
                            FrsActivity.aZw = (System.nanoTime() - this.startTime) / 1000000;
                            if (aVar != null) {
                                FrsActivity.aZx = aVar.dwU;
                            }
                            pVar10 = this.bag.aZs;
                            if (pVar10 != null) {
                                pVar21 = this.bag.aZs;
                                if (pVar21.getThreadList() != null) {
                                    pVar22 = this.bag.aZs;
                                    if (pVar22.getThreadList().size() == 0 && this.bag.MX().getType() == 4) {
                                        this.bag.showToast(this.bag.getPageContext().getString(n.i.no_more_to_load));
                                        i4 = this.bag.mPn;
                                        if (i4 > 1) {
                                            FrsActivity frsActivity4 = this.bag;
                                            i5 = frsActivity4.mPn;
                                            frsActivity4.mPn = i5 - 1;
                                        }
                                        if (this.bag.aQy > -1) {
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            TiebaStatic.page("op_frs_enter", currentTimeMillis2 - this.bag.aQy, this.bag.MX().Ke() - this.bag.aQy, this.bag.MX().Kc(), this.bag.MX().Kd(), currentTimeMillis2 - this.bag.MX().Kb());
                                            this.bag.aQy = -1L;
                                        }
                                        this.bag.ays = System.currentTimeMillis() - currentTimeMillis;
                                        return;
                                    }
                                }
                            }
                            pVar11 = this.bag.aZs;
                            if (pVar11 != null) {
                                pVar19 = this.bag.aZs;
                                if (pVar19.getUserData() != null) {
                                    pVar20 = this.bag.aZs;
                                    if (pVar20.getUserData().isBawu()) {
                                        lVar3 = this.bag.aZG;
                                        lVar3.setIsManager(true);
                                        pVar12 = this.bag.aZs;
                                        if (pVar12 != null) {
                                            pVar17 = this.bag.aZs;
                                            if (pVar17.ajy() != null) {
                                                lVar2 = this.bag.aZG;
                                                pVar18 = this.bag.aZs;
                                                lVar2.cA(pVar18.ajy().isLike() == 1);
                                            }
                                        }
                                        aVar4 = this.bag.aZH;
                                        pVar13 = this.bag.aZs;
                                        a = aVar4.a(true, pVar13.getThreadList());
                                        if (a != null) {
                                            pVar16 = this.bag.aZs;
                                            pVar16.am(a);
                                        }
                                        this.bag.MM();
                                        FrsActivity frsActivity5 = this.bag;
                                        pVar14 = this.bag.aZs;
                                        frsActivity5.aZm = pVar14.Pe();
                                        eVar = this.bag.aZn;
                                        if (eVar != null) {
                                            eVar2 = this.bag.aZn;
                                            i3 = this.bag.aZm;
                                            eVar2.mt(i3);
                                        }
                                        aVar5 = this.bag.aZF;
                                        pVar15 = this.bag.aZs;
                                        aVar5.cy(pVar15.aBE());
                                    }
                                }
                            }
                            lVar = this.bag.aZG;
                            lVar.setIsManager(false);
                            pVar12 = this.bag.aZs;
                            if (pVar12 != null) {
                            }
                            aVar4 = this.bag.aZH;
                            pVar13 = this.bag.aZs;
                            a = aVar4.a(true, pVar13.getThreadList());
                            if (a != null) {
                            }
                            this.bag.MM();
                            FrsActivity frsActivity52 = this.bag;
                            pVar14 = this.bag.aZs;
                            frsActivity52.aZm = pVar14.Pe();
                            eVar = this.bag.aZn;
                            if (eVar != null) {
                            }
                            aVar5 = this.bag.aZF;
                            pVar15 = this.bag.aZs;
                            aVar5.cy(pVar15.aBE());
                        }
                        if (this.bag.aQy > -1) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            TiebaStatic.page("op_frs_enter", currentTimeMillis3 - this.bag.aQy, this.bag.MX().Ke() - this.bag.aQy, this.bag.MX().Kc(), this.bag.MX().Kd(), currentTimeMillis3 - this.bag.MX().Kb());
                            this.bag.aQy = -1L;
                        }
                        pVar4 = this.bag.aZs;
                        if (pVar4 != null) {
                            pVar5 = this.bag.aZs;
                            if (pVar5.getUserData() != null) {
                                MessageManager messageManager = MessageManager.getInstance();
                                pVar6 = this.bag.aZs;
                                messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_RESPONSE_MEM, Integer.valueOf(pVar6.getUserData().getIsMem())));
                            }
                        }
                        this.bag.ays = System.currentTimeMillis() - currentTimeMillis;
                        System.gc();
                        return;
                    }
                    if (TbadkCoreApplication.m411getInst().isRecAppExist()) {
                        pVar41 = this.bag.aZs;
                        pVar41.aN(this.bag.getPageContext().getPageActivity());
                    }
                    aVar7 = this.bag.aZH;
                    pVar38 = this.bag.aZs;
                    ArrayList<com.baidu.adp.widget.ListView.u> threadList = pVar38.getThreadList();
                    eVar3 = this.bag.aZn;
                    ArrayList<com.baidu.adp.widget.ListView.u> a2 = aVar7.a(false, threadList, eVar3);
                    if (a2 != null) {
                        pVar39 = this.bag.aZs;
                        pVar39.am(a2);
                        cd cdVar3 = this.bag.aZq;
                        i6 = this.bag.mPn;
                        pVar40 = this.bag.aZs;
                        i7 = this.bag.aZI;
                        cdVar3.a(a2, i6, pVar40, i7);
                        return;
                    }
                    return;
                }
            }
            this.bag.aZq.NT();
            if (i != 4) {
            }
        }
        this.bag.aZq.NR();
        if (i != 4) {
        }
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public void b(com.baidu.tieba.tbadkCore.n nVar) {
        if (nVar != null) {
            if (!"normal_page".equals(this.bag.MX().OW()) && !"frs_page".equals(this.bag.MX().OW())) {
                return;
            }
            this.bag.a(nVar);
        }
    }
}
