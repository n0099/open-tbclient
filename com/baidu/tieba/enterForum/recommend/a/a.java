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
    private r eYZ;
    private b eZa;
    private c eZb;
    private d eZc;
    private ab<com.baidu.tieba.card.data.b> eZd = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bgy = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bgy();
                            arrayList.add(mVar);
                            arrayList.addAll(bgy);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bgx = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bgx();
                            arrayList.add(mVar);
                            arrayList.addAll(bgx);
                        }
                    }
                }
                e eVar = new e();
                eVar.eZz = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.eYZ.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eYZ = rVar;
        initAdapters();
        this.eYZ.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.eZa = new b(this.mPageContext);
        this.mAdapters.add(this.eZa);
        this.eZb = new c(this.mPageContext, this.eZd);
        this.mAdapters.add(this.eZb);
        this.eZc = new d(this.mPageContext);
        this.mAdapters.add(this.eZc);
    }

    public void notifyDataSetChanged() {
        if (this.eYZ != null) {
            this.eYZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.eYZ.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
