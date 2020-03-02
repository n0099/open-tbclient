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
    private List<com.baidu.adp.widget.ListView.a> asE;
    private r fWD;
    private b fWE;
    private c fWF;
    private d fWG;
    private z<com.baidu.tieba.card.data.b> fWH = new z<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.z
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (m mVar : a.this.forumList) {
                    if (mVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) mVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> byZ = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).byZ();
                            arrayList.add(mVar);
                            arrayList.addAll(byZ);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> byY = ((com.baidu.tieba.enterForum.recommend.b.d) mVar).byY();
                            arrayList.add(mVar);
                            arrayList.addAll(byY);
                        }
                    }
                }
                e eVar = new e();
                eVar.fXd = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.fWD.setData(arrayList);
                }
            }
        }
    };
    private List<m> forumList;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.fWD = rVar;
        wM();
        this.fWD.addAdapters(this.asE);
    }

    private void wM() {
        this.asE = new ArrayList();
        this.fWE = new b(this.mPageContext);
        this.asE.add(this.fWE);
        this.fWF = new c(this.mPageContext, this.fWH);
        this.asE.add(this.fWF);
        this.fWG = new d(this.mPageContext);
        this.asE.add(this.fWG);
    }

    public void notifyDataSetChanged() {
        if (this.fWD != null) {
            this.fWD.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.forumList = list;
        this.fWD.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
