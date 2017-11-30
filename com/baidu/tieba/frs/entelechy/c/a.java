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
    private f cOm;
    private HorizontalTabView cOn;
    private com.baidu.tieba.frs.entelechy.c.a.a cOo;
    private aj cOp;
    private TabData cOr;
    private k cOs;
    private RelativeLayout csY;
    private boolean cOq = false;
    private int liveCount = -1;
    private aj cOt = new aj() { // from class: com.baidu.tieba.frs.entelechy.c.a.1
        @Override // com.baidu.tieba.frs.aj
        public void a(al alVar) {
        }

        @Override // com.baidu.tieba.frs.aj
        public void a(int i, int i2, ao aoVar) {
            if (i == 101) {
                TiebaStatic.log(new ak("c12103").ac(ImageViewerConfig.FORUM_ID, a.this.cOm.getForumId()));
            }
            if (i > 100) {
                if (aoVar != null && (aoVar.cKn instanceof String)) {
                    a.this.aV((String) aoVar.cKn, "c10079");
                }
            } else {
                ak akVar = new ak("c10074");
                akVar.r("obj_type", i);
                akVar.ac(ImageViewerConfig.FORUM_ID, a.this.cOm.getForumId());
                TiebaStatic.log(akVar);
            }
            if (i == 201 || i == 202) {
                ak akVar2 = new ak("c11500");
                akVar2.ac("obj_param1", i == 201 ? "2" : "1").ac("obj_param2", "1");
                TiebaStatic.log(akVar2);
            }
            if (HorizontalTabView.kQ(i) && aoVar != null) {
                String str = (String) aoVar.cKn;
                if (!StringUtils.isNull(str)) {
                    if ((str.contains("nohead:url") || str.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                        l.showToast(a.this.cOm.getPageContext().getPageActivity(), d.j.book_plugin_not_install_tip);
                    } else {
                        av.vL().c(a.this.cOm.getPageContext(), new String[]{str});
                    }
                }
            } else if (i == 301) {
                if (a.this.cOm != null && a.this.cOm.getPageContext() != null && a.this.cOm.getPageContext().getPageActivity() != null) {
                    a.this.cOm.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY, new FrsGoodActivityConfig(a.this.cOm.getPageContext().getPageActivity()).createNormalCfg(a.this.cOm.cGT, FrsActivityConfig.FRS_FROM_LIKE)));
                }
            } else {
                if (i == 49) {
                    if (a.this.cOm != null && a.this.cOm.getPageContext() != null && a.this.cOm.getPageContext().getPageActivity() != null && !TextUtils.isEmpty(a.this.cOm.alv().aRf().getForumGameLabel())) {
                        if (aoVar != null) {
                            aoVar.cKo = true;
                        }
                        a.this.cOm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGameFrsLiveListActivityConfig(a.this.cOm.getPageContext().getPageActivity(), a.this.cOm.getForumId(), a.this.cOm.getForumName(), a.this.cOm.alv().aRf().getForumGameLabel())));
                        return;
                    }
                } else if (i == 302) {
                    if (a.this.cOm != null && a.this.cOm.getPageContext() != null && a.this.cOm.getPageContext().getPageActivity() != null) {
                        TiebaStatic.log("c12410");
                        a.this.cOm.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoAggregationActivityConfig(a.this.cOm.getPageContext().getPageActivity(), a.this.cOm.forumId, VideoAggregationActivityConfig.TYPE_FROM_FRS, "", "")));
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    a.this.cOo.anR();
                } else {
                    a.this.cOo.anS();
                }
                if (a.this.cOp != null) {
                    a.this.cOp.a(i, i2, aoVar);
                }
            }
        }

        @Override // com.baidu.tieba.frs.aj
        public void init() {
        }

        @Override // com.baidu.tieba.frs.aj
        public void QJ() {
        }
    };
    private HorizontalTabView.c cOu = new HorizontalTabView.c() { // from class: com.baidu.tieba.frs.entelechy.c.a.2
        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public void kg(int i) {
            a.this.cOm.ale().jQ(i);
        }

        @Override // com.baidu.tieba.frs.tab.HorizontalTabView.c
        public boolean kh(int i) {
            return (a.this.cOm != null && a.this.cOm.alw() && i == 1) ? false : true;
        }
    };

    public void kf(int i) {
        this.liveCount = i;
    }

    public a(f fVar) {
        this.cOn = null;
        this.cOm = fVar;
        int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds104);
        this.csY = new RelativeLayout(fVar.getActivity());
        com.baidu.tbadk.core.util.aj.k(this.csY, d.C0082d.cp_bg_line_d);
        this.csY.setLayoutParams(new AbsListView.LayoutParams(-1, dimensionPixelSize));
        this.cOn = new HorizontalTabView(fVar.getPageContext());
        this.cOn.setForNewFrame(true);
        this.cOn.cYN = l.f(fVar.getActivity(), d.e.ds20);
        this.cOn.setAutoFillTabCount(4);
        this.cOn.setmShowMenuCallBack(this.cOu);
        this.cOn.setTabBackgroudColor(d.C0082d.cp_bg_line_d);
        this.cOn.setLayoutParams(new RelativeLayout.LayoutParams(-1, dimensionPixelSize));
        this.csY.addView(this.cOn);
        this.cOn.setOnTabItemClickListener(new HorizontalTabView.a() { // from class: com.baidu.tieba.frs.entelechy.c.a.3
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.a
            public void a(com.baidu.tieba.frs.tab.d dVar) {
                if (a.this.cOs != null && a.this.cOs.aRf() != null) {
                    TiebaStatic.log(new ak("c12047").ac(ImageViewerConfig.FORUM_ID, a.this.cOs.aRf().getId()));
                }
            }
        });
        this.cOn.setOnTabItemSelectListener(new HorizontalTabView.b() { // from class: com.baidu.tieba.frs.entelechy.c.a.4
            @Override // com.baidu.tieba.frs.tab.HorizontalTabView.b
            public void b(com.baidu.tieba.frs.tab.d dVar) {
                if (dVar != null && a.this.cOm != null) {
                    a.this.cOm.cM(dVar.tabId == 49);
                }
            }
        });
        this.cOo = new com.baidu.tieba.frs.entelechy.c.a.a(this.cOm, this.csY);
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(AbsListView absListView, int i, int i2, int i3, int i4) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void onChangeSkinType(int i) {
        if (this.csY != null) {
            com.baidu.tbadk.core.util.aj.k(this.csY, d.C0082d.cp_bg_line_d);
        }
        if (this.cOn != null) {
            this.cOn.wE();
        }
        if (this.cOo != null) {
            this.cOo.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(aj ajVar) {
        if (this.cOn != null) {
            this.cOn.setDataLoadInterface(this.cOt);
        }
        this.cOp = ajVar;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void ax(View view) {
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void b(BdListView bdListView) {
        if (this.csY != null && bdListView != null) {
            bdListView.removeHeaderView(this.csY);
            this.cOq = false;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, int i) {
        if (this.csY != null && !this.cOq) {
            bdListView.addHeaderView(this.csY, Integer.valueOf(i), false);
            this.cOq = true;
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void a(BdListView bdListView, k kVar, int i) {
        boolean z;
        if (kVar != null && kVar.buN() != null && kVar.buN().tab != null) {
            this.cOo.setData(kVar.buN().menu, i);
            if (kVar.aRf() != null) {
                this.cOo.setFid(kVar.aRf().getId());
            }
            this.cOs = kVar;
            b(kVar);
            this.cOr = new TabData();
            for (FrsTabInfo frsTabInfo : kVar.buN().tab) {
                if (!a(frsTabInfo) && !b(frsTabInfo)) {
                    com.baidu.tieba.frs.tab.d dVar = new com.baidu.tieba.frs.tab.d();
                    dVar.tabId = frsTabInfo.tab_id.intValue();
                    dVar.name = frsTabInfo.tab_name;
                    if (frsTabInfo.tab_type.intValue() == 12) {
                        this.cOr.add(dVar);
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
                            sb.append(kVar.aRf().getId());
                            dVar.url = sb.toString();
                            aV(dVar.url, "c10078");
                            this.cOr.add(dVar);
                        }
                    } else if (frsTabInfo.tab_type.intValue() == 11 && HorizontalTabView.kQ(frsTabInfo.tab_id.intValue())) {
                        if (!TextUtils.isEmpty(frsTabInfo.tab_url)) {
                            dVar.url = frsTabInfo.tab_url;
                            if (com.baidu.tbadk.browser.d.cm(dVar.url)) {
                                if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_LEGO_LIST) != null) {
                                    this.cOr.add(dVar);
                                }
                            } else {
                                this.cOr.add(dVar);
                            }
                        }
                    } else if (frsTabInfo.tab_id.intValue() != 1 && ac.amp().jW(frsTabInfo.tab_id.intValue()) && frsTabInfo.tab_id.intValue() != 49) {
                        aa jT = z.amo().jT(dVar.tabId);
                        if (jT != null && jT.cJX != null && jT.cJX.size() > 0) {
                            dVar.cZi = new au();
                            dVar.cZi.cJW = jT.cJW;
                            dVar.cZi.cJX = new LinkedList();
                            boolean z2 = true;
                            for (y yVar : jT.cJX) {
                                if (yVar != null) {
                                    at atVar = new at();
                                    atVar.name = yVar.name;
                                    atVar.cJT = yVar.cJT;
                                    if (z2) {
                                        atVar.isSelected = true;
                                        z = false;
                                    } else {
                                        z = z2;
                                    }
                                    dVar.cZi.cJX.add(atVar);
                                    z2 = z;
                                }
                            }
                        }
                        this.cOr.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 1) {
                        aa jT2 = z.amo().jT(dVar.tabId);
                        if (jT2 != null && jT2.cJX != null && jT2.cJX.size() > 0) {
                            dVar.cZi = new au();
                            dVar.cZi.cJW = jT2.cJW;
                            dVar.cZi.cJX = new LinkedList();
                            for (y yVar2 : jT2.cJX) {
                                if (yVar2 != null) {
                                    at atVar2 = new at();
                                    atVar2.name = yVar2.name;
                                    atVar2.cJT = yVar2.cJT;
                                    dVar.cZi.cJX.add(atVar2);
                                }
                            }
                        }
                        this.cOr.add(dVar);
                    } else if (frsTabInfo.tab_id.intValue() == 49 && this.cOm.ale().alV().l(bd.YK)) {
                        com.baidu.tieba.frs.tab.d dVar2 = new com.baidu.tieba.frs.tab.d();
                        dVar2.name = frsTabInfo.tab_name;
                        if (kVar.bul() != 0 && kVar.bul() <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + kVar.bul() + ")";
                        }
                        if (this.liveCount > 0 && this.liveCount != kVar.bul() && this.liveCount <= 99) {
                            dVar2.name = frsTabInfo.tab_name + "(" + this.liveCount + ")";
                        } else if (this.liveCount > 99 || kVar.bul() > 99) {
                            dVar2.name = frsTabInfo.tab_name + "(99+)";
                        } else if (this.liveCount == 0 && this.liveCount != kVar.bul()) {
                            dVar2.name = frsTabInfo.tab_name;
                        }
                        dVar2.tabId = frsTabInfo.tab_id.intValue();
                        this.cOr.add(dVar2);
                    }
                }
            }
            this.cOn.d(this.cOr, kVar.buH(), 12);
            if (!this.cOq) {
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
                    return frsTabInfo.tab_type.intValue() == 11 && !HorizontalTabView.kQ(frsTabInfo.tab_id.intValue());
                }
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(String str, String str2) {
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

    public HorizontalTabView anP() {
        return this.cOn;
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public void fl(boolean z) {
        if (this.cOo != null) {
            if (z) {
                this.cOo.anR();
            } else {
                this.cOo.anS();
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public TabData anI() {
        return this.cOr;
    }

    private void b(k kVar) {
        if (kVar == null || kVar.buE() == null || kVar.buE().size() == 0) {
            z.amo().a(1, null);
            return;
        }
        List<CategoryInfo> buE = kVar.buE();
        aa aaVar = new aa();
        aaVar.cJW = 1;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < buE.size()) {
                if (buE.get(i2) != null) {
                    y yVar = new y();
                    yVar.cJT = buE.get(i2).category_id.intValue();
                    yVar.name = buE.get(i2).category_name;
                    arrayList.add(yVar);
                }
                i = i2 + 1;
            } else {
                aaVar.cJX = arrayList;
                z.amo().a(1, aaVar);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View anJ() {
        if (this.cOo == null) {
            return null;
        }
        return this.cOo.anQ();
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public View anK() {
        return this.csY;
    }
}
