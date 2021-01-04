package com.baidu.tieba.homepage.topic.topicdetail.holder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes2.dex */
public class TopicTimelineHolder<T extends View> extends RecyclerView.ViewHolder {
    private T klj;

    public TopicTimelineHolder(T t) {
        super(t);
        this.klj = t;
    }

    public T cUa() {
        return this.klj;
    }
}
