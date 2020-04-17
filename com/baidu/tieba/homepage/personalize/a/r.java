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
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> acX;
    private boolean agt;
    public BdUniqueId ebv;
    private NEGFeedBackView.a euS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agt = true;
        this.euS = null;
        this.acX = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.r.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.dqA != null && kVar.dqA.aLq() != null) {
                    r.this.a(kVar.dqA, view);
                    TiebaStatic.log(kVar.bFt());
                    TiebaStatic.log(kVar.bFu());
                    r.this.d(kVar.dqA, kVar.bFh());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bZM();
    }

    private void bZM() {
        com.baidu.tieba.card.data.k.gsr = "c13388";
        com.baidu.tieba.card.data.k.gss = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aA */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.ebv);
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
        tVar.setFromCDN(this.agt);
        aVar.c(tVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.rB().bg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.rB().bd(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        af<com.baidu.tieba.card.data.k> afVar = new af<>(aVar.rC());
        afVar.setPageId(this.ebv);
        a(new com.baidu.adp.widget.ListView.v() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.dqA != null && kVar.dqA.aLq() != null) {
                    r.this.a(kVar.dqA, view);
                    TiebaStatic.log(kVar.bFt());
                    TiebaStatic.log(kVar.bFu());
                    r.this.d(kVar.dqA, kVar.bFh());
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.dqA == null) {
            return null;
        }
        kVar.rN(kVar.position + 1);
        com.baidu.card.w aF = afVar.aF(false);
        aF.bb(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47));
        aF.a(this.euS);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.rD().a(this.acX);
        com.baidu.tieba.card.r.bEY().e(kVar.bFs());
        com.baidu.tieba.a.d.bfP().a("page_recommend", "show_", kVar.bFs());
        e(kVar.dqA, kVar.bFh());
        return afVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euS = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void yc(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bj bjVar, View view) {
        if (bjVar != null && bjVar.aLq() != null) {
            String str = bjVar.aLq().id;
            String str2 = bjVar.aLq().link;
            String str3 = bjVar.aLq().h5_url;
            Long l = bjVar.aLq().swan_app_id;
            long parseLong = Long.parseLong(bjVar.getTid());
            long fid = bjVar.getFid();
            String str4 = bjVar.aLq().name;
            com.baidu.tbadk.core.sharedPref.b.aNV().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aNV().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bjVar.aLq().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.l.BB(bjVar.getTid());
                TiebaStatic.log(new an("c13274").t("fid", fid).t("tid", parseLong).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("obj_name", str4).t("obj_id", l.longValue()).cI("obj_source", "index_card").af("obj_param1", bjVar.aLq().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bj bjVar, int i) {
        if (bjVar != null && bjVar.aLq() != null) {
            com.baidu.tieba.s.c.cVr().b(this.ebv, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bjVar.aLq().id));
        }
    }

    private void e(bj bjVar, int i) {
        if (bjVar != null && bjVar.aLq() != null) {
            String str = bjVar.aLq().id;
            com.baidu.tieba.s.c.cVr().a(this.ebv, com.baidu.tieba.s.a.a(bjVar.getTid(), "", str, null), com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
