package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.z;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMd;
    private List<m> forumList;
    private r gEc;
    private b gEd;
    private c gEe;
    private d gEf;
    private z<com.baidu.tieba.card.data.b> gEg = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bJi = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bJi();
                            arrayList.add(mVar);
                            arrayList.addAll(bJi);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bJh = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).bJh();
                            arrayList.add(mVar);
                            arrayList.addAll(bJh);
                        }
                    }
                }
                e eVar = new e();
                eVar.gEC = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.gEc.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.gEc = rVar;
        BC();
        this.gEc.addAdapters(this.aMd);
    }

    private void BC() {
        this.aMd = new ArrayList();
        this.gEd = new b(this.mPageContext);
        this.aMd.add(this.gEd);
        this.gEe = new c(this.mPageContext, this.gEg);
        this.aMd.add(this.gEe);
        this.gEf = new d(this.mPageContext);
        this.aMd.add(this.gEf);
    }

    public void notifyDataSetChanged() {
        if (this.gEc != null) {
            this.gEc.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.gEc.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
