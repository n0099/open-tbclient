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
    private b dMD;
    private VideoTopicFragment dMy;
    l dqh;
    private m dtp;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.dMy = videoTopicFragment;
        this.dtp = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dMD = new b(this.dMy.getPageContext(), bb.ahM, this.dMy.getUniqueId());
        this.dqh = new l(this.dMy.getPageContext(), com.baidu.tieba.frs.m.doT);
        this.mAdapters.add(this.dqh);
        this.mAdapters.add(this.dMD);
        this.dtp.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.dMD.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dtp.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dtp.getListAdapter() != null) {
            this.dtp.getListAdapter().notifyDataSetChanged();
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
