package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agQ;
    private r fdE;
    private b fdF;
    private c fdG;
    private d fdH;
    private ab<com.baidu.tieba.card.data.b> fdI = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bfb = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bfb();
                            arrayList.add(mVar);
                            arrayList.addAll(bfb);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bfa = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bfa();
                            arrayList.add(mVar);
                            arrayList.addAll(bfa);
                        }
                    }
                }
                e eVar = new e();
                eVar.fee = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fdE.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fdE = rVar;
        sX();
        this.fdE.addAdapters(this.agQ);
    }

    private void sX() {
        this.agQ = new ArrayList();
        this.fdF = new b(this.mPageContext);
        this.agQ.add(this.fdF);
        this.fdG = new c(this.mPageContext, this.fdI);
        this.agQ.add(this.fdG);
        this.fdH = new d(this.mPageContext);
        this.agQ.add(this.fdH);
    }

    public void notifyDataSetChanged() {
        if (this.fdE != null) {
            this.fdE.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fdE.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agQ) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
