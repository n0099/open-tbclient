package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f16966a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16967b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16968c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16969d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16970e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16971f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16972g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16973h;

    /* renamed from: i  reason: collision with root package name */
    public View f16974i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f16967b = (TextView) view.findViewById(R.id.forum_name);
        this.f16966a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f16969d = (TextView) view.findViewById(R.id.member_num_label);
        this.f16968c = (TextView) view.findViewById(R.id.post_num_label);
        this.f16971f = (TextView) view.findViewById(R.id.member_num);
        this.f16970e = (TextView) view.findViewById(R.id.post_num);
        this.f16972g = (TextView) view.findViewById(R.id.forum_content);
        this.f16973h = (TextView) view.findViewById(R.id.forum_add_love);
        this.f16974i = view.findViewById(R.id.forum_item_divider);
    }
}
