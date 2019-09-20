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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.t;
/* loaded from: classes4.dex */
public class m extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private ab<com.baidu.tieba.card.data.l> VB;
    private String WM;
    private r YY;
    public BdUniqueId cyA;
    private ac gfu;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gfu != null && this.gfu.qV() != null && this.gfu.qV().ceV() != null) {
            if (view.getId() == this.gfu.qV().ceV().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VB = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                t.bat().gV(true);
                com.baidu.tieba.a.d.aCV().bJ("page_recommend", "show_");
                if (lVar != null && lVar.acC() != null && !StringUtils.isNull(lVar.acC().getTid())) {
                    if (lVar.acC().bMr <= 0) {
                        m.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.Z(lVar.acC()));
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
        this.gfu = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        this.gfu.setPageUniqueId(this.cyA);
        this.gfu.setFrom("concern_tab");
        aVar.b(this.gfu);
        x a = aVar.a(false, viewGroup, this.YY);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cyA);
        a.a(this.VB);
        a.bq(1);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.concern.a.m.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (m.this.VB != null) {
                        m.this.VB.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 1, false);
                    zVar.qQ().b(new a.C0038a(1));
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
        lVar.pN(lVar.position + 1);
        t.bat().c(lVar.wd("c12351"));
        aVar.qQ().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.qQ() instanceof com.baidu.tieba.a.e) {
            aVar.qQ().setPage(this.WM);
        }
        aVar.a(lVar);
        aVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qQ().a(this.VB);
        return aVar.getView();
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.bXN = lVar.tid;
            if (lVar.acC() != null) {
                zVar.eHo = String.valueOf(lVar.acC().getFid());
                if (lVar.acC().aeT() != null) {
                    zVar.iAH = lVar.acC().aeT().video_md5;
                    zVar.iAJ = String.valueOf(lVar.acC().aeT().is_vertical);
                }
            }
            zVar.bHq = lVar.baG();
            zVar.mSource = lVar.getSource();
            zVar.iAG = lVar.baE();
            zVar.iAE = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baD());
        }
        return zVar;
    }

    @Override // com.baidu.tieba.a.f
    public void sy(String str) {
        this.WM = str;
    }
}
