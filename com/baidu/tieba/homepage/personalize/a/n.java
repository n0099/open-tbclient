package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.d;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, z<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.k> EP;
    private boolean Hx;
    public BdUniqueId cJo;
    private NEGFeedBackView.a dcg;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Hx = true;
        this.dcg = null;
        this.EP = new ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.a.n.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.caz != null && kVar.caz.ajq() != null) {
                    n.this.a(kVar.caz, view);
                    TiebaStatic.log(kVar.baQ());
                    TiebaStatic.log(kVar.baR());
                    n.this.d(kVar.caz, kVar.baE());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        buW();
    }

    private void buW() {
        com.baidu.tieba.card.data.k.ePr = "c13388";
        com.baidu.tieba.card.data.k.ePs = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public z<com.baidu.tieba.card.data.k> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.cJo);
        dVar.T(false);
        dVar.U(false);
        dVar.V(false);
        dVar.aC(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.a.n.1
            @Override // com.baidu.card.d.a
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
        aVar.c(dVar);
        com.baidu.card.p pVar = new com.baidu.card.p(this.mPageContext.getPageActivity());
        pVar.setFrom("index");
        pVar.setFromCDN(this.Hx);
        aVar.b(pVar);
        aVar.a((com.baidu.card.f) new com.baidu.card.u(this.mPageContext.getPageActivity()));
        z<com.baidu.tieba.card.data.k> zVar = new z<>(aVar.lU());
        zVar.setPageId(this.cJo);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.personalize.a.n.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((mVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) mVar) != null && kVar.caz != null && kVar.caz.ajq() != null) {
                    n.this.a(kVar.caz, view);
                    TiebaStatic.log(kVar.baQ());
                    TiebaStatic.log(kVar.baR());
                    n.this.d(kVar.caz, kVar.baE());
                }
            }
        });
        return zVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, z<com.baidu.tieba.card.data.k> zVar) {
        if (kVar == null || zVar == null || zVar.getView() == null || kVar.caz == null) {
            return null;
        }
        kVar.oO(kVar.position + 1);
        zVar.lW().a(this.dcg);
        zVar.a(kVar);
        zVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        zVar.lV().b(this.EP);
        com.baidu.tieba.card.t.bau().c(kVar.baP());
        com.baidu.tieba.a.d.aDc().a("page_recommend", "show_", kVar.baP());
        e(kVar.caz, kVar.baE());
        return zVar.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcg = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bh bhVar, View view) {
        if (bhVar != null && bhVar.ajq() != null) {
            String str = bhVar.ajq().id;
            String str2 = bhVar.ajq().link;
            String str3 = bhVar.ajq().h5_url;
            Long l = bhVar.ajq().swan_app_id;
            long parseLong = Long.parseLong(bhVar.getTid());
            long fid = bhVar.getFid();
            String str4 = bhVar.ajq().name;
            com.baidu.tbadk.core.sharedPref.b.alP().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.alP().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.alP().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bhVar.ajq().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.n.uz(bhVar.getTid());
                TiebaStatic.log(new an("c13274").p("fid", fid).p("tid", parseLong).bS("uid", TbadkCoreApplication.getCurrentAccount()).bS("obj_name", str4).p("obj_id", l.longValue()).bS("obj_source", "index_card").O("obj_param1", bhVar.ajq().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(bh bhVar, int i) {
        if (bhVar != null && bhVar.ajq() != null) {
            com.baidu.tieba.q.c.cni().b(this.cJo, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bhVar.ajq().id));
        }
    }

    private void e(bh bhVar, int i) {
        if (bhVar != null && bhVar.ajq() != null) {
            String str = bhVar.ajq().id;
            com.baidu.tieba.q.c.cni().a(this.cJo, str, com.baidu.tieba.q.a.a(bhVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
