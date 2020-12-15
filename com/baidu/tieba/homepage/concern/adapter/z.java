package com.baidu.tieba.homepage.concern.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes22.dex */
public class z extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> agG;
    private String aiw;
    private com.baidu.adp.widget.ListView.v amH;
    public BdUniqueId fzO;
    private at iBm;
    private BdUniqueId jLf;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iBm != null && this.iBm.uf() != null && this.iBm.uf().dBI() != null) {
            if (view.getId() == this.iBm.uf().dBI().getId()) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
            }
        }
    }

    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.z.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.csh().mj(true);
                com.baidu.tieba.a.d.bLU().dS("page_recommend", "show_");
                if (lVar != null && lVar.bmn() != null && !StringUtils.isNull(lVar.bmn().getTid())) {
                    if (lVar.bmn().eLF <= 0) {
                        z.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ai(lVar.bmn()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jLf = bdUniqueId2;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.amH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qL() {
        return this.jLf != null ? this.jLf : com.baidu.tieba.card.data.b.imt;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qM() {
        return com.baidu.tieba.card.data.b.imz;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qN() {
        return com.baidu.tieba.card.data.b.imA;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qO() {
        return com.baidu.tieba.card.data.b.imB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.fzO);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.z.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bn = az.bn(cVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        az.a(aVar2, z.this.mContext, 1, false, bn);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, z.this.mContext, 1, false, bn);
                }
            }
        });
        this.iBm = cVar;
        aVar.c(this.iBm);
        if (this.iBm != null) {
            this.iBm.setStageType("2001");
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fzO);
        a2.a(this.agG);
        a2.setSourceForPb(1);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.z.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.adp.widget.ListView.i) && (view.getTag() instanceof am) && (((com.baidu.adp.widget.ListView.i) qVar).qV() instanceof com.baidu.tieba.card.data.l)) {
                    am amVar = (am) view.getTag();
                    com.baidu.tieba.card.data.l lVar2 = (com.baidu.tieba.card.data.l) ((com.baidu.adp.widget.ListView.i) qVar).qV();
                    lVar2.objType = 1;
                    if (z.this.agG != null) {
                        z.this.agG.a(amVar.getView(), lVar2);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar2, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tZ().b(new a.C0097a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.ym(lVar.position + 1);
        com.baidu.tieba.card.t.csh().e(lVar.Jv("c12351"));
        aVar.tZ().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.tZ() instanceof com.baidu.tieba.a.e) {
            aVar.tZ().setPage(this.aiw);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tZ().a(this.agG);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.amY = lVar.tid;
            if (lVar.bmn() != null) {
                oVar.fFV = String.valueOf(lVar.bmn().getFid());
                if (lVar.bmn().bph() != null) {
                    oVar.myv = lVar.bmn().bph().video_md5;
                    oVar.myx = String.valueOf(lVar.bmn().bph().is_vertical);
                }
            }
            oVar.eGn = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.myu = lVar.csu();
            oVar.myr = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.cst());
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fo(String str) {
        this.aiw = str;
    }
}
