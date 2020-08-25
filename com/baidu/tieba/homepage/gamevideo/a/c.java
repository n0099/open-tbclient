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
    private aa<m> aeT;
    private v akI;
    private BdUniqueId ePv;
    private int eoe;
    private as hBc;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.hBc != null && this.hBc.tW() != null && this.hBc.tW().djM() != null) {
            if (view.getId() == this.hBc.tW().djM().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eoe);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eoe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.aeT = new aa<m>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
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
        this.akI = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<m> b(ViewGroup viewGroup) {
        aj.a aVar = new aj.a(this.mPageContext.getPageActivity(), false);
        this.hBc = new ab(this.mPageContext.getPageActivity());
        this.hBc.setPageUniqueId(this.ePv);
        this.hBc.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.hBc.setStageType("2001");
        aVar.c(this.hBc);
        aj a = aVar.a(false, viewGroup, this.akI);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ePv);
        a.a(this.aeT);
        a.setSourceForPb(18);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof al)) {
                    al alVar = (al) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (c.this.aeT != null) {
                        c.this.aeT.a(alVar.getView(), mVar);
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
        com.baidu.tieba.homepage.gamevideo.e.a.d(mVar, this.eoe);
        aVar.setVideoStatsData(c(mVar));
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tR().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tR().a(this.aeT);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.akY = mVar.tid;
            if (mVar.bce() != null) {
                oVar.eVt = String.valueOf(mVar.bce().getFid());
                if (mVar.bce().beW() != null) {
                    oVar.lth = mVar.bce().beW().video_md5;
                    oVar.ltj = String.valueOf(mVar.bce().beW().is_vertical);
                }
            }
            oVar.dYo = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.ltg = mVar.cck();
            oVar.ltd = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.ccj());
            oVar.ltk = String.valueOf(this.eoe);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.ePv = bdUniqueId;
    }

    public void zQ(int i) {
        this.eoe = i;
    }

    public void onPause() {
        if (this.hBc != null) {
            this.hBc.onPause();
        }
    }
}
