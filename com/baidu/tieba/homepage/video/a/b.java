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
/* loaded from: classes21.dex */
public class b extends com.baidu.adp.widget.ListView.a<m, com.baidu.card.a<m>> {
    private aa<m> afn;
    private v alj;
    private BdUniqueId eSq;
    private at hIk;
    private com.baidu.tieba.homepage.personalize.model.e iWS;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, m mVar) {
        if (this.hIk != null && this.hIk.uc() != null && this.hIk.uc().dnv() != null) {
            if (view.getId() == this.hIk.uc().dnv().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(mVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(mVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.afn = new aa<m>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, m mVar) {
                if (view != null && mVar != null && mVar.bcY() != null) {
                    b.this.a(view, mVar);
                    if (b.this.iWS != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.fd(com.baidu.adp.lib.f.b.toLong(mVar.bcY().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.fc(com.baidu.adp.lib.f.b.toLong(mVar.bcY().getTid(), 0L));
                        b.this.iWS.a(com.baidu.adp.lib.f.b.toLong(mVar.bcY().getTid(), 0L), mVar.getWeight(), mVar.getSource(), mVar.cfz(), mVar.cfA(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", mVar.bcY().getBaijiahaoData());
                    }
                }
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
        final h hVar = new h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.b.a
            public void a(AbsThreadDataSupport absThreadDataSupport) {
                if (absThreadDataSupport != null) {
                    Rect ba = ay.ba(hVar.getVideoContainer());
                    if (absThreadDataSupport instanceof m) {
                        absThreadDataSupport.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                        com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, ba);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.c) absThreadDataSupport);
                    com.baidu.tieba.homepage.video.c.a.a(absThreadDataSupport, b.this.mContext, 19, false, ba);
                }
            }
        });
        this.hIk = hVar;
        this.hIk.setPageUniqueId(this.eSq);
        this.hIk.setFrom("video_tab");
        this.hIk.setStageType("2001");
        aVar.c(this.hIk);
        ak a = aVar.a(false, viewGroup, this.alj);
        com.baidu.card.a<m> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.eSq);
        a.a(this.afn);
        a.setSourceForPb(19);
        a(new ab() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof m) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    m mVar = (m) qVar;
                    mVar.objType = 1;
                    if (b.this.afn != null) {
                        b.this.afn.a(amVar.getView(), mVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(mVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
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
        aVar.setVideoStatsData(c(mVar));
        com.baidu.tieba.homepage.video.c.a.n(mVar);
        aVar.b((com.baidu.card.a<m>) mVar);
        aVar.tW().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tW().a(this.afn);
        return aVar.getView();
    }

    private o c(m mVar) {
        o oVar = null;
        if (mVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.alA = mVar.tid;
            if (mVar.bcY() != null) {
                oVar.eYo = String.valueOf(mVar.bcY().getFid());
                oVar.lCo = mVar.bcY().getNid();
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
            if (mVar.bcY() != null && mVar.bcY().getBaijiahaoData() != null) {
                oVar.mNid = mVar.bcY().getBaijiahaoData().oriUgcNid;
                oVar.mVid = mVar.bcY().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.eSq = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.iWS = eVar;
    }

    public void onPause() {
        if (this.hIk != null) {
            this.hIk.onPause();
        }
    }
}
