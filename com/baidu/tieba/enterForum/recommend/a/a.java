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
    private List<com.baidu.adp.widget.ListView.a> asE;
    private r fWB;
    private b fWC;
    private c fWD;
    private d fWE;
    private z<com.baidu.tieba.card.data.b> fWF = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> byX = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).byX();
                            arrayList.add(mVar);
                            arrayList.addAll(byX);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> byW = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).byW();
                            arrayList.add(mVar);
                            arrayList.addAll(byW);
                        }
                    }
                }
                e eVar = new e();
                eVar.fXb = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fWB.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWB = rVar;
        wM();
        this.fWB.addAdapters(this.asE);
    }

    private void wM() {
        this.asE = new ArrayList();
        this.fWC = new b(this.mPageContext);
        this.asE.add(this.fWC);
        this.fWD = new c(this.mPageContext, this.fWF);
        this.asE.add(this.fWD);
        this.fWE = new d(this.mPageContext);
        this.asE.add(this.fWE);
    }

    public void notifyDataSetChanged() {
        if (this.fWB != null) {
            this.fWB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fWB.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
