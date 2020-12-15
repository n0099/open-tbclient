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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf;
    private List<q> forumList;
    private v iyv;
    private b iyw;
    private c iyx;
    private d iyy;
    private ab<BaseCardInfo> iyz = new ab<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwz = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cwz();
                            arrayList.add(qVar);
                            arrayList.addAll(cwz);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwy = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cwy();
                            arrayList.add(qVar);
                            arrayList.addAll(cwy);
                        }
                    }
                }
                e eVar = new e();
                eVar.iyV = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.iyv.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.iyv = vVar;
        Nt();
        this.iyv.addAdapters(this.bnf);
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.iyw = new b(this.mPageContext);
        this.bnf.add(this.iyw);
        this.iyx = new c(this.mPageContext, this.iyz);
        this.bnf.add(this.iyx);
        this.iyy = new d(this.mPageContext);
        this.bnf.add(this.iyy);
    }

    public void notifyDataSetChanged() {
        if (this.iyv != null) {
            this.iyv.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.iyv.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
