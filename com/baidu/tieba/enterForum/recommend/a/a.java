package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM;
    private List<n> forumList;
    private s iKI;
    private b iKJ;
    private c iKK;
    private d iKL;
    private aa<BaseCardInfo> iKM = new aa<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (n nVar : a.this.forumList) {
                    if (nVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) nVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> czs = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).czs();
                            arrayList.add(nVar);
                            arrayList.addAll(czs);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> czr = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).czr();
                            arrayList.add(nVar);
                            arrayList.addAll(czr);
                        }
                    }
                }
                e eVar = new e();
                eVar.iLi = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.iKI.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iKI = sVar;
        MT();
        this.iKI.addAdapters(this.boM);
    }

    private void MT() {
        this.boM = new ArrayList();
        this.iKJ = new b(this.mPageContext);
        this.boM.add(this.iKJ);
        this.iKK = new c(this.mPageContext, this.iKM);
        this.boM.add(this.iKK);
        this.iKL = new d(this.mPageContext);
        this.boM.add(this.iKL);
    }

    public void notifyDataSetChanged() {
        if (this.iKI != null) {
            this.iKI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.forumList = list;
        this.iKI.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
