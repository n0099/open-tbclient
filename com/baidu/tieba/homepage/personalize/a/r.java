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
public class r extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, af<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> ada;
    private boolean agw;
    public BdUniqueId ebA;
    private NEGFeedBackView.a euX;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agw = true;
        this.euX = null;
        this.ada = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.r.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.dqE != null && kVar.dqE.aLo() != null) {
                    r.this.a(kVar.dqE, view);
                    TiebaStatic.log(kVar.bFr());
                    TiebaStatic.log(kVar.bFs());
                    r.this.d(kVar.dqE, kVar.bFf());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bZK();
    }

    private void bZK() {
        com.baidu.tieba.card.data.k.gsx = "c13388";
        com.baidu.tieba.card.data.k.gsy = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebA);
        eVar.aA(false);
        eVar.aB(false);
        eVar.aX(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.r.1
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
        tVar.setFromCDN(this.agw);
        aVar.c(tVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.rB().bg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.rB().bd(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        af<com.baidu.tieba.card.data.k> afVar = new af<>(aVar.rC());
        afVar.setPageId(this.ebA);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.dqE != null && kVar.dqE.aLo() != null) {
                    r.this.a(kVar.dqE, view);
                    TiebaStatic.log(kVar.bFr());
                    TiebaStatic.log(kVar.bFs());
                    r.this.d(kVar.dqE, kVar.bFf());
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqE == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        com.baidu.card.w aF = afVar.aF(false);
        aF.bb(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47));
        aF.a(this.euX);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.ada);
        com.baidu.tieba.card.r.bEW().e(kVar.bFq());
        com.baidu.tieba.a.d.bfN().a("page_recommend", "show_", kVar.bFq());
        e(kVar.dqE, kVar.bFf());
        return afVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euX = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yf(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bj bjVar, View view) {
        if (bjVar != null && bjVar.aLo() != null) {
            String str = bjVar.aLo().id;
            String str2 = bjVar.aLo().link;
            String str3 = bjVar.aLo().h5_url;
            Long l = bjVar.aLo().swan_app_id;
            long parseLong = Long.parseLong(bjVar.getTid());
            long fid = bjVar.getFid();
            String str4 = bjVar.aLo().name;
            com.baidu.tbadk.core.sharedPref.b.aNT().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aNT().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aNT().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bjVar.aLo().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.l.BE(bjVar.getTid());
                TiebaStatic.log(new an("c13274").t("fid", fid).t("tid", parseLong).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("obj_name", str4).t("obj_id", l.longValue()).cI("obj_source", "index_card").af("obj_param1", bjVar.aLo().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bj bjVar, int i) {
        if (bjVar != null && bjVar.aLo() != null) {
            com.baidu.tieba.s.c.cVo().b(this.ebA, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bjVar.aLo().id));
        }
    }

    private void e(bj bjVar, int i) {
        if (bjVar != null && bjVar.aLo() != null) {
            String str = bjVar.aLo().id;
            com.baidu.tieba.s.c.cVo().a(this.ebA, com.baidu.tieba.s.a.a(bjVar.getTid(), "", str, null), com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
