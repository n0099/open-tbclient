package com.baidu.tieba.homepage.video.a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.card.b;
import com.baidu.card.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes22.dex */
public class b extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private ab<l> agG;
    private v amH;
    private BdUniqueId fzO;
    private at iBk;
    private com.baidu.tieba.homepage.personalize.model.e jSO;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.iBk != null && this.iBk.uf() != null && this.iBk.uf().dBH() != null) {
            if (view.getId() == this.iBk.uf().dBH().getId()) {
                com.baidu.tieba.homepage.video.c.a.r(lVar);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.video.c.a.p(lVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new ab<l>() { // from class: com.baidu.tieba.homepage.video.a.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, l lVar) {
                if (view != null && lVar != null && lVar.bmn() != null) {
                    b.this.a(view, lVar);
                    if (b.this.jSO != null && (view.getTag() instanceof String) && !com.baidu.tieba.homepage.personalize.f.gA(com.baidu.adp.lib.f.b.toLong(lVar.bmn().getTid(), 0L))) {
                        com.baidu.tieba.homepage.personalize.f.gz(com.baidu.adp.lib.f.b.toLong(lVar.bmn().getTid(), 0L));
                        b.this.jSO.a(com.baidu.adp.lib.f.b.toLong(lVar.bmn().getTid(), 0L), lVar.getWeight(), lVar.getSource(), lVar.css(), lVar.cst(), com.baidu.adp.lib.f.b.toInt("3", 1), "video_tab", lVar.bmn().getBaijiahaoData());
                    }
                }
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(v vVar) {
        this.amH = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aS */
    public com.baidu.card.a<l> c(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        final h hVar = new h(this.mPageContext.getPageActivity());
        hVar.a(new b.a() { // from class: com.baidu.tieba.homepage.video.a.b.2
            @Override // com.baidu.card.b.a
            public void a(com.baidu.tbadk.core.data.a aVar2) {
                if (aVar2 != null) {
                    Rect bn = az.bn(hVar.getVideoContainer());
                    if (aVar2 instanceof l) {
                        aVar2.objType = 5;
                        com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                        com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bn);
                        return;
                    }
                    com.baidu.tieba.homepage.video.c.a.p((com.baidu.tieba.card.data.b) aVar2);
                    com.baidu.tieba.homepage.video.c.a.a(aVar2, b.this.mContext, 19, false, bn);
                }
            }
        });
        this.iBk = hVar;
        this.iBk.setPageUniqueId(this.fzO);
        this.iBk.setFrom("video_tab");
        this.iBk.setStageType("2001");
        aVar.c(this.iBk);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fzO);
        a2.a(this.agG);
        a2.setSourceForPb(19);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.video.a.b.3
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (b.this.agG != null) {
                        b.this.agG.a(amVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.video.c.a.a(lVar, view.getContext(), 19, false, com.baidu.card.f.a((v) viewGroup2, view, i));
                    amVar.tZ().b(new a.C0097a(1));
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
        lVar.ym(lVar.position + 1);
        aVar.tZ().setPosition(i);
        aVar.setVideoStatsData(c(lVar));
        com.baidu.tieba.homepage.video.c.a.n(lVar);
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tZ().a(this.agG);
        return aVar.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_ACT_TYPE_NINETEEN;
            oVar.amY = lVar.tid;
            if (lVar.bmn() != null) {
                oVar.fFV = String.valueOf(lVar.bmn().getFid());
                oVar.myx = lVar.bmn().getNid();
                if (lVar.bmn().bph() != null) {
                    oVar.myt = lVar.bmn().bph().video_md5;
                    oVar.myv = String.valueOf(lVar.bmn().bph().is_vertical);
                }
            }
            oVar.eGn = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mys = lVar.cst();
            oVar.myp = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.css());
            if (lVar.bmn() != null && lVar.bmn().getBaijiahaoData() != null) {
                oVar.mNid = lVar.bmn().getBaijiahaoData().oriUgcNid;
                oVar.mVid = lVar.bmn().getBaijiahaoData().oriUgcVid;
            }
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fzO = bdUniqueId;
    }

    public void b(com.baidu.tieba.homepage.personalize.model.e eVar) {
        this.jSO = eVar;
    }

    public void onPause() {
        if (this.iBk != null) {
            this.iBk.onPause();
        }
    }
}
