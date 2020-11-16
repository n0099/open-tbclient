package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN;
    private List<q> forumList;
    private v inB;
    private b inC;
    private c inD;
    private d inE;
    private ab<BaseCardInfo> inF = new ab<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> csj = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).csj();
                            arrayList.add(qVar);
                            arrayList.addAll(csj);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> csi = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).csi();
                            arrayList.add(qVar);
                            arrayList.addAll(csi);
                        }
                    }
                }
                e eVar = new e();
                eVar.iob = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.inB.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.inB = vVar;
        Lp();
        this.inB.addAdapters(this.biN);
    }

    private void Lp() {
        this.biN = new ArrayList();
        this.inC = new b(this.mPageContext);
        this.biN.add(this.inC);
        this.inD = new c(this.mPageContext, this.inF);
        this.biN.add(this.inD);
        this.inE = new d(this.mPageContext);
        this.biN.add(this.inE);
    }

    public void notifyDataSetChanged() {
        if (this.inB != null) {
            this.inB.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.inB.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
