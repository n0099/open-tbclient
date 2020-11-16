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
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
/* loaded from: classes21.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private ab<l> afK;
    private v alH;
    private int ePX;
    private BdUniqueId fsa;
    private at iqs;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.iqs != null && this.iqs.uc() != null && this.iqs.uc().dwp() != null) {
            if (view.getId() == this.iqs.uc().dwp().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.ePX);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.ePX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afK = new ab<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, l lVar) {
                c.this.a(view, lVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.alH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        this.iqs = new ac(this.mPageContext.getPageActivity());
        this.iqs.setPageUniqueId(this.fsa);
        this.iqs.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.iqs.setStageType("2001");
        aVar.c(this.iqs);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.alH);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsa);
        a2.a(this.afK);
        a2.setSourceForPb(18);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (c.this.afK != null) {
                        c.this.afK.a(amVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar.tW().b(new a.C0096a(1));
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
        lVar.xH(lVar.position + 1);
        aVar.tW().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.ePX);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afK);
        return aVar.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.alZ = lVar.tid;
            if (lVar.bjd() != null) {
                oVar.fyg = String.valueOf(lVar.bjd().getFid());
                if (lVar.bjd().blU() != null) {
                    oVar.mkp = lVar.bjd().blU().video_md5;
                    oVar.mkr = String.valueOf(lVar.bjd().blU().is_vertical);
                }
            }
            oVar.ezo = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mko = lVar.cog();
            oVar.mkl = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.cof());
            oVar.mks = String.valueOf(this.ePX);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fsa = bdUniqueId;
    }

    public void Cb(int i) {
        this.ePX = i;
    }

    public void onPause() {
        if (this.iqs != null) {
            this.iqs.onPause();
        }
    }
}
