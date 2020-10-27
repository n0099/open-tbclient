package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje;
    private List<q> forumList;
    private v igO;
    private b igP;
    private c igQ;
    private d igR;
    private ab<com.baidu.tieba.card.data.b> igS = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cqf = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cqf();
                            arrayList.add(qVar);
                            arrayList.addAll(cqf);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cqe = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cqe();
                            arrayList.add(qVar);
                            arrayList.addAll(cqe);
                        }
                    }
                }
                e eVar = new e();
                eVar.iho = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.igO.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.igO = vVar;
        Ly();
        this.igO.addAdapters(this.bje);
    }

    private void Ly() {
        this.bje = new ArrayList();
        this.igP = new b(this.mPageContext);
        this.bje.add(this.igP);
        this.igQ = new c(this.mPageContext, this.igS);
        this.bje.add(this.igQ);
        this.igR = new d(this.mPageContext);
        this.bje.add(this.igR);
    }

    public void notifyDataSetChanged() {
        if (this.igO != null) {
            this.igO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.igO.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
