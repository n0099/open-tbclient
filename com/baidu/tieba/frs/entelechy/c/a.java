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

    /* renamed from: com  reason: collision with root package name */
    private f f1com;
    private HorizontalTabView con;
    private com.baidu.tieba.frs.entelechy.c.a.a coo;
    private ai cop;
    private TabData cor;
    private i cos;
    private LinearLayout mRootLayout;
    private boolean coq = false;
    private int liveCount = -1;
    private ai cot = new ai() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i == 101) {
                TiebaStatic.log(new aj("c12103").aa("fid", a.this.f1com.getForumId()));
            }
            if (i > 100) {
                if (anVar != null && (anVar.cmc instanceof String)) {
                    a.this.aR((String) anVar.cmc, "c10079");
                }
            } else {
                aj ajVar = new aj("c10074");
                ajVar.r("obj_type", i);
                ajVar.aa("fid", a.this.f1com.getForumId());
                TiebaStatic.log(ajVar);
                if (i == 99) {
                    aj ajVar2 = new aj("c11500");
                    ajVar2.aa("obj_param1", "2").aa("obj_param2", "1");
                    TiebaStatic.log(ajVar2);
                }
            }
            if (HorizontalTabView.jp(i) && anVar != null) {
                String str = (String) anVar.cmc;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        k.showToast(a.this.f1com.getPageContext().getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else {
                        at.wf().c(a.this.f1com.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.f1com != null && a.this.f1com.getPageContext() != null && a.this.f1com.getPageContext().getPageActivity() != null) {
                    a.this.f1com.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.f1com.getPageContext().getPageActivity()).createNormalCfg(a.this.f1com.ciP, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else if (i == 49 && a.this.f1com != null && a.this.f1com.getPageContext() != null && a.this.f1com.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.f1com.afr().aPh().getForumGameLabel())) {
                if (anVar != null) {
                    anVar.cme = true;
                }
                a.this.f1com.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.f1com.getPageContext().getPageActivity(), a.this.f1com.getForumId(), a.this.f1com.getForumName(), a.this.f1com.afr().aPh().getForumGameLabel())));
            } else {
                if (i == 1) {
                    a.this.coo.ahi();
                } else {
                    a.this.coo.ahj();
                }
                if (a.this.cop != null) {
                    a.this.cop.a(i, i2, anVar);
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
    private HorizontalTabView.c cou = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void iS(int i) {
            a.this.f1com.aeZ().iG(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean iT(int i) {
            return (a.this.f1com != null && a.this.f1com.afs() && i == 1) ? false : true;
        }
    };

    public void iR(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.con = null;
        this.f1com = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.ai.k(this.mRootLayout, d.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.con = new HorizontalTabView(fVar.getPageContext());
        this.con.setForNewFrame(true);
        this.con.cvM = k.g(fVar.getActivity(), d.f.ds20);
        this.con.setAutoFillTabCount(4);
        this.con.setmShowMenuCallBack(this.cou);
        this.con.setNeedBottomLine(false);
        this.con.setTabBackgroudColor(d.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = k.g(fVar.getActivity(), d.f.ds26);
        layoutParams.weight = 1.0f;
        this.con.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.con);
        this.coo = new com.baidu.tieba.frs.entelechy.c.a.a(this.f1com, this.mRootLayout);
        this.con.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cos != null && a.this.cos.aPh() != null) {
                    TiebaStatic.log(new aj("c12047").aa("fid", a.this.cos.aPh().getId()));
                }
            }
        });
        this.con.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.f1com != null) {
                    a.this.f1com.cH(dVar.cwi == 49);
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
        if (this.con != null) {
            this.con.xd();
        }
        if (this.coo != null) {
            this.coo.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(ai aiVar) {
        if (this.con != null) {
            this.con.setDataLoadInterface(this.cot);
        }
        this.cop = aiVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void al(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.coq = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.coq) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.coq = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, i iVar, int i) {
        boolean z;
        if (iVar != null && iVar.brc() != null && iVar.brc().tab != null) {
            this.coo.i(iVar.brc().menu, i);
            if (iVar.aPh() != null) {
                this.coo.setFid(iVar.aPh().getId());
            }
            this.cos = iVar;
            b(iVar);
            this.cor = new TabData();
            if (u.v(iVar.brk())) {
                for (FrsTabInfo frsTabInfo : iVar.brc().tab) {
                    if (!a(frsTabInfo) && !b(frsTabInfo)) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.cwi = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            this.cor.add(dVar);
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
                                sb.append(iVar.aPh().getId());
                                dVar.url = sb.toString();
                                aR(dVar.url, "c10078");
                                this.cor.add(dVar);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.jp(frsTabInfo.tab_id.intValue())) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.co(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cor.add(dVar);
                                }
                            } else {
                                this.cor.add(dVar);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && ab.agg().iM(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            z iJ = y.agf().iJ(dVar.cwi);
                            if (iJ != null && iJ.clO != null && iJ.clO.size() > 0) {
                                dVar.cwj = new com.baidu.tieba.frs.at();
                                dVar.cwj.clN = iJ.clN;
                                dVar.cwj.clO = new LinkedList();
                                boolean z2 = true;
                                for (x xVar : iJ.clO) {
                                    if (xVar != null) {
                                        as asVar = new as();
                                        asVar.name = xVar.name;
                                        asVar.clK = xVar.clK;
                                        if (z2) {
                                            asVar.isSelected = true;
                                            z = false;
                                        } else {
                                            z = z2;
                                        }
                                        dVar.cwj.clO.add(asVar);
                                        z2 = z;
                                    }
                                }
                            }
                            this.cor.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            z iJ2 = y.agf().iJ(dVar.cwi);
                            if (iJ2 != null && iJ2.clO != null && iJ2.clO.size() > 0) {
                                dVar.cwj = new com.baidu.tieba.frs.at();
                                dVar.cwj.clN = iJ2.clN;
                                dVar.cwj.clO = new LinkedList();
                                for (x xVar2 : iJ2.clO) {
                                    if (xVar2 != null) {
                                        as asVar2 = new as();
                                        asVar2.name = xVar2.name;
                                        asVar2.clK = xVar2.clK;
                                        dVar.cwj.clO.add(asVar2);
                                    }
                                }
                            }
                            this.cor.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 49 && this.f1com.aeZ().afR().k(bl.Ze)) {
                            com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                            dVar2.name = frsTabInfo.tab_name;
                            if (iVar.bqz() != 0 && iVar.bqz() <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + iVar.bqz() + ")";
                            }
                            if (this.liveCount > 0 && this.liveCount != iVar.bqz() && this.liveCount <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                            } else if (this.liveCount > 99 || iVar.bqz() > 99) {
                                dVar2.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.liveCount == 0 && this.liveCount != iVar.bqz()) {
                                dVar2.name = frsTabInfo.tab_name;
                            }
                            dVar2.cwi = frsTabInfo.tab_id.intValue();
                            this.cor.add(dVar2);
                        }
                    }
                }
            } else {
                Iterator<FrsTabInfo> it = iVar.brc().tab.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.cwi = next.tab_id.intValue();
                        dVar3.name = next.tab_name;
                        this.cor.add(dVar3);
                        break;
                    }
                }
            }
            this.con.d(this.cor, iVar.bqW(), 12);
            if (!this.coq) {
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

    public HorizontalTabView ahg() {
        return this.con;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eR(boolean z) {
        if (this.coo != null) {
            if (z) {
                this.coo.ahi();
            } else {
                this.coo.ahj();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData agZ() {
        return this.cor;
    }

    private void b(i iVar) {
        if (iVar == null || iVar.bqT() == null || iVar.bqT().size() == 0) {
            y.agf().a(1, null);
            return;
        }
        List<CategoryInfo> bqT = iVar.bqT();
        z zVar = new z();
        zVar.clN = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bqT.size()) {
                if (bqT.get(i2) != null) {
                    x xVar = new x();
                    xVar.clK = bqT.get(i2).category_id.intValue();
                    xVar.name = bqT.get(i2).category_name;
                    arrayList.add(xVar);
                }
                i = i2 + 1;
            } else {
                zVar.clO = arrayList;
                y.agf().a(1, zVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View aha() {
        if (this.coo == null) {
            return null;
        }
        return this.coo.ahh();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ahb() {
        return this.mRootLayout;
    }
}
