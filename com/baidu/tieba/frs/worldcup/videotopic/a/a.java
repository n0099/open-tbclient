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
    l dEw;
    private m dHV;
    private VideoTopicFragment ebJ;
    private b ebO;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.ebJ = videoTopicFragment;
        this.dHV = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.ebO = new b(this.ebJ.getPageContext(), bb.aph, this.ebJ.getUniqueId());
        this.dEw = new l(this.ebJ.getPageContext(), com.baidu.tieba.frs.m.dCR);
        this.mAdapters.add(this.dEw);
        this.mAdapters.add(this.ebO);
        this.dHV.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.ebO.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dHV.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dHV.getListAdapter() != null) {
            this.dHV.getListAdapter().notifyDataSetChanged();
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
