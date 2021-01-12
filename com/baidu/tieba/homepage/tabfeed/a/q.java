package com.baidu.tieba.homepage.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class q extends com.baidu.adp.widget.ListView.a<by, AutoVideoCardViewHolder<bz>> {
    private aa<bz> ago;
    private s amu;
    private BdUniqueId fEN;
    private as iIR;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public q(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ago = new aa<bz>() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                com.baidu.tieba.card.s.crj().mC(true);
                com.baidu.tieba.homepage.tabfeed.b.a(view, bzVar, q.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fEN = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(s sVar) {
        this.amu = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new a.InterfaceC0088a() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.2
            @Override // com.baidu.card.a.InterfaceC0088a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bw = ay.bw(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bz)) {
                        ay.a(aVar2, q.this.mContext, 2, false, bw);
                        return;
                    }
                    aVar2.objType = 5;
                    ay.a(aVar2, q.this.mContext, 2, false, bw);
                }
            }
        });
        this.iIR = gVar;
        this.iIR.setPageUniqueId(this.fEN);
        this.iIR.setFrom(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.iIR.setStageType("2001");
        aVar.c(this.iIR);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amu);
        AutoVideoCardViewHolder<bz> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fEN);
        a2.a(this.ago);
        a2.setSourceForPb(2);
        a(new w() { // from class: com.baidu.tieba.homepage.tabfeed.a.q.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, com.baidu.adp.widget.ListView.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eHK;
                    bzVar.objType = 1;
                    if (q.this.ago != null) {
                        q.this.ago.a(autoVideoCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 2, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.tm().b(new a.C0089a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, AutoVideoCardViewHolder<bz> autoVideoCardViewHolder) {
        if (byVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        byVar.eHK.eMg = getPositionByType(i) + 1;
        autoVideoCardViewHolder.tm().setPosition(i);
        autoVideoCardViewHolder.setVideoStatsData(ak(byVar.eHK));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<bz>) byVar.eHK);
        autoVideoCardViewHolder.tm().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tm().a(this.ago);
        com.baidu.tieba.homepage.tabfeed.b.a(byVar, this.mTabName);
        return autoVideoCardViewHolder.getView();
    }

    private com.baidu.tieba.play.o ak(bz bzVar) {
        com.baidu.tieba.play.o oVar = null;
        if (bzVar != null) {
            oVar = new com.baidu.tieba.play.o();
            oVar.mLocate = "20";
            oVar.amM = bzVar.tid;
            oVar.mSource = bzVar.mRecomSource;
            oVar.myX = bzVar.mRecomAbTag;
            oVar.myY = bzVar.mRecomWeight;
            oVar.myZ = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(bzVar.eMg);
            if (bzVar.boQ() != null) {
                oVar.eLs = String.valueOf(bzVar.boQ().eSj);
            }
            if (bzVar.bkV() != null) {
                oVar.fKR = String.valueOf(bzVar.bkV().getFid());
                oVar.mzg = bzVar.bkV().blV();
                if (bzVar.bkV().bnO() != null) {
                    oVar.mzc = bzVar.bkV().bnO().video_md5;
                    oVar.mze = String.valueOf(bzVar.bkV().bnO().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bzVar.bkV() != null && bzVar.bkV().getBaijiahaoData() != null) {
                oVar.eRn = bzVar.bkV().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bzVar.bkV().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
