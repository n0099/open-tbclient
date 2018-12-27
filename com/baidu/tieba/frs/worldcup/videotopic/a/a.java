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
    l dOZ;
    private m dSq;
    private b emC;
    private VideoTopicFragment emx;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.emx = videoTopicFragment;
        this.dSq = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.emC = new b(this.emx.getPageContext(), bb.atv, this.emx.getUniqueId());
        this.dOZ = new l(this.emx.getPageContext(), com.baidu.tieba.frs.m.dNu);
        this.mAdapters.add(this.dOZ);
        this.mAdapters.add(this.emC);
        this.dSq.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.emC.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dSq.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dSq.getListAdapter() != null) {
            this.dSq.getListAdapter().notifyDataSetChanged();
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
