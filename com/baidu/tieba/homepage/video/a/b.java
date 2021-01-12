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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, AutoVideoCardViewHolder<l>> {
    private aa<l> ago;
    private s amu;
    private BdUniqueId fEN;
    private as iIR;
    private com.baidu.tieba.homepage.personalize.model.e kbv;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (this.iIR != null && this.iIR.tt() != null && this.iIR.tt().dxG() != null) {
            if (view.getId() == this.iIR.tt().dxG().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ago = new aa<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bkV() != null) {
                    b.this.b(view, lVar);
                    if (b.this.kbv != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(lVar.bkV().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(lVar.bkV().getTid(), 0L));
                        b.this.kbv.a(com.baidu.adp.lib.f.b.toLong(lVar.bkV().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.crv(), lVar.crw(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.bkV().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.amu = sVar;
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
                    Rect bw = ay.bw(gVar.getVideoContainer());
                    if (aVar2 instanceof l) {
                        aVar2.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                        com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bw);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                    com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bw);
                }
            }
        });
        this.iIR = gVar;
        this.iIR.setPageUniqueId(this.fEN);
        this.iIR.setFrom("video_tab");
        this.iIR.setStageType("2001");
        aVar.c(this.iIR);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amu);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fEN);
        a2.a(this.ago);
        a2.setSourceForPb(19);
        a(new w() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    l lVar = (l) nVar;
                    lVar.objType = 1;
                    if (b.this.ago != null) {
                        b.this.ago.a(threadCardViewHolder.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder.tm().b(new a.C0089a(1));
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
        lVar.wT(lVar.position + 1);
        autoVideoCardViewHolder.tm().setPosition(i);
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.n(lVar);
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<l>) lVar);
        autoVideoCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tm().a(this.ago);
        return autoVideoCardViewHolder.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.amM = lVar.tid;
            if (lVar.bkV() != null) {
                oVar.fKR = String.valueOf(lVar.bkV().getFid());
                oVar.mzg = lVar.bkV().blV();
                if (lVar.bkV().bnO() != null) {
                    oVar.mzc = lVar.bkV().bnO().video_md5;
                    oVar.mze = String.valueOf(lVar.bkV().bnO().is_vertical);
                }
            }
            oVar.eLs = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mzb = lVar.crw();
            oVar.myY = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.crv());
            if (lVar.bkV() != null && lVar.bkV().getBaijiahaoData() != null) {
                oVar.eRn = lVar.bkV().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bkV().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fEN = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.kbv = eVar;
    }

    public void onPause() {
        if (this.iIR != null) {
            this.iIR.onPause();
        }
    }
}
