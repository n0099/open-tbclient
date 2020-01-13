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
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> apl;
    private r fUA;
    private b fUB;
    private c fUC;
    private d fUD;
    private z<com.baidu.tieba.card.data.b> fUE = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bxv = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bxv();
                            arrayList.add(mVar);
                            arrayList.addAll(bxv);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bxu = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bxu();
                            arrayList.add(mVar);
                            arrayList.addAll(bxu);
                        }
                    }
                }
                e eVar = new e();
                eVar.fVa = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fUA.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fUA = rVar;
        vi();
        this.fUA.addAdapters(this.apl);
    }

    private void vi() {
        this.apl = new ArrayList();
        this.fUB = new b(this.mPageContext);
        this.apl.add(this.fUB);
        this.fUC = new c(this.mPageContext, this.fUE);
        this.apl.add(this.fUC);
        this.fUD = new d(this.mPageContext);
        this.apl.add(this.fUD);
    }

    public void notifyDataSetChanged() {
        if (this.fUA != null) {
            this.fUA.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fUA.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.apl) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
