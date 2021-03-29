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
    public TextView f15921a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15922b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15923c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15924d;

    /* renamed from: e  reason: collision with root package name */
    public View f15925e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f15926f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15927g;

    /* renamed from: h  reason: collision with root package name */
    public NoPressedLinearLayout f15928h;
    public View i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.f15921a = (TextView) view.findViewById(R.id.like_btn);
        this.f15922b = (TextView) view.findViewById(R.id.lever_tip_view);
        this.f15923c = (ImageView) view.findViewById(R.id.header_level_img);
        this.f15924d = (TextView) view.findViewById(R.id.user_level_name);
        this.f15925e = view.findViewById(R.id.header_divider_line2);
        this.f15926f = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.f15927g = (TextView) view.findViewById(R.id.tip_experience_score);
        this.f15928h = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.i = view.findViewById(R.id.header_divider_line3);
        this.j = (TextView) view.findViewById(R.id.tip_experience);
        this.k = (ImageView) view.findViewById(R.id.love_level_top);
        this.l = (ImageView) view.findViewById(R.id.love_level_bg);
        this.f15921a.setOnClickListener(onClickListener);
        this.f15924d.setOnClickListener(onClickListener);
    }
}
