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
public class ab extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.m, com.baidu.card.a<com.baidu.tieba.card.data.m>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.m> afE;
    private String aht;
    private com.baidu.adp.widget.ListView.v alC;
    private NEGFeedBackView.a fAU;
    public BdUniqueId fey;
    private at hXf;
    private com.baidu.tieba.homepage.personalize.model.e jlQ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.m mVar) {
        if (this.hXf != null && this.hXf.uc() != null && this.hXf.uc().drg() != null) {
            if (view.getId() == this.hXf.uc().drg().getId()) {
                com.baidu.tieba.homepage.personalize.c.a.a(mVar.eji, this.fey, mVar.ciV(), 4);
                TiebaStatic.log(mVar.cjo());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(mVar.ag(mVar.eji));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ab(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.fAU = null;
        this.afE = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.m>() { // from class: com.baidu.tieba.homepage.personalize.a.ab.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.m mVar) {
                com.baidu.tieba.card.s.ciJ().lm(true);
                com.baidu.tieba.a.d.bEz().dF("page_recommend", "show_");
                if (ab.this.jlQ != null && mVar != null && mVar.bfG() != null && !StringUtils.isNull(mVar.bfG().getTid())) {
                    if (mVar.bfG().erW > 0) {
                        TiebaStatic.log(mVar.ag(mVar.bfG()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fv(com.baidu.adp.lib.f.b.toLong(mVar.bfG().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fu(com.baidu.adp.lib.f.b.toLong(mVar.bfG().getTid(), 0L));
                        ab.this.jlQ.a(com.baidu.adp.lib.f.b.toLong(mVar.bfG().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.ciV(), mVar.ciW(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", mVar.bfG().getBaijiahaoData());
                    }
                    ab.this.a(view, mVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cDn();
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.alC = vVar;
    }

    private void cDn() {
        com.baidu.tieba.card.data.m.hIZ = "c10708";
        com.baidu.tieba.card.data.m.hJa = "c10735";
        com.baidu.tieba.card.data.m.hJs = "c10709";
        com.baidu.tieba.card.data.m.hIY = "c10734";
        com.baidu.tieba.card.data.m.hJt = "c11929";
        com.baidu.tieba.card.data.m.hJu = "c11928";
        com.baidu.tieba.card.data.m.hJv = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a<com.baidu.tieba.card.data.m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.personalize.a.ab.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bc = ay.bc(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.m)) {
                        ay.a(absThreadDataSupport, ab.this.mContext, 2, false, bc);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    ay.a(absThreadDataSupport, ab.this.mContext, 2, false, bc);
                }
            }
        });
        this.hXf = cVar;
        this.hXf.setPageUniqueId(this.fey);
        this.hXf.setFrom("index");
        this.hXf.setStageType("2001");
        aVar.c(this.hXf);
        ak a2 = aVar.a(false, viewGroup, this.alC);
        com.baidu.card.a<com.baidu.tieba.card.data.m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fey);
        a2.a(this.afE);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.personalize.a.ab.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.m) && (view.getTag() instanceof am)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    com.baidu.tieba.card.data.m mVar = (com.baidu.tieba.card.data.m) qVar;
                    mVar.objType = 1;
                    if (ab.this.afE != null) {
                        ab.this.afE.a(aVar3.getView(), mVar);
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
        mVar.wD(mVar.position + 1);
        aVar.tW().setPosition(i);
        mVar.sourceType = 0;
        com.baidu.tieba.card.s.ciJ().e(mVar.cjh());
        aVar.setVideoStatsData(c(mVar));
        if (aVar.tW() != null) {
            aVar.tW().setPage(this.aht);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afE);
        com.baidu.tieba.homepage.personalize.c.a.a(mVar.eji, this.fey, mVar.ciV());
        return aVar.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.m mVar) {
        com.baidu.tieba.play.o oVar = null;
        if (mVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.alS = mVar.tid;
            if (mVar.bfG() != null) {
                oVar.fkA = String.valueOf(mVar.bfG().getFid());
                oVar.lRD = mVar.bfG().getNid();
                if (mVar.bfG().biz() != null) {
                    oVar.lRz = mVar.bfG().biz().video_md5;
                    oVar.lRB = String.valueOf(mVar.bfG().biz().is_vertical);
                }
            }
            oVar.emE = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.lRy = mVar.ciW();
            oVar.lRv = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.ciV());
            if (mVar.bfG() != null && mVar.bfG().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bfG().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bfG().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jlQ = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Es(String str) {
        this.aht = str;
    }

    public void onResume() {
        if (this.hXf != null) {
            this.hXf.onResume();
        }
    }

    public void onPause() {
        if (this.hXf != null) {
            this.hXf.onPause();
        }
    }
}
