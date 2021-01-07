package com.baidu.tieba.homepage.concern.adapter;

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
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes2.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> ahf;
    private String aji;
    private com.baidu.adp.widget.ListView.s anl;
    public BdUniqueId fJu;
    private as iNy;
    private BdUniqueId jXP;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iNy != null && this.iNy.tE() != null && this.iNy.tE().dBy() != null) {
            if (view.getId() == this.iNy.tE().dBy().getId()) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.c.a(view, lVar, 2);
            }
        }
    }

    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahf = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.adapter.x.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.cvb().mG(true);
                com.baidu.tieba.a.d.bOn().dR("page_recommend", "show_");
                if (lVar != null && lVar.boP() != null && !StringUtils.isNull(lVar.boP().getTid())) {
                    if (lVar.boP().eVz <= 0) {
                        x.this.b(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ai(lVar.boP()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
        this.jXP = bdUniqueId2;
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.anl = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> e(ViewGroup viewGroup) {
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder) {
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qn() {
        return this.jXP != null ? this.jXP : com.baidu.tieba.card.data.b.iyN;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qo() {
        return com.baidu.tieba.card.data.b.iyT;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qp() {
        return com.baidu.tieba.card.data.b.iyV;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public BdUniqueId qq() {
        return com.baidu.tieba.card.data.b.iyW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> c(ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.b bVar = new com.baidu.tieba.homepage.personalize.view.b(this.mPageContext.getPageActivity());
        bVar.setPageUniqueId(this.fJu);
        bVar.setFrom("concern_tab");
        bVar.a(new a.InterfaceC0089a() { // from class: com.baidu.tieba.homepage.concern.adapter.x.2
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bw = ay.bw(bVar.getVideoContainer());
                    if (!(aVar2 instanceof com.baidu.tieba.card.data.l)) {
                        ay.a(aVar2, x.this.mContext, 1, false, bw);
                        return;
                    }
                    aVar2.objType = 5;
                    ay.a(aVar2, x.this.mContext, 1, false, bw);
                }
            }
        });
        this.iNy = bVar;
        aVar.c(this.iNy);
        if (this.iNy != null) {
            this.iNy.setStageType("2001");
        }
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fJu);
        a2.a(this.ahf);
        a2.setSourceForPb(1);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.concern.adapter.x.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.adp.widget.ListView.g) && (view.getTag() instanceof ThreadCardViewHolder) && (((com.baidu.adp.widget.ListView.g) nVar).qx() instanceof com.baidu.tieba.card.data.l)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.l lVar2 = (com.baidu.tieba.card.data.l) ((com.baidu.adp.widget.ListView.g) nVar).qx();
                    lVar2.objType = 1;
                    if (x.this.ahf != null) {
                        x.this.ahf.a(threadCardViewHolder.getView(), lVar2);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) lVar2, view.getContext(), 1, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    threadCardViewHolder.ty().b(new a.C0090a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: b */
    public View c(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.yA(lVar.position + 1);
        com.baidu.tieba.card.s.cvb().e(lVar.Js("c12351"));
        autoVideoCardViewHolder.ty().setPosition(i);
        lVar.sourceType = 0;
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        if (autoVideoCardViewHolder.ty() instanceof com.baidu.tieba.a.e) {
            autoVideoCardViewHolder.ty().setPage(this.aji);
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        autoVideoCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.ty().a(this.ahf);
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.anD = lVar.tid;
            if (lVar.boP() != null) {
                oVar.fPy = String.valueOf(lVar.boP().getFid());
                if (lVar.boP().brI() != null) {
                    oVar.mDL = lVar.boP().brI().video_md5;
                    oVar.mDN = String.valueOf(lVar.boP().brI().is_vertical);
                }
            }
            oVar.eQd = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mDK = lVar.cvo();
            oVar.mDH = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.cvn());
        }
        return oVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Fl(String str) {
        this.aji = str;
    }
}
