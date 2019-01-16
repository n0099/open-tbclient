package com.baidu.tieba.frs.worldcup.videotopic.a;

import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    l dPI;
    private m dSZ;
    private VideoTopicFragment ene;
    private b enj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.ene = videoTopicFragment;
        this.dSZ = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.enj = new b(this.ene.getPageContext(), bb.atX, this.ene.getUniqueId());
        this.dPI = new l(this.ene.getPageContext(), com.baidu.tieba.frs.m.dOd);
        this.mAdapters.add(this.dPI);
        this.mAdapters.add(this.enj);
        this.dSZ.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.enj.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dSZ.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dSZ.getListAdapter() != null) {
            this.dSZ.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }
}
