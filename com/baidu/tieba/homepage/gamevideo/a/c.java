package com.baidu.tieba.homepage.gamevideo.a;

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
import com.baidu.card.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.card.z;
import com.baidu.tieba.play.y;
/* loaded from: classes7.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private z<l> JE;
    private r Oq;
    private int cZk;
    private BdUniqueId dxg;
    private al gVS;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gVS != null && this.gVS.mY() != null && this.gVS.mY().cwW() != null) {
            if (view.getId() == this.gVS.mY().cwW().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.cZk);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.cZk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.JE = new z<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.z
            /* renamed from: b */
            public void a(View view, l lVar) {
                c.this.a(view, lVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.Oq = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        ad.a aVar = new ad.a(this.mPageContext.getPageActivity(), false);
        this.gVS = new x(this.mPageContext.getPageActivity());
        this.gVS.setPageUniqueId(this.dxg);
        this.gVS.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.c(this.gVS);
        ad a = aVar.a(false, viewGroup, this.Oq);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.dxg);
        a.a(this.JE);
        a.aM(18);
        a(new s() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof af)) {
                    af afVar = (af) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (c.this.JE != null) {
                        c.this.JE.a(afVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((r) viewGroup2, view, i));
                    afVar.mU().b(new a.C0050a(1));
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
        lVar.rm(lVar.position + 1);
        aVar.mU().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.cZk);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.mU().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.mU().a(this.JE);
        return aVar.getView();
    }

    private y c(l lVar) {
        y yVar = null;
        if (lVar != null) {
            yVar = new y();
            yVar.mLocate = "17";
            yVar.OG = lVar.tid;
            if (lVar.axQ() != null) {
                yVar.fKa = String.valueOf(lVar.axQ().getFid());
                if (lVar.axQ().aAo() != null) {
                    yVar.jvS = lVar.axQ().aAo().video_md5;
                    yVar.jvU = String.valueOf(lVar.axQ().aAo().is_vertical);
                }
            }
            yVar.cKN = lVar.getExtra();
            yVar.mSource = lVar.getSource();
            yVar.mAbTag = lVar.btL();
            yVar.jvP = lVar.getWeight();
            yVar.mUid = TbadkCoreApplication.getCurrentAccount();
            yVar.mFloor = String.valueOf(lVar.btK());
            yVar.jvV = String.valueOf(this.cZk);
        }
        return yVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.dxg = bdUniqueId;
    }

    public void vf(int i) {
        this.cZk = i;
    }

    public void onPause() {
        if (this.gVS != null) {
            this.gVS.onPause();
        }
    }
}
