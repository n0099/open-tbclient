package com.baidu.tieba.homepage.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class q extends com.baidu.adp.widget.ListView.a<bv, com.baidu.card.a<bw>> {
    private aa<bw> aeV;
    private v akK;
    private BdUniqueId ePz;
    private as hBi;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeV = new aa<bw>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                s.cbY().kM(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, bwVar, q.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.ePz = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.akK = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<bw> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aY = ay.aY(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, q.this.mContext, 2, false, aY);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, q.this.mContext, 2, false, aY);
                }
            }
        });
        this.hBi = gVar;
        this.hBi.setPageUniqueId(this.ePz);
        this.hBi.setFrom("14");
        this.hBi.setStageType("2001");
        aVar.c(this.hBi);
        aj a = aVar.a(false, viewGroup, this.akK);
        com.baidu.card.a<bw> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ePz);
        a.a(this.aeV);
        a.setSourceForPb(2);
        a(new ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof al)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bw bwVar = ((bv) qVar).dUW;
                    bwVar.objType = 1;
                    if (q.this.aeV != null) {
                        q.this.aeV.a(aVar3.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.tR().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.a<bw> aVar) {
        if (bvVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        bvVar.dUW.dZf = getPositionByType(i) + 1;
        aVar.tR().setPosition(i);
        aVar.setVideoStatsData(ah(bvVar.dUW));
        aVar.b((com.baidu.card.a<bw>) bvVar.dUW);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.aeV);
        com.baidu.tieba.homepage.tabfeed.b.a(bvVar, this.mTabName);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ah(bw bwVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bwVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "20";
            oVar.ala = bwVar.tid;
            oVar.mSource = bwVar.mRecomSource;
            oVar.ltn = bwVar.mRecomAbTag;
            oVar.lto = bwVar.mRecomWeight;
            oVar.ltp = "14";
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(bwVar.dZf);
            if (bwVar.bfU() != null) {
                oVar.dYs = String.valueOf(bwVar.bfU().eeS);
            }
            if (bwVar.bce() != null) {
                oVar.eVx = String.valueOf(bwVar.bce().getFid());
                oVar.ltx = bwVar.bce().getNid();
                if (bwVar.bce().beW() != null) {
                    oVar.ltt = bwVar.bce().beW().video_md5;
                    oVar.ltv = String.valueOf(bwVar.bce().beW().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.bce() != null && bwVar.bce().getBaijiahaoData() != null) {
                oVar.mNid = bwVar.bce().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bwVar.bce().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
