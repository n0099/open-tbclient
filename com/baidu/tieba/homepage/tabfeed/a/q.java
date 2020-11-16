package com.baidu.tieba.homepage.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes21.dex */
public class q extends com.baidu.adp.widget.ListView.a<bw, com.baidu.card.a<bx>> {
    private ab<bx> afK;
    private v alH;
    private BdUniqueId fsa;
    private at iqs;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afK = new ab<bx>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bx bxVar) {
                t.cnT().lO(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, bxVar, q.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fsa = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<bx> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bk = az.bk(hVar.getVideoContainer());
                    if (!(aVar2 instanceof bx)) {
                        az.a(aVar2, q.this.mContext, 2, false, bk);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, q.this.mContext, 2, false, bk);
                }
            }
        });
        this.iqs = hVar;
        this.iqs.setPageUniqueId(this.fsa);
        this.iqs.setFrom("14");
        this.iqs.setStageType("2001");
        aVar.c(this.iqs);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.alH);
        com.baidu.card.a<bx> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsa);
        a2.a(this.afK);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bw) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bx bxVar = ((bw) qVar).evQ;
                    bxVar.objType = 1;
                    if (q.this.afK != null) {
                        q.this.afK.a(aVar3.getView(), bxVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) bxVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.tW().b(new a.C0096a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bw bwVar, com.baidu.card.a<bx> aVar) {
        if (bwVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        bwVar.evQ.eAb = getPositionByType(i) + 1;
        aVar.tW().setPosition(i);
        aVar.setVideoStatsData(ak(bwVar.evQ));
        aVar.b((com.baidu.card.a<bx>) bwVar.evQ);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afK);
        com.baidu.tieba.homepage.tabfeed.b.a(bwVar, this.mTabName);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ak(bx bxVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bxVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "20";
            oVar.alZ = bxVar.tid;
            oVar.mSource = bxVar.mRecomSource;
            oVar.mkk = bxVar.mRecomAbTag;
            oVar.mkl = bxVar.mRecomWeight;
            oVar.mkm = "14";
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(bxVar.eAb);
            if (bxVar.bmU() != null) {
                oVar.ezo = String.valueOf(bxVar.bmU().eFT);
            }
            if (bxVar.bjd() != null) {
                oVar.fyg = String.valueOf(bxVar.bjd().getFid());
                oVar.mkt = bxVar.bjd().getNid();
                if (bxVar.bjd().blU() != null) {
                    oVar.mkp = bxVar.bjd().blU().video_md5;
                    oVar.mkr = String.valueOf(bxVar.bjd().blU().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bxVar.bjd() != null && bxVar.bjd().getBaijiahaoData() != null) {
                oVar.mNid = bxVar.bjd().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bxVar.bjd().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
