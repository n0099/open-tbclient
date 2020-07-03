package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.ar;
import com.baidu.card.b;
import com.baidu.card.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private aa<l> adX;
    private v ajy;
    private BdUniqueId eyE;
    private ar hiC;
    private com.baidu.tieba.homepage.personalize.model.e iti;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.hiC != null && this.hiC.sj() != null && this.hiC.sj().cUU() != null) {
            if (view.getId() == this.hiC.sj().cUU().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new aa<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.aPS() != null) {
                    b.this.a(view, lVar);
                    if (b.this.iti != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eq(com.baidu.adp.lib.f.b.toLong(lVar.aPS().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.ep(com.baidu.adp.lib.f.b.toLong(lVar.aPS().getTid(), 0L));
                        b.this.iti.a(com.baidu.adp.lib.f.b.toLong(lVar.aPS().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bOL(), lVar.bOM(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.aPS().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final g gVar = new g(this.mPageContext.getPageActivity());
        gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = aw.aQ(gVar.getVideoContainer());
                    if (absThreadDataSupport instanceof l) {
                        absThreadDataSupport.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                        com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, aQ);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                    com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, aQ);
                }
            }
        });
        this.hiC = gVar;
        this.hiC.setPageUniqueId(this.eyE);
        this.hiC.setFrom("video_tab");
        aVar.c(this.hiC);
        ai a = aVar.a(false, viewGroup, this.ajy);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eyE);
        a.a(this.adX);
        a.setSourceForPb(19);
        a(new z() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof ak)) {
                    ak akVar = (ak) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (b.this.adX != null) {
                        b.this.adX.a(akVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    akVar.se().b(new a.C0098a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.card.a<l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.sR(lVar.position + 1);
        aVar.se().setPosition(i);
        aVar.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.n(lVar);
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.se().a(this.adX);
        return aVar.getView();
    }

    private y c(l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            yVar.ajO = lVar.tid;
            if (lVar.aPS() != null) {
                yVar.eEs = String.valueOf(lVar.aPS().getFid());
                yVar.kVx = lVar.aPS().getNid();
                if (lVar.aPS().aSH() != null) {
                    yVar.kVt = lVar.aPS().aSH().video_md5;
                    yVar.kVv = String.valueOf(lVar.aPS().aSH().is_vertical);
                }
            }
            yVar.dIK = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kVs = lVar.bOM();
            yVar.kVp = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bOL());
            if (lVar.aPS() != null && lVar.aPS().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aPS().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aPS().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eyE = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iti = eVar;
    }

    public void onPause() {
        if (this.hiC != null) {
            this.hiC.onPause();
        }
    }
}
