package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f17583a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17584b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17585c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17586d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17587e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17588f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17589g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17590h;

    /* renamed from: i  reason: collision with root package name */
    public View f17591i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f17584b = (TextView) view.findViewById(R.id.forum_name);
        this.f17583a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f17586d = (TextView) view.findViewById(R.id.member_num_label);
        this.f17585c = (TextView) view.findViewById(R.id.post_num_label);
        this.f17588f = (TextView) view.findViewById(R.id.member_num);
        this.f17587e = (TextView) view.findViewById(R.id.post_num);
        this.f17589g = (TextView) view.findViewById(R.id.forum_content);
        this.f17590h = (TextView) view.findViewById(R.id.forum_add_love);
        this.f17591i = view.findViewById(R.id.forum_item_divider);
    }
}
