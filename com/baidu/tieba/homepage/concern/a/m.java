package com.baidu.tieba.homepage.concern.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ac;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> VC;
    private String WN;
    private r YY;
    public BdUniqueId cxx;
    private ac gcM;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gcM != null && this.gcM.qU() != null && this.gcM.qU().cdO() != null) {
            if (view.getId() == this.gcM.qU().cdO().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VC = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                t.aZN().gS(true);
                com.baidu.tieba.a.d.aCF().bJ("page_recommend", "show_");
                if (lVar != null && lVar.acx() != null && !StringUtils.isNull(lVar.acx().getTid())) {
                    if (lVar.acx().bLO <= 0) {
                        m.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.X(lVar.acx()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.YY = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        this.gcM = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        this.gcM.setPageUniqueId(this.cxx);
        this.gcM.setFrom("concern_tab");
        aVar.b(this.gcM);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YY);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cxx);
        a.a(this.VC);
        a.bq(1);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.concern.a.m.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (m.this.VC != null) {
                        m.this.VC.a(zVar.getView(), lVar);
                    }
                    av.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 1, false);
                    zVar.qP().b(new a.C0038a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.pI(lVar.position + 1);
        t.aZN().c(lVar.vD("c12351"));
        aVar.qP().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.qP() instanceof com.baidu.tieba.a.e) {
            aVar.qP().setPage(this.WN);
        }
        aVar.a(lVar);
        aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qP().a(this.VC);
        return aVar.getView();
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.bWO = lVar.tid;
            if (lVar.acx() != null) {
                zVar.eFy = String.valueOf(lVar.acx().getFid());
                if (lVar.acx().aeO() != null) {
                    zVar.ixC = lVar.acx().aeO().video_md5;
                    zVar.ixE = String.valueOf(lVar.acx().aeO().is_vertical);
                }
            }
            zVar.bGR = lVar.baa();
            zVar.mSource = lVar.getSource();
            zVar.ixB = lVar.aZY();
            zVar.ixz = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aZX());
        }
        return zVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sm(String str) {
        this.WN = str;
    }
}
