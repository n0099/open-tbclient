package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP;
    private v hfK;

    public void notifyDataSetChanged() {
        if (this.hfK != null) {
            this.hfK.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.hfK.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
