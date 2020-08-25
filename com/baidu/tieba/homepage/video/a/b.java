package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.card.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes16.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private aa<m> aeT;
    private v akI;
    private BdUniqueId ePv;
    private as hBc;
    private com.baidu.tieba.homepage.personalize.model.e iOg;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.hBc != null && this.hBc.tW() != null && this.hBc.tW().djM() != null) {
            if (view.getId() == this.hBc.tW().djM().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(mVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new aa<m>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, m mVar) {
                if (view != null && mVar != null && mVar.bce() != null) {
                    b.this.a(view, mVar);
                    if (b.this.iOg != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.eP(com.baidu.adp.lib.f.b.toLong(mVar.bce().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.eO(com.baidu.adp.lib.f.b.toLong(mVar.bce().getTid(), 0L));
                        b.this.iOg.a(com.baidu.adp.lib.f.b.toLong(mVar.bce().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.ccj(), mVar.cck(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", mVar.bce().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.akI = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<m> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        final g gVar = new g(this.mPageContext.getPageActivity());
        gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aY = ay.aY(gVar.getVideoContainer());
                    if (absThreadDataSupport instanceof m) {
                        absThreadDataSupport.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                        com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, aY);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                    com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, aY);
                }
            }
        });
        this.hBc = gVar;
        this.hBc.setPageUniqueId(this.ePv);
        this.hBc.setFrom("video_tab");
        this.hBc.setStageType("2001");
        aVar.c(this.hBc);
        aj a = aVar.a(false, viewGroup, this.akI);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ePv);
        a.a(this.aeT);
        a.setSourceForPb(19);
        a(new ab() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof al)) {
                    al alVar = (al) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (b.this.aeT != null) {
                        b.this.aeT.a(alVar.getView(), mVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(mVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    alVar.tR().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.card.a<m> aVar) {
        if (mVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        mVar.vy(mVar.position + 1);
        aVar.tR().setPosition(i);
        aVar.setVideoStatsData(c(mVar));
        com.baidu.tieba.homepage.video.c.a.n(mVar);
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.aeT);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.akY = mVar.tid;
            if (mVar.bce() != null) {
                oVar.eVt = String.valueOf(mVar.bce().getFid());
                oVar.ltl = mVar.bce().getNid();
                if (mVar.bce().beW() != null) {
                    oVar.lth = mVar.bce().beW().video_md5;
                    oVar.ltj = String.valueOf(mVar.bce().beW().is_vertical);
                }
            }
            oVar.dYo = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.ltg = mVar.cck();
            oVar.ltd = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.ccj());
            if (mVar.bce() != null && mVar.bce().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bce().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bce().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ePv = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iOg = eVar;
    }

    public void onPause() {
        if (this.hBc != null) {
            this.hBc.onPause();
        }
    }
}
