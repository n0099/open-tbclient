package com.baidu.tieba.homepage.personalize.a;

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
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.m> afn;
    private String ahc;
    private com.baidu.adp.widget.ListView.v alj;
    public BdUniqueId eSq;
    private NEGFeedBackView.a foG;
    private at hIk;
    private com.baidu.tieba.homepage.personalize.model.e iWS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.hIk != null && this.hIk.uc() != null && this.hIk.uc().dnv() != null) {
            if (view.getId() == this.hIk.uc().dnv().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(mVar.dXg, this.eSq, mVar.cfz(), 4);
                TiebaStatic.log(mVar.cfS());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(mVar.ag(mVar.dXg));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.foG = null;
        this.afn = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.s.cfn().kO(true);
                com.baidu.tieba.a.d.bBN().dA("page_recommend", "show_");
                if (ab.this.iWS != null && mVar != null && mVar.bcY() != null && !StringUtils.isNull(mVar.bcY().getTid())) {
                    if (mVar.bcY().efQ > 0) {
                        TiebaStatic.log(mVar.ag(mVar.bcY()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fd(com.baidu.adp.lib.f.b.toLong(mVar.bcY().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fc(com.baidu.adp.lib.f.b.toLong(mVar.bcY().getTid(), 0L));
                        ab.this.iWS.a(com.baidu.adp.lib.f.b.toLong(mVar.bcY().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.cfz(), mVar.cfA(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", mVar.bcY().getBaijiahaoData());
                    }
                    ab.this.a(view, mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        czJ();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alj = vVar;
    }

    private void czJ() {
        com.baidu.tieba.card.data.m.hue = "c10708";
        com.baidu.tieba.card.data.m.huf = "c10735";
        com.baidu.tieba.card.data.m.hux = "c10709";
        com.baidu.tieba.card.data.m.hud = "c10734";
        com.baidu.tieba.card.data.m.huy = "c11929";
        com.baidu.tieba.card.data.m.huz = "c11928";
        com.baidu.tieba.card.data.m.huA = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect ba = ay.ba(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, 2, false, ba);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, 2, false, ba);
                }
            }
        });
        this.hIk = cVar;
        this.hIk.setPageUniqueId(this.eSq);
        this.hIk.setFrom("index");
        this.hIk.setStageType("2001");
        aVar.c(this.hIk);
        ak a = aVar.a(false, viewGroup, this.alj);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eSq);
        a.a(this.afn);
        a.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (ab.this.afn != null) {
                        ab.this.afn.a(aVar3.getView(), mVar);
                    }
                    ay.a((AbsThreadDataSupport) mVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.tW().b(new a.C0096a(1));
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
        aVar.tW().setPosition(i);
        mVar.sourceType = 0;
        com.baidu.tieba.card.s.cfn().e(mVar.cfL());
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tW() != null) {
            aVar.tW().setPage(this.ahc);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afn);
        com.baidu.tieba.homepage.personalize.c.a.a(mVar.dXg, this.eSq, mVar.cfz());
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
                oVar.lCo = mVar.bcY().getNid();
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
            if (mVar.bcY() != null && mVar.bcY().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bcY().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bcY().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iWS = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void DH(String str) {
        this.ahc = str;
    }

    public void onResume() {
        if (this.hIk != null) {
            this.hIk.onResume();
        }
    }

    public void onPause() {
        if (this.hIk != null) {
            this.hIk.onPause();
        }
    }
}
