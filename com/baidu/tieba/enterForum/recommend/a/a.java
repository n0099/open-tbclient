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
    private r eTX;
    private b eTY;
    private c eTZ;
    private d eUa;
    private ab<com.baidu.tieba.card.data.b> eUb = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bes = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bes();
                            arrayList.add(mVar);
                            arrayList.addAll(bes);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> ber = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).ber();
                            arrayList.add(mVar);
                            arrayList.addAll(ber);
                        }
                    }
                }
                e eVar = new e();
                eVar.eUx = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.eTX.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private List<com.baidu.adp.widget.ListView.a> mAdapters;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.eTX = rVar;
        initAdapters();
        this.eTX.addAdapters(this.mAdapters);
    }

    private void initAdapters() {
        this.mAdapters = new ArrayList();
        this.eTY = new b(this.mPageContext);
        this.mAdapters.add(this.eTY);
        this.eTZ = new c(this.mPageContext, this.eUb);
        this.mAdapters.add(this.eTZ);
        this.eUa = new d(this.mPageContext);
        this.mAdapters.add(this.eUa);
    }

    public void notifyDataSetChanged() {
        if (this.eTX != null) {
            this.eTX.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.eTX.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
