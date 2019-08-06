package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.s;
import com.baidu.card.a.a;
import com.baidu.card.ac;
import com.baidu.card.t;
import com.baidu.card.x;
import com.baidu.card.z;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.l;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private ab<l> VC;
    private r YY;
    private int bWN;
    private BdUniqueId cxE;
    private ac gdC;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gdC != null && this.gdC.qU() != null && this.gdC.qU().ceg() != null) {
            if (view.getId() == this.gdC.qU().ceg().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.bWN);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.bWN);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VC = new ab<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, l lVar) {
                c.this.a(view, lVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void b(r rVar) {
        this.YY = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public com.baidu.card.a<l> onCreateViewHolder(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        this.gdC = new t(this.mPageContext.getPageActivity());
        this.gdC.setPageUniqueId(this.cxE);
        this.gdC.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.b(this.gdC);
        aVar.qN().setBackgroundResource(R.color.cp_bg_line_d);
        x a = aVar.a(false, viewGroup, this.YY);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cxE);
        a.a(this.VC);
        a.bq(18);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (c.this.VC != null) {
                        c.this.VC.a(zVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false);
                    zVar.qP().b(new a.C0038a(1));
                }
            }
        });
        return aVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, l lVar, com.baidu.card.a<l> aVar) {
        if (lVar == null) {
            return aVar.getView();
        }
        if (aVar == null) {
            return null;
        }
        lVar.pJ(lVar.position + 1);
        aVar.qP().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.bWN);
        aVar.setVideoStatsData(c(lVar));
        aVar.a(lVar);
        aVar.qP().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qP().a(this.VC);
        return aVar.getView();
    }

    private com.baidu.tieba.play.z c(l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = Constants.VIA_REPORT_TYPE_START_GROUP;
            zVar.bWU = lVar.tid;
            if (lVar.acy() != null) {
                zVar.eFF = String.valueOf(lVar.acy().getFid());
                if (lVar.acy().aeP() != null) {
                    zVar.iyF = lVar.acy().aeP().video_md5;
                    zVar.iyH = String.valueOf(lVar.acy().aeP().is_vertical);
                }
            }
            zVar.bGS = lVar.bac();
            zVar.mSource = lVar.getSource();
            zVar.iyE = lVar.baa();
            zVar.iyC = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.aZZ());
            zVar.iyI = String.valueOf(this.bWN);
        }
        return zVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cxE = bdUniqueId;
    }

    public void tZ(int i) {
        this.bWN = i;
    }

    public void onPause() {
        if (this.gdC != null) {
            this.gdC.onPause();
        }
    }
}
