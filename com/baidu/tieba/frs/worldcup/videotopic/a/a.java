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
    l dFM;
    private m dIZ;
    private VideoTopicFragment ede;
    private b edj;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.ede = videoTopicFragment;
        this.dIZ = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.edj = new b(this.ede.getPageContext(), bb.apV, this.ede.getUniqueId());
        this.dFM = new l(this.ede.getPageContext(), com.baidu.tieba.frs.m.dEh);
        this.mAdapters.add(this.dFM);
        this.mAdapters.add(this.edj);
        this.dIZ.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.edj.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dIZ.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dIZ.getListAdapter() != null) {
            this.dIZ.getListAdapter().notifyDataSetChanged();
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
