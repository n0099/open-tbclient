package com.baidu.tieba.homepage.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
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
import com.baidu.tieba.card.s;
/* loaded from: classes22.dex */
public class q extends com.baidu.adp.widget.ListView.a<bv, com.baidu.card.a<bw>> {
    private aa<bw> afE;
    private v alC;
    private BdUniqueId fey;
    private at hXf;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afE = new aa<bw>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bw bwVar) {
                s.ciJ().lm(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, bwVar, q.this.mTabName);
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
    /* renamed from: aU */
    public com.baidu.card.a<bw> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bc = ay.bc(hVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bw)) {
                        ay.a(absThreadDataSupport, q.this.mContext, 2, false, bc);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, q.this.mContext, 2, false, bc);
                }
            }
        });
        this.hXf = hVar;
        this.hXf.setPageUniqueId(this.fey);
        this.hXf.setFrom("14");
        this.hXf.setStageType("2001");
        aVar.c(this.hXf);
        ak a2 = aVar.a(false, viewGroup, this.alC);
        com.baidu.card.a<bw> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fey);
        a2.a(this.afE);
        a2.setSourceForPb(2);
        a(new ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bv) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bw bwVar = ((bv) qVar).eji;
                    bwVar.objType = 1;
                    if (q.this.afE != null) {
                        q.this.afE.a(aVar3.getView(), bwVar);
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
        bvVar.eji.ens = getPositionByType(i) + 1;
        aVar.tW().setPosition(i);
        aVar.setVideoStatsData(ai(bvVar.eji));
        aVar.b((com.baidu.card.a<bw>) bvVar.eji);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afE);
        com.baidu.tieba.homepage.tabfeed.b.a(bvVar, this.mTabName);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ai(bw bwVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bwVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "20";
            oVar.alS = bwVar.tid;
            oVar.mSource = bwVar.mRecomSource;
            oVar.lRu = bwVar.mRecomAbTag;
            oVar.lRv = bwVar.mRecomWeight;
            oVar.lRw = "14";
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(bwVar.ens);
            if (bwVar.bjx() != null) {
                oVar.emE = String.valueOf(bwVar.bjx().etn);
            }
            if (bwVar.bfG() != null) {
                oVar.fkA = String.valueOf(bwVar.bfG().getFid());
                oVar.lRD = bwVar.bfG().getNid();
                if (bwVar.bfG().biz() != null) {
                    oVar.lRz = bwVar.bfG().biz().video_md5;
                    oVar.lRB = String.valueOf(bwVar.bfG().biz().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bwVar.bfG() != null && bwVar.bfG().getBaijiahaoData() != null) {
                oVar.mNid = bwVar.bfG().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bwVar.bfG().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
