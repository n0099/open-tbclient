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
    private ab<com.baidu.tieba.card.data.l> EP;
    private String Gc;
    private r Iu;
    public BdUniqueId cJo;
    private ac gdZ;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gdZ != null && this.gdZ.ma() != null && this.gdZ.ma().cbV() != null) {
            if (view.getId() == this.gdZ.ma().cbV().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, false);
            }
        }
    }

    public m(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.EP = new ab<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.m.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                t.bau().gF(true);
                com.baidu.tieba.a.d.aDc().bO("page_recommend", "show_");
                if (lVar != null && lVar.agG() != null && !StringUtils.isNull(lVar.agG().getTid())) {
                    if (lVar.agG().cdj <= 0) {
                        m.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.X(lVar.agG()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.Iu = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        this.gdZ = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        this.gdZ.setPageUniqueId(this.cJo);
        this.gdZ.setFrom("concern_tab");
        aVar.b(this.gdZ);
        x a = aVar.a(false, viewGroup, this.Iu);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cJo);
        a.b(this.EP);
        a.aF(1);
        a(new s() { // from class: com.baidu.tieba.homepage.concern.a.m.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (m.this.EP != null) {
                        m.this.EP.a(zVar.getView(), lVar);
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
        lVar.oO(lVar.position + 1);
        t.bau().c(lVar.uF("c12351"));
        aVar.lV().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.lV() instanceof com.baidu.tieba.a.e) {
            aVar.lV().setPage(this.Gc);
        }
        aVar.a(lVar);
        aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.lV().b(this.EP);
        return aVar.getView();
    }

    private com.baidu.tieba.play.z c(com.baidu.tieba.card.data.l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = "1";
            zVar.cma = lVar.tid;
            if (lVar.agG() != null) {
                zVar.ePc = String.valueOf(lVar.agG().getFid());
                if (lVar.agG().aiV() != null) {
                    zVar.iyn = lVar.agG().aiV().video_md5;
                    zVar.iyp = String.valueOf(lVar.agG().aiV().is_vertical);
                }
            }
            zVar.bYk = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.iym = lVar.baF();
            zVar.iyk = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baE());
        }
        return zVar;
    }

    @Override // com.baidu.tieba.a.f
    public void rh(String str) {
        this.Gc = str;
    }
}
