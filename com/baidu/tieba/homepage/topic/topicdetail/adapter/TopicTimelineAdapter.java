package com.baidu.tieba.homepage.topic.topicdetail.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.homepage.topic.topicdetail.holder.TopicTimelineHolder;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicTimelineCellCardView;
import d.a.j0.a1.j.a.c.e;
import java.util.List;
/* loaded from: classes4.dex */
public class TopicTimelineAdapter extends RecyclerView.Adapter<TopicTimelineHolder> {

    /* renamed from: a  reason: collision with root package name */
    public Context f17339a;

    /* renamed from: b  reason: collision with root package name */
    public List<e> f17340b;

    public TopicTimelineAdapter(Context context) {
        this.f17339a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(TopicTimelineHolder topicTimelineHolder, int i2) {
        e eVar = (e) ListUtils.getItem(this.f17340b, i2);
        if (eVar == null) {
            return;
        }
        TopicTimelineCellCardView topicTimelineCellCardView = (TopicTimelineCellCardView) topicTimelineHolder.a();
        topicTimelineCellCardView.setData(eVar);
        topicTimelineCellCardView.b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public TopicTimelineHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new TopicTimelineHolder(new TopicTimelineCellCardView(this.f17339a));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return ListUtils.getCount(this.f17340b);
    }

    public void setData(List<e> list) {
        if (ListUtils.isEmpty(list)) {
            return;
        }
        this.f17340b = list;
    }
}
