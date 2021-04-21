package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes4.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17273a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17274b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17275c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f17276d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17277e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17278f;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.f17273a = 3;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17274b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f17275c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f17276d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f17277e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f17278f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}
