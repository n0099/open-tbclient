package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky;
    private List<q> forumList;
    private v imM;
    private b imN;
    private c imO;
    private d imP;
    private ab<com.baidu.tieba.card.data.b> imQ = new ab<com.baidu.tieba.card.data.b>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, com.baidu.tieba.card.data.b bVar) {
            if (bVar != null && (bVar instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) bVar).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> csG = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).csG();
                            arrayList.add(qVar);
                            arrayList.addAll(csG);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> csF = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).csF();
                            arrayList.add(qVar);
                            arrayList.addAll(csF);
                        }
                    }
                }
                e eVar = new e();
                eVar.inm = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.imM.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.imM = vVar;
        LY();
        this.imM.addAdapters(this.bky);
    }

    private void LY() {
        this.bky = new ArrayList();
        this.imN = new b(this.mPageContext);
        this.bky.add(this.imN);
        this.imO = new c(this.mPageContext, this.imQ);
        this.bky.add(this.imO);
        this.imP = new d(this.mPageContext);
        this.bky.add(this.imP);
    }

    public void notifyDataSetChanged() {
        if (this.imM != null) {
            this.imM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.imM.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
