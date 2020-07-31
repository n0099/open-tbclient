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
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf;
    private List<q> forumList;
    private v hlu;
    private b hlv;
    private c hlw;
    private d hlx;
    private aa<com.baidu.tieba.card.data.b> hly = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bVX = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).bVX();
                            arrayList.add(qVar);
                            arrayList.addAll(bVX);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bVW = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).bVW();
                            arrayList.add(qVar);
                            arrayList.addAll(bVW);
                        }
                    }
                }
                e eVar = new e();
                eVar.hlU = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.hlu.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hlu = vVar;
        DS();
        this.hlu.addAdapters(this.aWf);
    }

    private void DS() {
        this.aWf = new ArrayList();
        this.hlv = new b(this.mPageContext);
        this.aWf.add(this.hlv);
        this.hlw = new c(this.mPageContext, this.hly);
        this.aWf.add(this.hlw);
        this.hlx = new d(this.mPageContext);
        this.aWf.add(this.hlx);
    }

    public void notifyDataSetChanged() {
        if (this.hlu != null) {
            this.hlu.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.hlu.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aWf) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
