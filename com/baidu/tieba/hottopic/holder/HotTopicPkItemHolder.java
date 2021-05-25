package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes4.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f16793a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16794b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16795c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f16796d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16797e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16798f;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.f16793a = 3;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16794b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f16795c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f16796d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f16797e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f16798f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}
