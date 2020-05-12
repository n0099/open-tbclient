package com.baidu.tieba.enterForum.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class i extends com.baidu.adp.widget.ListView.a<bi, com.baidu.card.a<bj>> {
    private z<bj> ada;
    private r ahy;
    private BdUniqueId ebA;
    private al gGT;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void f(View view, bj bjVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bjVar, this.mTabName));
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bjVar, this.mTabName));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bjVar, this.mTabName));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.m(bjVar, this.mTabName));
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.l(bjVar, this.mTabName));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bjVar, this.mTabName));
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.k(bjVar, this.mTabName));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ada = new z<bj>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                com.baidu.tieba.card.r.bEX().jd(true);
                i.this.f(view, bjVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.ebA = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(r rVar) {
        this.ahy = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aB */
    public com.baidu.card.a<bj> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
            gVar.a(new b.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar2) {
                    if (aVar2 != null) {
                        Rect aQ = au.aQ(gVar.getVideoContainer());
                        if (!(aVar2 instanceof bj)) {
                            au.a(aVar2, i.this.mContext, 2, false, aQ);
                            return;
                        }
                        aVar2.objType = 5;
                        au.a(aVar2, i.this.mContext, 2, false, aQ);
                    }
                }
            });
            this.gGT = gVar;
        }
        this.gGT.setPageUniqueId(this.ebA);
        this.gGT.setFrom("14");
        aVar.c(this.gGT);
        ad a = aVar.a(false, viewGroup, this.ahy);
        com.baidu.card.a<bj> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebA);
        a.a(this.ada);
        a.bc(2);
        a(new v() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bj bjVar = ((bi) mVar).dqE;
                    bjVar.objType = 1;
                    if (i.this.ada != null) {
                        i.this.ada.a(aVar3.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 2, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    aVar3.rD().b(new a.C0095a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bi biVar, com.baidu.card.a<bj> aVar) {
        if (biVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        biVar.dqE.dpd = getPositionByType(i) + 1;
        aVar.rD().setPosition(i);
        aVar.setVideoStatsData(aj(biVar.dqE));
        aVar.b((com.baidu.card.a<bj>) biVar.dqE);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.ada);
        com.baidu.tieba.card.r.bEX().e(com.baidu.tieba.enterForum.a.h(biVar.aIu(), this.mTabName));
        return aVar.getView();
    }

    private y aj(bj bjVar) {
        y yVar = null;
        if (bjVar != null) {
            yVar = new y();
            yVar.mLocate = "20";
            yVar.ahO = bjVar.tid;
            yVar.mSource = bjVar.mRecomSource;
            yVar.kir = bjVar.mRecomAbTag;
            yVar.kis = bjVar.mRecomWeight;
            yVar.kit = "14";
            yVar.mGroupId = this.mTabName;
            yVar.mFloor = String.valueOf(bjVar.dpd);
            if (bjVar.aLP() != null) {
                yVar.dop = String.valueOf(bjVar.aLP().dur);
            }
            if (bjVar.aIu() != null) {
                yVar.eQk = String.valueOf(bjVar.aIu().getFid());
                if (bjVar.aIu().aKT() != null) {
                    yVar.kiw = bjVar.aIu().aKT().video_md5;
                    yVar.kiy = String.valueOf(bjVar.aIu().aKT().is_vertical);
                }
            }
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.aIu() != null && bjVar.aIu().getBaijiahaoData() != null) {
                yVar.mNid = bjVar.aIu().getBaijiahaoData().oriUgcNid;
                yVar.mVid = bjVar.aIu().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }
}
