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
    l dPJ;
    private m dTa;
    private VideoTopicFragment enf;
    private b enk;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.enf = videoTopicFragment;
        this.dTa = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.enk = new b(this.enf.getPageContext(), bb.atY, this.enf.getUniqueId());
        this.dPJ = new l(this.enf.getPageContext(), com.baidu.tieba.frs.m.dOe);
        this.mAdapters.add(this.dPJ);
        this.mAdapters.add(this.enk);
        this.dTa.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.enk.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dTa.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dTa.getListAdapter() != null) {
            this.dTa.getListAdapter().notifyDataSetChanged();
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
