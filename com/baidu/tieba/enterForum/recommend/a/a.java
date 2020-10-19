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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH;
    private List<q> forumList;
    private v hUo;
    private b hUp;
    private c hUq;
    private d hUr;
    private aa<com.baidu.tieba.card.data.b> hUs = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cmY = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cmY();
                            arrayList.add(qVar);
                            arrayList.addAll(cmY);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cmX = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cmX();
                            arrayList.add(qVar);
                            arrayList.addAll(cmX);
                        }
                    }
                }
                e eVar = new e();
                eVar.hUO = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.hUo.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hUo = vVar;
        Le();
        this.hUo.addAdapters(this.bhH);
    }

    private void Le() {
        this.bhH = new ArrayList();
        this.hUp = new b(this.mPageContext);
        this.bhH.add(this.hUp);
        this.hUq = new c(this.mPageContext, this.hUs);
        this.bhH.add(this.hUq);
        this.hUr = new d(this.mPageContext);
        this.bhH.add(this.hUr);
    }

    public void notifyDataSetChanged() {
        if (this.hUo != null) {
            this.hUo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.hUo.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
