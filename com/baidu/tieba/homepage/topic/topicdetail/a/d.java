package com.baidu.tieba.homepage.topic.topicdetail.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.topic.topicdetail.b.e;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicTimelineCellCardView;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends RecyclerView.Adapter<com.baidu.tieba.homepage.topic.topicdetail.c.a> {
    private List<e> jXC;
    private Context mContext;

    public d(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: F */
    public com.baidu.tieba.homepage.topic.topicdetail.c.a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new com.baidu.tieba.homepage.topic.topicdetail.c.a(new TopicTimelineCellCardView(this.mContext));
    }

    public void setData(List<e> list) {
        if (!y.isEmpty(list)) {
            this.jXC = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(com.baidu.tieba.homepage.topic.topicdetail.c.a aVar, int i) {
        e eVar = (e) y.getItem(this.jXC, i);
        if (eVar != null) {
            TopicTimelineCellCardView topicTimelineCellCardView = (TopicTimelineCellCardView) aVar.cQT();
            topicTimelineCellCardView.setData(eVar);
            topicTimelineCellCardView.onChangeSkinType();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.jXC);
    }
}
