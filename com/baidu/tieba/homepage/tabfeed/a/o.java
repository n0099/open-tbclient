package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class o extends com.baidu.adp.widget.ListView.a<bx, am<by>> {
    private ab<bx> agG;
    private v amH;
    private NEGFeedBackView.a fWC;
    public BdUniqueId fzO;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, bx bxVar, am<by> amVar) {
        return a2(i, view, viewGroup, bxVar, (am) amVar);
    }

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new ab<bx>() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, bx bxVar) {
                if (bxVar != null) {
                    t.csh().mj(true);
                }
            }
        };
        this.fWC = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(at atVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(at atVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str2, at atVar) {
            }
        };
        this.mPageContext = tbPageContext;
        this.fzO = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.amH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.d dVar = new com.baidu.tbadk.core.data.d();
        dVar.eEJ = 22;
        dVar.eEP = 19;
        anVar.setAgreeStatisticData(dVar);
        anVar.setTabName(this.mTabName);
        anVar.setFrom(18);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(18);
        anVar.setFromForPb(2);
        anVar.bs(32);
        aVar.b(anVar);
        ak a2 = aVar.a(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.amH);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fzO);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (o.this.agG != null) {
                        o.this.agG.a(amVar2.getView(), (bx) qVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar2.tZ().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, bx bxVar, am amVar) {
        if (bxVar == null || amVar == null || amVar.getView() == null || bxVar.eCR == null) {
            return null;
        }
        bxVar.eCR.eHa = getPositionByType(i) + 1;
        amVar.tZ().setPosition(i);
        if (amVar.tZ().tT() instanceof an) {
            ((an) amVar.tZ().tT()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((v) viewGroup, view, i));
                    }
                }
            });
        }
        amVar.b((am) bxVar);
        amVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        amVar.tZ().a(this.agG);
        return amVar.getView();
    }
}
