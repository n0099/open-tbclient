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
import d.a.c.e.p.l;
import tbclient.BaijiahaoInfo;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes4.dex */
public class FrsMemberTeamViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public TextView f14979a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f14980b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f14981c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f14982d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f14983e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f14984f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f14985g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f14986h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f14987i;
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
        this.f14979a = textView;
        textView.setOnClickListener(onClickListener);
        this.f14980b = (LinearLayout) view.findViewById(R.id.member1);
        this.f14984f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f14984f.setIsRound(true);
        this.f14984f.setBorderColor(color);
        this.f14984f.setBorderWidth(g2);
        this.f14984f.setOnClickListener(onClickListener);
        this.f14981c = (LinearLayout) view.findViewById(R.id.member2);
        this.f14985g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f14985g.setIsRound(true);
        this.f14985g.setBorderColor(color);
        this.f14985g.setBorderWidth(g2);
        this.f14985g.setOnClickListener(onClickListener);
        this.f14982d = (LinearLayout) view.findViewById(R.id.member3);
        this.f14986h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f14986h.setIsRound(true);
        this.f14986h.setBorderColor(color);
        this.f14986h.setBorderWidth(g2);
        this.f14986h.setOnClickListener(onClickListener);
        this.f14983e = (LinearLayout) view.findViewById(R.id.member4);
        this.f14987i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.f14987i.setIsRound(true);
        this.f14987i.setBorderColor(color);
        this.f14987i.setBorderWidth(g2);
        this.f14987i.setOnClickListener(onClickListener);
        this.n = (NoPressedLinearLayout) view.findViewById(R.id.forum_member_team_item_view);
    }

    public void b(BawuRoleInfoPub bawuRoleInfoPub, int i2) {
        String str;
        if (bawuRoleInfoPub == null || i2 < 0 || i2 > 3) {
            return;
        }
        BaijiahaoInfo baijiahaoInfo = bawuRoleInfoPub.baijiahao_info;
        if (baijiahaoInfo != null && !TextUtils.isEmpty(baijiahaoInfo.avatar)) {
            str = bawuRoleInfoPub.baijiahao_info.avatar;
        } else {
            str = bawuRoleInfoPub.portrait;
        }
        if (i2 == 0) {
            this.f14984f.V(str, 12, false);
            this.f14984f.setTag(bawuRoleInfoPub);
            this.f14984f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f14980b.setVisibility(0);
        } else if (i2 == 1) {
            this.f14985g.V(str, 12, false);
            this.f14985g.setTag(bawuRoleInfoPub);
            this.f14985g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f14981c.setVisibility(0);
        } else if (i2 == 2) {
            this.f14986h.V(str, 12, false);
            this.f14986h.setTag(bawuRoleInfoPub);
            this.f14986h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f14982d.setVisibility(0);
        } else if (i2 != 3) {
        } else {
            this.f14987i.V(str, 12, false);
            this.f14987i.setTag(bawuRoleInfoPub);
            this.f14987i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f14983e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f14984f.getVisibility() == 0) {
            this.f14984f.setIsNight(z);
            this.f14984f.refresh();
        }
        if (this.f14985g.getVisibility() == 0) {
            this.f14985g.setIsNight(z);
            this.f14985g.refresh();
        }
        if (this.f14986h.getVisibility() == 0) {
            this.f14986h.setIsNight(z);
            this.f14986h.refresh();
        }
        if (this.f14987i.getVisibility() == 0) {
            this.f14987i.setIsNight(z);
            this.f14987i.refresh();
        }
    }
}
