package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f17601a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17602b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17603c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17604d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17605e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17606f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17607g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17608h;
    public View i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f17602b = (TextView) view.findViewById(R.id.forum_name);
        this.f17601a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f17604d = (TextView) view.findViewById(R.id.member_num_label);
        this.f17603c = (TextView) view.findViewById(R.id.post_num_label);
        this.f17606f = (TextView) view.findViewById(R.id.member_num);
        this.f17605e = (TextView) view.findViewById(R.id.post_num);
        this.f17607g = (TextView) view.findViewById(R.id.forum_content);
        this.f17608h = (TextView) view.findViewById(R.id.forum_add_love);
        this.i = view.findViewById(R.id.forum_item_divider);
    }
}
