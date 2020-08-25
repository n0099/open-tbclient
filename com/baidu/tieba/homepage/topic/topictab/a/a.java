package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu;
    private v hyl;

    public void notifyDataSetChanged() {
        if (this.hyl != null) {
            this.hyl.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hyl.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
