package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.z;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMj;
    private List<m> forumList;
    private r gEi;
    private b gEj;
    private c gEk;
    private d gEl;
    private z<com.baidu.tieba.card.data.b> gEm = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bJg = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bJg();
                            arrayList.add(mVar);
                            arrayList.addAll(bJg);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bJf = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bJf();
                            arrayList.add(mVar);
                            arrayList.addAll(bJf);
                        }
                    }
                }
                e eVar = new e();
                eVar.gEI = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.gEi.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.gEi = rVar;
        BB();
        this.gEi.addAdapters(this.aMj);
    }

    private void BB() {
        this.aMj = new ArrayList();
        this.gEj = new b(this.mPageContext);
        this.aMj.add(this.gEj);
        this.gEk = new c(this.mPageContext, this.gEm);
        this.aMj.add(this.gEk);
        this.gEl = new d(this.mPageContext);
        this.aMj.add(this.gEl);
    }

    public void notifyDataSetChanged() {
        if (this.gEi != null) {
            this.gEi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.gEi.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMj) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
