package com.baidu.tieba.homepage.hotTopic.tab.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.play.o;
/* loaded from: classes21.dex */
public class f extends a<bv, com.baidu.card.a<bw>> {
    private aa<bw> afn;
    private at hIk;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), bw.edC);
        this.afn = new aa<bw>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                f.this.f(view, bwVar);
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.f.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect ba = ay.ba(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, f.this.mContext, 0, false, ba);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, f.this.mContext, 0, false, ba);
                }
            }
        });
        this.hIk = hVar;
        this.hIk.setPageUniqueId(this.mPageId);
        this.hIk.setFrom("14");
        this.hIk.setStageType("2001");
        aVar.c(this.hIk);
        ak a = aVar.a(false, viewGroup, this.alj);
        com.baidu.card.a<bw> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.mPageId);
        a.a(this.afn);
        a.setSourceForPb(0);
        a(new ab() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.f.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bw bwVar = ((bv) qVar).dXg;
                    bwVar.objType = 1;
                    if (f.this.afn != null) {
                        f.this.afn.a(aVar3.getView(), bwVar);
                    }
                    ay.a((AbsThreadDataSupport) bwVar, view.getContext(), 0, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.tW().b(new a.C0096a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.hotTopic.tab.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bv bvVar, com.baidu.card.a<bw> aVar) {
        if (bvVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        bvVar.dXg.ebp = getPositionByType(i) + 1;
        aVar.tW().setPosition(i);
        aVar.setVideoStatsData(ai(bvVar.dXg));
        aVar.b((com.baidu.card.a<bw>) bvVar.dXg);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afn);
        a(aVar.getView(), bvVar.dXg, i, i);
        return aVar.getView();
    }

    private o ai(bw bwVar) {
        o oVar = null;
        if (bwVar != null) {
            oVar = new o();
            oVar.mLocate = "20";
            oVar.alA = bwVar.tid;
            oVar.mSource = bwVar.mRecomSource;
            oVar.lCf = bwVar.mRecomAbTag;
            oVar.lCg = bwVar.mRecomWeight;
            oVar.lCh = "14";
            oVar.mFloor = String.valueOf(bwVar.ebp);
            if (bwVar.bgO() != null) {
                oVar.eaC = String.valueOf(bwVar.bgO().ehg);
            }
            if (bwVar.bcY() != null) {
                oVar.eYo = String.valueOf(bwVar.bcY().getFid());
                oVar.lCo = bwVar.bcY().getNid();
                if (bwVar.bcY().bfQ() != null) {
                    oVar.lCk = bwVar.bcY().bfQ().video_md5;
                    oVar.lCm = String.valueOf(bwVar.bcY().bfQ().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.bcY() != null && bwVar.bcY().getBaijiahaoData() != null) {
                oVar.mNid = bwVar.bcY().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bwVar.bcY().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
