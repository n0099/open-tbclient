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
    private ab<com.baidu.tieba.card.data.l> Fq;
    private String GC;
    private r IY;
    public BdUniqueId cKf;
    private ac geR;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.geR != null && this.geR.ma() != null && this.geR.ma().cbX() != null) {
            if (view.getId() == this.geR.ma().cbX().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Fq = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                t.baw().gF(true);
                com.baidu.tieba.a.d.aDe().bO("page_recommend", "show_");
                if (lVar != null && lVar.agI() != null && !StringUtils.isNull(lVar.agI().getTid())) {
                    if (lVar.agI().cea <= 0) {
                        m.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.X(lVar.agI()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.IY = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        this.geR = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        this.geR.setPageUniqueId(this.cKf);
        this.geR.setFrom("concern_tab");
        aVar.b(this.geR);
        x a = aVar.a(false, viewGroup, this.IY);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cKf);
        a.b(this.Fq);
        a.aF(1);
        a(new s() { // from class: com.baidu.tieba.homepage.concern.a.m.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (m.this.Fq != null) {
                        m.this.Fq.a(zVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 1, false);
                    zVar.lV().b(new a.C0044a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, com.baidu.card.a<com.baidu.tieba.card.data.l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.oP(lVar.position + 1);
        t.baw().c(lVar.uF("c12351"));
        aVar.lV().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.lV() instanceof com.baidu.tieba.a.e) {
            aVar.lV().setPage(this.GC);
        }
        aVar.a(lVar);
        aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.lV().b(this.Fq);
        return aVar.getView();
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.cmS = lVar.tid;
            if (lVar.agI() != null) {
                zVar.ePT = String.valueOf(lVar.agI().getFid());
                if (lVar.agI().aiX() != null) {
                    zVar.ize = lVar.agI().aiX().video_md5;
                    zVar.izg = String.valueOf(lVar.agI().aiX().is_vertical);
                }
            }
            zVar.bZb = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.izd = lVar.baH();
            zVar.izb = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baG());
        }
        return zVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.GC = str;
    }
}
