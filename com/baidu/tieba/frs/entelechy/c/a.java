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
    private f cna;
    private HorizontalTabView cnb;
    private com.baidu.tieba.frs.entelechy.c.a.a cnc;
    private ai cnd;
    private TabData cnf;
    private i cng;
    private LinearLayout mRootLayout;
    private boolean cne = false;
    private int liveCount = -1;
    private ai cnh = new ai() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i == 101) {
                TiebaStatic.log(new aj("c12103").aa("fid", a.this.cna.getForumId()));
            }
            if (i > 100) {
                if (anVar != null && (anVar.ckU instanceof String)) {
                    a.this.aR((String) anVar.ckU, "c10079");
                }
            } else {
                aj ajVar = new aj("c10074");
                ajVar.r("obj_type", i);
                ajVar.aa("fid", a.this.cna.getForumId());
                TiebaStatic.log(ajVar);
                if (i == 99) {
                    aj ajVar2 = new aj("c11500");
                    ajVar2.aa("obj_param1", "2").aa("obj_param2", "1");
                    TiebaStatic.log(ajVar2);
                }
            }
            if (HorizontalTabView.jp(i) && anVar != null) {
                String str = (String) anVar.ckU;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        k.showToast(a.this.cna.getPageContext().getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else {
                        at.vV().c(a.this.cna.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cna != null && a.this.cna.getPageContext() != null && a.this.cna.getPageContext().getPageActivity() != null) {
                    a.this.cna.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cna.getPageContext().getPageActivity()).createNormalCfg(a.this.cna.chI, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else if (i == 49 && a.this.cna != null && a.this.cna.getPageContext() != null && a.this.cna.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cna.afm().aOW().getForumGameLabel())) {
                if (anVar != null) {
                    anVar.ckV = true;
                }
                a.this.cna.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cna.getPageContext().getPageActivity(), a.this.cna.getForumId(), a.this.cna.getForumName(), a.this.cna.afm().aOW().getForumGameLabel())));
            } else {
                if (i == 1) {
                    a.this.cnc.ahb();
                } else {
                    a.this.cnc.ahc();
                }
                if (a.this.cnd != null) {
                    a.this.cnd.a(i, i2, anVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void Os() {
        }
    };
    private HorizontalTabView.c cni = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void iS(int i) {
            a.this.cna.aeU().iG(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean iT(int i) {
            return (a.this.cna != null && a.this.cna.afn() && i == 1) ? false : true;
        }
    };

    public void iR(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.cnb = null;
        this.cna = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.ai.k(this.mRootLayout, d.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cnb = new HorizontalTabView(fVar.getPageContext());
        this.cnb.setForNewFrame(true);
        this.cnb.cuu = k.g(fVar.getActivity(), d.f.ds20);
        this.cnb.setAutoFillTabCount(4);
        this.cnb.setmShowMenuCallBack(this.cni);
        this.cnb.setNeedBottomLine(false);
        this.cnb.setTabBackgroudColor(d.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
        layoutParams.weight = 1.0f;
        this.cnb.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.cnb);
        this.cnc = new com.baidu.tieba.frs.entelechy.c.a.a(this.cna, this.mRootLayout);
        this.cnb.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cng != null && a.this.cng.aOW() != null) {
                    TiebaStatic.log(new aj("c12047").aa("fid", a.this.cng.aOW().getId()));
                }
            }
        });
        this.cnb.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cna != null) {
                    a.this.cna.cH(dVar.cuQ == 49);
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
        if (this.cnb != null) {
            this.cnb.wV();
        }
        if (this.cnc != null) {
            this.cnc.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(ai aiVar) {
        if (this.cnb != null) {
            this.cnb.setDataLoadInterface(this.cnh);
        }
        this.cnd = aiVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void al(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.cne = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.cne) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.cne = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, i iVar, int i) {
        boolean z;
        if (iVar != null && iVar.bqV() != null && iVar.bqV().tab != null) {
            this.cnc.i(iVar.bqV().menu, i);
            if (iVar.aOW() != null) {
                this.cnc.setFid(iVar.aOW().getId());
            }
            this.cng = iVar;
            b(iVar);
            this.cnf = new TabData();
            if (u.v(iVar.brd())) {
                for (FrsTabInfo frsTabInfo : iVar.bqV().tab) {
                    if (!a(frsTabInfo) && !b(frsTabInfo)) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.cuQ = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            this.cnf.add(dVar);
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
                                sb.append(iVar.aOW().getId());
                                dVar.url = sb.toString();
                                aR(dVar.url, "c10078");
                                this.cnf.add(dVar);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.jp(frsTabInfo.tab_id.intValue())) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.ci(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cnf.add(dVar);
                                }
                            } else {
                                this.cnf.add(dVar);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && ab.afZ().iM(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            z iJ = y.afY().iJ(dVar.cuQ);
                            if (iJ != null && iJ.ckG != null && iJ.ckG.size() > 0) {
                                dVar.cuR = new com.baidu.tieba.frs.at();
                                dVar.cuR.ckF = iJ.ckF;
                                dVar.cuR.ckG = new LinkedList();
                                boolean z2 = true;
                                for (x xVar : iJ.ckG) {
                                    if (xVar != null) {
                                        as asVar = new as();
                                        asVar.name = xVar.name;
                                        asVar.ckC = xVar.ckC;
                                        if (z2) {
                                            asVar.isSelected = true;
                                            z = false;
                                        } else {
                                            z = z2;
                                        }
                                        dVar.cuR.ckG.add(asVar);
                                        z2 = z;
                                    }
                                }
                            }
                            this.cnf.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            z iJ2 = y.afY().iJ(dVar.cuQ);
                            if (iJ2 != null && iJ2.ckG != null && iJ2.ckG.size() > 0) {
                                dVar.cuR = new com.baidu.tieba.frs.at();
                                dVar.cuR.ckF = iJ2.ckF;
                                dVar.cuR.ckG = new LinkedList();
                                for (x xVar2 : iJ2.ckG) {
                                    if (xVar2 != null) {
                                        as asVar2 = new as();
                                        asVar2.name = xVar2.name;
                                        asVar2.ckC = xVar2.ckC;
                                        dVar.cuR.ckG.add(asVar2);
                                    }
                                }
                            }
                            this.cnf.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 49 && this.cna.aeU().afM().k(bl.XI)) {
                            com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                            dVar2.name = frsTabInfo.tab_name;
                            if (iVar.bqs() != 0 && iVar.bqs() <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + iVar.bqs() + ")";
                            }
                            if (this.liveCount > 0 && this.liveCount != iVar.bqs() && this.liveCount <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                            } else if (this.liveCount > 99 || iVar.bqs() > 99) {
                                dVar2.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.liveCount == 0 && this.liveCount != iVar.bqs()) {
                                dVar2.name = frsTabInfo.tab_name;
                            }
                            dVar2.cuQ = frsTabInfo.tab_id.intValue();
                            this.cnf.add(dVar2);
                        }
                    }
                }
            } else {
                Iterator<FrsTabInfo> it = iVar.bqV().tab.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.cuQ = next.tab_id.intValue();
                        dVar3.name = next.tab_name;
                        this.cnf.add(dVar3);
                        break;
                    }
                }
            }
            this.cnb.d(this.cnf, iVar.bqP(), 12);
            if (!this.cne) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.jp(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(String str, String str2) {
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

    public HorizontalTabView agZ() {
        return this.cnb;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eR(boolean z) {
        if (this.cnc != null) {
            if (z) {
                this.cnc.ahb();
            } else {
                this.cnc.ahc();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData agS() {
        return this.cnf;
    }

    private void b(i iVar) {
        if (iVar == null || iVar.bqM() == null || iVar.bqM().size() == 0) {
            y.afY().a(1, null);
            return;
        }
        List<CategoryInfo> bqM = iVar.bqM();
        z zVar = new z();
        zVar.ckF = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bqM.size()) {
                if (bqM.get(i2) != null) {
                    x xVar = new x();
                    xVar.ckC = bqM.get(i2).category_id.intValue();
                    xVar.name = bqM.get(i2).category_name;
                    arrayList.add(xVar);
                }
                i = i2 + 1;
            } else {
                zVar.ckG = arrayList;
                y.afY().a(1, zVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View agT() {
        if (this.cnc == null) {
            return null;
        }
        return this.cnc.aha();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View agU() {
        return this.mRootLayout;
    }
}
