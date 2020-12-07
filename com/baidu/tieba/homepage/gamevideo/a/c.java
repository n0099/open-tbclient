package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.card.a.a;
import com.baidu.card.ac;
import com.baidu.card.ak;
import com.baidu.card.am;
import com.baidu.card.at;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
/* loaded from: classes22.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, com.baidu.card.a<l>> {
    private ab<l> agG;
    private v amH;
    private int eXm;
    private BdUniqueId fzO;
    private at iBk;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, l lVar) {
        if (this.iBk != null && this.iBk.uf() != null && this.iBk.uf().dBH() != null) {
            if (view.getId() == this.iBk.uf().dBH().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.eXm);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.eXm);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.agG = new ab<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            /* renamed from: b */
            public void a(View view, l lVar) {
                c.this.a(view, lVar);
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
        this.iBk = new ac(this.mPageContext.getPageActivity());
        this.iBk.setPageUniqueId(this.fzO);
        this.iBk.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.iBk.setStageType("2001");
        aVar.c(this.iBk);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.amH);
        com.baidu.card.a<l> aVar2 = new com.baidu.card.a<>(a2);
        aVar2.setPageId(this.fzO);
        a2.a(this.agG);
        a2.setSourceForPb(18);
        a(new com.baidu.adp.widget.ListView.ab() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.ab
            public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((qVar instanceof l) && (view.getTag() instanceof am)) {
                    am amVar = (am) view.getTag();
                    l lVar = (l) qVar;
                    lVar.objType = 1;
                    if (c.this.agG != null) {
                        c.this.agG.a(amVar.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.f.a((v) viewGroup2, view, i));
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
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.eXm);
        aVar.setVideoStatsData(c(lVar));
        aVar.b((com.baidu.card.a<l>) lVar);
        aVar.tZ().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        aVar.tZ().a(this.agG);
        return aVar.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = "17";
            oVar.amY = lVar.tid;
            if (lVar.bmn() != null) {
                oVar.fFV = String.valueOf(lVar.bmn().getFid());
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
            oVar.myw = String.valueOf(this.eXm);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fzO = bdUniqueId;
    }

    public void CQ(int i) {
        this.eXm = i;
    }

    public void onPause() {
        if (this.iBk != null) {
            this.iBk.onPause();
        }
    }
}
