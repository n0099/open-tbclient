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
/* loaded from: classes21.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, am<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> afn;
    private boolean ajR;
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ajR = true;
        this.foG = null;
        this.afn = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.t.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.l lVar, String str) {
                if (lVar != null && lVar.dXg != null && lVar.dXg.bgn() != null) {
                    t.this.a(lVar.dXg, view);
                    TiebaStatic.log(lVar.cfM());
                    TiebaStatic.log(lVar.cfN());
                    t.this.e(lVar.dXg, lVar.cfz());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        czJ();
    }

    private void czJ() {
        com.baidu.tieba.card.data.l.hub = "c13388";
        com.baidu.tieba.card.data.l.huc = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.eSq);
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
        xVar.setFromCDN(this.ajR);
        aVar.c(xVar);
        aVar.a((com.baidu.card.i) new ah(this.mPageContext.getPageActivity()));
        aVar.tU().by(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.tU().bv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        am<com.baidu.tieba.card.data.l> amVar = new am<>(aVar.tV());
        amVar.setPageId(this.eSq);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.t.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.l lVar;
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (lVar = (com.baidu.tieba.card.data.l) qVar) != null && lVar.dXg != null && lVar.dXg.bgn() != null) {
                    t.this.a(lVar.dXg, view);
                    TiebaStatic.log(lVar.cfM());
                    TiebaStatic.log(lVar.cfN());
                    t.this.e(lVar.dXg, lVar.cfz());
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, am<com.baidu.tieba.card.data.l> amVar) {
        if (lVar == null || amVar == null || amVar.getView() == null || lVar.dXg == null) {
            return null;
        }
        lVar.vX(lVar.position + 1);
        amVar.aL(false).a(this.foG);
        amVar.b((am<com.baidu.tieba.card.data.l>) lVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        com.baidu.tieba.card.s.cfn().e(lVar.cfL());
        com.baidu.tieba.a.d.bBN().a("page_recommend", "show_", lVar.cfL());
        f(lVar.dXg, lVar.cfz());
        return amVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.foG = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bw bwVar, View view) {
        if (bwVar != null && bwVar.bgn() != null) {
            String str = bwVar.bgn().id;
            String str2 = bwVar.bgn().link;
            String str3 = bwVar.bgn().h5_url;
            Long l = bwVar.bgn().swan_app_id;
            long parseLong = Long.parseLong(bwVar.getTid());
            long fid = bwVar.getFid();
            String str4 = bwVar.bgn().name;
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.bjf().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.bjf().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bwVar.bgn().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.Hw(bwVar.getTid());
                TiebaStatic.log(new aq("c13274").u("fid", fid).u("tid", parseLong).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("obj_name", str4).u("obj_id", l.longValue()).dF("obj_source", "index_card").ai("obj_param1", bwVar.bgn().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bw bwVar, int i) {
        if (bwVar != null && bwVar.bgn() != null) {
            com.baidu.tieba.s.c.dzC().b(this.eSq, com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bwVar.bgn().id));
        }
    }

    private void f(bw bwVar, int i) {
        if (bwVar != null && bwVar.bgn() != null) {
            String str = bwVar.bgn().id;
            com.baidu.tieba.s.c.dzC().a(this.eSq, com.baidu.tieba.s.a.a(bwVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bwVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
