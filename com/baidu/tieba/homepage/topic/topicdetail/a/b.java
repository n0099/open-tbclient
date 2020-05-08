package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aMj;
    private r gEi;
    private c hRx;
    private a hRy;
    private com.baidu.tieba.homepage.topic.topictab.a.c hRz;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, r rVar) {
        this.mPageContext = tbPageContext;
        this.gEi = rVar;
        BB();
        this.gEi.addAdapters(this.aMj);
    }

    private void BB() {
        this.aMj = new ArrayList();
        this.hRx = new c(this.mPageContext);
        this.hRy = new a(this.mPageContext);
        this.hRz = new com.baidu.tieba.homepage.topic.topictab.a.c(this.mPageContext);
        this.aMj.add(this.hRx);
        this.aMj.add(this.hRy);
        this.aMj.add(this.hRz);
    }

    public void notifyDataSetChanged() {
        if (this.gEi != null) {
            this.gEi.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<m> list) {
        this.gEi.setData(list);
    }
}
