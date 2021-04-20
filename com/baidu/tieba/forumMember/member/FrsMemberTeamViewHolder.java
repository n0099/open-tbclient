package com.baidu.tieba.forumMember.member;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.R;
import d.b.c.e.p.l;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15590a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15591b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15592c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15593d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15594e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15595f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15596g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15597h;
    public HeadImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public NoPressedLinearLayout n;

    public FrsMemberTeamViewHolder(View view, View.OnClickListener onClickListener) {
        super(view);
        int g2 = l.g(BdBaseApplication.getInst().getApp(), R.dimen.ds1);
        int color = SkinManager.getColor(R.color.black_alpha10);
        TextView textView = (TextView) view.findViewById(R.id.title_text_view);
        this.f15590a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15591b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15595f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15595f.setIsRound(true);
        this.f15595f.setBorderColor(color);
        this.f15595f.setBorderWidth(g2);
        this.f15595f.setOnClickListener(onClickListener);
        this.f15592c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15596g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15596g.setIsRound(true);
        this.f15596g.setBorderColor(color);
        this.f15596g.setBorderWidth(g2);
        this.f15596g.setOnClickListener(onClickListener);
        this.f15593d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15597h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15597h.setIsRound(true);
        this.f15597h.setBorderColor(color);
        this.f15597h.setBorderWidth(g2);
        this.f15597h.setOnClickListener(onClickListener);
        this.f15594e = (LinearLayout) view.findViewById(R.id.member4);
        this.i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.i.setIsRound(true);
        this.i.setBorderColor(color);
        this.i.setBorderWidth(g2);
        this.i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        String str;
        if (bawuRoleInfoPub == null || i < 0 || i > 3) {
            return;
        }
        BaijiahaoInfo baijiahaoInfo = bawuRoleInfoPub.baijiahao_info;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            str = bawuRoleInfoPub.baijiahao_info.avatar;
        } else {
            str = bawuRoleInfoPub.portrait;
        }
        if (i == 0) {
            this.f15595f.W(str, 12, false);
            this.f15595f.setTag(bawuRoleInfoPub);
            this.f15595f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15591b.setVisibility(0);
        } else if (i == 1) {
            this.f15596g.W(str, 12, false);
            this.f15596g.setTag(bawuRoleInfoPub);
            this.f15596g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15592c.setVisibility(0);
        } else if (i == 2) {
            this.f15597h.W(str, 12, false);
            this.f15597h.setTag(bawuRoleInfoPub);
            this.f15597h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15593d.setVisibility(0);
        } else if (i != 3) {
        } else {
            this.i.W(str, 12, false);
            this.i.setTag(bawuRoleInfoPub);
            this.i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15594e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f15595f.getVisibility() == 0) {
            this.f15595f.setIsNight(z);
            this.f15595f.refresh();
        }
        if (this.f15596g.getVisibility() == 0) {
            this.f15596g.setIsNight(z);
            this.f15596g.refresh();
        }
        if (this.f15597h.getVisibility() == 0) {
            this.f15597h.setIsNight(z);
            this.f15597h.refresh();
        }
        if (this.i.getVisibility() == 0) {
            this.i.setIsNight(z);
            this.i.refresh();
        }
    }
}
