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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class q extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.k, ThreadCardViewHolder<com.baidu.tieba.card.data.k>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k> ahf;
    private boolean alQ;
    public BdUniqueId fJu;
    private NEGFeedBackView.a ggi;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.alQ = true;
        this.ggi = null;
        this.ahf = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.k>() { // from class: com.baidu.tieba.homepage.personalize.adapter.q.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public boolean a(View view, com.baidu.tieba.card.data.k kVar, String str) {
                if (kVar != null && kVar.eMv != null && kVar.eMv.bsg() != null) {
                    q.this.a(kVar.eMv, view);
                    TiebaStatic.log(kVar.cvu());
                    TiebaStatic.log(kVar.cvt());
                    q.this.e(kVar.eMv, kVar.cvn());
                    return true;
                }
                return false;
            }
        };
        this.mPageContext = tbPageContext;
        cQX();
    }

    private void cQX() {
        com.baidu.tieba.card.data.k.izC = "c13388";
        com.baidu.tieba.card.data.k.izD = "c13389";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bd */
    public ThreadCardViewHolder<com.baidu.tieba.card.data.k> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity());
        com.baidu.card.d dVar = new com.baidu.card.d(this.mPageContext.getPageActivity());
        dVar.setPageUniqueId(this.fJu);
        dVar.aC(false);
        dVar.aD(false);
        dVar.bt(1024);
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
        xVar.setFromCDN(this.alQ);
        aVar.c(xVar);
        aVar.b(new ah(this.mPageContext.getPageActivity()));
        ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder = new ThreadCardViewHolder<>(aVar.a(BaseCardInfo.SupportType.FULL, viewGroup));
        threadCardViewHolder.setPageId(this.fJu);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.q.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                com.baidu.tieba.card.data.k kVar;
                if ((nVar instanceof com.baidu.tieba.card.data.k) && (kVar = (com.baidu.tieba.card.data.k) nVar) != null && kVar.eMv != null && kVar.eMv.bsg() != null) {
                    q.this.a(kVar.eMv, view);
                    TiebaStatic.log(kVar.cvu());
                    TiebaStatic.log(kVar.cvt());
                    q.this.e(kVar.eMv, kVar.cvn());
                }
            }
        });
        return threadCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.k kVar, ThreadCardViewHolder<com.baidu.tieba.card.data.k> threadCardViewHolder) {
        if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.eMv == null) {
            return null;
        }
        kVar.yA(kVar.position + 1);
        threadCardViewHolder.aK(false).a(this.ggi);
        threadCardViewHolder.b((ThreadCardViewHolder<com.baidu.tieba.card.data.k>) kVar);
        threadCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        threadCardViewHolder.ty().a(this.ahf);
        com.baidu.tieba.card.s.cvb().e(kVar.cvw());
        com.baidu.tieba.a.d.bOn().a("page_recommend", "show_", kVar.cvw());
        f(kVar.eMv, kVar.cvn());
        return threadCardViewHolder.getView();
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.ggi = aVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bz bzVar, View view) {
        if (bzVar != null && bzVar.bsg() != null) {
            String str = bzVar.bsg().id;
            String str2 = bzVar.bsg().link;
            String str3 = bzVar.bsg().h5_url;
            Long l = bzVar.bsg().swan_app_id;
            long parseLong = Long.parseLong(bzVar.getTid());
            long fid = bzVar.getFid();
            String str4 = bzVar.bsg().name;
            com.baidu.tbadk.core.sharedPref.b.bvr().putLong("smart_app_tid", parseLong);
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("smart_app_name", str4);
            com.baidu.tbadk.core.sharedPref.b.bvr().putString("smart_app_id", str);
            if (!StringUtils.isNull(str)) {
                if (!com.baidu.tieba.aiapps.a.b(str, str2, "1191008600000000", bzVar.bsg().is_game)) {
                    if (!StringUtils.isNull(str3)) {
                        com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), str3);
                    } else {
                        return;
                    }
                }
                com.baidu.tieba.card.m.Jn(bzVar.getTid());
                TiebaStatic.log(new aq("c13274").w("fid", fid).w("tid", parseLong).dX("uid", TbadkCoreApplication.getCurrentAccount()).dX("obj_name", str4).w("obj_id", l.longValue()).dX("obj_source", "index_card").an("obj_param1", bzVar.bsg().is_game.intValue()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(bz bzVar, int i) {
        if (bzVar != null && bzVar.bsg() != null) {
            com.baidu.tieba.s.c.dNY().b(this.fJu, com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_click", 1, i, bzVar.bsg().id));
        }
    }

    private void f(bz bzVar, int i) {
        if (bzVar != null && bzVar.bsg() != null) {
            String str = bzVar.bsg().id;
            com.baidu.tieba.s.c.dNY().a(this.fJu, com.baidu.tieba.s.a.a(bzVar.getTid(), "", str, (BaijiahaoData) null), com.baidu.tieba.s.a.a(bzVar, PageStayDurationConstants.PageName.HOMEPAGE_PERSONALIZE, "common_exp", i, str));
        }
    }
}
