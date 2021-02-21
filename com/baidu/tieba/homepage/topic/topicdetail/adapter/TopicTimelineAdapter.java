package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.topic.topicdetail.a.e;
import com.baidu.tieba.homepage.topic.topicdetail.holder.TopicTimelineHolder;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicTimelineCellCardView;
import java.util.List;
/* loaded from: classes2.dex */
public class TopicTimelineAdapter extends RecyclerView.Adapter<TopicTimelineHolder> {
    private List<e> koG;
    private Context mContext;

    public TopicTimelineAdapter(Context context) {
        this.mContext = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: K */
    public TopicTimelineHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new TopicTimelineHolder(new TopicTimelineCellCardView(this.mContext));
    }

    public void setData(List<e> list) {
        if (!y.isEmpty(list)) {
            this.koG = list;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(TopicTimelineHolder topicTimelineHolder, int i) {
        e eVar = (e) y.getItem(this.koG, i);
        if (eVar != null) {
            TopicTimelineCellCardView topicTimelineCellCardView = (TopicTimelineCellCardView) topicTimelineHolder.cSp();
            topicTimelineCellCardView.setData(eVar);
            topicTimelineCellCardView.onChangeSkinType();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return y.getCount(this.koG);
    }
}
