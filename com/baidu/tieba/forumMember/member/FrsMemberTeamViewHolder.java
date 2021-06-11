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
    public TextView f15036a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15037b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15038c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15039d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15040e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15041f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15042g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15043h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f15044i;
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
        this.f15036a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15037b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15041f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15041f.setIsRound(true);
        this.f15041f.setBorderColor(color);
        this.f15041f.setBorderWidth(g2);
        this.f15041f.setOnClickListener(onClickListener);
        this.f15038c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15042g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15042g.setIsRound(true);
        this.f15042g.setBorderColor(color);
        this.f15042g.setBorderWidth(g2);
        this.f15042g.setOnClickListener(onClickListener);
        this.f15039d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15043h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15043h.setIsRound(true);
        this.f15043h.setBorderColor(color);
        this.f15043h.setBorderWidth(g2);
        this.f15043h.setOnClickListener(onClickListener);
        this.f15040e = (LinearLayout) view.findViewById(R.id.member4);
        this.f15044i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.f15044i.setIsRound(true);
        this.f15044i.setBorderColor(color);
        this.f15044i.setBorderWidth(g2);
        this.f15044i.setOnClickListener(onClickListener);
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
            this.f15041f.U(str, 12, false);
            this.f15041f.setTag(bawuRoleInfoPub);
            this.f15041f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15037b.setVisibility(0);
        } else if (i2 == 1) {
            this.f15042g.U(str, 12, false);
            this.f15042g.setTag(bawuRoleInfoPub);
            this.f15042g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15038c.setVisibility(0);
        } else if (i2 == 2) {
            this.f15043h.U(str, 12, false);
            this.f15043h.setTag(bawuRoleInfoPub);
            this.f15043h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15039d.setVisibility(0);
        } else if (i2 != 3) {
        } else {
            this.f15044i.U(str, 12, false);
            this.f15044i.setTag(bawuRoleInfoPub);
            this.f15044i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15040e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f15041f.getVisibility() == 0) {
            this.f15041f.setIsNight(z);
            this.f15041f.refresh();
        }
        if (this.f15042g.getVisibility() == 0) {
            this.f15042g.setIsNight(z);
            this.f15042g.refresh();
        }
        if (this.f15043h.getVisibility() == 0) {
            this.f15043h.setIsNight(z);
            this.f15043h.refresh();
        }
        if (this.f15044i.getVisibility() == 0) {
            this.f15044i.setIsNight(z);
            this.f15044i.refresh();
        }
    }
}
