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
import com.baidu.tieba.play.o;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private aa<l> adN;
    private v ajt;
    private BdUniqueId eEU;
    private int eeE;
    private ar hol;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.hol != null && this.hol.sl() != null && this.hol.sl().cYJ() != null) {
            if (view.getId() == this.hol.sl().cYJ().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.eeE);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.eeE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adN = new aa<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
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
        this.ajt = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ai.a aVar = new ai.a(this.mPageContext.getPageActivity(), false);
        this.hol = new com.baidu.card.aa(this.mPageContext.getPageActivity());
        this.hol.setPageUniqueId(this.eEU);
        this.hol.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.c(this.hol);
        ai a = aVar.a(false, viewGroup, this.ajt);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eEU);
        a.a(this.adN);
        a.setSourceForPb(18);
        a(new z() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.z
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof ak)) {
                    ak akVar = (ak) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (c.this.adN != null) {
                        c.this.adN.a(akVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    akVar.sg().b(new a.C0096a(1));
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
        lVar.tj(lVar.position + 1);
        aVar.sg().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.eeE);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.sg().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.sg().a(this.adN);
        return aVar.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.ajJ = lVar.tid;
            if (lVar.aTN() != null) {
                oVar.eKO = String.valueOf(lVar.aTN().getFid());
                if (lVar.aTN().aWD() != null) {
                    oVar.lcM = lVar.aTN().aWD().video_md5;
                    oVar.lcO = String.valueOf(lVar.aTN().aWD().is_vertical);
                }
            }
            oVar.dOV = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.lcL = lVar.bRY();
            oVar.lcI = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.bRX());
            oVar.lcP = String.valueOf(this.eeE);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eEU = bdUniqueId;
    }

    public void xw(int i) {
        this.eeE = i;
    }

    public void onPause() {
        if (this.hol != null) {
            this.hol.onPause();
        }
    }
}
