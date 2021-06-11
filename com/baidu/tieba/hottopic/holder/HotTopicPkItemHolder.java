package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.view.HotTopicPkView;
/* loaded from: classes4.dex */
public class HotTopicPkItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public int f16869a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16870b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16871c;

    /* renamed from: d  reason: collision with root package name */
    public HotTopicPkView f16872d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16873e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16874f;

    public HotTopicPkItemHolder(View view) {
        super(view);
        this.f16869a = 3;
        b(view);
    }

    public final void b(View view) {
        if (view == null) {
            return;
        }
        this.f16870b = (TextView) view.findViewById(R.id.pk_item_theme_title);
        this.f16871c = (TextView) view.findViewById(R.id.pk_topic_title);
        this.f16872d = (HotTopicPkView) view.findViewById(R.id.pk_topic_view);
        this.f16873e = (TextView) view.findViewById(R.id.pk_topic_positive);
        this.f16874f = (TextView) view.findViewById(R.id.pk_topic_opposing);
    }
}
