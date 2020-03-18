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
    private com.baidu.tieba.card.z<com.baidu.tieba.card.data.k> JZ;
    private boolean NK;
    public BdUniqueId dBK;
    private NEGFeedBackView.a dUT;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.NK = true;
        this.dUT = null;
        this.JZ = new com.baidu.tieba.card.z<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.r.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.cRt != null && kVar.cRt.aDd() != null) {
                    r.this.a(kVar.cRt, view);
                    TiebaStatic.log(kVar.bvI());
                    TiebaStatic.log(kVar.bvJ());
                    r.this.d(kVar.cRt, kVar.bvw());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        bPl();
    }

    private void bPl() {
        com.baidu.tieba.card.data.k.fNK = "c13388";
        com.baidu.tieba.card.data.k.fNL = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public af<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity());
        com.baidu.card.e eVar = new com.baidu.card.e(this.mPageContext.getPageActivity());
        eVar.setPageUniqueId(this.dBK);
        eVar.ab(false);
        eVar.ac(false);
        eVar.aL(1024);
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
        tVar.setFromCDN(this.NK);
        aVar.c(tVar);
        aVar.a((com.baidu.card.h) new com.baidu.card.aa(this.mPageContext.getPageActivity()));
        aVar.ni().aU(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds62));
        aVar.ni().aR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds27));
        af<com.baidu.tieba.card.data.k> afVar = new af<>(aVar.nj());
        afVar.setPageId(this.dBK);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.r.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.cRt != null && kVar.cRt.aDd() != null) {
                    r.this.a(kVar.cRt, view);
                    TiebaStatic.log(kVar.bvI());
                    TiebaStatic.log(kVar.bvJ());
                    r.this.d(kVar.cRt, kVar.bvw());
                }
            }
        });
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, af<com.baidu.tieba.card.data.k> afVar) {
        if (kVar == null || afVar == null || afVar.getView() == null || kVar.cRt == null) {
            return null;
        }
        kVar.rv(kVar.position + 1);
        com.baidu.card.w ag = afVar.ag(false);
        ag.aP(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds47));
        ag.a(this.dUT);
        afVar.b((af<com.baidu.tieba.card.data.k>) kVar);
        afVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        afVar.nk().a(this.JZ);
        com.baidu.tieba.card.r.bvm().e(kVar.bvH());
        com.baidu.tieba.a.d.aXK().a("page_recommend", "show_", kVar.bvH());
        e(kVar.cRt, kVar.bvw());
        return afVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUT = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wP(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bj bjVar, View view) {
        if (bjVar != null && bjVar.aDd() != null) {
            String str = bjVar.aDd().id;
            String str2 = bjVar.aDd().link;
            String str3 = bjVar.aDd().h5_url;
            Long l = bjVar.aDd().swan_app_id;
            long parseLong = Long.parseLong(bjVar.getTid());
            long fid = bjVar.getFid();
            String str4 = bjVar.aDd().name;
            com.baidu.tbadk.core.sharedPref.b.aFH().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.aFH().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.aFH().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bjVar.aDd().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.l.zU(bjVar.getTid());
                TiebaStatic.log(new an("c13274").s("fid", fid).s("tid", parseLong).cx("uid", TbadkCoreApplication.getCurrentAccount()).cx("obj_name", str4).s("obj_id", l.longValue()).cx("obj_source", "index_card").X("obj_param1", bjVar.aDd().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bj bjVar, int i) {
        if (bjVar != null && bjVar.aDd() != null) {
            com.baidu.tieba.s.c.cKv().b(this.dBK, com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bjVar.aDd().id));
        }
    }

    private void e(bj bjVar, int i) {
        if (bjVar != null && bjVar.aDd() != null) {
            String str = bjVar.aDd().id;
            com.baidu.tieba.s.c.cKv().a(this.dBK, com.baidu.tieba.s.a.a(bjVar.getTid(), "", str, null), com.baidu.tieba.s.a.a(bjVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
