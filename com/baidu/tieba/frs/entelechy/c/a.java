package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.x;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.i;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements d {
    private f coV;
    private HorizontalTabView coW;
    private com.baidu.tieba.frs.entelechy.c.a.a coX;
    private ai coY;
    private TabData cpa;
    private i cpb;
    private LinearLayout mRootLayout;
    private boolean coZ = false;
    private int liveCount = -1;
    private ai cpc = new ai() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i == 101) {
                TiebaStatic.log(new aj("c12103").aa("fid", a.this.coV.getForumId()));
            }
            if (i > 100) {
                if (anVar != null && (anVar.cmP instanceof String)) {
                    a.this.aS((String) anVar.cmP, "c10079");
                }
            } else {
                aj ajVar = new aj("c10074");
                ajVar.r("obj_type", i);
                ajVar.aa("fid", a.this.coV.getForumId());
                TiebaStatic.log(ajVar);
                if (i == 99) {
                    aj ajVar2 = new aj("c11500");
                    ajVar2.aa("obj_param1", "2").aa("obj_param2", "1");
                    TiebaStatic.log(ajVar2);
                }
            }
            if (HorizontalTabView.jz(i) && anVar != null) {
                String str = (String) anVar.cmP;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        k.showToast(a.this.coV.getPageContext().getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else {
                        at.wg().c(a.this.coV.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.coV != null && a.this.coV.getPageContext() != null && a.this.coV.getPageContext().getPageActivity() != null) {
                    a.this.coV.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.coV.getPageContext().getPageActivity()).createNormalCfg(a.this.coV.cjD, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else if (i == 49 && a.this.coV != null && a.this.coV.getPageContext() != null && a.this.coV.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.coV.afH().aPJ().getForumGameLabel())) {
                if (anVar != null) {
                    anVar.cmQ = true;
                }
                a.this.coV.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.coV.getPageContext().getPageActivity(), a.this.coV.getForumId(), a.this.coV.getForumName(), a.this.coV.afH().aPJ().getForumGameLabel())));
            } else {
                if (i == 1) {
                    a.this.coX.ahx();
                } else {
                    a.this.coX.ahy();
                }
                if (a.this.coY != null) {
                    a.this.coY.a(i, i2, anVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void Ox() {
        }
    };
    private HorizontalTabView.c cpd = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void iU(int i) {
            a.this.coV.afp().iI(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean iV(int i) {
            return (a.this.coV != null && a.this.coV.afI() && i == 1) ? false : true;
        }
    };

    public void iT(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.coW = null;
        this.coV = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.ai.k(this.mRootLayout, d.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.coW = new HorizontalTabView(fVar.getPageContext());
        this.coW.setForNewFrame(true);
        this.coW.cxP = k.g(fVar.getActivity(), d.f.ds20);
        this.coW.setAutoFillTabCount(4);
        this.coW.setmShowMenuCallBack(this.cpd);
        this.coW.setNeedBottomLine(false);
        this.coW.setTabBackgroudColor(d.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
        layoutParams.weight = 1.0f;
        this.coW.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.coW);
        this.coX = new com.baidu.tieba.frs.entelechy.c.a.a(this.coV, this.mRootLayout);
        this.coW.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cpb != null && a.this.cpb.aPJ() != null) {
                    TiebaStatic.log(new aj("c12047").aa("fid", a.this.cpb.aPJ().getId()));
                }
            }
        });
        this.coW.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.coV != null) {
                    a.this.coV.cH(dVar.cuL == 49);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.mRootLayout != null) {
            com.baidu.tbadk.core.util.ai.k(this.mRootLayout, d.e.cp_bg_line_d);
        }
        if (this.coW != null) {
            this.coW.xd();
        }
        if (this.coX != null) {
            this.coX.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(ai aiVar) {
        if (this.coW != null) {
            this.coW.setDataLoadInterface(this.cpc);
        }
        this.coY = aiVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ak(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.coZ = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.coZ) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.coZ = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, i iVar, int i) {
        boolean z;
        if (iVar != null && iVar.brD() != null && iVar.brD().tab != null) {
            this.coX.i(iVar.brD().menu, i);
            if (iVar.aPJ() != null) {
                this.coX.setFid(iVar.aPJ().getId());
            }
            this.cpb = iVar;
            b(iVar);
            this.cpa = new TabData();
            if (u.v(iVar.brL())) {
                for (FrsTabInfo frsTabInfo : iVar.brD().tab) {
                    if (!a(frsTabInfo) && !b(frsTabInfo)) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.cuL = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            this.cpa.add(dVar);
                        } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                            if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                                StringBuilder sb = new StringBuilder();
                                String lowerCase = frsTabInfo.tab_url.toLowerCase();
                                if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                    sb.append("http://");
                                }
                                sb.append(frsTabInfo.tab_url);
                                sb.append("&");
                                sb.append("fid");
                                sb.append("=");
                                sb.append(iVar.aPJ().getId());
                                dVar.url = sb.toString();
                                aS(dVar.url, "c10078");
                                this.cpa.add(dVar);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.jz(frsTabInfo.tab_id.intValue())) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.cr(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cpa.add(dVar);
                                }
                            } else {
                                this.cpa.add(dVar);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && ab.agv().iO(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            z iL = y.agu().iL(dVar.cuL);
                            if (iL != null && iL.cmB != null && iL.cmB.size() > 0) {
                                dVar.cyk = new com.baidu.tieba.frs.at();
                                dVar.cyk.cmA = iL.cmA;
                                dVar.cyk.cmB = new LinkedList();
                                boolean z2 = true;
                                for (x xVar : iL.cmB) {
                                    if (xVar != null) {
                                        as asVar = new as();
                                        asVar.name = xVar.name;
                                        asVar.cmx = xVar.cmx;
                                        if (z2) {
                                            asVar.isSelected = true;
                                            z = false;
                                        } else {
                                            z = z2;
                                        }
                                        dVar.cyk.cmB.add(asVar);
                                        z2 = z;
                                    }
                                }
                            }
                            this.cpa.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            z iL2 = y.agu().iL(dVar.cuL);
                            if (iL2 != null && iL2.cmB != null && iL2.cmB.size() > 0) {
                                dVar.cyk = new com.baidu.tieba.frs.at();
                                dVar.cyk.cmA = iL2.cmA;
                                dVar.cyk.cmB = new LinkedList();
                                for (x xVar2 : iL2.cmB) {
                                    if (xVar2 != null) {
                                        as asVar2 = new as();
                                        asVar2.name = xVar2.name;
                                        asVar2.cmx = xVar2.cmx;
                                        dVar.cyk.cmB.add(asVar2);
                                    }
                                }
                            }
                            this.cpa.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 49 && this.coV.afp().agi().k(bl.Zh)) {
                            com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                            dVar2.name = frsTabInfo.tab_name;
                            if (iVar.bra() != 0 && iVar.bra() <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + iVar.bra() + ")";
                            }
                            if (this.liveCount > 0 && this.liveCount != iVar.bra() && this.liveCount <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                            } else if (this.liveCount > 99 || iVar.bra() > 99) {
                                dVar2.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.liveCount == 0 && this.liveCount != iVar.bra()) {
                                dVar2.name = frsTabInfo.tab_name;
                            }
                            dVar2.cuL = frsTabInfo.tab_id.intValue();
                            this.cpa.add(dVar2);
                        }
                    }
                }
            } else {
                Iterator<FrsTabInfo> it = iVar.brD().tab.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.cuL = next.tab_id.intValue();
                        dVar3.name = next.tab_name;
                        this.cpa.add(dVar3);
                        break;
                    }
                }
            }
            this.coW.d(this.cpa, iVar.brx(), 12);
            if (!this.coZ) {
                a(bdListView, bdListView.getHeaderViewsCount());
            }
        }
    }

    private boolean a(FrsTabInfo frsTabInfo) {
        if (frsTabInfo == null || frsTabInfo.tab_id.intValue() <= 0 || TextUtils.isEmpty(frsTabInfo.tab_name) || TextUtils.isEmpty(frsTabInfo.tab_name.trim())) {
            return true;
        }
        return !(frsTabInfo.tab_type.intValue() == 1 || frsTabInfo.tab_type.intValue() == 0 || frsTabInfo.tab_type.intValue() == 11 || frsTabInfo.tab_type.intValue() == 12) || frsTabInfo.tab_id.intValue() == 3 || frsTabInfo.tab_id.intValue() == 4;
    }

    private boolean b(FrsTabInfo frsTabInfo) {
        if (frsTabInfo != null) {
            if (frsTabInfo.tab_type.intValue() != 0 || frsTabInfo.tab_id.intValue() < 100) {
                if (frsTabInfo.tab_type.intValue() != 1 || frsTabInfo.tab_id.intValue() >= 100) {
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.jz(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    aj ajVar = new aj(str2);
                    ajVar.aa("obj_type", host);
                    TiebaStatic.log(ajVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView ahv() {
        return this.coW;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eT(boolean z) {
        if (this.coX != null) {
            if (z) {
                this.coX.ahx();
            } else {
                this.coX.ahy();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData aho() {
        return this.cpa;
    }

    private void b(i iVar) {
        if (iVar == null || iVar.bru() == null || iVar.bru().size() == 0) {
            y.agu().a(1, null);
            return;
        }
        List<CategoryInfo> bru = iVar.bru();
        z zVar = new z();
        zVar.cmA = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bru.size()) {
                if (bru.get(i2) != null) {
                    x xVar = new x();
                    xVar.cmx = bru.get(i2).category_id.intValue();
                    xVar.name = bru.get(i2).category_name;
                    arrayList.add(xVar);
                }
                i = i2 + 1;
            } else {
                zVar.cmB = arrayList;
                y.agu().a(1, zVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ahp() {
        if (this.coX == null) {
            return null;
        }
        return this.coX.ahw();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ahq() {
        return this.mRootLayout;
    }
}
