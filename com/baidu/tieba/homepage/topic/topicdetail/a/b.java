package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aSj;
    private t gTb;
    private c igU;
    private a igV;
    private com.baidu.tieba.homepage.topic.topictab.a.c igW;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, t tVar) {
        this.mPageContext = tbPageContext;
        this.gTb = tVar;
        CY();
        this.gTb.addAdapters(this.aSj);
    }

    private void CY() {
        this.aSj = new ArrayList();
        this.igU = new c(this.mPageContext);
        this.igV = new a(this.mPageContext);
        this.igW = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.aSj.add(this.igU);
        this.aSj.add(this.igV);
        this.aSj.add(this.igW);
    }

    public void notifyDataSetChanged() {
        if (this.gTb != null) {
            this.gTb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<o> list) {
        this.gTb.setData(list);
    }
}
