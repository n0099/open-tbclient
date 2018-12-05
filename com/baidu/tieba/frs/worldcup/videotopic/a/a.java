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
    l dMl;
    private m dPC;
    private VideoTopicFragment ejH;
    private b ejM;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.ejH = videoTopicFragment;
        this.dPC = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.ejM = new b(this.ejH.getPageContext(), bb.atv, this.ejH.getUniqueId());
        this.dMl = new l(this.ejH.getPageContext(), com.baidu.tieba.frs.m.dKG);
        this.mAdapters.add(this.dMl);
        this.mAdapters.add(this.ejM);
        this.dPC.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.ejM.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dPC.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dPC.getListAdapter() != null) {
            this.dPC.getListAdapter().notifyDataSetChanged();
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
