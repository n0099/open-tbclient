package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes4.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f16951a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16952b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16953c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f16954d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16955e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16956f;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.f16951a = 3;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16952b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f16953c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f16954d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f16955e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f16956f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}
