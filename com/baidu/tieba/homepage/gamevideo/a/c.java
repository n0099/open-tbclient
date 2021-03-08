package com.baidu.tieba.homepage.gamevideo.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.w;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.card.a.a;
import com.baidu.card.ac;
import com.baidu.card.ak;
import com.baidu.card.as;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.card.data.l;
import com.baidu.tieba.play.o;
import com.tencent.connect.common.Constants;
/* loaded from: classes2.dex */
public class c extends com.baidu.adp.widget.ListView.a<l, AutoVideoCardViewHolder<l>> {
    private ab<l> ahy;
    private s anC;
    private BdUniqueId fIy;
    private int ffT;
    private as iQw;
    private TbPageContext mPageContext;

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, l lVar) {
        if (this.iQw != null && this.iQw.tq() != null && this.iQw.tq().dAf() != null) {
            if (view.getId() == this.iQw.tq().dAf().getId()) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.ffT);
            } else if (view.getId() == R.id.thread_card_root) {
                com.baidu.tieba.homepage.gamevideo.e.a.b(lVar, this.ffT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.ahy = new ab<l>() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.card.ab
            public void a(View view, l lVar) {
                c.this.b(view, lVar);
            }
        };
        this.mPageContext = tbPageContext;
    }

    public void a(s sVar) {
        this.anC = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: be */
    public AutoVideoCardViewHolder<l> e(ViewGroup viewGroup) {
        ak.a aVar = new ak.a(this.mPageContext.getPageActivity(), false);
        this.iQw = new ac(this.mPageContext.getPageActivity());
        this.iQw.setPageUniqueId(this.fIy);
        this.iQw.setFrom(ImageViewerConfig.FROM_GAME_VIDEO);
        this.iQw.setStageType("2001");
        aVar.c(this.iQw);
        ak a2 = aVar.a(BaseCardInfo.SupportType.CONTENT, viewGroup, this.anC);
        AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(a2);
        autoVideoCardViewHolder.setPageId(this.fIy);
        a2.a(this.ahy);
        a2.setSourceForPb(18);
        a(new w() { // from class: com.baidu.tieba.homepage.gamevideo.a.c.2
            @Override // com.baidu.adp.widget.ListView.w
            public void a(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup2, int i, long j) {
                if ((nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                    ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                    l lVar = (l) nVar;
                    lVar.objType = 1;
                    if (c.this.ahy != null) {
                        c.this.ahy.a(threadCardViewHolder.getView(), lVar);
                    }
                    com.baidu.tieba.homepage.gamevideo.e.a.a(lVar, view.getContext(), 18, false, com.baidu.card.e.a((s) viewGroup2, view, i));
                    threadCardViewHolder.tj().b(new a.C0095a(1));
                }
            }
        });
        return autoVideoCardViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder<l> autoVideoCardViewHolder) {
        if (lVar == null) {
            return autoVideoCardViewHolder.getView();
        }
        if (autoVideoCardViewHolder == null) {
            return null;
        }
        lVar.xe(lVar.position + 1);
        autoVideoCardViewHolder.tj().setPosition(i);
        com.baidu.tieba.homepage.gamevideo.e.a.d(lVar, this.ffT);
        autoVideoCardViewHolder.setVideoStatsData(c(lVar));
        autoVideoCardViewHolder.b((AutoVideoCardViewHolder<l>) lVar);
        autoVideoCardViewHolder.tj().onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        autoVideoCardViewHolder.tj().a(this.ahy);
        return autoVideoCardViewHolder.getView();
    }

    private o c(l lVar) {
        o oVar = null;
        if (lVar != null) {
            oVar = new o();
            oVar.mLocate = Constants.VIA_REPORT_TYPE_START_GROUP;
            oVar.anU = lVar.tid;
            if (lVar.blp() != null) {
                oVar.fOD = String.valueOf(lVar.blp().getFid());
                if (lVar.blp().boj() != null) {
                    oVar.mKE = lVar.blp().boj().video_md5;
                    oVar.mKG = String.valueOf(lVar.blp().boj().is_vertical);
                }
            }
            oVar.ePf = lVar.getExtra();
            oVar.mSource = lVar.getSource();
            oVar.mKD = lVar.csV();
            oVar.mKA = lVar.getWeight();
            oVar.mUid = TbadkCoreApplication.getCurrentAccount();
            oVar.mFloor = String.valueOf(lVar.csU());
            oVar.mKH = String.valueOf(this.ffT);
        }
        return oVar;
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        this.fIy = bdUniqueId;
    }

    public void BQ(int i) {
        this.ffT = i;
    }

    public void onPause() {
        if (this.iQw != null) {
            this.iQw.onPause();
        }
    }
}
