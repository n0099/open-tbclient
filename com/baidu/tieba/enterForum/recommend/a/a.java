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
    private List<com.baidu.adp.widget.ListView.a> agy;
    private r fcN;
    private b fcO;
    private c fcP;
    private d fcQ;
    private ab<com.baidu.tieba.card.data.b> fcR = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> beZ = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).beZ();
                            arrayList.add(mVar);
                            arrayList.addAll(beZ);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> beY = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).beY();
                            arrayList.add(mVar);
                            arrayList.addAll(beY);
                        }
                    }
                }
                e eVar = new e();
                eVar.fdn = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fcN.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fcN = rVar;
        sY();
        this.fcN.addAdapters(this.agy);
    }

    private void sY() {
        this.agy = new ArrayList();
        this.fcO = new b(this.mPageContext);
        this.agy.add(this.fcO);
        this.fcP = new c(this.mPageContext, this.fcR);
        this.agy.add(this.fcP);
        this.fcQ = new d(this.mPageContext);
        this.agy.add(this.fcQ);
    }

    public void notifyDataSetChanged() {
        if (this.fcN != null) {
            this.fcN.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fcN.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.agy) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
