package com.baidu.tieba.hottopic.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class RelateTopicForumItemHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public BarImageView f16884a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f16885b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f16886c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f16887d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f16888e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16889f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16890g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f16891h;

    /* renamed from: i  reason: collision with root package name */
    public View f16892i;
    public int j;

    public RelateTopicForumItemHolder(View view) {
        super(view);
        this.j = 3;
        this.f16885b = (TextView) view.findViewById(R.id.forum_name);
        this.f16884a = (BarImageView) view.findViewById(R.id.forum_avatar);
        this.f16887d = (TextView) view.findViewById(R.id.member_num_label);
        this.f16886c = (TextView) view.findViewById(R.id.post_num_label);
        this.f16889f = (TextView) view.findViewById(R.id.member_num);
        this.f16888e = (TextView) view.findViewById(R.id.post_num);
        this.f16890g = (TextView) view.findViewById(R.id.forum_content);
        this.f16891h = (TextView) view.findViewById(R.id.forum_add_love);
        this.f16892i = view.findViewById(R.id.forum_item_divider);
    }
}
