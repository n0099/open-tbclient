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
    private z<bj> acX;
    private r ahv;
    private BdUniqueId ebv;
    private al gGN;
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
        this.acX = new z<bj>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            public void a(View view, bj bjVar) {
                com.baidu.tieba.card.r.bEY().jd(true);
                i.this.f(view, bjVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.ebv = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(r rVar) {
        this.ahv = rVar;
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
            this.gGN = gVar;
        }
        this.gGN.setPageUniqueId(this.ebv);
        this.gGN.setFrom("14");
        aVar.c(this.gGN);
        ad a = aVar.a(false, viewGroup, this.ahv);
        com.baidu.card.a<bj> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.ebv);
        a.a(this.acX);
        a.bc(2);
        a(new v() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.3
            @Override // com.baidu.adp.widget.ListView.v
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof bi) && (view.getTag() instanceof af)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bj bjVar = ((bi) mVar).dqA;
                    bjVar.objType = 1;
                    if (i.this.acX != null) {
                        i.this.acX.a(aVar3.getView(), bjVar);
                    }
                    au.a((com.baidu.tbadk.core.data.a) bjVar, view.getContext(), 2, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    aVar3.rD().b(new a.C0074a(1));
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
        biVar.dqA.doZ = getPositionByType(i) + 1;
        aVar.rD().setPosition(i);
        aVar.setVideoStatsData(aj(biVar.dqA));
        aVar.b((com.baidu.card.a<bj>) biVar.dqA);
        aVar.rD().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rD().a(this.acX);
        com.baidu.tieba.card.r.bEY().e(com.baidu.tieba.enterForum.a.h(biVar.aIw(), this.mTabName));
        return aVar.getView();
    }

    private y aj(bj bjVar) {
        y yVar = null;
        if (bjVar != null) {
            yVar = new y();
            yVar.mLocate = "20";
            yVar.ahL = bjVar.tid;
            yVar.mSource = bjVar.mRecomSource;
            yVar.kin = bjVar.mRecomAbTag;
            yVar.kio = bjVar.mRecomWeight;
            yVar.kip = "14";
            yVar.mGroupId = this.mTabName;
            yVar.mFloor = String.valueOf(bjVar.doZ);
            if (bjVar.aLR() != null) {
                yVar.dol = String.valueOf(bjVar.aLR().dun);
            }
            if (bjVar.aIw() != null) {
                yVar.eQf = String.valueOf(bjVar.aIw().getFid());
                if (bjVar.aIw().aKV() != null) {
                    yVar.kis = bjVar.aIw().aKV().video_md5;
                    yVar.kiu = String.valueOf(bjVar.aIw().aKV().is_vertical);
                }
            }
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bjVar.aIw() != null && bjVar.aIw().getBaijiahaoData() != null) {
                yVar.mNid = bjVar.aIw().getBaijiahaoData().oriUgcNid;
                yVar.mVid = bjVar.aIw().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }
}
