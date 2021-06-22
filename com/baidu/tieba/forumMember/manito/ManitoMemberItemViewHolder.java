package com.baidu.tieba.forumMember.manito;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.R;
import com.baidu.tieba.forumMember.view.GodHeadImageView;
/* loaded from: classes4.dex */
public class ManitoMemberItemViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public GodHeadImageView f15095a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15096b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f15097c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15098d;

    /* renamed from: e  reason: collision with root package name */
    public View f15099e;

    /* renamed from: f  reason: collision with root package name */
    public int f15100f;

    public ManitoMemberItemViewHolder(View view) {
        super(view);
        this.f15100f = 3;
        GodHeadImageView godHeadImageView = (GodHeadImageView) view.findViewById(R.id.item_head);
        this.f15095a = godHeadImageView;
        godHeadImageView.setShapeType(0);
        this.f15095a.setShowType(1);
        this.f15095a.setRadius(14);
        this.f15096b = (TextView) view.findViewById(R.id.item_manito_name);
        this.f15097c = (TextView) view.findViewById(R.id.item_manito_intro);
        this.f15098d = (TextView) view.findViewById(R.id.item_manito_fans);
        this.f15099e = view.findViewById(R.id.divider_line);
    }
}
