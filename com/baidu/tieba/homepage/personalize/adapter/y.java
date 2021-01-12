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
    private com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l> ago;
    private String air;
    private com.baidu.adp.widget.ListView.s amu;
    public BdUniqueId fEN;
    private NEGFeedBackView.a gbz;
    private as iIR;
    private com.baidu.tieba.homepage.personalize.model.e kbv;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.iIR != null && this.iIR.tt() != null && this.iIR.tt().dxG() != null) {
            if (view.getId() == this.iIR.tt().dxG().getId()) {
                com.baidu.tieba.homepage.personalize.a.a.a(lVar.eHK, this.fEN, lVar.crv(), 4);
                TiebaStatic.log(lVar.crN());
            } else if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(lVar.ai(lVar.eHK));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.gbz = null;
        this.ago = new com.baidu.tieba.card.aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.crj().mC(true);
                com.baidu.tieba.a.d.bKv().dQ("page_recommend", "show_");
                if (y.this.kbv != null && lVar != null && lVar.bkV() != null && !StringUtils.isNull(lVar.bkV().getTid())) {
                    if (lVar.bkV().eQO > 0) {
                        TiebaStatic.log(lVar.ai(lVar.bkV()));
                        return;
                    }
                    if ((view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(lVar.bkV().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(lVar.bkV().getTid(), 0L));
                        y.this.kbv.a(com.baidu.adp.lib.f.b.toLong(lVar.bkV().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.crv(), lVar.crw(), com.baidu.adp.lib.f.b.toInt((String) view.getTag(), 1), "homepage", lVar.bkV().getBaijiahaoData());
                    }
                    y.this.b(view, lVar);
                }
            }
        };
        this.mPageContext = tbPageContext;
        cNf();
    }

    public void a(com.baidu.adp.widget.ListView.s sVar) {
        this.amu = sVar;
    }

    private void cNf() {
        com.baidu.tieba.card.data.l.iuY = "c10708";
        com.baidu.tieba.card.data.l.iuZ = "c10735";
        com.baidu.tieba.card.data.l.ivo = "c10709";
        com.baidu.tieba.card.data.l.iuX = "c10734";
        com.baidu.tieba.card.data.l.ivp = "c11929";
        com.baidu.tieba.card.data.l.ivq = "c11928";
        com.baidu.tieba.card.data.l.ivr = "c10756";
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
        this.iIR = bVar;
        this.iIR.setPageUniqueId(this.fEN);
        this.iIR.setFrom("index");
        this.iIR.setStageType("2001");
        aVar.c(this.iIR);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amu);
        AutoVideoCardViewHolder<com.baidu.tieba.card.data.l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fEN);
        a2.a(this.ago);
        a2.setSourceForPb(2);
        a(new com.baidu.adp.widget.ListView.w() { // from class: com.baidu.tieba.homepage.personalize.adapter.y.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) nVar;
                    lVar.objType = 1;
                    if (y.this.ago != null) {
                        y.this.ago.a(autoVideoCardViewHolder2.getView(), lVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 2, false, com.baidu.card.e.a((com.baidu.adp.widget.ListView.s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.tm().b(new a.C0089a(1));
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
        lVar.wT(lVar.position + 1);
        autoVideoCardViewHolder.tm().setPosition(i);
        lVar.sourceType = 0;
        com.baidu.tieba.card.s.crj().e(lVar.crE());
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        if (autoVideoCardViewHolder.tm() != null) {
            autoVideoCardViewHolder.tm().setPage(this.air);
        }
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<com.baidu.tieba.card.data.l>) lVar);
        autoVideoCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tm().a(this.ago);
        com.baidu.tieba.homepage.personalize.a.a.a(lVar.eHK, this.fEN, lVar.crv());
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.o oVar = null;
        if (lVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "1";
            oVar.amM = lVar.tid;
            if (lVar.bkV() != null) {
                oVar.fKR = String.valueOf(lVar.bkV().getFid());
                oVar.mzg = lVar.bkV().blV();
                if (lVar.bkV().bnO() != null) {
                    oVar.mzc = lVar.bkV().bnO().video_md5;
                    oVar.mze = String.valueOf(lVar.bkV().bnO().is_vertical);
                }
            }
            oVar.eLs = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mzb = lVar.crw();
            oVar.myY = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.crv());
            if (lVar.bkV() != null && lVar.bkV().getBaijiahaoData() != null) {
                oVar.eRn = lVar.bkV().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bkV().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void a(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kbv = eVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ea(String str) {
        this.air = str;
    }

    public void onResume() {
        if (this.iIR != null) {
            this.iIR.onResume();
        }
    }

    public void onPause() {
        if (this.iIR != null) {
            this.iIR.onPause();
        }
    }
}
