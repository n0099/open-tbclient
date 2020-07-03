package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP;
    private List<q> forumList;
    private v hfK;
    private b hfL;
    private c hfM;
    private d hfN;
    private aa<com.baidu.tieba.card.data.b> hfO = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bSF = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).bSF();
                            arrayList.add(qVar);
                            arrayList.addAll(bSF);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bSE = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).bSE();
                            arrayList.add(qVar);
                            arrayList.addAll(bSE);
                        }
                    }
                }
                e eVar = new e();
                eVar.hgk = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.hfK.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hfK = vVar;
        Dz();
        this.hfK.addAdapters(this.aUP);
    }

    private void Dz() {
        this.aUP = new ArrayList();
        this.hfL = new b(this.mPageContext);
        this.aUP.add(this.hfL);
        this.hfM = new c(this.mPageContext, this.hfO);
        this.aUP.add(this.hfM);
        this.hfN = new d(this.mPageContext);
        this.aUP.add(this.hfN);
    }

    public void notifyDataSetChanged() {
        if (this.hfK != null) {
            this.hfK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.hfK.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
