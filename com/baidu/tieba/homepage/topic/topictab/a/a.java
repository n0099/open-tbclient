package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH;
    private v hUo;

    public void notifyDataSetChanged() {
        if (this.hUo != null) {
            this.hUo.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hUo.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
