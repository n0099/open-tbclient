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
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes21.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, am<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> afK;
    private boolean akn;
    private NEGFeedBackView.a fOM;
    public BdUniqueId fsa;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public u(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akn = true;
        this.fOM = null;
        this.afK = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.u.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.evQ != null && kVar.evQ.bmr() != null) {
                    u.this.a(kVar.evQ, view);
                    TiebaStatic.log(kVar.com());
                    TiebaStatic.log(kVar.col());
                    u.this.e(kVar.evQ, kVar.cof());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cIA();
    }

    private void cIA() {
        com.baidu.tieba.card.data.k.ici = "c13388";
        com.baidu.tieba.card.data.k.icj = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am<com.baidu.tieba.card.data.k> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.fsa);
        eVar.aE(false);
        eVar.aF(false);
        eVar.bp(1024);
        eVar.a(new e.a() { // from class: com.baidu.tieba.homepage.personalize.a.u.1
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
        com.baidu.card.x xVar = new com.baidu.card.x(this.mPageContext.getPageActivity());
        xVar.setFrom("index");
        xVar.setFromCDN(this.akn);
        aVar.c(xVar);
        aVar.b(new ah(this.mPageContext.getPageActivity()));
        am<com.baidu.tieba.card.data.k> amVar = new am<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup));
        amVar.setPageId(this.fsa);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.u.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((qVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) qVar) != null && kVar.evQ != null && kVar.evQ.bmr() != null) {
                    u.this.a(kVar.evQ, view);
                    TiebaStatic.log(kVar.com());
                    TiebaStatic.log(kVar.col());
                    u.this.e(kVar.evQ, kVar.cof());
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, am<com.baidu.tieba.card.data.k> amVar) {
        if (kVar == null || amVar == null || amVar.getView() == null || kVar.evQ == null) {
            return null;
        }
        kVar.xH(kVar.position + 1);
        amVar.aN(false).a(this.fOM);
        amVar.b((am<com.baidu.tieba.card.data.k>) kVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afK);
        com.baidu.tieba.card.t.cnT().e(kVar.coo());
        com.baidu.tieba.a.d.bIl().a("page_recommend", "show_", kVar.coo());
        f(kVar.evQ, kVar.cof());
        return amVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EA(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bx bxVar, View view) {
        if (bxVar != null && bxVar.bmr() != null) {
            String str = bxVar.bmr().id;
            String str2 = bxVar.bmr().link;
            String str3 = bxVar.bmr().h5_url;
            Long l = bxVar.bmr().swan_app_id;
            long parseLong = Long.parseLong(bxVar.getTid());
            long fid = bxVar.getFid();
            String str4 = bxVar.bmr().name;
            com.baidu.tbadk.core.sharedPref.b.bpu().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.bpu().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.bpu().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bxVar.bmr().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.IA(bxVar.getTid());
                TiebaStatic.log(new ar("c13274").w("fid", fid).w("tid", parseLong).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", str4).w("obj_id", l.longValue()).dR("obj_source", "index_card").ak("obj_param1", bxVar.bmr().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bx bxVar, int i) {
        if (bxVar != null && bxVar.bmr() != null) {
            com.baidu.tieba.t.c.dIO().b(this.fsa, com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bxVar.bmr().id));
        }
    }

    private void f(bx bxVar, int i) {
        if (bxVar != null && bxVar.bmr() != null) {
            String str = bxVar.bmr().id;
            com.baidu.tieba.t.c.dIO().a(this.fsa, com.baidu.tieba.t.a.a(bxVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.t.a.a(bxVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
