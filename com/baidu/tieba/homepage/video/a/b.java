package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.as;
import com.baidu.card.g;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, AutoVideoCardViewHolder<l>> {
    private ab<l> agg;
    private s amk;
    private BdUniqueId fGZ;
    private as iON;
    private com.baidu.tieba.homepage.personalize.model.e kjT;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (this.iON != null && this.iON.tq() != null && this.iON.tq().dzW() != null) {
            if (view.getId() == this.iON.tq().dzW().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agg = new ab<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bln() != null) {
                    b.this.b(view, lVar);
                    if (b.this.kjT != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gF(com.baidu.adp.lib.f.b.toLong(lVar.bln().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gE(com.baidu.adp.lib.f.b.toLong(lVar.bln().getTid(), 0L));
                        b.this.kjT.a(com.baidu.adp.lib.f.b.toLong(lVar.bln().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.csO(), lVar.csP(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.bln().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.amk = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final g gVar = new g(this.mPageContext.getPageActivity());
        gVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(gVar.getVideoContainer());
                    if (aVar2 instanceof l) {
                        aVar2.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                        com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bs);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                    com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bs);
                }
            }
        });
        this.iON = gVar;
        this.iON.setPageUniqueId(this.fGZ);
        this.iON.setFrom("video_tab");
        this.iON.setStageType("2001");
        aVar.c(this.iON);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amk);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fGZ);
        a2.a(this.agg);
        a2.setSourceForPb(19);
        a(new w() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    l lVar = (l) nVar;
                    lVar.objType = 1;
                    if (b.this.agg != null) {
                        b.this.agg.a(threadCardViewHolder.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0089a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xd(lVar.position + 1);
        autoVideoCardViewHolder.tj().setPosition(i);
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.n(lVar);
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<l>) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.agg);
        return autoVideoCardViewHolder.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.amC = lVar.tid;
            if (lVar.bln() != null) {
                oVar.fNd = String.valueOf(lVar.bln().getFid());
                oVar.mIF = lVar.bln().bmo();
                if (lVar.bln().boh() != null) {
                    oVar.mIA = lVar.bln().boh().video_md5;
                    oVar.mIC = String.valueOf(lVar.bln().boh().is_vertical);
                }
            }
            oVar.eNE = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mIz = lVar.csP();
            oVar.mIw = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.csO());
            if (lVar.bln() != null && lVar.bln().getBaijiahaoData() != null) {
                oVar.eTz = lVar.bln().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bln().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fGZ = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kjT = eVar;
    }

    public void onPause() {
        if (this.iON != null) {
            this.iON.onPause();
        }
    }
}
