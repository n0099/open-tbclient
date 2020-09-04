package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ab;
import com.baidu.card.aj;
import com.baidu.card.al;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.play.o;
/* loaded from: classes16.dex */
public class c extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private aa<m> aeV;
    private v akK;
    private BdUniqueId ePz;
    private int eoj;
    private as hBi;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.hBi != null && this.hBi.tW() != null && this.hBi.tW().djP() != null) {
            if (view.getId() == this.hBi.tW().djP().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eoj);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eoj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeV = new aa<m>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, m mVar) {
                c.this.a(view, mVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.akK = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<m> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        this.hBi = new ab(this.mPageContext.getPageActivity());
        this.hBi.setPageUniqueId(this.ePz);
        this.hBi.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.hBi.setStageType("2001");
        aVar.c(this.hBi);
        aj a = aVar.a(false, viewGroup, this.akK);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ePz);
        a.a(this.aeV);
        a.setSourceForPb(18);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof al)) {
                    al alVar = (al) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (c.this.aeV != null) {
                        c.this.aeV.a(alVar.getView(), mVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(mVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    alVar.tR().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, m mVar, com.baidu.card.a<m> aVar) {
        if (mVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        mVar.vy(mVar.position + 1);
        aVar.tR().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(mVar, this.eoj);
        aVar.setVideoStatsData(c(mVar));
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.aeV);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.ala = mVar.tid;
            if (mVar.bce() != null) {
                oVar.eVx = String.valueOf(mVar.bce().getFid());
                if (mVar.bce().beW() != null) {
                    oVar.ltt = mVar.bce().beW().video_md5;
                    oVar.ltv = String.valueOf(mVar.bce().beW().is_vertical);
                }
            }
            oVar.dYs = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.lts = mVar.ccl();
            oVar.lto = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.cck());
            oVar.ltw = String.valueOf(this.eoj);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ePz = bdUniqueId;
    }

    public void zQ(int i) {
        this.eoj = i;
    }

    public void onPause() {
        if (this.hBi != null) {
            this.hBi.onPause();
        }
    }
}
