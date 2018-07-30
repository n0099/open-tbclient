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
    private VideoTopicFragment dMC;
    private b dMH;
    l dqj;
    private m dts;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.dMC = videoTopicFragment;
        this.dts = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dMH = new b(this.dMC.getPageContext(), bb.ahM, this.dMC.getUniqueId());
        this.dqj = new l(this.dMC.getPageContext(), com.baidu.tieba.frs.m.doV);
        this.mAdapters.add(this.dqj);
        this.mAdapters.add(this.dMH);
        this.dts.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.dMH.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dts.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dts.getListAdapter() != null) {
            this.dts.getListAdapter().notifyDataSetChanged();
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
