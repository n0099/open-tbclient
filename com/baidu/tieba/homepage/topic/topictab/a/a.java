package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM;
    private s iKI;

    public void notifyDataSetChanged() {
        if (this.iKI != null) {
            this.iKI.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iKI.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.boM) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
