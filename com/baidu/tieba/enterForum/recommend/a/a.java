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
    private List<com.baidu.adp.widget.ListView.a> asF;
    private r fWQ;
    private b fWR;
    private c fWS;
    private d fWT;
    private z<com.baidu.tieba.card.data.b> fWU = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bza = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bza();
                            arrayList.add(mVar);
                            arrayList.addAll(bza);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> byZ = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).byZ();
                            arrayList.add(mVar);
                            arrayList.addAll(byZ);
                        }
                    }
                }
                e eVar = new e();
                eVar.fXq = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fWQ.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWQ = rVar;
        wM();
        this.fWQ.addAdapters(this.asF);
    }

    private void wM() {
        this.asF = new ArrayList();
        this.fWR = new b(this.mPageContext);
        this.asF.add(this.fWR);
        this.fWS = new c(this.mPageContext, this.fWU);
        this.asF.add(this.fWS);
        this.fWT = new d(this.mPageContext);
        this.asF.add(this.fWT);
    }

    public void notifyDataSetChanged() {
        if (this.fWQ != null) {
            this.fWQ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fWQ.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
