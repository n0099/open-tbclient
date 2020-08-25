package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private NEGFeedBackView.a flJ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cbX().kK(true);
                if (view != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    l.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cyk();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        int i;
        aq ccw;
        int id = view.getId();
        if (lVar != null) {
            if (id == R.id.forum_head_image || id == R.id.forum_head_barname || id == R.id.forum_head_info_attention || id == R.id.forum_head_info_thread) {
                TiebaStatic.log(lVar.ccx());
                com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", lVar.ccx());
                i = 9;
            } else {
                if (lVar.bdk()) {
                    ccw = lVar.ccB();
                } else {
                    ccw = lVar.ccw();
                }
                TiebaStatic.log(ccw);
                com.baidu.tieba.a.d.bAA().a("page_recommend", "clk_", ccw);
                i = 1;
            }
            if (i != 0) {
                com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj(), i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity());
        aVar.tP().bu(com.baidu.adp.lib.util.l.getDimens(this.mPageContext.getPageActivity(), com.baidu.tbadk.a.b.a.aL(R.dimen.tbds30, R.dimen.tbds10)));
        aVar.a(new com.baidu.card.l(this.mPageContext.getPageActivity()));
        aj a = aVar.a(false, viewGroup, this.akI);
        a.setSourceForPb(2);
        al alVar = new al(a);
        alVar.setPageId(this.ePv);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.l.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (l.this.aeT != null) {
                        l.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.tR().setPosition(i);
        alVar.tR().setPage(this.agH);
        alVar.a(true, Align.ALIGN_RIGHT_TOP, this.flJ);
        alVar.b((al<com.baidu.tieba.card.data.l>) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        com.baidu.tieba.card.s.cbX().e(lVar.ccv());
        com.baidu.tieba.a.d.bAA().e(lVar.ccv());
        com.baidu.tieba.homepage.personalize.c.a.a(lVar.dUS, this.ePv, lVar.ccj());
        return alVar.getView();
    }

    private void cyk() {
        com.baidu.tieba.card.data.l.hmJ = "c10705";
        com.baidu.tieba.card.data.l.hmK = "c10730";
        com.baidu.tieba.card.data.l.hmL = "c10731";
        com.baidu.tieba.card.data.l.hmM = "c10704";
        com.baidu.tieba.card.data.l.hmN = "c10755";
        com.baidu.tieba.card.data.l.hmO = "c10710";
        com.baidu.tieba.card.data.l.hmP = "c10736";
        com.baidu.tieba.card.data.l.hmQ = "c10737";
        com.baidu.tieba.card.data.l.hmR = "c10711";
        com.baidu.tieba.card.data.l.hmS = "c10758";
        com.baidu.tieba.card.data.l.hmT = "c10757";
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flJ = aVar;
    }
}
