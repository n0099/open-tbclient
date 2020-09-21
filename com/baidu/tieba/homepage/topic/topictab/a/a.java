package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV;
    private v hFt;

    public void notifyDataSetChanged() {
        if (this.hFt != null) {
            this.hFt.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hFt.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
