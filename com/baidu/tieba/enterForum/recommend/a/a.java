package com.baidu.tieba.enterForum.recommend.a;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.aa;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.enterForum.recommend.b.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private List<n> forumList;
    private s iGb;
    private b iGc;
    private c iGd;
    private d iGe;
    private aa<BaseCardInfo> iGf = new aa<BaseCardInfo>() { // from class: com.baidu.tieba.enterForum.recommend.a.a.1
        @Override // com.baidu.tieba.card.aa
        public void a(View view, BaseCardInfo baseCardInfo) {
            if (baseCardInfo != null && (baseCardInfo instanceof com.baidu.tieba.enterForum.recommend.b.d)) {
                ArrayList arrayList = new ArrayList();
                String title = ((com.baidu.tieba.enterForum.recommend.b.d) baseCardInfo).getTitle();
                for (n nVar : a.this.forumList) {
                    if (nVar instanceof com.baidu.tieba.enterForum.recommend.b.d) {
                        if (title.equals(((com.baidu.tieba.enterForum.recommend.b.d) nVar).getTitle())) {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cvB = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cvB();
                            arrayList.add(nVar);
                            arrayList.addAll(cvB);
                        } else {
                            List<com.baidu.tieba.enterForum.recommend.b.c> cvA = ((com.baidu.tieba.enterForum.recommend.b.d) nVar).cvA();
                            arrayList.add(nVar);
                            arrayList.addAll(cvA);
                        }
                    }
                }
                e eVar = new e();
                eVar.iGB = TbadkCoreApplication.getInst().getMainTabBottomBarHeightId();
                arrayList.add(eVar);
                if (arrayList.size() > 0) {
                    a.this.iGb.setData(arrayList);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext, s sVar) {
        this.mPageContext = tbPageContext;
        this.iGb = sVar;
        IY();
        this.iGb.addAdapters(this.bjZ);
    }

    private void IY() {
        this.bjZ = new ArrayList();
        this.iGc = new b(this.mPageContext);
        this.bjZ.add(this.iGc);
        this.iGd = new c(this.mPageContext, this.iGf);
        this.bjZ.add(this.iGd);
        this.iGe = new d(this.mPageContext);
        this.bjZ.add(this.iGe);
    }

    public void notifyDataSetChanged() {
        if (this.iGb != null) {
            this.iGb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.forumList = list;
        this.iGb.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
