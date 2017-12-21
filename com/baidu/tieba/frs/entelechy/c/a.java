package com.baidu.tieba.frs.entelechy.c;

import android.text.TextUtils;
import android.view.View;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.aa;
import com.baidu.tieba.frs.ab;
import com.baidu.tieba.frs.ad;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.entelechy.b.d;
import com.baidu.tieba.frs.g;
import com.baidu.tieba.frs.tab.HorizontalTabView;
import com.baidu.tieba.frs.tab.TabData;
import com.baidu.tieba.frs.z;
import com.baidu.tieba.tbadkCore.k;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import tbclient.CategoryInfo;
import tbclient.FrsTabInfo;
/* loaded from: classes.dex */
public class a implements d {
    private g cOB;
    private HorizontalTabView cOC;
    private com.baidu.tieba.frs.entelechy.c.a.a cOD;
    private ak cOE;
    private TabData cOG;
    private k cOH;
    private RelativeLayout ctl;
    private boolean cOF = false;
    private int liveCount = -1;
    private ak cOI = new ak() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.ak
        public void a(am amVar) {
        }

        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ap apVar) {
            if (i == 101) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12103").ac(ImageViewerConfig.FORUM_ID, a.this.cOB.getForumId()));
            }
            if (i > 100) {
                if (apVar != null && (apVar.cKB instanceof String)) {
                    a.this.aW((String) apVar.cKB, "c10079");
                }
            } else {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c10074");
                akVar.r("obj_type", i);
                akVar.ac(ImageViewerConfig.FORUM_ID, a.this.cOB.getForumId());
                TiebaStatic.log(akVar);
            }
            if (i == 201 || i == 202) {
                com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak("c11500");
                akVar2.ac("obj_param1", i == 201 ? "2" : "1").ac("obj_param2", "1");
                TiebaStatic.log(akVar2);
            }
            if (HorizontalTabView.kS(i) && apVar != null) {
                String str = (String) apVar.cKB;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        l.showToast(a.this.cOB.getPageContext().getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else {
                        av.vI().c(a.this.cOB.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cOB != null && a.this.cOB.getPageContext() != null && a.this.cOB.getPageContext().getPageActivity() != null) {
                    a.this.cOB.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cOB.getPageContext().getPageActivity()).createNormalCfg(a.this.cOB.cHf, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cOB != null && a.this.cOB.getPageContext() != null && a.this.cOB.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cOB.alE().aRo().getForumGameLabel())) {
                        if (apVar != null) {
                            apVar.cKC = true;
                        }
                        a.this.cOB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cOB.getPageContext().getPageActivity(), a.this.cOB.getForumId(), a.this.cOB.getForumName(), a.this.cOB.alE().aRo().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cOB != null && a.this.cOB.getPageContext() != null && a.this.cOB.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cOB.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cOB.getPageContext().getPageActivity(), a.this.cOB.forumId, VideoAggregationActivityConfig.TYPE_FROM_FRS, "", "")));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cOD.aoa();
                } else {
                    a.this.cOD.aob();
                }
                if (a.this.cOE != null) {
                    a.this.cOE.a(i, i2, apVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.ak
        public void init() {
        }

        @Override // com.baidu.tieba.frs.ak
        public void QJ() {
        }
    };
    private HorizontalTabView.c cOJ = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void ki(int i) {
            a.this.cOB.aln().jS(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean kj(int i) {
            return (a.this.cOB != null && a.this.cOB.alF() && i == 1) ? false : true;
        }
    };

    public void kh(int i) {
        this.liveCount = i;
    }

    public a(g gVar) {
        this.cOC = null;
        this.cOB = gVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds104);
        this.ctl = new RelativeLayout(gVar.getActivity());
        aj.k(this.ctl, d.C0095d.cp_bg_line_d);
        this.ctl.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cOC = new HorizontalTabView(gVar.getPageContext());
        this.cOC.setForNewFrame(true);
        this.cOC.cZd = l.f(gVar.getActivity(), d.e.ds20);
        this.cOC.setAutoFillTabCount(4);
        this.cOC.setmShowMenuCallBack(this.cOJ);
        this.cOC.setTabBackgroudColor(d.C0095d.cp_bg_line_d);
        this.cOC.setLayoutParams(new RelativeLayout.LayoutParams(-1, dimensionPixelSize));
        this.ctl.addView(this.cOC);
        this.cOC.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cOH != null && a.this.cOH.aRo() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12047").ac(ImageViewerConfig.FORUM_ID, a.this.cOH.aRo().getId()));
                }
            }
        });
        this.cOC.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cOB != null) {
                    a.this.cOB.cN(dVar.tabId == 49);
                }
            }
        });
        this.cOD = new com.baidu.tieba.frs.entelechy.c.a.a(this.cOB, this.ctl);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.ctl != null) {
            aj.k(this.ctl, d.C0095d.cp_bg_line_d);
        }
        if (this.cOC != null) {
            this.cOC.wC();
        }
        if (this.cOD != null) {
            this.cOD.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(ak akVar) {
        if (this.cOC != null) {
            this.cOC.setDataLoadInterface(this.cOI);
        }
        this.cOE = akVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void az(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.ctl != null && bdListView != null) {
            bdListView.removeHeaderView(this.ctl);
            this.cOF = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.ctl != null && !this.cOF) {
            bdListView.addHeaderView(this.ctl, Integer.valueOf(i), false);
            this.cOF = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, k kVar, int i) {
        boolean z;
        if (kVar != null && kVar.bvu() != null && kVar.bvu().tab != null) {
            this.cOD.setData(kVar.bvu().menu, i);
            if (kVar.aRo() != null) {
                this.cOD.setFid(kVar.aRo().getId());
            }
            this.cOH = kVar;
            c(kVar);
            this.cOG = new TabData();
            for (FrsTabInfo frsTabInfo : kVar.bvu().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                    dVar.tabId = frsTabInfo.tab_id.intValue();
                    dVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.cOG.add(dVar);
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
                            sb.append(kVar.aRo().getId());
                            dVar.url = sb.toString();
                            aW(dVar.url, "c10078");
                            this.cOG.add(dVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.kS(frsTabInfo.tab_id.intValue())) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.cm(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cOG.add(dVar);
                                }
                            } else {
                                this.cOG.add(dVar);
                            }
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ad.amy().jY(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        ab jV = aa.amx().jV(dVar.tabId);
                        if (jV != null && jV.cKl != null && jV.cKl.size() > 0) {
                            dVar.cZy = new com.baidu.tieba.frs.av();
                            dVar.cZy.cKk = jV.cKk;
                            dVar.cZy.cKl = new LinkedList();
                            boolean z2 = true;
                            for (z zVar : jV.cKl) {
                                if (zVar != null) {
                                    au auVar = new au();
                                    auVar.name = zVar.name;
                                    auVar.cKh = zVar.cKh;
                                    if (z2) {
                                        auVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar.cZy.cKl.add(auVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.cOG.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        ab jV2 = aa.amx().jV(dVar.tabId);
                        if (jV2 != null && jV2.cKl != null && jV2.cKl.size() > 0) {
                            dVar.cZy = new com.baidu.tieba.frs.av();
                            dVar.cZy.cKk = jV2.cKk;
                            dVar.cZy.cKl = new LinkedList();
                            for (z zVar2 : jV2.cKl) {
                                if (zVar2 != null) {
                                    au auVar2 = new au();
                                    auVar2.name = zVar2.name;
                                    auVar2.cKh = zVar2.cKh;
                                    dVar.cZy.cKl.add(auVar2);
                                }
                            }
                        }
                        this.cOG.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cOB.aln().ame().l(bd.YH)) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.name = frsTabInfo.tab_name;
                        if (kVar.buS() != 0 && kVar.buS() <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + kVar.buS() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != kVar.buS() && this.liveCount <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || kVar.buS() > 99) {
                            dVar2.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != kVar.buS()) {
                            dVar2.name = frsTabInfo.tab_name;
                        }
                        dVar2.tabId = frsTabInfo.tab_id.intValue();
                        this.cOG.add(dVar2);
                    }
                }
            }
            this.cOC.d(this.cOG, kVar.bvo(), 12);
            if (!this.cOF) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.kS(frsTabInfo.tab_id.intValue());
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
                    akVar.ac("obj_type", host);
                    TiebaStatic.log(akVar);
                }
            } catch (URISyntaxException e) {
                BdLog.e(e);
            }
        }
    }

    public HorizontalTabView anY() {
        return this.cOC;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fm(boolean z) {
        if (this.cOD != null) {
            if (z) {
                this.cOD.aoa();
            } else {
                this.cOD.aob();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData anR() {
        return this.cOG;
    }

    private void c(k kVar) {
        if (kVar == null || kVar.bvl() == null || kVar.bvl().size() == 0) {
            aa.amx().a(1, null);
            return;
        }
        List<CategoryInfo> bvl = kVar.bvl();
        ab abVar = new ab();
        abVar.cKk = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bvl.size()) {
                if (bvl.get(i2) != null) {
                    z zVar = new z();
                    zVar.cKh = bvl.get(i2).category_id.intValue();
                    zVar.name = bvl.get(i2).category_name;
                    arrayList.add(zVar);
                }
                i = i2 + 1;
            } else {
                abVar.cKl = arrayList;
                aa.amx().a(1, abVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View anS() {
        if (this.cOD == null) {
            return null;
        }
        return this.cOD.anZ();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View anT() {
        return this.ctl;
    }
}
