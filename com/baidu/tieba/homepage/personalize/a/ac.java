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
/* loaded from: classes22.dex */
public class ac extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.m> afF;
    private String ahu;
    private com.baidu.adp.widget.ListView.v alD;
    private NEGFeedBackView.a fJp;
    public BdUniqueId fmX;
    private at ijF;
    private com.baidu.tieba.homepage.personalize.model.e jyq;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.ijF != null && this.ijF.uc() != null && this.ijF.uc().dun() != null) {
            if (view.getId() == this.ijF.uc().dun().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(mVar.erH, this.fmX, mVar.cmc(), 4);
                TiebaStatic.log(mVar.cmv());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(mVar.ag(mVar.erH));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ac(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fJp = null;
        this.afF = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.a.ac.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.t.clQ().lE(true);
                com.baidu.tieba.a.d.bGs().dM("page_recommend", "show_");
                if (ac.this.jyq != null && mVar != null && mVar.bhz() != null && !StringUtils.isNull(mVar.bhz().getTid())) {
                    if (mVar.bhz().eAw > 0) {
                        TiebaStatic.log(mVar.ag(mVar.bhz()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fw(com.baidu.adp.lib.f.b.toLong(mVar.bhz().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fv(com.baidu.adp.lib.f.b.toLong(mVar.bhz().getTid(), 0L));
                        ac.this.jyq.a(com.baidu.adp.lib.f.b.toLong(mVar.bhz().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.cmc(), mVar.cmd(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", mVar.bhz().getBaijiahaoData());
                    }
                    ac.this.a(view, mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cGu();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alD = vVar;
    }

    private void cGu() {
        com.baidu.tieba.card.data.m.hVw = "c10708";
        com.baidu.tieba.card.data.m.hVx = "c10735";
        com.baidu.tieba.card.data.m.hVP = "c10709";
        com.baidu.tieba.card.data.m.hVv = "c10734";
        com.baidu.tieba.card.data.m.hVQ = "c11929";
        com.baidu.tieba.card.data.m.hVR = "c11928";
        com.baidu.tieba.card.data.m.hVS = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ac.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bd = ay.bd(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, ac.this.mContext, 2, false, bd);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ac.this.mContext, 2, false, bd);
                }
            }
        });
        this.ijF = cVar;
        this.ijF.setPageUniqueId(this.fmX);
        this.ijF.setFrom("index");
        this.ijF.setStageType("2001");
        aVar.c(this.ijF);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fmX);
        a2.a(this.afF);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ac.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (ac.this.afF != null) {
                        ac.this.afF.a(aVar3.getView(), mVar);
                    }
                    ay.a((AbsThreadDataSupport) mVar, view.getContext(), 2, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    aVar3.tW().b(new a.C0097a(1));
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
        mVar.wW(mVar.position + 1);
        aVar.tW().setPosition(i);
        mVar.sourceType = 0;
        com.baidu.tieba.card.t.clQ().e(mVar.cmo());
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tW() != null) {
            aVar.tW().setPage(this.ahu);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afF);
        com.baidu.tieba.homepage.personalize.c.a.a(mVar.erH, this.fmX, mVar.cmc());
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.play.o oVar = null;
        if (mVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.alT = mVar.tid;
            if (mVar.bhz() != null) {
                oVar.fsZ = String.valueOf(mVar.bhz().getFid());
                oVar.meb = mVar.bhz().getNid();
                if (mVar.bhz().bks() != null) {
                    oVar.mdX = mVar.bhz().bks().video_md5;
                    oVar.mdZ = String.valueOf(mVar.bhz().bks().is_vertical);
                }
            }
            oVar.eve = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.mdW = mVar.cmd();
            oVar.mdT = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.cmc());
            if (mVar.bhz() != null && mVar.bhz().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bhz().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bhz().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jyq = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void EL(String str) {
        this.ahu = str;
    }

    public void onResume() {
        if (this.ijF != null) {
            this.ijF.onResume();
        }
    }

    public void onPause() {
        if (this.ijF != null) {
            this.ijF.onPause();
        }
    }
}
