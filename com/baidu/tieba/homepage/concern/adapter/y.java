package com.baidu.tieba.homepage.concern.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.m> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    public BdUniqueId fsQ;
    private at ipE;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.ipE != null && this.ipE.uc() != null && this.ipE.uc().dwP() != null) {
            if (view.getId() == this.ipE.uc().dwP().getId()) {
                com.baidu.tieba.homepage.concern.c.a(view, mVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.c.a(view, mVar, 2);
            }
        }
    }

    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.concern.adapter.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.t.cor().lN(true);
                com.baidu.tieba.a.d.bIR().dM("page_recommend", "show_");
                if (mVar != null && mVar.bjZ() != null && !StringUtils.isNull(mVar.bjZ().getTid())) {
                    if (mVar.bjZ().eGl <= 0) {
                        y.this.a(view, mVar);
                    } else {
                        TiebaStatic.log(mVar.ag(mVar.bjZ()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.fsQ);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.y.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bh = ay.bh(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, y.this.mContext, 1, false, bh);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, y.this.mContext, 1, false, bh);
                }
            }
        });
        this.ipE = cVar;
        aVar.c(this.ipE);
        if (this.ipE != null) {
            this.ipE.setStageType("2001");
        }
        ak a2 = aVar.a(false, viewGroup, this.alD);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsQ);
        a2.a(this.afF);
        a2.setSourceForPb(1);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.concern.adapter.y.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (y.this.afF != null) {
                        y.this.afF.a(amVar.getView(), mVar);
                    }
                    ay.a((AbsThreadDataSupport) mVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0097a(1));
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
        mVar.xj(mVar.position + 1);
        com.baidu.tieba.card.t.cor().e(mVar.Jf("c12351"));
        aVar.tW().setPosition(i);
        mVar.sourceType = 0;
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tW() instanceof com.baidu.tieba.a.e) {
            aVar.tW().setPage(this.ahu);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afF);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.play.o oVar = null;
        if (mVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.alT = mVar.tid;
            if (mVar.bjZ() != null) {
                oVar.fyR = String.valueOf(mVar.bjZ().getFid());
                if (mVar.bjZ().bmS() != null) {
                    oVar.mjW = mVar.bjZ().bmS().video_md5;
                    oVar.mjY = String.valueOf(mVar.bjZ().bmS().is_vertical);
                }
            }
            oVar.eAX = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.mjV = mVar.coE();
            oVar.mjS = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.coD());
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EZ(String str) {
        this.ahu = str;
    }
}
