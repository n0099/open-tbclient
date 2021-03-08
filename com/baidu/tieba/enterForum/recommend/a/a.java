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
    private List<com.baidu.adp.widget.ListView.a> boS;
    private List<n> forumList;
    private s iNH;
    private b iNI;
    private c iNJ;
    private d iNK;
    private ab<BaseCardInfo> iNL = new ab<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (n nVar : a.this.forumList) {
                    if (nVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) nVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cxa = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cxa();
                            arrayList.add(nVar);
                            arrayList.addAll(cxa);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwZ = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cwZ();
                            arrayList.add(nVar);
                            arrayList.addAll(cwZ);
                        }
                    }
                }
                e eVar = new e();
                eVar.iOh = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.iNH.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iNH = sVar;
        Kz();
        this.iNH.addAdapters(this.boS);
    }

    private void Kz() {
        this.boS = new ArrayList();
        this.iNI = new b(this.mPageContext);
        this.boS.add(this.iNI);
        this.iNJ = new c(this.mPageContext, this.iNL);
        this.boS.add(this.iNJ);
        this.iNK = new d(this.mPageContext);
        this.boS.add(this.iNK);
    }

    public void notifyDataSetChanged() {
        if (this.iNH != null) {
            this.iNH.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.forumList = list;
        this.iNH.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boS) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
