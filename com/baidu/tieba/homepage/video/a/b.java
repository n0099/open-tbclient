package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ab;
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
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.m;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private aa<m> afE;
    private v alC;
    private BdUniqueId fey;
    private at hXf;
    private com.baidu.tieba.homepage.personalize.model.e jlQ;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.hXf != null && this.hXf.uc() != null && this.hXf.uc().drg() != null) {
            if (view.getId() == this.hXf.uc().drg().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(mVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afE = new aa<m>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, m mVar) {
                if (view != null && mVar != null && mVar.bfG() != null) {
                    b.this.a(view, mVar);
                    if (b.this.jlQ != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fv(com.baidu.adp.lib.f.b.toLong(mVar.bfG().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fu(com.baidu.adp.lib.f.b.toLong(mVar.bfG().getTid(), 0L));
                        b.this.jlQ.a(com.baidu.adp.lib.f.b.toLong(mVar.bfG().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.ciV(), mVar.ciW(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", mVar.bfG().getBaijiahaoData());
                    }
                }
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
        final h hVar = new h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect bc = ay.bc(hVar.getVideoContainer());
                    if (absThreadDataSupport instanceof m) {
                        absThreadDataSupport.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                        com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, bc);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                    com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, bc);
                }
            }
        });
        this.hXf = hVar;
        this.hXf.setPageUniqueId(this.fey);
        this.hXf.setFrom("video_tab");
        this.hXf.setStageType("2001");
        aVar.c(this.hXf);
        ak a2 = aVar.a(false, viewGroup, this.alC);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fey);
        a2.a(this.afE);
        a2.setSourceForPb(19);
        a(new ab() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (b.this.afE != null) {
                        b.this.afE.a(amVar.getView(), mVar);
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
        mVar.wD(mVar.position + 1);
        aVar.tW().setPosition(i);
        aVar.setVideoStatsData(c(mVar));
        com.baidu.tieba.homepage.video.c.a.n(mVar);
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afE);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.alS = mVar.tid;
            if (mVar.bfG() != null) {
                oVar.fkA = String.valueOf(mVar.bfG().getFid());
                oVar.lRD = mVar.bfG().getNid();
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
            if (mVar.bfG() != null && mVar.bfG().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bfG().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bfG().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fey = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jlQ = eVar;
    }

    public void onPause() {
        if (this.hXf != null) {
            this.hXf.onPause();
        }
    }
}
