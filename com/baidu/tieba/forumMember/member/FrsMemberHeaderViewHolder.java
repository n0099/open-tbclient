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
    public TextView f14970a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f14971b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f14972c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f14973d;

    /* renamed from: e  reason: collision with root package name */
    public View f14974e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f14975f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f14976g;

    /* renamed from: h  reason: collision with root package name */
    public NoPressedLinearLayout f14977h;

    /* renamed from: i  reason: collision with root package name */
    public View f14978i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.f14970a = (TextView) view.findViewById(R.id.like_btn);
        this.f14971b = (TextView) view.findViewById(R.id.lever_tip_view);
        this.f14972c = (ImageView) view.findViewById(R.id.header_level_img);
        this.f14973d = (TextView) view.findViewById(R.id.user_level_name);
        this.f14974e = view.findViewById(R.id.header_divider_line2);
        this.f14975f = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.f14976g = (TextView) view.findViewById(R.id.tip_experience_score);
        this.f14977h = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.f14978i = view.findViewById(R.id.header_divider_line3);
        this.j = (TextView) view.findViewById(R.id.tip_experience);
        this.k = (ImageView) view.findViewById(R.id.love_level_top);
        this.l = (ImageView) view.findViewById(R.id.love_level_bg);
        this.f14970a.setOnClickListener(onClickListener);
        this.f14973d.setOnClickListener(onClickListener);
    }
}
