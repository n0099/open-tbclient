package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes4.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17568a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17569b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17570c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f17571d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17572e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17573f;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.f17568a = 3;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17569b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f17570c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f17571d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f17572e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f17573f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}
