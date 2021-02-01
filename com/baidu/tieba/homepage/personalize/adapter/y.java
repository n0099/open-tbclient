package com.baidu.tieba.homepage.personalize.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l> agg;
    private String aif;
    private com.baidu.adp.widget.ListView.s amk;
    public BdUniqueId fGZ;
    private NEGFeedBackView.a gdO;
    private as iOz;
    private com.baidu.tieba.homepage.personalize.model.e kjF;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iOz != null && this.iOz.tq() != null && this.iOz.tq().dzP() != null) {
            if (view.getId() == this.iOz.tq().dzP().getId()) {
                com.baidu.tieba.homepage.personalize.a.a.a(lVar.eJQ, this.fGZ, lVar.csH(), 4);
                TiebaStatic.log(lVar.csZ());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.aj(lVar.eJQ));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gdO = null;
        this.agg = new com.baidu.tieba.card.ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.t.csu().mG(true);
                com.baidu.tieba.a.d.bKP().dK("page_recommend", "show_");
                if (y.this.kjF != null && lVar != null && lVar.bln() != null && !StringUtils.isNull(lVar.bln().getTid())) {
                    if (lVar.bln().eTa > 0) {
                        TiebaStatic.log(lVar.aj(lVar.bln()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gF(com.baidu.adp.lib.f.b.toLong(lVar.bln().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gE(com.baidu.adp.lib.f.b.toLong(lVar.bln().getTid(), 0L));
                        y.this.kjF.a(com.baidu.adp.lib.f.b.toLong(lVar.bln().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.csH(), lVar.csI(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bln().getBaijiahaoData());
                    }
                    y.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cPb();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amk = sVar;
    }

    private void cPb() {
        com.baidu.tieba.card.data.l.iAI = "c10708";
        com.baidu.tieba.card.data.l.iAJ = "c10735";
        com.baidu.tieba.card.data.l.iAY = "c10709";
        com.baidu.tieba.card.data.l.iAH = "c10734";
        com.baidu.tieba.card.data.l.iAZ = "c11929";
        com.baidu.tieba.card.data.l.iBa = "c11928";
        com.baidu.tieba.card.data.l.iBb = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.b bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        bVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(bVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        az.a(aVar2, y.this.mContext, 2, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, y.this.mContext, 2, false, bs);
                }
            }
        });
        this.iOz = bVar;
        this.iOz.setPageUniqueId(this.fGZ);
        this.iOz.setFrom("index");
        this.iOz.setStageType("2001");
        aVar.c(this.iOz);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fGZ);
        a2.a(this.agg);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) nVar;
                    lVar.objType = 1;
                    if (y.this.agg != null) {
                        y.this.agg.a(autoVideoCardViewHolder2.getView(), lVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.tj().b(new a.C0089a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xd(lVar.position + 1);
        autoVideoCardViewHolder.tj().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.t.csu().e(lVar.csQ());
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        if (autoVideoCardViewHolder.tj() != null) {
            autoVideoCardViewHolder.tj().setPage(this.aif);
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.agg);
        com.baidu.tieba.homepage.personalize.a.a.a(lVar.eJQ, this.fGZ, lVar.csH());
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.amC = lVar.tid;
            if (lVar.bln() != null) {
                oVar.fNd = String.valueOf(lVar.bln().getFid());
                oVar.mIn = lVar.bln().bmo();
                if (lVar.bln().boh() != null) {
                    oVar.mIj = lVar.bln().boh().video_md5;
                    oVar.mIl = String.valueOf(lVar.bln().boh().is_vertical);
                }
            }
            oVar.eNE = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mIi = lVar.csI();
            oVar.mIf = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.csH());
            if (lVar.bln() != null && lVar.bln().getBaijiahaoData() != null) {
                oVar.eTz = lVar.bln().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bln().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kjF = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ey(String str) {
        this.aif = str;
    }

    public void onResume() {
        if (this.iOz != null) {
            this.iOz.onResume();
        }
    }

    public void onPause() {
        if (this.iOz != null) {
            this.iOz.onPause();
        }
    }
}
