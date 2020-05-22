package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.e;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ag<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> adt;
    private boolean aha;
    private NEGFeedBackView.a eJz;
    public BdUniqueId epM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aha = true;
        this.eJz = null;
        this.adt = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.dEA != null && kVar.dEA.aRn() != null) {
                    q.this.a(kVar.dEA, view);
                    TiebaStatic.log(kVar.bLM());
                    TiebaStatic.log(kVar.bLN());
                    q.this.e(kVar.dEA, kVar.bLz());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cgg();
    }

    private void cgg() {
        com.baidu.tieba.card.data.k.gHm = "c13388";
        com.baidu.tieba.card.data.k.gHn = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aM */
    public ag<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.epM);
        eVar.aC(false);
        eVar.aD(false);
        eVar.aY(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.q.1
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
        com.baidu.card.u uVar = new com.baidu.card.u(this.mPageContext.getPageActivity());
        uVar.setFrom("index");
        uVar.setFromCDN(this.aha);
        aVar.c(uVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.ab(this.mPageContext.getPageActivity()));
        aVar.rK().bh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.rK().be(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        ag<com.baidu.tieba.card.data.k> agVar = new ag<>(aVar.rL());
        agVar.setPageId(this.epM);
        a(new com.baidu.adp.widget.ListView.x() { // from class: com.baidu.tieba.homepage.personalize.a.q.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, com.baidu.adp.widget.ListView.o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((oVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) oVar) != null && kVar.dEA != null && kVar.dEA.aRn() != null) {
                    q.this.a(kVar.dEA, view);
                    TiebaStatic.log(kVar.bLM());
                    TiebaStatic.log(kVar.bLN());
                    q.this.e(kVar.dEA, kVar.bLz());
                }
            }
        });
        return agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ag<com.baidu.tieba.card.data.k> agVar) {
        if (kVar == null || agVar == null || agVar.getView() == null || kVar.dEA == null) {
            return null;
        }
        kVar.sr(kVar.position + 1);
        agVar.aH(false).a(this.eJz);
        agVar.b((ag<com.baidu.tieba.card.data.k>) kVar);
        agVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        agVar.rM().a(this.adt);
        com.baidu.tieba.card.s.bLq().e(kVar.bLL());
        com.baidu.tieba.a.d.blZ().a("page_recommend", "show_", kVar.bLL());
        f(kVar.dEA, kVar.bLz());
        return agVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJz = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void zL(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bk bkVar, View view) {
        if (bkVar != null && bkVar.aRn() != null) {
            String str = bkVar.aRn().id;
            String str2 = bkVar.aRn().link;
            String str3 = bkVar.aRn().h5_url;
            Long l = bkVar.aRn().swan_app_id;
            long parseLong = Long.parseLong(bkVar.getTid());
            long fid = bkVar.getFid();
            String str4 = bkVar.aRn().name;
            com.baidu.tbadk.core.sharedPref.b.aTX().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aTX().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bkVar.aRn().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.Dn(bkVar.getTid());
                TiebaStatic.log(new an("c13274").s("fid", fid).s("tid", parseLong).dh("uid", TbadkCoreApplication.getCurrentAccount()).dh("obj_name", str4).s("obj_id", l.longValue()).dh("obj_source", "index_card").ag("obj_param1", bkVar.aRn().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bk bkVar, int i) {
        if (bkVar != null && bkVar.aRn() != null) {
            com.baidu.tieba.s.c.dct().b(this.epM, com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bkVar.aRn().id));
        }
    }

    private void f(bk bkVar, int i) {
        if (bkVar != null && bkVar.aRn() != null) {
            String str = bkVar.aRn().id;
            com.baidu.tieba.s.c.dct().a(this.epM, com.baidu.tieba.s.a.a(bkVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bkVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
