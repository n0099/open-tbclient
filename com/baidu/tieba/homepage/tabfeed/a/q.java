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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class q extends com.baidu.adp.widget.ListView.a<bv, com.baidu.card.a<bw>> {
    private ab<bw> afF;
    private v alD;
    private BdUniqueId fmX;
    private at ijF;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<bw>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                t.clQ().lE(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, bwVar, q.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fmX = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bd = ay.bd(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, q.this.mContext, 2, false, bd);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, q.this.mContext, 2, false, bd);
                }
            }
        });
        this.ijF = hVar;
        this.ijF.setPageUniqueId(this.fmX);
        this.ijF.setFrom("14");
        this.ijF.setStageType("2001");
        aVar.c(this.ijF);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        com.baidu.card.a<bw> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fmX);
        a2.a(this.afF);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bw bwVar = ((bv) qVar).erH;
                    bwVar.objType = 1;
                    if (q.this.afF != null) {
                        q.this.afF.a(aVar3.getView(), bwVar);
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
        bvVar.erH.evR = getPositionByType(i) + 1;
        aVar.tW().setPosition(i);
        aVar.setVideoStatsData(ai(bvVar.erH));
        aVar.b((com.baidu.card.a<bw>) bvVar.erH);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afF);
        com.baidu.tieba.homepage.tabfeed.b.a(bvVar, this.mTabName);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bwVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "20";
            oVar.alT = bwVar.tid;
            oVar.mSource = bwVar.mRecomSource;
            oVar.mdS = bwVar.mRecomAbTag;
            oVar.mdT = bwVar.mRecomWeight;
            oVar.mdU = "14";
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(bwVar.evR);
            if (bwVar.blq() != null) {
                oVar.eve = String.valueOf(bwVar.blq().eBM);
            }
            if (bwVar.bhz() != null) {
                oVar.fsZ = String.valueOf(bwVar.bhz().getFid());
                oVar.meb = bwVar.bhz().getNid();
                if (bwVar.bhz().bks() != null) {
                    oVar.mdX = bwVar.bhz().bks().video_md5;
                    oVar.mdZ = String.valueOf(bwVar.bhz().bks().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.bhz() != null && bwVar.bhz().getBaijiahaoData() != null) {
                oVar.mNid = bwVar.bhz().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bwVar.bhz().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
