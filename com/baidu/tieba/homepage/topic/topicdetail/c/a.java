package com.baidu.tieba.homepage.topic.topicdetail.c;

import android.support.v7.widget.RecyclerView;
import android.view.View;
/* loaded from: classes9.dex */
public class a<T extends View> extends RecyclerView.ViewHolder {
    private T hRS;

    public a(T t) {
        super(t);
        this.hRS = t;
    }

    public T cak() {
        return this.hRS;
    }
}
