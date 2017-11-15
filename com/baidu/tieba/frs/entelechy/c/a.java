package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ac;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.y;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.j;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements d {
    private f cFg;
    private HorizontalTabView cFh;
    private com.baidu.tieba.frs.entelechy.c.a.a cFi;
    private aj cFj;
    private TabData cFl;
    private j cFm;
    private LinearLayout mRootLayout;
    private boolean cFk = false;
    private int liveCount = -1;
    private aj cFn = new aj() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i == 101) {
                TiebaStatic.log(new ak("c12103").ac(ImageViewerConfig.FORUM_ID, a.this.cFg.getForumId()));
            }
            if (i > 100) {
                if (aoVar != null && (aoVar.cBj instanceof String)) {
                    a.this.aS((String) aoVar.cBj, "c10079");
                }
            } else {
                ak akVar = new ak("c10074");
                akVar.r("obj_type", i);
                akVar.ac(ImageViewerConfig.FORUM_ID, a.this.cFg.getForumId());
                TiebaStatic.log(akVar);
            }
            if (i == 99 || i == 202) {
                ak akVar2 = new ak("c11500");
                akVar2.ac("obj_param1", i == 99 ? "2" : "1").ac("obj_param2", "1");
                TiebaStatic.log(akVar2);
            }
            if (HorizontalTabView.ks(i) && aoVar != null) {
                String str = (String) aoVar.cBj;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        l.showToast(a.this.cFg.getPageContext().getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else {
                        av.vI().c(a.this.cFg.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cFg != null && a.this.cFg.getPageContext() != null && a.this.cFg.getPageContext().getPageActivity() != null) {
                    a.this.cFg.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cFg.getPageContext().getPageActivity()).createNormalCfg(a.this.cFg.cxN, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cFg != null && a.this.cFg.getPageContext() != null && a.this.cFg.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cFg.ajB().aPU().getForumGameLabel())) {
                        if (aoVar != null) {
                            aoVar.cBk = true;
                        }
                        a.this.cFg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cFg.getPageContext().getPageActivity(), a.this.cFg.getForumId(), a.this.cFg.getForumName(), a.this.cFg.ajB().aPU().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cFg != null && a.this.cFg.getPageContext() != null && a.this.cFg.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cFg.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cFg.getPageContext().getPageActivity(), a.this.cFg.forumId, VideoAggregationActivityConfig.TYPE_FROM_FRS, "", "")));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cFi.alW();
                } else {
                    a.this.cFi.alX();
                }
                if (a.this.cFj != null) {
                    a.this.cFj.a(i, i2, aoVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void PA() {
        }
    };
    private HorizontalTabView.c cFo = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void jI(int i) {
            a.this.cFg.ajk().js(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean jJ(int i) {
            return (a.this.cFg != null && a.this.cFg.ajC() && i == 1) ? false : true;
        }
    };

    public void jH(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.cFh = null;
        this.cFg = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.aj.k(this.mRootLayout, d.C0080d.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cFh = new HorizontalTabView(fVar.getPageContext());
        this.cFh.setForNewFrame(true);
        this.cFh.cPy = l.f(fVar.getActivity(), d.e.ds20);
        this.cFh.setAutoFillTabCount(4);
        this.cFh.setmShowMenuCallBack(this.cFo);
        this.cFh.setNeedBottomLine(false);
        this.cFh.setTabBackgroudColor(d.C0080d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = l.f(fVar.getActivity(), d.e.ds26);
        layoutParams.weight = 1.0f;
        this.cFh.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.cFh);
        this.cFi = new com.baidu.tieba.frs.entelechy.c.a.a(this.cFg, this.mRootLayout);
        this.cFh.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cFm != null && a.this.cFm.aPU() != null) {
                    TiebaStatic.log(new ak("c12047").ac(ImageViewerConfig.FORUM_ID, a.this.cFm.aPU().getId()));
                }
            }
        });
        this.cFh.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cFg != null) {
                    a.this.cFg.cE(dVar.cKT == 49);
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
            com.baidu.tbadk.core.util.aj.k(this.mRootLayout, d.C0080d.cp_bg_line_d);
        }
        if (this.cFh != null) {
            this.cFh.wB();
        }
        if (this.cFi != null) {
            this.cFi.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(aj ajVar) {
        if (this.cFh != null) {
            this.cFh.setDataLoadInterface(this.cFn);
        }
        this.cFj = ajVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void aw(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.cFk = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.cFk) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.cFk = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, j jVar, int i) {
        boolean z;
        if (jVar != null && jVar.bth() != null && jVar.bth().tab != null) {
            this.cFi.j(jVar.bth().menu, i);
            if (jVar.aPU() != null) {
                this.cFi.setFid(jVar.aPU().getId());
            }
            this.cFm = jVar;
            b(jVar);
            this.cFl = new TabData();
            for (FrsTabInfo frsTabInfo : jVar.bth().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                    dVar.cKT = frsTabInfo.tab_id.intValue();
                    dVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.cFl.add(dVar);
                    } else if (frsTabInfo.tab_type.intValue() == 1 && frsTabInfo.tab_id.intValue() >= 100) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            StringBuilder sb = new StringBuilder();
                            String lowerCase = frsTabInfo.tab_url.toLowerCase();
                            if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://") && !lowerCase.contains("://")) {
                                sb.append("http://");
                            }
                            sb.append(frsTabInfo.tab_url);
                            sb.append("&");
                            sb.append(ImageViewerConfig.FORUM_ID);
                            sb.append("=");
                            sb.append(jVar.aPU().getId());
                            dVar.url = sb.toString();
                            aS(dVar.url, "c10078");
                            this.cFl.add(dVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.ks(frsTabInfo.tab_id.intValue())) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.cm(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cFl.add(dVar);
                                }
                            } else {
                                this.cFl.add(dVar);
                            }
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ac.akt().jy(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        aa jv = z.aks().jv(dVar.cKT);
                        if (jv != null && jv.cAT != null && jv.cAT.size() > 0) {
                            dVar.cPT = new au();
                            dVar.cPT.cAS = jv.cAS;
                            dVar.cPT.cAT = new LinkedList();
                            boolean z2 = true;
                            for (y yVar : jv.cAT) {
                                if (yVar != null) {
                                    at atVar = new at();
                                    atVar.name = yVar.name;
                                    atVar.cAP = yVar.cAP;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar.cPT.cAT.add(atVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.cFl.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        aa jv2 = z.aks().jv(dVar.cKT);
                        if (jv2 != null && jv2.cAT != null && jv2.cAT.size() > 0) {
                            dVar.cPT = new au();
                            dVar.cPT.cAS = jv2.cAS;
                            dVar.cPT.cAT = new LinkedList();
                            for (y yVar2 : jv2.cAT) {
                                if (yVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = yVar2.name;
                                    atVar2.cAP = yVar2.cAP;
                                    dVar.cPT.cAT.add(atVar2);
                                }
                            }
                        }
                        this.cFl.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cFg.ajk().akb().l(bh.Ys)) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.name = frsTabInfo.tab_name;
                        if (jVar.bsE() != 0 && jVar.bsE() <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + jVar.bsE() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != jVar.bsE() && this.liveCount <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || jVar.bsE() > 99) {
                            dVar2.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != jVar.bsE()) {
                            dVar2.name = frsTabInfo.tab_name;
                        }
                        dVar2.cKT = frsTabInfo.tab_id.intValue();
                        this.cFl.add(dVar2);
                    }
                }
            }
            this.cFh.d(this.cFl, jVar.btb(), 12);
            if (!this.cFk) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.ks(frsTabInfo.tab_id.intValue());
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
                    ak akVar = new ak(str2);
                    akVar.ac("obj_type", host);
                    TiebaStatic.log(akVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView alU() {
        return this.cFh;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eU(boolean z) {
        if (this.cFi != null) {
            if (z) {
                this.cFi.alW();
            } else {
                this.cFi.alX();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData alN() {
        return this.cFl;
    }

    private void b(j jVar) {
        if (jVar == null || jVar.bsY() == null || jVar.bsY().size() == 0) {
            z.aks().a(1, null);
            return;
        }
        List<CategoryInfo> bsY = jVar.bsY();
        aa aaVar = new aa();
        aaVar.cAS = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bsY.size()) {
                if (bsY.get(i2) != null) {
                    y yVar = new y();
                    yVar.cAP = bsY.get(i2).category_id.intValue();
                    yVar.name = bsY.get(i2).category_name;
                    arrayList.add(yVar);
                }
                i = i2 + 1;
            } else {
                aaVar.cAT = arrayList;
                z.aks().a(1, aaVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View alO() {
        if (this.cFi == null) {
            return null;
        }
        return this.cFi.alV();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View alP() {
        return this.mRootLayout;
    }
}
