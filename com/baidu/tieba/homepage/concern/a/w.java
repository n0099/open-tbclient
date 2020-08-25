package com.baidu.tieba.homepage.concern.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.card.a.a;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes16.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.m> aeT;
    private String agH;
    private com.baidu.adp.widget.ListView.v akI;
    public BdUniqueId ePv;
    private as hBc;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.hBc != null && this.hBc.tW() != null && this.hBc.tW().djM() != null) {
            if (view.getId() == this.hBc.tW().djM().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, mVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, mVar, 2);
            }
        }
    }

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.concern.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.s.cbX().kK(true);
                com.baidu.tieba.a.d.bAA().dA("page_recommend", "show_");
                if (mVar != null && mVar.bce() != null && !StringUtils.isNull(mVar.bce().getTid())) {
                    if (mVar.bce().edC <= 0) {
                        w.this.a(view, mVar);
                    } else {
                        TiebaStatic.log(mVar.af(mVar.bce()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.akI = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.ePv);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.w.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aY = ay.aY(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, w.this.mContext, 1, false, aY);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, w.this.mContext, 1, false, aY);
                }
            }
        });
        this.hBc = cVar;
        aVar.c(this.hBc);
        if (this.hBc != null) {
            this.hBc.setStageType("2001");
        }
        aj a = aVar.a(false, viewGroup, this.akI);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ePv);
        a.a(this.aeT);
        a.setSourceForPb(1);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.a.w.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof al)) {
                    al alVar = (al) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (w.this.aeT != null) {
                        w.this.aeT.a(alVar.getView(), mVar);
                    }
                    ay.a((AbsThreadDataSupport) mVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    alVar.tR().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.m mVar, com.baidu.card.a<com.baidu.tieba.card.data.m> aVar) {
        if (mVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        mVar.vy(mVar.position + 1);
        com.baidu.tieba.card.s.cbX().e(mVar.He("c12351"));
        aVar.tR().setPosition(i);
        mVar.sourceType = 0;
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tR() instanceof com.baidu.tieba.a.e) {
            aVar.tR().setPage(this.agH);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.aeT);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.play.o oVar = null;
        if (mVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.akY = mVar.tid;
            if (mVar.bce() != null) {
                oVar.eVt = String.valueOf(mVar.bce().getFid());
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
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Dj(String str) {
        this.agH = str;
    }
}
