package com.baidu.tieba.homepage.concern.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.ar;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class w extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private aa<com.baidu.tieba.card.data.l> adX;
    private String afG;
    private com.baidu.adp.widget.ListView.v ajy;
    public BdUniqueId eyE;
    private ar hiC;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.hiC != null && this.hiC.sj() != null && this.hiC.sj().cUU() != null) {
            if (view.getId() == this.hiC.sj().cUU().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
            }
        }
    }

    public w(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new aa<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.s.bOA().jI(true);
                com.baidu.tieba.a.d.boA().dh("page_recommend", "show_");
                if (lVar != null && lVar.aPS() != null && !StringUtils.isNull(lVar.aPS().getTid())) {
                    if (lVar.aPS().dNV <= 0) {
                        w.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ai(lVar.aPS()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        this.ajy = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.c cVar = new com.baidu.tieba.homepage.personalize.view.c(this.mPageContext.getPageActivity());
        cVar.setPageUniqueId(this.eyE);
        cVar.setFrom("concern_tab");
        cVar.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.w.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect aQ = aw.aQ(cVar.getVideoContainer());
                    if (!(absThreadDataSupport instanceof com.baidu.tieba.card.data.l)) {
                        aw.a(absThreadDataSupport, w.this.mContext, 1, false, aQ);
                        return;
                    }
                    absThreadDataSupport.objType = 5;
                    aw.a(absThreadDataSupport, w.this.mContext, 1, false, aQ);
                }
            }
        });
        this.hiC = cVar;
        aVar.c(this.hiC);
        ai a = aVar.a(false, viewGroup, this.ajy);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eyE);
        a.a(this.adX);
        a.setSourceForPb(1);
        a(new z() { // from class: com.baidu.tieba.homepage.concern.a.w.3
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, com.baidu.adp.widget.ListView.q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof ak)) {
                    ak akVar = (ak) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) qVar;
                    lVar.objType = 1;
                    if (w.this.adX != null) {
                        w.this.adX.a(akVar.getView(), lVar);
                    }
                    aw.a((AbsThreadDataSupport) lVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.v) viewGroup2, view, i));
                    akVar.se().b(new a.C0098a(1));
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
        lVar.sR(lVar.position + 1);
        com.baidu.tieba.card.s.bOA().e(lVar.DU("c12351"));
        aVar.se().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.se() instanceof com.baidu.tieba.a.e) {
            aVar.se().setPage(this.afG);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.se().a(this.adX);
        return aVar.getView();
    }

    private y c(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.ajO = lVar.tid;
            if (lVar.aPS() != null) {
                yVar.eEs = String.valueOf(lVar.aPS().getFid());
                if (lVar.aPS().aSH() != null) {
                    yVar.kVt = lVar.aPS().aSH().video_md5;
                    yVar.kVv = String.valueOf(lVar.aPS().aSH().is_vertical);
                }
            }
            yVar.dIK = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kVs = lVar.bOM();
            yVar.kVp = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bOL());
        }
        return yVar;
    }

    @Override // com.baidu.tieba.a.f
    public void Ae(String str) {
        this.afG = str;
    }
}
