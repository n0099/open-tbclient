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
    public TextView f15598a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15599b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15600c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15601d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15602e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15603f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15604g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15605h;
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
        this.f15598a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15599b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15603f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15603f.setIsRound(true);
        this.f15603f.setBorderColor(color);
        this.f15603f.setBorderWidth(g2);
        this.f15603f.setOnClickListener(onClickListener);
        this.f15600c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15604g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15604g.setIsRound(true);
        this.f15604g.setBorderColor(color);
        this.f15604g.setBorderWidth(g2);
        this.f15604g.setOnClickListener(onClickListener);
        this.f15601d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15605h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15605h.setIsRound(true);
        this.f15605h.setBorderColor(color);
        this.f15605h.setBorderWidth(g2);
        this.f15605h.setOnClickListener(onClickListener);
        this.f15602e = (LinearLayout) view.findViewById(R.id.member4);
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
            this.f15603f.W(str, 12, false);
            this.f15603f.setTag(bawuRoleInfoPub);
            this.f15603f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15599b.setVisibility(0);
        } else if (i == 1) {
            this.f15604g.W(str, 12, false);
            this.f15604g.setTag(bawuRoleInfoPub);
            this.f15604g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15600c.setVisibility(0);
        } else if (i == 2) {
            this.f15605h.W(str, 12, false);
            this.f15605h.setTag(bawuRoleInfoPub);
            this.f15605h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15601d.setVisibility(0);
        } else if (i != 3) {
        } else {
            this.i.W(str, 12, false);
            this.i.setTag(bawuRoleInfoPub);
            this.i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15602e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f15603f.getVisibility() == 0) {
            this.f15603f.setIsNight(z);
            this.f15603f.refresh();
        }
        if (this.f15604g.getVisibility() == 0) {
            this.f15604g.setIsNight(z);
            this.f15604g.refresh();
        }
        if (this.f15605h.getVisibility() == 0) {
            this.f15605h.setIsNight(z);
            this.f15605h.refresh();
        }
        if (this.i.getVisibility() == 0) {
            this.i.setIsNight(z);
            this.i.refresh();
        }
    }
}
