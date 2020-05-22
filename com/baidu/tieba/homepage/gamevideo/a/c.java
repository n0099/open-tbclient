package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.am;
import com.baidu.card.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private aa<l> adt;
    private t aib;
    private int dRA;
    private BdUniqueId epM;
    private am gVA;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gVA != null && this.gVA.rR() != null && this.gVA.rR().cQn() != null) {
            if (view.getId() == this.gVA.rR().cQn().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dRA);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dRA);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, l lVar) {
                c.this.a(view, lVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(t tVar) {
        this.aib = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        this.gVA = new y(this.mPageContext.getPageActivity());
        this.gVA.setPageUniqueId(this.epM);
        this.gVA.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.c(this.gVA);
        ae a = aVar.a(false, viewGroup, this.aib);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.epM);
        a.a(this.adt);
        a.setSourceForPb(18);
        a(new x() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof l) && (view.getTag() instanceof ag)) {
                    ag agVar = (ag) view.getTag();
                    l lVar = (l) oVar;
                    lVar.objType = 1;
                    if (c.this.adt != null) {
                        c.this.adt.a(agVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((t) viewGroup2, view, i));
                    agVar.rM().b(new a.C0097a(1));
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
        lVar.sr(lVar.position + 1);
        aVar.rM().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.dRA);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a(this.adt);
        return aVar.getView();
    }

    private com.baidu.tieba.play.y c(l lVar) {
        com.baidu.tieba.play.y yVar = null;
        if (lVar != null) {
            yVar = new com.baidu.tieba.play.y();
            yVar.mLocate = "17";
            yVar.ais = lVar.tid;
            if (lVar.aOi() != null) {
                yVar.evm = String.valueOf(lVar.aOi().getFid());
                if (lVar.aOi().aQQ() != null) {
                    yVar.kAq = lVar.aOi().aQQ().video_md5;
                    yVar.kAs = String.valueOf(lVar.aOi().aQQ().is_vertical);
                }
            }
            yVar.dCp = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.kAp = lVar.bLA();
            yVar.kAm = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bLz());
            yVar.kAt = String.valueOf(this.dRA);
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.epM = bdUniqueId;
    }

    public void ww(int i) {
        this.dRA = i;
    }

    public void onPause() {
        if (this.gVA != null) {
            this.gVA.onPause();
        }
    }
}
