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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class y extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> ahf;
    private String aji;
    private com.baidu.adp.widget.ListView.s anl;
    public BdUniqueId fJu;
    private NEGFeedBackView.a ggi;
    private as iNy;
    private com.baidu.tieba.homepage.personalize.model.e kgb;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iNy != null && this.iNy.tE() != null && this.iNy.tE().dBx() != null) {
            if (view.getId() == this.iNy.tE().dBx().getId()) {
                com.baidu.tieba.homepage.personalize.a.a.a(lVar.eMv, this.fJu, lVar.cvm(), 4);
                TiebaStatic.log(lVar.cvE());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ai(lVar.eMv));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ggi = null;
        this.ahf = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cva().mG(true);
                com.baidu.tieba.a.d.bOm().dR("page_recommend", "show_");
                if (y.this.kgb != null && lVar != null && lVar.boO() != null && !StringUtils.isNull(lVar.boO().getTid())) {
                    if (lVar.boO().eVz > 0) {
                        TiebaStatic.log(lVar.ai(lVar.boO()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(lVar.boO().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(lVar.boO().getTid(), 0L));
                        y.this.kgb.a(com.baidu.adp.lib.f.b.toLong(lVar.boO().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.cvm(), lVar.cvn(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.boO().getBaijiahaoData());
                    }
                    y.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cQW();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anl = sVar;
    }

    private void cQW() {
        com.baidu.tieba.card.data.l.izF = "c10708";
        com.baidu.tieba.card.data.l.izG = "c10735";
        com.baidu.tieba.card.data.l.izV = "c10709";
        com.baidu.tieba.card.data.l.izE = "c10734";
        com.baidu.tieba.card.data.l.izW = "c11929";
        com.baidu.tieba.card.data.l.izX = "c11928";
        com.baidu.tieba.card.data.l.izY = "c10756";
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.b bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        bVar.a(new a.InterfaceC0089a() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.2
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bw = ay.bw(bVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        ay.a(aVar2, y.this.mContext, 2, false, bw);
                        return;
                    }
                    aVar2.objType = 5;
                    ay.a(aVar2, y.this.mContext, 2, false, bw);
                }
            }
        });
        this.iNy = bVar;
        this.iNy.setPageUniqueId(this.fJu);
        this.iNy.setFrom("index");
        this.iNy.setStageType("2001");
        aVar.c(this.iNy);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fJu);
        a2.a(this.ahf);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) nVar;
                    lVar.objType = 1;
                    if (y.this.ahf != null) {
                        y.this.ahf.a(autoVideoCardViewHolder2.getView(), lVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.ty().b(new a.C0090a(1));
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
        lVar.yA(lVar.position + 1);
        autoVideoCardViewHolder.ty().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.s.cva().e(lVar.cvv());
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        if (autoVideoCardViewHolder.ty() != null) {
            autoVideoCardViewHolder.ty().setPage(this.aji);
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        autoVideoCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.ty().a(this.ahf);
        com.baidu.tieba.homepage.personalize.a.a.a(lVar.eMv, this.fJu, lVar.cvm());
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.anD = lVar.tid;
            if (lVar.boO() != null) {
                oVar.fPy = String.valueOf(lVar.boO().getFid());
                oVar.mDQ = lVar.boO().bpO();
                if (lVar.boO().brH() != null) {
                    oVar.mDM = lVar.boO().brH().video_md5;
                    oVar.mDO = String.valueOf(lVar.boO().brH().is_vertical);
                }
            }
            oVar.eQd = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mDL = lVar.cvn();
            oVar.mDI = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.cvm());
            if (lVar.boO() != null && lVar.boO().getBaijiahaoData() != null) {
                oVar.eVY = lVar.boO().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.boO().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kgb = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fm(String str) {
        this.aji = str;
    }

    public void onResume() {
        if (this.iNy != null) {
            this.iNy.onResume();
        }
    }

    public void onPause() {
        if (this.iNy != null) {
            this.iNy.onPause();
        }
    }
}
