package com.baidu.tieba.enterForum.tabfeed.a;

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
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.t;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class l extends com.baidu.adp.widget.ListView.a<ca, AutoVideoCardViewHolder<cb>> {
    private ab<cb> ahy;
    private s anC;
    private BdUniqueId fIy;
    private as iQw;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new ab<cb>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.l.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, cb cbVar) {
                t.csH().mG(true);
                com.baidu.tieba.enterForum.a.a(view, cbVar, l.this.mTabName);
            }
        };
        this.mPageContext = tbPageContext;
        this.fIy = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<cb> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
        gVar.a(new a.InterfaceC0094a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.l.2
            @Override // com.baidu.card.a.InterfaceC0094a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bs = az.bs(gVar.getVideoContainer());
                    if (!(aVar2 instanceof cb)) {
                        az.a(aVar2, l.this.mContext, 2, false, bs);
                        return;
                    }
                    aVar2.objType = 5;
                    az.a(aVar2, l.this.mContext, 2, false, bs);
                }
            }
        });
        this.iQw = gVar;
        this.iQw.setPageUniqueId(this.fIy);
        this.iQw.setFrom(Constants.VIA_REPORT_TYPE_MAKE_FRIEND);
        this.iQw.setStageType("2001");
        aVar.c(this.iQw);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anC);
        AutoVideoCardViewHolder<cb> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fIy);
        a2.a(this.ahy);
        a2.setSourceForPb(2);
        a(new w() { // from class: com.baidu.tieba.enterForum.tabfeed.a.l.3
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof ca) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    AutoVideoCardViewHolder autoVideoCardViewHolder2 = (AutoVideoCardViewHolder) view.getTag();
                    cb cbVar = ((ca) nVar).eLr;
                    cbVar.objType = 1;
                    if (l.this.ahy != null) {
                        l.this.ahy.a(autoVideoCardViewHolder2.getView(), cbVar);
                    }
                    az.a((com.baidu.tbadk.core.data.a) cbVar, view.getContext(), 2, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    autoVideoCardViewHolder2.tj().b(new a.C0095a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, ca caVar, AutoVideoCardViewHolder<cb> autoVideoCardViewHolder) {
        if (caVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        caVar.eLr.ePT = getPositionByType(i) + 1;
        autoVideoCardViewHolder.tj().setPosition(i);
        autoVideoCardViewHolder.setVideoStatsData(al(caVar.eLr));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<cb>) caVar.eLr);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.ahy);
        com.baidu.tieba.enterForum.a.a(caVar, this.mTabName);
        return autoVideoCardViewHolder.getView();
    }

    private o al(cb cbVar) {
        o oVar = null;
        if (cbVar != null) {
            oVar = new o();
            oVar.mLocate = "20";
            oVar.anU = cbVar.tid;
            oVar.mSource = cbVar.mRecomSource;
            oVar.mKz = cbVar.mRecomAbTag;
            oVar.mKA = cbVar.mRecomWeight;
            oVar.mKB = Constants.VIA_REPORT_TYPE_MAKE_FRIEND;
            oVar.mGroupId = this.mTabName;
            oVar.mFloor = String.valueOf(cbVar.ePT);
            if (cbVar.bpk() != null) {
                oVar.ePf = String.valueOf(cbVar.bpk().eVW);
            }
            if (cbVar.blp() != null) {
                oVar.fOD = String.valueOf(cbVar.blp().getFid());
                oVar.mKI = cbVar.blp().bmq();
                if (cbVar.blp().boj() != null) {
                    oVar.mKE = cbVar.blp().boj().video_md5;
                    oVar.mKG = String.valueOf(cbVar.blp().boj().is_vertical);
                }
            }
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (cbVar.blp() != null && cbVar.blp().getBaijiahaoData() != null) {
                oVar.eVa = cbVar.blp().getBaijiahaoData().oriUgcNid;
                oVar.mVid = cbVar.blp().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }
}
