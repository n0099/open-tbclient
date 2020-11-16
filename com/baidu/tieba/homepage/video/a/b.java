package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.b;
import com.baidu.card.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes21.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private ab<l> afK;
    private v alH;
    private BdUniqueId fsa;
    private at iqs;
    private com.baidu.tieba.homepage.personalize.model.e jFl;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.iqs != null && this.iqs.uc() != null && this.iqs.uc().dwp() != null) {
            if (view.getId() == this.iqs.uc().dwp().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afK = new ab<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bjd() != null) {
                    b.this.a(view, lVar);
                    if (b.this.jFl != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fV(com.baidu.adp.lib.f.b.toLong(lVar.bjd().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fU(com.baidu.adp.lib.f.b.toLong(lVar.bjd().getTid(), 0L));
                        b.this.jFl.a(com.baidu.adp.lib.f.b.toLong(lVar.bjd().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.cof(), lVar.cog(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.bjd().getBaijiahaoData());
                    }
                }
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
        final h hVar = new h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bk = az.bk(hVar.getVideoContainer());
                    if (aVar2 instanceof l) {
                        aVar2.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                        com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bk);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                    com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bk);
                }
            }
        });
        this.iqs = hVar;
        this.iqs.setPageUniqueId(this.fsa);
        this.iqs.setFrom("video_tab");
        this.iqs.setStageType("2001");
        aVar.c(this.iqs);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.alH);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fsa);
        a2.a(this.afK);
        a2.setSourceForPb(19);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (b.this.afK != null) {
                        b.this.afK.a(amVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
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
        aVar.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.n(lVar);
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afK);
        return aVar.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.alZ = lVar.tid;
            if (lVar.bjd() != null) {
                oVar.fyg = String.valueOf(lVar.bjd().getFid());
                oVar.mkt = lVar.bjd().getNid();
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
            if (lVar.bjd() != null && lVar.bjd().getBaijiahaoData() != null) {
                oVar.mNid = lVar.bjd().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bjd().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fsa = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jFl = eVar;
    }

    public void onPause() {
        if (this.iqs != null) {
            this.iqs.onPause();
        }
    }
}
