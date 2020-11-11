package com.baidu.tieba.homepage.topic.topictab.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.v;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky;
    private v imM;

    public void notifyDataSetChanged() {
        if (this.imM != null) {
            this.imM.getListAdapter().notifyDataSetChanged();
        }
    }

    public void setData(List<q> list) {
        this.imM.setData(list);
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            aVar.setPageId(bdUniqueId);
        }
    }
}
