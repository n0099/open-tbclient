package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.s;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ;
    private s iGb;

    public void notifyDataSetChanged() {
        if (this.iGb != null) {
            this.iGb.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<n> list) {
        this.iGb.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
