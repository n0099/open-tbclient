package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsMemberHeaderViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15590a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15591b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15592c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15593d;

    /* renamed from: e  reason: collision with root package name */
    public View f15594e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f15595f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15596g;

    /* renamed from: h  reason: collision with root package name */
    public NoPressedLinearLayout f15597h;
    public View i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.f15590a = (TextView) view.findViewById(R.id.like_btn);
        this.f15591b = (TextView) view.findViewById(R.id.lever_tip_view);
        this.f15592c = (ImageView) view.findViewById(R.id.header_level_img);
        this.f15593d = (TextView) view.findViewById(R.id.user_level_name);
        this.f15594e = view.findViewById(R.id.header_divider_line2);
        this.f15595f = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.f15596g = (TextView) view.findViewById(R.id.tip_experience_score);
        this.f15597h = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.i = view.findViewById(R.id.header_divider_line3);
        this.j = (TextView) view.findViewById(R.id.tip_experience);
        this.k = (ImageView) view.findViewById(R.id.love_level_top);
        this.l = (ImageView) view.findViewById(R.id.love_level_bg);
        this.f15590a.setOnClickListener(onClickListener);
        this.f15593d.setOnClickListener(onClickListener);
    }
}
