package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ad;
import com.baidu.card.af;
import com.baidu.card.al;
import com.baidu.card.b;
import com.baidu.card.g;
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.z;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes9.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private z<l> JZ;
    private r OT;
    private BdUniqueId dBK;
    private al gZo;
    private com.baidu.tieba.homepage.personalize.model.e heO;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gZo != null && this.gZo.np() != null && this.gZo.np().cyL() != null) {
            if (view.getId() == this.gZo.np().cyL().getId()) {
                com.baidu.tieba.homepage.video.c.a.o(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.m(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JZ = new z<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.aAj() != null) {
                    b.this.a(view, lVar);
                    if (b.this.heO != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.dD(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.dC(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L));
                        b.this.heO.a(com.baidu.adp.lib.f.b.toLong(lVar.aAj().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.bvw(), lVar.bvx(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.aAj().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.OT = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        if (TbSingleton.getInstance().isVideoEnterMiddlePage()) {
            final g gVar = new g(this.mPageContext.getPageActivity());
            gVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
                @Override // com.baidu.card.b.a
                public void a(com.baidu.tbadk.core.data.a aVar2) {
                    if (aVar2 != null) {
                        Rect aP = au.aP(gVar.getVideoContainer());
                        if (aVar2 instanceof l) {
                            aVar2.objType = 5;
                            com.baidu.tieba.homepage.video.c.a.m((com.baidu.tieba.card.data.c) aVar2);
                            com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, aP);
                            return;
                        }
                        com.baidu.tieba.homepage.video.c.a.m((com.baidu.tieba.card.data.c) aVar2);
                        com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, aP);
                    }
                }
            });
            this.gZo = gVar;
        } else {
            this.gZo = new x(this.mPageContext.getPageActivity());
        }
        this.gZo.setPageUniqueId(this.dBK);
        this.gZo.setFrom("video_tab");
        aVar.c(this.gZo);
        ad a = aVar.a(false, viewGroup, this.OT);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.dBK);
        a.a(this.JZ);
        a.aQ(19);
        a(new s() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (b.this.JZ != null) {
                        b.this.JZ.a(afVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar.nk().b(new a.C0052a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.card.a<l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.rv(lVar.position + 1);
        aVar.nk().setPosition(i);
        aVar.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.k(lVar);
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.nk().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.nk().a(this.JZ);
        return aVar.getView();
    }

    private y c(l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            yVar.Pk = lVar.tid;
            if (lVar.aAj() != null) {
                yVar.emF = String.valueOf(lVar.aAj().getFid());
                if (lVar.aAj().aCI() != null) {
                    yVar.jyv = lVar.aAj().aCI().video_md5;
                    yVar.jyx = String.valueOf(lVar.aAj().aCI().is_vertical);
                }
            }
            yVar.cPf = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.bvx();
            yVar.jys = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.bvw());
            if (lVar.aAj() != null && lVar.aAj().getBaijiahaoData() != null) {
                yVar.mNid = lVar.aAj().getBaijiahaoData().oriUgcNid;
                yVar.mVid = lVar.aAj().getBaijiahaoData().oriUgcVid;
            }
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dBK = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.heO = eVar;
    }

    public void onPause() {
        if (this.gZo != null) {
            this.gZo.onPause();
        }
    }
}
