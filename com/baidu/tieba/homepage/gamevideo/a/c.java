package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.al;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.z;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private z<l> acX;
    private r ahv;
    private int dDp;
    private BdUniqueId ebv;
    private al gGN;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gGN != null && this.gGN.rI() != null && this.gGN.rI().cJq() != null) {
            if (view.getId() == this.gGN.rI().cJq().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dDp);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dDp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.acX = new z<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, l lVar) {
                c.this.a(view, lVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(r rVar) {
        this.ahv = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        this.gGN = new x(this.mPageContext.getPageActivity());
        this.gGN.setPageUniqueId(this.ebv);
        this.gGN.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.c(this.gGN);
        ad a = aVar.a(false, viewGroup, this.ahv);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebv);
        a.a(this.acX);
        a.bc(18);
        a(new v() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (c.this.acX != null) {
                        c.this.acX.a(afVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar.rD().b(new a.C0074a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.card.a<l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.rN(lVar.position + 1);
        aVar.rD().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.dDp);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.acX);
        return aVar.getView();
    }

    private y c(l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "17";
            yVar.ahL = lVar.tid;
            if (lVar.aIw() != null) {
                yVar.eQf = String.valueOf(lVar.aIw().getFid());
                if (lVar.aIw().aKV() != null) {
                    yVar.kis = lVar.aIw().aKV().video_md5;
                    yVar.kiu = String.valueOf(lVar.aIw().aKV().is_vertical);
                }
            }
            yVar.dol = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kir = lVar.bFi();
            yVar.kio = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bFh());
            yVar.kiv = String.valueOf(this.dDp);
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ebv = bdUniqueId;
    }

    public void vQ(int i) {
        this.dDp = i;
    }

    public void onPause() {
        if (this.gGN != null) {
            this.gGN.onPause();
        }
    }
}
