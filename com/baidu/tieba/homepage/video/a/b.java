package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.card.g;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.z;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private z<l> acX;
    private r ahv;
    private BdUniqueId ebv;
    private al gGN;
    private com.baidu.tieba.homepage.personalize.model.e hOB;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gGN != null && this.gGN.rI() != null && this.gGN.rI().cJq() != null) {
            if (view.getId() == this.gGN.rI().cJq().getId()) {
                com.baidu.tieba.homepage.video.c.a.o(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.m(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acX = new z<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.aIw() != null) {
                    b.this.a(view, lVar);
                    if (b.this.hOB != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.el(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L));
                        b.this.hOB.a(com.baidu.adp.lib.f.b.toLong(lVar.aIw().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bFh(), lVar.bFi(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.aIw().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(r rVar) {
        this.ahv = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final g gVar = new g(this.mPageContext.getPageActivity());
            gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar2) {
                    if (aVar2 != null) {
                        Rect aQ = au.aQ(gVar.getVideoContainer());
                        if (aVar2 instanceof l) {
                            aVar2.objType = 5;
                            com.baidu.tieba.homepage.video.c.a.m((com.baidu.tieba.card.data.c) aVar2);
                            com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, aQ);
                            return;
                        }
                        com.baidu.tieba.homepage.video.c.a.m((com.baidu.tieba.card.data.c) aVar2);
                        com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, aQ);
                    }
                }
            });
            this.gGN = gVar;
        } else {
            this.gGN = new x(this.mPageContext.getPageActivity());
        }
        this.gGN.setPageUniqueId(this.ebv);
        this.gGN.setFrom("video_tab");
        aVar.c(this.gGN);
        ad a = aVar.a(false, viewGroup, this.ahv);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebv);
        a.a(this.acX);
        a.bc(19);
        a(new v() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (b.this.acX != null) {
                        b.this.acX.a(afVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar.rD().b(new a.C0074a(1));
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
        lVar.rN(lVar.position + 1);
        aVar.rD().setPosition(i);
        aVar.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.k(lVar);
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.acX);
        return aVar.getView();
    }

    private y c(l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            yVar.ahL = lVar.tid;
            if (lVar.aIw() != null) {
                yVar.eQf = String.valueOf(lVar.aIw().getFid());
                if (lVar.aIw().aKV() != null) {
                    yVar.kis = lVar.aIw().aKV().video_md5;
                    yVar.kiu = String.valueOf(lVar.aIw().aKV().is_vertical);
                }
            }
            yVar.dol = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kir = lVar.bFi();
            yVar.kio = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bFh());
            if (lVar.aIw() != null && lVar.aIw().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aIw().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aIw().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ebv = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.hOB = eVar;
    }

    public void onPause() {
        if (this.gGN != null) {
            this.gGN.onPause();
        }
    }
}
