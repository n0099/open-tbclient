package com.baidu.tieba.frs.worldcup.videotopic.a;

import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private VideoTopicFragment dJM;
    private b dJR;
    l dnp;
    private m dqF;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.dJM = videoTopicFragment;
        this.dqF = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dJR = new b(this.dJM.getPageContext(), bc.aiq, this.dJM.getUniqueId());
        this.dnp = new l(this.dJM.getPageContext(), com.baidu.tieba.frs.m.dmd);
        this.mAdapters.add(this.dnp);
        this.mAdapters.add(this.dJR);
        this.dqF.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.dJR.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dqF.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dqF.getListAdapter() != null) {
            this.dqF.getListAdapter().notifyDataSetChanged();
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
