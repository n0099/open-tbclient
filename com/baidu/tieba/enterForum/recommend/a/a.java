package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj;
    private List<o> forumList;
    private t gTb;
    private b gTc;
    private c gTd;
    private d gTe;
    private aa<com.baidu.tieba.card.data.b> gTf = new aa<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (o oVar : a.this.forumList) {
                    if (oVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) oVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bPC = ((com.baidu.tieba.enterForum.recommend.b.d) oVar).bPC();
                            arrayList.add(oVar);
                            arrayList.addAll(bPC);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> bPB = ((com.baidu.tieba.enterForum.recommend.b.d) oVar).bPB();
                            arrayList.add(oVar);
                            arrayList.addAll(bPB);
                        }
                    }
                }
                e eVar = new e();
                eVar.gTB = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.gTb.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, t tVar) {
        this.mPageContext = tbPageContext;
        this.gTb = tVar;
        CY();
        this.gTb.addAdapters(this.aSj);
    }

    private void CY() {
        this.aSj = new ArrayList();
        this.gTc = new b(this.mPageContext);
        this.aSj.add(this.gTc);
        this.gTd = new c(this.mPageContext, this.gTf);
        this.aSj.add(this.gTd);
        this.gTe = new d(this.mPageContext);
        this.aSj.add(this.gTe);
    }

    public void notifyDataSetChanged() {
        if (this.gTb != null) {
            this.gTb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<o> list) {
        this.forumList = list;
        this.gTb.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aSj) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
