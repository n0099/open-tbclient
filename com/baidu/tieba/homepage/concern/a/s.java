package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.card.Align;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.am;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, al<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> aeT;
    private String agH;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private TbPageContext<?> mPageContext;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al<com.baidu.tieba.card.data.l> alVar) {
        return a2(i, view, viewGroup, lVar, (al) alVar);
    }

    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                if (view != null && lVar != null && lVar.bce() != null && !StringUtils.isNull(lVar.bce().getTid())) {
                    s.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (view.getId() == R.id.thread_card_root || view.getId() == R.id.thread_info_commont_container) {
            com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public al b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        am amVar = new am(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dWK = 9;
        cVar.dWQ = 9;
        amVar.setAgreeStatisticData(cVar);
        amVar.setFrom(4);
        amVar.setStType("personalize_page");
        amVar.setShareReportFrom(4);
        amVar.setFromForPb(1);
        amVar.bk(32);
        aVar.b(amVar);
        aj a = aVar.a(true, viewGroup, this.akI);
        a.setSourceForPb(1);
        al alVar = new al(a);
        alVar.setPageId(this.ePv);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.a.s.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof al)) {
                    al alVar2 = (al) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (s.this.aeT != null) {
                        s.this.aeT.a(alVar2.getView(), lVar);
                    }
                    ay.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    alVar2.tR().b(new a.C0095a(1));
                }
            }
        });
        return alVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, al alVar) {
        if (lVar == null || alVar == null || alVar.getView() == null || lVar.dUS == null) {
            return null;
        }
        lVar.vy(lVar.position + 1);
        alVar.tR().setPosition(i);
        if (alVar.tR().tL() instanceof am) {
            ((am) alVar.tR().tL()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.concern.a.s.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup, view, i));
                    }
                }
            });
        }
        if (alVar.tR() instanceof com.baidu.tieba.a.e) {
            alVar.tR().setPage(this.agH);
        }
        alVar.a(false, Align.ALIGN_RIGHT_BOTTOM);
        alVar.b((al) lVar);
        alVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        alVar.tR().a(this.aeT);
        return alVar.getView();
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }
}
