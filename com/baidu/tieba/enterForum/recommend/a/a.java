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
    private List<com.baidu.adp.widget.ListView.a> asP;
    private c fXA;
    private d fXB;
    private z<com.baidu.tieba.card.data.b> fXC = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bzg = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bzg();
                            arrayList.add(mVar);
                            arrayList.addAll(bzg);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bzf = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bzf();
                            arrayList.add(mVar);
                            arrayList.addAll(bzf);
                        }
                    }
                }
                e eVar = new e();
                eVar.fXY = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fXy.setData(arrayList);
                }
            }
        }
    };
    private r fXy;
    private b fXz;
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fXy = rVar;
        wR();
        this.fXy.addAdapters(this.asP);
    }

    private void wR() {
        this.asP = new ArrayList();
        this.fXz = new b(this.mPageContext);
        this.asP.add(this.fXz);
        this.fXA = new c(this.mPageContext, this.fXC);
        this.asP.add(this.fXA);
        this.fXB = new d(this.mPageContext);
        this.asP.add(this.fXB);
    }

    public void notifyDataSetChanged() {
        if (this.fXy != null) {
            this.fXy.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fXy.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
