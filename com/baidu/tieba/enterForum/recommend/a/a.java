package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns;
    private List<n> forumList;
    private s iLK;
    private b iLL;
    private c iLM;
    private d iLN;
    private ab<BaseCardInfo> iLO = new ab<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (n nVar : a.this.forumList) {
                    if (nVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) nVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwN = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cwN();
                            arrayList.add(nVar);
                            arrayList.addAll(cwN);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwM = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cwM();
                            arrayList.add(nVar);
                            arrayList.addAll(cwM);
                        }
                    }
                }
                e eVar = new e();
                eVar.iMk = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.iLK.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLK = sVar;
        Kw();
        this.iLK.addAdapters(this.bns);
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.iLL = new b(this.mPageContext);
        this.bns.add(this.iLL);
        this.iLM = new c(this.mPageContext, this.iLO);
        this.bns.add(this.iLM);
        this.iLN = new d(this.mPageContext);
        this.bns.add(this.iLN);
    }

    public void notifyDataSetChanged() {
        if (this.iLK != null) {
            this.iLK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.forumList = list;
        this.iLK.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
