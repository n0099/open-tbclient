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
    private VideoTopicFragment dTQ;
    private b dTV;
    l dwv;
    private m dzV;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.dTQ = videoTopicFragment;
        this.dzV = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dTV = new b(this.dTQ.getPageContext(), bb.akm, this.dTQ.getUniqueId());
        this.dwv = new l(this.dTQ.getPageContext(), com.baidu.tieba.frs.m.duQ);
        this.mAdapters.add(this.dwv);
        this.mAdapters.add(this.dTV);
        this.dzV.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.dTV.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dzV.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dzV.getListAdapter() != null) {
            this.dzV.getListAdapter().notifyDataSetChanged();
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
