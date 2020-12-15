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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
/* loaded from: classes22.dex */
public class q extends com.baidu.adp.widget.ListView.a<bx, com.baidu.card.a<by>> {
    private ab<by> agG;
    private v amH;
    private BdUniqueId fzO;
    private at iBm;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new ab<by>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, by byVar) {
                t.csh().mj(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, byVar, q.this.mTabName);
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
    /* renamed from: aS */
    public com.baidu.card.a<by> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.h hVar = new com.baidu.card.h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bn = az.bn(hVar.getVideoContainer());
                    if (!(aVar2 instanceof by)) {
                        az.a(aVar2, q.this.mContext, 2, false, bn);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, q.this.mContext, 2, false, bn);
                }
            }
        });
        this.iBm = hVar;
        this.iBm.setPageUniqueId(this.fzO);
        this.iBm.setFrom("14");
        this.iBm.setStageType("2001");
        aVar.c(this.iBm);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        com.baidu.card.a<by> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fzO);
        a2.a(this.agG);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bx) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    by byVar = ((bx) qVar).eCR;
                    byVar.objType = 1;
                    if (q.this.agG != null) {
                        q.this.agG.a(aVar3.getView(), byVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) byVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.tZ().b(new a.C0097a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bx bxVar, com.baidu.card.a<by> aVar) {
        if (bxVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        bxVar.eCR.eHa = getPositionByType(i) + 1;
        aVar.tZ().setPosition(i);
        aVar.setVideoStatsData(ak(bxVar.eCR));
        aVar.b((com.baidu.card.a<by>) bxVar.eCR);
        aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tZ().a(this.agG);
        com.baidu.tieba.homepage.tabfeed.b.a(bxVar, this.mTabName);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o ak(by byVar) {
        com.baidu.tieba.play.o oVar = null;
        if (byVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "20";
            oVar.amY = byVar.tid;
            oVar.mSource = byVar.mRecomSource;
            oVar.myq = byVar.mRecomAbTag;
            oVar.myr = byVar.mRecomWeight;
            oVar.mys = "14";
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(byVar.eHa);
            if (byVar.bqh() != null) {
                oVar.eGn = String.valueOf(byVar.bqh().eMW);
            }
            if (byVar.bmn() != null) {
                oVar.fFV = String.valueOf(byVar.bmn().getFid());
                oVar.myz = byVar.bmn().getNid();
                if (byVar.bmn().bph() != null) {
                    oVar.myv = byVar.bmn().bph().video_md5;
                    oVar.myx = String.valueOf(byVar.bmn().bph().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (byVar.bmn() != null && byVar.bmn().getBaijiahaoData() != null) {
                oVar.mNid = byVar.bmn().getBaijiahaoData().oriUgcNid;
                oVar.mVid = byVar.bmn().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
