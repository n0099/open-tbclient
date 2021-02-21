package com.baidu.tieba.homepage.concern.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> agg;
    private String aif;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private as iON;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iON != null && this.iON.tq() != null && this.iON.tq().dzW() != null) {
            if (view.getId() == this.iON.tq().dzW().getId()) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
            }
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.csB().mG(true);
                com.baidu.tieba.a.d.bKU().dK("page_recommend", "show_");
                if (lVar != null && lVar.bln() != null && !StringUtils.isNull(lVar.bln().getTid())) {
                    if (lVar.bln().eTa <= 0) {
                        y.this.b(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.aj(lVar.bln()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.b bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        bVar.setPageUniqueId(this.fGZ);
        bVar.setFrom("concern_tab");
        bVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.concern.adapter.y.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(bVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        az.a(aVar2, y.this.mContext, 1, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, y.this.mContext, 1, false, bs);
                }
            }
        });
        this.iON = bVar;
        aVar.c(this.iON);
        if (this.iON != null) {
            this.iON.setStageType("2001");
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fGZ);
        a2.a(this.agg);
        a2.setSourceForPb(1);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.y.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) nVar;
                    lVar.objType = 1;
                    if (y.this.agg != null) {
                        y.this.agg.a(threadCardViewHolder.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0089a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xd(lVar.position + 1);
        com.baidu.tieba.card.t.csB().e(lVar.IT("c12351"));
        autoVideoCardViewHolder.tj().setPosition(i);
        lVar.sourceType = 0;
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        if (autoVideoCardViewHolder.tj() instanceof com.baidu.tieba.a.e) {
            autoVideoCardViewHolder.tj().setPage(this.aif);
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.agg);
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.amC = lVar.tid;
            if (lVar.bln() != null) {
                oVar.fNd = String.valueOf(lVar.bln().getFid());
                if (lVar.bln().boh() != null) {
                    oVar.mIA = lVar.bln().boh().video_md5;
                    oVar.mIC = String.valueOf(lVar.bln().boh().is_vertical);
                }
            }
            oVar.eNE = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mIz = lVar.csP();
            oVar.mIw = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.csO());
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ew(String str) {
        this.aif = str;
    }
}
