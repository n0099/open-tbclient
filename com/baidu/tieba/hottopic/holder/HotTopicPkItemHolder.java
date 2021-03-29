package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes3.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f17588a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17589b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17590c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f17591d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17592e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17593f;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.f17588a = 3;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f17589b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f17590c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f17591d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f17592e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f17593f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}
