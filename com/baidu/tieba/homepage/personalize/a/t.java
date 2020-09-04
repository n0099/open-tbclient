package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ag;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.e;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> aeV;
    private boolean ajt;
    public BdUniqueId ePz;
    private NEGFeedBackView.a flN;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajt = true;
        this.flN = null;
        this.aeV = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.l lVar, String str) {
                if (lVar != null && lVar.dUW != null && lVar.dUW.bft() != null) {
                    t.this.a(lVar.dUW, view);
                    TiebaStatic.log(lVar.ccx());
                    TiebaStatic.log(lVar.ccy());
                    t.this.e(lVar.dUW, lVar.cck());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cyl();
    }

    private void cyl() {
        com.baidu.tieba.card.data.l.hmY = "c13388";
        com.baidu.tieba.card.data.l.hmZ = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ePz);
        eVar.aE(false);
        eVar.aF(false);
        eVar.bl(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.t.1
            @Override // com.baidu.card.e.a
            public void a(AbsThreadDataSupport absThreadDataSupport, View view) {
                if (absThreadDataSupport != null) {
                    if (view.getId() == R.id.user_name) {
                        absThreadDataSupport.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        absThreadDataSupport.objType = 4;
                    } else {
                        absThreadDataSupport.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.w wVar = new com.baidu.card.w(this.mPageContext.getPageActivity());
        wVar.setFrom("index");
        wVar.setFromCDN(this.ajt);
        aVar.c(wVar);
        aVar.a((com.baidu.card.h) new ag(this.mPageContext.getPageActivity()));
        aVar.tP().bu(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.tP().br(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        al<com.baidu.tieba.card.data.l> alVar = new al<>(aVar.tQ());
        alVar.setPageId(this.ePz);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.l lVar;
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) qVar) != null && lVar.dUW != null && lVar.dUW.bft() != null) {
                    t.this.a(lVar.dUW, view);
                    TiebaStatic.log(lVar.ccx());
                    TiebaStatic.log(lVar.ccy());
                    t.this.e(lVar.dUW, lVar.cck());
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUW == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.aL(false).a(this.flN);
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeV);
        com.baidu.tieba.card.s.cbY().e(lVar.ccw());
        com.baidu.tieba.a.d.bAB().a("page_recommend", "show_", lVar.ccw());
        f(lVar.dUW, lVar.cck());
        return alVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flN = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Dk(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bw bwVar, View view) {
        if (bwVar != null && bwVar.bft() != null) {
            String str = bwVar.bft().id;
            String str2 = bwVar.bft().link;
            String str3 = bwVar.bft().h5_url;
            Long l = bwVar.bft().swan_app_id;
            long parseLong = Long.parseLong(bwVar.getTid());
            long fid = bwVar.getFid();
            String str4 = bwVar.bft().name;
            com.baidu.tbadk.core.sharedPref.b.bik().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.bik().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.bik().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bwVar.bft().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.GZ(bwVar.getTid());
                TiebaStatic.log(new aq("c13274").u("fid", fid).u("tid", parseLong).dD("uid", TbadkCoreApplication.getCurrentAccount()).dD("obj_name", str4).u("obj_id", l.longValue()).dD("obj_source", "index_card").ai("obj_param1", bwVar.bft().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bw bwVar, int i) {
        if (bwVar != null && bwVar.bft() != null) {
            com.baidu.tieba.s.c.dvJ().b(this.ePz, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bwVar.bft().id));
        }
    }

    private void f(bw bwVar, int i) {
        if (bwVar != null && bwVar.bft() != null) {
            String str = bwVar.bft().id;
            com.baidu.tieba.s.c.dvJ().a(this.ePz, com.baidu.tieba.s.a.a(bwVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
