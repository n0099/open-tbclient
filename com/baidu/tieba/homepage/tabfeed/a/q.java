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
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class q extends com.baidu.adp.widget.ListView.a<bt, com.baidu.card.a<bu>> {
    private aa<bu> adX;
    private v ajy;
    private BdUniqueId eyE;
    private ar hiC;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new aa<bu>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bu buVar) {
                s.bOB().jI(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, buVar, q.this.mTabName);
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
    /* renamed from: aR */
    public com.baidu.card.a<bu> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = aw.aQ(gVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof bu)) {
                        aw.a(absThreadDataSupport, q.this.mContext, 2, false, aQ);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    aw.a(absThreadDataSupport, q.this.mContext, 2, false, aQ);
                }
            }
        });
        this.hiC = gVar;
        this.hiC.setPageUniqueId(this.eyE);
        this.hiC.setFrom("14");
        aVar.c(this.hiC);
        ai a = aVar.a(false, viewGroup, this.ajy);
        com.baidu.card.a<bu> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eyE);
        a.a(this.adX);
        a.setSourceForPb(2);
        a(new z() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof bt) && (view.getTag() instanceof ak)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bu buVar = ((bt) qVar).dLi;
                    buVar.objType = 1;
                    if (q.this.adX != null) {
                        q.this.adX.a(aVar3.getView(), buVar);
                    }
                    aw.a((AbsThreadDataSupport) buVar, view.getContext(), 2, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    aVar3.se().b(new a.C0098a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bt btVar, com.baidu.card.a<bu> aVar) {
        if (btVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        btVar.dLi.dJw = getPositionByType(i) + 1;
        aVar.se().setPosition(i);
        aVar.setVideoStatsData(ak(btVar.dLi));
        aVar.b((com.baidu.card.a<bu>) btVar.dLi);
        aVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.se().a(this.adX);
        com.baidu.tieba.homepage.tabfeed.b.a(btVar, this.mTabName);
        return aVar.getView();
    }

    private y ak(bu buVar) {
        y yVar = null;
        if (buVar != null) {
            yVar = new y();
            yVar.mLocate = "20";
            yVar.ajO = buVar.tid;
            yVar.mSource = buVar.mRecomSource;
            yVar.kVo = buVar.mRecomAbTag;
            yVar.kVp = buVar.mRecomWeight;
            yVar.kVq = "14";
            yVar.mGroupId = this.mTabName;
            yVar.mFloor = String.valueOf(buVar.dJw);
            if (buVar.aTF() != null) {
                yVar.dIK = String.valueOf(buVar.aTF().dPc);
            }
            if (buVar.aPS() != null) {
                yVar.eEs = String.valueOf(buVar.aPS().getFid());
                yVar.kVx = buVar.aPS().getNid();
                if (buVar.aPS().aSH() != null) {
                    yVar.kVt = buVar.aPS().aSH().video_md5;
                    yVar.kVv = String.valueOf(buVar.aPS().aSH().is_vertical);
                }
            }
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (buVar.aPS() != null && buVar.aPS().getBaijiahaoData() != null) {
                yVar.mNid = buVar.aPS().getBaijiahaoData().oriUgcNid;
                yVar.mVid = buVar.aPS().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }
}
