package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes4.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public GodHeadImageView f15738a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15739b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15740c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15741d;

    /* renamed from: e  reason: collision with root package name */
    public View f15742e;

    /* renamed from: f  reason: collision with root package name */
    public int f15743f;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.f15743f = 3;
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.f15738a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.f15738a.setShowType(1);
        this.f15738a.setRadius(14);
        this.f15739b = (TextView) view.findViewById(R.id.item_manito_name);
        this.f15740c = (TextView) view.findViewById(R.id.item_manito_intro);
        this.f15741d = (TextView) view.findViewById(R.id.item_manito_fans);
        this.f15742e = view.findViewById(R.id.divider_line);
    }
}
