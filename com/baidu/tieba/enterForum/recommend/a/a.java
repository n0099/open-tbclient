package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj;
    private List<o> forumList;
    private t gSQ;
    private b gSR;
    private c gSS;
    private d gST;
    private aa<com.baidu.tieba.card.data.b> gSU = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (o oVar : a.this.forumList) {
                    if (oVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) oVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bPA = ((com.baidu.tieba.enterForum.recommend.b.d) oVar).bPA();
                            arrayList.add(oVar);
                            arrayList.addAll(bPA);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bPz = ((com.baidu.tieba.enterForum.recommend.b.d) oVar).bPz();
                            arrayList.add(oVar);
                            arrayList.addAll(bPz);
                        }
                    }
                }
                e eVar = new e();
                eVar.gTq = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.gSQ.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, t tVar) {
        this.mPageContext = tbPageContext;
        this.gSQ = tVar;
        CY();
        this.gSQ.addAdapters(this.aSj);
    }

    private void CY() {
        this.aSj = new ArrayList();
        this.gSR = new b(this.mPageContext);
        this.aSj.add(this.gSR);
        this.gSS = new c(this.mPageContext, this.gSU);
        this.aSj.add(this.gSS);
        this.gST = new d(this.mPageContext);
        this.aSj.add(this.gST);
    }

    public void notifyDataSetChanged() {
        if (this.gSQ != null) {
            this.gSQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<o> list) {
        this.forumList = list;
        this.gSQ.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
