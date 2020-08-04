package com.baidu.tieba.homepage.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.ar;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
/* loaded from: classes16.dex */
public class q extends com.baidu.adp.widget.ListView.a<bu, com.baidu.card.a<bv>> {
    private aa<bv> adN;
    private v ajt;
    private BdUniqueId eEU;
    private ar hol;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new aa<bv>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bv bvVar) {
                s.bRL().km(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, bvVar, q.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.eEU = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<bv> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aW = ax.aW(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bv)) {
                        ax.a(absThreadDataSupport, q.this.mContext, 2, false, aW);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ax.a(absThreadDataSupport, q.this.mContext, 2, false, aW);
                }
            }
        });
        this.hol = gVar;
        this.hol.setPageUniqueId(this.eEU);
        this.hol.setFrom("14");
        aVar.c(this.hol);
        ai a = aVar.a(false, viewGroup, this.ajt);
        com.baidu.card.a<bv> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eEU);
        a.a(this.adN);
        a.setSourceForPb(2);
        a(new z() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bu) && (view.getTag() instanceof ak)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bv bvVar = ((bu) qVar).dLK;
                    bvVar.objType = 1;
                    if (q.this.adN != null) {
                        q.this.adN.a(aVar3.getView(), bvVar);
                    }
                    ax.a((AbsThreadDataSupport) bvVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.sg().b(new a.C0096a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bu buVar, com.baidu.card.a<bv> aVar) {
        if (buVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        buVar.dLK.dPI = getPositionByType(i) + 1;
        aVar.sg().setPosition(i);
        aVar.setVideoStatsData(ah(buVar.dLK));
        aVar.b((com.baidu.card.a<bv>) buVar.dLK);
        aVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.sg().a(this.adN);
        com.baidu.tieba.homepage.tabfeed.b.a(buVar, this.mTabName);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ah(bv bvVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bvVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "20";
            oVar.ajJ = bvVar.tid;
            oVar.mSource = bvVar.mRecomSource;
            oVar.lcJ = bvVar.mRecomAbTag;
            oVar.lcK = bvVar.mRecomWeight;
            oVar.lcL = "14";
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(bvVar.dPI);
            if (bvVar.aXB() != null) {
                oVar.dOV = String.valueOf(bvVar.aXB().dVo);
            }
            if (bvVar.aTN() != null) {
                oVar.eKO = String.valueOf(bvVar.aTN().getFid());
                oVar.lcS = bvVar.aTN().getNid();
                if (bvVar.aTN().aWD() != null) {
                    oVar.lcO = bvVar.aTN().aWD().video_md5;
                    oVar.lcQ = String.valueOf(bvVar.aTN().aWD().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bvVar.aTN() != null && bvVar.aTN().getBaijiahaoData() != null) {
                oVar.mNid = bvVar.aTN().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bvVar.aTN().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
