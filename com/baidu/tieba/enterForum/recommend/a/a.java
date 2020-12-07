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
    private v iyt;
    private b iyu;
    private c iyv;
    private d iyw;
    private ab<BaseCardInfo> iyx = new ab<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.ab
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (q qVar : a.this.forumList) {
                    if (qVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) qVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwy = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cwy();
                            arrayList.add(qVar);
                            arrayList.addAll(cwy);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cwx = ((com.baidu.tieba.enterForum.recommend.b.d) qVar).cwx();
                            arrayList.add(qVar);
                            arrayList.addAll(cwx);
                        }
                    }
                }
                e eVar = new e();
                eVar.iyT = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.iyt.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.iyt = vVar;
        Nt();
        this.iyt.addAdapters(this.bnf);
    }

    private void Nt() {
        this.bnf = new ArrayList();
        this.iyu = new b(this.mPageContext);
        this.bnf.add(this.iyu);
        this.iyv = new c(this.mPageContext, this.iyx);
        this.bnf.add(this.iyv);
        this.iyw = new d(this.mPageContext);
        this.bnf.add(this.iyw);
    }

    public void notifyDataSetChanged() {
        if (this.iyt != null) {
            this.iyt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.forumList = list;
        this.iyt.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
