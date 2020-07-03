package com.baidu.tieba.homepage.topic.topicdetail.a;

import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b {
    private List<com.baidu.adp.widget.ListView.a> aUP;
    private v hfK;
    private c ixZ;
    private a iya;
    private com.baidu.tieba.homepage.topic.topictab.a.b iyb;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, v vVar) {
        this.mPageContext = tbPageContext;
        this.hfK = vVar;
        Dz();
        this.hfK.addAdapters(this.aUP);
    }

    private void Dz() {
        this.aUP = new ArrayList();
        this.ixZ = new c(this.mPageContext);
        this.iya = new a(this.mPageContext);
        this.iyb = new com.baidu.tieba.homepage.topic.topictab.a.b(this.mPageContext);
        this.aUP.add(this.ixZ);
        this.aUP.add(this.iya);
        this.aUP.add(this.iyb);
    }

    public void notifyDataSetChanged() {
        if (this.hfK != null) {
            this.hfK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hfK.setData(list);
    }
}
