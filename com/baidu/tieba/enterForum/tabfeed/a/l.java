package com.baidu.tieba.enterForum.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
import com.baidu.tieba.play.o;
/* loaded from: classes22.dex */
public class l extends com.baidu.adp.widget.ListView.a<bv, com.baidu.card.a<bw>> {
    private ab<bw> afF;
    private v alD;
    private BdUniqueId fsQ;
    private at ipE;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<bw>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                t.cor().lN(true);
                com.baidu.tieba.enterForum.a.a(view, bwVar, l.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fsQ = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public com.baidu.card.a<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.l.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bh = ay.bh(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, l.this.mContext, 2, false, bh);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, l.this.mContext, 2, false, bh);
                }
            }
        });
        this.ipE = hVar;
        this.ipE.setPageUniqueId(this.fsQ);
        this.ipE.setFrom("14");
        this.ipE.setStageType("2001");
        aVar.c(this.ipE);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        com.baidu.card.a<bw> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsQ);
        a2.a(this.afF);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.enterForum.tabfeed.a.l.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bw bwVar = ((bv) qVar).exA;
                    bwVar.objType = 1;
                    if (l.this.afF != null) {
                        l.this.afF.a(aVar3.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.tW().b(new a.C0097a(1));
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
        bvVar.exA.eBK = getPositionByType(i) + 1;
        aVar.tW().setPosition(i);
        aVar.setVideoStatsData(ai(bvVar.exA));
        aVar.b((com.baidu.card.a<bw>) bvVar.exA);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afF);
        com.baidu.tieba.enterForum.a.a(bvVar, this.mTabName);
        return aVar.getView();
    }

    private o ai(bw bwVar) {
        o oVar = null;
        if (bwVar != null) {
            oVar = new o();
            oVar.mLocate = "20";
            oVar.alT = bwVar.tid;
            oVar.mSource = bwVar.mRecomSource;
            oVar.mjR = bwVar.mRecomAbTag;
            oVar.mjS = bwVar.mRecomWeight;
            oVar.mjT = "14";
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(bwVar.eBK);
            if (bwVar.bnQ() != null) {
                oVar.eAX = String.valueOf(bwVar.bnQ().eHB);
            }
            if (bwVar.bjZ() != null) {
                oVar.fyR = String.valueOf(bwVar.bjZ().getFid());
                oVar.mka = bwVar.bjZ().getNid();
                if (bwVar.bjZ().bmS() != null) {
                    oVar.mjW = bwVar.bjZ().bmS().video_md5;
                    oVar.mjY = String.valueOf(bwVar.bjZ().bmS().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.bjZ() != null && bwVar.bjZ().getBaijiahaoData() != null) {
                oVar.mNid = bwVar.bjZ().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bwVar.bjZ().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
