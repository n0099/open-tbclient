package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes4.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17265a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17266b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17267c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f17268d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17269e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17270f;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.f17265a = 3;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17266b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f17267c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f17268d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f17269e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f17270f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}
