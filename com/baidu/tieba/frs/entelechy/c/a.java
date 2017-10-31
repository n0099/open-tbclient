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
    private f cEN;
    private HorizontalTabView cEO;
    private com.baidu.tieba.frs.entelechy.c.a.a cEP;
    private aj cEQ;
    private TabData cES;
    private j cET;
    private LinearLayout mRootLayout;
    private boolean cER = false;
    private int liveCount = -1;
    private aj cEU = new aj() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i == 101) {
                TiebaStatic.log(new ak("c12103").ac(ImageViewerConfig.FORUM_ID, a.this.cEN.getForumId()));
            }
            if (i > 100) {
                if (aoVar != null && (aoVar.cAQ instanceof String)) {
                    a.this.aR((String) aoVar.cAQ, "c10079");
                }
            } else {
                ak akVar = new ak("c10074");
                akVar.r("obj_type", i);
                akVar.ac(ImageViewerConfig.FORUM_ID, a.this.cEN.getForumId());
                TiebaStatic.log(akVar);
            }
            if (i == 99 || i == 202) {
                ak akVar2 = new ak("c11500");
                akVar2.ac("obj_param1", i == 99 ? "2" : "1").ac("obj_param2", "1");
                TiebaStatic.log(akVar2);
            }
            if (HorizontalTabView.ks(i) && aoVar != null) {
                String str = (String) aoVar.cAQ;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        l.showToast(a.this.cEN.getPageContext().getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else {
                        av.vI().c(a.this.cEN.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cEN != null && a.this.cEN.getPageContext() != null && a.this.cEN.getPageContext().getPageActivity() != null) {
                    a.this.cEN.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cEN.getPageContext().getPageActivity()).createNormalCfg(a.this.cEN.cxu, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cEN != null && a.this.cEN.getPageContext() != null && a.this.cEN.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cEN.ajn().aPM().getForumGameLabel())) {
                        if (aoVar != null) {
                            aoVar.cAR = true;
                        }
                        a.this.cEN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cEN.getPageContext().getPageActivity(), a.this.cEN.getForumId(), a.this.cEN.getForumName(), a.this.cEN.ajn().aPM().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cEN != null && a.this.cEN.getPageContext() != null && a.this.cEN.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cEN.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cEN.getPageContext().getPageActivity(), a.this.cEN.forumId, VideoAggregationActivityConfig.TYPE_FROM_FRS, "", "")));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cEP.alI();
                } else {
                    a.this.cEP.alJ();
                }
                if (a.this.cEQ != null) {
                    a.this.cEQ.a(i, i2, aoVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void Pp() {
        }
    };
    private HorizontalTabView.c cEV = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void jJ(int i) {
            a.this.cEN.aiW().jt(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean jK(int i) {
            return (a.this.cEN != null && a.this.cEN.ajo() && i == 1) ? false : true;
        }
    };

    public void jI(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.cEO = null;
        this.cEN = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds114);
        this.mRootLayout = new LinearLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.aj.k(this.mRootLayout, d.C0080d.cp_bg_line_d);
        this.mRootLayout.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cEO = new HorizontalTabView(fVar.getPageContext());
        this.cEO.setForNewFrame(true);
        this.cEO.cPe = l.f(fVar.getActivity(), d.e.ds20);
        this.cEO.setAutoFillTabCount(4);
        this.cEO.setmShowMenuCallBack(this.cEV);
        this.cEO.setNeedBottomLine(false);
        this.cEO.setTabBackgroudColor(d.C0080d.cp_bg_line_d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, dimensionPixelSize);
        layoutParams.topMargin = l.f(fVar.getActivity(), d.e.ds26);
        layoutParams.weight = 1.0f;
        this.cEO.setLayoutParams(layoutParams);
        this.mRootLayout.addView(this.cEO);
        this.cEP = new com.baidu.tieba.frs.entelechy.c.a.a(this.cEN, this.mRootLayout);
        this.cEO.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cET != null && a.this.cET.aPM() != null) {
                    TiebaStatic.log(new ak("c12047").ac(ImageViewerConfig.FORUM_ID, a.this.cET.aPM().getId()));
                }
            }
        });
        this.cEO.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cEN != null) {
                    a.this.cEN.cD(dVar.cKA == 49);
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
        if (this.cEO != null) {
            this.cEO.wB();
        }
        if (this.cEP != null) {
            this.cEP.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(aj ajVar) {
        if (this.cEO != null) {
            this.cEO.setDataLoadInterface(this.cEU);
        }
        this.cEQ = ajVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void av(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.mRootLayout != null && bdListView != null) {
            bdListView.removeHeaderView(this.mRootLayout);
            this.cER = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.mRootLayout != null && !this.cER) {
            bdListView.addHeaderView(this.mRootLayout, Integer.valueOf(i), false);
            this.cER = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, j jVar, int i) {
        boolean z;
        if (jVar != null && jVar.bsW() != null && jVar.bsW().tab != null) {
            this.cEP.j(jVar.bsW().menu, i);
            if (jVar.aPM() != null) {
                this.cEP.setFid(jVar.aPM().getId());
            }
            this.cET = jVar;
            b(jVar);
            this.cES = new TabData();
            for (FrsTabInfo frsTabInfo : jVar.bsW().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                    dVar.cKA = frsTabInfo.tab_id.intValue();
                    dVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.cES.add(dVar);
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
                            sb.append(jVar.aPM().getId());
                            dVar.url = sb.toString();
                            aR(dVar.url, "c10078");
                            this.cES.add(dVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.ks(frsTabInfo.tab_id.intValue())) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.cm(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cES.add(dVar);
                                }
                            } else {
                                this.cES.add(dVar);
                            }
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ac.akf().jz(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        aa jw = z.ake().jw(dVar.cKA);
                        if (jw != null && jw.cAA != null && jw.cAA.size() > 0) {
                            dVar.cPz = new au();
                            dVar.cPz.cAz = jw.cAz;
                            dVar.cPz.cAA = new LinkedList();
                            boolean z2 = true;
                            for (y yVar : jw.cAA) {
                                if (yVar != null) {
                                    at atVar = new at();
                                    atVar.name = yVar.name;
                                    atVar.cAw = yVar.cAw;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar.cPz.cAA.add(atVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.cES.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        aa jw2 = z.ake().jw(dVar.cKA);
                        if (jw2 != null && jw2.cAA != null && jw2.cAA.size() > 0) {
                            dVar.cPz = new au();
                            dVar.cPz.cAz = jw2.cAz;
                            dVar.cPz.cAA = new LinkedList();
                            for (y yVar2 : jw2.cAA) {
                                if (yVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = yVar2.name;
                                    atVar2.cAw = yVar2.cAw;
                                    dVar.cPz.cAA.add(atVar2);
                                }
                            }
                        }
                        this.cES.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cEN.aiW().ajN().l(bh.Ys)) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.name = frsTabInfo.tab_name;
                        if (jVar.bst() != 0 && jVar.bst() <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + jVar.bst() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != jVar.bst() && this.liveCount <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || jVar.bst() > 99) {
                            dVar2.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != jVar.bst()) {
                            dVar2.name = frsTabInfo.tab_name;
                        }
                        dVar2.cKA = frsTabInfo.tab_id.intValue();
                        this.cES.add(dVar2);
                    }
                }
            }
            this.cEO.d(this.cES, jVar.bsQ(), 12);
            if (!this.cER) {
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
    public void aR(String str, String str2) {
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

    public HorizontalTabView alG() {
        return this.cEO;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void eP(boolean z) {
        if (this.cEP != null) {
            if (z) {
                this.cEP.alI();
            } else {
                this.cEP.alJ();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData alz() {
        return this.cES;
    }

    private void b(j jVar) {
        if (jVar == null || jVar.bsN() == null || jVar.bsN().size() == 0) {
            z.ake().a(1, null);
            return;
        }
        List<CategoryInfo> bsN = jVar.bsN();
        aa aaVar = new aa();
        aaVar.cAz = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bsN.size()) {
                if (bsN.get(i2) != null) {
                    y yVar = new y();
                    yVar.cAw = bsN.get(i2).category_id.intValue();
                    yVar.name = bsN.get(i2).category_name;
                    arrayList.add(yVar);
                }
                i = i2 + 1;
            } else {
                aaVar.cAA = arrayList;
                z.ake().a(1, aaVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View alA() {
        if (this.cEP == null) {
            return null;
        }
        return this.cEP.alH();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View alB() {
        return this.mRootLayout;
    }
}
