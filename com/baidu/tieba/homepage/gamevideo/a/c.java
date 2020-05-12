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
    private z<l> ada;
    private r ahy;
    private int dDt;
    private BdUniqueId ebA;
    private al gGT;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gGT != null && this.gGT.rI() != null && this.gGT.rI().cJo() != null) {
            if (view.getId() == this.gGT.rI().cJo().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dDt);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dDt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ada = new z<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
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
        this.ahy = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        this.gGT = new x(this.mPageContext.getPageActivity());
        this.gGT.setPageUniqueId(this.ebA);
        this.gGT.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.c(this.gGT);
        ad a = aVar.a(false, viewGroup, this.ahy);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebA);
        a.a(this.ada);
        a.bc(18);
        a(new v() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (c.this.ada != null) {
                        c.this.ada.a(afVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar.rD().b(new a.C0095a(1));
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
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.dDt);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.ada);
        return aVar.getView();
    }

    private y c(l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "17";
            yVar.ahO = lVar.tid;
            if (lVar.aIu() != null) {
                yVar.eQk = String.valueOf(lVar.aIu().getFid());
                if (lVar.aIu().aKT() != null) {
                    yVar.kiw = lVar.aIu().aKT().video_md5;
                    yVar.kiy = String.valueOf(lVar.aIu().aKT().is_vertical);
                }
            }
            yVar.dop = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kiv = lVar.bFh();
            yVar.kis = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bFg());
            yVar.kiz = String.valueOf(this.dDt);
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ebA = bdUniqueId;
    }

    public void vQ(int i) {
        this.dDt = i;
    }

    public void onPause() {
        if (this.gGT != null) {
            this.gGT.onPause();
        }
    }
}
