package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ah;
import com.baidu.card.ak;
import com.baidu.card.am;
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
/* loaded from: classes22.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afE;
    private boolean akj;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akj = true;
        this.fAU = null;
        this.afE = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.l lVar, String str) {
                if (lVar != null && lVar.eji != null && lVar.eji.biW() != null) {
                    t.this.a(lVar.eji, view);
                    TiebaStatic.log(lVar.cji());
                    TiebaStatic.log(lVar.cjj());
                    t.this.e(lVar.eji, lVar.ciV());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cDn();
    }

    private void cDn() {
        com.baidu.tieba.card.data.l.hIW = "c13388";
        com.baidu.tieba.card.data.l.hIX = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fey);
        eVar.aE(false);
        eVar.aF(false);
        eVar.bp(1024);
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
        com.baidu.card.x xVar = new com.baidu.card.x(this.mPageContext.getPageActivity());
        xVar.setFrom("index");
        xVar.setFromCDN(this.akj);
        aVar.c(xVar);
        aVar.a((com.baidu.card.i) new ah(this.mPageContext.getPageActivity()));
        aVar.tU().by(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        am<com.baidu.tieba.card.data.l> amVar = new am<>(aVar.tV());
        amVar.setPageId(this.fey);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.l lVar;
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) qVar) != null && lVar.eji != null && lVar.eji.biW() != null) {
                    t.this.a(lVar.eji, view);
                    TiebaStatic.log(lVar.cji());
                    TiebaStatic.log(lVar.cjj());
                    t.this.e(lVar.eji, lVar.ciV());
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.eji == null) {
            return null;
        }
        lVar.wD(lVar.position + 1);
        amVar.aL(false).a(this.fAU);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afE);
        com.baidu.tieba.card.s.ciJ().e(lVar.cjh());
        com.baidu.tieba.a.d.bEz().a("page_recommend", "show_", lVar.cjh());
        f(lVar.eji, lVar.ciV());
        return amVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fAU = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bw bwVar, View view) {
        if (bwVar != null && bwVar.biW() != null) {
            String str = bwVar.biW().id;
            String str2 = bwVar.biW().link;
            String str3 = bwVar.biW().h5_url;
            Long l = bwVar.biW().swan_app_id;
            long parseLong = Long.parseLong(bwVar.getTid());
            long fid = bwVar.getFid();
            String str4 = bwVar.biW().name;
            com.baidu.tbadk.core.sharedPref.b.blO().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.blO().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.blO().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bwVar.biW().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.Ij(bwVar.getTid());
                TiebaStatic.log(new aq("c13274").u("fid", fid).u("tid", parseLong).dK("uid", TbadkCoreApplication.getCurrentAccount()).dK("obj_name", str4).u("obj_id", l.longValue()).dK("obj_source", "index_card").aj("obj_param1", bwVar.biW().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bw bwVar, int i) {
        if (bwVar != null && bwVar.biW() != null) {
            com.baidu.tieba.s.c.dDn().b(this.fey, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bwVar.biW().id));
        }
    }

    private void f(bw bwVar, int i) {
        if (bwVar != null && bwVar.biW() != null) {
            String str = bwVar.biW().id;
            com.baidu.tieba.s.c.dDn().a(this.fey, com.baidu.tieba.s.a.a(bwVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
