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
    private ab<l> Fq;
    private r IY;
    private BdUniqueId cKf;
    private int cmL;
    private ac geR;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.geR != null && this.geR.ma() != null && this.geR.ma().cbX() != null) {
            if (view.getId() == this.geR.ma().cbX().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.cmL);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.cmL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.Fq = new ab<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
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
        this.IY = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aQ */
    public com.baidu.card.a<l> b(ViewGroup viewGroup) {
        x.a aVar = new x.a(this.mPageContext.getPageActivity(), false);
        this.geR = new t(this.mPageContext.getPageActivity());
        this.geR.setPageUniqueId(this.cKf);
        this.geR.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        aVar.b(this.geR);
        x a = aVar.a(false, viewGroup, this.IY);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a);
        aVar2.setPageId(this.cKf);
        a.b(this.Fq);
        a.aF(18);
        a(new s() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.s
            public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((mVar instanceof l) && (view.getTag() instanceof z)) {
                    z zVar = (z) view.getTag();
                    l lVar = (l) mVar;
                    lVar.objType = 1;
                    if (c.this.Fq != null) {
                        c.this.Fq.a(zVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false);
                    zVar.lV().b(new a.C0044a(1));
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
        lVar.oP(lVar.position + 1);
        aVar.lV().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.cmL);
        aVar.setVideoStatsData(c(lVar));
        aVar.a(lVar);
        aVar.lV().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.lV().b(this.Fq);
        return aVar.getView();
    }

    private com.baidu.tieba.play.z c(l lVar) {
        com.baidu.tieba.play.z zVar = null;
        if (lVar != null) {
            zVar = new com.baidu.tieba.play.z();
            zVar.mLocate = Constants.VIA_REPORT_TYPE_START_GROUP;
            zVar.cmS = lVar.tid;
            if (lVar.agI() != null) {
                zVar.ePT = String.valueOf(lVar.agI().getFid());
                if (lVar.agI().aiX() != null) {
                    zVar.ize = lVar.agI().aiX().video_md5;
                    zVar.izg = String.valueOf(lVar.agI().aiX().is_vertical);
                }
            }
            zVar.bZb = lVar.getExtra();
            zVar.mSource = lVar.getSource();
            zVar.izd = lVar.baH();
            zVar.izb = lVar.getWeight();
            zVar.mUid = TbadkCoreApplication.getCurrentAccount();
            zVar.mFloor = String.valueOf(lVar.baG());
            zVar.izh = String.valueOf(this.cmL);
        }
        return zVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.cKf = bdUniqueId;
    }

    public void sY(int i) {
        this.cmL = i;
    }

    public void onPause() {
        if (this.geR != null) {
            this.geR.onPause();
        }
    }
}
