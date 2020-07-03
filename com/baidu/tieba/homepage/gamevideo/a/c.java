package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.adp.widget.ListView.z;
import com.baidu.card.a.a;
import com.baidu.card.ai;
import com.baidu.card.ak;
import com.baidu.card.ar;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private aa<l> adX;
    private v ajy;
    private int dYs;
    private BdUniqueId eyE;
    private ar hiC;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.hiC != null && this.hiC.sj() != null && this.hiC.sj().cUU() != null) {
            if (view.getId() == this.hiC.sj().cUU().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dYs);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.dYs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adX = new aa<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, l lVar) {
                c.this.a(view, lVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.ajy = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        this.hiC = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        this.hiC.setPageUniqueId(this.eyE);
        this.hiC.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.c(this.hiC);
        ai a = aVar.a(false, viewGroup, this.ajy);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eyE);
        a.a(this.adX);
        a.setSourceForPb(18);
        a(new z() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof ak)) {
                    ak akVar = (ak) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (c.this.adX != null) {
                        c.this.adX.a(akVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    akVar.se().b(new a.C0098a(1));
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
        lVar.sR(lVar.position + 1);
        aVar.se().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.dYs);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.se().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.se().a(this.adX);
        return aVar.getView();
    }

    private y c(l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "17";
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
            yVar.kVw = String.valueOf(this.dYs);
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eyE = bdUniqueId;
    }

    public void xe(int i) {
        this.dYs = i;
    }

    public void onPause() {
        if (this.hiC != null) {
            this.hiC.onPause();
        }
    }
}
