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
    private ak cOA;
    private TabData cOC;
    private k cOD;
    private g cOx;
    private HorizontalTabView cOy;
    private com.baidu.tieba.frs.entelechy.c.a.a cOz;
    private RelativeLayout cth;
    private boolean cOB = false;
    private int liveCount = -1;
    private ak cOE = new ak() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.ak
        public void a(am amVar) {
        }

        @Override // com.baidu.tieba.frs.ak
        public void a(int i, int i2, ap apVar) {
            if (i == 101) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12103").ac(ImageViewerConfig.FORUM_ID, a.this.cOx.getForumId()));
            }
            if (i > 100) {
                if (apVar != null && (apVar.cKx instanceof String)) {
                    a.this.aW((String) apVar.cKx, "c10079");
                }
            } else {
                com.baidu.tbadk.core.util.ak akVar = new com.baidu.tbadk.core.util.ak("c10074");
                akVar.r("obj_type", i);
                akVar.ac(ImageViewerConfig.FORUM_ID, a.this.cOx.getForumId());
                TiebaStatic.log(akVar);
            }
            if (i == 201 || i == 202) {
                com.baidu.tbadk.core.util.ak akVar2 = new com.baidu.tbadk.core.util.ak("c11500");
                akVar2.ac("obj_param1", i == 201 ? "2" : "1").ac("obj_param2", "1");
                TiebaStatic.log(akVar2);
            }
            if (HorizontalTabView.kS(i) && apVar != null) {
                String str = (String) apVar.cKx;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        l.showToast(a.this.cOx.getPageContext().getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else {
                        av.vI().c(a.this.cOx.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cOx != null && a.this.cOx.getPageContext() != null && a.this.cOx.getPageContext().getPageActivity() != null) {
                    a.this.cOx.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cOx.getPageContext().getPageActivity()).createNormalCfg(a.this.cOx.cHb, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cOx != null && a.this.cOx.getPageContext() != null && a.this.cOx.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cOx.alF().aRo().getForumGameLabel())) {
                        if (apVar != null) {
                            apVar.cKy = true;
                        }
                        a.this.cOx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cOx.getPageContext().getPageActivity(), a.this.cOx.getForumId(), a.this.cOx.getForumName(), a.this.cOx.alF().aRo().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cOx != null && a.this.cOx.getPageContext() != null && a.this.cOx.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cOx.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cOx.getPageContext().getPageActivity(), a.this.cOx.forumId, VideoAggregationActivityConfig.TYPE_FROM_FRS, "", "")));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cOz.aoa();
                } else {
                    a.this.cOz.aob();
                }
                if (a.this.cOA != null) {
                    a.this.cOA.a(i, i2, apVar);
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
    private HorizontalTabView.c cOF = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void ki(int i) {
            a.this.cOx.alo().jS(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean kj(int i) {
            return (a.this.cOx != null && a.this.cOx.alG() && i == 1) ? false : true;
        }
    };

    public void kh(int i) {
        this.liveCount = i;
    }

    public a(g gVar) {
        this.cOy = null;
        this.cOx = gVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds104);
        this.cth = new RelativeLayout(gVar.getActivity());
        aj.k(this.cth, d.C0096d.cp_bg_line_d);
        this.cth.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cOy = new HorizontalTabView(gVar.getPageContext());
        this.cOy.setForNewFrame(true);
        this.cOy.cYZ = l.f(gVar.getActivity(), d.e.ds20);
        this.cOy.setAutoFillTabCount(4);
        this.cOy.setmShowMenuCallBack(this.cOF);
        this.cOy.setTabBackgroudColor(d.C0096d.cp_bg_line_d);
        this.cOy.setLayoutParams(new RelativeLayout.LayoutParams(-1, dimensionPixelSize));
        this.cth.addView(this.cOy);
        this.cOy.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cOD != null && a.this.cOD.aRo() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ak("c12047").ac(ImageViewerConfig.FORUM_ID, a.this.cOD.aRo().getId()));
                }
            }
        });
        this.cOy.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cOx != null) {
                    a.this.cOx.cN(dVar.tabId == 49);
                }
            }
        });
        this.cOz = new com.baidu.tieba.frs.entelechy.c.a.a(this.cOx, this.cth);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.cth != null) {
            aj.k(this.cth, d.C0096d.cp_bg_line_d);
        }
        if (this.cOy != null) {
            this.cOy.wC();
        }
        if (this.cOz != null) {
            this.cOz.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(ak akVar) {
        if (this.cOy != null) {
            this.cOy.setDataLoadInterface(this.cOE);
        }
        this.cOA = akVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ay(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.cth != null && bdListView != null) {
            bdListView.removeHeaderView(this.cth);
            this.cOB = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.cth != null && !this.cOB) {
            bdListView.addHeaderView(this.cth, Integer.valueOf(i), false);
            this.cOB = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, k kVar, int i) {
        boolean z;
        if (kVar != null && kVar.bvu() != null && kVar.bvu().tab != null) {
            this.cOz.setData(kVar.bvu().menu, i);
            if (kVar.aRo() != null) {
                this.cOz.setFid(kVar.aRo().getId());
            }
            this.cOD = kVar;
            c(kVar);
            this.cOC = new TabData();
            for (FrsTabInfo frsTabInfo : kVar.bvu().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                    dVar.tabId = frsTabInfo.tab_id.intValue();
                    dVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.cOC.add(dVar);
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
                            this.cOC.add(dVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.kS(frsTabInfo.tab_id.intValue())) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.cm(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cOC.add(dVar);
                                }
                            } else {
                                this.cOC.add(dVar);
                            }
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ad.amy().jY(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        ab jV = aa.amx().jV(dVar.tabId);
                        if (jV != null && jV.cKh != null && jV.cKh.size() > 0) {
                            dVar.cZu = new com.baidu.tieba.frs.av();
                            dVar.cZu.cKg = jV.cKg;
                            dVar.cZu.cKh = new LinkedList();
                            boolean z2 = true;
                            for (z zVar : jV.cKh) {
                                if (zVar != null) {
                                    au auVar = new au();
                                    auVar.name = zVar.name;
                                    auVar.cKd = zVar.cKd;
                                    if (z2) {
                                        auVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar.cZu.cKh.add(auVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.cOC.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        ab jV2 = aa.amx().jV(dVar.tabId);
                        if (jV2 != null && jV2.cKh != null && jV2.cKh.size() > 0) {
                            dVar.cZu = new com.baidu.tieba.frs.av();
                            dVar.cZu.cKg = jV2.cKg;
                            dVar.cZu.cKh = new LinkedList();
                            for (z zVar2 : jV2.cKh) {
                                if (zVar2 != null) {
                                    au auVar2 = new au();
                                    auVar2.name = zVar2.name;
                                    auVar2.cKd = zVar2.cKd;
                                    dVar.cZu.cKh.add(auVar2);
                                }
                            }
                        }
                        this.cOC.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cOx.alo().ame().l(bd.YE)) {
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
                        this.cOC.add(dVar2);
                    }
                }
            }
            this.cOy.d(this.cOC, kVar.bvo(), 12);
            if (!this.cOB) {
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
        return this.cOy;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fm(boolean z) {
        if (this.cOz != null) {
            if (z) {
                this.cOz.aoa();
            } else {
                this.cOz.aob();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData anR() {
        return this.cOC;
    }

    private void c(k kVar) {
        if (kVar == null || kVar.bvl() == null || kVar.bvl().size() == 0) {
            aa.amx().a(1, null);
            return;
        }
        List<CategoryInfo> bvl = kVar.bvl();
        ab abVar = new ab();
        abVar.cKg = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bvl.size()) {
                if (bvl.get(i2) != null) {
                    z zVar = new z();
                    zVar.cKd = bvl.get(i2).category_id.intValue();
                    zVar.name = bvl.get(i2).category_name;
                    arrayList.add(zVar);
                }
                i = i2 + 1;
            } else {
                abVar.cKh = arrayList;
                aa.amx().a(1, abVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View anS() {
        if (this.cOz == null) {
            return null;
        }
        return this.cOz.anZ();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View anT() {
        return this.cth;
    }
}
