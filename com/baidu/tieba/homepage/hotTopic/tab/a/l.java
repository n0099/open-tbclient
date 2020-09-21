package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class l extends a<bv, am<bw>> {
    private aa<bv> afn;

    public l(TbPageContext<?> tbPageContext) {
        super(tbPageContext, bw.edr);
        this.afn = new aa<bv>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bv bvVar) {
                if (bvVar != null) {
                    l.this.f(view, bvVar.dXg);
                }
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dYY = 1;
        cVar.dZe = 1;
        anVar.setAgreeStatisticData(cVar);
        anVar.setFrom(1);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(1);
        anVar.setFromForPb(2);
        anVar.bo(32);
        aVar.b(anVar);
        ak a = aVar.a(true, viewGroup, this.alj);
        a.setSourceForPb(2);
        am amVar = new am(a);
        amVar.setPageId(this.mPageId);
        a(new ab() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.l.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).dXg;
                    bwVar.objType = 1;
                    if (l.this.afn != null) {
                        l.this.afn.a(amVar2.getView(), (bv) qVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 0, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0096a(1));
                }
            }
        });
        return amVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.hotTopic.tab.a.a, com.baidu.adp.widget.ListView.a
    public View a(final int i, final View view, final ViewGroup viewGroup, bv bvVar, am amVar) {
        if (bvVar == null || amVar == null || amVar.getView() == null || bvVar.dXg == null) {
            return null;
        }
        bvVar.dXg.ebp = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.l.3
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((v) viewGroup, view, i));
                    }
                }
            });
        }
        amVar.b((am) bvVar);
        amVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tW().a(this.afn);
        return amVar.getView();
    }
}
