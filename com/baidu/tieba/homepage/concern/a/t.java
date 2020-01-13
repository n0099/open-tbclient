package com.baidu.tieba.homepage.concern.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.play.y;
/* loaded from: classes7.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, com.baidu.card.a<com.baidu.tieba.card.data.l>> implements com.baidu.tieba.a.f {
    private z<com.baidu.tieba.card.data.l> JE;
    private String Lg;
    private com.baidu.adp.widget.ListView.r Oq;
    public BdUniqueId dxg;
    private al gVS;
    private TbPageContext<?> mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, com.baidu.tieba.card.data.l lVar) {
        if (this.gVS != null && this.gVS.mY() != null && this.gVS.mY().cwU() != null) {
            if (view.getId() == this.gVS.mY().cwU().getId()) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 4);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.concern.b.a(view, lVar, 2);
            }
        }
    }

    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JE = new z<com.baidu.tieba.card.data.l>() { // from class: com.baidu.tieba.homepage.concern.a.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, com.baidu.tieba.card.data.l lVar) {
                com.baidu.tieba.card.r.btA().hU(true);
                com.baidu.tieba.a.d.aVo().cm("page_recommend", "show_");
                if (lVar != null && lVar.axQ() != null && !StringUtils.isNull(lVar.axQ().getTid())) {
                    if (lVar.axQ().cPL <= 0) {
                        t.this.a(view, lVar);
                    } else {
                        TiebaStatic.log(lVar.ae(lVar.axQ()));
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(com.baidu.adp.widget.ListView.r rVar) {
        this.Oq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<com.baidu.tieba.card.data.l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.tieba.homepage.personalize.view.a aVar2 = new com.baidu.tieba.homepage.personalize.view.a(this.mPageContext.getPageActivity());
        aVar2.setPageUniqueId(this.dxg);
        aVar2.setFrom("concern_tab");
        aVar2.a(new b.a() { // from class: com.baidu.tieba.homepage.concern.a.t.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar3) {
                if (aVar3 != null) {
                    Rect aP = au.aP(aVar2.getVideoContainer());
                    if (!(aVar3 instanceof com.baidu.tieba.card.data.l)) {
                        au.a(aVar3, t.this.mContext, 1, false, aP);
                        return;
                    }
                    aVar3.objType = 5;
                    au.a(aVar3, t.this.mContext, 1, false, aP);
                }
            }
        });
        this.gVS = aVar2;
        aVar.c(this.gVS);
        ad a = aVar.a(false, viewGroup, this.Oq);
        com.baidu.card.a<com.baidu.tieba.card.data.l> aVar3 = new com.baidu.card.a<>(a);
        aVar3.setPageId(this.dxg);
        a.a(this.JE);
        a.aM(1);
        a(new com.baidu.adp.widget.ListView.s() { // from class: com.baidu.tieba.homepage.concern.a.t.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, com.baidu.adp.widget.ListView.m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof com.baidu.tieba.card.data.l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    com.baidu.tieba.card.data.l lVar = (com.baidu.tieba.card.data.l) mVar;
                    lVar.objType = 1;
                    if (t.this.JE != null) {
                        t.this.JE.a(afVar.getView(), lVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) lVar, view.getContext(), 1, false, com.baidu.card.f.a((com.baidu.adp.widget.ListView.r) viewGroup2, view, i));
                    afVar.mU().b(new a.C0050a(1));
                }
            }
        });
        return aVar3;
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
        lVar.rm(lVar.position + 1);
        com.baidu.tieba.card.r.btA().c(lVar.zI("c12351"));
        aVar.mU().setPosition(i);
        lVar.sourceType = 0;
        aVar.setVideoStatsData(c(lVar));
        if (aVar.mU() instanceof com.baidu.tieba.a.e) {
            aVar.mU().setPage(this.Lg);
        }
        aVar.b((com.baidu.card.a<com.baidu.tieba.card.data.l>) lVar);
        aVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mU().a(this.JE);
        return aVar.getView();
    }

    private y c(com.baidu.tieba.card.data.l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "1";
            yVar.OG = lVar.tid;
            if (lVar.axQ() != null) {
                yVar.fKa = String.valueOf(lVar.axQ().getFid());
                if (lVar.axQ().aAo() != null) {
                    yVar.jvN = lVar.axQ().aAo().video_md5;
                    yVar.jvP = String.valueOf(lVar.axQ().aAo().is_vertical);
                }
            }
            yVar.cKN = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.btL();
            yVar.jvK = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.btK());
        }
        return yVar;
    }

    @Override // com.baidu.tieba.a.f
    public void wu(String str) {
        this.Lg = str;
    }
}
