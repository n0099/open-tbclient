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
    private r eEd;
    private b eEe;
    private c eEf;
    private d eEg;
    private ab<com.baidu.tieba.card.data.b> eEh = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> aXe = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).aXe();
                            arrayList.add(mVar);
                            arrayList.addAll(aXe);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> aXd = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).aXd();
                            arrayList.add(mVar);
                            arrayList.addAll(aXd);
                        }
                    }
                }
                e eVar = new e();
                eVar.eED = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.eEd.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEd = rVar;
        initAdapters();
        this.eEd.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.eEe = new b(this.mPageContext);
        this.mAdapters.add(this.eEe);
        this.eEf = new c(this.mPageContext, this.eEh);
        this.mAdapters.add(this.eEf);
        this.eEg = new d(this.mPageContext);
        this.mAdapters.add(this.eEg);
    }

    public void notifyDataSetChanged() {
        if (this.eEd != null) {
            this.eEd.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.eEd.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
