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
    private List<com.baidu.adp.widget.ListView.a> bbw;
    private List<q> forumList;
    private v hyr;
    private b hys;
    private c hyt;
    private d hyu;
    private aa<com.baidu.tieba.card.data.b> hyv = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cgl = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cgl();
                            arrayList.add(qVar);
                            arrayList.addAll(cgl);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cgk = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cgk();
                            arrayList.add(qVar);
                            arrayList.addAll(cgk);
                        }
                    }
                }
                e eVar = new e();
                eVar.hyR = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.hyr.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hyr = vVar;
        Jv();
        this.hyr.addAdapters(this.bbw);
    }

    private void Jv() {
        this.bbw = new ArrayList();
        this.hys = new b(this.mPageContext);
        this.bbw.add(this.hys);
        this.hyt = new c(this.mPageContext, this.hyv);
        this.bbw.add(this.hyt);
        this.hyu = new d(this.mPageContext);
        this.bbw.add(this.hyu);
    }

    public void notifyDataSetChanged() {
        if (this.hyr != null) {
            this.hyr.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.hyr.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
