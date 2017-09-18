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
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.at;
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
    private f cws;
    private HorizontalTabView cwt;
    private com.baidu.tieba.frs.entelechy.c.a.a cwu;
    private ai cwv;
    private TabData cwx;
    private i cwy;
    private LinearLayout mRootLayout;
    private boolean cww = false;
    private int liveCount = -1;
    private ai cwz = new ai() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.ai
        public void a(ak akVar) {
        }

        @Override // com.baidu.tieba.frs.ai
        public void a(int i, int i2, an anVar) {
            if (i == 101) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12103").ad("fid", a.this.cws.getForumId()));
            }
            if (i > 100) {
                if (anVar != null && (anVar.ctb instanceof String)) {
                    a.this.aW((String) anVar.ctb, "c10079");
                }
            } else {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c10074");
                akVar.r("obj_type", i);
                akVar.ad("fid", a.this.cws.getForumId());
                TiebaStatic.log(akVar);
                if (i == 99) {
                    com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak("c11500");
                    akVar2.ad("obj_param1", "2").ad("obj_param2", "1");
                    TiebaStatic.log(akVar2);
                }
            }
            if (HorizontalTabView.jP(i) && anVar != null) {
                String str = (String) anVar.ctb;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        k.showToast(a.this.cws.getPageContext().getPageActivity(), d.l.book_plugin_not_install_tip);
                    } else {
                        au.wd().c(a.this.cws.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cws != null && a.this.cws.getPageContext() != null && a.this.cws.getPageContext().getPageActivity() != null) {
                    a.this.cws.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cws.getPageContext().getPageActivity()).createNormalCfg(a.this.cws.cpO, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cws != null && a.this.cws.getPageContext() != null && a.this.cws.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cws.ahq().aPg().getForumGameLabel())) {
                        if (anVar != null) {
                            anVar.ctc = true;
                        }
                        a.this.cws.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cws.getPageContext().getPageActivity(), a.this.cws.getForumId(), a.this.cws.getForumName(), a.this.cws.ahq().aPg().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cws != null && a.this.cws.getPageContext() != null && a.this.cws.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cws.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cws.getPageContext().getPageActivity(), a.this.cws.forumId)));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cwu.ajv();
                } else {
                    a.this.cwu.ajw();
                }
                if (a.this.cwv != null) {
                    a.this.cwv.a(i, i2, anVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.ai
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ai
        public void OQ() {
        }
    };
    private HorizontalTabView.c cwA = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void jk(int i) {
            a.this.cws.agY().iW(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean jl(int i) {
            return (a.this.cws != null && a.this.cws.ahr() && i == 1) ? false : true;
        }
    };

    public void jj(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.cwt = null;
        this.cws = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        aj.k(this.mRootLayout, d.e.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cwt = new HorizontalTabView(fVar.getPageContext());
        this.cwt.setForNewFrame(true);
        this.cwt.cFk = k.f(fVar.getActivity(), d.f.ds20);
        this.cwt.setAutoFillTabCount(4);
        this.cwt.setmShowMenuCallBack(this.cwA);
        this.cwt.setNeedBottomLine(false);
        this.cwt.setTabBackgroudColor(d.e.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = k.f(fVar.getActivity(), d.f.ds26);
        layoutParams.weight = 1.0f;
        this.cwt.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.cwt);
        this.cwu = new com.baidu.tieba.frs.entelechy.c.a.a(this.cws, this.mRootLayout);
        this.cwt.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cwy != null && a.this.cwy.aPg() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12047").ad("fid", a.this.cwy.aPg().getId()));
                }
            }
        });
        this.cwt.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cws != null) {
                    a.this.cws.cK(dVar.cCh == 49);
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
            aj.k(this.mRootLayout, d.e.cp_bg_line_d);
        }
        if (this.cwt != null) {
            this.cwt.xc();
        }
        if (this.cwu != null) {
            this.cwu.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(ai aiVar) {
        if (this.cwt != null) {
            this.cwt.setDataLoadInterface(this.cwz);
        }
        this.cwv = aiVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void as(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.cww = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.cww) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.cww = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, i iVar, int i) {
        boolean z;
        if (iVar != null && iVar.brd() != null && iVar.brd().tab != null) {
            this.cwu.i(iVar.brd().menu, i);
            if (iVar.aPg() != null) {
                this.cwu.setFid(iVar.aPg().getId());
            }
            this.cwy = iVar;
            b(iVar);
            this.cwx = new TabData();
            if (v.v(iVar.brl())) {
                for (FrsTabInfo frsTabInfo : iVar.brd().tab) {
                    if (!a(frsTabInfo) && !b(frsTabInfo)) {
                        com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                        dVar.cCh = frsTabInfo.tab_id.intValue();
                        dVar.name = frsTabInfo.tab_name;
                        if (frsTabInfo.tab_type.intValue() == 12) {
                            this.cwx.add(dVar);
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
                                sb.append(iVar.aPg().getId());
                                dVar.url = sb.toString();
                                aW(dVar.url, "c10078");
                                this.cwx.add(dVar);
                            }
                        } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.jP(frsTabInfo.tab_id.intValue())) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.ch(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cwx.add(dVar);
                                }
                            } else {
                                this.cwx.add(dVar);
                            }
                        } else if (frsTabInfo.tab_id.intValue() != 1 && ab.aie().jc(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                            z iZ = y.aid().iZ(dVar.cCh);
                            if (iZ != null && iZ.csN != null && iZ.csN.size() > 0) {
                                dVar.cFF = new at();
                                dVar.cFF.csM = iZ.csM;
                                dVar.cFF.csN = new LinkedList();
                                boolean z2 = true;
                                for (x xVar : iZ.csN) {
                                    if (xVar != null) {
                                        as asVar = new as();
                                        asVar.name = xVar.name;
                                        asVar.csJ = xVar.csJ;
                                        if (z2) {
                                            asVar.isSelected = true;
                                            z = false;
                                        } else {
                                            z = z2;
                                        }
                                        dVar.cFF.csN.add(asVar);
                                        z2 = z;
                                    }
                                }
                            }
                            this.cwx.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 1) {
                            z iZ2 = y.aid().iZ(dVar.cCh);
                            if (iZ2 != null && iZ2.csN != null && iZ2.csN.size() > 0) {
                                dVar.cFF = new at();
                                dVar.cFF.csM = iZ2.csM;
                                dVar.cFF.csN = new LinkedList();
                                for (x xVar2 : iZ2.csN) {
                                    if (xVar2 != null) {
                                        as asVar2 = new as();
                                        asVar2.name = xVar2.name;
                                        asVar2.csJ = xVar2.csJ;
                                        dVar.cFF.csN.add(asVar2);
                                    }
                                }
                            }
                            this.cwx.add(dVar);
                        } else if (frsTabInfo.tab_id.intValue() == 49 && this.cws.agY().ahR().m(bj.Yl)) {
                            com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                            dVar2.name = frsTabInfo.tab_name;
                            if (iVar.bqA() != 0 && iVar.bqA() <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + iVar.bqA() + ")";
                            }
                            if (this.liveCount > 0 && this.liveCount != iVar.bqA() && this.liveCount <= 99) {
                                dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                            } else if (this.liveCount > 99 || iVar.bqA() > 99) {
                                dVar2.name = frsTabInfo.tab_name + "(99+)";
                            } else if (this.liveCount == 0 && this.liveCount != iVar.bqA()) {
                                dVar2.name = frsTabInfo.tab_name;
                            }
                            dVar2.cCh = frsTabInfo.tab_id.intValue();
                            this.cwx.add(dVar2);
                        }
                    }
                }
            } else {
                Iterator<FrsTabInfo> it = iVar.brd().tab.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 1) {
                        com.baidu.tieba.frs.tab.d dVar3 = new com.baidu.tieba.frs.tab.d();
                        dVar3.cCh = next.tab_id.intValue();
                        dVar3.name = next.tab_name;
                        this.cwx.add(dVar3);
                        break;
                    }
                }
            }
            this.cwt.d(this.cwx, iVar.bqX(), 12);
            if (!this.cww) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.jP(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                URI uri = new URI(str);
                if (uri != null) {
                    String host = uri.getHost();
                    com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak(str2);
                    akVar.ad("obj_type", host);
                    TiebaStatic.log(akVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView ajt() {
        return this.cwt;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fc(boolean z) {
        if (this.cwu != null) {
            if (z) {
                this.cwu.ajv();
            } else {
                this.cwu.ajw();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData ajm() {
        return this.cwx;
    }

    private void b(i iVar) {
        if (iVar == null || iVar.bqU() == null || iVar.bqU().size() == 0) {
            y.aid().a(1, null);
            return;
        }
        List<CategoryInfo> bqU = iVar.bqU();
        z zVar = new z();
        zVar.csM = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bqU.size()) {
                if (bqU.get(i2) != null) {
                    x xVar = new x();
                    xVar.csJ = bqU.get(i2).category_id.intValue();
                    xVar.name = bqU.get(i2).category_name;
                    arrayList.add(xVar);
                }
                i = i2 + 1;
            } else {
                zVar.csN = arrayList;
                y.aid().a(1, zVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ajn() {
        if (this.cwu == null) {
            return null;
        }
        return this.cwu.aju();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View ajo() {
        return this.mRootLayout;
    }
}
