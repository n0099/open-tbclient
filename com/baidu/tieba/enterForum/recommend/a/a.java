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
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz;
    private r fRq;
    private b fRr;
    private c fRs;
    private d fRt;
    private z<com.baidu.tieba.card.data.b> fRu = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bwt = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bwt();
                            arrayList.add(mVar);
                            arrayList.addAll(bwt);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bws = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bws();
                            arrayList.add(mVar);
                            arrayList.addAll(bws);
                        }
                    }
                }
                e eVar = new e();
                eVar.fRQ = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fRq.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fRq = rVar;
        uR();
        this.fRq.addAdapters(this.aoz);
    }

    private void uR() {
        this.aoz = new ArrayList();
        this.fRr = new b(this.mPageContext);
        this.aoz.add(this.fRr);
        this.fRs = new c(this.mPageContext, this.fRu);
        this.aoz.add(this.fRs);
        this.fRt = new d(this.mPageContext);
        this.aoz.add(this.fRt);
    }

    public void notifyDataSetChanged() {
        if (this.fRq != null) {
            this.fRq.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fRq.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aoz) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
