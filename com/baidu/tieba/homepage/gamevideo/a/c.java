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
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private aa<m> afn;
    private v alj;
    private BdUniqueId eSq;
    private int eqz;
    private at hIk;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.hIk != null && this.hIk.uc() != null && this.hIk.uc().dnv() != null) {
            if (view.getId() == this.hIk.uc().dnv().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eqz);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(mVar, this.eqz);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afn = new aa<m>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
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
        this.alj = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        this.hIk = new ac(this.mPageContext.getPageActivity());
        this.hIk.setPageUniqueId(this.eSq);
        this.hIk.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.hIk.setStageType("2001");
        aVar.c(this.hIk);
        ak a = aVar.a(false, viewGroup, this.alj);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eSq);
        a.a(this.afn);
        a.setSourceForPb(18);
        a(new ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (c.this.afn != null) {
                        c.this.afn.a(amVar.getView(), mVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(mVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0096a(1));
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
        mVar.vX(mVar.position + 1);
        aVar.tW().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(mVar, this.eqz);
        aVar.setVideoStatsData(c(mVar));
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afn);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.alA = mVar.tid;
            if (mVar.bcY() != null) {
                oVar.eYo = String.valueOf(mVar.bcY().getFid());
                if (mVar.bcY().bfQ() != null) {
                    oVar.lCk = mVar.bcY().bfQ().video_md5;
                    oVar.lCm = String.valueOf(mVar.bcY().bfQ().is_vertical);
                }
            }
            oVar.eaC = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.lCj = mVar.cfA();
            oVar.lCg = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.cfz());
            oVar.lCn = String.valueOf(this.eqz);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eSq = bdUniqueId;
    }

    public void Ar(int i) {
        this.eqz = i;
    }

    public void onPause() {
        if (this.hIk != null) {
            this.hIk.onPause();
        }
    }
}
