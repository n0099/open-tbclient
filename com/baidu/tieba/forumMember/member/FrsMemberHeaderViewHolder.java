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
    public TextView f15752a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f15753b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f15754c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f15755d;

    /* renamed from: e  reason: collision with root package name */
    public View f15756e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f15757f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15758g;

    /* renamed from: h  reason: collision with root package name */
    public NoPressedLinearLayout f15759h;

    /* renamed from: i  reason: collision with root package name */
    public View f15760i;
    public TextView j;
    public ImageView k;
    public ImageView l;

    public FrsMemberHeaderViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        this.f15752a = (TextView) view.findViewById(R.id.like_btn);
        this.f15753b = (TextView) view.findViewById(R.id.lever_tip_view);
        this.f15754c = (ImageView) view.findViewById(R.id.header_level_img);
        this.f15755d = (TextView) view.findViewById(R.id.user_level_name);
        this.f15756e = view.findViewById(R.id.header_divider_line2);
        this.f15757f = (LinearLayout) view.findViewById(R.id.view_experience_score);
        this.f15758g = (TextView) view.findViewById(R.id.tip_experience_score);
        this.f15759h = (NoPressedLinearLayout) view.findViewById(R.id.root_forum_member_header);
        this.f15760i = view.findViewById(R.id.header_divider_line3);
        this.j = (TextView) view.findViewById(R.id.tip_experience);
        this.k = (ImageView) view.findViewById(R.id.love_level_top);
        this.l = (ImageView) view.findViewById(R.id.love_level_bg);
        this.f15752a.setOnClickListener(onClickListener);
        this.f15755d.setOnClickListener(onClickListener);
    }
}
