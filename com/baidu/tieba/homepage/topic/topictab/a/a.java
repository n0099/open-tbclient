package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje;
    private v igO;

    public void notifyDataSetChanged() {
        if (this.igO != null) {
            this.igO.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.igO.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
