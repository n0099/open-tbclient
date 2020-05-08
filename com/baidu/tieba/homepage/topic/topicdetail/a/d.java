package com.baidu.tieba.homepage.topic.topicdetail.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.homepage.topic.topicdetail.b.e;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicTimelineCellCardView;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends RecyclerView.Adapter<com.baidu.tieba.homepage.topic.topicdetail.c.a> {
    private List<e> hRA;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: z */
    public com.baidu.tieba.homepage.topic.topicdetail.c.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new com.baidu.tieba.homepage.topic.topicdetail.c.a(new TopicTimelineCellCardView(this.mContext));
    }

    public void setData(List<e> list) {
        if (!v.isEmpty(list)) {
            this.hRA = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(com.baidu.tieba.homepage.topic.topicdetail.c.a aVar, int i) {
        e eVar = (e) v.getItem(this.hRA, i);
        if (eVar != null) {
            TopicTimelineCellCardView topicTimelineCellCardView = (TopicTimelineCellCardView) aVar.caj();
            topicTimelineCellCardView.setData(eVar);
            topicTimelineCellCardView.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return v.getCount(this.hRA);
    }
}
