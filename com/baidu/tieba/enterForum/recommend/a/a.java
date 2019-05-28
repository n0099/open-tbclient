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
    private r eTY;
    private b eTZ;
    private c eUa;
    private d eUb;
    private ab<com.baidu.tieba.card.data.b> eUc = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bev = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bev();
                            arrayList.add(mVar);
                            arrayList.addAll(bev);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> beu = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).beu();
                            arrayList.add(mVar);
                            arrayList.addAll(beu);
                        }
                    }
                }
                e eVar = new e();
                eVar.eUy = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.eTY.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTY = rVar;
        initAdapters();
        this.eTY.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.eTZ = new b(this.mPageContext);
        this.mAdapters.add(this.eTZ);
        this.eUa = new c(this.mPageContext, this.eUc);
        this.mAdapters.add(this.eUa);
        this.eUb = new d(this.mPageContext);
        this.mAdapters.add(this.eUb);
    }

    public void notifyDataSetChanged() {
        if (this.eTY != null) {
            this.eTY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.eTY.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
