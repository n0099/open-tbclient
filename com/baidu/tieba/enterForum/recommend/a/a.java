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
    private s iLY;
    private b iLZ;
    private c iMa;
    private d iMb;
    private ab<BaseCardInfo> iMc = new ab<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (n nVar : a.this.forumList) {
                    if (nVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) nVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwU = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cwU();
                            arrayList.add(nVar);
                            arrayList.addAll(cwU);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwT = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cwT();
                            arrayList.add(nVar);
                            arrayList.addAll(cwT);
                        }
                    }
                }
                e eVar = new e();
                eVar.iMy = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.iLY.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iLY = sVar;
        Kw();
        this.iLY.addAdapters(this.bns);
    }

    private void Kw() {
        this.bns = new ArrayList();
        this.iLZ = new b(this.mPageContext);
        this.bns.add(this.iLZ);
        this.iMa = new c(this.mPageContext, this.iMc);
        this.bns.add(this.iMa);
        this.iMb = new d(this.mPageContext);
        this.bns.add(this.iMb);
    }

    public void notifyDataSetChanged() {
        if (this.iLY != null) {
            this.iLY.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.forumList = list;
        this.iLY.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
