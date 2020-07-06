package com.baidu.tieba.enterForum.tabfeed.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.al;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class j extends com.baidu.adp.widget.ListView.a<bt, ak<bu>> {
    private aa<bt> adX;
    private v ajy;
    private NEGFeedBackView.a eTW;
    public BdUniqueId eyE;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.ad$a] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public /* bridge */ /* synthetic */ View a(int i, View view, ViewGroup viewGroup, bt btVar, ak<bu> akVar) {
        return a2(i, view, viewGroup, btVar, (ak) akVar);
    }

    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new aa<bt>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.j.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, bt btVar) {
                if (btVar != null) {
                    s.bOB().jI(true);
                    com.baidu.tieba.enterForum.a.a(view, btVar, j.this.mTabName);
                }
            }
        };
        this.eTW = new NEGFeedBackView.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.j.2
            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void b(ap apVar) {
                TiebaStatic.log(com.baidu.tbadk.core.util.l.a(apVar, j.this.mTabName));
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ap apVar, CompoundButton compoundButton, boolean z) {
            }

            @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.a
            public void a(ArrayList<Integer> arrayList, String str2, ap apVar) {
            }
        };
        this.mPageContext = tbPageContext;
        this.eyE = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public ak b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        al alVar = new al(this.mPageContext.getPageActivity());
        com.baidu.tbadk.core.data.c cVar = new com.baidu.tbadk.core.data.c();
        cVar.dHq = 22;
        cVar.dHw = 19;
        alVar.setAgreeStatisticData(cVar);
        alVar.setTabName(this.mTabName);
        alVar.setFrom(18);
        alVar.setStType("personalize_page");
        alVar.setShareReportFrom(18);
        alVar.setFromForPb(2);
        alVar.bd(32);
        aVar.b(alVar);
        ai a = aVar.a(true, viewGroup, this.ajy);
        a.setSourceForPb(2);
        ak akVar = new ak(a);
        akVar.setPageId(this.eyE);
        a(new z() { // from class: com.baidu.tieba.enterForum.tabfeed.a.j.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bt) && (view.getTag() instanceof ak)) {
                    ak akVar2 = (ak) view.getTag();
                    bu buVar = ((bt) qVar).dLi;
                    buVar.objType = 1;
                    if (j.this.adX != null) {
                        j.this.adX.a(akVar2.getView(), (bt) qVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    akVar2.se().b(new a.C0098a(1));
                }
            }
        });
        return akVar;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    protected View a2(final int i, final View view, final ViewGroup viewGroup, bt btVar, ak akVar) {
        if (btVar == null || akVar == null || akVar.getView() == null || btVar.dLi == null) {
            return null;
        }
        btVar.dLi.dJw = getPositionByType(i) + 1;
        akVar.se().setPosition(i);
        if (akVar.se().rY() instanceof al) {
            ((al) akVar.se().rY()).setOnCommentClickCallback(new ThreadCommentAndPraiseInfoLayout.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.j.4
                @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.a
                public void a(IntentConfig intentConfig) {
                    if (intentConfig instanceof PbActivityConfig) {
                        ((PbActivityConfig) intentConfig).setVideoOriginArea(com.baidu.card.f.a((v) viewGroup, view, i));
                    }
                }
            });
        }
        akVar.aI(false).a(this.eTW);
        akVar.b((ak) btVar);
        akVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        akVar.se().a(this.adX);
        com.baidu.tieba.enterForum.a.a(btVar, this.mTabName);
        return akVar.getView();
    }
}
