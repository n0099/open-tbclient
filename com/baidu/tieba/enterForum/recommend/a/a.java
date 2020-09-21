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
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private List<q> forumList;
    private v hFt;
    private b hFu;
    private c hFv;
    private d hFw;
    private aa<com.baidu.tieba.card.data.b> hFx = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cjC = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cjC();
                            arrayList.add(qVar);
                            arrayList.addAll(cjC);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cjB = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cjB();
                            arrayList.add(qVar);
                            arrayList.addAll(cjB);
                        }
                    }
                }
                e eVar = new e();
                eVar.hFT = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.hFt.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hFt = vVar;
        JZ();
        this.hFt.addAdapters(this.bdV);
    }

    private void JZ() {
        this.bdV = new ArrayList();
        this.hFu = new b(this.mPageContext);
        this.bdV.add(this.hFu);
        this.hFv = new c(this.mPageContext, this.hFx);
        this.bdV.add(this.hFv);
        this.hFw = new d(this.mPageContext);
        this.bdV.add(this.hFw);
    }

    public void notifyDataSetChanged() {
        if (this.hFt != null) {
            this.hFt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.hFt.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
