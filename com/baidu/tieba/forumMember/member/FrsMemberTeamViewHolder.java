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
    public TextView f15761a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15762b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15763c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f15764d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f15765e;

    /* renamed from: f  reason: collision with root package name */
    public HeadImageView f15766f;

    /* renamed from: g  reason: collision with root package name */
    public HeadImageView f15767g;

    /* renamed from: h  reason: collision with root package name */
    public HeadImageView f15768h;

    /* renamed from: i  reason: collision with root package name */
    public HeadImageView f15769i;
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
        this.f15761a = textView;
        textView.setOnClickListener(onClickListener);
        this.f15762b = (LinearLayout) view.findViewById(R.id.member1);
        this.f15766f = (HeadImageView) view.findViewById(R.id.imageview_user_photo1);
        this.j = (TextView) view.findViewById(R.id.textview_user_name1);
        this.f15766f.setIsRound(true);
        this.f15766f.setBorderColor(color);
        this.f15766f.setBorderWidth(g2);
        this.f15766f.setOnClickListener(onClickListener);
        this.f15763c = (LinearLayout) view.findViewById(R.id.member2);
        this.f15767g = (HeadImageView) view.findViewById(R.id.imageview_user_photo2);
        this.k = (TextView) view.findViewById(R.id.textview_user_name2);
        this.f15767g.setIsRound(true);
        this.f15767g.setBorderColor(color);
        this.f15767g.setBorderWidth(g2);
        this.f15767g.setOnClickListener(onClickListener);
        this.f15764d = (LinearLayout) view.findViewById(R.id.member3);
        this.f15768h = (HeadImageView) view.findViewById(R.id.imageview_user_photo3);
        this.l = (TextView) view.findViewById(R.id.textview_user_name3);
        this.f15768h.setIsRound(true);
        this.f15768h.setBorderColor(color);
        this.f15768h.setBorderWidth(g2);
        this.f15768h.setOnClickListener(onClickListener);
        this.f15765e = (LinearLayout) view.findViewById(R.id.member4);
        this.f15769i = (HeadImageView) view.findViewById(R.id.imageview_user_photo4);
        this.m = (TextView) view.findViewById(R.id.textview_user_name4);
        this.f15769i.setIsRound(true);
        this.f15769i.setBorderColor(color);
        this.f15769i.setBorderWidth(g2);
        this.f15769i.setOnClickListener(onClickListener);
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
            this.f15766f.V(str, 12, false);
            this.f15766f.setTag(bawuRoleInfoPub);
            this.f15766f.setContentDescription(bawuRoleInfoPub.user_name);
            this.j.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15762b.setVisibility(0);
        } else if (i2 == 1) {
            this.f15767g.V(str, 12, false);
            this.f15767g.setTag(bawuRoleInfoPub);
            this.f15767g.setContentDescription(bawuRoleInfoPub.user_name);
            this.k.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15763c.setVisibility(0);
        } else if (i2 == 2) {
            this.f15768h.V(str, 12, false);
            this.f15768h.setTag(bawuRoleInfoPub);
            this.f15768h.setContentDescription(bawuRoleInfoPub.user_name);
            this.l.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15764d.setVisibility(0);
        } else if (i2 != 3) {
        } else {
            this.f15769i.V(str, 12, false);
            this.f15769i.setTag(bawuRoleInfoPub);
            this.f15769i.setContentDescription(bawuRoleInfoPub.user_name);
            this.m.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
            this.f15765e.setVisibility(0);
        }
    }

    public void c(boolean z) {
        if (this.f15766f.getVisibility() == 0) {
            this.f15766f.setIsNight(z);
            this.f15766f.refresh();
        }
        if (this.f15767g.getVisibility() == 0) {
            this.f15767g.setIsNight(z);
            this.f15767g.refresh();
        }
        if (this.f15768h.getVisibility() == 0) {
            this.f15768h.setIsNight(z);
            this.f15768h.refresh();
        }
        if (this.f15769i.getVisibility() == 0) {
            this.f15769i.setIsNight(z);
            this.f15769i.refresh();
        }
    }
}
