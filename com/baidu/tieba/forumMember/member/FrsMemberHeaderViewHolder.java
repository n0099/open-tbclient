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
    public TextView f15067a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15068b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15069c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15070d;

    /* renamed from: e  reason: collision with root package name */
    public View f15071e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f15072f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15073g;

    /* renamed from: h  reason: collision with root package name */
    public NoPressedLinearLayout f15074h;

    /* renamed from: i  reason: collision with root package name */
    public View f15075i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.f15067a = (TextView) view.findViewById(R.id.like_btn);
        this.f15068b = (TextView) view.findViewById(R.id.lever_tip_view);
        this.f15069c = (ImageView) view.findViewById(R.id.header_level_img);
        this.f15070d = (TextView) view.findViewById(R.id.user_level_name);
        this.f15071e = view.findViewById(R.id.header_divider_line2);
        this.f15072f = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.f15073g = (TextView) view.findViewById(R.id.tip_experience_score);
        this.f15074h = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.f15075i = view.findViewById(R.id.header_divider_line3);
        this.j = (TextView) view.findViewById(R.id.tip_experience);
        this.k = (ImageView) view.findViewById(R.id.love_level_top);
        this.l = (ImageView) view.findViewById(R.id.love_level_bg);
        this.f15067a.setOnClickListener(onClickListener);
        this.f15070d.setOnClickListener(onClickListener);
    }
}
