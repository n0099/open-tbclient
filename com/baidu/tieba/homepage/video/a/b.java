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
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private ab<m> afF;
    private v alD;
    private BdUniqueId fmX;
    private at ijF;
    private com.baidu.tieba.homepage.personalize.model.e jyq;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.ijF != null && this.ijF.uc() != null && this.ijF.uc().dun() != null) {
            if (view.getId() == this.ijF.uc().dun().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(mVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afF = new ab<m>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, m mVar) {
                if (view != null && mVar != null && mVar.bhz() != null) {
                    b.this.a(view, mVar);
                    if (b.this.jyq != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fw(com.baidu.adp.lib.f.b.toLong(mVar.bhz().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fv(com.baidu.adp.lib.f.b.toLong(mVar.bhz().getTid(), 0L));
                        b.this.jyq.a(com.baidu.adp.lib.f.b.toLong(mVar.bhz().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.cmc(), mVar.cmd(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", mVar.bhz().getBaijiahaoData());
                    }
                }
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
    /* renamed from: aU */
    public com.baidu.card.a<m> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final h hVar = new h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bd = ay.bd(hVar.getVideoContainer());
                    if (absThreadDataSupport instanceof m) {
                        absThreadDataSupport.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                        com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, bd);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                    com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, bd);
                }
            }
        });
        this.ijF = hVar;
        this.ijF.setPageUniqueId(this.fmX);
        this.ijF.setFrom("video_tab");
        this.ijF.setStageType("2001");
        aVar.c(this.ijF);
        ak a2 = aVar.a(false, viewGroup, this.alD);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fmX);
        a2.a(this.afF);
        a2.setSourceForPb(19);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (b.this.afF != null) {
                        b.this.afF.a(amVar.getView(), mVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(mVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
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
        mVar.wW(mVar.position + 1);
        aVar.tW().setPosition(i);
        aVar.setVideoStatsData(c(mVar));
        com.baidu.tieba.homepage.video.c.a.n(mVar);
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afF);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.alT = mVar.tid;
            if (mVar.bhz() != null) {
                oVar.fsZ = String.valueOf(mVar.bhz().getFid());
                oVar.meb = mVar.bhz().getNid();
                if (mVar.bhz().bks() != null) {
                    oVar.mdX = mVar.bhz().bks().video_md5;
                    oVar.mdZ = String.valueOf(mVar.bhz().bks().is_vertical);
                }
            }
            oVar.eve = mVar.getExtra();
            oVar.mSource = mVar.getSource();
            oVar.mdW = mVar.cmd();
            oVar.mdT = mVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(mVar.cmc());
            if (mVar.bhz() != null && mVar.bhz().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bhz().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bhz().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fmX = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jyq = eVar;
    }

    public void onPause() {
        if (this.ijF != null) {
            this.ijF.onPause();
        }
    }
}
