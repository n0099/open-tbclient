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
    private r eEr;
    private b eEs;
    private c eEt;
    private d eEu;
    private ab<com.baidu.tieba.card.data.b> eEv = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> aXg = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).aXg();
                            arrayList.add(mVar);
                            arrayList.addAll(aXg);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> aXf = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).aXf();
                            arrayList.add(mVar);
                            arrayList.addAll(aXf);
                        }
                    }
                }
                e eVar = new e();
                eVar.eER = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.eEr.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eEr = rVar;
        initAdapters();
        this.eEr.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.eEs = new b(this.mPageContext);
        this.mAdapters.add(this.eEs);
        this.eEt = new c(this.mPageContext, this.eEv);
        this.mAdapters.add(this.eEt);
        this.eEu = new d(this.mPageContext);
        this.mAdapters.add(this.eEu);
    }

    public void notifyDataSetChanged() {
        if (this.eEr != null) {
            this.eEr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.eEr.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
