package com.baidu.tieba.homepage.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.an;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class o extends com.baidu.adp.widget.ListView.a<bv, am<bw>> {
    private aa<bv> afE;
    private v alC;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.af$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, bv bvVar, am<bw> amVar) {
        return a2(i, view, viewGroup, bvVar, (am) amVar);
    }

    public o(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afE = new aa<bv>() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bv bvVar) {
                if (bvVar != null) {
                    s.ciJ().lm(true);
                }
            }
        };
        this.fAU = new NEGFeedBackView.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackWindowShow(ar arVar) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onCheckedChanged(ar arVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str2, ar arVar) {
            }
        };
        this.mPageContext = tbPageContext;
        this.fey = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alC = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aT */
    public am c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        an anVar = new an(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.ela = 22;
        cVar.elg = 19;
        anVar.setAgreeStatisticData(cVar);
        anVar.setTabName(this.mTabName);
        anVar.setFrom(18);
        anVar.setStType("personalize_page");
        anVar.setShareReportFrom(18);
        anVar.setFromForPb(2);
        anVar.bo(32);
        aVar.b(anVar);
        ak a2 = aVar.a(true, viewGroup, this.alC);
        a2.setSourceForPb(2);
        am amVar = new am(a2);
        amVar.setPageId(this.fey);
        a(new ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    am amVar2 = (am) view.getTag();
                    bw bwVar = ((bv) qVar).eji;
                    bwVar.objType = 1;
                    if (o.this.afE != null) {
                        o.this.afE.a(amVar2.getView(), (bv) qVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar2.tW().b(new a.C0097a(1));
                }
            }
        });
        return amVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, bv bvVar, am amVar) {
        if (bvVar == null || amVar == null || amVar.getView() == null || bvVar.eji == null) {
            return null;
        }
        bvVar.eji.ens = getPositionByType(i) + 1;
        amVar.tW().setPosition(i);
        if (amVar.tW().tQ() instanceof an) {
            ((an) amVar.tW().tQ()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.o.4
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
        amVar.tW().a(this.afE);
        return amVar.getView();
    }
}
