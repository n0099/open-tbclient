package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ac;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.play.o;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private ab<m> afF;
    private v alD;
    private int eQW;
    private BdUniqueId fsQ;
    private at ipE;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.ipE != null && this.ipE.uc() != null && this.ipE.uc().dwP() != null) {
            if (view.getId() == this.ipE.uc().dwP().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eQW);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eQW);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<m>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, m mVar) {
                c.this.a(view, mVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.alD = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aW */
    public com.baidu.card.a<m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        this.ipE = new ac(this.mPageContext.getPageActivity());
        this.ipE.setPageUniqueId(this.fsQ);
        this.ipE.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.ipE.setStageType("2001");
        aVar.c(this.ipE);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsQ);
        a2.a(this.afF);
        a2.setSourceForPb(18);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (c.this.afF != null) {
                        c.this.afF.a(amVar.getView(), mVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(mVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0097a(1));
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
        mVar.xj(mVar.position + 1);
        aVar.tW().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(mVar, this.eQW);
        aVar.setVideoStatsData(c(mVar));
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afF);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.alT = mVar.tid;
            if (mVar.bjZ() != null) {
                oVar.fyR = String.valueOf(mVar.bjZ().getFid());
                if (mVar.bjZ().bmS() != null) {
                    oVar.mjW = mVar.bjZ().bmS().video_md5;
                    oVar.mjY = String.valueOf(mVar.bjZ().bmS().is_vertical);
                }
            }
            oVar.eAX = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.mjV = mVar.coE();
            oVar.mjS = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.coD());
            oVar.mjZ = String.valueOf(this.eQW);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fsQ = bdUniqueId;
    }

    public void BD(int i) {
        this.eQW = i;
    }

    public void onPause() {
        if (this.ipE != null) {
            this.ipE.onPause();
        }
    }
}
