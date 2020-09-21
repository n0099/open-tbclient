package com.baidu.tieba.homepage.concern.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.ab;
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
import com.baidu.tieba.card.aa;
/* loaded from: classes21.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.m> afn;
    private String ahc;
    private com.baidu.adp.widget.ListView.v alj;
    public BdUniqueId eSq;
    private at hIk;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.hIk != null && this.hIk.uc() != null && this.hIk.uc().dnv() != null) {
            if (view.getId() == this.hIk.uc().dnv().getId()) {
                com.baidu.tieba.homepage.concern.c.a(view, mVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.c.a(view, mVar, 2);
            }
        }
    }

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afn = new aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.concern.adapter.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.s.cfn().kO(true);
                com.baidu.tieba.a.d.bBN().dA("page_recommend", "show_");
                if (mVar != null && mVar.bcY() != null && !StringUtils.isNull(mVar.bcY().getTid())) {
                    if (mVar.bcY().efQ <= 0) {
                        x.this.a(view, mVar);
                    } else {
                        TiebaStatic.log(mVar.ag(mVar.bcY()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alj = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.eSq);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.adapter.x.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect ba = ay.ba(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, x.this.mContext, 1, false, ba);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, x.this.mContext, 1, false, ba);
                }
            }
        });
        this.hIk = cVar;
        aVar.c(this.hIk);
        if (this.hIk != null) {
            this.hIk.setStageType("2001");
        }
        ak a = aVar.a(false, viewGroup, this.alj);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eSq);
        a.a(this.afn);
        a.setSourceForPb(1);
        a(new ab() { // from class: com.baidu.tieba.homepage.concern.adapter.x.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (x.this.afn != null) {
                        x.this.afn.a(amVar.getView(), mVar);
                    }
                    ay.a((AbsThreadDataSupport) mVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0096a(1));
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
        mVar.vX(mVar.position + 1);
        com.baidu.tieba.card.s.cfn().e(mVar.HC("c12351"));
        aVar.tW().setPosition(i);
        mVar.sourceType = 0;
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tW() instanceof com.baidu.tieba.a.e) {
            aVar.tW().setPage(this.ahc);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afn);
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.play.o oVar = null;
        if (mVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.alA = mVar.tid;
            if (mVar.bcY() != null) {
                oVar.eYo = String.valueOf(mVar.bcY().getFid());
                if (mVar.bcY().bfQ() != null) {
                    oVar.lCk = mVar.bcY().bfQ().video_md5;
                    oVar.lCm = String.valueOf(mVar.bcY().bfQ().is_vertical);
                }
            }
            oVar.eaC = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.lCj = mVar.cfA();
            oVar.lCg = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.cfz());
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }
}
