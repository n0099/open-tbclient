package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f17279a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17280b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17281c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17282d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17283e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17284f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17285g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17286h;
    public View i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f17280b = (TextView) view.findViewById(R.id.forum_name);
        this.f17279a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f17282d = (TextView) view.findViewById(R.id.member_num_label);
        this.f17281c = (TextView) view.findViewById(R.id.post_num_label);
        this.f17284f = (TextView) view.findViewById(R.id.member_num);
        this.f17283e = (TextView) view.findViewById(R.id.post_num);
        this.f17285g = (TextView) view.findViewById(R.id.forum_content);
        this.f17286h = (TextView) view.findViewById(R.id.forum_add_love);
        this.i = view.findViewById(R.id.forum_item_divider);
    }
}
