package com.baidu.tieba.frs.worldcup.videotopic.a;

import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.frs.f;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicFragment;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private VideoTopicFragment dGt;
    private b dGy;
    j dmH;
    private m dnw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public a(VideoTopicFragment videoTopicFragment, m mVar) {
        this.dGt = videoTopicFragment;
        this.dnw = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dGy = new b(this.dGt.getPageContext(), bd.ahX, this.dGt.getUniqueId());
        this.dmH = new j(this.dGt.getPageContext(), k.djW);
        this.mAdapters.add(this.dmH);
        this.mAdapters.add(this.dGy);
        this.dnw.addAdapters(this.mAdapters);
    }

    public void setForumId(String str) {
        this.dGy.setForumId(str);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dnw.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        if (this.dnw.getListAdapter() != null) {
            this.dnw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof f) {
                ((f) aVar).release();
            }
        }
    }
}
