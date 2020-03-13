package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.e;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class p extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private boolean NJ;
    public BdUniqueId dBx;
    private NEGFeedBackView.a dUD;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.NJ = true;
        this.dUD = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.p.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.cRg != null && kVar.cRg.aDa() != null) {
                    p.this.a(kVar.cRg, view);
                    TiebaStatic.log(kVar.bvD());
                    TiebaStatic.log(kVar.bvE());
                    p.this.d(kVar.cRg, kVar.bvr());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bOX();
    }

    private void bOX() {
        com.baidu.tieba.card.data.k.fNc = "c13388";
        com.baidu.tieba.card.data.k.fNd = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBx);
        eVar.ab(false);
        eVar.ac(false);
        eVar.aL(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.p.1
            @Override // com.baidu.card.e.a
            public void a(com.baidu.tbadk.core.data.a aVar2, View view) {
                if (aVar2 != null) {
                    if (view.getId() == R.id.user_name) {
                        aVar2.objType = 3;
                    } else if (view.getId() == R.id.user_avatar) {
                        aVar2.objType = 4;
                    } else {
                        aVar2.objType = 1;
                    }
                }
            }
        });
        aVar.a(eVar);
        com.baidu.card.t tVar = new com.baidu.card.t(this.mPageContext.getPageActivity());
        tVar.setFrom("index");
        tVar.setFromCDN(this.NJ);
        aVar.c(tVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.ni().aU(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        af<com.baidu.tieba.card.data.k> afVar = new af<>(aVar.nj());
        afVar.setPageId(this.dBx);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.p.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.cRg != null && kVar.cRg.aDa() != null) {
                    p.this.a(kVar.cRg, view);
                    TiebaStatic.log(kVar.bvD());
                    TiebaStatic.log(kVar.bvE());
                    p.this.d(kVar.cRg, kVar.bvr());
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRg == null) {
            return null;
        }
        kVar.rt(kVar.position + 1);
        com.baidu.card.w ag = afVar.ag(false);
        ag.aP(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47));
        ag.a(this.dUD);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.card.r.bvh().d(kVar.bvC());
        com.baidu.tieba.a.d.aXG().a("page_recommend", "show_", kVar.bvC());
        e(kVar.cRg, kVar.bvr());
        return afVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUD = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bj bjVar, View view) {
        if (bjVar != null && bjVar.aDa() != null) {
            String str = bjVar.aDa().id;
            String str2 = bjVar.aDa().link;
            String str3 = bjVar.aDa().h5_url;
            Long l = bjVar.aDa().swan_app_id;
            long parseLong = Long.parseLong(bjVar.getTid());
            long fid = bjVar.getFid();
            String str4 = bjVar.aDa().name;
            com.baidu.tbadk.core.sharedPref.b.aFD().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aFD().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bjVar.aDa().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.l.zT(bjVar.getTid());
                TiebaStatic.log(new an("c13274").s("fid", fid).s("tid", parseLong).cy("uid", TbadkCoreApplication.getCurrentAccount()).cy("obj_name", str4).s("obj_id", l.longValue()).cy("obj_source", "index_card").X("obj_param1", bjVar.aDa().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bj bjVar, int i) {
        if (bjVar != null && bjVar.aDa() != null) {
            com.baidu.tieba.s.c.cKb().b(this.dBx, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bjVar.aDa().id));
        }
    }

    private void e(bj bjVar, int i) {
        if (bjVar != null && bjVar.aDa() != null) {
            String str = bjVar.aDa().id;
            com.baidu.tieba.s.c.cKb().a(this.dBx, com.baidu.tieba.s.a.a(bjVar.getTid(), "", str, null), com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
