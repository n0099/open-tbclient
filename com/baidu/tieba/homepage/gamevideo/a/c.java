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
    private ab<l> VB;
    private r YY;
    private int bXG;
    private BdUniqueId cyA;
    private ac gfu;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.gfu != null && this.gfu.qV() != null && this.gfu.qV().ceV() != null) {
            if (view.getId() == this.gfu.qV().ceV().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.bXG);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.bXG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.VB = new ab<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
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
        this.gfu = new t(this.mPageContext.getPageActivity());
        this.gfu.setPageUniqueId(this.cyA);
        this.gfu.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.b(this.gfu);
        x a = aVar.a(false, viewGroup, this.YY);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cyA);
        a.a(this.VB);
        a.bq(18);
        setOnAdapterItemClickListener(new s() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (c.this.VB != null) {
                        c.this.VB.a(zVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false);
                    zVar.qQ().b(new a.C0038a(1));
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
        lVar.pN(lVar.position + 1);
        aVar.qQ().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.bXG);
        aVar.setVideoStatsData(c(lVar));
        aVar.a(lVar);
        aVar.qQ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.qQ().a(this.VB);
        return aVar.getView();
    }

    private com.baidu.tieba.play.z c(l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = Constants.VIA_REPORT_TYPE_START_GROUP;
            zVar.bXN = lVar.tid;
            if (lVar.acC() != null) {
                zVar.eHo = String.valueOf(lVar.acC().getFid());
                if (lVar.acC().aeT() != null) {
                    zVar.iAH = lVar.acC().aeT().video_md5;
                    zVar.iAJ = String.valueOf(lVar.acC().aeT().is_vertical);
                }
            }
            zVar.bHq = lVar.baG();
            zVar.mSource = lVar.getSource();
            zVar.iAG = lVar.baE();
            zVar.iAE = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baD());
            zVar.iAK = String.valueOf(this.bXG);
        }
        return zVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cyA = bdUniqueId;
    }

    public void ud(int i) {
        this.bXG = i;
    }

    public void onPause() {
        if (this.gfu != null) {
            this.gfu.onPause();
        }
    }
}
