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
    private r eZn;
    private b eZo;
    private c eZp;
    private d eZq;
    private ab<com.baidu.tieba.card.data.b> eZr = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bgB = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bgB();
                            arrayList.add(mVar);
                            arrayList.addAll(bgB);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bgA = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bgA();
                            arrayList.add(mVar);
                            arrayList.addAll(bgA);
                        }
                    }
                }
                e eVar = new e();
                eVar.eZN = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.eZn.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eZn = rVar;
        initAdapters();
        this.eZn.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.eZo = new b(this.mPageContext);
        this.mAdapters.add(this.eZo);
        this.eZp = new c(this.mPageContext, this.eZr);
        this.mAdapters.add(this.eZp);
        this.eZq = new d(this.mPageContext);
        this.mAdapters.add(this.eZq);
    }

    public void notifyDataSetChanged() {
        if (this.eZn != null) {
            this.eZn.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.eZn.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
