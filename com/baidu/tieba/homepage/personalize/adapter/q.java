package com.baidu.tieba.homepage.personalize.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.ah;
import com.baidu.card.ak;
import com.baidu.card.d;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k> agg;
    private boolean akO;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdO;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.akO = true;
        this.gdO = null;
        this.agg = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.eJQ != null && kVar.eJQ.boE() != null) {
                    q.this.a(kVar.eJQ, view);
                    TiebaStatic.log(kVar.csO());
                    TiebaStatic.log(kVar.csN());
                    q.this.e(kVar.eJQ, kVar.csH());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cPb();
    }

    private void cPb() {
        com.baidu.tieba.card.data.k.iAF = "c13388";
        com.baidu.tieba.card.data.k.iAG = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fGZ);
        dVar.aC(false);
        dVar.aD(false);
        dVar.br(1024);
        dVar.a(new d.a() { // from class: com.baidu.tieba.homepage.personalize.adapter.q.1
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
        aVar.a(dVar);
        com.baidu.card.x xVar = new com.baidu.card.x(this.mPageContext.getPageActivity());
        xVar.setFrom("index");
        xVar.setFromCDN(this.akO);
        aVar.c(xVar);
        aVar.b(new ah(this.mPageContext.getPageActivity()));
        ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder = new ThreadCardViewHolder<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup));
        threadCardViewHolder.setPageId(this.fGZ);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.q.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) nVar) != null && kVar.eJQ != null && kVar.eJQ.boE() != null) {
                    q.this.a(kVar.eJQ, view);
                    TiebaStatic.log(kVar.csO());
                    TiebaStatic.log(kVar.csN());
                    q.this.e(kVar.eJQ, kVar.csH());
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eJQ == null) {
            return null;
        }
        kVar.xd(kVar.position + 1);
        threadCardViewHolder.aK(false).a(this.gdO);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.tj().a(this.agg);
        com.baidu.tieba.card.t.csu().e(kVar.csQ());
        com.baidu.tieba.a.d.bKP().a("page_recommend", "show_", kVar.csQ());
        f(kVar.eJQ, kVar.csH());
        return threadCardViewHolder.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gdO = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cb cbVar, View view) {
        if (cbVar != null && cbVar.boE() != null) {
            String str = cbVar.boE().id;
            String str2 = cbVar.boE().link;
            String str3 = cbVar.boE().h5_url;
            Long l = cbVar.boE().swan_app_id;
            long parseLong = Long.parseLong(cbVar.getTid());
            long fid = cbVar.getFid();
            String str4 = cbVar.boE().name;
            com.baidu.tbadk.core.sharedPref.b.brQ().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.brQ().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", cbVar.boE().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.IM(cbVar.getTid());
                TiebaStatic.log(new ar("c13274").v("fid", fid).v("tid", parseLong).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("obj_name", str4).v("obj_id", l.longValue()).dR("obj_source", "index_card").ap("obj_param1", cbVar.boE().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(cb cbVar, int i) {
        if (cbVar != null && cbVar.boE() != null) {
            com.baidu.tieba.s.c.dMr().b(this.fGZ, com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, cbVar.boE().id));
        }
    }

    private void f(cb cbVar, int i) {
        if (cbVar != null && cbVar.boE() != null) {
            String str = cbVar.boE().id;
            com.baidu.tieba.s.c.dMr().a(this.fGZ, com.baidu.tieba.s.a.a(cbVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(cbVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
