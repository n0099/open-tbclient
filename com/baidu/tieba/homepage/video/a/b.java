package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.am;
import com.baidu.card.b;
import com.baidu.card.g;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
import com.tencent.connect.common.Constants;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private aa<l> adt;
    private t aib;
    private BdUniqueId epM;
    private am gVA;
    private com.baidu.tieba.homepage.personalize.model.e idp;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gVA != null && this.gVA.rR() != null && this.gVA.rR().cQn() != null) {
            if (view.getId() == this.gVA.rR().cQn().getId()) {
                com.baidu.tieba.homepage.video.c.a.o(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.m(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.aOi() != null) {
                    b.this.a(view, lVar);
                    if (b.this.idp != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.en(com.baidu.adp.lib.f.b.toLong(lVar.aOi().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.em(com.baidu.adp.lib.f.b.toLong(lVar.aOi().getTid(), 0L));
                        b.this.idp.a(com.baidu.adp.lib.f.b.toLong(lVar.aOi().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bLz(), lVar.bLA(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.aOi().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(t tVar) {
        this.aib = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final g gVar = new g(this.mPageContext.getPageActivity());
            gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
                @Override // com.baidu.card.b.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (absThreadDataSupport != null) {
                        Rect aQ = au.aQ(gVar.getVideoContainer());
                        if (absThreadDataSupport instanceof l) {
                            absThreadDataSupport.objType = 5;
                            com.baidu.tieba.homepage.video.c.a.m((com.baidu.tieba.card.data.c) absThreadDataSupport);
                            com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, aQ);
                            return;
                        }
                        com.baidu.tieba.homepage.video.c.a.m((com.baidu.tieba.card.data.c) absThreadDataSupport);
                        com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, aQ);
                    }
                }
            });
            this.gVA = gVar;
        } else {
            this.gVA = new y(this.mPageContext.getPageActivity());
        }
        this.gVA.setPageUniqueId(this.epM);
        this.gVA.setFrom("video_tab");
        aVar.c(this.gVA);
        ae a = aVar.a(false, viewGroup, this.aib);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.epM);
        a.a(this.adt);
        a.setSourceForPb(19);
        a(new x() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof l) && (view.getTag() instanceof ag)) {
                    ag agVar = (ag) view.getTag();
                    l lVar = (l) oVar;
                    lVar.objType = 1;
                    if (b.this.adt != null) {
                        b.this.adt.a(agVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.f.a((t) viewGroup2, view, i));
                    agVar.rM().b(new a.C0097a(1));
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
        lVar.sr(lVar.position + 1);
        aVar.rM().setPosition(i);
        aVar.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.k(lVar);
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a(this.adt);
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            yVar.ais = lVar.tid;
            if (lVar.aOi() != null) {
                yVar.evm = String.valueOf(lVar.aOi().getFid());
                yVar.kAu = lVar.aOi().getNid();
                if (lVar.aOi().aQQ() != null) {
                    yVar.kAq = lVar.aOi().aQQ().video_md5;
                    yVar.kAs = String.valueOf(lVar.aOi().aQQ().is_vertical);
                }
            }
            yVar.dCp = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kAp = lVar.bLA();
            yVar.kAm = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bLz());
            if (lVar.aOi() != null && lVar.aOi().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aOi().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aOi().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.epM = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.idp = eVar;
    }

    public void onPause() {
        if (this.gVA != null) {
            this.gVA.onPause();
        }
    }
}
