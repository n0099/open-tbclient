package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f17287a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f17288b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f17289c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f17290d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f17291e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f17292f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f17293g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f17294h;
    public View i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f17288b = (TextView) view.findViewById(R.id.forum_name);
        this.f17287a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f17290d = (TextView) view.findViewById(R.id.member_num_label);
        this.f17289c = (TextView) view.findViewById(R.id.post_num_label);
        this.f17292f = (TextView) view.findViewById(R.id.member_num);
        this.f17291e = (TextView) view.findViewById(R.id.post_num);
        this.f17293g = (TextView) view.findViewById(R.id.forum_content);
        this.f17294h = (TextView) view.findViewById(R.id.forum_add_love);
        this.i = view.findViewById(R.id.forum_item_divider);
    }
}
