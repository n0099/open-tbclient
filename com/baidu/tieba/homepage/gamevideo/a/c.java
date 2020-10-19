package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.play.o;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private aa<m> afE;
    private v alC;
    private int eCL;
    private BdUniqueId fey;
    private at hXf;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.hXf != null && this.hXf.uc() != null && this.hXf.uc().drg() != null) {
            if (view.getId() == this.hXf.uc().drg().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eCL);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eCL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afE = new aa<m>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
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
        this.alC = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aU */
    public com.baidu.card.a<m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        this.hXf = new ac(this.mPageContext.getPageActivity());
        this.hXf.setPageUniqueId(this.fey);
        this.hXf.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.hXf.setStageType("2001");
        aVar.c(this.hXf);
        ak a2 = aVar.a(false, viewGroup, this.alC);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fey);
        a2.a(this.afE);
        a2.setSourceForPb(18);
        a(new ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (c.this.afE != null) {
                        c.this.afE.a(amVar.getView(), mVar);
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
        mVar.wD(mVar.position + 1);
        aVar.tW().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(mVar, this.eCL);
        aVar.setVideoStatsData(c(mVar));
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afE);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.alS = mVar.tid;
            if (mVar.bfG() != null) {
                oVar.fkA = String.valueOf(mVar.bfG().getFid());
                if (mVar.bfG().biz() != null) {
                    oVar.lRz = mVar.bfG().biz().video_md5;
                    oVar.lRB = String.valueOf(mVar.bfG().biz().is_vertical);
                }
            }
            oVar.emE = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.lRy = mVar.ciW();
            oVar.lRv = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.ciV());
            oVar.lRC = String.valueOf(this.eCL);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fey = bdUniqueId;
    }

    public void AX(int i) {
        this.eCL = i;
    }

    public void onPause() {
        if (this.hXf != null) {
            this.hXf.onPause();
        }
    }
}
