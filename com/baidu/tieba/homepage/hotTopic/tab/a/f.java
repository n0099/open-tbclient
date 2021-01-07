package com.baidu.tieba.homepage.hotTopic.tab.a;

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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class f extends a<by, AutoVideoCardViewHolder<bz>> {
    private aa<bz> ahf;
    private as iNy;

    public f(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), bz.eTj);
        this.ahf = new aa<bz>() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bz bzVar) {
                f.this.f(view, bzVar);
            }
        };
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<bz> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new a.InterfaceC0089a() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.f.2
            @Override // com.baidu.card.a.InterfaceC0089a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bw = ay.bw(gVar.getVideoContainer());
                    if (!(aVar2 instanceof bz)) {
                        ay.a(aVar2, f.this.mContext, 0, false, bw);
                        return;
                    }
                    aVar2.objType = 5;
                    ay.a(aVar2, f.this.mContext, 0, false, bw);
                }
            }
        });
        this.iNy = gVar;
        this.iNy.setPageUniqueId(this.mPageId);
        this.iNy.setFrom(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.iNy.setStageType("2001");
        aVar.c(this.iNy);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anl);
        AutoVideoCardViewHolder<bz> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.mPageId);
        a2.a(this.ahf);
        a2.setSourceForPb(0);
        a(new w() { // from class: com.baidu.tieba.homepage.hotTopic.tab.a.f.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof by) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    bz bzVar = ((by) nVar).eMv;
                    bzVar.objType = 1;
                    if (f.this.ahf != null) {
                        f.this.ahf.a(autoVideoCardViewHolder2.getView(), bzVar);
                    }
                    ay.a((com.baidu.tbadk.core.data.a) bzVar, view.getContext(), 0, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.ty().b(new a.C0090a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.homepage.hotTopic.tab.a.a, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, AutoVideoCardViewHolder<bz> autoVideoCardViewHolder) {
        if (byVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        byVar.eMv.eQR = getPositionByType(i) + 1;
        autoVideoCardViewHolder.ty().setPosition(i);
        autoVideoCardViewHolder.setVideoStatsData(ak(byVar.eMv));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<bz>) byVar.eMv);
        autoVideoCardViewHolder.ty().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.ty().a(this.ahf);
        a(autoVideoCardViewHolder.getView(), byVar.eMv, i, i);
        return autoVideoCardViewHolder.getView();
    }

    private o ak(bz bzVar) {
        o oVar = null;
        if (bzVar != null) {
            oVar = new o();
            oVar.mLocate = "20";
            oVar.anD = bzVar.tid;
            oVar.mSource = bzVar.mRecomSource;
            oVar.mDG = bzVar.mRecomAbTag;
            oVar.mDH = bzVar.mRecomWeight;
            oVar.mDI = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.mFloor = String.valueOf(bzVar.eQR);
            if (bzVar.bsK() != null) {
                oVar.eQd = String.valueOf(bzVar.bsK().eWU);
            }
            if (bzVar.boP() != null) {
                oVar.fPy = String.valueOf(bzVar.boP().getFid());
                oVar.mDP = bzVar.boP().bpP();
                if (bzVar.boP().brI() != null) {
                    oVar.mDL = bzVar.boP().brI().video_md5;
                    oVar.mDN = String.valueOf(bzVar.boP().brI().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bzVar.boP() != null && bzVar.boP().getBaijiahaoData() != null) {
                oVar.eVY = bzVar.boP().getBaijiahaoData().oriUgcNid;
                oVar.mVid = bzVar.boP().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
