package com.baidu.tieba.enterForum.tabfeed.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.adp.widget.ListView.x;
import com.baidu.card.a.a;
import com.baidu.card.ae;
import com.baidu.card.ag;
import com.baidu.card.am;
import com.baidu.card.b;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AbsThreadDataSupport;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.s;
import com.baidu.tieba.play.y;
/* loaded from: classes9.dex */
public class i extends com.baidu.adp.widget.ListView.a<bj, com.baidu.card.a<bk>> {
    private aa<bk> adt;
    private t aib;
    private BdUniqueId epM;
    private am gVL;
    private TbPageContext<?> mPageContext;
    private String mTabName;

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view, bk bkVar) {
        int id = view.getId();
        if (view.getId() == R.id.thread_card_root || id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bkVar, this.mTabName));
        } else if (id == R.id.user_avatar) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bkVar, this.mTabName));
        } else if (id == R.id.user_name) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.i(bkVar, this.mTabName));
        } else if (id == R.id.forum_name_text) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.m(bkVar, this.mTabName));
        } else if (id == R.id.operable_video_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.l(bkVar, this.mTabName));
        } else if (id == R.id.thread_info_commont_container) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.j(bkVar, this.mTabName));
        } else if (view instanceof TbImageView) {
            TiebaStatic.log(com.baidu.tieba.enterForum.a.k(bkVar, this.mTabName));
        }
    }

    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.adt = new aa<bk>() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.aa
            /* renamed from: b */
            public void a(View view, bk bkVar) {
                s.bLs().jv(true);
                i.this.g(view, bkVar);
            }
        };
        this.mPageContext = tbPageContext;
        this.epM = bdUniqueId2;
        this.mTabName = str;
    }

    public void a(t tVar) {
        this.aib = tVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public com.baidu.card.a<bk> b(ViewGroup viewGroup) {
        ae.a aVar = new ae.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final com.baidu.card.g gVar = new com.baidu.card.g(this.mPageContext.getPageActivity());
            gVar.a(new b.a() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.2
                @Override // com.baidu.card.b.a
                public void a(AbsThreadDataSupport absThreadDataSupport) {
                    if (absThreadDataSupport != null) {
                        Rect aQ = au.aQ(gVar.getVideoContainer());
                        if (!(absThreadDataSupport instanceof bk)) {
                            au.a(absThreadDataSupport, i.this.mContext, 2, false, aQ);
                            return;
                        }
                        absThreadDataSupport.objType = 5;
                        au.a(absThreadDataSupport, i.this.mContext, 2, false, aQ);
                    }
                }
            });
            this.gVL = gVar;
        }
        this.gVL.setPageUniqueId(this.epM);
        this.gVL.setFrom("14");
        aVar.c(this.gVL);
        ae a = aVar.a(false, viewGroup, this.aib);
        com.baidu.card.a<bk> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.epM);
        a.a(this.adt);
        a.setSourceForPb(2);
        a(new x() { // from class: com.baidu.tieba.enterForum.tabfeed.a.i.3
            @Override // com.baidu.adp.widget.ListView.x
            public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((oVar instanceof bj) && (view.getTag() instanceof ag)) {
                    com.baidu.card.a aVar3 = (com.baidu.card.a) view.getTag();
                    bk bkVar = ((bj) oVar).dEA;
                    bkVar.objType = 1;
                    if (i.this.adt != null) {
                        i.this.adt.a(aVar3.getView(), bkVar);
                    }
                    au.a((AbsThreadDataSupport) bkVar, view.getContext(), 2, false, com.baidu.card.f.a((t) viewGroup2, view, i));
                    aVar3.rM().b(new a.C0097a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bj bjVar, com.baidu.card.a<bk> aVar) {
        if (bjVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        bjVar.dEA.dDb = getPositionByType(i) + 1;
        aVar.rM().setPosition(i);
        aVar.setVideoStatsData(ak(bjVar.dEA));
        aVar.b((com.baidu.card.a<bk>) bjVar.dEA);
        aVar.rM().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.rM().a(this.adt);
        s.bLs().e(com.baidu.tieba.enterForum.a.h(bjVar.aOi(), this.mTabName));
        return aVar.getView();
    }

    private y ak(bk bkVar) {
        y yVar = null;
        if (bkVar != null) {
            yVar = new y();
            yVar.mLocate = "20";
            yVar.ais = bkVar.tid;
            yVar.mSource = bkVar.mRecomSource;
            yVar.kBr = bkVar.mRecomAbTag;
            yVar.kBs = bkVar.mRecomWeight;
            yVar.kBt = "14";
            yVar.mGroupId = this.mTabName;
            yVar.mFloor = String.valueOf(bkVar.dDb);
            if (bkVar.aRO() != null) {
                yVar.dCp = String.valueOf(bkVar.aRO().dIm);
            }
            if (bkVar.aOi() != null) {
                yVar.evm = String.valueOf(bkVar.aOi().getFid());
                yVar.kBA = bkVar.aOi().getNid();
                if (bkVar.aOi().aQQ() != null) {
                    yVar.kBw = bkVar.aOi().aQQ().video_md5;
                    yVar.kBy = String.valueOf(bkVar.aOi().aQQ().is_vertical);
                }
            }
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            if (bkVar.aOi() != null && bkVar.aOi().getBaijiahaoData() != null) {
                yVar.mNid = bkVar.aOi().getBaijiahaoData().oriUgcNid;
                yVar.mVid = bkVar.aOi().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }
}
